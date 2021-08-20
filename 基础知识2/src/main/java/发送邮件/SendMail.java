package 发送邮件;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
/**
 * @Description:
 * @author: LinQin
 * @date: 2018/11/12
 */
public class SendMail {

    // 日志记录
    private static Logger logger = Logger.getLogger(SendMail.class);

    public static MailAuthenticator authenticator;
    private MimeMessage message;
    private Session session;
    private Transport transport;
    private Properties properties = new Properties();

    private String mailHost = null;
    private String sender_username = null;
    private String sender_password = null;

    /**
     * 构造方法
     */
    public SendMail() {
        super();
    }

    /**
     * 供外界调用的发送邮件接口
     */
    public boolean sendEmail(String title, String content, List<String> receivers, List<File> fileList) {
        try {
            // 初始化smtp发送邮件所需参数
            initSmtpParams();

            // 发送邮件
            doSendHtmlEmail(title, content, receivers, fileList);

        } catch (Exception e) {
            logger.error(e);
        }
        return true;
    }

    /**
     * 初始化smtp发送邮件所需参数
     */
    private boolean initSmtpParams() {

        mailHost = "smtp.163.com"; // 邮箱类型不同值也会不同
        sender_username = "woshilinqin163@163.com";
        sender_password = "tb134694";

        properties.put("mail.smtp.host", mailHost);// mail.envisioncitrix.com
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.checkserveridentity", "false");
        properties.put("mail.smtp.ssl.trust", mailHost);

        authenticator = new MailAuthenticator(sender_username, sender_password);
        session = Session.getInstance(properties, authenticator);
        session.setDebug(false);// 开启后有调试信息
        message = new MimeMessage(session);

        return true;
    }

    /**
     * 发送邮件
     */
    private boolean doSendHtmlEmail(String title, String htmlContent, List<String> receivers, List<File> fileList) {
        try {
            // 发件人
            InternetAddress from = new InternetAddress(sender_username);
            message.setFrom(from);

            // 收件人(多个)
            InternetAddress[] sendTo = new InternetAddress[receivers.size()];
            for (int i = 0; i < receivers.size(); i++) {
                sendTo[i] = new InternetAddress(receivers.get(i));
            }
            message.setRecipients(MimeMessage.RecipientType.TO, sendTo);

            // 邮件主题
            message.setSubject(title);

            // 添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 添加邮件正文
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(htmlContent, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);

            // 遍历添加附件
            if (fileList != null && fileList.size() > 0) {
                for (File file : fileList) {
                    BodyPart attachmentBodyPart = new MimeBodyPart();
                    DataSource source = new FileDataSource(file);
                    attachmentBodyPart.setDataHandler(new DataHandler(source));
                    attachmentBodyPart.setFileName(file.getName());
                    multipart.addBodyPart(attachmentBodyPart);
                }
            }

            // 将多媒体对象放到message中
            message.setContent(multipart);

            // 保存邮件
            message.saveChanges();

            // SMTP验证，就是你用来发邮件的邮箱用户名密码
            transport = session.getTransport("smtp");
            transport.connect(mailHost, sender_username, sender_password);

            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());

            System.out.println(title + " Email send success!");
        } catch (Exception e) {
            logger.error(e);
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    logger.error(e);
                }
            }
        }
        return true;
    }

    /**
     * 测试main
     */
    public static void main(String[] args) {
        // 邮件主题
        String title = "邮件主题";

        // 邮件正文
        String htmlContent = "邮件内容";

        // 收件人
        List<String> receivers = new ArrayList<String>();
        receivers.add("woshilinqin163@163.com");
        receivers.add("625424841@qq.com");

        // 附件
        String fileName1 = "D:\\Program Files\\jd-gui-0.3.3.windows\\jd-gui.exe";
        File file1 = new File(fileName1);
        String fileName2 = "E:\\密码文件.txt";
        File file2 = new File(fileName2);
        List<File> fileList = new ArrayList<File>();
        fileList.add(file1);
        fileList.add(file2);

        // 执行发送
        new SendMail().sendEmail(title, htmlContent, receivers, fileList);
    }

}
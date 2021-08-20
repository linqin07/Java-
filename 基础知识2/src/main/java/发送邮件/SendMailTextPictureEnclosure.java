package 发送邮件;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 图片带附件二合一的发送方式
 * @Description:
 * @author: LinQin
 * @date: 2018/11/13
 */
public class SendMailTextPictureEnclosure {

    //发件人账户名
    public String senderAccount;
    //发件人账户密码
    public String senderPassword;

    public String smtpHost;

    public SendMailTextPictureEnclosure(String senderAccount, String senderPassword, String smtpHost) {
        this.senderAccount = senderAccount;
        this.senderPassword = senderPassword;
        this.smtpHost = smtpHost;
    }

    public static void main(String[] args) throws Exception {
        List<String> to = new ArrayList<>();
        to.add("625424841@qq.com");
        // to.add("1486459715@qq.com");
        to.add("woshilinqin163@163.com");
        SendMailTextPictureEnclosure mailTextPictureEnclosure = new SendMailTextPictureEnclosure("linqin@.com", "Tb134694", "smtp.qiye.163.com");
        mailTextPictureEnclosure.send("通知", "您好！此邮件由日志分析系统[chenyi : 192.168.10.176]发送，由您在系统中设置仪表盘执行计划并生成报表数据，发送仪表盘【盘3】的执行结果，详情请查看附件！祝您生活愉快!",
                to,
                "C:\\Users\\LinQin\\Desktop\\q.png","D:\\IDEAWorkspace\\Java基础知识\\基础知识2\\src\\main\\java\\发送邮件\\newReport.html");



    }

    /**
     * 获得创建一封邮件的实例对象
     *
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
    public  MimeMessage getMimeMessage(Session session, String title, String htmlContent, List<String> receivers, String picPath, String filePath) throws Exception {
        //1.创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        // 发件人
        InternetAddress from = new InternetAddress(senderAccount);
        msg.setFrom(from);

        // 收件人(多个)
        InternetAddress[] sendTo = new InternetAddress[receivers.size()];
        for (int i = 0; i < receivers.size(); i++) {
            sendTo[i] = new InternetAddress(receivers.get(i));
        }
        msg.setRecipients(MimeMessage.RecipientType.TO, sendTo);

        //4.设置邮件主题
        msg.setSubject(title, "UTF-8");

        //下面是设置邮件正文
        //msg.setContent("简单的纯文本邮件！", "text/html;charset=UTF-8");

        // 5. 创建图片"节点"
        MimeBodyPart image = new MimeBodyPart();
        // 读取本地文件
        DataHandler dh = new DataHandler(new FileDataSource(picPath));
        // 将图片数据添加到"节点"
        image.setDataHandler(dh);
        // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
        image.setContentID("mailTestPic");

        // 6. 创建文本"节点"
        MimeBodyPart text = new MimeBodyPart();
        // 这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
        text.setContent(htmlContent + "<br/><br/><br/><br/><img align=\"center\" src='cid:mailTestPic'/></a>", "text/html;charset=UTF-8");

        // 7. （文本+图片）设置 文本 和 图片"节点"的关系（将 文本 和 图片"节点"合成一个混合"节点"）
        MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        mm_text_image.addBodyPart(image);
        mm_text_image.setSubType("related");    // 关联关系

        // 8. 将 文本+图片 的混合"节点"封装成一个普通"节点"
        // 最终添加到邮件的 Content 是由多个 BodyPart 组成的 Multipart, 所以我们需要的是 BodyPart,
        // 上面的 mailTestPic 并非 BodyPart, 所有要把 mm_text_image 封装成一个 BodyPart
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mm_text_image);

        // 9. 创建附件"节点"
        MimeBodyPart attachment = new MimeBodyPart();
        // 读取本地文件
        DataHandler dh2 = new DataHandler(new FileDataSource(filePath));
        // 将附件数据添加到"节点"
        attachment.setDataHandler(dh2);
        // 设置附件的文件名（需要编码）
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合"节点" / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        mm.setSubType("mixed");         // 混合关系

        // 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
        msg.setContent(mm);
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());

        return msg;
    }

    public boolean send(String title, String htmlContent, List<String> receivers, String picPath, String filePath) {

        Message msg = null;
        try { //1、连接邮件服务器的参数配置
            Properties props = new Properties();
            //设置用户的认证方式
            props.setProperty("mail.smtp.auth", "true");
            //设置传输协议
            props.setProperty("mail.transport.protocol", "smtp");
            //设置发件人的SMTP服务器地址
            props.setProperty("mail.smtp.host", smtpHost);
            //2、创建定义整个应用程序所需的环境信息的 Session 对象
            Session session = Session.getInstance(props);
            //设置调试信息在控制台打印出来
            // session.setDebug(true);

            msg = getMimeMessage(session, title, htmlContent, receivers, picPath, filePath);

            //3、创建邮件的实例对象
            //4、根据session对象获取邮件传输对象Transport
            Transport transport = session.getTransport();
            //设置发件人的账户名和密码
            transport.connect(senderAccount, senderPassword);
            //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(msg, msg.getAllRecipients());

            //5、关闭邮件连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

}
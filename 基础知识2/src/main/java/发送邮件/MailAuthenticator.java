package 发送邮件;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @Description:
 * @author: LinQin
 * @date: 2018/11/12
 */
public class MailAuthenticator extends Authenticator {
    private String username;
    private String password;

    public MailAuthenticator(String sender_username, String sender_password) {
        this.username = sender_username;
        this.password = sender_password;
    }

    protected PasswordAuthentication getPasswordAuthentication () {
        return new PasswordAuthentication(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

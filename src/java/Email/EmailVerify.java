package Email;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.annotation.WebServlet;


public class EmailVerify 
{

    public boolean sendVerifyMail(String name, String email, int otp) {
               String msg = "<html> <body>"
                + "<h1 style='color:red'>CollegeQuera Verification Mail</h1>"
                + "<hr>"
                + "<b>Hello "+name+"</b>,<br><br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp; Thanks for registeration in CollegeQuera__@dushyant "
                + "This is a verification mail for your account, So please verify your account "
                + "with this OTP : " + otp + "."
                + "<br><br> Thanks"
                + "</body></html>";
        System.out.println("Email.EmailVerify.sendVerifyMail()"+email + "@" +otp + "@"+ name);      
        String username = "justsample4mail@gmail.com";
        String password = "sample@12345";
        
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");    
        
     Session session = Session.getInstance(props, new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("College Quera Verification Mail");

            
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
                
            Transport.send(message);
             return true;
        }
        
        catch (MessagingException me) {
            System.out.println("Email Errro : " + me.getMessage());
            return false;
        }
        

    }
    
}

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

//calss to send email
Class SMTPMailSender {
  
  public static sendEmail(String reciever,String sender,String subject , String body) {
  	
         final String fromEmail = sender;
        final String toEmail = reciever; // can be any email id 
         
        try{
        	
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
         
        Session session = Session.getInstance(props, auth);
         
        EmailUtil.sendEmail(session, toEmail,subject, body); 	
        }
        catch (MessagingException e) {
			throw new RuntimeException(e);
		}

  }
}
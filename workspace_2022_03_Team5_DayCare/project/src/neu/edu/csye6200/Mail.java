package neu.edu.csye6200;

import javax.mail.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {


	//public static class PasswordValidator extends Authenticator {  

	/**
	 * @param args the command line arguments
	 */
	public static void sendMail(String recepient, String body, String subject, String body2, String body3) throws MessagingException{
		System.out.println("Preparing to send email");
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");

		String myAccountEmail = "nishok127@proton.me";
		String password = "Wanker95!";


		Session session = Session.getInstance(properties, new javax.mail.Authenticator(){

			@Override
			protected  javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(myAccountEmail,password);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recepient, subject, body, body2, body3);

		Transport.send(message);
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String subject, String body, String plainBody, String body2){

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();           

			//plain text
			//            messageBodyPart.setText(plainBody);
			//            multipart.addBodyPart(messageBodyPart);

			String htmlText1 = plainBody;
			messageBodyPart.setContent(htmlText1, "text/html");
			multipart.addBodyPart(messageBodyPart); 

			//html text
			BodyPart messageBodyPart2 = new MimeBodyPart();
			String htmlText = body;
			messageBodyPart2.setContent(htmlText, "text/html");
			multipart.addBodyPart(messageBodyPart2);            


			BodyPart messageBodyPart3=new MimeBodyPart();
			messageBodyPart3.setContent(body2, "text/html");
			multipart.addBodyPart(messageBodyPart3);

			//            DataSource fds = new FileDataSource("F:\\Northeastern University\\New folder\\AED_FinalProject\\AED_FinalProject\\RapidExpress\\src\\Images\\imageProj.jpg");////src//Images//imageProj.jpg");
			BodyPart messageBodyPart4=new MimeBodyPart();
			//          messageBodyPart4.setDataHandler(new DataHandler(fds));
			messageBodyPart4.setHeader("Content-ID", "<image>");
			multipart.addBodyPart(messageBodyPart4);

			message.setContent(multipart);

			return message;
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		return null;
	} 


}
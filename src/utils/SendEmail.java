/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author boukr
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
   public SendEmail(){}
  public void email_sending(String email, String content,String subject ) {
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
 // Get a Properties object
    Properties props = System.getProperties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    props.setProperty("mail.smtp.socketFactory.fallback", "false");
    props.setProperty("mail.smtp.port", "465");
    props.setProperty("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.store.protocol", "pop3");
    props.put("mail.transport.protocol", "smtp");
    final String username = "contanct.gyf@gmail.com";//
    final String password = "contactgyf56789";
    try{
      Session session;
        session = Session.getDefaultInstance(props, 
                new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }});

   // -- Create a new message --
      Message msg = new MimeMessage(session);

   // -- Set the FROM and TO fields --
      msg.setFrom(new InternetAddress(username));
      msg.setRecipients(Message.RecipientType.TO, 
                        InternetAddress.parse(email,false));
      msg.setSubject(subject);
      msg.setText(content);
        System.out.println(email);
      msg.setSentDate(new Date());
      Transport.send(msg);
      System.out.println("Message sent.");
    }catch (MessagingException e){ 
      System.out.println("Erreur d'envoi, cause: " + e);
    }
  }
}


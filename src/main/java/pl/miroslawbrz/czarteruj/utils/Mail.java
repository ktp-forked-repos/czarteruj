package pl.miroslawbrz.czarteruj.utils;

import pl.miroslawbrz.czarteruj.model.User;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail{

    public void sendEmail(User user){

        final String username = "test.kurs.123123@gmail.com";
        final String password = "Test1234@";
        final String messageTitle = "Rejestracja - Czarteruj";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject(messageTitle);
            message.setText("Poniżej znajduje się link aktywacyjny - kliknij na niego aby dokończyć rejestrację \n" + prepareActivationLink(user));

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String prepareActivationLink(User user){
        return "localhost:8080/activateuser/" + user.getHash();
    }


}

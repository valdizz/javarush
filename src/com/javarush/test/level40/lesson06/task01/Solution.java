package com.javarush.test.level40.lesson06.task01;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/* Отправка письма с файлом
Исправь реализацию метода setAttachment. Этот метод должен прикреплять файл к письму.
Подсказки:
 1. Используй библиотеку JavaMail API версии 1.4.7.
 2. Письмо должно содержать только одну часть (MimeBodyPart) с файлом.
*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sendMail("valdizz@tut.by", "redalert", "valizz@inbox.ru");
    }

    public void sendMail(final String username, final String password, final String recipients) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {
            Transport bus = session.getTransport("smtp");
            bus.connect(recipients, username, password);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));

            setSubject(message, "Тестовое письмо");
            setAttachment(message, "c:/text.txt");

            message.saveChanges();
            bus.send(message);
            bus.close();
            System.out.println("Письмо было отправлено.");

        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке: " + e.toString());
        }
    }

    public static void setSubject(Message message, String subject) throws MessagingException {
        message.setSubject(subject);
    }

    public static void setAttachment(Message message, String filename) throws MessagingException {
        MimeBodyPart p1 = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(filename);
        p1.setDataHandler(new DataHandler(fds));
        p1.setFileName(fds.getName());
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        message.setContent(mp);
    }
}
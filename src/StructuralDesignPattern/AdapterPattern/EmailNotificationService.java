package StructuralDesignPattern.AdapterPattern;

// Legacy code :: Email Notification Service

public interface NotificationService {
    void send(String to, String subject, String body);
}
public class EmailNotificationService implements NotificationService {
    public void send(String to, String subject, String body) {
        System.out.println("Sending Email to: " + to);;
        System.out.println(("Subject: " + subject));
        System.out.println("Body: " + body);
    }
}

public class Client {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        emailService.send("customer@xyz.com", "Random Subject", "Random Body");

        // Using SendGrid email service via SendGridAdapter
        NotificationService emailServiceUsingSendGrid = new SendGridAdapter(new SendGridService());
        emailServiceUsingSendGrid.send("customer@xyz.com", "Random Subject", "Random Body");
    }
}

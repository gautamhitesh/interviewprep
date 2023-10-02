public class AbstractFactory {
    public static void main(String[] args) {
        NotificationFactory.notify("hitesh.gautam2501@gmail.com", "Hello email", "GCP", "Email");
        NotificationFactory.notify("9876543210", "Hello sms awws", "AWS", "SMS");
    }
}
enum NotificationType{
    email,
    sms,
    push
}

abstract class Notification{
    String cloudProvider;
    String userid;
    String msg;
    NotificationType notificationType;
    Notification(String cloudProvider, String userid, String msg, NotificationType type){
        this.cloudProvider=cloudProvider;
        this.userid=userid;
        this.msg=msg;
        this.notificationType=type;
    }
    abstract void createService(String cloudProvider, String userid, String msg);


}

class Email extends Notification{
    public Email(String cloudProvider, String userid, String msg){
        super(cloudProvider, userid, msg, NotificationType.email);
        createService(cloudProvider, userid, msg);
    }
    public void createService(String service, String userid, String msg){
        System.out.println("Email service created on "+service+ " Notification sent to "+userid +" Msg: "+msg);
    }
}

class SMS extends Notification{

    public SMS(String cloudProvider, String userid, String msg){
        super(cloudProvider, userid, msg, NotificationType.sms);
        createService(cloudProvider, userid, msg);
    }

    public void createService(String service, String userid, String msg){
        System.out.println("SMS service created on "+service+ " Notification sent to "+userid +" Msg: "+msg);
    }
}

class PushNotification extends Notification{
    public PushNotification(String cloudProvider,String userId, String msg){
        super(cloudProvider, userId, msg, NotificationType.push);
    }
    public void createService(String service, String userid, String msg){
        System.out.println("Push service created on "+service+ " Notification sent to "+userid +" Msg: "+msg);
    }
}

class AWS{
    public static Notification createNotification(String channel,String userid, String msg){
        switch(channel){
            case "SMS": return new SMS("AWS",userid, msg);
            case "Email": return new Email("AWS", userid, msg);
            case "Push": return new PushNotification("AWS", userid, msg);
            default: throw new IllegalArgumentException("Argument not found");
        }
    }
}

class GCP{
    public static Notification createNotification(String channel,String userid, String msg){
        switch(channel){
            case "SMS": return new SMS("GCP",userid, msg);
            case "Email": return new Email("GCP", userid, msg);
            case "Push": return new PushNotification("GCP", userid, msg);
            default: throw new IllegalArgumentException("Argument not found");
        }
    }
}

class NotificationFactory{
    private NotificationFactory(){
    }

    public static void notify(String userid, String msg, String service, String channel){
        switch (service){
            case "GCP": GCP.createNotification(channel, userid, msg);
            break;
            case "AWS": AWS.createNotification(channel, userid, msg);
            break;
            default: throw new IllegalArgumentException("Service not found");
        }
    }
}
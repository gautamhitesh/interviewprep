public class Factory {
    public static void main(String[] args) {
        NotificationFactory nf=new NotificationFactory();
        Notification notification=nf.createNotification("SMS", "987643210","Helo SMS");
        notification.notifyUser();
    }
}

interface Notification{
    public void notifyUser();
}

class NotificationFactory{
    public Notification createNotification(String channel, String id, String msg){
        switch(channel){
            case "Email": return new Email(id,msg);
            case "SMS": return new SMS(id, msg);
            case "Push": return new PushNotification(id, msg);
            default: throw new IllegalArgumentException("Unknown channel"+ channel);
        }
    }
}

class Email implements Notification{
    private String address;
    private String body;
    public Email(){}
    public Email(String address, String body){
        this.address=address;
        this.body=body;
    }

    public void notifyUser(){
        System.out.println("User with email id: "+address+" notified with message: "+body);
    }
}

class SMS implements Notification{
    private String phoneNumber;
    private String message;

    public SMS(){}

    public SMS(String phone, String msg){
        phoneNumber=phone;
        message=msg;
    }

    public void notifyUser(){
        System.out.println("User with phone number "+ phoneNumber +" notified with message: "+message);
    }
}

class PushNotification implements Notification{
    String userId;
    String msg;

    public PushNotification(){}
    public PushNotification(String userId, String msg){
        this.userId=userId;
        this.msg=msg;
    }
    public void notifyUser(){
        System.out.println("Push notification sent to user id "+userId+" with message "+msg);
    }
}

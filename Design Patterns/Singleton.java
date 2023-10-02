class Singleton extends Thread{
    public static void main(String[] args) {
        System.out.println("Hello World. Creating singleton instance");
        SingletonExample obj=SingletonExample.getInstance(); //call method via class name as it is static in nature/class method
        System.out.println(obj);
        SingletonExample obj2=SingletonExample.getInstance();
        System.out.println(obj2);
        if (obj==obj2){
            System.out.println("Same object");
        }else{
            System.out.println("Different object. Singleton failed");
        }

        SingletonExample obj3=SingletonExample.getInstance();
        System.out.println(obj3);
        
        for (int i = 0; i < 10; i++) {
            Singleton singleton=new Singleton();
                 singleton.start();   
        }
    }

    public void run(){
        try{
            SingletonExample obj4=SingletonExample.getInstance();
            SingletonExample obj5=SingletonExample.getInstance();
            SingletonThreadSafe obj6=SingletonThreadSafe.getInstance();
            SingletonThreadSafe obj7=SingletonThreadSafe.getInstance();
            System.out.println("Thread "+Thread.currentThread().getName());
            if (obj4==obj5){
                System.out.println("Non thread same object "+obj4+" "+obj5);
            }else{
                System.out.println("Non thread different object "+obj4+" "+obj5);
            }

            if (obj6==obj7){
                System.out.println("Thread same object "+obj6+" "+obj7);
            }else{
                System.out.println("Thread different object "+obj4+" "+obj5);
            }


        }catch(Exception e){
            System.out.println("Exception occurred "+e);
        }

    }
}

class SingletonExample{
    private static SingletonExample object=new SingletonExample();
    //static method as the object will be created once for the whole class, no more copies will be created

    private SingletonExample(){} 
    //force the use of getInstance method

    public static SingletonExample getInstance(){ 
        return object;
    }
}

class SingletonThreadSafe{
    private static volatile SingletonThreadSafe obj=null;

    private SingletonThreadSafe(){}

    public static synchronized SingletonThreadSafe getInstance(){
        if (obj==null){
            synchronized(SingletonThreadSafe.class){
                if (obj==null){
                    obj= new SingletonThreadSafe();
                }
            }
        }
        return obj;
    }
}
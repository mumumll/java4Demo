package junit5;


public class Calculator {
    public static int result = 0;
    public static int add(int x,int y){
        sleep();
        int result = x + y;
        return result;
    }

    public static int subtract(int x,int y){
        sleep();
        int result = x - y;
        return result;
    }
    public static int multiply(int x,int y){
        int result = x * y;
        return result;
    }
    public static int divide(int x,int y){
        int result = x/y;
        return result;
    }
    public static int count(int x){
        int i =result;
        sleep();
        result =i + x;
        return result;
    }
    public static int synCount(int x){
        sleep();
        result +=x;
        return result;
    }
    public static void clear(){
        int result = 0;
        System.out.println("清零当前结果");
    }
    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

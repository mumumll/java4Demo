package junit5;


public class Calculator {
    public static int result = 0;
    public static int add(int x,int y){
        int result = x + y;
        return result;
    }

    public static int subtract(int x,int y){
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
        result +=x;
        return result;
    }
    public static void clear(){
        int result = 0;
    }

}

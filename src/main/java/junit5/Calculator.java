package junit5;

public class Calculator {
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
        int result = x++;
        return result;
    }
    public void clear(){

    }

}

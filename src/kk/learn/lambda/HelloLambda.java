package kk.learn.lambda;

public class HelloLambda {

    public static void main(String[] args)
    {
        System.out.println("Inside outer Thread: " + Thread.currentThread().getName());
        new Thread(() ->
            System.out.println("Inside inner Thread: " + Thread.currentThread().getName())
        ).start();
    }
}

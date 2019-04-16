package kk.learn.lambda;

public class HelloLambda {

    public static void main(String[] args)
    {
        System.out.println("Inside outer Thread: " + Thread.currentThread().getName());
        new Thread(() ->
            System.out.println("Inside I inner Thread: " + Thread.currentThread().getName())
        ).start();

        Runnable run = () ->
        System.out.println("Inside II inner Thread: " + Thread.currentThread().getName());
        new Thread(run).start();

    }
}


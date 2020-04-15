//Student Name: Badal Sarkar
//Student ID:137226189

public class ReverseThread{
    public static void main(String [] args){
        System.out.println("Starting First Thread");
        ThreadAction ta= new ThreadAction();
        Thread t= new Thread(ta);
        t.start();
        try{
        t.join();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}




class ThreadAction implements Runnable{
    private static int threadCount=0;
    private static int sleepTime=1000;

    @Override
    public void run(){
        if(threadCount<50){
            sleepTime-=20;
            Thread t= new Thread(new ThreadAction());
            threadCount++;
            t.start();
            try{
                Thread.currentThread().sleep(sleepTime);
            }
            catch(Exception e){
                System.out.println(e);
            }
            System.out.println("Hello from "+ Thread.currentThread().getName());
        }
    }
    
}

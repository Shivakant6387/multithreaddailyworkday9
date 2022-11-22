
class MyData{
    int value;
    boolean flag=true;
   synchronized public void set(int v){
       while(flag!=true)
          try
          {
              wait();
          }catch (Exception e){

          }
           value=v;
       flag=false;
       notify();
    }
    synchronized public int get(){
        int x=0;
        while (flag!=false)
            try {
                wait();
            }catch (Exception e){

            }
        x=value;
        flag=false;
        notify();
        return x;
    }
}
class Producer extends Thread{
    MyData data;
    public Producer(MyData d){
        data=d;
    }
    public void run(){
        int count=1;
        while(true){
            data.set(count);
            System.out.println("Producer"+count);
            count++;
        }
    }
}
class Consumer extends Thread{
    MyData data;
    public Consumer(MyData d){
        data=d;
    }
    public void run(){
        int value;
        while(true){
            value=data.get();
            System.out.println("Consumer"+value);
        }
    }
}
public class InnerThreadS {
    public static void main(String[] args) {
        MyData myData=new MyData();
        Producer p=new Producer(myData);
        Consumer c=new Consumer(myData);
        p.start();
        c.start();
    }
}

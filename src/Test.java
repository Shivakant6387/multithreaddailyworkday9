
class WhiteBoard{
    String text;
    int numberOfStudent;
    int count;
    public void attendance(){
        numberOfStudent++;
    }
    synchronized  public  void write(String t){
        System.out.println( "Teacher is writing "+t);
        while (count!=0)
            try {
                wait();
            }catch (Exception e){

            }
        text=t;
        count=numberOfStudent;
        notifyAll();
    }
    synchronized  public  String read(){
        while (count==0)
            try
            {
                wait();
            }catch (Exception e){

            }
        String t=text;
        count--;
        if(count==0)
            notify();
        return t;
    }
}
class Teacher extends Thread{
    WhiteBoard wb;
    String notes[]={"java is language","it is platform independent","it support thread"};
    public Teacher(WhiteBoard w){
        wb=w;
    }
    public void  run(){
        for (int i=0;i<notes.length;    i++)
            wb.write(notes[i]);
    }
}
class Student extends Thread{
    String name;
    WhiteBoard wb;
    public Student(String n, WhiteBoard w){
        name=n;
        wb=w;
    }
    public void run(){
        String text;
        wb.attendance();
        do{
                text=wb.read();
            System.out.println(name+"Reading "+text);
            System.out.flush();
        }while (!text.equals("end"));
    }
}
public class Test {
    public static void main(String[] args) {
WhiteBoard whiteBoard=new WhiteBoard();
Teacher teacher=new Teacher(whiteBoard);
        Student s1=new Student("1. John",whiteBoard);
        Student s2=new Student("2. Ajay",whiteBoard);
        Student s3=new Student("3. Raj",whiteBoard);
        Student s4=new Student("4. Ravi",whiteBoard);
        teacher.start();
        s1.start();
        s2.start();
        s3.start();
        s4.start();

    }
}

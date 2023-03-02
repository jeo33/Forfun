import java.awt.*;
import java.util.List;

public class RR implements Algorithm{
    int Timeout=Integer.MAX_VALUE;
    TaskDisplay R;
    int c=0;
    Task taskTemp;
    List<Task> OriginalQueue;
    List<Task> RQueue;
    int counter=0;
    int quantum;
    double WaitTime=0;
    double TurnAroundTime=0;
    double RunTime=0;
    int size=0;

    public MainPanel mainP=new MainPanel();
    RR(List<Task> queue,int q)
    {
        OriginalQueue=queue;
        RQueue=queue;
        quantum=q;
        size=OriginalQueue.size();
        R=new TaskDisplay();
        R.setBackground(Color.PINK);
        mainP.add(R);
        R.setBounds(0,0,R.getTaskDisplay_Width(),R.getTaskDisplay_Width());
    }
    RR(List<Task> queue,int q,int timeout)
    {
        OriginalQueue=queue;
        RQueue=queue;
        quantum=q;
        size=OriginalQueue.size();
        Timeout=timeout;
        R=new TaskDisplay();
        R.setBackground(Color.PINK);
        mainP.add(R);
        R.setBounds(0,0,R.getTaskDisplay_Width(),R.getTaskDisplay_Width());
    }

    @Override
    public void schedule() {
        Task temp;
        int SliceTime;
        while (!RQueue.isEmpty())
        {
            temp=pickNextTask();
            CPU.run(temp,0);
            R=new TaskDisplay(temp);
            R.setBackground(Color.PINK);
            mainP.add(R);
            R.setBounds(3*mainP.getUnit_size()+c*R.getTaskDisplay_Width(), 0,R.getTaskDisplay_Width(),R.getTaskDisplay_Width());

            if(temp.getBurst()<=quantum)
            {
                SliceTime=temp.getBurst();
            }
            else SliceTime=quantum;

            WaitTime=WaitTime+SliceTime*(RQueue.size()-1);
            TurnAroundTime=TurnAroundTime+SliceTime;
            temp.setBurst(temp.getBurst()-SliceTime);

            if(temp.getBurst()==0)
            {
                System.out.println("Task "+temp.getName()+" finished.");
                RQueue.remove(temp);

            }
            else
            {
                RQueue.add(temp);
                RQueue.remove(0);
            }

            draw(RQueue);
        }

        System.out.println("Average times: waiting "+WaitTime/size+", turnaround: "+(WaitTime+TurnAroundTime)/size);
        GantChart gant=new GantChart(c*R.getTaskDisplay_Width(),R.getTaskDisplay_Height());
        mainP.add(gant);
        TimePanel panel=new TimePanel(WaitTime/size,(WaitTime+TurnAroundTime)/size);
        mainP.add(panel);
        ReadyQueue qu=new ReadyQueue(600);
        mainP.add(qu);

        Display d=new Display(mainP);
    }

    public void draw(List<Task> q)
    {
        for(int i=0;i<q.size();i++)
        {
            taskTemp=q.get(i);
            R=new TaskDisplay(taskTemp);
            mainP.add(R);
            R.setLocation(R.getTaskDisplay_Width()+c*R.getTaskDisplay_Width(),R.getTaskDisplay_Height()+i*R.getTaskDisplay_Height());

        }
        c++;


    }



    public void fss_helper(int quantum) {
        int UserTimeOut = Timeout;
        Task temp;
        int SliceTime;
        while (!RQueue.isEmpty()& UserTimeOut !=0)
        {
            temp=pickNextTask();
            CPU.run(temp,0);
            if(temp.getBurst()<=quantum)
            {
                SliceTime=temp.getBurst();
            }
            else SliceTime=quantum;
            if(SliceTime> UserTimeOut)
            {
                SliceTime= UserTimeOut;
            }
            UserTimeOut = UserTimeOut -SliceTime;
            WaitTime=WaitTime+SliceTime*(RQueue.size()-1);
            TurnAroundTime=TurnAroundTime+SliceTime;
            temp.setBurst(temp.getBurst()-SliceTime);

            if(temp.getBurst()==0)
            {
                System.out.println("Task "+temp.getName()+" finished.");
                RQueue.remove(temp);
            }
            else
            {
                RQueue.add(temp);
                RQueue.remove(0);
            }
        }

        if(RQueue.isEmpty())
        {
            System.out.println("Average times: waiting "+WaitTime/size+", turnaround: "+(WaitTime+TurnAroundTime)/size);

        }

    }



    @Override
    public Task pickNextTask() {

        if(RQueue.isEmpty())return null;
        else
        {
            return RQueue.get(counter);
        }
    }
}

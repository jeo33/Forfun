import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Priority implements Algorithm{
    public MainPanel mainP=new MainPanel();
    int c=0;
    TaskDisplay R;
    Task taskTemp;
    List<Task> OriginalQueue;
    List<Task> RQueue;
    int counter=0;
    double WaitTime=0;
    double TurnAroundTime=0;
    int size=0;
    Priority(List<Task> queue) throws IOException {
        OriginalQueue=queue;
        RQueue=Sort(queue);;
        R=new TaskDisplay();
        R.setBackground(Color.PINK);
        mainP.add(R);
        R.setBounds(0,0,R.getTaskDisplay_Width(),R.getTaskDisplay_Width());
    }


    @Override
    public void schedule() {
        Task temp;
        while (!RQueue.isEmpty())
        {
            temp=pickNextTask();
            CPU.run(temp,0);

            R=new TaskDisplay(temp);
            R.setBackground(Color.PINK);
            mainP.add(R);
            R.setBounds(3*mainP.getUnit_size()+c*R.getTaskDisplay_Width(),0*mainP.getUnit_size(),R.getTaskDisplay_Width(),R.getTaskDisplay_Width());

            WaitTime=WaitTime+temp.getBurst()*(RQueue.size()-1);

            TurnAroundTime=TurnAroundTime+temp.getBurst();
            temp.setBurst(0);
            if(temp.getBurst()==0)
            {
                System.out.println("Task "+temp.getName()+" finished.");
                RQueue.remove(counter);
                draw(RQueue);
                size++;
            }
            else counter++;

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
    public List<Task> Sort(List<Task> a)
    {
        List<Task> ans=new ArrayList<>();
        int dummy;
        while(!a.isEmpty())
        {
            dummy=0;
            for(int j=0;j<a.size();j++)
            {
                if(a.get(j).getPriority()>a.get(dummy).getPriority())
                {
                    dummy=j;
                }
            }
            ans.add(a.get(dummy));
            a.remove(dummy);
        }
        return ans;
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

    @Override
    public Task pickNextTask() {

        if(RQueue.isEmpty())return null;
        else
        {
            return RQueue.get(counter);
        }
    }
}

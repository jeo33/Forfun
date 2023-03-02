
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TaskDisplay extends JPanel {
    static final int TaskDisplay_Width=60;
    static final int TaskDisplay_Height=60;

    Task t;

    int getTaskDisplay_Width()
    {
        return TaskDisplay_Width;
    }
    int getTaskDisplay_Height()
    {
        return TaskDisplay_Height;
    }

    public TaskDisplay(Task t)
    {

        String labelText ="<html>Name :"+t.getName()+"<br>Priority :"+t.getPriority()+"<br>Burst :"+t.getBurst()+"</html>";
        JLabel label=new JLabel(labelText);
        label.setFont(new Font("Serif",Font.CENTER_BASELINE,10));
        this.setBackground(Color.yellow);
        this.setBounds(0,0,TaskDisplay_Width,TaskDisplay_Height);
        Border border=BorderFactory.createLineBorder(Color.cyan);
        this.setBorder(border);
        this.add(label);
    }


    public TaskDisplay()
    {
        String st="<html>Gantt<br>Chart</html>";
        JLabel label=new JLabel(st);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("Serif",Font.CENTER_BASELINE,12));
        this.setBackground(Color.yellow);
        this.setBounds(0,0,TaskDisplay_Width,TaskDisplay_Height);
        Border border=BorderFactory.createLineBorder(Color.cyan);
        this.setBorder(border);
        this.add(label);
    }




}

import javax.swing.*;
import java.awt.*;

public class TimePanel extends JPanel {
    static final int Screen_Width =1200;
    static final int Screen_Height =600;
    int TimePanel_Width=20*unit_size;
    int TimePanel_Height=3*unit_size;
    static final int unit_size=20;

    public TimePanel()
    {
        this.setPreferredSize(new Dimension());
        this.setBackground(Color.blue);
        this.setBounds((int)(0.5*(Screen_Width-TimePanel_Width)),Screen_Height-5*unit_size,20*unit_size,3*unit_size);
        this.setBorder(null);
    }

    public TimePanel(double x,double y)
    {

        JLabel label=new JLabel("Average wait :"+x+"            Average Turnaround :"+y);
        label.setFont(new Font("Serif",Font.CENTER_BASELINE,15));
        label.setForeground(Color.black);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.setPreferredSize(new Dimension());
        this.setBackground(Color.blue);
        this.setBounds((int)(0.5*(Screen_Width-TimePanel_Width)),Screen_Height-5*unit_size,20*unit_size,3*unit_size);
        this.setBorder(null);
        this.add(label);
    }
}

import javax.swing.*;
import java.awt.*;

public class ReadyQueue extends JPanel {
    int ReadyQueue_Width=60;
    int ReadyQueue_Height;
    static final int unit_size=20;

    public ReadyQueue(int ReadyQueue_Height)
    {

        String st="<html> Ready<br> Queue</html>";
        JLabel label=new JLabel(st);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);

        this.setLayout(null);
        this.add(label);
        label.setBounds(0,12*20,60,60);


        this.setPreferredSize(new Dimension());
        this.setBackground(Color.ORANGE);
        this.setBounds(0,60,ReadyQueue_Width,ReadyQueue_Height);
        this.setBorder(null);

    }
}

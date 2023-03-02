
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {
    static final int Screen_Width =1200;
    static final int unit_size=20;
    static final int Screen_Height =600;

    int getUnit_size()
    {
        return unit_size;
    }
    int Screen_Width()
    {
        return Screen_Width;
    }
    int Screen_Height()
    {
        return Screen_Height;
    }

    Algorithm scheduler = null;
    List<Task> queue = new ArrayList<Task>();
    int quantum=10;
    int UserQuantum=30;
    List<List<Task>> ReadyQHistory;



    String[] args;



    public MainPanel(){
        this.setPreferredSize(new Dimension(Screen_Width,Screen_Height));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setBorder(null);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        // custom painting logic
    }
    public void draw(Graphics g)
    {
        for(int i=0;i<=Screen_Height/unit_size;i++)
        {
            g.drawLine(0,i*unit_size,Screen_Width,i*unit_size);
        }
        for(int i=0;i<=Screen_Width/unit_size;i++)
        {

            g.drawLine(i*unit_size,0,i*unit_size,Screen_Height);
        }
    }



}

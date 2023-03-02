import javax.swing.*;
import java.awt.*;

public class GantChart extends JPanel {

    static final int unit_size=20;
    public GantChart(int gantChart_Width,int gantChart_Height)
    {
        this.setPreferredSize(new Dimension());
        this.setBackground(Color.GREEN);
        this.setBounds(3*unit_size,0*unit_size,gantChart_Width,gantChart_Height);
        this.setBorder(null);
    }
}

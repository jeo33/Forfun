import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Display extends JFrame {

    public Display(MainPanel x) {

        this.setTitle("coen346_Assignment2_Jgai");
        this.setResizable(true);
        this.setDefaultCloseOperation(Display.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setSize(1300,700);
        this.setLocationRelativeTo(null);
        this.add(x);
        this.setVisible(true);
    }

}

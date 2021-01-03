package home.avat;

import javax.swing.*;
import java.awt.*;

public class FrameFactory {
    public JFrame create() {
        var frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setTitle("Main Form");

        return frame;
    }
}

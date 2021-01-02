package home.avat;

import javax.swing.*;
import java.awt.*;

public class FrameFactory {
    public JFrame create() {
        var frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setTitle("Main Form");

        return frame;
    }
}

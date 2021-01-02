package home.avat;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        FrameFactory factory = new FrameFactory();
        JFrame frame = factory.create();
        frame.pack();
        frame.setVisible(true);
    }
}

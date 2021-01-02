package home.avat;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        var factory = new FrameFactory();
        var frame = factory.create();
        frame.pack();
        frame.setVisible(true);
    }
}

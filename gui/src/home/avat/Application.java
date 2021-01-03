package home.avat;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        var factory = new FrameFactory();
        var frame = factory.create();

        var container = new NodeContainer();
        container.addToParent(frame.getContentPane());

        frame.setVisible(true);

        var nodeViewProvider = new DummyNodeViewProvider();
        container.setNodeView(nodeViewProvider.get());

        frame.pack();
    }
}

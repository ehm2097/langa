package home.avat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NodeContainer {

    public NodeContainer() {
        innerPanel = new JPanel();
        innerPanel.setLayout(new FlowLayout());
        innerPanel.setBackground(Color.GREEN);

        outerPanel = new JScrollPane(innerPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        outerPanel.setBackground(Color.CYAN);
        outerPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            }
        });

    }

    public void addToParent(Container parent) {
        parent.add(outerPanel);
    }

    public void setNodeView(NodeView nodeView) {
        innerPanel.removeAll();
        for(var node: nodeView.getSubnodes()) {

            var width = node.getThumbnailWidth();
            var height = 200;

            var label = new JLabel();
            label.setToolTipText(node.getTitle());
            label.setPreferredSize((new Dimension(width, height)));
            label.setBorder(new LineBorder(Color.RED));

            var image = outerPanel.createImage(width, height);
            var g = image.getGraphics();
            g.setColor(Color.ORANGE);
            g.fillRect(0, 0, width, height);
            label.setIcon(new ImageIcon(image));

            innerPanel.add(label);
        }
    }

    private static int NODE_HEIGHT = 200;

    private JScrollPane outerPanel;
    private Container innerPanel;
}

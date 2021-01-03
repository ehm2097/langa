package home.avat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NodeContainer {

    public NodeContainer() {
        innerPanel = new ScrollablePanel();
        innerPanel.setLayout(new HalfScrollLayout(33));
        innerPanel.setBackground(Color.GREEN);

        outerPanel = new JScrollPane(innerPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outerPanel.setBackground(Color.CYAN);
        outerPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            }
        });


    }

    public void addToParent(Container parent) {
        parent.add(outerPanel, BorderLayout.CENTER);
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

    private class ScrollablePanel extends JPanel implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 1;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 1;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
    }
}

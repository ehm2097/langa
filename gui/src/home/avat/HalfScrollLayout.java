package home.avat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HalfScrollLayout extends FlowLayout implements LayoutManager {

    public HalfScrollLayout(int rowHeight) {
        this.rowHeight = rowHeight;
        this.cellWidths = new ArrayList<Integer>();
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        super.addLayoutComponent(name, comp);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        super.removeLayoutComponent(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
//        var parentDimension = parent.getSize();
//        var result = super.preferredLayoutSize(parent);
//        System.out.printf("Preferred: %s => %s\n", parentDimension, result);
//        if (parentDimension.width > 0) {
//            var factor = (int) Math.ceil(1.0 * result.width / parentDimension.width);
//            result.height *= factor;
//        }
//        return result;

        synchronized (target.getTreeLock()) {
            Dimension dim = new Dimension(target.getWidth(), 0);
            int nmembers = target.getComponentCount();
            boolean firstVisibleComponent = true;
            boolean useBaseline = getAlignOnBaseline();
            int maxAscent = 0;
            int maxDescent = 0;

            Insets insets = target.getInsets();
            var hgap = getHgap();
            var vgap = getVgap();
            var lineHeight = 0;
            var lineWidth = 0;
            var maxWidth = dim.width - insets.left - insets.right - 2 *hgap;

            for (int i = 0 ; i < nmembers ; i++) {
                Component m = target.getComponent(i);
                if (m.isVisible()) {
                    Dimension d = m.getPreferredSize();

                    if(lineWidth + d.width + hgap > maxWidth) {
                        lineWidth = 0;
                    }

                    lineHeight = Math.max(lineHeight, d.height);
                    if(lineWidth == 0) dim.height += (lineHeight + vgap);

                    if (firstVisibleComponent) {
                        firstVisibleComponent = false;
                    } else {
                        lineWidth += hgap;
                    }
                    lineWidth += d.width;
                    if (useBaseline) {
                        int baseline = m.getBaseline(d.width, d.height);
                        if (baseline >= 0) {
                            maxAscent = Math.max(maxAscent, baseline);
                            maxDescent = Math.max(maxDescent, d.height - baseline);
                        }
                    }
                }
            }
            if (useBaseline) {
                dim.height = Math.max(maxAscent + maxDescent, dim.height);
            }
            dim.height += insets.top + insets.bottom + vgap*2;
            return dim;
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return super.minimumLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        var parentDimension = parent.getSize();
        System.out.printf("Layout: %s\n", parentDimension);
        super.layoutContainer(parent);
    }

    private int rowHeight;
    private List<Integer> cellWidths;
}

package home.avat;

import java.util.Arrays;
import java.util.ServiceLoader;

public class DummyNodeViewProvider implements ServiceLoader.Provider<NodeView> {
    @Override
    public Class<? extends NodeView> type() {
        return NodeView.class;
    }

    @Override
    public NodeView get() {
        return new RootView();
    }

    private static int NODE_COUNT = 33;
    private static String TITLE = "Dummy Nodes";

    private static class RootView implements NodeView {

        public RootView() {
            for(int i = 0; i < NODE_COUNT; i++) {
                leaves[i] = new LeaveView(widthGenerator.getNext());
            }
        }

        @Override
        public String getTitle() {
            return TITLE;
        }

        @Override
        public byte[] getThumbnail() {
            return new byte[0];
        }

        @Override
        public int getThumbnailWidth() {
            return 0;
        }

        @Override
        public Iterable<NodeView> getSubnodes() {
            return Arrays.asList(leaves);
        }

        private NodeView[] leaves = new NodeView[NODE_COUNT];
        private DummyWidthGenerator widthGenerator = DummyWidthGenerator.create();
    }

    private static class LeaveView implements NodeView {

        public LeaveView(int width) {
            this.width = width;
        }

        @Override
        public String getTitle() {
            return String.format("leave_%d", width);
        }

        @Override
        public byte[] getThumbnail() {
            return new byte[0];
        }

        @Override
        public int getThumbnailWidth() {
            return width;
        }

        @Override
        public Iterable<NodeView> getSubnodes() {
            return null;
        }

        private int width;
    }
}

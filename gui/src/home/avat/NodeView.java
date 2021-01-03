package home.avat;

public interface NodeView {
    public String getTitle();
    public byte[] getThumbnail();
    public int getThumbnailWidth();
    public Iterable<NodeView> getSubnodes();
}

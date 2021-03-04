import java.util.AbstractList;

public interface IRssUpdater {
    AbstractList<Item> update() throws Exception;
}

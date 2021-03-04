import java.net.MalformedURLException;
import java.util.AbstractList;

public abstract class Publisher {

    abstract void Publish(Item item) throws Exception;

    void PublishMultipleItems(AbstractList<Item> items) {
        for(Item item : items) {
            try {
                Publish(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

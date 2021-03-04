import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.ArrayList;

public class Manager {
    private AbstractList<IRssUpdater> updaters;
    private AbstractList<Publisher> publishers;
    private final String apiToken = "1660844865:AAE6Nzau1hebq1-kMNyjxSh1HHf1mLISnao";
    private final String channelName = "@check_channnel";
    private AbstractList<String> words;

    public Manager(){
        Timestamp current_time = new Timestamp(Long.MIN_VALUE);
        this.words = new ArrayList<>();
        words.add("video");
        words.add("Super");
        words.add("Nintendo");
        words.add("play");
        // You can add more words if you want to

        updaters = new ArrayList<>();
        updaters.add( new TheVergeUpdater(current_time, words));
        // You can add more updaters if you want to

        publishers = new ArrayList<>();
        publishers.add(new TelegramPublisher(channelName, apiToken));
        // You can add more publishers if you want to
    }

    private AbstractList<Item> update(){

        AbstractList<Item> allItems = new ArrayList<>();

        for (IRssUpdater updeter: this.updaters){
            try {
                allItems.addAll(updeter.update());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allItems;
    }

    private void publish(AbstractList<Item> items) {
        for (Publisher publisher: this.publishers) {
            publisher.PublishMultipleItems(items);
        }
    }

    public void run() {
        while (true) {
            this.publish( this.update());
            try {
                Thread.sleep(30*60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

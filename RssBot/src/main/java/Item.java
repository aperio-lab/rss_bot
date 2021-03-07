public class Item {
    public String title;
    public String content;

    public Item(String title, String content){
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + ": " + content;
    }
}

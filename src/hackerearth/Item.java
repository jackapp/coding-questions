package hackerearth;

public class Item {

    private String name;
    private int relevance;
    private int price;

    public Item(String name, int relevance, int price) {
        this.name = name;
        this.relevance = relevance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

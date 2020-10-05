package hackerearth;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);



    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        List<Item> items1 = new ArrayList<>();
        for (List<String> itemList : items) {
            items1.add(new Item(itemList.get(0),itemList.get(1),itemList.get(2)));
        }

        switch (sortParameter) {
            case 0:
                Collections.sort(items1, new Comparator<Item>() {
                    @Override
                    public int compare(Item item, Item t1) {
                        if (sortOrder==0) {
                            return item.getName().compareTo(t1.getName());
                        } else {
                            return t1.getRelevance().compareTo(item.getRelevance());
                        }
                    }
                });
                break;
            case 1:
                Collections.sort(items1, new Comparator<Item>() {
                    @Override
                    public int compare(Item item, Item t1) {
                        if (sortOrder==0) {
                            return item.getRelevance().compareTo(t1.getRelevance());
                        } else {
                            return t1.getRelevance().compareTo(item.getRelevance());
                        }
                    }
                });
                break;
            case 2:
                Collections.sort(items1, new Comparator<Item>() {
                    @Override
                    public int compare(Item item, Item t1) {
                        if (sortOrder==0) {
                            return item.getPrice().compareTo(t1.getPrice());
                        } else {
                            return t1.getPrice().compareTo(item.getPrice());
                        }
                    }
                });
                break;

        }

        //Items are sorted now

        List<String> returnList = new ArrayList<>();
        int start;
        int end;
        for (int i=(pageNumber)*itemPerPage;i<Math.min(items1.size(),(pageNumber+1)*itemPerPage);i++) {
             returnList.add(items1.get(i).getName());
        }
        return returnList;
    }

    private static class Item {

        private String name;
        private Integer relevance;
        private Integer price;

        public Item(String name, String relevance, String price) {
            this.name = name;
            this.relevance = Integer.parseInt(relevance);
            this.price = Integer.parseInt(price);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getRelevance() {
            return relevance;
        }

        public void setRelevance(Integer relevance) {
            this.relevance = relevance;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }
}
package misc;

import java.util.*;
import java.util.stream.Collectors;

public class Amazon1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCom=6;
        int topN=2;
    }

    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {
        Map<String,Map<Integer,Integer>> map = new HashMap<>();
        for (String competitor : competitors) {
            map.put(competitor,new HashMap<>());
        }
        int counter=0;
        for (String review : reviews) {
            String words[] = review.split(" ");
            for (String word : words) {
                if (map.containsKey(word)) {
                    Map<Integer,Integer> temp = map.get(word);
                    if (!temp.containsKey(counter)) {
                        temp.put(counter,1);
                        map.put(word,temp);
                    }
                }
            }
            counter++;
        }
        List<Map.Entry<String, Map<Integer,Integer>>> list =
                new LinkedList<Map.Entry<String, Map<Integer,Integer>>> (map.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<String, Map<Integer, Integer>>>() {
           @Override
           public int compare(Map.Entry<String, Map<Integer, Integer>> t, Map.Entry<String, Map<Integer, Integer>> t1) {
               if (t.getValue().size()>t1.getValue().size()) {
                   return 1;
               } else if (t.getValue().size()==t1.getValue().size()) {
                   return t.getKey().compareTo(t1.getKey());
               }
               return -1;
           }
       });
       ArrayList<String> ans = new ArrayList<>();
       counter=0;
       int maxVal = numCompetitors>=topNCompetitors?topNCompetitors:numCompetitors;
       for (Map.Entry<String,Map<Integer,Integer>> entry : list) {
           if (counter<=maxVal) {
               ans.add(entry.getKey());
               counter++;
           } else {
               break;
           }
       }
      return ans;
    }
}

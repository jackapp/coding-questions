package leetcode.thirtyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("cbaebabacd","abc");
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int anagram[] = new int[26];

        List<Integer> positions = new ArrayList<>();
        for (int i=0;i<p.length();i++) {
            anagram[p.charAt(i)-'a']++;
        }
        Map<Character,Integer> tempMap = restoreMap(anagram);

        int curr=0,last=0;
        while (curr<s.length()) {
            if (anagram[s.charAt(curr)-'a']!=0) {
                if (tempMap.containsKey(s.charAt(curr))) {
                   tempMap.put(s.charAt(curr),tempMap.get(s.charAt(curr))-1);
                   if (tempMap.get(s.charAt(curr))==0) {
                       tempMap.remove(s.charAt(curr));
                   }
                   curr++;
                } else {
                    tempMap.put(s.charAt(last),tempMap.containsKey(s.charAt(last))?tempMap.get(s.charAt(last))+1:1);
                    last++;
                }
            } else {
                if (last!=curr) {
                    tempMap.put(s.charAt(last),tempMap.containsKey(s.charAt(last))?tempMap.get(s.charAt(last))+1:1);
                    last++;
                } else {
                    curr++;
                    last++;
                }

            }

            if (tempMap.size()==0) {
                positions.add(last);
                tempMap.put(s.charAt(last),1);
                last++;
            }
        }
        return positions;
    }

    private static Map<Character, Integer> restoreMap(int[] anagram) {
        Map<Character,Integer> tempMap = new HashMap<>();
        for (int i=0;i<26;i++) {
            if (anagram[i]!=0) {
                int x = 'a'+i;
                tempMap.put((char)x,anagram[i]);
            }
        }
        return tempMap;
    }

}

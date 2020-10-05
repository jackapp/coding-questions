package leetcode.thirtyDay;

import java.util.*;

public class TownJudge {

    public static void main(String[] args) {

    }

    public static int findJudge(int N, int[][] trust) {

        int trustedBy[] = new int[N];
        int trustsWhom[] = new int[N];
        for (int i=0;i<trust.length;i++) {
            trustedBy[trust[i][1]-1]++;
            trustsWhom[trust[i][0]-1]++;
        }
        int ans=-1;
        for (int i=0;i<N;i++) {
            if (trustedBy[i]==N-1) {
                if (ans==-1 && trustsWhom[i]==0) {
                    ans=i+1;
                } else {
                    return -1;
                }
            }
        }

        return ans;
        /*
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0;i<trust.length;i++) {
            if (map.containsKey(trust[i][1])) {
                map.get(trust[i][0]).add(trust[i][0]);
            } else {
                map.put(trust[i][1],new ArrayList<>());
                map.get(trust[i][1]).add(trust[i][0]);
            }
        }

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry entry = (Map.Entry)iterator.next();



        }

         */

    }
}

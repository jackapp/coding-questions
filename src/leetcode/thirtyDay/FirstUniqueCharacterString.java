package leetcode.thirtyDay;

public class FirstUniqueCharacterString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
    public static int firstUniqChar(String s) {
        int base[] = new int[26];

        for (int i=0;i<26;i++) {
            base[i]=-1;
        }

        for (int i=0;i<s.length();i++) {
            int x = base[s.charAt(i)-'a'];
            if (x!=-2) {
                if (x==-1) {
                    base[s.charAt(i)-'a']=i;
                } else {
                    base[s.charAt(i)-'a']=-2;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<26;i++) {
            if (base[i]>=0) {
                if (min>base[i]) {
                    min=base[i];
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

}

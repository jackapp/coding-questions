package misc;


public class BinaryString {

    //Assuming its a binary string
    public static void main(String[] args) {
        minFlipsRequired("1000");
    }

    public static void minFlipsRequired(String s) {
        int diff1 = checkDiff('1',s);
        int diff2 = checkDiff('0',s);
        System.out.println(diff1>diff2?diff2:diff1);
    }


    public static int checkDiff(char startingChar,String s) {
        int start = startingChar=='1'?1:0;
        int diff=0;
        boolean flag;
        if (start==1) {
            flag=true;
        } else {
            flag= false;
        }
        for (int i=0;i<s.length();i++) {
            char temp;
            if (flag) {
                temp='1';
                flag=false;
            } else {
                temp='0';
                flag=true;
            }
            if (s.charAt(i)!=temp) {
                diff++;
            }
        }
        return diff;
    }

}

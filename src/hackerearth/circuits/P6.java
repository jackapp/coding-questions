package hackerearth.circuits;

import java.io.*;
import java.util.*;

public class P6 {

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();

        while (t-->0) {
            int n = sc.nextInt();
            List<CustomObj> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(new CustomObj(sc.nextInt()));
            }

            for (int i = 0; i < n; i++) {
                arr.get(i).right=sc.nextInt();
            }

            arr.sort(new Comparator<CustomObj>() {
                @Override
                public int compare(CustomObj customObj, CustomObj t1) {
                    Long x1 = customObj.left-customObj.right;
                    Long x2 = t1.left-t1.right;

                    return x2.compareTo(x1);
                }
            });
            long cost=0;
            for (int i = 0; i < n; i++) {
                CustomObj temp = arr.get(i);
                long y = temp.left*i;
                cost+=y;
                y = temp.right*(n-i-1);
                cost+=y;

            }
            out.println(cost);
        }
        out.close();
    }

    public static class CustomObj {
        long left;
        long right;

        public CustomObj(long left) {
            this.left = left;
        }
    }
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

package codejam;

import java.util.*;

public class QRound1B {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0) {
            int x=in.nextInt();
            int y=in.nextInt();
            int n =nextPowerOf2(x+y);
            int arr[] = new int[n];
            arr[0]=1;
            for (int i=1;i<arr.length;i++) {
                arr[i]=arr[i-1]*2;
            }
            int temp[] = new int[n];
            findSum(arr,x,0,temp);
            List<Integer>list1 = findSubset(temp,x);
            List<Integer>list2 = findSubset(temp,y);
            char charArr[] = new char[n];

            List<CustomObject> objects = new ArrayList<>();
            for (int i=0;i<list1.size();i++) {
                objects.add(new CustomObject(list1.get(i),0));
            }

            for (int i=0;i<list2.size();i++) {
                objects.add(new CustomObject(list2.get(i),1));
            }

            Collections.sort(objects, new Comparator<CustomObject>() {
                @Override
                public int compare(CustomObject customObject, CustomObject t1) {
                    Integer i1 = Math.abs(customObject.val);
                    Integer i2 = Math.abs(t1.val);

                    return i1.compareTo(i2);
                }
            });
            String s="";
            for (int i=0;i<objects.size();i++) {
                if (objects.get(i).val>0) {
                    if (objects.get(i).getCoordinateAxis()==0) {
                        s=s.concat("E");
                    } else {
                        s=s.concat("N");
                    }
                } else {
                    if (objects.get(i).getCoordinateAxis()==0) {
                        s=s.concat("W");
                    } else {
                        s=s.concat("S");
                    }
                }
            }
            System.out.println(s);
        }

    }

    static class CustomObject {
        int val;
        int coordinateAxis;

        public CustomObject(int val, int coordinateAxis) {
            this.val = val;
            this.coordinateAxis = coordinateAxis;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getCoordinateAxis() {
            return coordinateAxis;
        }

        public void setCoordinateAxis(int coordinateAxis) {
            this.coordinateAxis = coordinateAxis;
        }
    }

    public static boolean findSum(int arr[],int requiredSum,int pos,int temp[]) {
        if (pos==arr.length) {
            int sum=0;
            for (int i=0;i<arr.length;i++) {
                sum+=arr[i];
            }
            if (sum==requiredSum) {
                for (int i=0;i<arr.length;i++) {
                    temp[i]=arr[i];
                }
                return true;
            } else {
                return false;
            }

        } else {
            int temp1=arr[pos];
            boolean ans =  findSum(arr,requiredSum,pos+1,temp);
            if (!ans) {

                int tempArray[] = new int[arr.length];
                for (int i=0; i<arr.length; i++)
                    tempArray[i] = arr[i];

                tempArray[pos]=-temp1;
                return findSum(tempArray,requiredSum,pos+1,temp);
            } else {
                return ans;
            }
        }

    }

    static int nextPowerOf2(int n)
    {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;
        return n-1;
    }

    public static List<Integer> findSubset(int arr[],int sum) {
        Vector<Integer> v= new Vector<Integer>();
        List<Integer> integers = new ArrayList<>();
        printAllSubsetsRec(arr, arr.length, v, sum,integers);
        return integers;
    }

    static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v,
                                            int sum, List<Integer> list)
    {
        // If remaining sum is 0, then print all
        // elements of current subset.

        if (sum == 0) {
            for (int i=0;i<v.size();i++)
                System.out.print( v.get(i) + " ");
            list.add(n);
            return;
        }

        // If no remaining elements,
        if (n == 0)
            return;

        // We consider two cases for every element.
        // a) We do not include last element.
        // b) We include last element in current subset.
        printAllSubsetsRec(arr, n - 1, v, sum,list);
        Vector<Integer> v1=new Vector<Integer>(v);
        v1.add(arr[n - 1]);
        printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1],list);
    }


}

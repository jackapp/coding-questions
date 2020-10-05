package leetcode.thirtyDay;

public class SearchInsert {

    public static void main(String[] args) {
        int arr[] = new int[] {1,3,5,6};
        searchInsert(arr,11);
    }

    public static void searchInsert(int[] nums, int target) {
        System.out.println(binarySearch(nums,target,0,(nums.length-1)/2,nums.length-1));
    }

    private static int binarySearch(int arr[],int value,int low,int mid,int high) {

        if (low == mid) {
            //Search all three values
            if (arr[low]==value ) {
                return low;
            } else if (arr[high]==value) {
                return high;
            } else {
                if (arr[low]<value) {
                    if (arr[high]<value) {
                        return high+1;
                    } else {
                        return low+1;
                    }
                } else {
                    return mid;
                }

            }
        } else {

            if (arr[mid]==value) {
                return mid;
            } else if (arr[mid]<value) {
                //Do search on the right side of the array
                int newMid = ((high-mid)/2) + mid;
                return binarySearch(arr,value,mid,newMid,high);

            } else {
                int newMid = ((mid-1 - low)/2) + low;
                return binarySearch(arr,value,low,newMid,mid-1);
            }
        }
    }

}

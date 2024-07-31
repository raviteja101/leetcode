class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int total = nums1.length+nums2.length;
        int mid = total/2;

        int arr[] = mergeArray(nums1, nums2, mid+1);

        if(total%2 != 0) {
            return (double) arr[mid];
        } 
        return (double) (arr[mid]+arr[mid-1])/2.0;

    }

    public int[] mergeArray(int[] nums1, int[] nums2, int mid) {
        
        int i = 0, j = 0, k = 0;
        int arr[] = new int[mid];

        while(i < nums1.length && j < nums2.length && k < mid) {
            if(nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while(i < nums1.length && k < mid) {
            arr[k++] = nums1[i++];
        }

        while(j < nums2.length && k < mid) {
            arr[k++] = nums2[j++];
        }

        return arr;
    }

}
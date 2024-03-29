import java.util.ArrayList;

public class MyMain {
    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to search for a value in
    // an array using binary search!

    // Examples:
    // binarySearch([5, 2, 4, 3], 4) => true
    // binarySearch([6, 7, 1, 2, 8], 5) => false

    // Wrapper Method
    public static boolean binarySearch(int[] arr, int num) {
        return binarySearchTR(arr, num, 0, arr.length-1);
    }
    // Tail recursive method:
    public static boolean binarySearchTR(int[] arr, int num, int lowerBound, int upperBound) {
        if (upperBound < lowerBound){
            return false;
        }
        else if (arr[lowerBound + (upperBound-lowerBound)/2] < num){
            return binarySearchTR(arr, num, (lowerBound + (upperBound-lowerBound)/2)+1, upperBound);
        }
        else if (arr[lowerBound + (upperBound-lowerBound)/2] > num){
            return binarySearchTR(arr, num, lowerBound, (lowerBound + (upperBound-lowerBound)/2)-1);
        }
        else if (arr[lowerBound + (upperBound-lowerBound)/2] == num){
            return true;
        }
        return false;
    }





    // ********************
    // Methods for homework:
    // ********************

    // This method does not use recursion!

    // Write a method takes two sorted arrays as input and combines them
    // into one large combined arrays.

    // Here is the pseudocode for merge:
    // * Create a new big output array
    // * Start at the beginning of both input arrays
    // * Take the smaller of the two values and add it to the output array
    // * Repeat until we’ve gone through all the values in one of the arrays
    // * Copy the remaining values from the other array into the output array

    // Here's an example of how it looks in action:
    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [                         ]
    //         ^                         ^                           ^
    //     idx1 = 0                  idx2 = 0                   outputIdx = 0

    // The current value in arr1 (1) is smaller than the current value
    // in arr2 (2). So we copy 1 into the output array. Then we increment
    // both idx1 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1,                       ]
    //            ^                      ^                              ^
    //        idx1 = 1               idx2 = 0                      outputIdx = 1

    // The current value in arr1 (4) is larger than the current value
    // in arr2 (2). So we copy 2 into the output array. Then we increment
    // both idx2 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1, 2,                     ]
    //            ^                         ^                              ^
    //        idx1 = 1                  idx2 = 1                      outputIdx = 2

    // We continue on until one of the arrays is empty
    // Then we need to copy the rest of the array
    public static int[] merge(int[] arr1, int[] arr2) {
        int j = 0;
        int i = 0;
        int k = 0;
         int [] arr3 = new int[arr1.length*2];
         while (arr3[arr3.length-1] == 0) {
             if (j >= arr1.length){
                 for (i = i; i < arr2.length; i ++){
                     arr3[k] = arr2[i];
                     k++;
                 }
             }
             else if (i >= arr2.length){
                 for (j = j; j < arr1.length; j ++){
                     arr3[k] = arr1[j];
                     k++;
                 }
             }
             else if (arr1[j] < arr2[i]) {
                 arr3[k] = arr1[j];
                 j++;
                 k++;
             }
             else if (arr1[j] > arr2[i]) {
                 arr3[k] = arr2[i];
                 i++;
                 k++;
             }

         }
        return arr3;
    }
}

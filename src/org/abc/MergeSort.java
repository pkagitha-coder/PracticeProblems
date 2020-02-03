package org.abc;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        Util.printArray(obj.sort(new int[]{2,1,3,1,2}));
        Util.printArray(obj.sort(new int[]{1,1,2,2,3}));
        //Util.printArray(obj.sort(new int[]{2,1,3}));
    }

    private int[] sort(int[] array) {
        System.out.println("num swaps:"+ mergeSort(array,new int[array.length],0,array.length -1));
        return array;
    }

    private int mergeSort(int[] array, int[] temp, int start, int end) {
        if(end <= start) {
            return 0;
        }
        int middle = (end + start)/2;
        int numSwaps = 0;
        numSwaps += mergeSort(array,temp,start,middle);
        numSwaps += mergeSort(array,temp,middle+1,end);

        return numSwaps + mergeHalves(array,temp,start,end);
    }

    private int mergeHalves(int[] array, int[] temp, int start, int end) {
        int numSwaps = 0;
        int middle = (end +start)/2;

        int leftStart = start;
        int rightStart = middle +1;
        int leftEnd = rightStart - 1;
        int rightEnd = end;

        int index = start;
        while(leftStart <= leftEnd && rightStart <=rightEnd) {
            if(array[leftStart]<=array[rightStart]) {
                temp[index] = array[leftStart];
                leftStart++;
            }else {
                temp[index] = array[rightStart];
                numSwaps += rightStart - index;
                rightStart++;

            }

            index++;
        }

        System.arraycopy(array,leftStart,temp,index,leftEnd - leftStart+1);
        System.arraycopy(array,rightStart,temp,index,rightEnd - rightStart+1);

        System.arraycopy(temp,start,array,start,end-start+1);
        return numSwaps;
    }

}

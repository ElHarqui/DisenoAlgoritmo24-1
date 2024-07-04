package charquitec.Codigo;

public class MergeSortArray {
    public void mergeSort(String[][] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        String[][] left = new String[mid][3];
        String[][] right = new String[array.length - mid][3];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }
    

    private void merge(String[][] result, String[][] left, String[][] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            int leftValue = Integer.parseInt(left[i][0]);
            int rightValue = Integer.parseInt(right[j][0]);
            if (leftValue <= rightValue) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

}
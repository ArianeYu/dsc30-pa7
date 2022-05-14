/**
 * PA7 Part 1 worksheet (style not required)
 */
public class Worksheet {

    /**
     * method that stores the result of Q1 in PA7 worksheet
     * @return heap's array representation after insertions
     */
    public static int[] insertionResult(){
        /*
        TODO: replace the values with the heap's array representations
         */
        int[] output =  new int[]{95, 80, 88, 57, 66, 80, 69, 20, 55, 52, 61, 23};
        return output;
    }

    /**
     * method that stores the result of Q2 in PA7 worksheet
     * @return heap's array representations for each iteration of element removal, 5 iterations in total
     */
    public static int[][] removalResult(){
        /*
        TODO: store the values with the heap's array representations for each removal iteration
         */
        int[][] output = new int[5][12];
        output[0] = new int[]{30, 34, 46, 64, 39, 93, 96, 101, 91, 73, 100, 0};
        output[1] = new int[]{34, 39, 46, 64, 73, 93, 96, 101, 91, 100, 0, 0};
        output[2] = new int[]{39, 64, 46, 91, 73, 93, 96, 101, 100, 0, 0, 0};
        output[3] = new int[]{46, 64, 93, 91, 73, 100, 96, 101, 0, 0, 0, 0};
        output[4] = new int[]{64, 73, 93, 91, 101, 100, 96, 0, 0, 0, 0, 0};
        return output;
    }

    /**
     * method that stores the result of Q3 in PA7 worksheet
     * @return heap's array representations for d-ary heaps, where d = 3,4
     */
    public static int[][] dResult(){
        /*
        TODO: store 3-ary heap's array representation output[0] and store 4-ary representation in output[1]
         */
        int[][] output = new int[2][11];
        output[0] = new int[]{89, 70, 87, 85, 27, 52, 59, 29, 72, 79, 85};
        output[1] = new int[]{89, 87, 85, 46, 52, 27, 59, 70, 72, 27, 79};
        return output;
    }

    /**
     * method that stores the result of Q4 in PA7 worksheet
     * @return array representations
     */
    public static int[][] heapOperations(){
        /*
        TODO: store heap's array status after multiples operations - operation i will be stored at index i-1
         */
        int[][] output = new int[5][12];
        output[0] = new int[]{75, 72, 60, 74, 46, 56, 37, 43, 49, 0, 0, 0};
        output[1] = new int[]{91, 72, 60, 75, 46, 56, 37, 43, 49, 25, 74, 0};
        output[2] = new int[]{75, 72, 60, 74, 46, 56, 37, 43, 49, 25, 0, 0};
        output[3] = new int[]{75, 72, 60, 74, 46, 56, 37, 43, 49, 25, 39, 72};
        output[4] = new int[]{56, 46, 49, 25, 43, 39, 37, 0, 0, 0, 0, 0};
        return output;
    }
}

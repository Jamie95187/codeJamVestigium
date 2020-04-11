import java.util.*;

public class Vestigium {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String testCasesAsString = input.nextLine();
        int testCases = Integer.parseInt(testCasesAsString);
        ArrayList<int[][]> matrixArray = new ArrayList<int[][]>();
        for(int t = 0; t < testCases; t++){
            String matrixSizeAsString = input.nextLine();
            int matrixSize = Integer.parseInt(matrixSizeAsString);
            int[][] matrix = new int[matrixSize][matrixSize];
            for(int r = 0; r < matrixSize; r++){
                String[] row = input.nextLine().split(" ");
                for(int i = 0; i < matrixSize; i++){
                    matrix[r][i] = Integer.parseInt(row[i]);
                }
            }
            matrixArray.add(matrix);
        }
        input.close();
        output(matrixArray);
    }


    static void output(ArrayList<int[][]> matrixArray){
        int count = 1;
        for(int[][] matrix : matrixArray){
            int[][] transposedMatrix = new int[matrix.length][matrix.length];
            transposedMatrix = transpose(matrix);
            // System.out.println("Duplicates ====== " + solveDuplicates(matrix));
            // solveDuplicates(matrix);
            System.out.println("Case #" + count + ": " + solveTrace(matrix) + " " + solveDuplicates(matrix) + " " + solveDuplicates(transposedMatrix));
            count += 1;
        }
    }

    // Case #x: k (R) (C)
    static int solveDuplicates(int[][] matrix){
        int count = 0;
        for(int[] rows : matrix){
            if(duplicate(rows)){
                count+=1;
            }
        }
        return count;
    }

    static boolean duplicate(int[] row){
        Set<Integer> lump = new HashSet<Integer>();
        for(int i : row){
            // System.out.println(i);
            if(lump.contains(i)){
                return true;
            } else {
                lump.add(i);
            }
        }
        return false;
    }

    static int[][] transpose(int[][] matrix){
        int[][] transposedMatrix = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    static int solveTrace(int[][] matrix){
        int trace = 0;
        for(int i = 0; i < matrix.length; i++){
            trace += matrix[i][i];
        }
        return trace;
    }
}

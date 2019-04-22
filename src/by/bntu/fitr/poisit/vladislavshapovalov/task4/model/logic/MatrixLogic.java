package by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic;

import by.bntu.fitr.poisit.vladislavshapovalov.task4.model.entity.Matrix;
import java.util.Scanner;
import org.apache.log4j.Logger;
/**
 *
 * @author MICKEY
 */

public class MatrixLogic {    
     
     private static final Logger LOG;
    
    static {
        LOG = Logger.getRootLogger();
    }
    
    
    public static int[][] inputMatrix(int height, int width, int minRange, int maxRange) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String text = String.format("Enter matrix element [%d][%d]: ", i, j);
                matrix[i][j] = read(text, minRange, maxRange);
            }
        }
        return matrix;
    }
 
    public static boolean checkSymmetry(Matrix matrix) { 
        boolean result;
        if (result = matrix.getCountRows() > 1 && matrix.getCountRows() == matrix.getCountColumns()) {
            for (int i = 1; i < matrix.getCountRows(); i++) {
                for (int j = 0; j < matrix.getCountColumns(); j++) {
                    if (matrix.getElement(i, j) != matrix.getElement(i, j)) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
 
    public static int getMaxToMatrix(Matrix matrix) { 
        int max = 0;
        if (matrix != null && matrix.getCountRows() > 0 && matrix.getCountColumns() > 0) {
            max = matrix.getElement(0, 0);
            for (int[] line : matrix) {
                for (int number : line) {
                    if (max < number) {
                        max = number;
                    }
                }
            }
        }
        return max;
    }
 
    public static void replaceLocalMinimum(Matrix matrix, int replaceNumber) {
        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    matrix.getElement(i, j) = replaceNumber;
                }
            }
        }
    }
 
    public static boolean isLocalMinimum(Matrix matrix, int i, int j) { 
        boolean result = true;
        for (int k = i - 1; k <= i + 1; k++) {
            if (k == -1 || k == matrix.getCountRows()) {
                continue;
            }
            for (int m = j - 1; m < j + 1; m++) {
                if (m == -1 || m == matrix.getCountColumns() || (m == j && k == i)) {
                    continue;
                }
                if (matrix.getElement(i, j) >= matrix.getElement(k, m)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
 
    public static int getMinToMatrix(Matrix matrix) { 
        int min = 0;
        if (matrix != null && matrix.getCountRows() > 0 && matrix.getCountColumns() > 0) {
            min = matrix.getElement(0, 0);
            for (int[] line : matrix) {
                for (int number : line) {
                    if (min > number) {
                        min = number;
                    }
                }
            }
        }
        return min;
    }
 
    public static String matrixToString(Matrix matrix, int maxLengthNumber) {
        StringBuilder sb = new StringBuilder();
        String tab = String.format("%s%d%s", "%", maxLengthNumber + 2, "d");
        for (int[] line : matrix) {
            sb.append("|");
            for (int number : line) {
                sb.append(String.format(tab, number));
            }
            sb.append("|").append("\n");
        }
        return sb.toString();
    }

    public static int read(String text, int min, int max) {
        int result = 0;
        Scanner read = new Scanner(System.in);
        boolean incorrect = true;
        while (incorrect) {
            LOG.trace(text);
            String line = read.nextLine().trim();
            if (line.matches("[+-]*\\d+")) {
                result = Integer.parseInt(line);
                if (incorrect = result < min || result > max) {
                    LOG.error("Error: The number does not satisfy the range. Try again...");
                }
            } else {
                LOG.error("Error: You did not enter a number. Try again...");
            }
        }
        return result;
    }
}
   

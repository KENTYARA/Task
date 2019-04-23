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
    
    
    public static Matrix createRandomized(Matrix matrix){
        for(int i = 0; i < matrix.getCountRows(); i++){
            for(int j = 0; j < matrix.getCountColumns(); j++){
                matrix.setElement(i, j, (int)(Math.random() * matrix.getCountColumns()) + 1);
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
 
 
    public static void replaceLocalMinimum(Matrix matrix, int replaceNumber) {
        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    matrix.setElement(i, j,replaceNumber);
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
   

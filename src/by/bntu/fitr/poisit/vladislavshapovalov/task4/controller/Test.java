package by.bntu.fitr.poisit.vladislavshapovalov.task4.controller;

import by.bntu.fitr.poisit.vladislavshapovalov.task4.model.entity.Matrix;
import static by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic.inputMatrix;
import static by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic.read;
import static by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic.matrixToString;
import static by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic.checkSymmetry;
import static by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic.getMaxToMatrix;
import static by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic.getMinToMatrix;
import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
/**
 *
 * @author MICKEY
 */

public class Test {
    
    private static final Logger LOG;
    
    static {
        LOG = Logger.getRootLogger();
    }
    
   
    
    public static void main(String[] args) {
        
    
        int height = read("Enter the number of rows of your matrix: ", 1, 20);
        int width = read("Enter the number of columns of your matrix: ", 1, 20);

        int[][] matrix = inputMatrix(height, width, -10, 10);
 
        LOG.trace(matrixToString(matrix, 2));
        LOG.trace("The minimum value of the matrix:  " + getMinToMatrix(matrix));
        LOG.trace("The maximum value of the matrix: " + getMaxToMatrix(matrix));
        LOG.trace("Is the matrix symmetric with respect to the main diagonal?: " + checkSymmetry(matrix));
 
        LOG.trace("Replace all local minima with 0: ");
        replaceLocalMinimum(matrix, 0);
        LOG.trace(matrixToString(matrix, 2));
 
        LOG.trace("Is the matrix symmetric about the main diagonal now?: " + checkSymmetry(matrix));
 
    }
}

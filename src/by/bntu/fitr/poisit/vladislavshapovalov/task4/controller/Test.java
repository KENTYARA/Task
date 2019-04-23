package by.bntu.fitr.poisit.vladislavshapovalov.task4.controller;

import by.bntu.fitr.poisit.vladislavshapovalov.task4.model.entity.Matrix;
import by.bntu.fitr.poisit.vladislavshapovalov.task4.model.logic.MatrixLogic;
import org.apache.log4j.Logger;

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
        
    
        int height = MatrixLogic.read("Enter the number of rows of your matrix: ", 1, 20);
        int width = MatrixLogic.read("Enter the number of columns of your matrix: ", 1, 20);
        Matrix matrix = new Matrix(height,width);
        
        MatrixLogic.createRandomized(matrix);
 
        LOG.trace(matrix);
        
        LOG.trace("Is the matrix symmetric with respect to the main diagonal?: " + MatrixLogic.checkSymmetry(matrix));
 
        LOG.trace("Replace all local minima with 0: ");
        MatrixLogic.replaceLocalMinimum(matrix, 0);
        LOG.trace(matrix);
 
        LOG.trace("Is the matrix symmetric about the main diagonal now?: " + MatrixLogic.checkSymmetry(matrix));
 
    }
}

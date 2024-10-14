package ce306.shapoval.lab4;
/**
* Class <code>Equations</code> implements method for ( y = 1/ctg(2x)) expression
* calculation
* @author Shapoval
* @version 1.0
*/
public class Equation {
    
    /**
     * Calculate value of ( y = 1/ctg(2x)) expression for a given angle x in
     * degrees.
     * @param x angle in degrees
     * @return value of ( y = 1/ctg(2x)) for given angle x
     * @throws CalcException if given argument is equal or near to 45 degrees
     */
    public double calculate(double x) throws CalcException {
        x = x % 90;
        double y;
        double rad = x * Math.PI / 180;
        
        try {
            y = Math.tan(2 * rad);
            if (y == Double.NaN ||
                y == Double.POSITIVE_INFINITY ||
                y == Double.NEGATIVE_INFINITY ||
                x == -45.0 ||
                x == 45.0
                ) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            if (x == 45.0 || x == -45.0) {
                throw new CalcException("Exception reason: Illegal value of x");
            } else {
                throw new CalcException("Unknown reason");
            }
        }

        return y;
    }
}
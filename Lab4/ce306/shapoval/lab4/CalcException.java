package ce306.shapoval.lab4;

/**
* Class <code>CalcException</code> more precises ArithmeticException
* @author Shapoval
* @version 1.0
*/
class CalcException extends ArithmeticException {
    public CalcException(){}

    public CalcException(String cause) {
        super(cause);
    }
}
import org.assertj.core.api.AbstractAssert;

public class QuadraticFunctionAssert extends AbstractAssert<QuadraticFunctionAssert, QuadraticFunction> {
    
    public QuadraticFunctionAssert(QuadraticFunction actual) {
        super(actual, QuadraticFunctionAssert.class);
    }
    
    public static QuadraticFunctionAssert assertThat(QuadraticFunction actual) {
        return new QuadraticFunctionAssert(actual);
    }
    
    public QuadraticFunctionAssert hasA(double a) {
        isNotNull();
        
        if ( actual.getA() != a ) {
            failWithMessage("Expected a to be <%s> but was <%s>", a, actual.getA());
        }
        return this;
    }
    
    public QuadraticFunctionAssert hasB(double b) {
        isNotNull();
        
        if ( actual.getB() != b ) {
            failWithMessage("Expected b to be <%s> but was <%s>", b, actual.getB());
        }
        return this;
    }
    
    public QuadraticFunctionAssert hasC(double c) {
        isNotNull();
        
        if ( actual.getC() != c ) {
            failWithMessage("Expected c to be <%s> but was <%s>", c, actual.getC());
        }
        return this;
    }
    
    public QuadraticFunctionAssert hasX1(double x1) {
        isNotNull();
        
        if ( actual.getX1() != x1 ) {
            failWithMessage("Expected x1 to be <%s> but was <%s>", x1, actual.getX1());
        }
        return this;
    }
    
    public QuadraticFunctionAssert hasX2(double x2) {
        isNotNull();
        
        if ( actual.getX2() != x2 ) {
            failWithMessage("Expected x2 to be <%s> but was <%s>", x2, actual.getX2());
        }
        return this;
    }
    
    public QuadraticFunctionAssert hasSameSolutions(double solution) {
        isNotNull();
        
        if ( solution != actual.getX1() && solution != actual.getX2() ) {
            failWithMessage("Expected x1 to be equal x2 (<%s>) but was <%s>", solution, actual.getX2());
        }
        return this;
    }
    
    public QuadraticFunctionAssert hasOppositeSolutions(double solution) {
        isNotNull();
        
        if ( actual.getX1() > actual.getX2() ) {
            if ( solution != actual.getX1() && solution != (-1) * actual.getX2() ) {
                failWithMessage("Expected x1 to be equal opposite of x2 (<%s>) but was <%s>", solution, actual.getX2());
            }
        } else {
            if ( solution != (-1) * actual.getX1() && solution != actual.getX2() ) {
                failWithMessage("Expected x2 to be equal opposite of x1 (<%s>) but was <%s>", solution, actual.getX1());
            }
        }
        return this;
    }
    
}
import org.assertj.core.api.AbstractAssert;

import java.util.concurrent.Callable;

public class QuadraticFunctionExceptionAssert extends AbstractAssert<QuadraticFunctionExceptionAssert, Callable<?>> {
    
    public QuadraticFunctionExceptionAssert(Callable<?> actual) {
        super(actual, QuadraticFunctionExceptionAssert.class);
    }
    
    public static QuadraticFunctionExceptionAssert assertThat(Callable<?> actual) {
        return new QuadraticFunctionExceptionAssert(actual);
    }
    
    public QuadraticFunctionExceptionAssert throwsException(Class<?> clazz) {
        isNotNull();
        
        try {
            actual.call();
            failWithMessage("Expected to throw exception but nothing was thrown");
        } catch ( Throwable t ) {
            if ( !t.getClass()
                    .equals(clazz) ) {
                failWithMessage("Expected exception to be instance of <%s> but was <%s>", clazz, t.getClass());
            }
        }
        return this;
    }
    
}

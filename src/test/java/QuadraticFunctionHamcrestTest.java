import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class QuadraticFunctionHamcrestTest {
    
    @Test
    public void shouldThrowExceptionWithAllZeros() throws Exception {
        assertThat(exceptionOf(() -> QuadraticFunction.of(0, 0, 0)), instanceOf(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithNoQuadraticFunction() throws Exception {
        assertThat(exceptionOf(() -> QuadraticFunction.of(0, 3, 5)), instanceOf(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithPositiveInfinities() throws Exception {
        assertThat(exceptionOf(() -> QuadraticFunction.of(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)),
                instanceOf(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeInfinities() throws Exception {
        assertThat(exceptionOf(() -> QuadraticFunction.of(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY)),
                instanceOf(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldContainSameValuesWithDeltaEqualToZero() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(2, 4, 2);
        assertThat(quadraticFunction, allOf(QuadraticFunctionMatcher.hasA(2), QuadraticFunctionMatcher.hasB(4), QuadraticFunctionMatcher.hasC(2),
                QuadraticFunctionMatcher.hasSameSolutions(-1)));
    }
    
    @Test
    public void shouldContainDifferentValuesWithDeltaGreaterThanZero() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(10, 12, 2);
        assertThat(quadraticFunction, allOf(QuadraticFunctionMatcher.hasA(10), QuadraticFunctionMatcher.hasB(12), QuadraticFunctionMatcher.hasC(2),
                QuadraticFunctionMatcher.hasX1(-1), QuadraticFunctionMatcher.hasX2(-0.2)));
    }
    
    @Test
    public void shouldContainSameValuesWhenOnlyAIsGiven() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(2, 0, 0);
        assertThat(quadraticFunction, allOf(QuadraticFunctionMatcher.hasA(2), QuadraticFunctionMatcher.hasB(0), QuadraticFunctionMatcher.hasC(0),
                QuadraticFunctionMatcher.hasSameSolutions(0)));
    }
    
    @Test
    public void shouldContainDifferentValuesWhenGivenAAndNegativeC() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(2, 0, -3);
        assertThat(quadraticFunction, allOf(QuadraticFunctionMatcher.hasA(2), QuadraticFunctionMatcher.hasB(0), QuadraticFunctionMatcher.hasC(-3),
                QuadraticFunctionMatcher.hasOppositeSolutions(1.224744871391589)));
    }
    
    @Test
    public void shouldThrowExceptionWhenGivenOnlyAAndC() throws Exception {
        assertThat(exceptionOf(() -> QuadraticFunction.of(1, 0, 3)),
                instanceOf(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeDelta() throws Exception {
        assertThat(exceptionOf(() -> QuadraticFunction.of(10, 6, 2)),
                instanceOf(IllegalArgumentException.class));
    }
    
    private static Throwable exceptionOf(Callable<?> callable) throws Exception {
        try {
            callable.call();
            return null;
        } catch ( Throwable t ) {
            return t;
        }
    }
    
}
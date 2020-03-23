import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class QuadraticFunctionHamcrestTest {
    
    @Test
    public void shouldThrowExceptionWithAllZeros() {
        assertThat(() -> QuadraticFunction.of(0, 0, 0), QuadraticFunctionExceptionMatcher.throwsException(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithNoQuadraticFunction() {
        assertThat(() -> QuadraticFunction.of(0, 3, 5), QuadraticFunctionExceptionMatcher.throwsException(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithPositiveInfinities() {
        assertThat(() -> QuadraticFunction.of(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
                QuadraticFunctionExceptionMatcher.throwsException(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeInfinities() {
        assertThat(() -> QuadraticFunction.of(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
                QuadraticFunctionExceptionMatcher.throwsException(IllegalArgumentException.class));
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
        assertThat(() -> QuadraticFunction.of(1, 0, 3),
                QuadraticFunctionExceptionMatcher.throwsException(IllegalArgumentException.class));
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeDelta() throws Exception {
        assertThat(() -> QuadraticFunction.of(10, 6, 2),
                QuadraticFunctionExceptionMatcher.throwsException(IllegalArgumentException.class));
    }
    
}
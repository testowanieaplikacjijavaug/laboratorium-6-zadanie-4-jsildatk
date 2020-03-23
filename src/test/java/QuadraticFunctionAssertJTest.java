import org.junit.jupiter.api.Test;

public class QuadraticFunctionAssertJTest {
    
    @Test
    public void shouldThrowExceptionWithAllZeros() {
        QuadraticFunctionExceptionAssert.assertThat(() -> QuadraticFunction.of(0, 0, 0))
                .throwsException(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithNoQuadraticFunction() {
        QuadraticFunctionExceptionAssert.assertThat(() -> QuadraticFunction.of(0, 3, 5))
                .throwsException(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithPositiveInfinities() {
        QuadraticFunctionExceptionAssert.assertThat(
                () -> QuadraticFunction.of(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY))
                .throwsException(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeInfinities() {
        QuadraticFunctionExceptionAssert.assertThat(
                () -> QuadraticFunction.of(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY))
                .throwsException(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldContainSameValuesWithDeltaEqualToZero() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(2, 4, 2);
        QuadraticFunctionAssert.assertThat(quadraticFunction)
                .hasA(2)
                .hasB(4)
                .hasC(2)
                .hasSameSolutions(-1);
    }
    
    @Test
    public void shouldContainDifferentValuesWithDeltaGreaterThanZero() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(10, 12, 2);
        QuadraticFunctionAssert.assertThat(quadraticFunction)
                .hasA(10)
                .hasB(12)
                .hasC(2)
                .hasX1(-1)
                .hasX2(-0.2);
    }
    
    @Test
    public void shouldContainSameValuesWhenOnlyAIsGiven() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(2, 0, 0);
        QuadraticFunctionAssert.assertThat(quadraticFunction)
                .hasA(2)
                .hasB(0)
                .hasC(0)
                .hasSameSolutions(0);
    }
    
    @Test
    public void shouldContainDifferentValuesWhenGivenAAndNegativeC() {
        QuadraticFunction quadraticFunction = QuadraticFunction.of(2, 0, -3);
        QuadraticFunctionAssert.assertThat(quadraticFunction)
                .hasA(2)
                .hasB(0)
                .hasC(-3)
                .hasOppositeSolutions(1.224744871391589);
    }
    
    @Test
    public void shouldThrowExceptionWhenGivenOnlyAAndC() {
        QuadraticFunctionExceptionAssert.assertThat(() -> QuadraticFunction.of(1, 0, 3))
                .throwsException(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeDelta() {
        QuadraticFunctionExceptionAssert.assertThat(() -> QuadraticFunction.of(10, 6, 2))
                .throwsException(IllegalArgumentException.class);
    }
    
}
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuadraticFunctionAssertJTest {
    
    @Test
    public void shouldThrowExceptionWithAllZeros() {
        assertThatThrownBy(() -> QuadraticFunction.of(0, 0, 0)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithNoQuadraticFunction() {
        assertThatThrownBy(() -> QuadraticFunction.of(0, 3, 5)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithPositiveInfinities() {
        assertThatThrownBy(() -> QuadraticFunction.of(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)).isInstanceOf(
                IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeInfinities() {
        assertThatThrownBy(() -> QuadraticFunction.of(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY)).isInstanceOf(
                IllegalArgumentException.class);
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
        assertThatThrownBy(() -> QuadraticFunction.of(1, 0, 3)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void shouldThrowExceptionWithNegativeDelta() {
        assertThatThrownBy(() -> QuadraticFunction.of(10, 6, 2)).isInstanceOf(IllegalArgumentException.class);
    }
    
}
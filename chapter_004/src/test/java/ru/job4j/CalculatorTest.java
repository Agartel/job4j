package ru.job4j;
import org.junit.Test;
import ru.job4j.lambda.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<Double>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadreanFunctionThenQuadreanResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenCubeanFunctionThenCubeanResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> Math.pow(x, 3) + 1);
        List<Double> expected = Arrays.asList(126D, 217D, 344D);
        assertThat(result, is(expected));
    }
}

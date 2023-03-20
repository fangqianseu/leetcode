package basic.calculator;

import basic.calculator.sdk.CalculatorFactory;
import basic.calculator.sdk.ICalculator;

import java.util.Objects;

/**
 * @author qianfang, at 2023/3/20, 00:13
 **/
public class CalculatorTest {
    public static void main(String[] args) {
        ICalculator calculator = CalculatorFactory.getCalculator(3);

        if (!Objects.equals(2.0, calculator.init(2).add(3).undo().getVal())) {
            throw new RuntimeException("not equal");
        }

        calculator.reset();
        if (!Objects.equals(2.0, calculator.init(2).add(3).subtract(1).multiply(2).divide(4).getVal())) {
            throw new RuntimeException("not equal");
        }

        calculator.reset();
        if (!Objects.equals(5.0, calculator.init(2).add(3).undo().redo().getVal())) {
            throw new RuntimeException("not equal");
        }

        calculator.reset();
        if (!Objects.equals(5.0, calculator.init(2).add(3).add(5).undo().undo().redo().getVal())) {
            throw new RuntimeException("not equal");
        }

        calculator.reset();
        if (!Objects.equals(21.0, calculator.init(1).add(2).add(3).add(4).add(5).add(6).add(7).undo().getVal())) {
            throw new RuntimeException("not equal");
        }

        calculator.reset();
        calculator.init(1).add(Double.MAX_VALUE).add(Double.MAX_VALUE).getVal();
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;
import tpo.SinPowerSeries;

public class SinTest {
    @Test
    @DisplayName("Сравниваем результаты приближения и Math.sin в диапазоне [-PI; PI]")
    void testDiffBetweenSinAndPowerSeries() {
        int divisor = 30;
        double maximum_deviation = 0.001;
        for (int divisible = 0; divisible < divisor * 2 + 1; ++divisible) {
            double check_value = Math.PI * (divisible - divisor) / divisor;
            double diff = Math.abs(SinPowerSeries.calcWithPowerSeries(check_value) - Math.sin(check_value));
            Assertions.assertTrue(diff < maximum_deviation, "Получено отклонение: " + diff + ", максимально допустимое: "
                    + maximum_deviation + ", check_value = " + check_value);
        }
    }
}

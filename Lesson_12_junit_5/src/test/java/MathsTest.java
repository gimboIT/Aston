import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MathsTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    @DisplayName("Вычисление факториала")
    void getFactorial(int number, int result) {
        assertEquals(Maths.getFactorial(number), result);
    }
}
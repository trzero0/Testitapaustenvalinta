import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.TimeUtils;

public class TimeUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "0, 0:00:00",
        "59, 0:00:59",
        "60, 0:01:00",
        "3599, 0:59:59",
        "3600, 1:00:00",
        "3665, 1:01:05",
        "86399, 23:59:59",
        "86400, 24:00:00",
        "86401, Error", // Tarkista, miten metodi käsittelee suuria arvoja (yli 24 tuntia)
        "999999999, Error", // Tarkista, miten metodi käsittelee suuria arvoja (yli 24 tuntia)
        "-1, Error", // Olettaen, että metodi palauttaa "Error" virheellisillä syötteillä
    })
    void testSecToTime(int seconds, String expected) {
        assertEquals(expected, TimeUtils.secToTime(seconds));
    }
}
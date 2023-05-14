import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static program.Calculator.*;

public class Calculator_Test
{

    @Test
    @Tag("unit")
    @Tag("blackbox")
    void Test_compute_total_mark_positiveTesting()
    {
        int activitiesMark = 8;
        int oralPracticalMark = 0;
        int midtermMark = 20;
        int finalMark = 59;

        int expectedValue = 87;

        int actualValue = compute_total_mark(activitiesMark,oralPracticalMark,midtermMark,finalMark);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=97 && values <=100")
    @ValueSource(ints= {97,98,100})
    void Test_compute_Grade_valuesBetween97And100_gradeAPlus(int grade)
    {
        String expectedValue = "A+";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=93 && values <97")
    @ValueSource(ints= {93,95,96})
    void Test_compute_Grade_valuesBetween93And96_gradeA(int grade)
    {
        String expectedValue = "A";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=89 && values <93")
    @ValueSource(ints= {89,91,92})
    void Test_compute_Grade_valuesBetween89And92_gradeAMinus(int grade)
    {
        String expectedValue = "A-";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=84 && values <89")
    @ValueSource(ints= {84,86,88})
    void Test_compute_Grade_valuesBetween84And88_gradeBPlus(int grade)
    {
        String expectedValue = "B+";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=80 && values <84")
    @ValueSource(ints= {80,82,83})
    void Test_compute_Grade_valuesBetween80And83_gradeB(int grade)
    {
        String expectedValue = "B";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=76 && values <80")
    @ValueSource(ints= {76,78,79})
    void Test_compute_Grade_valuesBetween76And79_gradeBMinus(int grade)
    {
        String expectedValue = "B-";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=73 && values <76")
    @ValueSource(ints= {73,74,75})
    void Test_compute_Grade_valuesBetween73And75_gradeCPlus(int grade)
    {
        String expectedValue = "C+";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=70 && values <73")
    @ValueSource(ints= {70,71,72})
    void Test_compute_Grade_valuesBetween70And72_gradeC(int grade)
    {
        String expectedValue = "C";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=67 && values <70")
    @ValueSource(ints= {67,68,69})
    void Test_compute_Grade_valuesBetween67And69_gradeCMinus(int grade)
    {
        String expectedValue = "C-";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=64 && values <67")
    @ValueSource(ints= {64,65,66})
    void Test_compute_Grade_valuesBetween64And66_gradeDPlus(int grade)
    {
        String expectedValue = "D+";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=60 && values <64")
    @ValueSource(ints= {60,61,63})
    void Test_compute_Grade_valuesBetween60And63_gradeD(int grade)
    {
        String expectedValue = "D";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @Tag("unit")
    @Tag("blackbox")
    @Tag("BVA_strategy")
    @DisplayName("Test values >=0 && values <60")
    @ValueSource(ints= {0,1,30,58,59})
    void Test_compute_Grade_valuesBetween0And59_gradeF(int grade)
    {
        String expectedValue = "F";

        String actualValue = compute_Grade(grade);

        assertThat(actualValue).isEqualTo(expectedValue);
    }
}

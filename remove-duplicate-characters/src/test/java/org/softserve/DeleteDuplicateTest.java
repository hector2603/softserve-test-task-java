package org.softserve;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteDuplicateTest {

    private DeleteDuplicate deleteDuplicate;

    @BeforeEach
    public void setUp() {
        deleteDuplicate = new DeleteDuplicate();
    }

    @DisplayName("Test DeleteDuplicate with multiple inputs")
    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    @CsvSource({
            "'AABBCCD112233', 'ABCD123'",
            "'AAABBBCCC', 'ABC'",
            "'1122334455', '12345'",
            "'', ''",
            "'AAAAAA', 'A'",
            "'!@#$%^&*()', '!@#$%^&*()'",
            "' A B C ', ' ABC'",
            "'AaBbCc', 'AaBbCc'",
            "'\nA\nB\nC\n', '\nABC'",
            "'\tA\tB\tC\t', '\tABC'",
            "'\rA\rB\rC\r', '\rABC'",
    })
    public void testDeleteDuplicate(String input, String expected) {
        String actual = deleteDuplicate.deleteDuplicate(input);
        assertEquals(expected, actual);
    }

    @DisplayName("Test DeleteDuplicate when input is null")
    @Test
    public void testDeleteDuplicateWhenInputIsNull() {
        String actual = deleteDuplicate.deleteDuplicate(null);
        assertEquals(null, actual);
    }


}

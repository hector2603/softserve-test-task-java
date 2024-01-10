package org.softserve;

import java.util.stream.Collectors;

/**
 * Delete duplicate characters from string
 * author Héctor Ocampo
 */
public class DeleteDuplicate {

    /**
     * @param input string with duplicates
     * @return string without duplicates
     */
    public String deleteDuplicate(String input) {
        if(input == null || input.isEmpty()){
            return input;
        }
        return input.chars()
                .distinct()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}

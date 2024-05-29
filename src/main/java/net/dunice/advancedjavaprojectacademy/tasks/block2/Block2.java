package net.dunice.advancedjavaprojectacademy.tasks.block2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Block2 implements Block2Interface {
    @Override
    public <T> Collection<T> getWithoutDublicates(Collection<T> collection) {
        return collection.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public <T> T[] arrayIterator(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
        return array;
    }

    @Override
    public Integer countNumber(Integer number) {
        return Math.toIntExact(IntStream.range(0, number + 1)
                .filter(i -> Integer.valueOf(i).toString().contains("2"))
                .count());
    }

    @Override
    public boolean isPermutationStrings(String str1, String str2) {
        var sizeStr1 = Stream.of(str1.split(" ")).filter(item -> !Objects.equals(item, "")).toList().size();
        var sizeStr2 = Stream.of(str2.split(" ")).filter(item -> !Objects.equals(item, "")).toList().size();
        if (sizeStr1 == sizeStr2) {
            return Stream.of((str1 + " " + str2).split(" "))
                    .filter(item -> !Objects.equals(item, ""))
                    .map(item -> item
                            .chars()
                            .sorted()
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString())
                    .distinct()
                    .sorted()
                    .toList()
                    .size() == sizeStr1;
        }
        return false;
    }

    @Override
    public String getCompressedString(String noCompressedString) {
        if (noCompressedString == null || noCompressedString.isEmpty()) {
            return noCompressedString;
        }
        StringBuilder compressed = new StringBuilder();
        IntStream charStream = noCompressedString.chars();
        var iterator = charStream.iterator();
        char currentChar = (char) iterator.nextInt();
        int count = 1;
        while (iterator.hasNext()) {
            char nextChar = (char) iterator.nextInt();
            if (nextChar == currentChar) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = nextChar;
                count = 1;
            }
        }
        compressed.append(currentChar).append(count);
        String compressedString = compressed.toString();
        return compressedString.length() < noCompressedString.length() ? compressedString : noCompressedString;
    }

    @Override
    public Character getFrequencyCharacter(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        IntStream charStream = source.chars();
        var iterator = charStream.iterator();
        char currentChar = (char) iterator.nextInt();
        while (iterator.hasNext()) {
            char nextChar = (char) iterator.nextInt();
            if (nextChar == currentChar) {
                return currentChar;
            } else {
                currentChar = nextChar;
            }
        }
        return null;
    }

    @Override
    public boolean isStringValid(String givenString) {
        if (givenString == null || givenString.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : givenString.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public String getModifyingString(String noBracketsString) {
        if (noBracketsString == null || noBracketsString.isEmpty()) {
            return noBracketsString;
        }
        StringBuilder result = new StringBuilder();
        String bracket;
        String input;
        for (int i = 0; i < noBracketsString.length(); i++) {
            bracket = i < noBracketsString.length() / 2 + 1 ? "(" : ")";
            input = (noBracketsString.length() % 2 == 0 && i == noBracketsString.length() / 2) ? ")" : "";
            result.append(bracket).append(input).append(noBracketsString.charAt(i));
        }
        return result + ")";
    }

    @Override
    public String getValidStringNoSpaces(String string) {
        return null;
    }

    @Override
    public int numberOfIdenticalPairs(int[] nums) {
        return 0;
    }
}


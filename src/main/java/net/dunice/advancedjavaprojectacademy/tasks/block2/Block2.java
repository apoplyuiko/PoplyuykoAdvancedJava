package net.dunice.advancedjavaprojectacademy.tasks.block2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Block2 implements Block2Interface {
    @Override
    public <T> Collection<T> getWithoutDublicates(Collection<T> collection) {
        return new LinkedHashSet<>(collection);
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
        if (number == null || number < 2) {
            return 0;
        }
        return IntStream.range(0, number + 1)
                .map(i ->
                        (int) Integer.valueOf(i)
                                .toString()
                                .chars()
                                .filter(j -> j == '2').count())
                .filter(i -> i > 0)
                .reduce(Integer::sum).orElse(0);
    }

    @Override
    public boolean isPermutationStrings(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
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
            switch (ch) {
                case '{', '[', '(' -> stack.push(ch);
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                default -> {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public String getModifyingString(String noBracketsString) {
        if (noBracketsString == null) {
            return null;
        } else if (noBracketsString.isEmpty()) {
            return "()";
        } else {
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
    }

    @Override
    public String getValidStringNoSpaces(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return Stream.of(string.split(" ")).filter(item -> !Objects.equals(item, "")).collect(Collectors.joining(" "));
    }

    @Override
    public int numberOfIdenticalPairs(int[] array) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int item : array) {
            var getValue = pairs.getOrDefault(item, 0) + 1;
            pairs.put(item, getValue);
        }
        int count = 0;
        for (int frequency : pairs.values()) {
            if (frequency > 1) {
                count += (frequency * (frequency - 1)) / 2;
            }
        }
        return count;
    }
}


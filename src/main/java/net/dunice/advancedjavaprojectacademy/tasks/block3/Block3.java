package net.dunice.advancedjavaprojectacademy.tasks.block3;

import net.dunice.advancedjavaprojectacademy.tasks.Sex;
import net.dunice.advancedjavaprojectacademy.tasks.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Block3 implements Block3Interface {
    @Override
    public List<Student> getAgendaList(List<Student> studentList) {
        return studentList.stream()
                .filter(item -> item.sex() == Sex.MAN && (item.age() <= 27 && item.age() >= 18))
                .toList();
    }

    @Override
    public List<Student> getJobList(List<Student> studentList) {
        return studentList.stream()
                .filter(item ->
                        (item.sex() == Sex.MAN && item.age() <= 60 && item.age() >= 18) ||
                                (item.sex() == Sex.WOMAN && item.age() <= 55 && item.age() >= 18))
                .toList();
    }

    @Override
    public List<String> getListSortByAlphabet(List<String> list) {
        return list.stream().sorted().toList();
    }

    @Override
    public List<String> getListWithNumbers(List<String> list) {
        return list.stream().map(item -> item + "_1").toList();
    }

    @Override
    public int[] getArrayNumbers(List<String> list) {
        return list.stream()
                .mapToInt(
                        item -> Integer.parseInt(item.substring(1)))
                .toArray();
    }

    @Override
    public List<String> getListSortedAndDistinct(List<String> list) {
        return list.stream().distinct().sorted().collect(Collectors.toList());
    }
}

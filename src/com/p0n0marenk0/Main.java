/*1) Написать класс "Группа", для отображения учебной группы в Hillel,
 который содержит поля:
- название курса
- дата старта занятий
- суммарное количество занятий
- количество занятий в неделю
- список учащихся типа Student у которого есть фамилия, имя, дата рождения и контакты.
Написать методы:
- метод который выдает название группы на основе даты старта и названия курса
- метод который выдает дату последнего занятия
- печатает список студентов по порядку в формате:
        И. Иванов
        П. Петров
        С. Сидоров
- добавить студента
- узнать если ли студент с такой фамилией в группе
- удалить студента по фамилии или по номеру
1.1*) У студента есть список групп в которых он учится.
При добавлении студента в группу у него прописывается эта группа в списке.
В группе есть преподаватель типа Teacher,
у которого есть те же поля что у Student + информация о зарплате.*/
package com.p0n0marenk0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Group> groups = new ArrayList<>();
        Teacher teacher = new Teacher("Vasyl", "Ivanov", "14.12.1990", 5000.0);
        Student student = new Student("Serhii", "Ponomarenko", "05.05.1992",
                "+380630474700", 1);
        Student student1 = new Student("Valentin", "Ivanovich", "31.12.1989",
                "+380633409840", 2);
        Student student2 = new Student("Tetyanka", "Artemenko", "31.12.1941",
                "245", 3);
        Student student3 = new Student("Valentina", "Ivanovna", "31.12.1989",
                "+380633409840", 4);
        Student student4 = new Student("Oleg", "Filonenko", "31.12.1941",
                "245", 5);
        students.add(0, student);
        students.add(1, student1);
        students.add(2, student2);
        students.add(3, student3);
        students.add(4, student4);
        Group group = new Group("Java", "18.01.2021", 32,
                2, students, "18.01.2021 Introduction");
        groups.add(0, group);
        System.out.println("Result: ");
        System.out.println("Name of group: " + getNameOfGroup(groups, "18.01.2021", "Java"));
        System.out.println("Date of last lesson: " + getDateOfLastLesson(groups, "18.01.2021 Introduction"));

        //printSortedListOfStudents(students);
        //addStudent(students);
        printSortedListOfStudents(students);
        //addStudent(students);
        System.out.println("delete on number");
        removeStudentFromList(students, 2);
        printSortedListOfStudents(students);
        System.out.println("===========================");
        System.out.println("delete on surname");
        removeStudentFromList(students, "Artemenko");
        printSortedListOfStudents(students);

    }

    private static void removeStudentFromList(ArrayList<Student> students, int numberInList) {
        int count = -1;
        String searсh = "Студента с номером: " + numberInList + " нет в этом списке";
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNumberOfStudentInListOfGroup() == numberInList) {
                searсh = "Студент по фамилии: " + students.get(i).getSurname() + " в списке с номером: " +
                        students.get(i).getNumberOfStudentInListOfGroup() + "Удален!";
                count = students.get(i).getNumberOfStudentInListOfGroup();
            }
        }
        students.remove(count);
    }

    private static void removeStudentFromList(ArrayList<Student> students, String surname) {
        String searсh = "Студента с фамилией: " + surname + " нет в этом списке";
        int count = -1;
        for (int i = 0; i <students.size(); i++) {
            if (Objects.equals(students.get(i).getSurname(), surname)) {
                searсh = "Студент по фамилии: " + students.get(i).getSurname() + " в списке с номером: "
                        + students.get(i).getNumberOfStudentInListOfGroup() + "Удален!";
                count = i;
            }
        }
        students.remove(count);
    }

    private static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }


    private static LocalDate stringToDate(String myDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(myDate, formatter);
        return date;
    }

    private static String getNameOfGroup(ArrayList<Group> groups, String dateOfStart, String nameOfCourse) {
        String nameOfGroup = " Совпадений не найдено";
        for (Group i : groups) {
            if ((Objects.equals(i.getDateOfStartOfTheLessons(), dateOfStart)) && (Objects.equals(i.getNameOfCourse(), nameOfCourse))) {
                nameOfGroup = i.getNameOfGroup();
            }
        }
        return nameOfGroup;
    }

    private static String getDateOfLastLesson(ArrayList<Group> groups, String nameOfGroup) {
        String dateOfLastLesson = "Нету такой группы в списке";
        for (Group i : groups) {
            if (Objects.equals(i.getNameOfGroup(), nameOfGroup)) {
                dateOfLastLesson = dateToString(stringToDate((i.getDateOfStartOfTheLessons())).
                        plusDays((i.getAmountOfLessons() / i.getAmountOfLessonsOnTheWeek()) * 7));
            }
        }

        return dateOfLastLesson;
    }

    private static void printSortedListOfStudents(ArrayList<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        for (Student i : students) {
            System.out.println(i.convertName());
        }
    }

    private static void addStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя студента:");
        String name = sc.nextLine();
        System.out.println("Введите фамилию студента:");
        String surname = sc.nextLine();
        System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ :");
        String dateOfBirth = sc.nextLine();
        System.out.println("Введите номер телефона в формате +38ххххххххх :");
        String phoneNum = sc.nextLine();
        System.out.println("Введите номер студента в группе :");
        int numStInGroup = sc.nextInt();
        Student student = new Student(name, surname, dateOfBirth, phoneNum, numStInGroup);
        students.add(students.size(), student);
    }

    private static String checkStudentInTheListBySurname(ArrayList<Student> students, String surname) {
        String searsh = "Фамилии " + surname + " нет в этом списке";
        for (Student i : students) {
            if (Objects.equals(i.getSurname(), surname)) {
                searsh = "Есть такая фамилия " + i.getSurname() + " в списке с номером: " + i.getNumberOfStudentInListOfGroup();
            }
        }
        return searsh;
    }
}

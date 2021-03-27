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
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Group> groups = new ArrayList<>();
        Teacher teacher = new Teacher("Vasyl","Ivanov","14.12.1990",5000.0);
        Student student = new Student("Serhii","Ponomarenko","05.05.1992",
                "+380630474700",1);
        Student student1 = new Student("Valentin","Batenko","01.01.1989",
                "+380633409840",2);
        Group group = new Group("Java","18.01.2021",32,
                2,students,"18.01.2021 Introduction");

    }

    private static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       return  date.format(formatter);
    }


    private static LocalDate stringToDate(String myDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(myDate, formatter);
        return date;
    }

    private static String getNameOfGroup(ArrayList<Group> groups ,String dateOfStart, String nameOfCourse){
        String nameOfGroup = " Совпадений не найдено";
        for (Group i : groups) {
            if ((i.getDateOfStartOfTheLessons() == dateOfStart) && (i.getNameOfCourse() == nameOfCourse)) {
                nameOfGroup = i.getNameOfGroup();
            }
        }
     return nameOfGroup;
    }
  //метод который выдает дату последнего занятия
    private static String getDateOfLastLesson(ArrayList<Group> groups,String nameOfGroup){
        String dateOfLastLesson = "Нету такой группы в списке";
        for (Group i : groups) {
            if (i.getNameOfGroup() == nameOfGroup) {
                dateOfLastLesson = dateToString(stringToDate((i.getDateOfStartOfTheLessons()) +
                        (i.getAmountOfLessons()/i.getAmountOfLessonsOnTheWeek())*7));

            }
        }

        return dateOfLastLesson;
    }



}

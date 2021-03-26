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

import java.util.ArrayList;

public class Group {
    private String nameOfCourse;
    private String dateOfStartOfTheLessons;
    private int amountOfLessons;
    private int amountOfLessonsOnTheWeek;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    private ArrayList<Student> students = new ArrayList<>();

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    private String nameOfGroup;

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public String getDateOfStartOfTheLessons() {
        return dateOfStartOfTheLessons;
    }

    public void setDateOfStartOfTheLessons(String dateOfStartOfTheLessons) {
        this.dateOfStartOfTheLessons = dateOfStartOfTheLessons;
    }

    public int getAmountOfLessons() {
        return amountOfLessons;
    }

    public void setAmountOfLessons(int amountOfLessons) {
        this.amountOfLessons = amountOfLessons;
    }

    public int getAmountOfLessonsOnTheWeek() {
        return amountOfLessonsOnTheWeek;
    }

    public void setAmountOfLessonsOnTheWeek(int amountOfLessonsOnTheWeek) {
        this.amountOfLessonsOnTheWeek = amountOfLessonsOnTheWeek;
    }
}

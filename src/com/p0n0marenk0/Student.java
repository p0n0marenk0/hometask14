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

public class Student extends Person {
    private String phoneNumber;
    private int numberOfStudentInListOfGroup;
    private ArrayList<Group> groups = new ArrayList<>();
    private String studentsNameOfGroup;

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

        public String getStudentsNameOfGroup() {
        return studentsNameOfGroup;
    }

    public void setStudentsNameOfGroup(String studentsNameOfGroup) {
        this.studentsNameOfGroup = studentsNameOfGroup;
    }


    public Student(String name, String surname, String dateOfBirth, String phoneNumber, int numberOfStudentInListOfGroup) {
        super(name, surname, dateOfBirth);
        this.phoneNumber = phoneNumber;
        this.numberOfStudentInListOfGroup = numberOfStudentInListOfGroup;
    }

    public Student(String phoneNumber, int numberOfStudentInListOfGroup) {
        this.phoneNumber = phoneNumber;
        this.numberOfStudentInListOfGroup = numberOfStudentInListOfGroup;
    }

    public Student(String studentsNameOfGroup) {
        this.studentsNameOfGroup = studentsNameOfGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfStudentInListOfGroup() {
        return numberOfStudentInListOfGroup;
    }

    public void setNumberOfStudentInListOfGroup(int numberOfStudentInListOfGroup) {
        this.numberOfStudentInListOfGroup = numberOfStudentInListOfGroup;
    }

    public String convertName() {
        return getName().charAt(0) + ". " + getSurname();
    }
}

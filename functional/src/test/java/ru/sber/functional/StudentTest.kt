package ru.sber.functional

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StudentTest {

    private var studentsGroup = StudentsGroup()

    @Test
    fun filterTest(){
        val student1 = Student(firstName = "Petr", lastName = "Petrov",  averageRate = 4.2)
        val student2 = Student(firstName = "Ivan", lastName = "Petrov",  averageRate = 4.4)
        val student3 = Student(firstName = "Dmitriy", lastName = "Petrov",  averageRate = 4.7)
        val student4 = Student(firstName = "Petr", lastName = "Ivanov", averageRate =  4.5)
        studentsGroup.students = listOf(student1, student2, student3, student4)
        val studentsTest = listOf(student1)
        assertEquals(studentsGroup.filterByPredicate { it.averageRate < 4.4 }, studentsTest)
    }
}
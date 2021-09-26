package ru.sber.functional

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StudentTest {

    private var studentsGroup = StudentsGroup()

    @Test
    fun filterTest(){
        val student1 = Student("Petr", "Petrov", "none", 20, 4.2, "none", "none", "none")
        val student2 = Student("Ivan", "Petrov", "none", 19, 4.4, "none", "none", "none")
        val student3 = Student("Dmitriy", "Petrov", "none", 21, 4.7, "none", "none", "none")
        val student4 = Student("Petr", "Ivanov", "none", 22, 4.5, "none", "none", "none")
        studentsGroup.students = listOf(student1, student2, student3, student4)
        val studentsTest = listOf(student1)
        assertEquals(studentsGroup.filterByPredicate { it.averageRate < 4.4 }, studentsTest)
    }
}
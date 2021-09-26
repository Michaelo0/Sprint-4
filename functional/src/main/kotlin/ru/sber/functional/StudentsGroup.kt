package ru.sber.functional

class StudentsGroup {

    lateinit var students: List<Student>

    fun  filterByPredicate(predicate : (Student) -> Boolean): List<Student> {
        return students.filter(predicate)
    }
}

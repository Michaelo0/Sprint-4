package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "none",
    val age: Int = 50,
    val averageRate: Double,
    val city: String = "none",
    val specialization: String = "none",
    val prevEducation: String? = "none"
)

package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val zones = mutableSetOf<String>()
    for (s in ZoneId.getAvailableZoneIds()){
        val z = ZoneId.of(s)
        val seconds = LocalDateTime.now().atZone(z).offset.totalSeconds % 3600
        if (seconds != 0)
            zones.add(s)
    }
    return zones
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val days = mutableListOf<String>()

    for (i in 1..12) {
        days.add(YearMonth.of(year, i).atEndOfMonth().dayOfWeek.toString())
    }
    return days
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var number = 0
    for (month in 1..12){
        val yearMonth = YearMonth.of(year, month)
        val days = yearMonth.lengthOfMonth()
        for (day in 1..days) {
            val date = LocalDate.of(year, month, day)
            val dayOfWeek = date.dayOfWeek
            if ((day == 13) && (dayOfWeek == DayOfWeek.FRIDAY))
                number++
        }
    }
    return number
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    return DateTimeFormatter.ofPattern("dd MMM YYYY, HH:mm", Locale.US).format(dateTime)
}

fun main(){
    println(getNumberOfFridayThirteensInYear(1969))
}


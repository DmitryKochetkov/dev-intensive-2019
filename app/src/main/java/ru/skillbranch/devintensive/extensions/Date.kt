package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss dd:MM:yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Long): String {
        when (value % 10L) {
            0L -> return "минут"
            1L -> return "минуту"
            in 2L..4L -> return "минуты"
            in 5L..9L -> return "минут"
        }

        return ""
    }
}

fun Date.humanizeDiff(date:Date = Date()): String {
    return when(val diff = date.time - this.time) {
        in 0..1*SECOND -> "только что"
        in 1*SECOND..45*SECOND -> "несколько секунд назад"
        in 45*SECOND..75*SECOND -> "минуту назад"
        in 75*SECOND..45*MINUTE -> "${diff / MINUTE} ${TimeUnits.MINUTE.plural(diff / MINUTE)} назад"
        in 45*MINUTE..75*MINUTE -> "час назад"
        in 75*MINUTE..22*HOUR -> "${diff / HOUR} часов назад"
        in 22*HOUR..26*HOUR -> "день назад"
        in 26*HOUR..360*DAY -> "${diff / DAY} дней назад"
        else -> if (diff > 0) "более года назад" else "более, чем через год"
    }
}
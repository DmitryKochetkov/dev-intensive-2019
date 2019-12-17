package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val res: List<String>? = fullName?.split(" ")
        return Pair(res?.getOrNull(0), res?.getOrNull(1))
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var res: String = ""
        for (c in payload) {
            res += when(c) {
                'а' -> 'a'
                'б' -> 'b'
                'в' -> 'v'
                'г' -> 'g'
                'д' -> 'd'
                'е' -> 'e'
                'ё' -> 'e'
                'ж' -> "zh"
                'з' -> 'z'
                'и' -> 'i'
                'й' -> 'i'
                'к' -> 'k'
                'л' -> 'l'
                'м' -> 'm'
                'н' -> 'n'
                'о' -> 'o'
                'п' -> 'p'
                'р' -> 'r'
                'с' -> 's'
                'т' -> 't'
                'у' -> 'u'
                'ф' -> 'f'
                'х' -> 'h'
                'ц' -> 'c'
                'ч' -> "ch"
                'ш' -> "sh"
                'щ' -> "sh"
                'ъ' -> ""
                'ы' -> 'i'
                'ь' -> ""
                'э' -> 'e'
                'ю' -> "yu"
                'я' -> "ya"
                ' ' -> divider
                else -> c
            }
        }
        return res
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        //return firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
        if (firstName.isNullOrEmpty() && (lastName.isNullOrEmpty())) return "null"
        if (firstName.isNullOrEmpty()) return lastName!![0].toString().toUpperCase()
        if (lastName.isNullOrEmpty()) return firstName[0].toString().toUpperCase()
        return firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
    }


}
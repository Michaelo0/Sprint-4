abstract class Validator<T> {
    abstract fun validatePhone(value: T?): List<ErrorCode>
    abstract fun validateName(value: T?): List<ErrorCode>
    abstract fun validateEmail(value: T?): List<ErrorCode>
    abstract fun validateSnils(value: T?): List<ErrorCode>
}

class PhoneValidator : Validator<String>() {
    override fun validateName(value: String?): List<ErrorCode> {
        if (value == null || value.length > 16)
            return listOf(ErrorCode.INVALID_CHARACTER)
        for (i in value.indices)
                if (Character.UnicodeBlock.of(value[i]) != Character.UnicodeBlock.CYRILLIC) {
                    return listOf(ErrorCode.INVALID_CHARACTER)
                }
        return listOf()
    }

    override fun validatePhone(value: String?): List<ErrorCode> {
        if (value == null || value.length != 11 || (value[0] != '7' && value[0] != '8'))
            return listOf(ErrorCode.INVALID_CHARACTER)
        for (i in value.indices){
            if (!value[i].isDigit())
                return listOf(ErrorCode.INVALID_CHARACTER)
        }
        return listOf()
    }

    override fun validateEmail(value: String?): List<ErrorCode> {
        if (value == null || value.length > 32 || !value.contains('@'))
            return listOf(ErrorCode.INVALID_CHARACTER)
        for (i in value.indices)
            if (!((value[i] in 'A'..'Z') || (value[i] in 'a'..'z'))) {
                if (value[i] != '@' && value[i] != '.')
                    return listOf(ErrorCode.INVALID_CHARACTER)
            }
        return listOf()
    }

    override fun validateSnils(value: String?): List<ErrorCode> {
        if (value == null || value.length != 11)
            return listOf(ErrorCode.INVALID_CHARACTER)

        for (i in value.indices) {
            if (!value[i].isDigit())
                return listOf(ErrorCode.INVALID_CHARACTER)
        }
        val checkSum = value.substring(value.length - 2, value.length).toInt()
        val revValue = value.substring(0, value.length - 1).reversed()

        var sum = 0
        for (i in revValue.indices) {
            sum += Character.getNumericValue(revValue[i]) * i
        }
        if (sum > 101) {
            sum %= 101
        }
        if ((sum == 100 || sum == 101) && (checkSum != 0)) {
            return listOf(ErrorCode.INVALID_CHARACTER)
        } else if (sum < 100 && checkSum != sum) {
            return listOf(ErrorCode.INVALID_CHARACTER)
        }

        return listOf()
    }
}

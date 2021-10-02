import mu.KLogging

class ClientService {

    fun saveClient(client: Client): Client = client
        .also { validateClient(client) }
        .let { saveToMyPhantomDB(client) }
        .also { logger.info { "Успешно сохранена новая версия $it" } }


    private fun validateClient(client: Client) {
        val errorList = ArrayList<ErrorCode>()
        errorList.addAll(ValidatorUtils().validatePhone(client.phone))
        errorList.addAll(ValidatorUtils().validateName(client.firstName))
        errorList.addAll(ValidatorUtils().validateName(client.lastName))
        errorList.addAll(ValidatorUtils().validateEmail(client.email))
        errorList.addAll(ValidatorUtils().validateSnils(client.snils))
        if (errorList.isNotEmpty()) {
            throw ValidationException(*errorList.toTypedArray())
        }
    }

    private fun saveToMyPhantomDB(client: Client) = client
        .also { it.incrementVersion() }

    companion object : KLogging()
}
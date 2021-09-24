import mu.KLogging

class ClientService {

    fun saveClient(client: Client): Client = client
        .also { validateClient(client) }
        .let { saveToMyPhantomDB(client) }
        .also { logger.info { "Успешно сохранена новая версия $it" } }


    private fun validateClient(client: Client) {
        val errorList = ArrayList<ErrorCode>()
        errorList.addAll(PhoneValidator().validatePhone(client.phone))
        errorList.addAll(PhoneValidator().validateName(client.firstName))
        errorList.addAll(PhoneValidator().validateName(client.lastName))
        errorList.addAll(PhoneValidator().validateEmail(client.email))
        errorList.addAll(PhoneValidator().validateSnils(client.snils))
        if (errorList.isNotEmpty()) {
            throw ValidationException(*errorList.toTypedArray())
        }
    }

    private fun saveToMyPhantomDB(client: Client) = client
        .also { it.incrementVersion() }

    companion object : KLogging()
}
package business

class ContactBusiness {

    fun validate(name: String, phone: String) {

        if (name == "") {
            throw Exception("Name is empty")
        }
        if (phone == "") {
            throw Exception("Phone is empty")
        }
    }

    fun validateDelete(name: String, phone: String) {

        if(name == "" || phone == "") {
            throw Exception("Select contact before delete");
        }
    }

    fun save(name: String, phone: String) {
        validate(name, phone);
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone);
    }
}
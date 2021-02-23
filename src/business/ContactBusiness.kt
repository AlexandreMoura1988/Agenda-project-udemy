package business

import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {

    private fun validate(name: String, phone: String) {

        if (name == "") {
            throw Exception("Name is empty")
        }
        if (phone == "") {
            throw Exception("Phone is empty")
        }
    }

    private fun validateDelete(name: String, phone: String) {

        if(name == "" || phone == "") {
            throw Exception("Select contact before delete");
        }
    }

    fun save(name: String, phone: String) {

        validate(name, phone);
        ContactRepository.save(ContactEntity(name, phone))
    }

    fun delete(name: String, phone: String) {

        validateDelete(name, phone);
        ContactRepository.delete(ContactEntity(name, phone))
    }

    fun getList(): List<ContactEntity> {
        return ContactRepository.getList();
    }
}
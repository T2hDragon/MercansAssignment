package request.dto

import validators.Uuid
import java.util.*

class RequestDto {
    private lateinit var uuid: String;
    private lateinit var fname: String;
    private var errors: ArrayList<String>? = null;
    private lateinit var payload: ArrayList<PayloadDto>;

    fun getUuid(): String {
        return this.uuid;
    }
    fun setUuid(uuid: String) {
        if (!Uuid.isValidUuidString(uuid)) {
            throw java.lang.IllegalArgumentException("Given invalid \"$uuid\"");
        }
        this.uuid = uuid;
    }
    fun getFname(): String {
        return this.fname;
    }
    fun setFname(fname: String) {
        this.fname = fname;
    }
    fun getErrors(): ArrayList<String>? {
        return this.errors;
    }
    fun setErrors(errors: ArrayList<String>?) {
        this.errors = errors;
    }
    fun addError(error: String) {
        if (this.errors === null) {
            this.errors = ArrayList<String>();
        }
        this.errors!!.add(error);
    }
}
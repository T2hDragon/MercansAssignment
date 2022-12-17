package request.dto

import validators.DateTime
import java.lang.Exception

class PayComponentDto {
    private var amount: Float? = null;
    private lateinit var currency: String;
    private lateinit var startDate: String;
    private lateinit var endDate: String;

    fun getAmount(): Float {
        if (this.amount === null) {
            throw Exception("Field amount is not initialized");
        }
        return this.amount!!;
    }
    fun setAmount(amount: Float) {
        this.amount = amount;
    }

    fun getCurrency(): String {
        return this.currency;
    }
    fun setCurrency(currency: String) {
        this.currency = currency;
    }

    fun getStartDate(): String {
        return this.startDate;
    }
    fun setStartDate(startDate: String, format: String = "yyyy-MM-dd") {
        if (!DateTime.isValidDateTimeString(startDate, format)) {
            throw java.lang.IllegalArgumentException("Given invalid date \"$startDate\" for format \"$format\"");
        }
        this.startDate = transformer.DateTime.changeStringFormat(startDate, format);
    }
    fun getEndDate(): String {
        return this.startDate;
    }
    fun setEndDate(endDate: String, format: String = "yyyy-MM-dd") {
        if (!DateTime.isValidDateTimeString(endDate, format)) {
            throw java.lang.IllegalArgumentException("Given invalid date \"$endDate\" for format \"$format\"");
        }
        this.startDate = transformer.DateTime.changeStringFormat(endDate, format);
    }
}
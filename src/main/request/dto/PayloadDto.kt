package request.dto

import transformer.DateTime
import java.rmi.UnexpectedException
import java.security.KeyStore.Entry

class PayloadDto {
    private var orderNumber: Int = 0;
    private var payComponents: ArrayList<PayComponentDto>? = null;
    private lateinit var employeeCode: String;
    private lateinit var action: String;
    // Correctness is assumed to have Types of String, Int, Boolean, Float
    private var data: MutableMap<String, Any> = mutableMapOf();

    fun getEmployeeCode(): String {
        return this.employeeCode;
    }
    fun setEmployeeCode(employeeCode: String?) {
        if (employeeCode === null) {
            this.employeeCode = this.generateEmployeeCode();
            return;
        }
        this.employeeCode = employeeCode;
    }

    private fun generateEmployeeCode(): String
    {
        if (this.payComponents === null) {
            throw UnexpectedException("Unable to generate EmployeeCode since it lacks payComponents")
        }
        val payComponents = this.payComponents!!.sortedBy { it.getStartDate() };
        val firstWorkDay = DateTime.changeStringFormat(payComponents.first().getStartDate(), "yyyy-MM-dd", "yymmdd");
        val orderNumberHex = Integer.toHexString(this.orderNumber);
        return "$firstWorkDay$orderNumberHex";
    }

    fun getAction(): Action {
        return Action.getAction(this.action);
    }
    fun setAction(action: Action) {
        this.action = action.toString();
    }

    fun getData(): MutableMap<String, Any> {
        return this.data;
    }
    fun setData(data: MutableMap<String, Any>) {
        this.data = data;
    }
    fun getPayComponents(): ArrayList<PayComponentDto>? {
        return this.payComponents;
    }
    fun setPayComponents(payComponents: ArrayList<PayComponentDto>?) {
        this.payComponents = payComponents;
    }
    fun addError(payComponent: PayComponentDto) {
        if (this.payComponents === null) {
            this.payComponents = ArrayList();
        }
        this.payComponents!!.add(payComponent);
    }
}
package request.dto

import java.lang.IllegalArgumentException

enum class Action(val action: String) {
    HIRE("hire"),
    CHANGE("change"),
    TERMINATE("terminate");

    companion object {
        fun getAction(action: String): Action
        {
            return when (action.lowercase()) {
                "hire", "add" -> Action.HIRE;
                "change", "update" -> Action.CHANGE;
                "terminate", "delete" -> Action.TERMINATE;
                else -> throw IllegalArgumentException("Action \"$action\" not accounted for")
            }
        }
    }
}


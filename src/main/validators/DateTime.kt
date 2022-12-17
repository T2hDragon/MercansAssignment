package validators

import java.text.SimpleDateFormat
import java.util.*

class DateTime {
    companion object {
        fun isValidDateTimeString(dateString: String, format: String = "yyyy-MM-dd"): Boolean {
            val formatter = SimpleDateFormat(format, Locale.getDefault())
            return try {
                formatter.parse(dateString)
                true;
            } catch (exception: IllegalArgumentException) {
                false;
            }
        }
    }
}
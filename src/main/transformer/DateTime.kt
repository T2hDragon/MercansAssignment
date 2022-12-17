package transformer

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class DateTime {
    companion object {
        fun changeStringFormat(dateString: String, givenFormat: String = "yyyy-MM-dd", desiredFormat: String = "yyyy-MM-dd"): String {
            val givenFormatter = DateTimeFormatter.ofPattern(givenFormat);
            val desiredFormatter = DateTimeFormatter.ofPattern(desiredFormat);
            val date = givenFormatter.parse(dateString);
            return desiredFormatter.format(date);
        }
    }
}
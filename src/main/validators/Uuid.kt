package validators

import java.util.*

class Uuid {
    companion object {
        fun isValidUuidString(uuid: String): Boolean {
            return try {
                UUID.fromString(uuid);
                true;
            } catch (exception: IllegalArgumentException) {
                false;
            }
        }
    }
}
package unit.controller

import controller.Main.Companion.main
import org.junit.Test
import kotlin.test.assertEquals

internal class MainTest {
    @Test
    fun testMain() {
        val name = "Karmo"
        val given = main(name)
        assertEquals("Name is: $name", given)
    }
}
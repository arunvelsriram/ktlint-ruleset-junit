package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MaximumIgnoredTestRuleTest {

    private val ruleId = "junit-maximum-ignored-tests"
    private val lintErrorMessage = "Number of ignored tests is greater than Threshold (5)"

    @Test
    fun `should emit lint error only once when number of ignored test is greater than 5`() {
        val code = """
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            } 
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            } 
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            } 
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            }
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            }
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            }
            @Ignore
            fun shouldAssertTrue() {
                assertTrue(true)
            }
            @Test
            fun shouldAssertTrue() {
                assertTrue(true)
            }
        """.trimIndent()

        val result = MaximumIgnoredTestRule().lint(code)

        val expected = listOf(LintError(1, 1, ruleId, lintErrorMessage))
        assertEquals(expected, result)
    }

    @Test
    fun `should do nothing when number of ignored tests is within 5`() {
        val code = """
            @Test
            fun `should assert true`() {
                assertTrue(true)
            }
            @Ignore
            fun `should assert false`() {
                assertFalse(false)
            }
        """.trimIndent()

        val result = MaximumIgnoredTestRule().lint(code)

        assertTrue(result.isEmpty())
    }
}

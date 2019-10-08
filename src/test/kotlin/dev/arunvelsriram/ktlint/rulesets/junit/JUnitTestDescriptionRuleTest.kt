package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JUnitTestDescriptionRuleTest {

    private val ruleId = "junit-backticked-test-description"
    private val lintErrorMessage = "Test description should be inside backticks (e.g., `should add two numbers`)"

    @Test
    fun `should emit lint error when test name is not inside backticks`() {
        val code = """
            @Test
            fun shouldAssertTrue() {
                assertTrue(true)
            }
        """.trimIndent()

        val result = JUnitTestDescriptionRule().lint(code)

        val expected = listOf(LintError(2, 5, ruleId, lintErrorMessage))
        assertEquals(expected, result)
    }

    @Test
    fun `should do nothing when test name is inside backticks`() {
        val code = """
            @Test
            fun `should assert true`() {
                assertTrue(true)
            }
        """.trimIndent()

        val result = JUnitTestDescriptionRule().lint(code)

        assertTrue(result.isEmpty())
    }
}

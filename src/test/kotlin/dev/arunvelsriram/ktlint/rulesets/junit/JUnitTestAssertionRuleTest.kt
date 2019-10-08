package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JUnitTestAssertionRuleTest {

    private val ruleId = "junit-test-without-assertion"

    @Test
    fun `should emit lint error when test body does not assert`() {
        val code = """
            @Test
            fun `should assert true`() {
                // no body
            }
        """.trimIndent()

        val result = JUnitTestAssertionRule().lint(code)

        val expected =
            listOf(LintError(2, 28, ruleId, JUnitTestAssertionRule.LINT_ERROR_MESSAGE))
        assertEquals(expected, result, "Lint should fail if test does not assert")
    }

    @Test
    fun `should pass when test body asserts`() {
        val code = """
            @Test
            fun `should assert true`() {
                assertTrue(true)
            }
        """.trimIndent()

        val result = JUnitTestAssertionRule().lint(code)

        assertTrue(result.isEmpty(), "If an assertion is present, lint should pass")
    }
}

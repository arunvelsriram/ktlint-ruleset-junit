package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/**
This rule checks if JUnit test description follows backticks style.

```
@Test
fun `should add two numbers`() {
    assertEquals(3, add(1,2))
}
```
**/
class JUnitTestDescriptionRule : Rule("junit-test-description") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtStubElementTypes.FUNCTION) {
            val func = node.psi as KtFunction
            func.annotationEntries.find {
                it.text == TEST_ANNOTATION
            }?.let {
                val funcNameIdentifier = func.nameIdentifier
                val funcName = funcNameIdentifier?.text
                if (funcName != null && !funcName.matches(Regex("^`.*`$"))) {
                    emit(funcNameIdentifier.textOffset, LINT_ERROR_MESSAGE, false)
                }
            }
        }
    }

    companion object {
        private const val TEST_ANNOTATION = "@Test"
        private const val LINT_ERROR_MESSAGE =
            "Test description should be inside backticks (e.g., `should add two numbers`)"
    }
}

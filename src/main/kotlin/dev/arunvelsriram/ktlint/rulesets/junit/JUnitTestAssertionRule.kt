package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class JUnitTestAssertionRule : Rule("junit-test-without-assertion") {

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
                val body = func.bodyExpression
                if (body?.text?.contains(other = "assert", ignoreCase = true) == false) {
                    emit(body.textOffset, LINT_ERROR_MESSAGE, false)
                }
            }
        }
    }

    companion object {
        const val LINT_ERROR_MESSAGE =
            "Test must contain an assertion"

        private const val TEST_ANNOTATION = "@Test"
    }
}

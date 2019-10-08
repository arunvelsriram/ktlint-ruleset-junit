package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtFunction
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class MaximumIgnoredTestRule : Rule("junit-maximum-ignored-tests") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (ignoredTestsCount > IGNORED_TESTS_THRESHOLD) return
        if (node.elementType == KtStubElementTypes.FUNCTION) {
            val func = node.psi as KtFunction
            func.annotationEntries.find {
                it.text == IGNORE_ANNOTATION
            }?.let {
                if (ignoredTestsCount == IGNORED_TESTS_THRESHOLD) {
                    emit(0, LINT_ERROR_MESSAGE, false)
                }
                ignoredTestsCount += 1
            }
        }
    }

    companion object {
        private const val IGNORE_ANNOTATION = "@Ignore"
        private const val IGNORED_TESTS_THRESHOLD = 5
        private const val LINT_ERROR_MESSAGE = "Number of ignored tests is greater than Threshold (5)"
        private var ignoredTestsCount = 0
    }
}

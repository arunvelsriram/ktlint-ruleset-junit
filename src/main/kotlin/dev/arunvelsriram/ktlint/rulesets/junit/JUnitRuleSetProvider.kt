package dev.arunvelsriram.ktlint.rulesets.junit

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class JUnitRuleSetProvider : RuleSetProvider {
    override fun get() = RuleSet("junit-ktlint-rules", JUnitTestDescriptionRule())
}

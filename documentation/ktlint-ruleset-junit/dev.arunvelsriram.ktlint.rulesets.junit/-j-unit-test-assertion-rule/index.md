[ktlint-ruleset-junit](../../index.md) / [dev.arunvelsriram.ktlint.rulesets.junit](../index.md) / [JUnitTestAssertionRule](./index.md)

# JUnitTestAssertionRule

`class JUnitTestAssertionRule : Rule`

This rule checks if JUnit test asserts anything.

```
@Test
fun `should pass when test body asserts`() {
assertTrue(true)
}
```

### Constructors

| [&lt;init&gt;](-init-.md) | This rule checks if JUnit test asserts anything.`JUnitTestAssertionRule()` |

### Functions

| [visit](visit.md) | `fun visit(node: ASTNode, autoCorrect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, emit: (offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, canBeAutoCorrected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| [LINT_ERROR_MESSAGE](-l-i-n-t_-e-r-r-o-r_-m-e-s-s-a-g-e.md) | `const val LINT_ERROR_MESSAGE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |


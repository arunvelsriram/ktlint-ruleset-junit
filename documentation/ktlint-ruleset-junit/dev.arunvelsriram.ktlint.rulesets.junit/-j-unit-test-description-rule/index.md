[ktlint-ruleset-junit](../../index.md) / [dev.arunvelsriram.ktlint.rulesets.junit](../index.md) / [JUnitTestDescriptionRule](./index.md)

# JUnitTestDescriptionRule

`class JUnitTestDescriptionRule : Rule`

This rule checks if JUnit test description follows backticks style.

```
@Test
fun `should add two numbers`() {
assertEquals(3, add(1,2))
}
```

### Constructors

| [&lt;init&gt;](-init-.md) | This rule checks if JUnit test description follows backticks style.`JUnitTestDescriptionRule()` |

### Functions

| [visit](visit.md) | `fun visit(node: ASTNode, autoCorrect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, emit: (offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, canBeAutoCorrected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |


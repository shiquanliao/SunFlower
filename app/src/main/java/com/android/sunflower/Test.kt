package com.android.sunflower

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegatePropertiesDemo {
    var content: String by Content()
}

class Content {
    operator fun getValue(
        delegatePropertiesDemo: DelegatePropertiesDemo,
        property: KProperty<*>
    ): String {
        return "$delegatePropertiesDemo property '${property.name}' = 'stone'"
    }

    operator fun setValue(
        delegatePropertiesDemo: DelegatePropertiesDemo,
        property: KProperty<*>,
        value: String
    ) {
        println("$delegatePropertiesDemo property '${property.name}' is '$value'")
    }

}


class PostHierarchy {
    var level: String by Delegates.observable("P0", { _, oldValue, newValue ->
        println("$oldValue -> $newValue")
    })
}

fun main() {
    val delegatePropertiesDemo = DelegatePropertiesDemo()
    println(delegatePropertiesDemo.content)
    delegatePropertiesDemo.content = "hhhhh"
    println(delegatePropertiesDemo.content)

    val synchronizedLazyImpl = lazy {
        println("synchronizedLazyImpl   3!")
        println("synchronizedLazyImpl   2!")
        println("synchronizedLazyImpl   1!")
        "Hello lazy synchronized1"
    }

    val lazy1: String by synchronizedLazyImpl

    println(lazy1)
    println(lazy1)

    val ph = PostHierarchy()
    ph.level = "p1"
    ph.level = "p2"
    ph.level = "p3"
    println(ph.level)


}

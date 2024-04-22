package com.example.kotlinpractice.kotlin

import kotlin.reflect.KProperty

class DelegateProperties {

    class PropertiesMigration {
        var newName: Int = 0
        @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
        var oldName: Int by this::newName
    }

    class Resource

    class Owner {
        var varResource: Resource by ResourceDelegate()
    }

    class ResourceDelegate(private var resource: Resource = Resource()) {
        operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
            return resource
        }
        operator fun setValue(thisRef: Owner, property: KProperty<*>, value: Any?) {
            if (value is Resource) {
                resource = value
            }
        }
    }
}

fun main() {
    val myClass = DelegateProperties.PropertiesMigration()
    myClass.newName = 10
    println(myClass.newName)
    println(myClass.oldName)
    myClass.oldName = 20
    println(myClass.newName)
    println(myClass.oldName)

    // Notification: 'oldName: Int' is deprecated.
    // Use 'newName' instead
    myClass.oldName = 42
    println(myClass.newName) // 42
    println(myClass.oldName) // 42

    class User(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int     by map
    }

    class MutableUser(val map: MutableMap<String, Any?>) {
        var name: String by map
        var age: Int     by map
    }

    val user = User(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println(user.name) // Prints "John Doe"
    println(user.age)  // Prints 25
}

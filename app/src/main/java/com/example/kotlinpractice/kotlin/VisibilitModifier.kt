package com.example.kotlinpractice.kotlin

class VisibilitModifier {
    // This is visible to everyone. (Same as explicitly declaring `public`)
    fun publicFunction() { }

    // This is only visible within the same file.
    private fun privateFunction() { }

    // This is visible to any client inside this module.
    internal fun internalFunction() { }

    open class Example {
        // This is visible to any subclass.
        protected open val openProperty: String = "I'm protected"

        // This is visible only within Example class.
        private val myProperty: String = "I'm private"

        // This is visible to any client inside this module.
        internal val visibleProperty: String = "I'm internal"

        // This is visible to everyone. (Same as explicitly declaring `public`)
        val publicProperty: String = "I'm public"
    }
}
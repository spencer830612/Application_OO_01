package com.example.application_oo_01

open class cuboid(var length: Double, var width: Double, var height: Double) {

    open fun volume(): Double {
        return length * width * height
    }

    open fun info(): Map<String, Double> {
        return mapOf("長" to length, "寬" to width, "高" to height, "體積" to volume())
    }
}
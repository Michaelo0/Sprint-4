package ru.sber.generics

import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

// 1.
fun compare(p1: Pair<Any, Any>, p2: Pair<Any, Any>): Boolean {
    val k1 = p1.first
    val v1 = p1.second
    val k2 = p2.first
    val v2 = p2.second

    return ((k1 == k2) && (v1 == v2))
}

// 2.
fun <T> countGreaterThan(anArray: Array<Comparable<in T>>, elem: T): Int {
    var count = 0
    for (el in anArray){
        if (el > elem)
            count++
    }
    return count
}

// 3.
class  Sorter<T: Comparable<T>>{
    var list: MutableList<T> = mutableListOf()


    fun add(value: T) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack <T>{
    var list : MutableList<T> = mutableListOf()

    fun isEmpty() : Boolean {
        return list.isEmpty()
    }

    fun push(value : T) {
        list.add(value)
    }

    fun pop() : T {
        val elem : T = list[list.size - 1]
        list.removeAt(list.size - 1)
        return elem
    }

}
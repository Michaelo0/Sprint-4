package ru.sber.generics


// 1.
fun <T1, T2> compare(p1: Pair<T1, T2>, p2: Pair<T1, T2>): Boolean {
    return ((p1.first == p2.first) && (p1.second == p2.second))
}

// 2.
fun <T : Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
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
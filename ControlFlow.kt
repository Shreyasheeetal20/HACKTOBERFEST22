fun main() {
    val a = 1.rangeTo(10) step 3 // range 1 s/d 10 with step 3
    for((i, v) in a.withIndex()){
        println("[$i] = $v") // [index] = value from variable 'a'
    }
    println()

    a.forEach {
        println(it) // same with diff way
    }
    println()

    a.forEachIndexed{ i, v ->
        println("[$i] = $v") // same with diff way
    }
}
package ctci.ch1

import collection.mutable

object P1_6 extends App {

    // Simple string compression transformation
    // This algorithm is case sensitive
    def compress(s:String):String = {
        val storage = new mutable.ArrayBuffer[(Char, Int)]

        // Do compression
        var currentC = s(0)
        var seen = 1

        for(i <- 1 until s.length){
            if(s(i) == currentC)
                seen += 1
            else{
                storage += Tuple2(currentC, seen)
                currentC = s(i)
                seen = 1
            }
        }

        // Add the last element to the storage
        storage += Tuple2(currentC, seen)

        // Transform the encoding to a string
        val candidate = storage.map{ case(c, i) => s"$c$i" }.mkString

        // Return the candidate only if its lenght is shorter than the original's
        if(candidate.length < s.length) candidate else s
    }

    println("== Problem 1.6 - String compression ==")
    println

    val s1= "aabcccccaaa"
    val s2 = "Hithere"
    val s3 = "holakeaaaaaaaaaaaaaaaaaaaaaaaaase"
    // Tests
    println(s"$s1 compresses to ${compress(s1)}")
    println(s"$s2 compresses to ${compress(s2)}")
    println(s"$s3 compresses to ${compress(s3)}")

}

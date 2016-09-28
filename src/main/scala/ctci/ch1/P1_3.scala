package ctci.ch1

import collection.mutable

object P1_3 extends App {

    // Assume there is enough trailing white space to fill it with the %20s
    def urlify(s:String):String = {
        // The problem suggests this should be done in place,
        // so I will use an array buffer to simulate a mutable string
        val buff = new mutable.StringBuilder(s)

        // Auxiliary function to shift the contents of the string one
        // position to the right
        def shiftRight(i:Int){
            var prev = buff(i+1)
            for(j <- i+2 until s.length){
                val hold = buff(j)
                buff(j) = prev
                prev = hold
            }
        }

        for(i <- 0 until s.length){
            if(buff(i) == ' '){
                // Shift the contents to the right twice
                shiftRight(i)
                shiftRight(i)
                // Put the substitution
                buff(i) = '%'
                buff(i+1) = '2'
                buff(i+2) = '0'
            }
        }

        // Return the modified string
        buff.toString
    }

    println("== Problem 1.3 - URLify ==")
    println

    // Test my strings
    val s1 = "Mr John Smith    "
    val s2 = "Enrique Noriega  "

    println(s"$s1 => ${urlify(s1)}")
    println(s"$s2 => ${urlify(s2)}")

}

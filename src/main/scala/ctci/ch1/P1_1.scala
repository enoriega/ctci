package ctci.ch1

object P1_1 extends App {

    // This implementation makes no use of any auxiliary data structure
    // It's case insensitive
    def uniqueCharacters(s:String):Boolean = {
        // Sort the String
        // Enrique => Eeinqru
        val sortedS = s.sorted

        // Consecutive character pairs (bigrams/tuples)
        // Eeinqru => (E, e), (e, i), (i, n), (n, q), (q, r), (r, u)
        val bigrams = sortedS zip (sortedS.drop(1))

        // Test to se if there is a tuple with the equal elements
        !bigrams.exists{ case(a, b) => a == b }
    }
    def test(s:String){
        if(uniqueCharacters(s))
            println(s"'$s' has unique characters")
        else
            println(s"'$s' doesn't have unique characters")
    }

    println("== Problem 1.1 - String with unique characters ==")
    println
    // Test my strings
    val s1 = "Enrique Noriega"
    val s2 = "Enriqu Noga"

    test(s1)
    test(s2)
}

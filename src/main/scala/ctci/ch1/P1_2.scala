package ctci.ch1

object P1_2 extends App {

    // It's case Sensitive
    def isPermutation(s1:String, s2:String):Boolean = {
        // Sort the string
        val sS1 = s1.sorted
        val sS2 = s2.sorted

        // If they're the same string then they're a permutation of each other
        sS1 == sS2
    }

    def test(s1:String, s2:String){
        if(isPermutation(s1, s2))
            println(s"'$s1' is a permutation of '$s2'")
        else
            println(s"'$s1' isn't a permutation of '$s2'")
    }

    println("== Problem 1.2 - String permutations ==")
    println
    // Test my strings
    val s1 = "roma"
    val s2 = "amor"
    val s3 = "scala"

    test(s1, s2)
    test(s1, s3)
    test(s2, s3)
}

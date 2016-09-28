package ctci.ch1

object P1_5 extends App {

    // This is just the classic edit distance problem disguised

    // Edit distance implementation
    // See https://en.wikipedia.org/wiki/Edit_distance for details
    def editDistance(s1:String, s2:String):Int = {

        val table = Array.ofDim[Int](s1.length, s2.length)

        // Initialize the dynamic programming table
        if(s1(0) != s2(0)) table(0)(0) = 1

        for(i <- 1 until s1.length)
            table(i)(0) = table(i-1)(0) + 1

        for(j <- 1 until s2.length)
            table(0)(j) = table(0)(j-1) + 1

        // Do dynamic programming
        for{
            i <- 1 until s1.length
            j <- 1 until s2.length
        }{
            // Same character
            if(s1(i) == s2(j))
                table(i)(j) = table(i-1)(j-1)
            // Different character
            else{
                val choice = Seq(table(i-1)(j), table(i)(j-1), table(i-1)(j-1)).min
                table(i)(j) = choice + 1
            }
        }

        // Return the edit distance
        table(s1.length-1)(s2.length-1)
    }

    def test(s1:String, s2:String){
        val distance = editDistance(s1, s2)
        if(distance <= 1)
            println(s"$s1 and $s2 are at most one edit away: $distance")
        else
            println(s"$s1 and $s2 are more than one edit away: $distance!!!")
    }

    println("== Problem 1.5 - One way ==")
    println

    // Tests
    test("pale", "ple")
    test("pales", "pale")
    test("pale", "bale")
    test("pale", "bake")

}

package ctci.ch1

object P1_4 extends App {

    // Tests whether s is a palindrome permutation
    // This algorithm is case insensitive
    def isPalindromePermutation(s:String):Boolean = {
        // First, remove the white spaces, then
        // case-fold and sort the string, makes it easier
        val sortedS = s.replace(" ", "").toLowerCase.sorted

        // There are two cases, an even-length string and odd-length string
        // If the string is even, all the characters should appear an even
        // number of times in the string.
        // If the string is odd, the there must be *only one* character that
        // appears an odd number of times

        var times = 1
        var seenOdd = false

        for(i <- 1 until sortedS.length){
            // Seen the same character again
            // Increment it's count
            if(sortedS(i) == sortedS(i-1)){
                times += 1
            }
            // Change of character, decide what to do:
            else{
                // All good!
                if(times % 2 == 0){
                    // Now seen ${sortedS(i)} once
                    times = 1
                }
                // Ugh...
                else{
                    // This is an odd character
                    // If it's the first, we let it go

                    if(!seenOdd){
                        seenOdd = true
                        times = 1
                    }
                    // If it isn't then this isn't a palindrome permutation
                    else{
                        return false //!!!
                    }
                }
            }

        }

        // If we reached this point then we passed the test
        true
    }

    def test(s:String){
        if(isPalindromePermutation(s))
            println(s"'$s' is a palindrome permutation")
        else
            println(s"'$s' isn't a palindrome permutation")
    }

    println("== Problem 1.4 - Palindrome permutation ==")
    println

    // Tests
    test("Tact Coa")
    test("Enrique Noriega")
    test("Able was I ere I saw Elba")
    test("Ablewas I aws I eer Elba")

}

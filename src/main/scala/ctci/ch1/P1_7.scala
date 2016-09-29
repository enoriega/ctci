package ctci.ch1

object P1_7 extends App {

    // Assuming that the platform's length of int is 4 bytes, each cell in
    // the matrix is of type int

    def rotate(m:Array[Array[Int]]){
        // To solve this problem, we use a recursive algorithm that works
        // "Layer by layer" of the matrix

        // This is the recursive procedure we will use
        def recursive(m:Array[Array[Int]], ix:Tuple2[Int, Int], n:Int){
            for(i <- 0 until (n-1)){
                helper(m, (ix._1+i, ix._2), n)
                // Call recursion
                recursive(m, (ix._1 + 1, ix._2 + 1), n-2)
            }
        }

        // This is where the actual in place movement happens
        def helper(m:Array[Array[Int]], start:Tuple2[Int, Int], n:Int){

            // This is an auxiliary function to compute the location of the
            // location of an entry after location
            // i, j are the original indices and n the size of the row
            def location(i:Int, j:Int, n:Int) = (j, n-1-i)

            // Here is where the magic happens
            var ix = start
            var next = location(ix._1, ix._2, n)
            var working = m(ix._1)(ix._2)

            // Start moving around the values
            while(next != start){
                val hold = m(next._1)(next._2)
                m(next._1)(next._2) = working
                working = hold
                ix = next
                next = location(next._1, next._2, n)
            }
            // Put the last element at the start
            m(start._1)(start._2) = working
        }

        // Now start the recursion
        recursive(m, (0, 0), m.size)
    }
    //////////////////////////////////////////////////////////////////////


    def test(m:Array[Array[Int]]){
        // Print the original matrix
        println("Original:")
        println
        for(i <- 0 until m.size){
            println(m(i).mkString("\t"))
        }
        rotate(m)
        println
        println("Rotation:")
        println
        for(i <- 0 until m.size){
            println(m(i).mkString("\t"))
        }
        println
        println("====================")
    }

    // Fills the matrix with the sequence of integers
    def fillMatrix(m:Array[Array[Int]]) = {
        var seed = 1
        for(i <- 0 until m.size; j <- 0 until m.size){
            m(i)(j) = seed
            seed += 1
        }
    }

    println("== Problem 1.7 - Matrix rotation ==")
    println

    // Tests
    val a = Array.ofDim[Int](2,2)
    val b = Array.ofDim[Int](3,3)
    val c = Array.ofDim[Int](4,4)

    fillMatrix(a)
    fillMatrix(b)
    fillMatrix(c)

    test(a)
    test(b)
    test(c)

}

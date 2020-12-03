package nl.melvinsnijders.adventofcode2020

import scala.io.Source

object Day3 {

    val input: Array[String] = Source.fromResource("day03.txt").getLines().toArray
    val slopes: Seq[(Int, Int)] = Seq((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))

    def main(args: Array[String]): Unit = {

        var part1 = 0
        var part2 = 1

        for((right, down) <- slopes) {

            var trees = 0
            var x = 0
            var y = 0

            while(y < input.length) {

                if(input(y).charAt(x % (input(y).length)) == '#')
                    trees += 1

                x += right
                y += down

            }

            if(right == 3 && down == 1) {
                part1 = trees
            }

            part2 *= trees

        }

        println(s"Part 1: $part1")
        println(s"Part 2: $part2")

    }


}

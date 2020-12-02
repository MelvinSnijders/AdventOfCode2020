package nl.melvinsnijders.adventofcode2020

import scala.io.Source

object Day2 {

    val input: Array[String] = Source.fromResource("day02.txt").getLines().toArray

    def main(args: Array[String]): Unit = {

        var matchesPart1 = 0
        var matchesPart2 = 0

        for(line <- input) {

            val splitted: Array[String] = line.split(" ")
            val minMax = splitted(0).split("-")

            val num1: Int = minMax(0).toInt
            val num2: Int = minMax(1).toInt
            val character: Char = splitted(1).charAt(0)
            val password = splitted(2)

            val count: Int = password.count(_ == character)

            if(count >= num1 && count <= num2) {
                matchesPart1 += 1
            }

            val firstChar = password.charAt(num1 - 1)
            val secondChar = password.charAt(num2 - 1)

            if(firstChar != secondChar && (firstChar == character || secondChar == character)) {
                matchesPart2 += 1
            }

        }

        println(s"Part 1: $matchesPart1")
        println(s"Part 2: $matchesPart2")

    }

}

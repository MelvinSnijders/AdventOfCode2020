package nl.melvinsnijders.adventofcode2020

import scala.io.Source

object Day1 {

    val input: Array[Int] = Source.fromResource("day01.txt").getLines().map(_.toInt).toArray

    def main(args: Array[String]): Unit = {

        var result1 = 0;
        var result2 = 0;

        for (number1 <- input; number2 <- input) {

            if(number1 + number2 == 2020) {
                result1 = number1 * number2
            }

            for(number3 <- input; if number1 + number2 + number3 == 2020) {
                result2 = number1 * number2 * number3
            }

        }

        println(s"Part 1: $result1")
        println(s"Part 2: $result2")

    }

}

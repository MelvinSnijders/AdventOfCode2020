package nl.melvinsnijders.adventofcode2020

import scala.io.Source

object Day2 {

    val input: Array[String] = Source.fromResource("day02.txt").getLines().toArray
    val policies: Array[PasswordPolicy] = input.map(line => {
        val policy = line.split(" ")
        val minMax = policy(0).split("-")
        PasswordPolicy(minMax(0).toInt, minMax(1).toInt, policy(1).charAt(0), policy(2))
    })

    def main(args: Array[String]): Unit = {

        println("Part 1: " + partOne())
        println("Part 1: " + partTwo())

    }

    def partOne(): Int = {

        policies.count(policy => {
            val count = policy.password.count(_ == policy.character)
            count >= policy.num1 && count <= policy.num2
        })

    }

    def partTwo(): Int = {

        policies.count(policy => {
            val char1 = policy.password.charAt(policy.num1 - 1);
            val char2 = policy.password.charAt(policy.num2 - 1)
            char1 != char2 && (char1 == policy.character || char2 == policy.character)
        })

    }

    case class PasswordPolicy(num1: Int, num2: Int, character: Char, password: String)

}

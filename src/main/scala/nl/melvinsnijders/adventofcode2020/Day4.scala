package nl.melvinsnijders.adventofcode2020

import scala.io.Source

object Day4 {

    val input: Array[String] = Source.fromResource("day04.txt").getLines.mkString(" ").split(" {2}")

    def main(args: Array[String]): Unit = {

        var totalValid = 0;

        for (line <- input) {

            val fields: Map[String, String] = line.split(" ").map(field => (field.split(":")(0), field.split(":")(1))).toMap
            val valid = enhancedValidation(fields)

            if (valid) totalValid += 1

        }

        print(s"Part 2: $totalValid")

    }

    def enhancedValidation(fields: Map[String, String]): Boolean = {

        fields.get("byr") match {
            case Some(value) => if(!value.matches("^\\d{4}$") || (value.toInt < 1920 || value.toInt > 2002)) return false
            case None => return false
        }

        fields.get("iyr") match {
            case Some(value) => if(!value.matches("^\\d{4}$") || (value.toInt < 2010 || value.toInt > 2020)) return false
            case None => return false
        }

        fields.get("eyr") match {
            case Some(value) => if(!value.matches("^\\d{4}$") || (value.toInt < 2020 || value.toInt > 2030)) return false
            case None => return false
        }

        fields.get("hgt") match {
            case Some(value) => if((!value.matches("^\\d+cm$") || value.substring(0, value.length - 2).toInt < 150 || value.substring(0, value.length - 2).toInt > 193) && (!value.matches("^\\d+in$") || value.substring(0, value.length - 2).toInt < 59 || value.substring(0, value.length - 2).toInt > 76)) return false
            case None => return false
        }

        fields.get("hcl") match {
            case Some(value) => if(!value.matches("^#([0-9]|[a-f]){6}$")) return false
            case None => return false
        }

        fields.get("ecl") match {
            case Some(value) => if(!List("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value)) return false
            case None => return false
        }

        fields.get("pid") match {
            case Some(value) => if(!value.matches("^\\d{9}$")) return false
            case None => return false
        }

        true

    }


}

lazy val root = project
  .in(file("."))
  .settings(
    name := "Advent of Code 2020",
    description := "Code for the Advent Of Code 2020",
    version := "0.1.0",

    scalaVersion := "3.0.0-M2",

    useScala3doc := true
  )

package com.proyecto.demo

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object EjercicioDatio {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val startTimeMillis = System.currentTimeMillis()
    val conf = new SparkConf().setAppName("Ejercicio").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val patt: String = "Multi-Family"

    val lines = sc.textFile("resources/Sacramentorealestatetransactions.csv")
    val prlin = lines.filter(line => line.contains(patt))
    println(" Lineas donde aparece Multi-Family: ")
     prlin.foreach(println)

    val words: RDD[String] = lines.flatMap(line => line.split(",")).filter(w => w =="Multi-Family")

    val wordCounts = words.countByValue()
    println(" Veces que se repite Multi-Family: ")
    for ((word, count) <- wordCounts) println(word + " : " + count)
    val endTimeMillis = System.currentTimeMillis()
    val durationSeconds = (endTimeMillis - startTimeMillis) / 1000
    println("Tiempo de Ejecucion: " +durationSeconds +" Segundos")

  }
}

package com.comscore

//import scala.collection.immutable.HashMap
import java.util.Date
import java.util.regex.Pattern

import scala.collection.mutable
import scala.collection.mutable.HashMap
import scala.io.Source


/**
  * Created by ravikiran on 12/10/2016.
  */
object ProcessComScoreViewItems extends App {

  /*
    val itemFile:String =
      """STB|TITLE|PROVIDER|DATE|REV|VIEW_TIME
         stb1|the matrix|warner bros|2014-04-01|4.00|1:30
         stb1|unbreakable|buena vista|2014-04-03|6.00|2:05
         stb2|the hobbit|warner bros|2014-04-02|8.00|2:45
         stb3|the matrix|warner bros|2014-04-02|4.00|1:05
      """.stripMargin

  println(itemFile)
  */

  val mapViewItems: mutable.HashMap[String, ViewItem] = new HashMap();

  for (line <- Source.fromFile("G:\\Ravi_Krovvidi\\INTEVIEW\\cscore_items.txt").getLines()) {
    println(line)
    if (!line.equalsIgnoreCase("STB|TITLE|PROVIDER|DATE|REV|VIEW_TIME")) {


      val lineVals: Array[String] = line.split(Pattern.quote("|"))
      println(lineVals(0))


      val key = lineVals(0) + "|" + lineVals(1) + "|" + lineVals(3)
      println(key)

      val vwTimeArr = lineVals(5).split(Pattern.quote(":"))
      println(vwTimeArr(0))
      val vwTimeSeconds = (vwTimeArr(0).toInt) * 60 * 60 + (vwTimeArr(1).toInt) * 60

      val format = new java.text.SimpleDateFormat("yyyy-MM-dd")

      val viewItm = new ViewItem(lineVals(0), lineVals(1), lineVals(2), format.parse(lineVals(3)), lineVals(4).toDouble, vwTimeSeconds)

      println(viewItm)
      mapViewItems += (key -> viewItm)

    }

  }

  print(mapViewItems.size)
}

package com.comscore

import java.util.Date

/**
  * Created by ravikiran on 12/10/2016.
  */
class ViewItem(stb:String,title:String,provider:String,dateLeased:Date,rev:Double,viewTime:Int) {
//
//  var stb: String = stb
//
//  var title: String = null
//
//  var provider: String = null
//  var dateLeased: Date = null
//  var rev: Double = 0.0
//  var viewTime: Int = 0

  def key(): String = {
    stb +"|"+ title +"|"+ dateLeased
  }

  override def toString: String =
    "stb:" + stb + ", " + "title:"+title + ","+ "provider:"+provider + ","+ "dateLeased:"+dateLeased + ","+ "rev:"+rev + ","+ "viewTime:"+viewTime
}

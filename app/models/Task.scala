package models

import anorm._
import anorm.SqlParser._

import org.scalaquery.ql._
import org.scalaquery.ql.TypeMapper._
import org.scalaquery.ql.extended.{ExtendedTable => Table}

import play.api.db._
import play.api.Play.current

import org.scalaquery.ql.extended.H2Driver.Implicit._

import org.scalaquery.session._

case class Task(id: Long, label: String)

object Task extends Table[(Long, String)]("task") {

  lazy val database = Database.forDataSource(DB.getDataSource())

  def id = column[Long]("id", O PrimaryKey, O AutoInc)

  def label = column[String]("label")

  def * = id ~ label

  def all(): List[Task] = List()

  def create(label: String) {
  }

  def delete(id: Long) {
  }

}

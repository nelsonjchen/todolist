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

object Task extends Table[(Long, String)]("TASK") {

  lazy val database = Database.forDataSource(DB.getDataSource("default"))

  def id = column[Long]("ID", O PrimaryKey, O AutoInc)

  def label = column[String]("LABEL")

  def * = id ~ label

  def all(): List[Task] = {
    database.withSession(implicit s => {
      val query = for (u <- Task) yield u
      query.list().map {
        t => Task(t._1, t._2)
      }
    }
    )
  }

  def create(label: String) {
    database.withSession( (s:Session) =>
      Task.label.insert(label)(s)
    )
  }

  def delete(id: Long) {
    database.withSession((s:Session) =>
      Task.delete(id)
    )
  }
}

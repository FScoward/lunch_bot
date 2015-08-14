package util

import scala.util.matching.Regex

/**
 * Created by FScoward on 15/08/14.
 */
object Regex {
  val REGISTER: Regex = """(reg:.*)""".r
  val VOTE: Regex = """(vote:.*)""".r
}

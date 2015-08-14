package service

import scala.util.Random

/**
 * Created by FScoward on 15/08/15.
 */
trait LunchService {
  val list: List[String] = List("弁当", "大戸屋")
  def search(user: String): String = {
    val r = new Random().nextInt(list.length)
    s"@$user ${list(r)}"
  }
  def isLunchSearch(text: String) = {
    text.contains("ランチ")
  }
}
object LunchService extends LunchService {}

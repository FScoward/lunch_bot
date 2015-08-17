package util

import scala.util.matching.Regex

/**
 * Created by FScoward on 15/08/14.
 */
object RegexPattern {
  object Slack {
    val REGISTER: Regex = """(reg:.*)""".r
    val VOTE: Regex = """(vote:.*)""".r
    val VOICE_ACTOR: Regex = """(声優.*)""".r  
  }
  
  object VoiceActor {
    val JPG = """(src="http.*?jpg)""".r
  }
  
}


import akka.actor.ActorSystem
import model.Token
import service.LunchService
import slack.SlackUtil
import slack.rtm.SlackRtmClient
import util.Regex

/**
 * Created by FScoward on 15/08/12.
 */
object Main extends App {
  
  implicit val system = ActorSystem("slack")
  implicit val ec = system.dispatcher
  val client = SlackRtmClient(Token.token)
  val selfId = client.state.self.id

  client.onMessage { message =>
    val mentionedIds = SlackUtil.extractMentionedIds(message.text)
    val channelId: String = message.channel
    
    val GENERAL = client.state.getChannelIdForName("general").getOrElse("")
    val user = client.state.getUserById(message.user).map(_.name).getOrElse("")
    
    channelId match {
      case GENERAL => client.sendMessage(GENERAL, whatToDo(message.text, user))
      case _ => // do nothing
    }
  }
  
  def whatToDo(what: String, user: String): String = {
    what match {
      case Regex.REGISTER(x) => "reg"
      case Regex.VOTE(x) => "vote"
      case _ => if(what.contains("ランチ")) LunchService.search(user) else ""
    }
  }
}


import akka.actor.ActorSystem
import model.Token
import service.{VoiceActorService, LunchService}
import slack.rtm.SlackRtmClient
import util.RegexPattern

/**
 * Created by FScoward on 15/08/12.
 */
object Main extends App {
  
  implicit val system = ActorSystem("slack")
  implicit val ec = system.dispatcher
  val client = SlackRtmClient(Token.token)
  val selfId = client.state.self.id

  client.onMessage { message =>
    val channelId: String = message.channel
   
    val GENERAL = client.state.getChannelIdForName("general").getOrElse("")
    val user = client.state.getUserById(message.user).map(_.name).getOrElse("")
    
    val todo = whatToDo(message.text, user)
    
    channelId match {
      case GENERAL => client.sendMessage(GENERAL, todo)
      case _ => // do nothing
    }
  }
  
  
  def whatToDo(what: String, user: String): String = {
    what match {
      case RegexPattern.Slack.REGISTER(x) => "reg"
      case RegexPattern.Slack.VOTE(x) => "vote"
      case RegexPattern.Slack.VOICE_ACTOR(x) => VoiceActorService.search("")//.getOrElse("") // Await.result ( VoiceActorService.search, Duration.Inf)
      case _ => if(LunchService.isLunchSearch(what)) LunchService.search(user) else ""
    }
  }
}

package service

import java.io.{InputStreamReader, BufferedReader}

import com.google.api.client.http.GenericUrl
import com.google.api.client.http.javanet.NetHttpTransport
import util.RegexPattern
import scala.util.matching.Regex.MatchIterator
import scala.util.{Random, Try, Failure, Success}


/**
 * Created by FScoward on 15/08/15.
 */

trait VoiceActorService {
  
  def createRequest(url: String) = {
    val httpTransport = new NetHttpTransport()
    val requestFactory = httpTransport.createRequestFactory()
    requestFactory.buildGetRequest(new GenericUrl(url))
  }
  
  def getJpgUrl(list: List[MatchIterator]): String = list(Random.nextInt(list.size)).next.substring(5)
  
  def search(voiceActor: String): String = {
    Try {
      val base = "http://animage.tumblr.com/"
      val res = createRequest(base).execute()
      val br = new BufferedReader(new InputStreamReader((res.getContent)))
      val s = Iterator.continually(br.readLine()).takeWhile(_ != null).toList
      val jpgMatchIterList: List[MatchIterator] = s.map(RegexPattern.VoiceActor.JPG.findAllIn(_)).filter(_.nonEmpty)
      res.disconnect()
      getJpgUrl(jpgMatchIterList)
    } match {
      case Success(s) => s
      case Failure(e) => e.getMessage
    }
  }
}

object VoiceActorService extends VoiceActorService

package dispatch.as.argonaut

import com.ning.http.client.Response

import scalaz._, Scalaz._
import argonaut._, Argonaut._

object Json extends (Response => String \/ Json) {
  def apply(r: Response) = (dispatch.as.String andThen (Parse.parse(_)))(r)
}

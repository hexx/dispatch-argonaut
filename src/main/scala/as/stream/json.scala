package dispatch.as.argonaut.stream

import dispatch.stream.StringsByLine

import scalaz._, Scalaz._
import argonaut._, Argonaut._

object Json {
  def apply[T](f: Json => T) =
    new StringsByLine[Unit] {
      def onStringBy(string: String) {
        Parse.parse(string) map f
      }
      def onCompleted = ()
    }
}

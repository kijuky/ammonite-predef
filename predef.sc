// sttp
import $ivy.`com.softwaremill.sttp.client3::core:3.4.1`

// unix like command
def wd = new java.io.File(".").getCanonicalFile
def pwd = wd.getAbsolutePath

// LINE Notify
val line = new {
  import sttp.client3._
  import sttp.client3.quick._

  def notify(message: String): Response[String] = {
    quickRequest.auth
      .bearer(sys.env("LINE_NOTIFY_TOKEN"))
      .post(uri"https://notify-api.line.me/api/notify")
      .body(Map("message" -> message))
      .send(backend)
  }
}

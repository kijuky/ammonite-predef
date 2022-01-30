// predef for repl

// slf4j (nop)
import $ivy.`org.slf4j:slf4j-nop:1.7.35`

// unix like command
def wd = new java.io.File(".").getCanonicalFile
def pwd = wd.getAbsolutePath

// LINE Notify
val line = new {
  private lazy val accessToken = sys.env("LINE_NOTIFY_TOKEN")

  def notify(message: String): requests.Response = {
    requests.post(
      "https://notify-api.line.me/api/notify",
      data = Map("message" -> message),
      headers = Map("Authorization" -> s"Bearer $accessToken")
    )
  }
}

// Twitter
import $ivy.`org.twitter4j:twitter4j-core:4.0.7`
val twitter = new {
  import twitter4j._

  private lazy val facade = new TwitterFactory(
    new conf.ConfigurationBuilder()
      .setDebugEnabled(sys.env("TWITTER4J_DEBUG").toBoolean)
      .setOAuthConsumerKey(sys.env("TWITTER4J_OAUTH_CONSUMERKEY"))
      .setOAuthConsumerSecret(sys.env("TWITTER4J_OAUTH_CONSUMERSECRET"))
      .setOAuthAccessToken(sys.env("TWITTER4J_OAUTH_ACCESSTOKEN"))
      .setOAuthAccessTokenSecret(sys.env("TWITTER4J_OAUTH_ACCESSTOKENSECRET"))
      .build()
  ).getInstance

  def notify(message: String): Unit = {
    facade.updateStatus(message)
  }
}

// Slack
import $ivy.`com.slack.api:slack-api-client:1.17.0`
val slack = new {
  import com.slack.api.Slack
  import com.slack.api.model.block.Blocks._
  import com.slack.api.model.block.composition.BlockCompositions._
  import com.slack.api.webhook.WebhookPayloads._
  import com.slack.api.webhook.WebhookResponse

  private lazy val facade = Slack.getInstance()
  private lazy val webhookUrl = sys.env("SLACK_WEBHOOK_URL")

  def notify(message: String): WebhookResponse = {
    val sections = Seq(section(_.text(markdownText(message))))
    facade.send(
      webhookUrl,
      payload(_.text(message).blocks(asBlocks(sections: _*)))
    )
  }
}

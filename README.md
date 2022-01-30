# ammonite predef

[Ammonite](https://ammonite.io/) の事前定義スクリプトです。

## インストール

```shell
$ git clone https://github.com/kijuky/ammonite-predef.git ~/.ammonite
```

.ammonite フォルダを上書きするため、既に predef.sc を用意している場合はバックアップしてください。

## 使い方

### [LINE Notify](https://engineering.linecorp.com/ja/blog/using-line-notify-to-send-messages-to-line-from-the-command-line/)

[LINE Notifyのマイページ](https://notify-bot.line.me/my/) から、「トークンを発行する」ボタンでアクセストークンを発行する。

```shell
export LINE_NOTIFY_TOKEN="発行したアクセストークン"
```

```
@ line notify "foobar"
```

### Slack

[Slack Incoming-Webhook を追加](https://slack.com/intl/ja-jp/help/articles/115005265063) して Webhook URL を発行する。

```shell
export SLACK_WEBHOOK_URL="発行したWebhook Url"
```

```shell
@ slack notify ":candy: はい、アメちゃん！"
```

slack の表示名でもメンションできます。

#### 参考

- https://slack.dev/java-slack-sdk/guides/ja/incoming-webhooks
- https://slack.dev/java-slack-sdk/guides/ja/composing-messages
  - https://app.slack.com/block-kit-builder

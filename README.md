# ammonite predef

## インストール

```shell
$ git clone https://github.com/kijuky/ammonite-predef.git ~/.ammonite
```

### for mac

```shell
$ brew install ammonite-repl
```

### for windows

TODO

## 使い方

### [LINE Notify](https://engineering.linecorp.com/ja/blog/using-line-notify-to-send-messages-to-line-from-the-command-line/)

[LINE Notifyのマイページ](https://notify-bot.line.me/my/) から、「トークンを発行する」ボタンでアクセストークンを発行する。

```shell
export LINE_NOTIFY_TOKEN="発行したアクセストークン"
```

```
@ line notify "foobar"
```

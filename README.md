# ammonite predef

## install

```shell
$ git clone https://github.com/kijuky/ammonite-predef.git ~/.ammonite
```

### for mac

```shell
$ brew install ammonite-repl
```

### for windows

TODO

## usage

### LINE Notify

[LINE Notifyのマイページ](https://notify-bot.line.me/my/) から、「トークンを発行する」ボタンでアクセストークンを発行する。

```shell
export LINE_NOTIFY_TOKEN="発行したアクセストークン"
```

```
@ line notify "foobar"
```

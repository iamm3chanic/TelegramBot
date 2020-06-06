# TelegramBot
To start with, create 2 classes: _Bot.java_ and _Main.java_. Don't forget abot changing name of project in Procfile and pom.xml.

For proper builing, add all `maven dependencies` in pom.xml accurately.

### Building

As bot needs a server, we will deploy it somewhere. 
We need to write that in console to install `heroku`, login there and create an app with [APP_NAME]:
```bash
  $ sudo dnf[OR_YOUR_PAC_MANAGER] install snap
  $ sudo snap install heroku --classic
  $ heroku login
```
After that we commit it with git:
```bash
  $ git init
  $ git add .
  $ heroku git:remote -a [APP_NAME]
  $ git push heroku master
  $ heroku ps:scale worker=1
```
### Versions
I'll add further versions into new branches.
- The current one will be in telegram, @ImFriendBot
### Thanks
Thanks a lot: 
- javarush.ru
- github.com/dp-ua
- github.com/rubenlagus
- github.com/gbuh

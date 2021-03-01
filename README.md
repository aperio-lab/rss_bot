# RSS BOT
RSS Notification Bot - New candidates home assignment

## The idea
Free style RSS listener application that acts as new content listener, periodicly checking if a website or API has new content on a subscribed topic. 
If topic has new content, a notification message will be sent to a notification channel, notifing all subscribers that new content on particular topic exists, with the content attached.

## Requirements in breaf
* Build a server application (in any programing language that can run on server: Java / Python / NodeJS / Ruby / etc.)
* Once started, that application will check periodicly if new content exists on an RSS feed's particular topic or has the provided keywords.
* If new content posted to the feed, send a message to the subscriber with the new content attached.


## Technical requirements
* __RSS feed API__: https://www.geektime.com/rss/ or https://www.theverge.com/rss/index.xml
* __Periodic interval__: 30 min
* __Topic category__: "cyber security" (Some RSS feeds does not categorize their content, in such case you the BOT will need to seach for the relevant content by key-words: cyber, security etc.
* Upon new relevant content available on the RSS feed, notify the subscriber on his prefered channel: Slack / Telegram / any other application that expose and API that can receive notification (Webhook).

## How to post your home assignment solution
* Clone this repository
* Checkout new branch with your solution
* Create a PR to the main branch
* **Extra** credit will be given for an online demo. You may use any free clound application hosting service such as: [Heroku](https://www.Heroku.com) / [AWS](https://aws.amazon.com/) / [Azure](https://azure.microsoft.com/) / [Google Clound](https://cloud.google.com/) or any other familier to you clound compute service.

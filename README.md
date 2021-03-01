# rss_bot
RSS Notification Bot - New candidates home assignment

## The idea
An pplication that acts as new content listener, periodicly checking if a website or API has new content on a subscribed topic. 
If topic has new content, a notification message will be sent to a notification channel, notifing all subscribers that new content on particular topic exists, with the content included.

## Requirements in breaf
* Build a server application (in any programing language that can run on server: Java / Python / NodeJS / Ruby / etc.)
* Once started, that application will check periodicly (periodic interval will be defined later) if new content exists on an RSS feed (defeined bellow), on a     particular topic (defined later) with the provided keywords (defined below).


## Technical requirements
* RSS feed API: https://www.geektime.com/rss/ or https://www.theverge.com/rss/index.xml
* Periodic interval: 30 min
* Topic category: "cyber security" (Some RSS feeds does not categorize their content, in such case you the BOT will need to seach for the relevant content by key-words: cyber, security etc.
* Upon new relevant content available on the RSS feed, notify the subscriber on his prefered channel: Slack / Telegram / any other application that expose and API that can receive notification (Webhook).

## How to post your home assignment solution
* Clone this repository
* Checkout new branch with you solution
* Create a PR to develop

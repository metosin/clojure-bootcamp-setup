# Setup-test

This repo has a simple Clojure and ClojureScript application. The purpose of this repo is to make sure you have
your environment ready for the training.

This project has a lot of dependencies. This simple setup application doesn't need them all, but depending on
them will populate your local cache with them so that when we use them in training, you'll already have them.

## Prerequisites

You need:

* Laptop, with Linux, Mac OS X, or recent Windows

Note, if you have Linux or Mac, you can install these using your package manager. In case 
of Mac, use [homebrew](http://brew.sh) with [cask](http://caskroom.io).

* JDK 1.8 _(or later)_: http://java.oracle.com
* Leiningen 2.5.0 _(or later)_: http://leiningen.org
* git: http://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* github account: https://github.com/join
* MongoDB: http://docs.mongodb.org/manual/installation/
* httpie: https://github.com/jakubroztocil/httpie

## Optional

At the end of training you have developed a small Web application that you can deploy to [Heroku](https://heroku.com/).
This is not mandatory, but if you would like to do that, you'll need:

* Heroku account: https://signup.heroku.com/
* Heroku toolbelt: https://devcenter.heroku.com/articles/getting-started-with-clojure#set-up

## Running setup application

```bash
git clone git@github.com:metosin/clojure-bootcamp-setup.git
cd clojure-bootcamp-setup
lein do cljsbuild once, ring server
```

When run for the first time Leiningen shows how it downloads half of the internet (the better half) to
your HD and then it compiles the application. This might take a some time (like 30 sec or so). Don't worry,
the normal development cycle is usually less than 1 sec. Once the dependencies are downloaded and the
application started it should open a browser and show you a greeting message. If that's what you get it
means that you, and your machine, are ready for the training. If something did not work as intended, contact
us for help.

You can stop the application with `ctrl-c`.

## Setup your IDE

### General

The development process for Clojure is radically different from Java development process. Likewise, the features
that you'll want from your IDE are also different.

The important features that you should look for in Clojure IDE are:

* REPL, the IDE should allow access to project REPL
* Evaluating from source, you should be able to select part of source code and send it to REPL for evaluation

### IntelliJ IDEA with Cursive

IDEA has two Clojure plugins, the old La Clojure and the new and shiny Cursive. Follow the instructions for
installing Cursive in here https://cursiveclojure.com/userguide/

Import the project as described in this page https://cursiveclojure.com/userguide/leiningen.html

### Eclipse

Clojure plugin for Eclipse is Counterclockwise. Follow the instructions at http://doc.ccw-ide.org to install
Counterclockwise plugin to your Eclipse. Once you have Counterclockwise installed you can continue.

To open a Clojure project in CCW:

- Drag-and-drop file from somewhere to your Eclipse and Eclipse should ask if you want to find the projects from the dir
- *or*, `File` -> `New` -> `Project`
  - `General` -> `Project`
  - Give project a name
  - Uncheck `Use default location` and select the directory to which you have cloned this repo
- CCW will detect the `project.clj` and configure the project accordingly

In the project, open the `src/clj` -> `setup` -> `server.clj` file, right click on the source file and
`Clojure` -> `Load file in REPL`. Eclipse now starts JVM, starts the Clojure REPL in it, and loads the `server.clj`
file into it. You should now have the REPL window open. Type into it `(run)` and hit enter. You should see a message
`"App running..."`, the application is now ready and listening HTTP traffic on port 8080. Open your browser to
http://localhost:8080/.

For 2nd day of training, it might be useful to configure your Eclipse so that it recognize ```.cljc``` files as
Clojure sources. Follow [these](https://github.com/lynaghk/cljx#user-content-eclipse--counterclockwise) instructions
for ```Eclipse + CounterClockwise```, but substitute ```.cljx``` with ```.cljc```.

### Vim

See https://gist.github.com/Deraen/da73db508e75eb4aad71 for list of few useful plugins and settings.

### Emacs

See https://github.com/clojure-emacs/cider

### Others

See at http://dev.clojure.org/display/doc/IDEs+and+Editors

# Setup-test

This repository has a simple Clojure and ClojureScript application. The
purpose of this application is to make sure you have your environment
ready for the training.

## Prerequisites

You need:

* Laptop with Linux, Mac OS X, or recent Windows

Note, if you have Linux or Mac, you can install these using your package
manager. In case of Mac, use [homebrew](http://brew.sh) with
[cask](http://caskroom.io).

* JDK 1.8 _(or later)_: http://java.oracle.com
* Leiningen 2.7.2 _(or later)_: http://leiningen.org
* Boot 2.6.0 _(optional)_: http://boot-clj.com (requires Windows 10)
* git: http://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* github account: https://github.com/join
* httpie _(optional)_: https://github.com/jakubroztocil/httpie
* IDE with Clojure support (more details below)

## Running this application

This project has simple Clojure/ClojureScript application. By running
this you can ensure that your development setup is ok.

Also, this project has dependencies to (most) of the libraries will be
using in training, so building this project ensures that you'll have the
dependencies in your local hard-drive. Sometimes the wlan in trainings
chokes when everybody tries to pull these at the same time.

After installing the prerequisites listed above, do this:

```bash
git clone git@github.com:metosin/clojure-bootcamp-setup.git
cd clojure-bootcamp-setup
lein welcome
```

You should see a page with greeting message. You can stop the
application with `ctrl-c`.

## Setup your IDE

### General

The development process for Clojure is radically different from Java
development process. Likewise, the features that you'll want from your
IDE are also different.

The important features that you should look for in Clojure IDE are:

* REPL, the IDE should allow access to project REPL
* Evaluating from source, you should be able to select part of source
  code and send it to REPL for evaluation

### IntelliJ IDEA with Cursive

IDEA has two Clojure plugins, the old La Clojure and the new and
shiny Cursive. Follow the instructions for installing Cursive in
here https://cursiveclojure.com/userguide/

Import the project as described in this page
https://cursiveclojure.com/userguide/leiningen.html

### Vim

See https://github.com/tpope/vim-fireplace

### Emacs

See https://github.com/clojure-emacs/cider

### Others

See at http://dev.clojure.org/display/doc/IDEs+and+Editors

## Optional Heroku account

At the end of training you have developed a small Web application that
you can deploy to [Heroku](https://heroku.com/). This is not mandatory,
but if you would like to do that, you'll need:

* Heroku account: https://signup.heroku.com/
* Heroku toolbelt: https://devcenter.heroku.com/articles/getting-started-with-clojure#set-up

Mac users can install Heroku toolbelt using `brew install heroku`.

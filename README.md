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
* Leiningen 2.5.0 _(or later)_: http://leiningen.org
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

### Visual Studio Code with Calva

Microsoft Visual Studio Code has [Calva][calva] plugin for Clojure code.  The
plugin can be installed through the Visual Studio Marketplace (just click the
"Extensions" icon and search for "Calva"). Once installed you can open a
Clojure project as follows:

- Close existing workspace if you have one open.

- Open the project folder through `File` -> `Add Folder to Workspace`.
- Open a new terminal `Terminal` -> `New Terminal` which should open into the
  project root.

- Start nREPL with `lein repl`

- Open a `.clj` file (in our example case the file
  `src/clj/setup/server.clj`). You should observe a bright "nREPL⚡" icon
  (located in the bottom left footer area) indicating a live nREPL
  connection. In case there is no active connection you can try to connect
  manually:

  - Go to the terminal and note the nREPL port from the first line of the
    process output.

  - Start connecting by pressing `Ctrl+Alt+v` `c` and supply the (host and)
    port when/if asked for it.

- See Calva's [Github page][calva-github] for information about how to use the
  plugin.

[calva]: https://marketplace.visualstudio.com/items?itemName=cospaia.clojure4vscode
[calva-github]: https://github.com/BetterThanTomorrow/calva

### Eclipse

Clojure plugin for Eclipse is Counterclockwise. Follow the instructions
at http://doc.ccw-ide.org to install Counterclockwise plugin to your
Eclipse. Once you have Counterclockwise installed you can continue.

To open a Clojure project in CCW:

- Drag-and-drop the project directory to Eclipse and it should ask if
  you want to find the projects from the dir
- *or*, `File` -> `New` -> `Project`
  - `General` -> `Project`
  - Give project a name
  - Uncheck `Use default location` and select the directory to which
    you have cloned this repo
- CCW will detect the `project.clj` and configure the project accordingly

In the project, open the `src/clj` -> `setup` -> `server.clj` file,
right click on the source file and `Clojure` -> `Load file in REPL`.
Eclipse now starts JVM, starts the Clojure REPL in it, and loads the
`server.clj` file into it. You should now have the REPL window open.
Type into it `(run)` and hit enter. You should see a message
`"App running..."`, the application is now ready and listening HTTP
traffic on port 8080. Open your browser to http://localhost:3000/.

For 2nd day of training, it might be useful to configure your Eclipse
so that it recognize ```.cljc``` files as Clojure sources. Follow
[these](https://github.com/lynaghk/cljx#user-content-eclipse--counterclockwise)
instructions for ```Eclipse + CounterClockwise```, but substitute
```.cljx``` with ```.cljc```.

### Vim

See https://gist.github.com/Deraen/da73db508e75eb4aad71 for list of few
useful plugins and settings.

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

# Setup-test

This repo has a simple Clojure and ClojureScript application. The purpose of this repo is to make sure you have your environment ready for the training.

This project has a lot of dependencies. This simple setup application does not need them, but when you build this the Leiningen build tool will load and cache them to your local hard-drive.

## Prerequisites

You need:

* JDK 1.6 _(or later)_: http://java.oracle.com
* Leiningen 2.5.0 _(or later)_: http://leiningen.org

## Running setup application

```bash
git clone git@github.com:metosin/clojure-bootcamp-setup.git
cd clojure-bootcamp-setup
lein do cljsbuild once, ring server
```

When run for the first time Leiningen shows how it downloads half of the internet (the better half) to your HD and then it compiles the application. This might take a some time (like 30 sec or so). Don't worry, the normal development cycle is usually less than 1 sec. Once the dependencies are downloaded and the application started it should open a browser and show you a greeting message. If that's what you get it means that you, and your machine, are ready for the training. If something did not work as intended, contact us for help.

You can stop the application with `ctrl-c`.

## Setup your IDE

### General

The development process for Clojure is radically different from Java
development process. Likewise, the features that you'll want from your
IDE are also defferent.

The important features that you should look for in Clojure IDE are:

* REPL, the IDE should allow access to project REPL
* Evaluating from source, you should be able to select part of source code and send it to REPL for evaluation

### Eclipse

Clojure plugin for Eclipse is Counterclockwise. Follow the instructions at
http://doc.ccw-ide.org to install Counterclockwise plugin to your Eclipse.
Once you have Counterclockwise installed you can continue.

To open a Clojure project in CCW:

- Drag-and-drop file from somewhere to your Eclipse and Eclipse should ask if you
want to find the projects from the dir
- *or*, `File` -> `New` -> `Project`
    - `General` -> `Project`
    - Give project a name
    - Uncheck `Use default location` and select the directory to which you have
    cloned this repo
- CCW will detect the `project.clj` and configure the project accordingly

In the project, open the `src/clj` -> `setup` -> `server.clj`
file, right click on the source file and `Clojure` -> `Load file in
REPL`. Eclipse now starts JVM, starts the Clojure REPL in it, and loads
the `server.clj` file into it. You should now have the REPL window
open. Type into it `(run)` and hit enter. You should see a
message `"App running..."`, the application is now ready and
listening HTTP trafic on port 8080. Open your browser to http://localhost:8080/.

For 2nd day of training, it might be useful to condigure your Eclipse for
[cljx](https://github.com/lynaghk/cljx#eclipse--counterclockwise).

### IntelliJ IDEA with Cursive

IDEA has two Clojure plugins, the old La Clojure and the new and shiny
Cursive. Follow the instuctions for installing Cursive in here
https://cursiveclojure.com/userguide/

Import the project as decribed in this page https://cursiveclojure.com/userguide/leiningen.html

### Vim

See https://gist.github.com/Deraen/da73db508e75eb4aad71 for list of few useful plugins and settings.

### Emacs

See https://github.com/clojure-emacs/cider

### Others

See at http://dev.clojure.org/display/doc/IDEs+and+Editors

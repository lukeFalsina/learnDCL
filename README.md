# Learn Dynamic Code Loading (DCL)

We recently designed and implemented a new Android library that eases the
proper implementation of Android apps that rely on **dynamic code loading**
(DCL).

With this experiment, we want to determine whether our work actually helps
Android developers! Your help will be *incredibly* useful to evaluate and
improve our research effort!

This experiment is structured in two parts. First, we will ask you to implement
a specific functionality using one of the standard Android API (no worries, we
will provide all the details later! :-)). Second, we will ask you to implement
the same functionality, using the new library we designed.

Our goal is to evaluate how our library helps an Android developer in writing a
functionality based on **dynamic code loading**. We are currently interested in
evaluating several aspects, such as efficiency, code readability, security, and
maintainability of the code.

For this experiment, we will give you a *toy application* to play with, and we
will ask you to implement several additional functionality (again, all the
details later). Note: Even if the application is not a real, full-fledge
Android app, we ask you to treat such app as it were your most successful app
on the Google official app store, with millions of users!

Again, *you will play with a toy example, but, for the purpose of this
experiment, treat as it were real*! We stress this point as playing a toy app
might lead you to write sloppy/hacky code. This, unfortunately, will invalidate
the results of this experiment! So, once again, be ready to write code you can
be proud of!! :-)

Alright, let's start!

## Requirements

Double check that you are set with these tools:

1. **Android Studio + Gradle:** You must have a working version of this *IDE*
   installed on your machine. In the case that you do not, you can get the
   latest running version by following instructions reported
   [here](http://developer.android.com/sdk/index.html).

2. **Git:** In order to move properly between the different branches that I
   have set up, you will need this version control system. Grab the latest
   version of it [here](http://git-scm.com/downloads); in case you are
   completely new to *Git*, you may prefer to first become confident with it
   before moving on. On the net you may find several good tutorials for Git, a
   cool one is [Try Git](https://try.github.io/levels/1/challenges/1) but there
   are just so many of them..

## Phase 1

You will practice how to use the `DexClassLoader` class by filling in the
missing parts in a simple skeleton application, in order to download code from
remote location and execute it.

Note: do **not** read/continue to Phase 2 until you are done with this one! No
spoilers!

Here is a walk through on what you are expected to do:

* Fork this repository from your Github account. Why forking and not cloning?
  You can clone, if you prefer. However, by forking you’re helping us to keep
  track of who is participating to our research project, to better understand
  how developers like you use DCL.

```
  https://github.com/lukeFalsina/learnDCL
```
* Create a first branch called *dcl* and invoke **checkout** on it to change
  branch. You will use this branch to save your first implementation of the
  sample app project.

``` bash
    $ git branch dcl
    $ git checkout dcl
```
* Open the project contained in the root folder with *Android Studio*.
* Read **carefully** the class `MainActivity.java` in the `app` module. Part of
  the code are purposely missing: I expect you to implement them :) Follow
  the step-by-step instructions in the comments to understand
  exactly what to do. Please bear in mind that you are expected to write a
  secure, working application.
* Perform this simple **"Repack"** test:
    * Run your working app as it is now and see how it behaves.
    * Once done, modify the string `APK_CONTAINER_URL` inside
      the `MainActivity.java` class from its current value to

```
    https://dl.dropboxusercontent.com/u/28681922/HelperAppRepack.apk
```

    * Save and run again the application.
    * Can you spoil any difference between the two executions? What is the
      final outcome in this second test case compared to the first one?
* Once done, just commit your changes (`git commit`) and shoot us a message via
  Github. Alternatively, you can send us a pull request to let us know that you
  are done. In either case, please tell us the outcome of the *”Repack”* check.

## Phase 2

For this phase, we will ask you to implement a very similar functionality, this
time by using our new library! The library you will need to use is called
**Grab'n run (GNR)**, which is available at
[http://www.grabnrun.org](http://www.grabnrun.org).

Here are the details on how to continue!


* Now checkout the `secure` branch and then create a new branch called
  `securedcl`. This new branch will record your second implementation of the
  example application. 

``` bash
    $ git checkout secure
    $ git branch securedcl
    $ git checkout securedcl
```
* If you turn back your attention to the *Android Studio* editor, you will
  notice that the code that you have just implemented vanished and it was
  substituted by a different implementation of the `MainActivity.java` class.
* Now go through the comments to understand exactly what you are supposed to
  do. Basically, you will now implement the same application you did
  before but this time you will learn how to use **Grab'n Run (GNR)** APIs
  instead of the native `DexClassLoader` APIs.
* Once your app works correctly again, perform the same "Repack" test explained
  before.

    * Can you notice any difference between this execution of the test and the
      one that you did before? If yes, awesome ;)

* Once more, remember to commit and send us a pull request, or a Github
  notification.

## Phase 3

In addition to your code, we would like to received your build files.

* Zip your "LearnDCL" folder and send it to lfalsina@gmail.com
* Complete this [form](http://goo.gl/forms/k500h7cYiv) on DCL and Grab'n Run.

This will be a tremendous help to make GNR library a better and more flexible tool :)

Thanks in advance for your time playing with this tutorial and I hope you enjoyed it!

In case you get stuck or you have questions and/or suggestions, you are more than welcome to contact me by email :)

Happy coding :D

*Luca*

# Learn DCL (Dynamic Code Loading)

The goal of this repository is helping *Android* developers get more confident with **remote dynamic code loading**. With this tutorial you will practice how to use standard *DexClassLoader* class by completing a simple skeleton application, which makes use of DCL from a remote source. After this first step, you will also learn how to implement the very same functionality by means of [Grab'n Run](https://github.com/lukeFalsina/Grab-n-Run), a simple and neat Java library to secure DCL. My personal hope is that you will be able to **reuse later on** in your Android applications what you are just going to learn here :)

## Requirements

Before heading to the walk through, you should double check this brief requirements list:

1. **Android Studio + Gradle:** You must have a working version of this *IDE* installed on your machine. In the case that you do not, you can get the latest running version by following instructions reported [here](http://developer.android.com/sdk/index.html).
2. **Git:** In order to move properly between the different branches that I have set up, you will need this version control system. Grab the latest version of it [here](http://git-scm.com/downloads); in case you are completely new to *Git*, you may prefer to first become confident with it before moving on. On the net you may find several good tutorials for Git, a cool one is [Try Git](https://try.github.io/levels/1/challenges/1) but there are just so many of them..
3. **Time and patience (to taste):** As it occurs every time that you need to learn something new, also here you may take a while to figure out what you are supposed to do. Anyway don't panic! This won't be a very difficult tutorial :) Of course having any previous experience with Android app development will sensibly help to speed things up..  

## Walk through

Here is a *walk through* on what you are expected to do:

* Clone this repository onto your local machine.

``` bash
        $ git clone https://github.com/lukeFalsina/learnDCL.git
```
* Create a first branch called *dcl* and invoke **checkout** on it to change branch. You will use this branch to save your first implementation of the sample app project.

``` bash
		$ git branch dcl
		$ git checkout dcl
```
* Open the project contained in this folder in *Android Studio*.
* Study **carefully** the class *"MainActivity.java"* in the *app* module. Some parts of its code implying remote dynamic code loading are missing and I expect you to implement them :) Follow the step by step instructions in the comments of that Java class to learn exactly what to do. Please bear in mind that you are expected to write an **application** that, it *not only works fine*, but is also **secure**! I mean, as developers, we want our users to get only the best or aren't we? :) 
* Once that you are done and the application is fully working remember to **COMMIT** your changes (git commit).

	Perform also this simple **"Repack"** test:

	* Run your working app as it is now and see how it behaves.
	* Once that you are done, modify the string **APK_CONTAINER_URL** inside of the *"MainActivity.java"* class from its current value to "https://dl.dropboxusercontent.com/u/28681922/HelperAppRepack.apk"
	* Save and run again the application.
	* Can you spoil any difference between the two executions? What is the final outcome in this second test case compared to the first one?

* Now checkout the *secure* branch and then create a new branch called *"securedcl"*. This new branch will record your second implementation of the example application. 

``` bash
        $ git checkout secure
        $ git branch securedcl
		$ git checkout securedcl
```
* If you turn back your attention to the *Android Studio* editor, you will notice that the code that you have just implemnted vanished and it was substituted by a different implementation of the class *"MainActivity.java"*. This is absolutely **NORMAL** and it happens since you have switched your repository to a different branch.
* Once again inspect **carefully** the comments in the class *"MainActivity.java"* to learn exactly what you are supposed to do. Basically you will now implement the same kind of application you did before but this time you will learn how to use **Grab'n Run (GNR)** APIs instead of standard *DexClassLoader*.
* Once that you are done with the steps depicted in the comments and your app works correctly again, perform the same "Repack" test explained before.

	* Can you notice any difference between this execution of the test and the one that you did before? If yes, awesome ;)

* Once more remember to **COMMIT** your current code implementation :)
* If you want to help my research, you have to perform two further steps that would be greatly appreciated:

	* Zip your "LearnDCL" folder and send it to lfalsina@gmail.com
	* Complete this [form](http://goo.gl/forms/k500h7cYiv) on DCL and Grab'n Run.

	This will be a tremendous help to make GNR library a better and more flexible tool :)

Thanks in advance for your time playing with this tutorial and I hope you enjoyed it!

In case you get stuck or you have questions and/or suggestions, you are more than welcome to contact me by email :)

Happy coding :D

*Luca*

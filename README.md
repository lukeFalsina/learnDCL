# Learn DCL (Dynamic Code Loading)

Here is a brief walk through on what you are expected to do:

* Clone this repository onto your local machine.

``` bash
        $ git clone https://github.com/lukeFalsina/learnDCL.git
```
* Open this project in Android Studio.
* Create a first branch called *"dcl"* and invoke *checkout* on it to change branch.

``` bash
		$ git branch dcl
		$ git checkout dcl
```
* Give a look at class "MainActivity.java". Some of its code implying dynamic code loading is missing and you will have to implement that functionality :)
* Once that you are done and the application is fully working remember to **COMMIT** your changes (git commit).

	Perform also this simple **"Repack"** test:

	* Run your working app as it is now.
	* Once that you are done, modify the string **APK_CONTAINER_URL** inside of the *"MainActivity.java"* class from its current value to "https://dl.dropboxusercontent.com/u/28681922/HelperAppRepack.apk"
	* Save and run again the application.
	* Could you spoil any difference between the two executions? What is the final outcome in this second test case compared to the first one?

* Now checkout the master branch again and then create a new branch *"securedcl"*

``` bash
        $ git checkout master
        $ git branch securedcl
		$ git checkout securedcl
```
* Next you will have to setup the GNR library in your project. Then implement again the very same functionality but this time use **SecureDexClassLoader** in stead of standard *DexClassLoader*.
	* You may need to refer to GNR main [Github](https://github.com/lukeFalsina/Grab-n-Run) page or its [documentation](http://grab-n-run.readthedocs.org/en/latest/tutorial.html).
* Once that you are done and your app works correctly again, perform the same "Repack" test explained before.

	* Did you notice any difference between this run of the test and the one that you performed before? If yes, awesome ;)

* Once more remember to **COMMIT** your code implementation with GNR :)
* If you want to help my research, you could perform two further steps that would be greatly appreciated:

	* Zip your "LearnDCL" folder and send it to lfalsina@gmail.com
	* Complete this [form](http://goo.gl/forms/k500h7cYiv) on DCL and Grab'n Run.

	This will be a tremendous help to make our library a better and more flexible tool :)

Thanks in advance for your time playing with this tutorial and I hope you enjoyed it!

Happy coding :D

*Luca*
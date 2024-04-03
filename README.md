# Wally Installation For The Current Versioning (wally 1.6.1)
- Install android studio https://developer.android.com/studio
- Download and extract wally. From this repo
- Open android studio and click open
- select the wally project folder that contains the models, dataprovider, and wally modules along with the build.gradle file
- upon opening click the settings icon in the top right corner
- click settings
- click the build, execution, deployment dropdown
- click the build tools drop down
- select gradle
- in the gradle menu press the Gradle JDK dropdown and click download jdk
- click the version dropdown and select 15 (causes compilation errors otherwise)
- click download
- click apply then ok
- while that is installing click the settings icon again
- click project structure
- select project and make sure the android gradle plugin version is 3.4.1 and you select 6.7 as the gradle version for the project.
- click apply and then ok (ignore the problems if any pop up)
- after doing all this it may take a bit because its installing sdk build tools and stuff
- this should be it for wally setup

# PIT MUTATIONS/PITEST
- In the top right beside the run icon there is a drop down with run configurations. The PIT Mutation tests should be under those configurations
- If you have the PIT Mutation plugin installed for Android Studio the following is not relevant
- First click the settings icon in the top right corner
- Click plugins
- Search "pit mutation"
- Click the first one that is returned and click install and click accept on any popup
- Press ok.
- The run configurations should now have the PIT mutations work on run.
- To view the full report just click the "Open report in browser" in the output.

# Running JUNIT
- Any of tests (depending on the layout) should be under its own folder called test from within the module that contains the class being tested.
- You can right click the name of the test and click run.



# AFTER THIS IS THE READ ME FOR DEFAULT WALLY
Wally
=====

Wally is a fast and efficient open source wallpaper application for Android.

![](assets/wally_logo.png)

Wally gets its source of images from [Wallhaven][1]. By scraping the website, it provides the user
with a fast and smooth experience filled with subtle animations and a minimal design. The main goal
of Wally is to provide the same functionality as the website but in a more mobile friendly way.

Development
-----------
Wally is a gradle project built with Android Studio 0.8.x. To get started, import the project in
Android Studio by choosing the <code>build.gradle</code> located in the root folder.

However, you might notice that it won't build right away. This is because you have to provide it
with/generate your own release- and debug keystore. The debug keystore can be generated the same
way as a release keystore. Put the release- and debug keystore files in a directory of your choice
and reference them in a <code>local.properties</code> file in the root folder of this project.

Architecture
------------
Wally is divided into multiple modules; Models, Data Provider, and the main module Wally (UI). This
architecture allows a project to more easily expand to other platforms (e.g. Android Wear
or Android Auto).

License
-------
Apache 2.0 where applicable. See LICENSE file for details.

Contributing
------------
Pull requests are welcome!

Thanks
------
* All alpha testers.
* Everyone who has contributed ideas and reported issues!

Author
------
Freddie Lust-Hed - @musenkishi

Disclaimer
---------
This is not an official Wallhaven product.

[1]: http://alpha.wallhaven.cc
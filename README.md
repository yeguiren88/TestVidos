![image](https://github.com/yeguiren88/TestVidos/blob/master/imgs/112.png)
![image](https://github.com/yeguiren88/TestVidos/blob/master/imgs/113.png)
![image](https://github.com/yeguiren88/TestVidos/blob/master/imgs/114.png)
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

    gradle
    maven
    sbt
    leiningen

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Copy

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.yeguiren88:TestVidos:1.0'
	}

# EMA
https://developer.android.com/studio/releases/gradle-plugin

Faster R class generation for library projects: Previously, the Android Gradle plugin would generate an R.java file for each of your project's dependencies and then compile those R classes alongside your app's other classes. The plugin now generates a JAR containing your app's compiled R class directly, without first building intermediate R.java classes. This optimization may significantly improve build performance for projects that include many library subprojects and dependencies, and improve the indexing speed in Android Studio

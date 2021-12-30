# GradientTextView
A customized view project. TextView with gradient text.

# Reference
[Publish your Android library to jCenter](https://medium.com/@LopezMikhael/publish-your-android-library-to-jcenter-5c6df287db11)
# Potential Issues
* Skipping upload for missing file 'xx/../pom-default.xml'
  * Run <b> ./gradlew `--stacktrace --info` clean build generatePomFileFor`xxx`Publication bintrayUpload -PbintrayUser=<bintray name> -PbintrayKey=<bintray key> -PdryRun=false</b> 
    * where, `--stacktrace --info` is for debugging and optional; `xxx` means your publication name, in my case, it's `MyPublication`
# Adding to your project
* Add following configuration in your build.gradle file.

```
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'me.bytebeats:gtv:1.0.0'
}
```

# Usage

```
        <me.bytebeats.gtv.GradientTextView
            android:id="@+id/force_gradient"
            app:gtv_forceGradient="true"
            app:gtv_startColor="@color/yellow_ffe"
            app:gtv_endColor="@color/yellow_ce"
            android:layout_width="0dp"
            android:gravity="center"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:text="force gradient" />

```
# Visual Effects

![screenshot](screenshots/gtv_screenshot.png)
 
 # MIT License

    Copyright (c) 2021 Chen Pan

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

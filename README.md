# 🌟 Welcome to TextWithSubText Library

[![](https://jitpack.io/v/JoyRay0/TextWithSubText.svg)](https://jitpack.io/#JoyRay0/TextWithSubText)

### 🧩 A lightweight and customizable Android library for displaying a main title with a subtext — perfect for lists, settings screens, or profile sections.
### It supports custom text styles, colors, and drawables (start & end) with flexible padding, making your UI cleaner and more elegant.  


## ✨ Preview  

<p align="start">
  <img src="preview.png" height="600" alt="Preview" />
</p>



## 🚀 How to Use

### 1️⃣ Add JitPack Repository

### Add the following line to your `settings.gradle` or `settings.gradle.kts` file 👇

```
gradle


maven { url = uri("https://jitpack.io") }
```

### Your repositories block should look like this:

```
gradle

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // Now paste here
    }
} 
```

## 2️⃣ Add Dependency

### In your `app/build.gradle` file, add:

__Groovy DSL__

``` 
implementation 'com.github.JoyRay0:TextWithSubText:$release Version'
 ```

 __Kotlin DSL__
 ```
 implementation("com.github.JoyRay0:TextWithSubText:$release version")
 ```

### 🧱 XML Example

```
<com.rk_softwares.textwithsubtext.TextWithSubText
    android:id="@+id/text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:mainText="Hello"
    app:mainTextSize="14sp"
    app:mainTextColor="#000"
    app:mainTextStyle="bold"
    app:subText="World"
    app:subTextSize="12sp"
    app:subTextColor="#625959"
    app:subTextStyle="bold"
    app:drawableStart="@drawable/ic_android"
    app:drawableEnd="@drawable/ic_forward_"
    app:drawablePadding="10dp"
    />
```

### 🧠 Customize in Java
```
java


TextWithSubText text = findViewById(R.id.text);

text.setMainText("Hello")
text.setSubText("World")
text.setMainTextColor("#000000")
text.setSubTextColor("#000000")
text.setMainTextSize(30)
text.setSubTextSize(20)
text.setMainTextStyle(Typeface.BOLD)
text.setSubTextStyle(Typeface.NORMAL)
text.drawableStart(R.drawable.ic_android)
text.drawableEnd(R.drawable.ic_forward_)
text.drawablePadding(10)
```
 
### 🧠 Customize in Kotlin
```
kotlin


val text: TextWithSubText = findViewById(R.id.text)

text.setMainText("Hello")
text.setSubText("World")
text.setMainTextColor("#000000")
text.setSubTextColor("#000000")
text.setMainTextSize(30)
text.setSubTextSize(20)
text.setMainTextStyle(Typeface.BOLD)
text.setSubTextStyle(Typeface.NORMAL)
text.drawableStart(R.drawable.ic_android)
text.drawableEnd(R.drawable.ic_forward_)
text.drawablePadding(10)
```
 
### 💖 Special Thanks

__I would like to express my heartfelt thanks to everyone who uses or contributes to TextWithSubText.
Your support, feedback, and contributions inspire me to make this library even better.__

_Every suggestion, bug report, and pull request helps this project grow stronger.
Together, we’re building something simple, elegant, and useful for the Android community._

__💬 Thank you for being a part of this journey — your encouragement means the world! 🌍💫__


## ⚖️ License

__MIT License — Use freely in your projects, commercial or personal.__

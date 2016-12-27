# greenDao3
greenDao3 数据库配置、增删改查及升级 简单打造本地数据库


* 步骤
* 1.依赖 首先在project项目中的build.gradle 中添加如下代码


```java
   buildscript {
  repositories {
    jcenter()
  }
  dependencies {
    classpath 'com.android.tools.build:gradle:2.0.0'
    classpath 'org.greenrobot:greendao-gradle-plugin:3.1.0'
    classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' //这个是黄油刀的注解

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}
```


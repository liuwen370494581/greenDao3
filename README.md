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

* 2.依赖 在modele中的build.gradle 中添加如下代码


```java
      apply plugin: 'com.android.application'
      apply plugin: 'org.greenrobot.greendao'
    android {
      compileSdkVersion 23
      buildToolsVersion "25.0.0"
      
      
        buildTypes {
    release {
      minifyEnabled false
      proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
  }
}
//greendao配置
greendao {
  schemaVersion 2                             //版本号，升级时可配置
  daoPackage 'com.inst.greendao3_demo.dao'     //包名
  targetGenDir 'src/main/java'                 //生成目录
  
  
  
dependencies {
  compile fileTree(dir: 'libs', include: ['*.jar'])
  testCompile 'junit:junit:4.12'
  compile 'com.android.support:appcompat-v7:23.0.1'
  compile 'org.greenrobot:greendao:3.2.0'
}
```

* 3.然后可以新建一个实体类 然后点击工具栏中的build-----make project 会自动生成相应的dao类
* 4.使用方法可以看代码了。

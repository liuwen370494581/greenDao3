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
    schemaVersion 6                       //版本号，升级时可配置
    daoPackage 'star.liuwen.com.endgreendao3.Dao'     //包名
    targetGenDir 'src/main/java'                 //生成目录
  
  
  
dependencies {
  compile fileTree(dir: 'libs', include: ['*.jar'])
  testCompile 'junit:junit:4.12'
  compile 'com.android.support:appcompat-v7:23.0.1'
  compile 'org.greenrobot:greendao:3.2.0'
}
```

* 3.然后可以新建一个实体类 然后点击工具栏中的build-----make project 会自动生成相应的dao类


```java

@Entity
public class UserInfo {

    @Id
    public long id;
    public String name;
    public String tel;
    public String address;
}
```

* 切记 id一定是long型的 不然插入数据的时候会报错的
* 4.升级不删除老数据 
```java

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.e("greenDAO",
                "Upgrading schema from version " + oldVersion + " to " + newVersion + " by migrating all tables data");
         //完全自动升级本地数据库 要升级那个bean 只需要调用下面这个方法 
        // MigrationHelper.getInstance().migrate(db, xxx.class);
        MigrationHelper.getInstance().migrate(db, TestDao.class);
    }
}
```
![](https://github.com/liuwen370494581/greenDao3/blob/master/image/IMG_0049_%E5%89%AF%E6%9C%AC.jpg) 

* 上面图 我是升级了一个desc的字段 发现之前的数据依旧保存 记得 要添加某个实体的字段  schemaVersion 一定要大于当前版本 也就说当前版本是6 那么升级的需   要设置为7  才会有保存之前数据的作用 大家可以多试几次.

* 5.使用方法可以看代码了。

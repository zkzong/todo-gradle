# todo-gradle

## 打包成jar
Tasks -> build -> jar

打包后的文件放在build/libs目录下

使用下面命令执行：
```
java -classpath build/libs/todo-gradle-1.0-SNAPSHOT.jar com.zkzong.gradle.todo.App
```

## 打包成war
Tasks -> build -> war

## Task
自定义任务在Tasks -> other

## 冲突构建失败和指定版本

```
configurations.all {
    resolutionStrategy {
        failOnVersionConflict()
        force 'org.slf4j:slf4j-api:1.7.22'
    }
}
```

## 所有项目中应用Java插件
根目录下的build.gradle中添加：
```groovy
allprojects {
    apply plugin: 'java'
    sourceCompatibility = 1.8
}
```
## web子项目打包成war
web模块的build.gradle中添加：
```groovy
apply plugin: 'war'
```

## 所有项目添加logback日志功能
根目录下的build.gradle中添加：
```groovy
subprojects {
    repositories {
        mavenCentral()
    }
    dependencies {
        compile group: 'ch.qos.logback', name: 'logback-classic', version: '1.2.3'
    }
}
```
## 统一配置group和version

两种方式：gradle.properties和ext

### 1. gradle.properties

根目录下创建gradle.properties，并添加：
```groovy
group = com.zkzong.gradle
version = 1.0-SNAPSHOT
```

### 2. ext

在build.gradle中定义：
```groovy
ext {
    group = 'com.zkzong.gradle'
    version = '1.0-SNAPSHOT'
}
```
在allprojects中插入：
```groovy
group $group
version $version
```

使用时一定要用双引号，不能使用单引号
> "$version"，不能写成'$version'，否则就不是取的变量，而是字符串$version


## 发布

在allprojects中添加：
```groovy
apply plugin: 'maven-publish'

publishing {
    publications {
        myPublish(MavenPublication) {
            from components.java
        }
    }
    repositories {
        maven {
            name "myRepo"
            url ""
        }
    }
}
```
> 注意：`gradle.properties`配置文件中的`group = com.zkzong.gradle`不能写成`group = 'com.zkzong.gradle'`，即`group`的值不能带单引号，否则报错。
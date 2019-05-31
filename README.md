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


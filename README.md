# Cucumber Exmample

使用Cucumber和Selenium来测试ionic app

### 使用的工具
* Cucumber-JVM 管理feature，并把它转化为可以执行的测试脚本  
  https://cucumber.io/docs/reference/jvm
* Selenium 提供API，定位和操作浏览器中的页面元素  
  http://www.seleniumhq.org/
* Selenide 把Selenium API封装成更易用的API  
  http://selenide.org/
* gradle 构建工具，用来运行测试  
  http://gradle.org/

### 准备工作
1. 安装Chromedriver，参考：https://sites.google.com/a/chromium.org/chromedriver/getting-started
2. clone 前台的代码（ionic app）https://github.com/automation-test-training/banking-page/
3. clone 后台代码（服务接口）https://github.com/automation-test-training/server-api
4. 安装node，根据[说明](https://github.com/automation-test-training/banking-page/blob/master/README.md)安装前台需要的库和工具

### 运行测试
1. 启动后台服务（进入后台代码目录，执行`./gradlew bootRun`）
2. 启动ionic app（进入前台代码目录，执行`ionic serve`）
3. 运行测试（进入本仓库代码目录，执行`./gradlew test`）



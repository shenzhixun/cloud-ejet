易接（ejet） 微服务框架  
==============================  
特点：微服务插件式开发，业务组件以JAR方式提供、松耦合可插拔支持独立部署，也可以无缝集成易接(ejet)平台

当前版本：1.0.0（重构版本 | 发布日期：20190101）


#### 项目说明

	ejet-starter-parent        | 父POM（管理公共资源版本号）
	ejet-starter-web           | 启动主项目
	ejet-generator-project 	   | 项目骨架生成工具
	ejet-core-ui			   | UI依赖（h+、jquery等等第三方UI依赖）
    ejet-biz-helloworld        | 第一个插件例子

	
#### 架构说明

    1.ejet技术架构
	    MVC层 ： Springboot_2.1.1.RELEASE
		持久层： Mybatis_1.3.2
		View层： VUE前后端分离、
		UI 层 ： ivew-admin、Bootstrap、Jquery
	
	2.通过eclipse启动项目
	  选中项目，右键采用maven方式，输入命令 tomcat:run 启动Web项目
	  
      http://localhost/jeecg-p3-report-web
	  
    4.页面层面采用模板语言Velocity，不能采用jsp
    5.每个业务组件以jar包方式提供

	
	

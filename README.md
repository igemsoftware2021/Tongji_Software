# Website technical route

  We mainly used the following open source tools and frameworks in the develotment of the website:

  For the front-end of the website, we used **Vue**, a progressive framework for building user interfaces, ElementsUI, a front-end component library based on the Vue framework, and a browser-based dynamic JavaScript visualization library Vis.js for data visualization.

  For the back-end of the website, we used the **SpringBoot** framework based on the **JavaEE** ecology to design and implement the business logic and the database interaction. SpringBoot has the characteristics of rapid development and is particularly suitable for building micro-service systems. It encapsulates some frequently used components and tools to facilitate external output of various forms of services. It has a very simple integration of security policies and supports relational and non-relational databases. It upports embedded containers such as Tomcat during runtime. It has a powerful development package which supports hot starting, automatically managing dependencies, application monitoring, and various IDEs such as IntelliJ IDEA.

  In the database layer, we used **MySql**, a relational database system to store website data. MySQL is smaller in size and faster in command execution compared with other database systems. It is an open source software and provides a free version of application. Compared with other large database system settings and management, it is less complex and easier to use. It has strong portability and can run on a variety of system platforms. 

  In terms of deployment, we use **Nginx** and **Tomcat** as the proxy layer for the above services and deploy them on the Alibaba Cloud Elastic Compute Service based on the **Ubuntu** environment to provide support for the operation of the website. The cloud elastic compute service provides more stable, secure, and highly resilient network services, which can be expanded flexibly according to the business requirements. It also can be dynamically migrated with high reliability.

  During the development process, we also used the following tools: front-end development and debugging tool **Visual Studio Code**, API testing tool Postman, back-end development and debugging tool: IntelliJ IDEA, database development and debugging tool: Navicat, team collaboration tool Feishu, version control tool Git and code hosting tool GitHub.


# Page-Map DataBase

## E-R diagram

![](https://2021.igem.org/wiki/images/9/90/T--Tongji_Software--E-R.png)

## Description

​	The E-R diagram of the database is shown above. There are 10 tables in total, including **10819** kinds of bacteria, **16** kinds of superbacteria and **12,041** kinds of bacteriophages. The total number of records exceeds **500000**.

​	The dump mode provides two modes: overall database dump and single table dump, which can be requested by users on demand.

​	In order to meet the referential integrity constraints in the database construction process, the recommended table creation order is 

```
bacteria_taxon -> bacteria -> bacteria_spacer -> phage -> bacteria_phage_score -> result -> super_bug -> phage_bug -> score_bug -> comment
```

# Reconstruct our pipeline
You can use `Docker` image to construct your own pipeline. 

Please click [this](https://github.com/tj-Acmen/Tongji_Software/tree/main/data-processing) to get more details by reading `README.md` instruction.

We've tested that using the following virtual machine configuration, we can run the entire analysis process smoothly.

![](https://2021.igem.org/wiki/images/a/ab/T--Tongji_Software--xunijipeizhi.png)

## Docker installation succeeded
![](https://2021.igem.org/wiki/images/1/15/T--Tongji_Software--docker9.png)

## Pull docker succeeded
![](https://2021.igem.org/wiki/images/f/f1/T--Tongji_Software--pull_docker.png)

## Analysising succeeded

![](https://2021.igem.org/wiki/images/b/b5/T--Tongji_Software--step111.png)
![](https://2021.igem.org/wiki/images/2/23/T--Tongji_Software--daimafenxi-1.png)

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


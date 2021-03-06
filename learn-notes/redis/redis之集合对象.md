---
layout: post
title:  "redis深入学习(十)之集合对象"
date:   2017-09-09 01:06:05
categories: noSQL
tags: redis
excerpt: redis
---


* conten

### 集合对象

集合对象的编码可以是intset或者hashtable

intset编码的集合对象使用整数集合作为底层实现,集合对象包含的所有元素都被保存在整数集合里面.

hashtable编码的集合对象使用字典作为底层实现,字典的每个键都是一个字符串对象,每个字符串对象包含了一个集合元素,而字典的值则全部被设置为null

![image](http://7xpuj1.com1.z0.glb.clouddn.com/%E9%9B%86%E5%90%88%E5%AF%B9%E8%B1%A1%E5%BA%95%E5%B1%82%E5%AE%9E%E7%8E%B0.png)

### 编码的转换

当集合对象可以同时满足以下两个条件时,对象使用intset编码:

- 集合对象保存的所有元素是整数
- 集合对象保存的元素数量不超过512个

其余均使用hashtable编码.对于使用intset编码的集合对象来说,当任意一个条件不能满足时,将会执行转码操作,转换为字典保存,若向只包含整数元素的集合对象添加一个字符串元素,集合短信的编码转移操作就会被执行.

![image](http://7xpuj1.com1.z0.glb.clouddn.com/%E9%9B%86%E5%90%88%E5%91%BD%E4%BB%A4.png)

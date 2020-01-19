package com.nivelle.spring.springcore.basics;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

/**
 * 实现了常用扩展的接口
 *
 * BeanFactoryAware
 * BeanNameAware
 * InitializingBean
 * DisposableBean
 *
 * @Author nivelle
 *
 */
@Component
public class PersonBeanLife implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private String name;
    private String address;
    private int phone;

    private BeanFactory beanFactory;
    private String beanName;

    public PersonBeanLife() {
        System.err.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.err.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.err.println("【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.err.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonBeanLife [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    /**
     * 这是BeanFactoryAware接口方法
     */
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.err.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    /**
     * 这是BeanNameAware接口方法
     * @param arg0
     */
    @Override
    public void setBeanName(String arg0) {
        System.err.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = arg0;
    }

    /**
     * 这是 InitializingBean 接口方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    /**
     * 这是DiposibleBean接口方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.err.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }
    /**
     * 通过<bean>的init-method属性指定的初始化方法
     */
    public void myInit() {
        System.err.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    /**
     * 通过<bean>的destroy-method属性指定的初始化方法
     */
    public void myDestory() {
        System.err.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
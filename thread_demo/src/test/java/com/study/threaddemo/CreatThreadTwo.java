package com.study.threaddemo;

import java.util.LinkedList;

/*
 * @Author：hzx
 * @Description：创建线程的方式
 * @Date： 2018/12/26 15:23
 * 继承Thread类
 *
 */
public class CreatThreadTwo {
    public static void main(String[] args) {
        System.out.println("主线程名："+Thread.currentThread().getName()+"开始运行");
        Thread1 thread1 = new Thread1("aaa");
        Thread1 thread2 = new Thread1("bbb");
        thread1.start();
        thread2.start();
        System.out.println("主线程名："+Thread.currentThread().getName()+"结束运行");

    }
}
//创建一个线程对象
 class Thread1 extends Thread{
    private String name;
    public Thread1(String name){
        super(name);
        this.name=name;
    }
    public void run(){
        System.out.println("子线程名："+Thread.currentThread().getName()+"----线程开始运行。。。");
        for (int i = 0; i <10 ; i++) {
            System.out.println("当前线程名："+Thread.currentThread().getName());
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("子线程名："+Thread.currentThread().getName()+"线程结束");
    }
}
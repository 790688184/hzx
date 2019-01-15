package com.study.threaddemo.controller;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*
 * @Author：hzx
 * @Description：创建线程的方式
 * @Date： 2018/12/26 15:23
 *
 */
public class CreatThread extends Thread {
    public static void main(String[] args) {
       //实现Runnable接口重写run方法
        Thread threadOne = new Thread(new ThreadOne());
        threadOne.start();

        //new一个实现Callable实现类的对象
        ThreadTwo threadTwo = new ThreadTwo();
        //使用FutureTask对threadTwo对象结果输出的进行封装
        FutureTask<Object> futureTask = new FutureTask<Object>(threadTwo);
        //将futureTask对象作为Thread的target创建线程
        Thread thread = new Thread(futureTask);

        //启动线程
        thread.start();

        //继承Thread类
        ThreadThree threadThree = new ThreadThree();


    }
}

/**
 * 通过实现Runnable接口实现run方法
 * 接口的实现类的实例作为Thread的target作为参数传入带参的Thread构造函数
 * 通过调用start()方法启动线程
 */
class ThreadOne implements Runnable{
    @Override
    public void run() {
        Date date = new Date();
        System.out.println(date+"-------"+Thread.currentThread().getName()+"-----是通过实现Runnable接口的线程实现方式");
    }
}

/*
通过实现Callable接口通过FutureTask创建的线程
创建Callable的实现类，并重写Call方法
创建Callable实现类的实现，使用Futuretask包装Callable对象，该FutureTask对象封装了Callable对象的Call方法返回值
使用FutureTask对象作为Thread对象的target创建并启动线程
调用FutureTask对象get()来获取子线程执行结束的返回值

 */

class  ThreadTwo implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"-----是通过实现Runnable接口的线程实现方式");
        return "";
    }
}


class ThreadThree {

}
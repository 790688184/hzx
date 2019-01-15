package com.study.threaddemo.controller;

/*
 * @Author：hzx
 * @Description：
 * @Date： 2018/12/27 9:54
 *
 */
public class SingleTon {
    private SingleTon(){}
    private final static SingleTon instance = new SingleTon();
    public static SingleTon getSingleTon(){
        return instance;
    }
}

class SingleTonHunger{
    private SingleTonHunger(){}

}



//卖票窗口示例

class test {
    public static void main(String[] args) {
        Ticket a = new Ticket();
        Ticket b = new Ticket();
        new Thread(a).start();
        new Thread(b).start();
    }

}
class Ticket implements Runnable {
    private int ticket =100;
    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+"正在卖票，还剩"+(ticket-1)+"张");
                ticket--;
            }
        }
    }
}


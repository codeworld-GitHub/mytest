package com.liguang.mytest.leecode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/11 23:42
 */
public class LeecodeTest {
    /**
     * 汽水瓶
     */
    @Test
    public void qishuiping() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            if (n == 1) {
                System.out.println(0);
                break;
            }
            if (n == 0) {
                break;
            }
            int x = n / 3 + n % 3;
            int sum = n / 3;
            if (x >= 3) {
                do {
                    sum += x / 3;
                    x = x % 3 + x / 3;
                } while (x >= 3);
                if (x == 1) {
                    System.out.println(sum);
                }
                if (x == 2) {
                    System.out.println(sum + 1);
                }
            } else if (x == 1) {
                System.out.println(sum);
            } else {
                System.out.println(sum + 1);
            }
        }
        in.close();
    }

    /**
     * 明明的随机数
     */
    @Test
    public void mingmingdesuijishu() {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            result.add(in.nextInt());
        }
        for (Integer num : result) {
            System.out.println(num);
        }
    }

    /**
     * 进制转换
     */
    @Test
    public void jizhizhuanhuan() {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        // 去掉表示十六进制的 0x 前缀 —— 从而使得我们可以使用下面的 API 实现进制转换
        a = a.substring(2);
        // 实现进制转换的两种 API
        // int ans = Integer.valueOf(a, 16);
        int ans = Integer.parseInt(a, 16);
        System.out.println(ans);
    }

    /**
     * 最后一个单词的长度
     */
    @Test
    public void zuihouyigedanzidechangdu(){
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextLine()) { // 注意 while 处理多个 case
//            String a = in.nextLine();
//            String[] str = a.split(" ");
//            System.out.println(str[str.length - 1].length());
//        }
        String words = "ABCabc".toLowerCase();
        String A = "A".toLowerCase();
        String format = String.format("%6s", "123");
        String x = "0 4";
        String[] s = x.split(" ");
        int i1 = Integer.parseInt(s[0]);
        int i2 = Integer.parseInt(s[1]);
        System.out.println(i1 + " " + i2);
        System.out.println(format);
        int num = 0;
        for (int i = 0; i < words.length(); i++) {
            if(A.equals(words.charAt(i)+"")){
                num++;
                continue;
            }
        }
        System.out.println(num);
//        System.out.println(words);
//        String[] s = words.split(" ");
//        System.out.println(s[s.length - 1].length());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int zu = in.nextInt();
        // 注意 hasNext 和 hasNextLine 的区别
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (zu > 0 && in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            if(s.length() <= 1){
                continue;
            }
            String[] lines = s.split(" ");
            int a1 = Integer.parseInt(lines[0]);
            int b1 = Integer.parseInt(lines[1]);
            map.put(a1, map.getOrDefault(a1, 0) + b1);
            zu-=1;
        }
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }

    private static volatile boolean flag = true;

    @Test
    public void testVolatile(){
        // 线程A
        new Thread(()->{
            int i = 0;
            do {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + "======>" + ++i);
                }
                if (i % 2 == 0) {
                    flag = false;
                }
            } while (i < 10);
        }, "A").start();
        // 线程B
        new Thread(()->{
            int i = 0;
            while (true){
                if(!flag){
                    System.out.println(Thread.currentThread().getName() + "被唤醒了" + ++i);
                    flag = true;
                    if(i == 5){
                        break;
                    }
                }
            }
        }, "B").start();
    }
}

package com.liguang.mytest;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * JasyptTest 加密测试
 */
public class JasyptTest extends BaseTest {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void test() {
        System.out.println(stringEncryptor.encrypt("123456"));
    }

    /**
     * java8 异步变成
     */
    @Test
    public void testCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Begin Invoke getFuntureHasReturnLambda");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {

            }
            System.out.println("End Invoke getFuntureHasReturnLambda");
            return "hasReturnLambda";
        });
        System.out.println("Main Method Is Invoking");
        future.get();
        System.out.println("Main Method End");
    }

    @Test
    public void testCompletableFuture2() throws ExecutionException, InterruptedException {
        //thenApply  可获取到前一个任务的返回值,也有返回值
        CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> "seqFutureOne");
        CompletableFuture<String> futureTwo = futureOne.thenApply(name -> name + " seqFutureTwo");
        System.out.println(futureTwo.get());

        //thenAccept  可获取到前一个任务的返回值,但是无返回值
        CompletableFuture<Void> thenAccept = futureOne.thenAccept(name -> System.out.println(name + " thenAccept"));
        System.out.println("------------");
        System.out.println(thenAccept.get());

        //thenRun 获取不到前一个任务的返回值,也无返回值
        System.out.println("-------------");
        CompletableFuture<Void> thenRun = futureOne.thenRun(() -> System.out.println("thenRun"));
        System.out.println(thenRun.get());
    }

    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer))
                        .thenApply(h -> Integer.toString(h))
                        .whenComplete((s, e) -> {
                            System.out.println("任务" + s + "完成!result=" + s + "，异常 e=" + e + "," + new Date());
                            list.add(s);
                        })
                ).toArray(CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(cfs).join();
        System.out.println("list=" + list + ",耗时=" + (System.currentTimeMillis() - start));
    }

    public int calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
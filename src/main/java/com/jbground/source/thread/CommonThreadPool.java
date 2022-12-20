package com.jbground.source.thread;

import java.util.concurrent.*;

/**
 * Created by jsjeong on 2022. 12. 20.
 * <pre>
 *  기본 JDK를 이용한 쓰레드 풀
 * </pre>
 */
public class CommonThreadPool {

    int nThreads = 5;
    int corePoolSize = 5;
    int maximumPoolSize = 20;
    int keepAliveTime = 10;

    public ThreadPoolExecutor createThreadPoolExecutor() {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, blockingQueue);
    }

    public ThreadFactory createThreadFactory() {
        return Executors.defaultThreadFactory();
    }

    public ExecutorService createSingleThreadPool() {
        return Executors.newSingleThreadExecutor();
    }

    public ExecutorService createFixedThreadPool(){
        return Executors.newFixedThreadPool(nThreads);
    }

    public ExecutorService createCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    public ExecutorService createScheduledThreadPool() {
        return Executors.newScheduledThreadPool(nThreads);
    }

    public void runThread(){
        ExecutorService service = createFixedThreadPool();
        service.submit(()->{

        });

        ThreadPoolExecutor threadPoolExecutor = createThreadPoolExecutor();
        threadPoolExecutor.submit(()->{

        });

        ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) createFixedThreadPool();
        threadPoolExecutor2.submit(()->{

        });

    }

    public void runThreadPoolExecutor() {
        /*
        corePoolSize보다 적은 Thread가 수행되고 있었던 경우:
            실행 요청한 Runnable을 수행하기 위한 Thread를 새로 생성하여 즉시 실행한다.
        corePoolSize보다 많은 Thread가 수행되고 있지만, maxPoolSize보다 적은 수의 Thread가 수행되고 있는 경우:
            Queue가 가득 차지 않은 경우: 즉시 실행하지 않고 Queue에 Runnable을 넣는다.
        Queue가 가득 찬 경우:
            maxPoolSize까지 Thread를 더 만들어 실행한다.
        즉, maxPoolSize만큼 확장되는 것보다 Queue를 채우는 작업이 우선한다. Queue의 크기를 넘어선 수의 작업들이 요청되었을 때만 maxPoolSize만큼 확장된다.
     */
        int numTasks = 60;
        CountDownLatch countDownLatch = new CountDownLatch(numTasks);
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, blockingQueue);

        for(int i = 0; i < numTasks; i++){
            threadPoolExecutor.submit(() -> {
                //Do something
                countDownLatch.countDown();
            });
        }
    }
}

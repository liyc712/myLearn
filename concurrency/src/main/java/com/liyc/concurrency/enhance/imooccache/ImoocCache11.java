package com.liyc.concurrency.enhance.imooccache;

import com.liyc.concurrency.enhance.imooccache.computable.Computable;
import com.liyc.concurrency.enhance.imooccache.computable.ExpensiveFunction;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述：   线程池看缓存效果
 */
public class ImoocCache11 {


}

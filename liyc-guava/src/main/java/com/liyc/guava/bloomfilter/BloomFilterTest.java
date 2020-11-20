package com.liyc.guava.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.*;

import static org.junit.Assert.assertThat;

/**
 * @Author lyc
 * @Date 2020-11-19 15:35
 * @ClassName BloomFilterTest
 * @Description 布隆过滤器
 */
public class BloomFilterTest {

    @Test
    public void test1() {
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                500,
                0.01);

        filter.put(1);
        filter.put(2);
        filter.put(3);


        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        System.out.println(filter.mightContain(3));
        System.out.println(filter.mightContain(4));
        System.out.println(filter.mightContain(100));

    }

    @Test
    public void test2() {

        int insertions = 10000000;

        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), insertions, 0.001);

        Set<String> sets = new HashSet<String>(insertions);

        List<String> lists = new ArrayList<String>(insertions);

        for (int i = 0; i < insertions; i++) {
            String uid = UUID.randomUUID().toString();
            bloomFilter.put(uid);
            sets.add(uid);
            lists.add(uid);
        }

        int right = 0;
        int wrong = 0;

        for (int i = 0; i < 10000; i++) {
            String data = i % 100 == 0 ? lists.get(i / 100) : UUID.randomUUID().toString();
            if (bloomFilter.mightContain(data)) {
                if (sets.contains(data)) {
                    right++;
                    continue;
                }
                wrong++;
            }
        }

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        float percent = (float) wrong / 9900;
        float bingo = (float) (9900 - wrong) / 9900;

        System.out.println("在 " + insertions + " 条数据中，判断 100 实际存在的元素，布隆过滤器认为存在的数量为：" + right);
        System.out.println("在 " + insertions + " 条数据中，判断 9900 实际不存在的元素，布隆过滤器误认为存在的数量为：" + wrong);
        System.out.println("命中率为：" + percentFormat.format(bingo) + "，误判率为：" + percentFormat.format(percent));

    }


    @Test
    public void autoData7() throws InterruptedException {
        int size = 1000000;

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size,0.0001);


        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        for (int i = 0; i < size; i++) {
            if (!bloomFilter.mightContain(i)) {
                System.out.println("有坏人逃脱了");
            }
        }

        List<Integer> list = new ArrayList<Integer>(1000);
        for (int i = size + 10000; i < size + 20000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }
        System.out.println("有误伤的数量：" + list.size());
        Assert.assertTrue(true);
    }

}

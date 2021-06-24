import cn.hutool.core.date.StopWatch;

/**
 * @ClassName: StopWatchDemo
 * @Description: 测试
 * @Author: zhilee
 * @Date: 2021/6/21 1:31 PM
 **/
public class StopWatchDemo {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("开始1");
        Thread.sleep(2000);
        stopWatch.stop();

        stopWatch.start("开始2");
        Thread.sleep(2000);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());

        System.out.println(stopWatch.getTotalTimeMillis());

        System.out.println(stopWatch.getTotalTimeSeconds());
    }

}

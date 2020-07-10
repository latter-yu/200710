public class Test {

    public int calculateMax(int[] prices) {

        // 风口之下，猪都能飞。
        // 当今中国股市牛市，真可谓 “错过等七年”。
        // 给你一个回顾历史的机会，已知一支股票连续 n 天的价格走势
        // 以长度为 n 的整数数组表示，数组中第 i 个元素（prices[i]）代表该股票第 i 天的股价。
        // 假设你一开始没有股票，但有至多两次买入 1 股而后卖出 1 股的机会，并且买入前一定要先保证手上没有股票。
        // 若两次交易机会都放弃，收益为 0。
        // 设计算法，计算你能获得的最大收益。
        // 输入数值范围：2 <= n <= 100,0 <= prices[i] <= 100

        // 示例:
        // 输入
        // 3, 8, 5, 1, 7, 8
        // 输出
        // 12

        int firstBuy = Integer.MAX_VALUE; // 32767
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE; // -32768
        int secondSell = 0;
        for (int cur : prices) {
            // 第一次买入最小的股 = firstBuy
            firstBuy = Math.min(firstBuy, cur);
            // 第一次卖出所得最大的利润 = firstSell
            firstSell = Math.max(firstSell, cur - firstBuy);
            // 第二次买入的利润 = 第一次所得利润 - 第二次买入开销
            secondBuy = Math.max(secondBuy, firstSell - cur);
            // 总共最大利润 = 买入利润 + 第二次卖出利润
            secondSell = Math.max(secondSell, secondBuy + cur);
        }
        return secondSell;
    }
}

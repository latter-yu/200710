import java.util.Scanner;

public class Main {
    public class Count2 {
        public int countNumberOf2s(int n) {
            // 请编写一个方法，输出 0 到 n(包括 n)中数字 2 出现了几次。
            //给定一个正整数 n，请返回 0 到 n 的数字中 2 出现了几次。

            // 测试样例：
            // 10
            // 返回：1

            // 解析：
            // 当计算右数第 i 位包含的 X 的个数时：
            // 取第 i 位左边（高位）的数字，乘以 10i − 1，得到基础值 a。
            // 取第 i 位数字，计算修正值：
            // 如果大于 X，则结果为 a + 10i − 1
            // 如果小于 X，则结果为 a
            // 如果等 X，则取第 i 位右边（低位）数字，设为 b
            // 最后结果为 a + b + 1

            int count = 0;
            if (n <= 1) {
                return 0;
            }
            for (int i = 1; i < n; i *= 10) {
                int x = n / i;
                int y = n % i;
                count += (x + 7) / 10 * i + ((x % 10 == 2) ? (y + 1) : 0);
                // 之所以补 7，是因为当百位为 0，则 x / 10 == (x + 7) / 10，
                // 当百位 >= 3，补 7 会产生进位，效果等同于(x / 10 + 1)
            }
            return count;
        }
    }

    public static class Test {
        public static void main(String[] args) {

            // 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
            // 十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱 P 和他实付的钱 A，你的任务是写一个程序来计算他应该被找的零钱。

            // 输入描述:
            // 输入在 1 行中分别给出 P 和 A，格式为 “Galleon.Sickle.Knut” ，其间用 1 个空格分隔。这里 Galleon是 [0, 107] 区间内的整数，
            // Sickle 是 [0, 17)区间内的整数，Knut 是 [0, 29) 区间内的整数。
            // 输出描述:
            // 在一行中用与输入同样的格式输出哈利应该被找的零钱。
            // 如果他没带够钱，那么输出的应该是负数。

            // 示例:
            // 输入
            // 10.16.27 14.1.28
            // 输出
            // 3.2.1

            // 输入
            // 14.1.28 10.16.27
            // 输出
            // -3.2.1

            Scanner sc = new Scanner(System.in);
            String P = sc.next(); // 应付
            String A = sc.next(); // 实付
            String[] arrp = P.split("\\.");
            String[] arra = A.split("\\.");
            // 转化为 int 类型的数组才能比较大小
            int[] p = {Integer.parseInt(arrp[0]),Integer.parseInt(arrp[1]),Integer.parseInt(arrp[2])};
            int[] a = {Integer.parseInt(arra[0]),Integer.parseInt(arra[1]),Integer.parseInt(arra[2])};
            int[] arrx = new int[a.length];
            int sump = 0;
            int suma = 0;
            int sum = 0;
            sump = p[0] * 17 * 29 + p[1] * 29 + p[2];
            suma = a[0] * 17 * 29 + a[1] * 29 + a[2];
            if (sump >= suma) {
                sum = sump - suma;
                arrx[0] = sum / (17 * 29);
                sum = sum % (17 * 29);
                arrx[1] = sum / 29;
                sum = sum % 29;
                arrx[2] = sum;
                System.out.println("-" + arrx[0] + "." + arrx[1] + "." + arrx[2]);
            }else {
                sum = suma - sump;
                arrx[0] = sum / (17 * 29);
                sum = sum % (17 * 29);
                arrx[1] = sum / 29;
                sum = sum % 29;
                arrx[2] = sum;
                System.out.println(arrx[0] + "." + arrx[1] + "." + arrx[2]);
            }
        }
    }
}

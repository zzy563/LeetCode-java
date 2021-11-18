class Solution {
    // 执行用时：1 ms, 在所有 Java 提交中击败了98.86%的用户
    // 内存消耗：35.7 MB, 在所有 Java 提交中击败了15.97%的用户
    public static int  divide(int dividend, int divisor) {
		if(dividend==-2147483648) {//限制条件
			if (divisor==1) {
				return -2147483648;
			}else if (divisor==-1) {
				return 2147483647;
			} else if (divisor==-2147483648) {
				return 1;
			}
		}
        //判断符号
		int m=9;
		if(dividend>0&&divisor>0||dividend<0&&divisor<0) m=1;
		if(dividend>0&&divisor<0||dividend<0&&divisor>0) m=-1;
        //转换成负数防止溢出
		dividend=-Math.abs(dividend);
		divisor=-Math.abs(divisor);
		
		int res=0;
        //a储存除数，b储存被除数
        //思路是b翻倍 一直翻倍到大于a的前一次翻倍
        //a=a-b，计算当前的商,重置b
        //再重新比较ab，直至a<=b结束循环
        //亿点点细节:
        //b翻倍容易溢出，做好判断（b+b>0）
        //移位运算符的使用
		for (int i = 0,a=dividend;; i++) {
			int b=divisor;
			if (a<=b) {
				for (int j = 0;;j++) {
					if (b+b<=a||b+b>0) {
						a=a-b;
						res+=1<<j;
						break;
					}
					b+=b;
				}
			}
			
			if (a>divisor) break;
		}
		return m==1? res:-res;
		
    }
    // 测试主函数
    public static void main(String[] args) {
		int a =1, b =1;
//		Integer.MIN_VALUE-2
		int re = divide(a, b);
		System.out.println(re);
//		System.out.println(Integer.MIN_VALUE);
//		for (int i = 0;i<4; i++) {
//			System.out.println(1<<i);
//		}
	}
}
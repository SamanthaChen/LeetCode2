package NetEase;

/**
 * 跳石板：站在k石板上只能每次跳到除了1和k之外，数字为k+divisor的石板。求n石板到m石板的最短路径长度。
 * 题目就是要找个最短路径的长度，这里是个比较显然的bfs题。考虑每一步状态拓展，即找某个数的所有约数，这个问题可以在O(sqrt(num))复杂度完成。所以直接搜出答案即可。

小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
例如：
N = 4，M = 24：
4->6->8->12->18->24
于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板 

	时间复杂度：讲道理，这个时间复杂度真的不太会分析。不过感性的感觉这个可以跑得非常快。
	实测了下10w范围内最大的转移步数是33，于是这个几乎就是一个log级的复杂度了。如果有巨巨能量化分析，请教教我。。
 * 
 * */
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int start = scanner.nextInt();// 第一块石板
			int end = scanner.nextInt();// 第二块石板
			int count = slove(start, end);
			System.out.println(count);
		}
		scanner.close();
	}

	private static int slove(int start, int end) {

		return end;
	}

}

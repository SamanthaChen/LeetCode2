package JZoffer;

public class JumFloor {

	public static void main(String[] args) {

	}

	public int JumpFloorII(int target) {

		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		int fn = 1;
		for (int i = 2; i <= target; i++) {
			fn = fn * 2;
		}

		return fn;

	}

}

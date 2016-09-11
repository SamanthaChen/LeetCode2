package JZoffer;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String ReverseSentence(String str) {
		if (str.trim().equals("")) {
			return str;
		}
		String[] s = str.split(" ");

		StringBuffer sb = new StringBuffer();
		for (int i = s.length - 1; i > 0; i--) {
			sb.append(s[i] + " ");
		}
		sb.append(s[0]);
		return sb.toString();
	}

}

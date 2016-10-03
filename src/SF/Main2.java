package SF;

/**
 * POJ 1011��һ����(ľ�����)  ��һ����PAT 1003(Emergency)
�����⡿����������һ��ȳ���ľ��������������ؿ��ϣ�ʹ��ÿһ��ľ���ĳ��ȶ�������50�����ȵ�λ��
Ȼ�����������Щľ���ָ���Ϊ�ý�ǰ��״̬���������˳�ʼʱ�ж���ľ���Լ�ľ���ĳ�ʼ���ȡ�
�������һ�����򣬰������μ���ľ���Ŀ�����С���ȡ�ÿһ��ľ���ĳ��ȶ��ô������������ʾ��

����⡿�����ڼ�֦����Ҫ��ܸߡ�����˵�¼�����Ҫ�ļ�֦��
1.������ľ���ĳ��ȴӴ�С���У����ľ��ʱ����ʹ�ó���ľ�����������Լӿ�����ٶȣ����ҶԺ���ļ�֦�а�����
2.ľ���ĳ���һ���Ǵ��ڵ����ľ���ĳ��Ȳ���С�ڵ�������ľ�����ȵĺͣ����������֤����
3.ľ���ĳ���һ��������ľ�����ȵĺ͵�Լ�������Ҳ������֤����
4.��ĳһ��ľ������Ϲ����У����ڵ�ǰ��ľ��stick[i]�����stick[i-1]û�б���ϲ���stick[i] == stick[i-1]����ô���ÿ���stick[i]����Ȼstick[i]����Ҳ���ᱻ��ϡ�
5.����˴����ڳ��Ե�i��ľ���ĵ�һ�Σ�����stick[j]Ϊ��ǰ���Ա�ʹ�õ����ľ��������˴����ʧ�ܣ�ֱ���˳����������˻ص��Ե�i-1��ľ�������������룺ʧ��˵������ʹ��stick[j]�ǲ����еģ���ô�Ժ�����ʲôʱ��ʹ��stick[j]���ǲ����еģ���Ϊ�Ժ��ٴ���stick[j]ʱ��ʹ�õ�ľ��һ���ǵ�ǰ��ʹ�õ�ľ�����Ӽ����ڸ���ľ��ѡ�������¶�������ϳɹ�����ô���ڸ���ľ��ѡ��������һ��������ϳɹ���

 * 
 * 
 * */
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static boolean[] used;
	static int len;
	static int[] s;
	static int sum;
	static int max;
	static int parts;

	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			len = reader.nextInt();
			s = new int[len];

			int index = 0;
			used = new boolean[len];
			sum = 0;
			while (index < len) {
				s[index] = reader.nextInt();
				sum += s[index++];
			}
			// ��ľ�����Ƚ�������
			Arrays.sort(s);
			max = s[len - 1];

			// ľ�����ȿ϶��Ǵ���ľ�����ȵģ���Ȼ����Ŀ�ʼ���кϲ�
			for (; max <= sum; max++) {
				// ֻ�е�ľ�������ܹ���sum����ʱ����ľ�����Ȳ������
				if (sum % max == 0) {
					parts = sum / max;
					// ������ľ�����ȣ��Ӵ���С����, �������Ա��ⲻ��Ҫ������
					Main2 main = new Main2();
					if (main.search(0, len - 1, 0)) {
						System.out.println(max);
						break;
					}
				}
			}
		}
		reader.close();
	}

	/**
	 * ��������ʹľ���ܹ��ճ�һ��ľ��
	 * 
	 * @param res
	 *            ��ǰ���ںϳɵ�ľ�����Ѻϳɵĳ���
	 * @param next
	 *            ��һ����Ҫ������ľ���±�
	 * @param cpl
	 *            �Ѿ��ϳɵ�ľ����
	 * @return
	 */
	private boolean search(int res, int next, int cpl) {
		// res = max ˵����ǰ�Ѿ��ϳ�һ��ľ��
		// cpl++ res��0
		// next��Ϊlen-2,
		// ��Ϊ��ʱlen-1���ľ���϶��Ѿ����õ��ˣ��´������϶���len-2��ʼ����ʵ���������Ҫ����Ϊÿ�ο�ʼ������ʱ�򶼻��鵱ǰ������ľ��used[next]
		if (res == max) {
			cpl++;
			res = 0;
			next = len - 2;
		}
		// ������ǰ����ľ���Ѿ��ϳ���ϣ�����
		if (cpl == parts) {
			return true;
		}

		// ��ǰ����ľ��û�кϲ��꣬���һ���ϲ�
		while (next >= 0) {
			// �����ǰľ��û�б�ʹ�ù�
			if (used[next] == false) {
				// �Ѻϲ�+ s[next] <= max ˵����ǰľ�����Լ��뵽��ǰ���ںϲ���ľ����
				if (res + s[next] <= max) {
					used[next] = true;
					// �����ɹ�����
					if (search(res + s[next], next - 1, cpl)) {
						return true;
					}
					// �������ɹ�������
					used[next] = false;
					// ��ǰ���ںϲ���ľ������res = 0�� ��ʣ��ľ���в������ٺϳ�ľ��������ʧ��
					if (res == 0) {
						break;
					}
					// ���Ժϳ�һ����ǰ�ģ�����ʣ��Ĳ��ܺϳ�һ��ľ��������ʧ��
					if (res + s[next] == max) {
						break;
					}
					// ���������Ȼ��������
				}

				int i = next - 1;
				while (i >= 0 && s[i] == s[next]) {
					i--;
				}
				next = i;
				int l_s = 0;
				while (i >= 0) {
					if (!used[i]) {
						l_s += s[i];
					}
					i--;
				}

				if (l_s < max - res) {
					break;
				}
				continue;
			}
			next--;

		}
		return false;
	}

}

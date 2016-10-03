package BaseKnowledge;

/**
 * java线程：生产者消费者模型
 */
public class Test {

	public static void main(String[] args) {
		Godown godown = new Godown(30);
		Consumer c1 = new Consumer(50, godown);
		Consumer c2 = new Consumer(20, godown);
		Consumer c3 = new Consumer(30, godown);
		Producer p1 = new Producer(10, godown);
		Producer p2 = new Producer(10, godown);
		Producer p3 = new Producer(10, godown);
		Producer p4 = new Producer(10, godown);
		Producer p5 = new Producer(10, godown);
		Producer p6 = new Producer(10, godown);
		Producer p7 = new Producer(80, godown);

		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();

	}

}

/**
 * 仓库
 */
class Godown {
	public static final int max_size = 100;
	public int currentNum;// 当前库存量

	public Godown() {

	}

	public Godown(int currentNum) {
		this.currentNum = currentNum;
	}

	/**
	 * 生产指定数量的产品
	 */
	public synchronized void produce(int neednum) {
		// 测试是否需要生产
		while (neednum + currentNum > max_size) {
			System.out.println("要生产的产品数量" + neednum + " 超过剩余库存量" + (max_size - currentNum) + ",暂时不能执行生产");
			try {
				// 当前的生产线程先暂时等待
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 满足生成条件则进行生产，这里只是简单更改当前库存量
		currentNum += neednum;
		System.out.println("已经生产了" + neednum + "个产品，现在仓储量为" + currentNum);
		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

	/**
	 * 消费指定数量的产品
	 */
	public synchronized void consume(int neednum) {
		// 测试是否可以消费
		while (currentNum < neednum) {
			try {
				// 当前的消费线程等待
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 满足消费条件，则进行消费，这里简单更改当前库存量
		currentNum -= neednum;
		System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + currentNum);
		// 唤醒在此对象上等待的所有线程
		notifyAll();
	}
}

/**
 * 生产者
 */
class Producer extends Thread {
	private int neednum;// 生成产品的数量
	private Godown godown;// 仓库

	public Producer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// 生产指定数量的产品
		godown.produce(neednum);
	}
}

/**
 * 消费者
 */
class Consumer extends Thread {
	private int neednum;// 生产产品的数量
	private Godown godown;// 仓库

	public Consumer(int neednum, Godown godown) {
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run() {
		// 消费指定数量的产品
		godown.consume(neednum);
	}
}

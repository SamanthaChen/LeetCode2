package BaseKnowledge.ProducerConsumer;

/**
 * 生产者模型
 */
public class Producer implements Runnable {

	// 简单的模拟一个生产容器，设置成final的话不允许再次赋值
	private final Container<Bread> container;

	// 生产者线程监听器
	private final Object producerMonitor;

	// 消费者线程监听器
	private final Object consumerMonitor;

	// 构造函数
	public Producer(Object producerMonitor, Object consumerMonitor, Container<Bread> container) {
		this.producerMonitor = producerMonitor;
		this.consumerMonitor = consumerMonitor;
		this.container = container;
	}

	@Override
	public void run() {
		while (true) {
			produce();
		}
	}

	/**
	 * 生产过程
	 */
	public void produce() {
		// 生产：模拟面包制作的步骤
		step1();
		Bread bread = step2();

		// 如果发现容器满了，生产者要停
		if (container.isFull()) {
			// 唤醒消费者
			synchronized (consumerMonitor) {
				if (container.isFull()) {
					consumerMonitor.notify();
				}
			}
			// 生产者挂起，两把锁问题
			synchronized (producerMonitor) {
				try {
					if (container.isFull()) {
						System.out.println("生产者挂起...");
						producerMonitor.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			// 如果容器中还有容量，把面包放到容器内，这里可能会丢失?
			boolean result = container.add(bread);
			System.out.println("Produce:" + result);
		}

	}

	// 几个空的步骤
	private Bread step2() {
		return new Bread();
	}

	private void step1() {

	}

}

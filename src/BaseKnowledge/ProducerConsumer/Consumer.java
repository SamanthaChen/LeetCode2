package BaseKnowledge.ProducerConsumer;

/**
 * 消费者模型
 */
public class Consumer implements Runnable {
	// 简单的模拟一个生产容器，设置成final的话不允许再次赋值
	private final Container<Bread> container;

	// 生产者线程监听器
	private final Object producerMonitor;

	// 消费者线程监听器
	private final Object consumerMonitor;

	// 构造函数
	public Consumer(Object producerMonitor, Object cosumerMonitor, Container<Bread> container) {
		this.producerMonitor = producerMonitor;
		this.consumerMonitor = cosumerMonitor;
		this.container = container;
	}

	@Override
	public void run() {
		while (true) {
			consumer();
		}
	}

	/**
	 * 消费，两把锁问题
	 */
	private void consumer() {
		// 如果容器已经空了，消费者要停
		if (container.isEmpty()) {
			// 唤醒生产者
			synchronized (producerMonitor) {
				if (container.isEmpty()) {
					producerMonitor.notify();
				}
			}

			// 消费者挂起
			synchronized (consumerMonitor) {
				try {
					if (container.isEmpty()) {
						System.out.println("消费者挂起...");
						consumerMonitor.wait();

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			// 还有面包可以消费
			Bread bread = container.get();
			System.out.println("bread:" + bread);
		}
	}

}

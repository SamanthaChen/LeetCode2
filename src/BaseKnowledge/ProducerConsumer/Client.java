package BaseKnowledge.ProducerConsumer;

/**
 * 
 * */
public class Client {
	public static void main(String[] args) {
		Object producerMonitor = new Object();
		Object consumerMonitor = new Object();
		Container<Bread> container = new Container<Bread>(10);
		// 生产者开动
		new Thread(new Producer(producerMonitor, consumerMonitor, container)).start();
		new Thread(new Producer(producerMonitor, consumerMonitor, container)).start();
		new Thread(new Producer(producerMonitor, consumerMonitor, container)).start();
		new Thread(new Producer(producerMonitor, consumerMonitor, container)).start();
		// 消费者开动
		new Thread(new Consumer(producerMonitor, consumerMonitor, container)).start();
		new Thread(new Consumer(producerMonitor, consumerMonitor, container)).start();

	}
}

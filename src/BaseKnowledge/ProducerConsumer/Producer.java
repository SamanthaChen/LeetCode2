package BaseKnowledge.ProducerConsumer;

/**
 * ������ģ��
 */
public class Producer implements Runnable {

	// �򵥵�ģ��һ���������������ó�final�Ļ��������ٴθ�ֵ
	private final Container<Bread> container;

	// �������̼߳�����
	private final Object producerMonitor;

	// �������̼߳�����
	private final Object consumerMonitor;

	// ���캯��
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
	 * ��������
	 */
	public void produce() {
		// ������ģ����������Ĳ���
		step1();
		Bread bread = step2();

		// ��������������ˣ�������Ҫͣ
		if (container.isFull()) {
			// ����������
			synchronized (consumerMonitor) {
				if (container.isFull()) {
					consumerMonitor.notify();
				}
			}
			// �����߹�������������
			synchronized (producerMonitor) {
				try {
					if (container.isFull()) {
						System.out.println("�����߹���...");
						producerMonitor.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			// ��������л���������������ŵ������ڣ�������ܻᶪʧ?
			boolean result = container.add(bread);
			System.out.println("Produce:" + result);
		}

	}

	// �����յĲ���
	private Bread step2() {
		return new Bread();
	}

	private void step1() {

	}

}

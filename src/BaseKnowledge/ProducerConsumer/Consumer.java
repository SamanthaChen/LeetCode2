package BaseKnowledge.ProducerConsumer;

/**
 * ������ģ��
 */
public class Consumer implements Runnable {
	// �򵥵�ģ��һ���������������ó�final�Ļ��������ٴθ�ֵ
	private final Container<Bread> container;

	// �������̼߳�����
	private final Object producerMonitor;

	// �������̼߳�����
	private final Object consumerMonitor;

	// ���캯��
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
	 * ���ѣ�����������
	 */
	private void consumer() {
		// ��������Ѿ����ˣ�������Ҫͣ
		if (container.isEmpty()) {
			// ����������
			synchronized (producerMonitor) {
				if (container.isEmpty()) {
					producerMonitor.notify();
				}
			}

			// �����߹���
			synchronized (consumerMonitor) {
				try {
					if (container.isEmpty()) {
						System.out.println("�����߹���...");
						consumerMonitor.wait();

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			// ���������������
			Bread bread = container.get();
			System.out.println("bread:" + bread);
		}
	}

}

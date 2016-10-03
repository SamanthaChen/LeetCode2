package BaseKnowledge.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * װ��Ʒ������
 */
public class Container<T> {

	private final int capacity;
	private final List<T> list;

	// ���캯��
	public Container(int capcity) {
		this.capacity = capcity;
		list = new ArrayList<T>(capcity);
	}

	public List<T> getList() {
		return list;
	}

	/**
	 * ��Ӳ�Ʒ
	 */
	public synchronized boolean add(T product) {
		if (list.size() < capacity) {
			list.add(product);
			return true;
		}
		return false;
	}

	/**
	 * ��
	 */
	public synchronized boolean isFull() {
		if (list.size() >= capacity) {
			return true;
		}
		return false;
	}

	/**
	 * ��
	 */
	public synchronized boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * ȡ����һ����Ʒ
	 */
	public synchronized T get() {
		if (list.size() > 0) {
			return list.remove(0);
		}
		return null;
	}

	/**
	 * ��������Ĵ�С
	 */
	public synchronized int getSize() {
		return list.size();
	}

	/**
	 * �������������
	 */
	public int getCapacity() {
		return capacity;
	}
}

package BaseKnowledge.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 装产品的容器
 */
public class Container<T> {

	private final int capacity;
	private final List<T> list;

	// 构造函数
	public Container(int capcity) {
		this.capacity = capcity;
		list = new ArrayList<T>(capcity);
	}

	public List<T> getList() {
		return list;
	}

	/**
	 * 添加产品
	 */
	public synchronized boolean add(T product) {
		if (list.size() < capacity) {
			list.add(product);
			return true;
		}
		return false;
	}

	/**
	 * 满
	 */
	public synchronized boolean isFull() {
		if (list.size() >= capacity) {
			return true;
		}
		return false;
	}

	/**
	 * 空
	 */
	public synchronized boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * 取出来一个商品
	 */
	public synchronized T get() {
		if (list.size() > 0) {
			return list.remove(0);
		}
		return null;
	}

	/**
	 * 获得容器的大小
	 */
	public synchronized int getSize() {
		return list.size();
	}

	/**
	 * 获得容器的容量
	 */
	public int getCapacity() {
		return capacity;
	}
}

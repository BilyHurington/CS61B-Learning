public class ArrayDeque<T> {
	private T[] data;
	private int size, start;
	private static final int addRadio = 2, delRadio = 4;

	public ArrayDeque() {
		size = 0;
		start = 0;
		data = (T[]) new Object[8];
	}

	private int prev(int x) {
		x--;
		if (x < 0) x += data.length;
		return x;
	}

	private int next(int x) {
		x++;
		if (x >= data.length) x -= data.length;
		return x;
	}

	/**
	 * Rebuild the data[] array with newSize length
	 */
	private void rebuild(int newSize) {
		T[] newData = (T[]) new Object[newSize];
		for (int i = 0, j = start; i < size; i++) {
			newData[i] = data[j];
			j = next(j);
		}
		start = 0;
		data = newData;
	}

	/**
	 * Check if newSize need to use rebuild()
	 */
	private void resize(int newSize) {
		if (newSize <= data.length && (newSize * delRadio >= data.length || data.length <= 8)) {
			return;
		} else if (newSize > data.length) {
			rebuild(data.length * addRadio);
		} else {
			rebuild(data.length / delRadio * 2);
		}
	}

	public void addFirst(T item) {
		resize(size + 1);
		size++;
		start = prev(start);
		data[start] = item;
	}

	public void addLast(T item) {
		resize(size + 1);
		size++;
		data[(start + size - 1) % data.length] = item;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		for (int i = 0, j = start; i < size; i++) {
			System.out.print(data[j]);
			if (i + 1 < size) {
				System.out.print(" ");
			}
			j = next(j);
		}
	}

	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		T answer = data[start];
		size--;
		start = next(start);
		resize(size);
		return answer;
	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		T answer = data[(start + size - 1) % data.length];
		size--;
		resize(size);
		return answer;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return data[(start + index) % data.length];
	}
}
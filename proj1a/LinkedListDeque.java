public class LinkedListDeque<T> {
	private int size;

	private class LinkNode {
		public LinkNode prev, next;
		public T value;

		LinkNode(LinkNode prev, LinkNode next, T value) {
			this.prev = prev;
			this.next = next;
			this.value = value;
		}
	}

	private LinkNode first, last;

	public LinkedListDeque() {
		size = 0;
		first = new LinkNode(null, null, null);
		last = new LinkNode(first, null, null);
		first.next = last;
	}

	public void addFirst(T item) {
		size++;
		LinkNode node = new LinkNode(first, first.next, item);
		node.prev.next = node;
		node.next.prev = node;
	}

	public void addLast(T item) {
		size++;
		LinkNode node = new LinkNode(last.prev, last, item);
		node.prev.next = node;
		node.next.prev = node;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		LinkNode tmp = first.next;
		while (!tmp.equals(last)) {
			System.out.print(tmp.value);
			if (!tmp.next.equals(last)) {
				System.out.print(" ");
			}
			tmp = tmp.next;
		}
	}

	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		size--;
		T value = first.next.value;
		first.next.next.prev = first;
		first.next = first.next.next;
		return value;
	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		size--;
		T value = last.prev.value;
		last.prev.prev.next = last;
		last.prev = last.prev.prev;
		return value;
	}

	public T get(int index) {
		if (index >= size || index < 0) {
			return null;
		}
		LinkNode node = first.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.value;
	}

	private T getRecursive(LinkNode node, int index) {
		if (index == 0) {
			return node.value;
		}
		return getRecursive(node.next, index - 1);
	}

	public T getRecursive(int index) {
		if (index >= size || index < 0) {
			return null;
		}
		return getRecursive(first.next, index);
	}
}
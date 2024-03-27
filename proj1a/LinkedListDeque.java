public class LinkedListDeque<Type>{
	private int size;
	public class LinkNode{
		public LinkNode prev,next;
		public Type value;
		LinkNode(LinkNode prev,LinkNode next,Type value){
			this.prev=prev;
			this.next=next;
			this.value=value;
		}
	}
	LinkNode first,last;
	public LinkedListDeque(){
		size=0;
		first=new LinkNode(null,null,null);
		last=new LinkNode(first,null,null);
		first.next=last;
	}
	public void addFirst(Type item){
		size++;
		LinkNode node=new LinkNode(first,first.next,item);
		node.prev.next=node;
		node.next.prev=node;
	}
	public void addLast(Type item){
		size++;
		LinkNode node=new LinkNode(last.prev,last,item);
		node.prev.next=node;
		node.next.prev=node;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int size() {
		return size;
	}
	public void printDeque(){
		LinkNode tmp=first.next;
		while(!tmp.equals(last)) {
			System.out.print(tmp.value);
			if (!tmp.next.equals(last)) {
				System.out.print(" ");
			}
			tmp = tmp.next;
		}
	}
	public Type removeFirst(){
		if(size==0){
			return null;
		}
		size--;
		Type value=first.next.value;
		first.next.next.prev=first;
		first.next=first.next.next;
		return value;
	}
	public Type removeLast(){
		if(size==0){
			return null;
		}
		size--;
		Type value=last.prev.value;
		last.prev.prev.next=last;
		last.prev=last.prev.prev;
		return value;
	}
	public Type get(int index){
		if(index>=size||index<0){
			return null;
		}
		LinkNode node=first.next;
		for(int i=0;i<=index;i++){
			node=node.next;
		}
		return node.value;
	}
	private Type getRecursive(LinkNode node,int index){
		if(index==0){
			return node.value;
		}
		return getRecursive(node.next,index-1);
	}
	public Type getRecursive(int index){
		if(index>=size||index<0){
			return null;
		}
		return getRecursive(first.next,index);
	}
}
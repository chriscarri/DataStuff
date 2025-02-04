import java.util.Iterator;
import java.util.NoSuchElementException;

public class StaticSet<E> implements Set<E> {

	// current number of elements in set
	private int currentSize;

	// array of elements
	private E elements[];

	private static final int DEFAULT_SET_SIZE = 10;

	public StaticSet(int maxCapacity) {
		if (maxCapacity < 1)
			throw new IllegalArgumentException("Max capacity must be at least 1");
		this.currentSize = 0;
		this.elements = (E[]) new Object[maxCapacity];
	}

	private class SetIterator<T> implements Iterator<T> {
		private int currentPosition;

		public SetIterator() {
			this.currentPosition = 0;
		}

		@Override
		public boolean hasNext() {
			return this.currentPosition < size();
		}

		@Override
		public T next() {
			if (this.hasNext()) {
				T result = (T) elements[this.currentPosition++];
				return result;
			}
			else
				throw new NoSuchElementException();				
		}
	}

	@Override
	public boolean add(E obj) {
		if (this.isMember(obj))
			return false;
		else {
			if (this.size() == this.elements.length)
				throw new IllegalStateException("The set is full.");
			else {
				this.elements[this.currentSize++] = obj;
				return true;
			}
		}
	}

	@Override
	public boolean isMember(E obj) {
		for (int i = 0; i < this.size(); i++)
			if (this.elements[i].equals(obj))
				return true;
		return false;
	}

	@Override
	public boolean remove(E obj) {
		for (int i = 0; i < this.size(); i++)
			if (this.elements[i].equals(obj))
			{
				this.elements[i] = this.elements[--this.currentSize];
				this.elements[this.currentSize] = null;
				return true;
			}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.size(); i++)
			this.elements[i] = null;
		this.currentSize = 0;

	}

	@Override
	public Set<E> union(Set<E> S2) {
		Set<E> S3 = new StaticSet<E>(DEFAULT_SET_SIZE);
		// Copy S1
		for (Object obj : this)
			S3.add((E) obj);

		// Copy elements of S2 not already in S1
		for (Object obj : S2)
		{
			E e = (E) obj;
			if (!S3.isMember(e))
				S3.add(e);
		}

		return S3;
	}

	@Override
	public Set<E> difference(Set<E> S2) {
		Set<E> S3 = new StaticSet<E>(DEFAULT_SET_SIZE);
		for (Object obj : this)
		{
			E e = (E) obj;
			if (!S2.isMember(e))
				S3.add(e);
		}
		return S3;
	}

	@Override
	public Set<E> intersection(Set<E> S2) {
		return this.difference(this.difference(S2));
	}

	@Override
	public boolean isSubSet(Set<E> S2) {
		for (Object obj : this)
			if (!S2.isMember((E) obj))
				return false;
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new SetIterator<E>();
	}

	@Override
	public boolean equals(Set<E> S2) {
		// TODO Auto-generated method stub
		if(this.isSubSet(S2) && S2.isSubSet(this)) {
			return true;
		}
		return false;
	}

	@Override
	public Set<Set<E>> singletonSets() {
		// TODO Auto-generated method stub
		Set<Set<E>> result = new StaticSet<Set<E>>(this.size());
		for(E A: this) {
			Set<E> temp = new StaticSet<E>(1);
			temp.add(A);
			result.add(temp);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static boolean checkDisjoint (Object[] sets) {
		Set<Integer> temp  = ((Set<Integer>) sets[0]).intersection((Set<Integer>) sets[1]); 
		for(int i = 2; i < sets.length;  i++) {
			temp = temp.intersection(((Set<Integer>) sets[i]));
		}
		return temp.isEmpty();
	}
	
	public E get(int index) {
		if(index < 0 || index > this.currentSize) {
			throw new ArrayIndexOutOfBoundsException("The index entered is invalid");
		}
		for(int i = 0; i < this.currentSize; i++) {
			if(i == index) {
				return this.elements[i];
			}
		}
		return null;
	}
	
	public int findElement(E e) {
		for(int i = 0; i < this.currentSize; i++) {
			if(e.equals(this.elements[i])) {
				return i;
			}
		}
		return -1; // Element is not found
	}
	
	public static void removeLast(Set<Object> set) {
		int index = 0;
		for(Object e: set) {
			if(index == set.size() - 1) {
				set.remove(e);
			}
			index++;
		}
	}
	

}
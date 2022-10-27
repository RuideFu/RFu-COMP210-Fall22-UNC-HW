package assn04;


import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	@Override
	public BST<T> insert(T element) {
		NonEmptyBST<T> new_branch = new NonEmptyBST<T>(element);
		if (element.compareTo(this._element) < 0){
			if (this._left.isEmpty()){
				this._left = new_branch;
			} else {
				this._left.insert(element);
			}
		} else {
			if (this._right.isEmpty()){
				this._right = new_branch;
			} else {
				this._right.insert(element);
			}
		}
		return this;
	}

	@Override
	public BST<T> remove(T element) {
		if (element.compareTo(this._element) < 0){
			this._left = this._left.remove(element);
		} else if (element.compareTo(this._element) > 0) {
			this._right = this._right.remove(element);
		} else {
			if (this._left.isEmpty() && this._right.isEmpty()){
				return new EmptyBST<T>();
			} else if (this._left.isEmpty() && !this._right.isEmpty()) {
				return this._right;
			} else if (!this._left.isEmpty() && this._right.isEmpty()) {
				return this._left;
			} else {
				NonEmptyBST<T> rightMin = (NonEmptyBST<T>) this._right;
				rightMin = rightMin.findMin();
				this._element = rightMin.getElement();
				this.setRight(this._right.remove(rightMin.getElement()));
				this.setLeft(this._left);
			}
		}
		return this;
	}

	private NonEmptyBST<T> findMax() {
		if (this._right.isEmpty()){
			return this;
		} else {
			NonEmptyBST<T> right = (NonEmptyBST<T>) this._right;
			return right.findMax();
		}
	}

	private NonEmptyBST<T> findMin() {
		if (this._left.isEmpty()){
			return this;
		} else {
			NonEmptyBST<T> left = (NonEmptyBST<T>) this._left;
			return left.findMin();
		}
	}
	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(this._element.toString() + " ");
		if (!this._left.isEmpty()){
			this._left.printPreOrderTraversal();
		}
		if (!this._right.isEmpty()) {
			this._right.printPreOrderTraversal();
		}
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (!this._left.isEmpty()){
			this._left.printPostOrderTraversal();
		}
		if (!this._right.isEmpty()) {
			this._right.printPostOrderTraversal();
		}
		System.out.print(this._element.toString() + " ");
	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		for (int i = 0; i <= this.getHeight(); i++) {
			this.printAtHeight(i);
		}
	}

	private void printAtHeight(int height){
		if (height == 0){
			System.out.print(this._element.toString() + " ");
		} else {
			if (!this._left.isEmpty()){
				((NonEmptyBST<T>) this._left).printAtHeight(height - 1);
			}
			if (!this._right.isEmpty()){
				((NonEmptyBST<T>) this._right).printAtHeight(height - 1);
			}
		}
	}

	@Override
	public int getHeight() {
		return Math.max(_left.getHeight(), _right.getHeight())+1;
	}


	@Override
	public BST<T> getLeft() {
		return _left;
	}

	public void setLeft(BST<T> left) {
		_left = left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	public void setRight(BST<T> right) {
		_right = right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}

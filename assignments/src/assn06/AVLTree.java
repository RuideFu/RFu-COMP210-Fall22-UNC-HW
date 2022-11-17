package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
//    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
//        _height = 0;
        _size = 0;
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     private AVLTree<T> rotateLeft(boolean recur) {
         // You should implement left rotation and then use this
         // method as needed when fixing imbalances.
         if (this._right == null || this._value == null){
             return this;
         } else {
             if (this._right.heightDiff() > 0 && recur) {
                 this._right = this._right.rotateRight(false);
             }
             AVLTree<T> cur = this;
             AVLTree<T> curRight = this._right;
             AVLTree<T> temp = this._right._left;
             curRight._left = cur;
             curRight._left._right = temp;
             curRight._left._size -= curRight._size;
             if (temp != null){
                 curRight._left._size += temp._size;
             }
             curRight._size = 1;
             if (curRight._left != null) {
                 curRight._size += curRight._left._size;
             }
             if (curRight._right != null) {
                 curRight._size += curRight._right._size;
             }
             return curRight;
         }
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private AVLTree<T> rotateRight(boolean recur) {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
         if (this._left == null || this._value == null){
             return this;
         } else {
             if (this._left.heightDiff() < 0 && recur) {
                this._left = this._left.rotateLeft(false);
             }
             AVLTree<T> cur = this;
             AVLTree<T> curLeft = this._left;
             AVLTree<T> temp = this._left._right;
             curLeft._right = cur;
             curLeft._right._left = temp;
             curLeft._right._size -= curLeft._size;
             if (temp != null){
                 curLeft._right._size += temp._size;
             }
             curLeft._size = 1;
             if (curLeft._left != null) {
                 curLeft._size += curLeft._left._size;
             }
             if (curLeft._right != null) {
                 curLeft._size += curLeft._right._size;
             }
             return curLeft;
         }
     }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
         if (element == null){
             return this;
         }
        AVLTree<T> new_tree = new AVLTree<T>();
        new_tree._value = element;
        new_tree._size = 1;
        if (this.isEmpty() || this._value == null) {
            return new_tree;
        } else {
            this._size++;
            if (element.compareTo(this._value) < 0) {
                if (this._left == null){
                    this._left = new_tree;
                } else {
                    this._left = (AVLTree<T>) this._left.insert(element);
                }
            } else {
                if (this._right == null){
                    this._right = new_tree;
                } else {
                    this._right = (AVLTree<T>) this._right.insert(element);
                }
            }
            return this.reBalance();
        }
    }

    @Override
    public int height() {
        if (this._value  == null){
            return -1;
        } else if (this._left == null && this._right == null) {
            return 1;
        } else {
            if (this._left == null){
                return 1 + this._right.height();
            } else if (this._right == null){
                return 1 + this._left.height();
            } else {
                return Math.max(this._left.height(), this._right.height())+1;
            }
        }
    }

    private int heightDiff(){
        if (this._left == null && this._right == null){
            return 0;
        } else if (this._left == null){
            return -this._right.height();
        } else if (this._right == null){
            return this._left.height();
        } else {
            return this._left.height() - this._right.height();
        }
    }

    private SelfBalancingBST<T> reBalance(){
         if (this._value == null) {
             return new AVLTree<T>();
         }
         try {
             if (this.heightDiff() >= 2) {
                 return this.rotateRight(true);
             } else if (this.heightDiff() <= -2)  {
                 return this.rotateLeft(true);
             }
         } catch (Exception e){
             return this;
         }
         return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
         if (element == null){
             return this;
         } else if (this.isEmpty() || this._value == null){
             return new AVLTree<T>();
         } else if (this.contains(element)){
             this._size--;
             if (element.compareTo(this._value) < 0 && this._left != null) {
                 this._left = (AVLTree<T>) this._left.remove(element);
                 if (this._left.isEmpty()){
                     this._left = null;
                 }
//                 return this;
//                 return this.reBalance();
             } else if (element.compareTo(this._value) > 0 && this._left != null) {
                 this._right = (AVLTree<T>) this._right.remove(element);
                 if (this._right.isEmpty()){
                     this._right = null;
                 }
//                 return this;
//                 return this.reBalance();
             } else if (element.compareTo(this._value) == 0) {
                 if (this._left == null && this._right == null) {
                     return new AVLTree<T>();
                 } else if (this._left == null) {
                     return this._right;
                 } else if (this._right == null) {
                     return this._left;
                 } else {
                     T rightMin = this._right.findMin();
                     this._value = rightMin;
                     this._right = (AVLTree<T>) this._right.remove(rightMin);
                     if (this._right.isEmpty()){
                         this._right = null;
                     }
//                     T leftMax = this._left.findMax();
//                     this._value = leftMax;
//                     this._left = (AVLTree<T>) this._left.remove(leftMax);
//                     if (this._left.isEmpty()){
//                         this._left = null;
//                     }
//                     return this;
//                     return this.reBalance();
                 }
             }
         }
         if (this == null || this.isEmpty()){
             return new AVLTree<T>();
         }
         return this.reBalance();
    }

    @Override
    public T findMin() {
        if (this._left != null){
            return this._left.findMin();
        } else {
            return this._value;
        }
    }

    @Override
    public T findMax() {
        if (this._right != null){
            return this._right.findMax();
        } else {
            return this._value;
        }
    }

    @Override
    public boolean contains(T element) {
         if (element == null || this.isEmpty() || this._value == null){
             return false;
         }
        if (element.compareTo(this._value) == 0) {
            return true;
        } else if (element.compareTo(this._value) < 0){
            if (this._left == null) {
                return false;
            } else {
                return this._left.contains(element);
            }
        } else {
            if (this._right == null) {
                return false;
            } else {
                return this._right.contains(element);
            }
        }
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        if (this._left == null) {
            return new AVLTree<T>();
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
        if (this._right == null) {
            return new AVLTree<T>();
        }
         return _right;
    }

}
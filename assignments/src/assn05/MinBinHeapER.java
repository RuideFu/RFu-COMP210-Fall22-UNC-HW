package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MinBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    public MinBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();
        for (int i = 0; i < initialEntries.length; i++) {
            _heap.add(initialEntries[i]);
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    @Override
    public void enqueue(V value, P priority) {
        _heap.add(new Patient<>(value, priority));
        bubbleUp(_heap.size()-1);
    }

    public void enqueue(V value) {
        _heap.add(new Patient<>(value));
        bubbleUp(_heap.size()-1);
    }

    private void bubbleUp(int index){
        if (index == 0){
            return;
        } else {
            int pIndex = parentInd(index);
            Prioritized<V, P> parent = _heap.get(pIndex);
            Prioritized<V, P> child = _heap.get(index);
            if (parent.getPriority().compareTo(child.getPriority()) < 0) {
                return;
            } else {
                _heap.set(index, parent);
                _heap.set(pIndex, child);
                bubbleUp(pIndex);
            }
        }
    }

    private int parentInd(int index){
        if (index == 0){
            return -1;
        } else {
            return Math.floorDiv(index-1, 2);
        }
    }

    @Override
    public V dequeue() {
        if (_heap.size() == 0) {
            return null;
        } else {
            V minV = _heap.get(0).getValue();
            _heap.set(0, _heap.get(_heap.size()-1));
            _heap.remove(_heap.size()-1);
            bubbleDown(0);
            return minV;
        }
    }

    private void bubbleDown(int index) {
        int leftIndex = leftChildInd(index);
        int rightIndex = rightChildInd(index);
        int minIndex = leftIndex;
        if (rightIndex < 0) {
            if (leftIndex < 0){
                return;
            }
        } else {
            if (_heap.get(leftIndex).getPriority().compareTo(_heap.get(rightIndex).getPriority()) > 0){
                minIndex = rightIndex;
            }
        }
        Prioritized<V, P> parent = _heap.get(index);
        Prioritized<V, P> child = _heap.get(minIndex);
        if (parent.getPriority().compareTo(child.getPriority()) > 0){
            _heap.set(index, child);
            _heap.set(minIndex, parent);
            bubbleDown(minIndex);
        } else {
            return;
        }
    }

    private int leftChildInd(int index){
        index = 2*index+1;
        if (index >= _heap.size()){
            return -1;
        } else {
            return index;
        }
    }

    private int rightChildInd(int index){
        index = 2*index+2;
        if (index >= _heap.size()){
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public V getMin() {
        if (_heap.size() == 0){
            return null;
        } else {
            return _heap.get(0).getValue();
        }
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}

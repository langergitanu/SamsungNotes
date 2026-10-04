package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FilterListIterator implements ListIterator {
    private ListIterator iterator;
    private Object nextObject;
    private Predicate predicate;
    private Object previousObject;
    private boolean nextObjectSet = false;
    private boolean previousObjectSet = false;
    private int nextIndex = 0;

    public FilterListIterator() {
    }

    private void clearNextObject() {
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    private void clearPreviousObject() {
        this.previousObject = null;
        this.previousObjectSet = false;
    }

    private boolean setNextObject() {
        if (this.previousObjectSet) {
            clearPreviousObject();
            if (!setNextObject()) {
                return false;
            }
            clearNextObject();
        }
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            if (this.predicate.evaluate(next)) {
                this.nextObject = next;
                this.nextObjectSet = true;
                return true;
            }
        }
        return false;
    }

    private boolean setPreviousObject() {
        if (this.nextObjectSet) {
            clearNextObject();
            if (!setPreviousObject()) {
                return false;
            }
            clearPreviousObject();
        }
        while (this.iterator.hasPrevious()) {
            Object objPrevious = this.iterator.previous();
            if (this.predicate.evaluate(objPrevious)) {
                this.previousObject = objPrevious;
                this.previousObjectSet = true;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
    }

    public ListIterator getListIterator() {
        return this.iterator;
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.nextObjectSet) {
            return true;
        }
        return setNextObject();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        if (this.previousObjectSet) {
            return true;
        }
        return setPreviousObject();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!this.nextObjectSet && !setNextObject()) {
            throw new NoSuchElementException();
        }
        this.nextIndex++;
        Object obj = this.nextObject;
        clearNextObject();
        return obj;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.nextIndex;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!this.previousObjectSet && !setPreviousObject()) {
            throw new NoSuchElementException();
        }
        this.nextIndex--;
        Object obj = this.previousObject;
        clearPreviousObject();
        return obj;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.nextIndex - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
    }

    public void setListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public FilterListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public FilterListIterator(ListIterator listIterator, Predicate predicate) {
        this.iterator = listIterator;
        this.predicate = predicate;
    }

    public FilterListIterator(Predicate predicate) {
        this.predicate = predicate;
    }
}

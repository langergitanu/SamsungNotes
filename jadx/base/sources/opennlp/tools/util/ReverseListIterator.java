package opennlp.tools.util;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReverseListIterator<T> implements Iterator<T> {
    private int index;
    private final List<T> list;

    public ReverseListIterator(List<T> list) {
        this.index = list.size() - 1;
        this.list = list;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        List<T> list = this.list;
        int i = this.index;
        this.index = i - 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

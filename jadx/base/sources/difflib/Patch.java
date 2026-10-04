package difflib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Patch {
    private List<Delta> deltas = new LinkedList();

    public void addDelta(Delta delta) {
        this.deltas.add(delta);
    }

    public List<?> applyTo(List<?> list) {
        LinkedList linkedList = new LinkedList(list);
        ListIterator<Delta> listIterator = getDeltas().listIterator(this.deltas.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().applyTo(linkedList);
        }
        return linkedList;
    }

    public List<Delta> getDeltas() {
        Collections.sort(this.deltas, DeltaComparator.INSTANCE);
        return this.deltas;
    }

    public List<?> restore(List<?> list) {
        LinkedList linkedList = new LinkedList(list);
        ListIterator<Delta> listIterator = getDeltas().listIterator(this.deltas.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().restore(linkedList);
        }
        return linkedList;
    }
}

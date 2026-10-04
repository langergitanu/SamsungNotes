package difflib;

import difflib.Delta;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ChangeDelta extends Delta {
    public ChangeDelta(Chunk chunk, Chunk chunk2) {
        super(chunk, chunk2);
    }

    @Override // difflib.Delta
    public void applyTo(List<Object> list) throws PatchFailedException {
        verify(list);
        int position = getOriginal().getPosition();
        int size = getOriginal().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            list.remove(position);
        }
        Iterator<?> it = getRevised().getLines().iterator();
        while (it.hasNext()) {
            list.add(position + i, it.next());
            i++;
        }
    }

    @Override // difflib.Delta
    public Delta.TYPE getType() {
        return Delta.TYPE.CHANGE;
    }

    @Override // difflib.Delta
    public void restore(List<Object> list) {
        int position = getRevised().getPosition();
        int size = getRevised().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            list.remove(position);
        }
        Iterator<?> it = getOriginal().getLines().iterator();
        while (it.hasNext()) {
            list.add(position + i, it.next());
            i++;
        }
    }

    public String toString() {
        return "[ChangeDelta, position: " + getOriginal().getPosition() + ", lines: " + getOriginal().getLines() + " to " + getRevised().getLines() + "]";
    }

    @Override // difflib.Delta
    public void verify(List<?> list) throws PatchFailedException {
        getOriginal().verify(list);
        if (getOriginal().getPosition() > list.size()) {
            throw new PatchFailedException("Incorrect patch for delta: delta original position > target size");
        }
    }
}

package difflib;

import difflib.Delta;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InsertDelta extends Delta {
    public InsertDelta(Chunk chunk, Chunk chunk2) {
        super(chunk, chunk2);
    }

    @Override // difflib.Delta
    public void applyTo(List<Object> list) throws PatchFailedException {
        verify(list);
        int position = getOriginal().getPosition();
        List<?> lines = getRevised().getLines();
        for (int i = 0; i < lines.size(); i++) {
            list.add(position + i, lines.get(i));
        }
    }

    @Override // difflib.Delta
    public Delta.TYPE getType() {
        return Delta.TYPE.INSERT;
    }

    @Override // difflib.Delta
    public void restore(List<Object> list) {
        int position = getRevised().getPosition();
        int size = getRevised().size();
        for (int i = 0; i < size; i++) {
            list.remove(position);
        }
    }

    public String toString() {
        return "[InsertDelta, position: " + getOriginal().getPosition() + ", lines: " + getRevised().getLines() + "]";
    }

    @Override // difflib.Delta
    public void verify(List<?> list) throws PatchFailedException {
        if (getOriginal().getPosition() > list.size()) {
            throw new PatchFailedException("Incorrect patch for delta: delta original position > target size");
        }
    }
}

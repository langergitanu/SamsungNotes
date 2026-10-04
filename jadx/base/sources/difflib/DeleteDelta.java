package difflib;

import difflib.Delta;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeleteDelta extends Delta {
    public DeleteDelta(Chunk chunk, Chunk chunk2) {
        super(chunk, chunk2);
    }

    @Override // difflib.Delta
    public void applyTo(List<Object> list) throws PatchFailedException {
        verify(list);
        int position = getOriginal().getPosition();
        int size = getOriginal().size();
        for (int i = 0; i < size; i++) {
            list.remove(position);
        }
    }

    @Override // difflib.Delta
    public Delta.TYPE getType() {
        return Delta.TYPE.DELETE;
    }

    @Override // difflib.Delta
    public void restore(List<Object> list) {
        int position = getRevised().getPosition();
        List<?> lines = getOriginal().getLines();
        for (int i = 0; i < lines.size(); i++) {
            list.add(position + i, lines.get(i));
        }
    }

    public String toString() {
        return "[DeleteDelta, position: " + getOriginal().getPosition() + ", lines: " + getOriginal().getLines() + "]";
    }

    @Override // difflib.Delta
    public void verify(List<?> list) throws PatchFailedException {
        getOriginal().verify(list);
    }
}

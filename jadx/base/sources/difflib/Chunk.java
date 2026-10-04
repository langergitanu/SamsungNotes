package difflib;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Chunk {
    private List<?> lines;
    private final int position;

    public Chunk(int i, List<?> list) {
        this.position = i;
        this.lines = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Chunk chunk = (Chunk) obj;
        List<?> list = this.lines;
        if (list == null) {
            if (chunk.lines != null) {
                return false;
            }
        } else if (!list.equals(chunk.lines)) {
            return false;
        }
        return this.position == chunk.position;
    }

    public List<?> getLines() {
        return this.lines;
    }

    public int getPosition() {
        return this.position;
    }

    public int hashCode() {
        List<?> list = this.lines;
        return size() + (((((list == null ? 0 : list.hashCode()) + 31) * 31) + this.position) * 31);
    }

    public int last() {
        return (size() + getPosition()) - 1;
    }

    public void setLines(List<?> list) {
        this.lines = list;
    }

    public int size() {
        return this.lines.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[position: ");
        sb.append(this.position);
        sb.append(", size: ");
        sb.append(size());
        sb.append(", lines: ");
        return AbstractC0541b.m777s(sb, this.lines, "]");
    }

    public void verify(List<?> list) throws PatchFailedException {
        if (last() > list.size()) {
            throw new PatchFailedException("Incorrect Chunk: the position of chunk > target size");
        }
        for (int i = 0; i < size(); i++) {
            if (!list.get(this.position + i).equals(this.lines.get(i))) {
                throw new PatchFailedException("Incorrect Chunk: the chunk content doesn't match the target");
            }
        }
    }

    public Chunk(int i, Object[] objArr) {
        this.position = i;
        this.lines = Arrays.asList(objArr);
    }
}

package difflib;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Delta {
    private Chunk original;
    private Chunk revised;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TYPE {
        CHANGE,
        DELETE,
        INSERT
    }

    public Delta(Chunk chunk, Chunk chunk2) {
        this.original = chunk;
        this.revised = chunk2;
    }

    public abstract void applyTo(List<Object> list);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Delta delta = (Delta) obj;
        Chunk chunk = this.original;
        if (chunk == null) {
            if (delta.original != null) {
                return false;
            }
        } else if (!chunk.equals(delta.original)) {
            return false;
        }
        Chunk chunk2 = this.revised;
        if (chunk2 == null) {
            if (delta.revised != null) {
                return false;
            }
        } else if (!chunk2.equals(delta.revised)) {
            return false;
        }
        return true;
    }

    public Chunk getOriginal() {
        return this.original;
    }

    public Chunk getRevised() {
        return this.revised;
    }

    public abstract TYPE getType();

    public int hashCode() {
        Chunk chunk = this.original;
        int iHashCode = ((chunk == null ? 0 : chunk.hashCode()) + 31) * 31;
        Chunk chunk2 = this.revised;
        return iHashCode + (chunk2 != null ? chunk2.hashCode() : 0);
    }

    public abstract void restore(List<Object> list);

    public void setOriginal(Chunk chunk) {
        this.original = chunk;
    }

    public void setRevised(Chunk chunk) {
        this.revised = chunk;
    }

    public abstract void verify(List<?> list);
}

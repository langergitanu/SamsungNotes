package difflib;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiffRow {
    private String newLine;
    private String oldLine;
    private Tag tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Tag {
        INSERT,
        DELETE,
        CHANGE,
        EQUAL
    }

    public DiffRow(Tag tag, String str, String str2) {
        this.tag = tag;
        this.oldLine = str;
        this.newLine = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiffRow diffRow = (DiffRow) obj;
        String str = this.newLine;
        if (str == null) {
            if (diffRow.newLine != null) {
                return false;
            }
        } else if (!str.equals(diffRow.newLine)) {
            return false;
        }
        String str2 = this.oldLine;
        if (str2 == null) {
            if (diffRow.oldLine != null) {
                return false;
            }
        } else if (!str2.equals(diffRow.oldLine)) {
            return false;
        }
        Tag tag = this.tag;
        if (tag == null) {
            if (diffRow.tag != null) {
                return false;
            }
        } else if (!tag.equals(diffRow.tag)) {
            return false;
        }
        return true;
    }

    public String getNewLine() {
        return this.newLine;
    }

    public String getOldLine() {
        return this.oldLine;
    }

    public Tag getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.newLine;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.oldLine;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Tag tag = this.tag;
        return iHashCode2 + (tag != null ? tag.hashCode() : 0);
    }

    public void setNewLine(String str) {
        this.newLine = str;
    }

    public void setOldLine(String str) {
        this.oldLine = str;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.tag);
        sb.append(",");
        sb.append(this.oldLine);
        sb.append(",");
        return AbstractC0622a.m1170p(this.newLine, "]", sb);
    }
}

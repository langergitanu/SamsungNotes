package opennlp.tools.entitylinker;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.ArrayList;
import java.util.Objects;
import opennlp.tools.entitylinker.BaseLink;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LinkedSpan<T extends BaseLink> extends Span {
    private static final long serialVersionUID = 2089863052379334449L;
    private ArrayList<T> linkedEntries;
    private String searchTerm;
    private int sentenceid;

    public LinkedSpan(ArrayList<T> arrayList, int i, int i2, String str) {
        this(arrayList, i, i2, str, 0.0d);
    }

    @Override // opennlp.tools.util.Span
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof LinkedSpan)) {
            LinkedSpan linkedSpan = (LinkedSpan) obj;
            if (Objects.equals(this.linkedEntries, linkedSpan.linkedEntries) && this.sentenceid == linkedSpan.sentenceid && Objects.equals(this.searchTerm, linkedSpan.searchTerm)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> getLinkedEntries() {
        return this.linkedEntries;
    }

    public String getSearchTerm() {
        return this.searchTerm;
    }

    public int getSentenceid() {
        return this.sentenceid;
    }

    @Override // opennlp.tools.util.Span
    public int hashCode() {
        return Objects.hash(this.linkedEntries, Integer.valueOf(this.sentenceid), this.searchTerm);
    }

    public void setLinkedEntries(ArrayList<T> arrayList) {
        this.linkedEntries = arrayList;
    }

    public void setSearchTerm(String str) {
        this.searchTerm = str;
    }

    public void setSentenceid(int i) {
        this.sentenceid = i;
    }

    @Override // opennlp.tools.util.Span
    public String toString() {
        int i = this.sentenceid;
        String str = this.searchTerm;
        ArrayList<T> arrayList = this.linkedEntries;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("LinkedSpan\nsentenceid=", i, "\nsearchTerm=", str, "\nlinkedEntries=\n");
        sbM1629s.append(arrayList);
        sbM1629s.append("\n");
        return sbM1629s.toString();
    }

    public LinkedSpan(ArrayList<T> arrayList, int i, int i2, String str, double d) {
        super(i, i2, str, d);
        this.sentenceid = 0;
        this.linkedEntries = arrayList;
    }

    public LinkedSpan(ArrayList<T> arrayList, int i, int i2) {
        super(i, i2);
        this.sentenceid = 0;
        this.linkedEntries = arrayList;
    }

    public LinkedSpan(ArrayList<T> arrayList, Span span, int i) {
        super(span, i);
        this.sentenceid = 0;
        this.linkedEntries = arrayList;
    }
}

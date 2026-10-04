package opennlp.tools.formats.brat;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BratAnnotation {

    /* JADX INFO: renamed from: id */
    private final String f9657id;
    private String note;
    private final String type;

    public BratAnnotation(String str, String str2) {
        Objects.requireNonNull(str);
        this.f9657id = str;
        Objects.requireNonNull(str2);
        this.type = str2;
        this.note = "";
    }

    public String getId() {
        return this.f9657id;
    }

    public String getNote() {
        return this.note;
    }

    public String getType() {
        return this.type;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public String toString() {
        return (this.f9657id + " " + this.type + " " + this.note).trim();
    }
}

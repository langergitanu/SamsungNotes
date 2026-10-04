package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class UnzipParameters {
    private boolean ignoreAllFileAttributes;
    private boolean ignoreArchiveFileAttribute;
    private boolean ignoreDateTimeAttributes;
    private boolean ignoreHiddenFileAttribute;
    private boolean ignoreReadOnlyFileAttribute;
    private boolean ignoreSystemFileAttribute;

    public boolean isIgnoreAllFileAttributes() {
        return this.ignoreAllFileAttributes;
    }

    public boolean isIgnoreArchiveFileAttribute() {
        return this.ignoreArchiveFileAttribute;
    }

    public boolean isIgnoreDateTimeAttributes() {
        return this.ignoreDateTimeAttributes;
    }

    public boolean isIgnoreHiddenFileAttribute() {
        return this.ignoreHiddenFileAttribute;
    }

    public boolean isIgnoreReadOnlyFileAttribute() {
        return this.ignoreReadOnlyFileAttribute;
    }

    public boolean isIgnoreSystemFileAttribute() {
        return this.ignoreSystemFileAttribute;
    }

    public void setIgnoreAllFileAttributes(boolean z) {
        this.ignoreAllFileAttributes = z;
    }

    public void setIgnoreArchiveFileAttribute(boolean z) {
        this.ignoreArchiveFileAttribute = z;
    }

    public void setIgnoreDateTimeAttributes(boolean z) {
        this.ignoreDateTimeAttributes = z;
    }

    public void setIgnoreHiddenFileAttribute(boolean z) {
        this.ignoreHiddenFileAttribute = z;
    }

    public void setIgnoreReadOnlyFileAttribute(boolean z) {
        this.ignoreReadOnlyFileAttribute = z;
    }

    public void setIgnoreSystemFileAttribute(boolean z) {
        this.ignoreSystemFileAttribute = z;
    }
}

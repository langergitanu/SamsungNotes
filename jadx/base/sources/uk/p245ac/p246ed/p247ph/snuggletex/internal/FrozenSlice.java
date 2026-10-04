package uk.p245ac.p246ed.p247ph.snuggletex.internal;

import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class FrozenSlice {
    public final WorkingDocument document;
    public final int endIndex;
    public final int startIndex;
    private transient String stringRepresentation;

    public FrozenSlice(WorkingDocument workingDocument, int i, int i2) {
        this.document = workingDocument;
        this.startIndex = i;
        this.endIndex = i2;
    }

    public final void ensureSharesDocumentWith(FrozenSlice frozenSlice) {
        if (sharesDocumentWith(frozenSlice)) {
            return;
        }
        throw new IllegalArgumentException("Document mismatch for FrozenSlice " + frozenSlice);
    }

    public CharSequence extract() {
        return this.document.extract(this.startIndex, this.endIndex);
    }

    public WorkingDocument getDocument() {
        return this.document;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public boolean isWhitespace() {
        return this.document.isRegionWhitespace(this.startIndex, this.endIndex);
    }

    public FrozenSlice rightOuterSpan(FrozenSlice frozenSlice) {
        ensureSharesDocumentWith(frozenSlice);
        return this.document.freezeSlice(this.startIndex, frozenSlice.endIndex);
    }

    public final boolean sharesDocumentWith(FrozenSlice frozenSlice) {
        return this.document.equals(frozenSlice.document);
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            this.stringRepresentation = "FrozenSlice(range=[" + this.startIndex + "," + this.endIndex + "), value='" + extract().toString().replace("\n", "%n").replace(StringUtils.f9761CR, "%r") + "')";
        }
        return this.stringRepresentation;
    }
}

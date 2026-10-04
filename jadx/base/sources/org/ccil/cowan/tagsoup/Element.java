package org.ccil.cowan.tagsoup;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Element {
    private boolean preclosed;
    private AttributesImpl theAtts;
    private Element theNext;
    private ElementType theType;

    public Element(ElementType elementType, boolean z) {
        this.theType = elementType;
        if (z) {
            this.theAtts = new AttributesImpl(elementType.atts());
        } else {
            this.theAtts = new AttributesImpl();
        }
        this.theNext = null;
        this.preclosed = false;
    }

    public void anonymize() {
        for (int length = this.theAtts.getLength() - 1; length >= 0; length--) {
            if (this.theAtts.getType(length).equals("ID") || this.theAtts.getQName(length).equals("name")) {
                this.theAtts.removeAttribute(length);
            }
        }
    }

    public AttributesImpl atts() {
        return this.theAtts;
    }

    public boolean canContain(Element element) {
        return this.theType.canContain(element.theType);
    }

    public void clean() {
        for (int length = this.theAtts.getLength() - 1; length >= 0; length--) {
            String localName = this.theAtts.getLocalName(length);
            if (this.theAtts.getValue(length) == null || localName == null || localName.length() == 0) {
                this.theAtts.removeAttribute(length);
            }
        }
    }

    public int flags() {
        return this.theType.flags();
    }

    public boolean isPreclosed() {
        return this.preclosed;
    }

    public String localName() {
        return this.theType.localName();
    }

    public int memberOf() {
        return this.theType.memberOf();
    }

    public int model() {
        return this.theType.model();
    }

    public String name() {
        return this.theType.name();
    }

    public String namespace() {
        return this.theType.namespace();
    }

    public Element next() {
        return this.theNext;
    }

    public ElementType parent() {
        return this.theType.parent();
    }

    public void preclose() {
        this.preclosed = true;
    }

    public void setAttribute(String str, String str2, String str3) {
        this.theType.setAttribute(this.theAtts, str, str2, str3);
    }

    public void setNext(Element element) {
        this.theNext = element;
    }

    public ElementType type() {
        return this.theType;
    }
}

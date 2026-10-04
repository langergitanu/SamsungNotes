package com.vladsch.flexmark.util.html;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AttributeImpl implements Attribute {
    private final String name;
    private final String value;
    private final char valueListDelimiter;
    private final char valueNameDelimiter;

    private AttributeImpl(CharSequence charSequence, CharSequence charSequence2, char c, char c2) {
        this.name = String.valueOf(charSequence);
        this.valueListDelimiter = c;
        this.valueNameDelimiter = c2;
        this.value = charSequence2 == null ? "" : String.valueOf(charSequence2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOfValue(CharSequence charSequence, CharSequence charSequence2, char c, char c2) {
        int iIndexOf;
        if (charSequence2.length() != 0 && charSequence.length() != 0) {
            int i = 0;
            if (c == 0) {
                return charSequence.equals(charSequence2) ? 0 : -1;
            }
            BasedSequence basedSequenceM13437of = BasedSequence.m13437of(charSequence);
            while (i < charSequence.length() && (iIndexOf = basedSequenceM13437of.indexOf(charSequence2, i)) != -1) {
                int length = charSequence2.length() + iIndexOf;
                if (iIndexOf != 0) {
                    int i2 = iIndexOf - 1;
                    if (charSequence.charAt(i2) == c || (c2 != 0 && charSequence.charAt(i2) == c2)) {
                        if (length >= charSequence.length() || charSequence.charAt(length) == c || (c2 != 0 && charSequence.charAt(length) == c2)) {
                            return iIndexOf;
                        }
                    }
                }
                i = length + 1;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: of */
    public static AttributeImpl m13361of(Attribute attribute) {
        return m13365of(attribute.getName(), attribute.getValue(), attribute.getValueListDelimiter(), attribute.getValueNameDelimiter());
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public boolean containsValue(CharSequence charSequence) {
        return indexOfValue(this.value, charSequence, this.valueListDelimiter, this.valueNameDelimiter) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (this.name.equals(attribute.getName())) {
            return this.value.equals(attribute.getValue());
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public String getName() {
        return this.name;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public String getValue() {
        return this.value;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public char getValueListDelimiter() {
        return this.valueListDelimiter;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public char getValueNameDelimiter() {
        return this.valueNameDelimiter;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public boolean isNonRendering() {
        if (this.name.indexOf(32) == -1) {
            return this.value.isEmpty() && Attribute.NON_RENDERING_WHEN_EMPTY.contains(this.name);
        }
        return true;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public Attribute removeValue(CharSequence charSequence) {
        MutableAttribute mutableAttributeRemoveValue = toMutable().removeValue(charSequence);
        return mutableAttributeRemoveValue.equals(this) ? this : mutableAttributeRemoveValue.toImmutable();
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public Attribute replaceValue(CharSequence charSequence) {
        return charSequence.equals(this.value) ? this : m13365of(this.name, charSequence, this.valueListDelimiter, this.valueNameDelimiter);
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public Attribute setValue(CharSequence charSequence) {
        MutableAttribute value = toMutable().setValue(charSequence);
        return value.equals(this) ? this : value.toImmutable();
    }

    public String toString() {
        return AbstractC0541b.m775q("AttributeImpl { name='", this.name, "', value='", this.value, "' }");
    }

    /* JADX INFO: renamed from: of */
    public static AttributeImpl m13362of(CharSequence charSequence) {
        return m13365of(charSequence, charSequence, (char) 0, (char) 0);
    }

    @Override // com.vladsch.flexmark.util.misc.Immutable
    public MutableAttribute toMutable() {
        return MutableAttributeImpl.m13369of(this);
    }

    /* JADX INFO: renamed from: of */
    public static AttributeImpl m13363of(CharSequence charSequence, CharSequence charSequence2) {
        return m13365of(charSequence, charSequence2, (char) 0, (char) 0);
    }

    /* JADX INFO: renamed from: of */
    public static AttributeImpl m13364of(CharSequence charSequence, CharSequence charSequence2, char c) {
        return m13365of(charSequence, charSequence2, c, (char) 0);
    }

    /* JADX INFO: renamed from: of */
    public static AttributeImpl m13365of(CharSequence charSequence, CharSequence charSequence2, char c, char c2) {
        if (charSequence.equals(Attribute.CLASS_ATTR)) {
            return new AttributeImpl(charSequence, charSequence2, ' ', (char) 0);
        }
        if (charSequence.equals("style")) {
            return new AttributeImpl(charSequence, charSequence2, SQLKeyword.DELIMITER, ':');
        }
        return new AttributeImpl(charSequence, charSequence2, c, c2);
    }
}

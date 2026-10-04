package com.vladsch.flexmark.util.html;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.imagetranslation.inpainting.C7126a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MutableAttributeImpl implements MutableAttribute {
    private final String name;
    private String value;
    private final char valueListDelimiter;
    private final char valueNameDelimiter;
    private LinkedHashMap<String, String> values;

    private MutableAttributeImpl(CharSequence charSequence, CharSequence charSequence2, char c, char c2) {
        this.name = String.valueOf(charSequence);
        this.valueListDelimiter = c;
        this.valueNameDelimiter = c2;
        this.value = charSequence2 == null ? "" : String.valueOf(charSequence2);
        this.values = null;
    }

    private void forEachValue(CharSequence charSequence, BiConsumer<String, String> biConsumer) {
        String strValueOf = charSequence == null ? "" : String.valueOf(charSequence);
        int i = 0;
        while (i < strValueOf.length()) {
            int iIndexOf = strValueOf.indexOf(this.valueListDelimiter, i);
            int length = iIndexOf == -1 ? strValueOf.length() : iIndexOf;
            if (i < length) {
                String strTrim = strValueOf.substring(i, length).trim();
                if (!strTrim.isEmpty()) {
                    char c = this.valueNameDelimiter;
                    int iIndexOf2 = c == 0 ? -1 : strTrim.indexOf(c);
                    biConsumer.accept(iIndexOf2 == -1 ? strTrim : strTrim.substring(0, iIndexOf2), iIndexOf2 == -1 ? "" : strTrim.substring(iIndexOf2 + 1));
                }
            }
            if (iIndexOf == -1) {
                return;
            } else {
                i = length + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeValue$1(Map map, boolean[] zArr, String str, String str2) {
        if (map.remove(str) != null) {
            zArr[0] = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setValue$0(Map map, String str, String str2) {
        if (this.valueNameDelimiter == 0 || !str2.isEmpty()) {
            map.put(str, str2);
        } else {
            map.remove(str);
        }
    }

    /* JADX INFO: renamed from: of */
    public static MutableAttributeImpl m13369of(Attribute attribute) {
        return m13373of(attribute.getName(), attribute.getValue(), attribute.getValueListDelimiter(), attribute.getValueNameDelimiter());
    }

    @Override // com.vladsch.flexmark.util.html.MutableAttribute, com.vladsch.flexmark.util.html.Attribute
    public boolean containsValue(CharSequence charSequence) {
        return AttributeImpl.indexOfValue(this.value, charSequence, this.valueListDelimiter, this.valueNameDelimiter) != -1;
    }

    @Override // com.vladsch.flexmark.util.html.MutableAttribute
    public MutableAttribute copy() {
        return m13369of(this);
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
            return getValue().equals(attribute.getValue());
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public String getName() {
        return this.name;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public String getValue() {
        if (this.value == null) {
            this.value = valueFromMap();
        }
        return this.value;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public char getValueListDelimiter() {
        return this.valueListDelimiter;
    }

    public Map<String, String> getValueMap() {
        if (this.values == null) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            this.values = linkedHashMap;
            if (this.valueListDelimiter == 0) {
                linkedHashMap.put(this.value, "");
            } else if (!this.value.isEmpty()) {
                int i = 0;
                while (i < this.value.length()) {
                    int iIndexOf = this.value.indexOf(this.valueListDelimiter, i);
                    int length = iIndexOf == -1 ? this.value.length() : iIndexOf;
                    if (i < length) {
                        String strSubstring = this.value.substring(i, length);
                        char c = this.valueNameDelimiter;
                        int iIndexOf2 = c != 0 ? strSubstring.indexOf(c) : -1;
                        if (iIndexOf2 == -1) {
                            this.values.put(strSubstring, "");
                        } else {
                            this.values.put(strSubstring.substring(0, iIndexOf2), strSubstring.substring(iIndexOf2 + 1));
                        }
                    }
                    if (iIndexOf == -1) {
                        break;
                    }
                    i = length + 1;
                }
            }
        }
        return this.values;
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public char getValueNameDelimiter() {
        return this.valueNameDelimiter;
    }

    public int hashCode() {
        return getValue().hashCode() + (this.name.hashCode() * 31);
    }

    @Override // com.vladsch.flexmark.util.html.Attribute
    public boolean isNonRendering() {
        if (this.name.indexOf(32) == -1) {
            return this.value.isEmpty() && Attribute.NON_RENDERING_WHEN_EMPTY.contains(this.name);
        }
        return true;
    }

    public void resetToValuesMap() {
        if (this.values == null) {
            throw new IllegalStateException("resetToValuesMap called when values is null");
        }
        this.value = null;
    }

    @Override // com.vladsch.flexmark.util.misc.Immutable
    public MutableAttribute toMutable() {
        return this;
    }

    public String toString() {
        return AbstractC0541b.m775q("MutableAttributeImpl { name='", this.name, "', value='", getValue(), "' }");
    }

    public String valueFromMap() {
        String next = "";
        if (this.valueListDelimiter != 0) {
            StringBuilder sb = new StringBuilder();
            if (this.valueNameDelimiter != 0) {
                String strValueOf = String.valueOf(this.valueListDelimiter);
                for (Map.Entry<String, String> entry : this.values.entrySet()) {
                    if (!entry.getKey().isEmpty()) {
                        sb.append(next);
                        sb.append(entry.getKey());
                        sb.append(this.valueNameDelimiter);
                        sb.append(entry.getValue());
                        next = strValueOf;
                    }
                }
            } else {
                String strValueOf2 = String.valueOf(this.valueListDelimiter);
                for (String str : this.values.keySet()) {
                    if (!str.isEmpty()) {
                        sb.append(next);
                        sb.append(str);
                        next = strValueOf2;
                    }
                }
            }
            this.value = sb.toString();
        } else {
            LinkedHashMap<String, String> linkedHashMap = this.values;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                next = this.values.keySet().iterator().next();
            }
            this.value = next;
        }
        return this.value;
    }

    /* JADX INFO: renamed from: of */
    public static MutableAttributeImpl m13370of(CharSequence charSequence) {
        return m13373of(charSequence, charSequence, (char) 0, (char) 0);
    }

    @Override // com.vladsch.flexmark.util.misc.Mutable
    public Attribute toImmutable() {
        return AttributeImpl.m13361of(this);
    }

    /* JADX INFO: renamed from: of */
    public static MutableAttributeImpl m13371of(CharSequence charSequence, CharSequence charSequence2) {
        return m13373of(charSequence, charSequence2, (char) 0, (char) 0);
    }

    @Override // com.vladsch.flexmark.util.html.MutableAttribute, com.vladsch.flexmark.util.html.Attribute
    public MutableAttributeImpl removeValue(CharSequence charSequence) {
        if (this.valueListDelimiter != 0) {
            if (charSequence != null && charSequence.length() != 0) {
                boolean[] zArr = {false};
                forEachValue(charSequence, new C7126a(getValueMap(), zArr, 3));
                if (zArr[0]) {
                    this.value = null;
                    return this;
                }
            }
        } else {
            String str = this.value;
            if (str == null || !str.contentEquals(charSequence)) {
                this.value = "";
                this.values = null;
                return this;
            }
        }
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.MutableAttribute, com.vladsch.flexmark.util.html.Attribute
    public MutableAttributeImpl replaceValue(CharSequence charSequence) {
        String strValueOf = charSequence == null ? "" : String.valueOf(charSequence);
        String str = this.value;
        if (str != null && charSequence != null && str.equals(strValueOf)) {
            return this;
        }
        this.value = strValueOf;
        this.values = null;
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.MutableAttribute, com.vladsch.flexmark.util.html.Attribute
    public MutableAttributeImpl setValue(CharSequence charSequence) {
        if (this.valueListDelimiter != 0) {
            if (charSequence != null && charSequence.length() != 0) {
                forEachValue(charSequence, new C7126a(this, getValueMap(), 2));
                this.value = null;
                return this;
            }
        } else {
            String str = this.value;
            if (str == null || !str.contentEquals(charSequence)) {
                this.value = charSequence == null ? "" : String.valueOf(charSequence);
                this.values = null;
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: of */
    public static MutableAttributeImpl m13372of(CharSequence charSequence, CharSequence charSequence2, char c) {
        return m13373of(charSequence, charSequence2, c, (char) 0);
    }

    /* JADX INFO: renamed from: of */
    public static MutableAttributeImpl m13373of(CharSequence charSequence, CharSequence charSequence2, char c, char c2) {
        if (Attribute.CLASS_ATTR.contentEquals(charSequence)) {
            return new MutableAttributeImpl(charSequence, charSequence2, ' ', (char) 0);
        }
        if ("style".contentEquals(charSequence)) {
            return new MutableAttributeImpl(charSequence, charSequence2, SQLKeyword.DELIMITER, ':');
        }
        return new MutableAttributeImpl(charSequence, charSequence2, c, c2);
    }
}

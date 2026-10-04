package com.vladsch.flexmark.util.html;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MutableAttributes extends Attributes {
    public MutableAttributes() {
    }

    public Attribute addValue(Attribute attribute) {
        return addValue(attribute.getName(), attribute.getValue());
    }

    public MutableAttributes addValues(Attributes attributes) {
        for (Attribute attribute : attributes.values()) {
            addValue(attribute.getName(), attribute.getValue());
        }
        return this;
    }

    public void clear() {
        this.attributes = null;
    }

    public LinkedHashMap<String, Attribute> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new LinkedHashMap<>();
        }
        return this.attributes;
    }

    public Attribute remove(Attribute attribute) {
        return remove(attribute.getName());
    }

    public Attribute removeValue(Attribute attribute) {
        return removeValue(attribute.getName(), attribute.getValue());
    }

    public Attribute replaceValue(Attribute attribute) {
        return replaceValue(attribute.getName(), attribute.getValue());
    }

    public void replaceValues(MutableAttributes mutableAttributes) {
        LinkedHashMap<String, Attribute> linkedHashMap = this.attributes;
        if (linkedHashMap == null) {
            this.attributes = new LinkedHashMap<>(mutableAttributes.attributes);
        } else {
            linkedHashMap.putAll(mutableAttributes.attributes);
        }
    }

    @Override // com.vladsch.flexmark.util.html.Attributes
    public Attributes toImmutable() {
        return new Attributes(this);
    }

    @Override // com.vladsch.flexmark.util.html.Attributes
    public MutableAttributes toMutable() {
        return this;
    }

    @Override // com.vladsch.flexmark.util.html.Attributes
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (String str2 : keySet()) {
            sb.append(str);
            sb.append(str2);
            Attribute attribute = this.attributes.get(str2);
            if (!attribute.getValue().isEmpty()) {
                sb.append("=\"");
                sb.append(attribute.getValue().replace("\"", "\\\""));
                sb.append("\"");
            }
            str = " ";
        }
        return AbstractC0541b.m773o("MutableAttributes{", sb.toString(), "}");
    }

    public MutableAttributes(Attributes attributes) {
        super(attributes);
    }

    public Attribute addValue(CharSequence charSequence, CharSequence charSequence2) {
        Attribute value;
        String strValueOf = String.valueOf(charSequence);
        LinkedHashMap<String, Attribute> linkedHashMap = this.attributes;
        if (linkedHashMap == null) {
            value = AttributeImpl.m13363of(charSequence, charSequence2);
        } else {
            Attribute attribute = linkedHashMap.get(strValueOf);
            value = attribute != null ? attribute.setValue(charSequence2) : AttributeImpl.m13363of(strValueOf, charSequence2);
        }
        getAttributes().put(strValueOf, value);
        return value;
    }

    public Attribute remove(CharSequence charSequence) {
        if (this.attributes == null || charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String strValueOf = String.valueOf(charSequence);
        Attribute attribute = this.attributes.get(strValueOf);
        this.attributes.remove(strValueOf);
        return attribute;
    }

    public Attribute removeValue(CharSequence charSequence, CharSequence charSequence2) {
        if (this.attributes == null || charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String strValueOf = String.valueOf(charSequence);
        Attribute attributeRemoveValue = this.attributes.get(strValueOf).removeValue(charSequence2);
        getAttributes().put(strValueOf, attributeRemoveValue);
        return attributeRemoveValue;
    }

    public Attribute replaceValue(CharSequence charSequence, CharSequence charSequence2) {
        Attribute attribute;
        String strValueOf = String.valueOf(charSequence);
        LinkedHashMap<String, Attribute> linkedHashMap = this.attributes;
        Attribute attributeM13363of = (linkedHashMap == null || (attribute = linkedHashMap.get(strValueOf)) == null) ? AttributeImpl.m13363of(strValueOf, charSequence2) : attribute.replaceValue(charSequence2);
        getAttributes().put(strValueOf, attributeM13363of);
        return attributeM13363of;
    }
}

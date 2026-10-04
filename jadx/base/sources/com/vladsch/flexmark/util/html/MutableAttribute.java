package com.vladsch.flexmark.util.html;

import com.vladsch.flexmark.util.misc.Mutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MutableAttribute extends Attribute, Mutable<MutableAttribute, Attribute> {
    @Override // com.vladsch.flexmark.util.html.Attribute
    boolean containsValue(CharSequence charSequence);

    MutableAttribute copy();

    @Override // com.vladsch.flexmark.util.html.Attribute
    MutableAttribute removeValue(CharSequence charSequence);

    @Override // com.vladsch.flexmark.util.html.Attribute
    MutableAttribute replaceValue(CharSequence charSequence);

    @Override // com.vladsch.flexmark.util.html.Attribute
    MutableAttribute setValue(CharSequence charSequence);
}

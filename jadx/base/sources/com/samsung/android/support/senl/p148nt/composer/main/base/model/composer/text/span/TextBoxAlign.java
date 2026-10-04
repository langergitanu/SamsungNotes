package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span;

import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextBoxAlign extends Alignment {
    private static final String TEXT_BOX_ALIGN_PREF_KEY = "Text_box_default_align";

    public TextBoxAlign() {
        super("Composer", "Text_box_default_align");
    }

    public static int getStoredValue() {
        return Alignment.getStoredValue("Composer", "Text_box_default_align");
    }

    public TextBoxAlign(int i) {
        super("Composer", "Text_box_default_align", i);
    }
}

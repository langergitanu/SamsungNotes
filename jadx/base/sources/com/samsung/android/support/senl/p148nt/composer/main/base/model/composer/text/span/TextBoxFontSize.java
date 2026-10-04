package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextBoxFontSize extends FontSize {
    private static final String TAG = Logger.createTag("TextBoxFontSize");
    private static final String TEXT_BOX_FONT_SIZE_PREF_KEY = "Text_box_default_font_size";

    public TextBoxFontSize(int i) {
        super("Composer", "Text_box_default_font_size", i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.FontSize
    public void applySPenSpan(int[] iArr, SpenObjectShape spenObjectShape) {
        Logger.m11003i(TAG, "applySPenSpan fontSize " + getValue());
        super.applySPenSpan(iArr, spenObjectShape);
    }

    public TextBoxFontSize(int i, int i2) {
        super("Composer", "Text_box_default_font_size", i, i2);
    }
}

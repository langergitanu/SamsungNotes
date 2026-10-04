package com.vladsch.flexmark.util.html.p169ui;

import androidx.compose.runtime.AbstractC1974b;
import java.awt.Font;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FontStyler extends HtmlStylerBase<Font> {
    @Override // com.vladsch.flexmark.util.html.p169ui.HtmlStylerBase, com.vladsch.flexmark.util.html.p169ui.HtmlStyler
    public String getStyle(Font font) {
        if (font == null) {
            return "";
        }
        Locale locale = Locale.US;
        return AbstractC1974b.m1319l("font-family:", font.getSize(), font.getFamily(), ";font-size:", "pt;font-style:normal;font-weight:normal");
    }
}

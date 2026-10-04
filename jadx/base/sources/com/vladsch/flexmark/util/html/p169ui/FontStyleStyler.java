package com.vladsch.flexmark.util.html.p169ui;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FontStyleStyler extends HtmlStylerBase<FontStyle> {
    @Override // com.vladsch.flexmark.util.html.p169ui.HtmlStylerBase, com.vladsch.flexmark.util.html.p169ui.HtmlStyler
    public String getStyle(FontStyle fontStyle) {
        if (fontStyle == null) {
            return "";
        }
        return (fontStyle.isItalic() ? "font-style:italic;" : "font-style:normal;").concat(fontStyle.isBold() ? "font-weight:bold" : "font-weight:normal");
    }
}

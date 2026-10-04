package com.vladsch.flexmark.util.html.p169ui;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class HtmlStylerBase<T> implements HtmlStyler<T> {
    @Override // com.vladsch.flexmark.util.html.p169ui.HtmlStyler
    public abstract String getStyle(T t);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vladsch.flexmark.util.html.p169ui.HtmlStyler
    public T getStyleable(Object obj) {
        return obj;
    }
}

package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.format.MarkdownParagraph;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.format.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11856b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ MarkdownParagraph.LeftAlignedWrapping f8374a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f8374a.addChars((CharSequence) obj);
    }
}

package com.vladsch.flexmark.html;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.renderer.LinkType;
import java.util.function.Function;

/* JADX INFO: renamed from: com.vladsch.flexmark.html.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11821a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8348a;

    public /* synthetic */ C11821a(int i) {
        this.f8348a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f8348a) {
            case 0:
                return HtmlRenderer.lambda$new$0((DelegatingNodeRendererFactoryWrapper) obj);
            default:
                return HtmlRenderer.MainNodeRenderer.lambda$resolveLink$0((LinkType) obj);
        }
    }
}

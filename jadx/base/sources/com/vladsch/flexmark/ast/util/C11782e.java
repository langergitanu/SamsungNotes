package com.vladsch.flexmark.ast.util;

import com.vladsch.flexmark.ast.util.LinkResolvingHandler;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.html.renderer.ResolvedLink;
import com.vladsch.flexmark.util.ast.Node;
import io.opentelemetry.context.Context;
import java.util.function.BiFunction;

/* JADX INFO: renamed from: com.vladsch.flexmark.ast.util.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11782e implements BiFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8285a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8286b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8287c;

    public /* synthetic */ C11782e(Object obj, Object obj2, int i) {
        this.f8285a = i;
        this.f8286b = obj;
        this.f8287c = obj2;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f8285a) {
            case 0:
                return LinkResolverAdapter.lambda$resolveLink$0((LinkResolverBasicContext) this.f8286b, (ResolvedLink) this.f8287c, (Node) obj, (LinkResolvingHandler.LinkResolvingVisitor) obj2);
            default:
                return ((Context) this.f8286b).lambda$wrapFunction$5((BiFunction) this.f8287c, obj, obj2);
        }
    }
}

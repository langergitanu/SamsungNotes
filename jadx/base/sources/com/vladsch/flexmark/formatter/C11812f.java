package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.renderer.LinkType;
import java.util.function.Function;

/* JADX INFO: renamed from: com.vladsch.flexmark.formatter.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11812f implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8339a;

    public /* synthetic */ C11812f(int i) {
        this.f8339a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f8339a) {
            case 0:
                return Formatter.MainNodeFormatter.lambda$new$0((Class) obj);
            case 1:
                return Formatter.MainNodeFormatter.lambda$resolveLink$1((LinkType) obj);
            default:
                return FormatterUtils.lambda$static$0((CharSequence) obj);
        }
    }
}

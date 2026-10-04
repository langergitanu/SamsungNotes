package androidx.core.content;

import androidx.core.util.Consumer;

/* JADX INFO: renamed from: androidx.core.content.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2356a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1265a;

    public /* synthetic */ C2356a(int i) {
        this.f1265a = i;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        String str = (String) obj;
        switch (this.f1265a) {
            case 0:
                IntentSanitizer.lambda$sanitizeByThrowing$1(str);
                break;
            default:
                IntentSanitizer.lambda$sanitizeByFiltering$0(str);
                break;
        }
    }
}

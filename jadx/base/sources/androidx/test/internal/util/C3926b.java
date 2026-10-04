package androidx.test.internal.util;

import androidx.test.internal.util.LogUtil;

/* JADX INFO: renamed from: androidx.test.internal.util.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C3926b implements LogUtil.Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1700a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1701b;

    public /* synthetic */ C3926b(String str, int i) {
        this.f1700a = i;
        this.f1701b = str;
    }

    @Override // androidx.test.internal.util.LogUtil.Supplier
    public final String get() {
        switch (this.f1700a) {
            case 0:
                return LogUtil.lambda$logDebugWithProcess$1(this.f1701b);
            default:
                return LogUtil.lambda$logDebug$0(this.f1701b);
        }
    }
}

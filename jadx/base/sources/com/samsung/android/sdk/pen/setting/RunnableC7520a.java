package com.samsung.android.sdk.pen.setting;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7520a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5001a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenBrushLayout f5002b;

    public /* synthetic */ RunnableC7520a(SpenBrushLayout spenBrushLayout, int i) {
        this.f5001a = i;
        this.f5002b = spenBrushLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5001a) {
            case 0:
                SpenBrushLayout.onSizeChanged$lambda$0(this.f5002b);
                break;
            case 1:
                SpenBrushLayout$setChildView$1$1.onColorPositionChanged$lambda$2(this.f5002b);
                break;
            default:
                SpenBrushLayout$setChildView$1$1.onPenPositionChanged$lambda$0(this.f5002b);
                break;
        }
    }
}

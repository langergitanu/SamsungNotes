package p180f2;

import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScroller;

/* JADX INFO: renamed from: f2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC11989a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8603a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenNoteZoomScroller f8604b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f8605c;

    public /* synthetic */ RunnableC11989a(SpenNoteZoomScroller spenNoteZoomScroller, boolean z, int i) {
        this.f8603a = i;
        this.f8604b = spenNoteZoomScroller;
        this.f8605c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8603a) {
            case 0:
                SpenNoteZoomScroller.onScrollLockChanged$lambda$1(this.f8604b, this.f8605c);
                break;
            default:
                SpenNoteZoomScroller.onZoomLockChanged$lambda$0(this.f8604b, this.f8605c);
                break;
        }
    }
}

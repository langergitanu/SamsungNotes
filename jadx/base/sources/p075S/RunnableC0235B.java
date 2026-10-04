package p075S;

import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;

/* JADX INFO: renamed from: S.B */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0235B implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SpaceResult f682a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0236C f683b;

    public RunnableC0235B(C0236C c0236c, SpaceResult spaceResult) {
        this.f683b = c0236c;
        this.f682a = spaceResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f683b.f684a.f685a.onResult(this.f682a);
    }
}

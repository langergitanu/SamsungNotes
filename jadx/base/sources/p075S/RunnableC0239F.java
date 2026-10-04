package p075S;

import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;

/* JADX INFO: renamed from: S.F */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0239F implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ BooleanResult f689a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0240G f690b;

    public RunnableC0239F(C0240G c0240g, BooleanResult booleanResult) {
        this.f690b = c0240g;
        this.f689a = booleanResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f690b.f691a.f692a.onResult(this.f689a);
    }
}

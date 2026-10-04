package p048L;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAccountLoginListener;
import p035H2.RunnableC0116a;

/* JADX INFO: renamed from: L.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0164b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f503a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f504b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f505c;

    public /* synthetic */ RunnableC0164b(int i, Object obj, boolean z) {
        this.f503a = i;
        this.f505c = obj;
        this.f504b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f503a) {
            case 0:
                Debugger.m8615i("ServerConsentBase", "executeRequest() : start request");
                AbstractC0165c abstractC0165c = (AbstractC0165c) this.f505c;
                abstractC0165c.f501a = abstractC0165c.f502b.submit(new RunnableC0116a(1, this, this.f504b));
                break;
            default:
                StringBuilder sb = new StringBuilder("[SA] notifyResultToListeners() : ");
                IAccountLoginListener iAccountLoginListener = (IAccountLoginListener) this.f505c;
                sb.append(iAccountLoginListener);
                Debugger.m8615i("SamsungAccountLogInController", sb.toString());
                iAccountLoginListener.onLoginInfoReceived(this.f504b);
                break;
        }
    }
}

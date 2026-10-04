package p207n1;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: n1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC13538e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9575a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f9576b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f9577c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ IAuthInfoReqListener f9578d;

    public RunnableC13538e(IAuthInfoReqListener iAuthInfoReqListener, String str, String str2) {
        this.f9578d = iAuthInfoReqListener;
        this.f9576b = str;
        this.f9577c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9575a) {
            case 0:
                StringBuilder sb = new StringBuilder("[SA] notifyResultToListeners() : ");
                IAuthInfoReqListener iAuthInfoReqListener = this.f9578d;
                sb.append(iAuthInfoReqListener);
                Debugger.m8615i("SamsungAccountAuthController", sb.toString());
                try {
                    iAuthInfoReqListener.onReceived(this.f9576b, this.f9577c);
                } catch (Exception e) {
                    AbstractC0000a.m22s("[SA] notifyResultToListeners : Exception = ", e, "SamsungAccountAuthController");
                    return;
                }
                break;
            default:
                StringBuilder sb2 = new StringBuilder("[SA] notifyErrorToListeners() : errCode = ");
                String str = this.f9576b;
                sb2.append(str);
                sb2.append(", errMsg = ");
                String str2 = this.f9577c;
                sb2.append(str2);
                Debugger.m8609e("SamsungAccountAuthController", sb2.toString());
                try {
                    this.f9578d.onError(str, str2);
                } catch (Exception e2) {
                    AbstractC0000a.m22s("[SA] notifyErrorToListeners : Exception = ", e2, "SamsungAccountAuthController");
                }
                break;
        }
    }

    public RunnableC13538e(String str, String str2, IAuthInfoReqListener iAuthInfoReqListener) {
        this.f9576b = str;
        this.f9577c = str2;
        this.f9578d = iAuthInfoReqListener;
    }
}

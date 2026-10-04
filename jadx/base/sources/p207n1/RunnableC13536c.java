package p207n1;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener;

/* JADX INFO: renamed from: n1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC13536c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9563a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f9564b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f9565c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f9566d;

    public /* synthetic */ RunnableC13536c(Object obj, String str, int i, String str2) {
        this.f9563a = i;
        this.f9564b = str;
        this.f9565c = str2;
        this.f9566d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9563a) {
            case 0:
                StringBuilder sb = new StringBuilder("[SA] notifyErrorToListeners() : , errCode = ");
                String str = this.f9564b;
                sb.append(str);
                sb.append(", errMsg = ");
                String str2 = this.f9565c;
                sb.append(str2);
                Debugger.m8609e("CountryPolicyController", sb.toString());
                ((CountryPolicyListener) this.f9566d).onError(str, str2);
                break;
            default:
                StringBuilder sb2 = new StringBuilder("[SA] notifyErrorToListeners() : , errCode = ");
                String str3 = this.f9564b;
                sb2.append(str3);
                sb2.append(", errMsg = ");
                String str4 = this.f9565c;
                sb2.append(str4);
                Debugger.m8615i("RequestRequiredConsentController", sb2.toString());
                ((ConsentDataListener) this.f9566d).onError(str3, str4);
                break;
        }
    }
}

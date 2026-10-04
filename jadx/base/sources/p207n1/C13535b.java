package p207n1;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyItem;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener;
import java.util.ArrayList;
import java.util.Iterator;
import p012C1.RunnableC0045a;

/* JADX INFO: renamed from: n1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13535b implements CountryPolicyListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9561a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9562b;

    public /* synthetic */ C13535b(Object obj, int i) {
        this.f9561a = i;
        this.f9562b = obj;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener
    public final void onError(String str, String str2) {
        switch (this.f9561a) {
            case 0:
                C6742k c6742k = (C6742k) this.f9562b;
                synchronized (((ArrayList) c6742k.f4110b)) {
                    try {
                        if (((ArrayList) c6742k.f4110b).size() > 0) {
                            Iterator it = ((ArrayList) c6742k.f4110b).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC13536c((CountryPolicyListener) it.next(), str, 0, str2));
                            }
                        }
                        ((ArrayList) c6742k.f4110b).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            default:
                C6904g c6904g = (C6904g) this.f9562b;
                c6904g.f4478a = false;
                C13535b c13535b = (C13535b) c6904g.f4479b;
                if (c13535b != null) {
                    c13535b.onError(str, str2);
                    c6904g.f4479b = null;
                    return;
                }
                return;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener
    public final void onReceived(CountryPolicyItem countryPolicyItem) {
        switch (this.f9561a) {
            case 0:
                C6742k c6742k = (C6742k) this.f9562b;
                synchronized (((ArrayList) c6742k.f4110b)) {
                    try {
                        if (((ArrayList) c6742k.f4110b).size() > 0) {
                            Iterator it = ((ArrayList) c6742k.f4110b).iterator();
                            while (it.hasNext()) {
                                new Handler(Looper.getMainLooper()).post(new RunnableC0045a(10, (CountryPolicyListener) it.next(), false, countryPolicyItem));
                            }
                        }
                        ((ArrayList) c6742k.f4110b).clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            default:
                C6904g c6904g = (C6904g) this.f9562b;
                c6904g.f4478a = false;
                C13535b c13535b = (C13535b) c6904g.f4479b;
                if (c13535b != null) {
                    c13535b.onReceived(countryPolicyItem);
                    c6904g.f4479b = null;
                    return;
                }
                return;
        }
    }
}

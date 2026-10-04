package p073R;

import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: renamed from: R.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0225d implements Runnable {

    /* JADX INFO: renamed from: a */
    public CoeditResolverContract.CoeditCallback f665a;

    /* JADX INFO: renamed from: b */
    public final String f666b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0226e f667c;

    public RunnableC0225d(C0226e c0226e, String str, CoeditResolverContract.CoeditCallback coeditCallback) {
        this.f667c = c0226e;
        this.f665a = coeditCallback;
        this.f666b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strM266j;
        Logger.m8697d("GcsComposerResolver", "UpdateWriterName#run# ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0226e c0226e = this.f667c;
        if (c0226e.f668a.m265b()) {
            try {
                strM266j = c0226e.f668a.m266j(this.f666b);
            } catch (Exception e) {
                e = e;
                strM266j = null;
            }
            try {
                Logger.m8697d("GcsComposerResolver", "UpdateWriterName#run# done: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Exception e2) {
                e = e2;
                Logger.m8698e("GcsComposerResolver", "updateWriterName#run# " + e.getMessage());
            }
            CoeditResolverContract.CoeditCallback coeditCallback = this.f665a;
            if (coeditCallback != null) {
                coeditCallback.onResult(strM266j);
                this.f665a = null;
            }
        }
    }
}

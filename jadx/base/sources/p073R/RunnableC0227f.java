package p073R;

import com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: renamed from: R.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0227f implements Runnable {

    /* JADX INFO: renamed from: a */
    public GcsResolverContract.GcsCallback f670a;

    /* JADX INFO: renamed from: b */
    public final String f671b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0228g f672c;

    public RunnableC0227f(C0228g c0228g, String str, GcsResolverContract.GcsCallback gcsCallback) {
        this.f672c = c0228g;
        this.f670a = gcsCallback;
        this.f671b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strM4858p;
        Logger.m8697d("GcsComposerResolver", "UpdateWriterName#run# ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0228g c0228g = this.f672c;
        if (c0228g.f673a.m4854k()) {
            try {
                strM4858p = c0228g.f673a.m4858p(this.f671b);
            } catch (Exception e) {
                e = e;
                strM4858p = null;
            }
            try {
                Logger.m8697d("GcsComposerResolver", "UpdateWriterName#run# done: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Exception e2) {
                e = e2;
                Logger.m8698e("GcsComposerResolver", "updateWriterName#run# " + e.getMessage());
            }
            GcsResolverContract.GcsCallback gcsCallback = this.f670a;
            if (gcsCallback != null) {
                gcsCallback.onResult(strM4858p);
                this.f670a = null;
            }
        }
    }
}

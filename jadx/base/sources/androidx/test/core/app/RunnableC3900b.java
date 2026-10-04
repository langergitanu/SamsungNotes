package androidx.test.core.app;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;

/* JADX INFO: renamed from: androidx.test.core.app.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3900b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1690a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Activity f1691b;

    public /* synthetic */ RunnableC3900b(Activity activity, int i) {
        this.f1690a = i;
        this.f1691b = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1690a) {
            case 0:
                this.f1691b.recreate();
                break;
            case 1:
                this.f1691b.finish();
                break;
            case 2:
                this.f1691b.finish();
                break;
            case 3:
                this.f1691b.finish();
                break;
            case 4:
                this.f1691b.finish();
                break;
            case 5:
                this.f1691b.finish();
                break;
            default:
                PermissionHelper.closeActivity$lambda$0(this.f1691b);
                break;
        }
    }
}

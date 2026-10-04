package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;

/* JADX INFO: renamed from: androidx.profileinstaller.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChoreographerFrameCallbackC3727b implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1644a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1645b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1646c;

    public /* synthetic */ ChoreographerFrameCallbackC3727b(Object obj, Object obj2, int i) {
        this.f1644a = i;
        this.f1645b = obj;
        this.f1646c = obj2;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        switch (this.f1644a) {
            case 0:
                ((ProfileInstallerInitializer) this.f1645b).lambda$create$0((Context) this.f1646c, j);
                break;
            default:
                AbsExecuteBinding.execute$lambda$0((AbsExecuteBinding) this.f1645b, this.f1646c, j);
                break;
        }
    }
}

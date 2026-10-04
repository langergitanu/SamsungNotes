package p031G2;

import android.window.OnBackInvokedCallback;
import com.google.android.material.motion.MaterialBackHandler;
import com.samsung.android.sdk.pen.widget.SpenTextManager;
import com.samsung.android.support.senl.addons.base.AbsToolActivity;
import com.samsung.android.support.senl.docscan.DocumentScanActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;

/* JADX INFO: renamed from: G2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C0109b implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f356a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f357b;

    public /* synthetic */ C0109b(Object obj, int i) {
        this.f356a = i;
        this.f357b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f356a) {
            case 0:
                ((DocumentScanActivity) this.f357b).onBackPressed();
                break;
            case 1:
                ((MaterialBackHandler) this.f357b).handleBackInvoked();
                break;
            case 2:
                SpenTextManager._init_$lambda$4((SpenTextManager) this.f357b);
                break;
            case 3:
                AbsToolActivity.onCreate$lambda$0((AbsToolActivity) this.f357b);
                break;
            default:
                ((BaseComposerFragment) this.f357b).lambda$registerOnBackInvokedCallback$2();
                break;
        }
    }
}

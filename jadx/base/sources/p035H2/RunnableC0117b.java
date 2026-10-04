package p035H2;

import com.google.android.material.chip.SeslExpandableContainer;
import com.samsung.android.mcf.continuity.impl.ContinuityReceiveFile;
import com.samsung.android.support.senl.docscan.detect.view.CameraMenu;
import com.samsung.android.support.senl.docscan.rectify.RectifyListFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemTouchHelperCallback;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.AIGuidingLightEffect;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: H2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC0117b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f370a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f371b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f372c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f373d;

    public /* synthetic */ RunnableC0117b(Object obj, int i, int i2, int i4) {
        this.f370a = i4;
        this.f373d = obj;
        this.f371b = i;
        this.f372c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f370a) {
            case 0:
                CameraMenu.showFlashOptions$lambda$1((CameraMenu) this.f373d, this.f371b, this.f372c);
                break;
            case 1:
                ((ContinuityReceiveFile) this.f373d).lambda$sendFileTransferResponse$0(this.f371b, this.f372c);
                break;
            case 2:
                ((SeslExpandableContainer) this.f373d).lambda$fullScrollToRight$1(this.f371b, this.f372c);
                break;
            case 3:
                ((RectifyListFragment) this.f373d).updateRecyclerViewForThumbnail(this.f371b, this.f372c);
                break;
            case 4:
                CustomToolbarItemTouchHelperCallback.onMove$lambda$2((CustomToolbarItemTouchHelperCallback) this.f373d, this.f371b, this.f372c);
                break;
            case 5:
                ((ComposerViewPresenter) this.f373d).lambda$showProgress$6(this.f371b, this.f372c);
                break;
            default:
                AIGuidingLightEffect.applyGuidingLightEffectBackground$lambda$2$lambda$1((Ref.ObjectRef) this.f373d, this.f371b, this.f372c);
                break;
        }
    }
}

package p027F3;

import android.app.Activity;
import android.content.ComponentName;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.profileinstaller.DeviceProfileWriter;
import androidx.work.multiprocess.IWorkManagerImplCallback;
import androidx.work.multiprocess.ListenableWorkerImpl;
import androidx.work.multiprocess.RemoteWorkerWrapper;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.app.sdk.deepsky.feedback.FeedbackRequest;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNearbyMyDeviceWrapper;
import com.samsung.android.sdk.pen.engine.SpenPenSound;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingDimView;
import com.samsung.android.support.senl.p148nt.app.labs.FolderTest;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RecyclerViewHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslatedPDFSaveTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;

/* JADX INFO: renamed from: F3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0101a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f329a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f330b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f331c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f332d;

    public /* synthetic */ RunnableC0101a(int i, Activity activity, DialogUtils.ProgressDialog progressDialog) {
        this.f329a = 9;
        this.f330b = i;
        this.f331c = activity;
        this.f332d = progressDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f329a) {
            case 0:
                super/*com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuEditMode*/.onOptionsItemSelected((OptionMenuParam) this.f332d, this.f330b);
                break;
            case 1:
                FeedbackRequest.sendRawData$lambda$1((FeedbackRequest) this.f331c, this.f330b, (ComponentName) this.f332d);
                break;
            case 2:
                ((DeviceProfileWriter) this.f331c).lambda$result$0(this.f330b, this.f332d);
                break;
            case 3:
                ListenableWorkerImpl.lambda$interrupt$0((RemoteWorkerWrapper) this.f331c, this.f330b, (IWorkManagerImplCallback) this.f332d);
                break;
            case 4:
                ((ContinuityDiscoveryManager.DiscoveryListener) this.f331c).onDiscovered(this.f330b, (ContinuityNearbyMyDevice) this.f332d);
                break;
            case 5:
                ((ContinuitySession.C71952) this.f331c).lambda$onPeerStatusChanged$0(this.f330b, (ContinuityNearbyMyDeviceWrapper) this.f332d);
                break;
            case 6:
                WidgetCreatorRecycleViewActivity.onCreate$lambda$3((WidgetCreatorRecycleViewActivity) this.f331c, this.f330b, (RoundCornerOverlayView) this.f332d);
                break;
            case 7:
                SpenPenSound.onTouch$lambda$6((SpenPenSound) this.f331c, (MotionEvent) this.f332d, this.f330b);
                break;
            case 8:
                ((InAppSettingDimView) this.f331c).setToolbarLocation(this.f330b, (ViewGroup) this.f332d);
                break;
            case 9:
                FolderTest.lambda$createData$0(this.f330b, (Activity) this.f331c, (DialogUtils.ProgressDialog) this.f332d);
                break;
            case 10:
                ((RecyclerViewHelper) this.f331c).lambda$autoScroll$0((AppBarLayout) this.f332d, this.f330b);
                break;
            case 11:
                ContentPickerUtils.startAttachActivityForResult$lambda$0((Fragment) this.f331c, this.f330b, (String[]) this.f332d);
                break;
            case 12:
                ((ComposerViewPresenter) this.f331c).lambda$smoothScrollAndScaleToFitPage$5(this.f330b, (Runnable) this.f332d);
                break;
            default:
                ((TranslatedPDFSaveTask) this.f331c).lambda$notifyFailure$1(this.f330b, (String) this.f332d);
                break;
        }
    }

    public /* synthetic */ RunnableC0101a(Object obj, int i, Object obj2, int i2) {
        this.f329a = i2;
        this.f331c = obj;
        this.f330b = i;
        this.f332d = obj2;
    }

    public /* synthetic */ RunnableC0101a(Object obj, Object obj2, int i, int i2) {
        this.f329a = i2;
        this.f331c = obj;
        this.f332d = obj2;
        this.f330b = i;
    }
}

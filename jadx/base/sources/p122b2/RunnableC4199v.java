package p122b2;

import android.app.Activity;
import android.app.job.JobParameters;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorSettingView;
import com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl;
import com.samsung.android.mcf.continuity.impl.ContinuitySimpleMessageManagerImpl;
import com.samsung.android.sdk.pen.engine.androidgraphicslowlatency.SPenRendererAdapterAGLL;
import com.samsung.android.sdk.pen.recogengine.SpenHwrResourceManager;
import com.samsung.android.sdk.pen.setting.SpenBrushMoveControl;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout$mModeChangeClickListener$1;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.MenuHideViewModel;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import com.samsung.android.support.senl.docscan.detect.CameraFragment$mPicImageAvailableListener$1;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.inapp.view.InAppActivityAttributes;
import com.samsung.android.support.senl.p148nt.app.lock.strategy.LockStrategy;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.NotesFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DragAndDropHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RecyclerViewHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: b2.v */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4199v implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1821a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1822b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1823c;

    public /* synthetic */ RunnableC4199v(Object obj, Object obj2, int i) {
        this.f1821a = i;
        this.f1822b = obj;
        this.f1823c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1821a) {
            case 0:
                ((ContinuitySessionManagerImpl) this.f1822b).lambda$registerPeerConnectionRequestListener$1((ContinuitySessionManager.PeerConnectionRequestListener) this.f1823c);
                break;
            case 1:
                ((ContinuitySimpleMessageManagerImpl) this.f1822b).lambda$registerMessageListener$0((ContinuityMessageManager.MessageListener) this.f1823c);
                break;
            case 2:
                ((JobInfoSchedulerService) this.f1822b).lambda$onStartJob$0((JobParameters) this.f1823c);
                break;
            case 3:
                ((TabLayout) this.f1822b).lambda$addTabView$0((TabLayout.TabView) this.f1823c);
                break;
            case 4:
                ((RemovalListener) this.f1822b).onRemoval((RemovalNotification) this.f1823c);
                break;
            case 5:
                WidgetListGlanceSettingView.C69451.clearView$lambda$1((WidgetListGlanceSettingView) this.f1822b, (WidgetListGlanceSettingView.C69451) this.f1823c);
                break;
            case 6:
                WidgetCreatorSettingView.initShortcutComponent$lambda$3((LinearLayout) this.f1822b, (RoundCornerOverlayView) this.f1823c);
                break;
            case 7:
                WidgetListSettingView.C70071.clearView$lambda$1((WidgetListSettingView) this.f1822b, (WidgetListSettingView.C70071) this.f1823c);
                break;
            case 8:
                SPenRendererAdapterAGLL.callOnProcess$lambda$2((SPenRendererAdapterAGLL) this.f1822b, (CountDownLatch) this.f1823c);
                break;
            case 9:
                SpenHwrResourceManager.downloadLanguage$lambda$2((String) this.f1822b, (SpenHwrResourceManager) this.f1823c);
                break;
            case 10:
                SpenBrushMoveControl.endAction$lambda$3((SpenBrushMoveControl) this.f1822b, (View) this.f1823c);
                break;
            case 11:
                SpenBrushPenTypeLayout$mModeChangeClickListener$1.onClick$lambda$1$lambda$0((SpenBrushPenTypeLayout.OnModeChangeListener) this.f1822b, (SpenBrushPenTypeLayout) this.f1823c);
                break;
            case 12:
                SpenQTPenListAdapter.ViewHolder.startAnimationShow$lambda$2((SpenQTPenListAdapter.ViewHolder) this.f1822b, (SpenQTPenListAdapter) this.f1823c);
                break;
            case 13:
                MenuHideViewModel.perform$lambda$0((MenuHideViewModel) this.f1822b, (LayoutChangeEvent) this.f1823c);
                break;
            case 14:
                CameraFragment$mPicImageAvailableListener$1.onImageAvailable$lambda$0((CameraFragment) this.f1822b, (DocScanData) this.f1823c);
                break;
            case 15:
                RectifyOverlayView.dismissHandlerPreview$lambda$5((RectifyOverlayView) this.f1822b, (Runnable) this.f1823c);
                break;
            case 16:
                ((View) this.f1822b).setLayoutParams((ViewGroup.MarginLayoutParams) this.f1823c);
                break;
            case 17:
                WidgetInsetUtils.applyWindowInsetsForSetting$lambda$5((ViewGroup) this.f1822b, (FloatingBottomLayout) this.f1823c);
                break;
            case 18:
                ((InAppActivityAttributes) this.f1822b).unbindRemoteSPenBindService((Activity) this.f1823c);
                break;
            case 19:
                LockStrategy.executeLockTask$lambda$0((LockStrategy) this.f1822b, (String[]) this.f1823c);
                break;
            case 20:
                ((AlertDialog) this.f1822b).setMessage((String) this.f1823c);
                break;
            case 21:
                ((AbsPasswordView) this.f1822b).lambda$showSoftInput$0((InputMethodManager) this.f1823c);
                break;
            case 22:
                ((MainHandoffManager) this.f1822b).releaseHandoffActionInternal((Activity) this.f1823c);
                break;
            case 23:
                BottomMenuController.addBlurForTabLayout$lambda$1$lambda$0((FloatingBottomLayout) this.f1822b, (TabLayout) this.f1823c);
                break;
            case 24:
                BottomMenuController.playInOutAnimation$lambda$3$lambda$2((FloatingBottomLayout) this.f1822b, (BottomMenuController) this.f1823c);
                break;
            case 25:
                ((NotesFragment) this.f1822b).lambda$requestVerifyForShare$2((ArrayList) this.f1823c);
                break;
            case 26:
                ((AdapterManager) this.f1822b).lambda$hideSearchFilter$6((Runnable) this.f1823c);
                break;
            case 27:
                ((DragAndDropHelper) this.f1822b).lambda$setDragListener$4((String) this.f1823c);
                break;
            case 28:
                ((RecyclerViewHelper) this.f1822b).lambda$collapseConcealSubFolderAnimation$1((Runnable) this.f1823c);
                break;
            default:
                ((LongPressRangeSelectionMotion) this.f1822b).lambda$new$0((LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener) this.f1823c);
                break;
        }
    }
}

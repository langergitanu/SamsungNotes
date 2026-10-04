package p017D1;

import android.app.ActivityOptions;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.arch.core.util.Function;
import androidx.core.util.SeslFadingEdgeHelperImpl;
import androidx.core.util.SeslFadingEdgeLegacyHelperImpl;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.SeslGoToTopController;
import androidx.core.widget.SeslGoToTopImageView;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.microsoft.identity.common.internal.broker.InstallCertActivityLauncher;
import com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.tools.CreateNoteActivity;
import com.samsung.android.app.notes.tools.FoldedPopupUtil;
import com.samsung.android.app.notes.widget.configure.AbsWidgetConfigureActivity;
import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.sdk.handwriting.resources.impl.HWRLanguagePack;
import com.samsung.android.sdk.handwriting.resources.impl.listener.HWRDeleteListener;
import com.samsung.android.sdk.handwriting.resources.interfaces.LanguagePackInterface;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.core.ActionParamExtraction;
import com.samsung.android.sdk.scs.p142ai.core.GenericInference;
import com.samsung.android.sdk.scs.p142ai.core.IntentQueryGeneration;
import com.samsung.android.sdk.scs.p142ai.language.Corrector;
import com.samsung.android.sdk.scs.p142ai.language.EmojiAugmentor;
import com.samsung.android.sdk.scs.p142ai.language.Extractor;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.PwFragment;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesPageSearchInfoRepository;
import java.util.List;
import java.util.function.Supplier;
import p123b3.C4201a;
import p123b3.C4202b;

/* JADX INFO: renamed from: D1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0061b implements InterfaceC6855f, ICustomToolbar.ToolbarHeightChangedListener, ActivityResultCallback, OnApplyWindowInsetsListener, SeslGoToTopController.OnGoToTopClickListener, SeslGoToTopImageView.WindowLocationProvider, OnCompleteListener, Function, SynchronizationGuard.CriticalSection, AccessibilityViewCommand, CanvasCompat.CanvasOperation, FoldedPopupUtil.IFoldedActivityOptionsCallback, HWRDeleteListener, InputConnectionCompat.OnCommitContentListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f242a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f243b;

    public /* synthetic */ C0061b(Object obj, int i) {
        this.f242a = i;
        this.f243b = obj;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public Object mo22196apply(Object obj) {
        return ((NotesPageSearchInfoRepository) this.f243b).lambda$deleteByUuid$0((List) obj);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.f242a) {
            case 11:
                return Integer.valueOf(((EventStore) this.f243b).cleanUp());
            case 12:
                return ((ClientHealthMetricsStore) this.f243b).loadClientMetrics();
            case 13:
                return ((Uploader) this.f243b).lambda$logAndUpdateState$6();
            default:
                return ((WorkInitializer) this.f243b).lambda$ensureContextsScheduled$0();
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.view.toolbar.ICustomToolbar.ToolbarHeightChangedListener
    public int getDefaultToolbarHeight() {
        return ((PwFragment) this.f243b).lambda$initAppbarContents$0();
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f
    /* JADX INFO: renamed from: h */
    public void mo142h() {
        switch (this.f242a) {
            case 0:
                C0062c c0062c = (C0062c) this.f243b;
                c0062c.f238b.m219f(c0062c.f239c, "SyncSDocxCreateLocalNote");
                break;
            default:
                C0063d c0063d = (C0063d) this.f243b;
                c0063d.f238b.m219f(c0063d.f239c, "SyncSDocxUpdateServerNote");
                break;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f242a) {
            case 3:
                AbsWidgetConfigureActivity.mActivityResultLauncher$lambda$0((AbsWidgetConfigureActivity) this.f243b, (ActivityResult) obj);
                break;
            case 18:
                ((InstallCertActivityLauncher) this.f243b).lambda$new$0((ActivityResult) obj);
                break;
            default:
                ((WebViewAuthorizationFragment) this.f243b).lambda$new$0((Boolean) obj);
                break;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.f242a) {
            case 4:
                return ((SeslFadingEdgeHelperImpl) this.f243b).lambda$setOnApplyWindowInsetsListener$0(view, windowInsetsCompat);
            case 5:
                return ((SeslFadingEdgeLegacyHelperImpl) this.f243b).lambda$setOnApplyWindowInsetsListener$0(view, windowInsetsCompat);
            default:
                return WidgetCreatorRecycleViewActivity.disableSystemBarInsets$lambda$5((Supplier) this.f243b, view, windowInsetsCompat);
        }
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return SpenInputManager.onCreateInputConnection$lambda$36((SpenInputManager) this.f243b, inputContentInfoCompat, i, bundle);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f242a) {
            case 8:
                SCSOperator.identifyLanguageOnThread$lambda$3((C4201a) this.f243b, task);
                break;
            case 9:
                SCSOperator.initTranslateConfig$lambda$5((C4202b) this.f243b, task);
                break;
            case 24:
                ((ActionParamExtraction) this.f243b).lambda$release$0(task);
                break;
            case 25:
                ((GenericInference) this.f243b).lambda$release$0(task);
                break;
            case 26:
                ((IntentQueryGeneration) this.f243b).lambda$release$0(task);
                break;
            case 27:
                ((Corrector) this.f243b).lambda$release$2(task);
                break;
            case 28:
                ((EmojiAugmentor) this.f243b).lambda$release$2(task);
                break;
            default:
                ((Extractor) this.f243b).lambda$release$4(task);
                break;
        }
    }

    @Override // com.samsung.android.app.notes.tools.FoldedPopupUtil.IFoldedActivityOptionsCallback
    public void onCompleted(ActivityOptions activityOptions) {
        CreateNoteActivity.checkHorizontalFolded$lambda$0((CreateNoteActivity) this.f243b, activityOptions);
    }

    @Override // androidx.core.widget.SeslGoToTopController.OnGoToTopClickListener
    public boolean onGoToTopClick() {
        return ((NestedScrollView) this.f243b).lambda$seslSetGoToTopEnabled$4();
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.f243b).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    @Override // androidx.core.widget.SeslGoToTopImageView.WindowLocationProvider
    public void provideWindowOffset(int[] iArr) {
        ((SeslGoToTopController) this.f243b).lambda$ensureView$0(iArr);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        switch (this.f242a) {
            case 16:
                ((MaskableFrameLayout) this.f243b).lambda$dispatchDraw$1(canvas);
                break;
            default:
                ((NavigationView) this.f243b).lambda$dispatchDraw$0(canvas);
                break;
        }
    }

    @Override // com.samsung.android.sdk.handwriting.resources.impl.listener.HWRDeleteListener
    public void onComplete(boolean z, String str) {
        HWRLanguagePack.lambda$delete$0((LanguagePackInterface.OnDeleteListener) this.f243b, z, str);
    }
}

package com.samsung.android.support.senl.p148nt.app.inapp.presenter.item;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.handwriting.LaserPenInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenGestureControllerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.keyguard.BaseKeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.HWToolbarPolicyManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.RemoteHwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteFunctionContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RemoteRtSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import com.samsung.android.support.senl.p148nt.composer.main.basic.factory.BasicComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0090\u00012\u00020\u0001:\u0002\u0090\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\b\u00105\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020%H\u0016J\b\u0010=\u001a\u00020\u0017H\u0016J\b\u0010>\u001a\u00020%H\u0016J\b\u0010?\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u00020%H\u0016J\b\u0010A\u001a\u00020%H\u0016J\b\u0010B\u001a\u00020\u0017H\u0016J\b\u0010C\u001a\u00020%H\u0016J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020%H\u0016J\b\u0010F\u001a\u00020%H\u0016J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020%H\u0016J\u0010\u0010I\u001a\u00020\u00172\u0006\u0010H\u001a\u00020%H\u0016J\u0010\u0010J\u001a\u00020\u00172\u0006\u0010H\u001a\u00020%H\u0016J\b\u0010K\u001a\u00020%H\u0016J\u0010\u0010L\u001a\u00020\u00172\u0006\u00102\u001a\u00020MH\u0016J \u0010N\u001a\u00020\u00172\u0006\u0010:\u001a\u00020;2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020%H\u0016J\b\u0010S\u001a\u00020%H\u0016J\u0010\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020%H\u0016J\b\u0010V\u001a\u00020\u0017H\u0016J\b\u0010W\u001a\u00020\u0017H\u0016J\b\u0010X\u001a\u00020%H\u0016J\u0018\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020%H\u0016J\b\u0010]\u001a\u00020\u0017H\u0016J\b\u0010^\u001a\u00020%H\u0016J\b\u0010_\u001a\u00020\u0017H\u0016J\b\u0010`\u001a\u000208H\u0016J\b\u0010a\u001a\u000208H\u0016J\b\u0010b\u001a\u00020%H\u0016J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010E\u001a\u00020%H\u0016J\b\u0010d\u001a\u00020%H\u0016J\b\u0010e\u001a\u00020\u0017H\u0016J\b\u0010f\u001a\u00020%H\u0016J\b\u0010g\u001a\u00020%H\u0016J\b\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020\u0017H\u0016J\b\u0010k\u001a\u00020\u0017H\u0016J\b\u0010l\u001a\u00020\u0017H\u0016J\b\u0010m\u001a\u00020\u0017H\u0016J\b\u0010n\u001a\u00020\u0017H\u0016J\b\u0010o\u001a\u00020\u0017H\u0016J\b\u0010p\u001a\u00020%H\u0016J\u0010\u0010q\u001a\u00020\u00172\u0006\u0010r\u001a\u00020%H\u0016J\b\u0010s\u001a\u00020%H\u0016J\b\u0010t\u001a\u00020\u0017H\u0016J\b\u0010u\u001a\u00020\u0017H\u0016J\b\u0010v\u001a\u00020\u0017H\u0016J\b\u0010w\u001a\u00020%H\u0016J\b\u0010x\u001a\u00020%H\u0016J\b\u0010y\u001a\u00020%H\u0016J\b\u0010z\u001a\u00020\u0017H\u0016J\b\u0010{\u001a\u00020\u0017H\u0016J\b\u0010|\u001a\u00020%H\u0016J\b\u0010}\u001a\u00020%H\u0016J\b\u0010~\u001a\u00020%H\u0016J\b\u0010\u007f\u001a\u00020\u0017H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0017H\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\t\u0010\u0083\u0001\u001a\u00020%H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020%2\u0007\u0010\u0086\u0001\u001a\u000208H\u0016J\u0012\u0010\u0087\u0001\u001a\u000b\u0012\u0004\u0012\u000208\u0018\u00010\u0088\u0001H\u0016J\u0019\u0010\u0089\u0001\u001a\u00020\u00172\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u0002080\u0088\u0001H\u0016J!\u0010\u008b\u0001\u001a\u00020\u00172\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenterImpl;", "mActivity", "Landroid/app/Activity;", "toolbarManager", "Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarContract;", "remoteFunctionPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/remotefunction/RemoteFunctionContract$PresenterContract;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarContract;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/remotefunction/RemoteFunctionContract$PresenterContract;)V", "mViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewContract$IPresenter;", "mRemoteHwSettingPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/setting/RemoteHwSettingPresenter;", "remoteRtSettingPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/richtext/setting/RemoteRtSettingPresenter;", "getRemoteRtSettingPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/richtext/setting/RemoteRtSettingPresenter;", "mToolbarManager", "mToolbarMenuView", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarContract$IView;", "createViewPresenter", "updateLastPenTypeSelectionState", "", "setView", "view", "getView", "onDetachView", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "restoreViewState", "savedInstanceState", "initFirstCase", "changeTextMode", "changeWritingMode", "isShowing", "", Constants.IntentExtraValue.SHOW, "hide", "hidePopupsWithSpoid", "getWritingToolManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/WritingToolManager;", "getObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "getSettingInstance", "getHWToolbarPolicyManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/policy/HWToolbarPolicyManager;", "release", "addPreTouchListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "removePreTouchListener", "executeEraseAllOnAllPages", "executeEraseAllOnCurrentPage", "type", "", "executeSelectedChangeStyle", "changeStyleInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "isUndoable", "undo", "isRedoable", "redo", "isEnableUndoRedoMenu", "isTaskRunningInUndoRedoPresenter", "offEasyWritingPad", "isEasyWritingPadEnabled", "setEasyWritingPadEnabled", "enable", "isLastStateLockCanvas", "setLastStateLockCanvas", "isLock", "setZoomLock", "setModelZoomLock", "isZoomLocked", "setSpenGestureControllerListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenGestureControllerImpl;", "openSelectionChangeStyle", "isSupportFill", "anchorInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/common/AnchorInfo;", "isTextMode", "isMoveOnlyMode", "executeRemoteFavoritePen", "isForward", "executeRemoteEraser", "executePenSetting", "isTabletLayout", "setToolbarPosition", "rect", "Landroid/graphics/Rect;", "immediatelyUpdate", "clearContextMenu", "isIdleWorkingState", "updatedLastPenInfo", "getColorTheme", "getBackgroundThemeColor", "onBackPressed", "enableDockingMode", "isDockingMode", "setMenuDirty", "isSupportEraseCurrentPage", "isEraseCurrentTwoPage", "getCurrentPageInfo", "", "showLockCanvasToolTip", "showSettingPenMini", "hideSettingPenMini", "reboundSettingPenMiniVI", "showSoftInput", "hideSoftInput", "isShownSoftInput", "setBlockContextMenu", "block", "isTextButtonEnabled", "updateUndoRedoMenu", "dismissDirectWriteSettingDialog", "requestFocusToComposerView", "isCoeditNote", "isDeleteOnlyState", "isMoveOnlyState", "showLanguageSettingDialog", "showCleanUpAndCTT", "isSupportedAiMenu", "isPdfReader", "isSolveMathEnabled", "onHideSolveMathContextMenu", "hideAiSuggestionView", "getKeyguardPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/keyguard/KeyguardPresenter;", "canShowAiContextMenu", "releaseAssistPopup", "onPreClick", "viewId", "getCollaborationViewSupportedMenuIdList", "", "setCollaborationViewSupportedMenuIdList", "supportedMenuIdList", "showAiAssistMenu", "anchorView", "Landroid/view/View;", "anchorPosition", "Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/AnchorPosition;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppToolbarPresenter implements HwToolbarPresenterImpl {

    @NotNull
    private static final String TAG = "InAppToolbarPresenter";

    @Nullable
    private final Activity mActivity;

    @NotNull
    private final RemoteHwSettingPresenter mRemoteHwSettingPresenter;

    @NotNull
    private final InAppToolbarContract mToolbarManager;

    @Nullable
    private HwToolbarContract.IView mToolbarMenuView;

    @NotNull
    private final ComposerViewContract.IPresenter mViewPresenter;

    @NotNull
    private final RemoteRtSettingPresenter remoteRtSettingPresenter;

    public InAppToolbarPresenter(@Nullable Activity activity, @NotNull InAppToolbarContract toolbarManager, @Nullable RemoteFunctionContract.PresenterContract presenterContract) {
        Intrinsics.checkNotNullParameter(toolbarManager, "toolbarManager");
        this.mActivity = activity;
        ComposerViewContract.IPresenter iPresenterCreateViewPresenter = createViewPresenter();
        this.mViewPresenter = iPresenterCreateViewPresenter;
        this.mRemoteHwSettingPresenter = new RemoteHwSettingPresenter(iPresenterCreateViewPresenter, this, presenterContract, new BasicComponentFactory());
        this.remoteRtSettingPresenter = new RemoteRtSettingPresenter(presenterContract);
        this.mToolbarManager = toolbarManager;
    }

    private final ComposerViewContract.IPresenter createViewPresenter() {
        return new ComposerViewContract.IPresenter() { // from class: com.samsung.android.support.senl.nt.app.inapp.presenter.item.InAppToolbarPresenter.createViewPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void clearWritingToolControl() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public Activity getActivity() {
                return InAppToolbarPresenter.this.mActivity;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public ComposerModel getComposerModel() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public int getCurrentPageIndex() {
                return 0;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public HWToolbarPolicyManager getHWToolbarPolicyManager() {
                return new HWToolbarPolicyManager();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public ComposerViewContract.HWToolbarContract getHWToolbarPresenter() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public ListenerManager getListenerManager() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public ObjectManager getObjectManager() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public ComposerViewContract.RtTableAndCellStyleContract getRtTableAndCellStylePresenter() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public TextManager getTextManager() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public ComposerViewContract.TlToolbarContract getTlToolbarPresenter() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public WritingToolManager getWritingToolManager() {
                return new WritingToolManager(new BaseKeyguardPresenter());
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void goToPage(int index) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public boolean hasBackgroundImage() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void insertPage(int pageIndex) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public boolean isActionLinkEnabled() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public boolean isCtrlPressedLast() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public boolean isHyperTextEnabled() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void onConfigurationChanged(Configuration newConfig, boolean isOrientationChanged) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void onInAppCollaborationCloseButtonClicked() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void onPageCountChanged(int pageCount) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void onPageIndexChanged(int idx) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void onPageLayoutChanged() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void onScroll(PagePanInfo pagePan, float docZoomRatio, int curPageIndex) {
                Intrinsics.checkNotNullParameter(pagePan, "pagePan");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void setInputFormEnabled(boolean enabled) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void setLaserPen(boolean enable, LaserPenInfo info) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void setView(ComposerViewContract.IView view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.IPresenter
            public void setWritingGuideLineEnabled(boolean enabled) {
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void addPreTouchListener(@NotNull SpenPreTouchListenerImpl.PreTouchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean canShowAiContextMenu() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void changeTextMode() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void changeWritingMode() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void clearContextMenu() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void dismissDirectWriteSettingDialog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void enableDockingMode(boolean enable) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeEraseAllOnAllPages() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeEraseAllOnCurrentPage(int type) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executePenSetting() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeRemoteEraser() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeRemoteFavoritePen(boolean isForward) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void executeSelectedChangeStyle(@NotNull SpenSettingUIChangeStyleInfo changeStyleInfo) {
        Intrinsics.checkNotNullParameter(changeStyleInfo, "changeStyleInfo");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public int getBackgroundThemeColor() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @Nullable
    public List<Integer> getCollaborationViewSupportedMenuIdList() {
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public int getColorTheme() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @NotNull
    public String getCurrentPageInfo() {
        return "";
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @NotNull
    public HWToolbarPolicyManager getHWToolbarPolicyManager() {
        HWToolbarPolicyManager hWToolbarPolicyManager = this.mViewPresenter.getHWToolbarPolicyManager();
        Intrinsics.checkNotNullExpressionValue(hWToolbarPolicyManager, "getHWToolbarPolicyManager(...)");
        return hWToolbarPolicyManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @NotNull
    public KeyguardPresenter getKeyguardPresenter() {
        return new BaseKeyguardPresenter();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @Nullable
    public ObjectManager getObjectManager() {
        return null;
    }

    @NotNull
    public final RemoteRtSettingPresenter getRemoteRtSettingPresenter() {
        return this.remoteRtSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @Nullable
    /* JADX INFO: renamed from: getView, reason: from getter */
    public HwToolbarContract.IView getMToolbarMenuView() {
        return this.mToolbarMenuView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @NotNull
    public WritingToolManager getWritingToolManager() {
        WritingToolManager writingToolManager = this.mViewPresenter.getWritingToolManager();
        Intrinsics.checkNotNullExpressionValue(writingToolManager, "getWritingToolManager(...)");
        return writingToolManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hide() {
        if (this.mToolbarMenuView != null) {
            InAppLogger.m8595d(TAG, "hide# hwToolbarMenu");
            HwToolbarContract.IView iView = this.mToolbarMenuView;
            Intrinsics.checkNotNull(iView);
            iView.hide();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hideAiSuggestionView() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hidePopupsWithSpoid() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hideSettingPenMini() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void hideSoftInput() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void initFirstCase() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isCoeditNote() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isDeleteOnlyState() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isDockingMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isEasyWritingPadEnabled() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isEnableUndoRedoMenu() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isEraseCurrentTwoPage() {
        if (!this.mRemoteHwSettingPresenter.isTwoPageView()) {
            return false;
        }
        int pageCount = this.mRemoteHwSettingPresenter.getPageCount();
        return (pageCount % 2 == 0 && pageCount + (-2) == this.mRemoteHwSettingPresenter.getPageIndex()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isIdleWorkingState() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isLastStateLockCanvas() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isMoveOnlyMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isMoveOnlyState() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isPdfReader() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isRedoable() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isShowing() {
        HwToolbarContract.IView iView = this.mToolbarMenuView;
        if (iView == null) {
            return false;
        }
        Intrinsics.checkNotNull(iView);
        boolean zIsShowing = iView.isShowing();
        InAppLogger.m8595d(TAG, "isShowing# hwToolbarMenu isShowing : " + zIsShowing);
        return zIsShowing;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isShownSoftInput() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isSolveMathEnabled() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isSupportEraseCurrentPage() {
        return (this.mRemoteHwSettingPresenter.isSinglePageMode() || this.mRemoteHwSettingPresenter.getPageCount() == 2 || this.mRemoteHwSettingPresenter.getPageCount() - 1 == this.mRemoteHwSettingPresenter.getPageIndex()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isSupportedAiMenu() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTabletLayout() {
        return NotesUtils.isTabletLayout(BaseUtils.getApplicationContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTaskRunningInUndoRedoPresenter() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTextButtonEnabled() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTextMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isUndoable() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isZoomLocked() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void offEasyWritingPad() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void onDetachView() {
        this.mToolbarMenuView = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void onHideSolveMathContextMenu() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean onPreClick(int viewId) {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (this.mToolbarMenuView != null) {
            InAppLogger.m8595d(TAG, "onSaveInstanceState# hwToolbarMenu");
            HwToolbarContract.IView iView = this.mToolbarMenuView;
            if (iView != null) {
                iView.onSaveInstanceState(outState);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void openSelectionChangeStyle(@NotNull SpenSettingUIChangeStyleInfo changeStyleInfo, boolean isSupportFill, @NotNull AnchorInfo anchorInfo) {
        Intrinsics.checkNotNullParameter(changeStyleInfo, "changeStyleInfo");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void reboundSettingPenMiniVI() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void redo() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void release() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void releaseAssistPopup() {
        getMRemoteHwSettingPresenter().releaseAssistPopup();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void removePreTouchListener(@NotNull SpenPreTouchListenerImpl.PreTouchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void requestFocusToComposerView() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void restoreViewState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        if (this.mToolbarMenuView != null) {
            InAppLogger.m8595d(TAG, "restoreState# hwToolbarMenu");
            HwToolbarContract.IView iView = this.mToolbarMenuView;
            if (iView != null) {
                iView.restore(savedInstanceState);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setBlockContextMenu(boolean block) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setCollaborationViewSupportedMenuIdList(@NotNull List<Integer> supportedMenuIdList) {
        Intrinsics.checkNotNullParameter(supportedMenuIdList, "supportedMenuIdList");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setEasyWritingPadEnabled(boolean enable) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setLastStateLockCanvas(boolean isLock) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setMenuDirty() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setModelZoomLock(boolean isLock) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setSpenGestureControllerListener(@NotNull SpenGestureControllerImpl listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setToolbarPosition(@NotNull Rect rect, boolean immediatelyUpdate) {
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setView(@Nullable HwToolbarContract.IView view) {
        this.mToolbarMenuView = view;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void setZoomLock(boolean isLock) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void show() {
        if (this.mToolbarMenuView != null) {
            InAppLogger.m8595d(TAG, "show# hwToolbarMenu");
            HwToolbarContract.IView iView = this.mToolbarMenuView;
            Intrinsics.checkNotNull(iView);
            iView.show();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showAiAssistMenu(@Nullable View anchorView, @Nullable AnchorPosition anchorPosition) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showCleanUpAndCTT() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showLanguageSettingDialog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showLockCanvasToolTip() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showSettingPenMini() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void showSoftInput() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void undo() {
    }

    public final void updateLastPenTypeSelectionState() {
        InAppLogger.m8595d(TAG, "updateLastPenTypeSelectionState#");
        this.mToolbarManager.updateLastPenTypeSelectionState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void updateUndoRedoMenu() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void updatedLastPenInfo() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    @NotNull
    /* JADX INFO: renamed from: getSettingInstance, reason: from getter */
    public RemoteHwSettingPresenter getMRemoteHwSettingPresenter() {
        return this.mRemoteHwSettingPresenter;
    }
}

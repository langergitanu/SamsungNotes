package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view.AiMenuPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u001c\u0018\u00002\u00020\u0001:\u0002\u0083\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010,\u001a\u00020-2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020\u0014J\u0010\u00101\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u00020\u0014J\u0006\u00105\u001a\u00020'J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020-J\u0006\u0010;\u001a\u00020-J\u0006\u0010<\u001a\u00020\u0014J\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>J\u0006\u0010@\u001a\u00020'J\f\u0010A\u001a\b\u0012\u0004\u0012\u00020?0>J\u0006\u0010B\u001a\u00020'J\u000e\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020?J\f\u0010E\u001a\b\u0012\u0004\u0012\u00020?0>J\u0006\u0010F\u001a\u00020'J\u0016\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020?2\u0006\u0010D\u001a\u00020?J\u000e\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020-2\u0006\u0010J\u001a\u00020KJ\u0016\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0014J\u0010\u0010Q\u001a\u00020-2\b\b\u0002\u0010R\u001a\u00020\u0014J\f\u0010S\u001a\b\u0012\u0004\u0012\u00020'0>J\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0>J\u000e\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020'J\u000e\u0010X\u001a\u00020-2\u0006\u0010Y\u001a\u00020ZJ\u0006\u0010[\u001a\u00020\\J\u000e\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020_J\u0010\u0010`\u001a\u00020-2\u0006\u0010a\u001a\u00020'H\u0016J\b\u0010b\u001a\u00020-H\u0016J\b\u0010c\u001a\u00020-H\u0016J\u0010\u0010d\u001a\u00020-2\u0006\u0010e\u001a\u00020\u0014H\u0016J\u001c\u0010f\u001a\u00020-2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0hH\u0016J\b\u0010i\u001a\u00020-H\u0016J\u0006\u0010j\u001a\u00020'J\u000e\u0010k\u001a\u00020-2\u0006\u0010N\u001a\u00020lJ\u0006\u0010m\u001a\u00020'J\f\u0010n\u001a\b\u0012\u0004\u0012\u00020?0>J\u0006\u0010o\u001a\u00020-J\u000e\u0010p\u001a\u00020-2\u0006\u0010q\u001a\u00020'J\b\u0010r\u001a\u00020-H\u0002J\u0006\u0010s\u001a\u00020-J\b\u0010t\u001a\u00020-H\u0002J\u0016\u0010u\u001a\u00020-2\u0006\u0010v\u001a\u00020\\2\u0006\u0010w\u001a\u00020\\J\u0010\u0010x\u001a\u00020-2\b\u0010J\u001a\u0004\u0018\u00010yJ\u0010\u0010z\u001a\u00020-2\b\u0010J\u001a\u0004\u0018\u00010yJ\u0006\u0010{\u001a\u00020-J\u0006\u0010|\u001a\u00020?J\u0006\u0010}\u001a\u00020\u0014J\u000e\u0010~\u001a\u00020-2\u0006\u0010\u007f\u001a\u00020'J\u0010\u0010\u0080\u0001\u001a\u00020-2\u0007\u0010\u0081\u0001\u001a\u00020\u0014J\u0007\u0010\u0082\u0001\u001a\u00020'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006\u0084\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarContract$QtHwToolbarStateListener;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "hwToolbarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;", "stickyMemoManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;)V", "getComposerViewPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "getHwToolbarPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;", "hwSettingPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/setting/HwSettingPresenter;", "kotlin.jvm.PlatformType", "settingInfoManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/setting/SettingInfoManager;", "isFocusStickyNote", "", "()Z", "view", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter$IQTView;", "isRequestShowNoteAssist", "setRequestShowNoteAssist", "(Z)V", "onSipListener", "com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter$onSipListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter$onSipListener$1;", "onFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "mDockingState", "", "getMDockingState", "()[F", "setMDockingState", "([F)V", "currentFavoriteIndex", "", "getCurrentFavoriteIndex", "()I", "setCurrentFavoriteIndex", "(I)V", "setView", "", "addOnSipListener", "removeOnSipListener", "canShowAiMenu", "restoreState", "savedInstanceState", "Landroid/os/Bundle;", "isSupportQuickTool", "getSelectedPenType", "getAiContextMenuPopup", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/view/AiMenuPopup;", "getAiMenuManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/AiMenuManager;", "clearSelectionNoteAssist", "showSettingPenMini", "hideSettingPenMini", "getPenInfoList", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "getPenSelectedIndex", "getHighlighterInfoList", "getHighlighterSelectedIndex", "onPenInfoChange", "newInfo", "getFavoriteInfoList", "getFavoriteSelectedIndex", "onFavoriteInfoChange", "currentInfo", "registerFavoriteInfoChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/toolbar/hw/setting/data/SettingFavoritePenData$FavoritePenInfoChangeListener;", "unregisterFavoriteInfoChangeListener", "showAddFavoritePen", "container", "Landroid/view/ViewGroup;", "right", "hideSettingViews", "animation", "getPaletteList", "getRecentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "onItemSelected", "type", "onNoteAssistClick", "runnable", "Ljava/lang/Runnable;", "getAppBarHeight", "", "getNavigationBarHeight", "context", "Landroid/content/Context;", "onPreClick", "viewId", "notifyToUpdateInfo", "onConfigurationChanged", "onFocusStickyMemo", "hasFocus", "onShownSettingViewsChange", "shownSettingViews", "", "onEyeDropperChanged", "getColorTheme", "showEyedropper", "Landroid/view/View;", "getPenSelected", "getPenViewList", "hideQT", "setVisibility", "visibility", "restorePenMode", "onSaveState", "hideStickyMemo", "setEyedropperPosition", "x", "y", "setPreTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "removePreTouchListener", "requestCancelTouch", "getSelectedPenInfo", "isEyeDropperEnabled", "updateQTContainer", "width", "setClipToOutlineForQTContainer", "clipToOutline", "getDeltaCoordinateOrigin", "IQTView", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QuickToolPresenter implements HwToolbarContract.QtHwToolbarStateListener {

    @NotNull
    private final ComposerViewPresenter composerViewPresenter;
    private int currentFavoriteIndex;
    private HwSettingPresenter hwSettingPresenter;

    @NotNull
    private final HwToolbarPresenter hwToolbarPresenter;
    private boolean isRequestShowNoteAssist;

    @Nullable
    private float[] mDockingState;

    @NotNull
    private final View.OnFocusChangeListener onFocusChangeListener;

    @NotNull
    private final QuickToolPresenter$onSipListener$1 onSipListener;
    private SettingInfoManager settingInfoManager;

    @NotNull
    private final StickyMemoManager stickyMemoManager;

    @Nullable
    private IQTView view;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\u0005H&¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter$IQTView;", "", "requestHideFromToolbar", "", "viewId", "", "updateInfo", "onConfigurationChanged", "blockAiMenu", RPCSyncSettingContract.Parameter.SUPPORTED, "", "hideQt", "setVisibility", "visibility", "getDockingQTState", "", "updateQTContainer", "width", "updateEyedropper", "setClipToOutlineForQTContainer", "clipToOutline", "getDeltaCoordinateOrigin", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IQTView {
        void blockAiMenu(boolean supported);

        int getDeltaCoordinateOrigin();

        @Nullable
        float[] getDockingQTState();

        boolean hideQt();

        void onConfigurationChanged();

        void requestHideFromToolbar(int viewId);

        void setClipToOutlineForQTContainer(boolean clipToOutline);

        void setVisibility(int visibility);

        void updateEyedropper();

        void updateInfo();

        void updateQTContainer(int width);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter$onSipListener$1] */
    public QuickToolPresenter(@NotNull ComposerViewPresenter composerViewPresenter, @NotNull HwToolbarPresenter hwToolbarPresenter, @NotNull StickyMemoManager stickyMemoManager) {
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(hwToolbarPresenter, "hwToolbarPresenter");
        Intrinsics.checkNotNullParameter(stickyMemoManager, "stickyMemoManager");
        this.composerViewPresenter = composerViewPresenter;
        this.hwToolbarPresenter = hwToolbarPresenter;
        this.stickyMemoManager = stickyMemoManager;
        HwSettingPresenter settingInstance = hwToolbarPresenter.getMRemoteHwSettingPresenter();
        this.hwSettingPresenter = settingInstance;
        this.settingInfoManager = settingInstance.getSettingInfoManager();
        this.onSipListener = new SoftInputManager.OnSipListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter$onSipListener$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
            public void onHide() {
                int i = this.this$0.isSupportQuickTool() ? 0 : 8;
                QuickToolPresenter.IQTView iQTView = this.this$0.view;
                if (iQTView != null) {
                    iQTView.setVisibility(i);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
            public void onShow() {
                QuickToolPresenter.IQTView iQTView = this.this$0.view;
                if (iQTView != null) {
                    iQTView.setVisibility(8);
                }
            }
        };
        this.onFocusChangeListener = new ViewOnFocusChangeListenerC4697c(this, 5);
    }

    public static /* synthetic */ void hideSettingViews$default(QuickToolPresenter quickToolPresenter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        quickToolPresenter.hideSettingViews(z);
    }

    private final void hideStickyMemo() {
        if (this.stickyMemoManager.isShowing()) {
            StickyMemoManager.hideMemo$default(this.stickyMemoManager, true, null, false, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFocusChangeListener$lambda$0(QuickToolPresenter quickToolPresenter, View view, boolean z) {
        if (z) {
            quickToolPresenter.notifyToUpdateInfo();
        }
    }

    private final void restorePenMode() {
        HwSettingPresenter hwSettingPresenter = this.hwSettingPresenter;
        hwSettingPresenter.updateToolbarSelectionState(hwSettingPresenter.getSelectedPenInfo());
        HwSettingPresenter hwSettingPresenter2 = this.hwSettingPresenter;
        hwSettingPresenter2.updatePenSettingInfo(hwSettingPresenter2.getSelectedPenInfo());
    }

    public final void addOnSipListener() {
        this.composerViewPresenter.getSoftInputManager().addOnSipListener(this.onSipListener);
    }

    public final boolean canShowAiMenu() {
        return FeatureInfo.isAiFeatureEnabled() && this.hwToolbarPresenter.isSupportedAiMenu() && this.hwToolbarPresenter.canShowAiContextMenu();
    }

    public final void clearSelectionNoteAssist() {
        if (getAiMenuManager().isShowingContextMenu()) {
            getAiMenuManager().hideContextMenu((this.composerViewPresenter.getComposerModel().getComposerState().isTranslated() && getAiMenuManager().getAiContextMenuPresenter().isAiMenuForTranslation()) ? false : true);
        }
        this.hwSettingPresenter.releaseAssistPopup();
        if (this.hwToolbarPresenter.isSelected(2) || this.hwToolbarPresenter.isSelected(2048) || this.composerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Text)) {
            return;
        }
        restorePenMode();
    }

    @NotNull
    public final AiMenuPopup getAiContextMenuPopup() {
        AiMenuPopup aiContextMenuPopup = this.hwToolbarPresenter.getAiMenuManager().getAiMenuView().getAiContextMenuPopup();
        Intrinsics.checkNotNullExpressionValue(aiContextMenuPopup, "getAiContextMenuPopup(...)");
        return aiContextMenuPopup;
    }

    @NotNull
    public final AiMenuManager getAiMenuManager() {
        AiMenuManager aiMenuManager = this.hwToolbarPresenter.getAiMenuManager();
        Intrinsics.checkNotNullExpressionValue(aiMenuManager, "getAiMenuManager(...)");
        return aiMenuManager;
    }

    public final float getAppBarHeight() {
        if (this.composerViewPresenter.getActivity().getTheme().resolveAttribute(R.attr.actionBarSize, new TypedValue(), true)) {
            return TypedValue.complexToDimensionPixelSize(r0.data, this.composerViewPresenter.getActivity().getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public final int getColorTheme() {
        return this.hwToolbarPresenter.getColorTheme();
    }

    @NotNull
    public final ComposerViewPresenter getComposerViewPresenter() {
        return this.composerViewPresenter;
    }

    public final int getCurrentFavoriteIndex() {
        return this.currentFavoriteIndex;
    }

    public final int getDeltaCoordinateOrigin() {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            return iQTView.getDeltaCoordinateOrigin();
        }
        return 0;
    }

    @NotNull
    public final List<SpenSettingUIPenInfo> getFavoriteInfoList() {
        ArrayList<SpenSettingUIPenInfo> favoriteList = this.settingInfoManager.getFavoritePenData().getFavoriteList();
        Intrinsics.checkNotNullExpressionValue(favoriteList, "getFavoriteList(...)");
        return favoriteList;
    }

    public final int getFavoriteSelectedIndex() {
        return this.hwSettingPresenter.getSelectedFavoritePenIndex();
    }

    @NotNull
    public final List<SpenSettingUIPenInfo> getHighlighterInfoList() {
        ArrayList<SpenSettingUIPenInfo> settingHighlighterInfoList = this.settingInfoManager.getHighlighterData().getSettingHighlighterInfoList();
        Intrinsics.checkNotNullExpressionValue(settingHighlighterInfoList, "getSettingHighlighterInfoList(...)");
        return settingHighlighterInfoList;
    }

    public final int getHighlighterSelectedIndex() {
        return this.settingInfoManager.getHighlighterData().getSettingHighlighterSelectedIndex();
    }

    @NotNull
    public final HwToolbarPresenter getHwToolbarPresenter() {
        return this.hwToolbarPresenter;
    }

    @Nullable
    public final float[] getMDockingState() {
        return this.mDockingState;
    }

    public final int getNavigationBarHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        if (companion.getInstance().isNavigationBarHidden(context)) {
            return 0;
        }
        return companion.getInstance().getNavigationBarHeight(context);
    }

    @NotNull
    public final List<Integer> getPaletteList() {
        List<Integer> selectList = this.settingInfoManager.getColorPaletteData().getSelectList();
        Intrinsics.checkNotNullExpressionValue(selectList, "getSelectList(...)");
        return selectList;
    }

    @NotNull
    public final List<SpenSettingUIPenInfo> getPenInfoList() {
        ArrayList<SpenSettingUIPenInfo> settingPenInfoList = this.settingInfoManager.getPenInfoData().getSettingPenInfoList();
        Intrinsics.checkNotNullExpressionValue(settingPenInfoList, "getSettingPenInfoList(...)");
        return settingPenInfoList;
    }

    public final int getPenSelected() {
        if (getSelectedPenType() == 2) {
            return getPenSelectedIndex();
        }
        return getPenInfoList().size() + getHighlighterSelectedIndex();
    }

    public final int getPenSelectedIndex() {
        return this.settingInfoManager.getPenInfoData().getSettingPenSelectedIndex();
    }

    @NotNull
    public final List<SpenSettingUIPenInfo> getPenViewList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getPenInfoList());
        if (!isFocusStickyNote()) {
            arrayList.addAll(getHighlighterInfoList());
        }
        return arrayList;
    }

    @NotNull
    public final List<SpenHSVColor> getRecentColors() {
        List<SpenHSVColor> recentColors = this.settingInfoManager.getColorRecentData().getRecentColors();
        Intrinsics.checkNotNullExpressionValue(recentColors, "getRecentColors(...)");
        return recentColors;
    }

    @NotNull
    public final SpenSettingUIPenInfo getSelectedPenInfo() {
        SpenSettingUIPenInfo selectedPenInfo = this.hwSettingPresenter.getSelectedPenInfo();
        Intrinsics.checkNotNullExpressionValue(selectedPenInfo, "getSelectedPenInfo(...)");
        return selectedPenInfo;
    }

    public final int getSelectedPenType() {
        return this.hwSettingPresenter.getSelectedPenType();
    }

    public final void hideQT() {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.hideQt();
        }
    }

    public final boolean hideSettingPenMini() {
        if (!this.settingInfoManager.getPenMiniMenuData().isEnable()) {
            return false;
        }
        this.settingInfoManager.getPenMiniMenuData().setEnable(false);
        this.hwToolbarPresenter.hideSettingPenMini();
        return true;
    }

    public final void hideSettingViews(boolean animation) {
        this.hwSettingPresenter.hideSettingViews(animation);
        this.hwSettingPresenter.hideColorSpoid();
    }

    public final boolean isEyeDropperEnabled() {
        return this.hwSettingPresenter.getSettingInfoManager().isEyeDropperEnabled();
    }

    public final boolean isFocusStickyNote() {
        return !this.hwSettingPresenter.isNotStickyMemoConnected() && this.stickyMemoManager.isShowing();
    }

    /* JADX INFO: renamed from: isRequestShowNoteAssist, reason: from getter */
    public final boolean getIsRequestShowNoteAssist() {
        return this.isRequestShowNoteAssist;
    }

    public final boolean isSupportQuickTool() {
        if (FeatureInfo.isEnabledQuickTool() && this.hwToolbarPresenter.isShowing() && this.hwToolbarPresenter.isWritingMode() && !this.composerViewPresenter.getComposerModel().getComposerState().isInAppCollaborationMode()) {
            return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_QUICK_TOOLS, true);
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.QtHwToolbarStateListener
    public void notifyToUpdateInfo() {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.updateInfo();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.QtHwToolbarStateListener
    public void onConfigurationChanged() {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.onConfigurationChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.QtHwToolbarStateListener
    public void onEyeDropperChanged() {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.updateEyedropper();
        }
    }

    public final void onFavoriteInfoChange(@NotNull SpenSettingUIPenInfo currentInfo, @NotNull SpenSettingUIPenInfo newInfo) {
        Intrinsics.checkNotNullParameter(currentInfo, "currentInfo");
        Intrinsics.checkNotNullParameter(newInfo, "newInfo");
        if (this.hwSettingPresenter.isHighlighterType(newInfo)) {
            hideStickyMemo();
        }
        this.hwSettingPresenter.changeFavoritePenInfo(currentInfo, newInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.QtHwToolbarStateListener
    public void onFocusStickyMemo(boolean hasFocus) {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.blockAiMenu(hasFocus);
        }
    }

    public final void onItemSelected(int type) {
        this.hwToolbarPresenter.onItemSelected(type);
    }

    public final void onNoteAssistClick(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.isRequestShowNoteAssist = true;
        this.hwToolbarPresenter.onNoteAssistClick(runnable);
    }

    public final void onPenInfoChange(@NotNull SpenSettingUIPenInfo newInfo) {
        Intrinsics.checkNotNullParameter(newInfo, "newInfo");
        if (this.hwSettingPresenter.isHighlighterType(newInfo)) {
            hideStickyMemo();
        }
        this.hwSettingPresenter.updatePenSettingInfo(newInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.QtHwToolbarStateListener
    public void onPreClick(int viewId) {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.requestHideFromToolbar(viewId);
        }
    }

    public final void onSaveState() {
        IQTView iQTView = this.view;
        this.mDockingState = iQTView != null ? iQTView.getDockingQTState() : null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.QtHwToolbarStateListener
    public void onShownSettingViewsChange(@NotNull Map<Integer, Integer> shownSettingViews) {
        Intrinsics.checkNotNullParameter(shownSettingViews, "shownSettingViews");
        int i = (shownSettingViews.isEmpty() && isSupportQuickTool() && !this.settingInfoManager.getPenMiniMenuData().isEnable()) ? 0 : 8;
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.setVisibility(i);
        }
    }

    public final void registerFavoriteInfoChangeListener(@NotNull SettingFavoritePenData.FavoritePenInfoChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.settingInfoManager.getFavoritePenData().registerFavoriteInfoChangeListener(listener);
    }

    public final void removeOnSipListener() {
        this.composerViewPresenter.getSoftInputManager().removeOnSipListener(this.onSipListener);
    }

    public final void removePreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener) {
        this.composerViewPresenter.getListenerManager().removePreTouchListener(listener);
    }

    public final void requestCancelTouch() {
        this.composerViewPresenter.requestCancelTouch();
    }

    public final void restoreState(@Nullable Bundle savedInstanceState) {
        this.hwToolbarPresenter.restoreSettingState(savedInstanceState);
        HwSettingPresenter settingInstance = this.hwToolbarPresenter.getMRemoteHwSettingPresenter();
        this.hwSettingPresenter = settingInstance;
        this.settingInfoManager = settingInstance.getSettingInfoManager();
    }

    public final void setClipToOutlineForQTContainer(boolean clipToOutline) {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.setClipToOutlineForQTContainer(clipToOutline);
        }
    }

    public final void setCurrentFavoriteIndex(int i) {
        this.currentFavoriteIndex = i;
    }

    public final void setEyedropperPosition(float x, float y2) {
        this.hwSettingPresenter.setEyedropperPosition((int) x, (int) y2);
    }

    public final void setMDockingState(@Nullable float[] fArr) {
        this.mDockingState = fArr;
    }

    public final void setPreTouchListener(@Nullable SpenPreTouchListenerImpl.PreTouchListener listener) {
        this.composerViewPresenter.getListenerManager().addPreTouchListener(listener);
    }

    public final void setRequestShowNoteAssist(boolean z) {
        this.isRequestShowNoteAssist = z;
    }

    public final void setView(@Nullable IQTView view) {
        this.view = view;
        if (view == null) {
            this.hwToolbarPresenter.setQtHwToolbarStateListener(null);
            this.composerViewPresenter.getListenerManager().removeFocusChangeListener(this.onFocusChangeListener);
        } else {
            this.hwToolbarPresenter.setQtHwToolbarStateListener(this);
            this.composerViewPresenter.getListenerManager().addFocusChangeListener(this.onFocusChangeListener);
        }
    }

    public final void setVisibility(int visibility) {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.setVisibility(visibility);
        }
    }

    public final void showAddFavoritePen(@NotNull ViewGroup container, boolean right) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (!this.settingInfoManager.getFavoritePenData().canAddFavoriteInfo()) {
            ToastHandler.show(container.getContext(), C9086R.string.hw_toolbar_list_full_favorite_pen, 0);
        } else {
            hideSettingViews$default(this, false, 1, null);
            this.hwSettingPresenter.showAddFavoritePen(0, container, right);
        }
    }

    public final void showEyedropper(@NotNull View container) {
        Intrinsics.checkNotNullParameter(container, "container");
        hideSettingViews$default(this, false, 1, null);
        this.hwSettingPresenter.showEyedropper(0, container, this.hwSettingPresenter.getSelectedPenInfo().hsv, null);
    }

    public final void showSettingPenMini() {
        if (this.hwSettingPresenter.getHwToolbarState().isShownSettingViews() || this.settingInfoManager.getPenMiniMenuData().isEnable()) {
            return;
        }
        this.settingInfoManager.getPenMiniMenuData().setEnable(true);
        this.hwToolbarPresenter.showSettingPenMini();
    }

    public final void unregisterFavoriteInfoChangeListener(@NotNull SettingFavoritePenData.FavoritePenInfoChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.settingInfoManager.getFavoritePenData().unregisterFavoriteInfoChangeListener(listener);
    }

    public final void updateQTContainer(int width) {
        IQTView iQTView = this.view;
        if (iQTView != null) {
            iQTView.updateQTContainer(width);
        }
    }
}

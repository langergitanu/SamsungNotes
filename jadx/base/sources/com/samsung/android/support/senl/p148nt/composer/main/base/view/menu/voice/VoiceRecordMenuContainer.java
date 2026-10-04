package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.voice.VoiceMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.STTPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.STTTabletWindow;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\u0018\u0000 t2\u00020\u0001:\u0001tB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\u0006\u0010.\u001a\u00020\u001bJ\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u00020\u001bH\u0016J(\u00103\u001a\u00020\u001b2\u0006\u00100\u001a\u00020'2\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020\u001bH\u0016J\u0018\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u001b2\u0006\u00100\u001a\u00020'H\u0016J\u0010\u0010E\u001a\u00020\u001b2\u0006\u00100\u001a\u00020'H\u0016J\b\u0010F\u001a\u00020\u001bH\u0016J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010H\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010I\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010J\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010L\u001a\u00020\u001b2\u0006\u00104\u001a\u00020#H\u0016J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020@H\u0016J \u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020#2\u0006\u0010?\u001a\u00020#2\u0006\u00100\u001a\u00020'H\u0016J\b\u0010Q\u001a\u00020\u001bH\u0016J\b\u0010R\u001a\u00020\u001bH\u0016J(\u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020'H\u0016J\u0010\u0010X\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020'H\u0016J\u0010\u0010Z\u001a\u00020\u001b2\u0006\u00106\u001a\u00020#H\u0016J\u0018\u0010[\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020'2\u0006\u00106\u001a\u00020#H\u0016J\b\u0010\\\u001a\u00020'H\u0016J\u0012\u0010]\u001a\u00020\u001b2\b\u0010^\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010_\u001a\u00020'H\u0016J\u0006\u0010`\u001a\u00020\u001bJ\u0018\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020@2\u0006\u0010c\u001a\u00020'H\u0016J\b\u0010d\u001a\u00020\u001bH\u0016J\u000f\u0010e\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u001bH\u0016J\u0010\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020'H\u0016J\b\u0010j\u001a\u00020\u001bH\u0016J\u0010\u0010k\u001a\u00020\u001b2\u0006\u00108\u001a\u00020'H\u0016J\b\u0010l\u001a\u00020'H\u0016J(\u0010m\u001a\u00020\u001b2\u0006\u0010n\u001a\u00020#2\u0006\u0010b\u001a\u00020@2\u0006\u0010c\u001a\u00020'2\u0006\u0010o\u001a\u00020#H\u0016J\u0010\u0010m\u001a\u00020\u001b2\u0006\u0010n\u001a\u00020#H\u0016J\b\u0010p\u001a\u00020\u001bH\u0016J\b\u0010q\u001a\u00020\u001bH\u0016J\b\u0010r\u001a\u00020\u001bH\u0016J\u0010\u0010s\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuContainer;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IView;", "mActivity", "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "mCustomToolbar", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar;)V", "mPresenter", "mVoiceRecordExpandMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandMenu;", "mVoiceRecordPlayMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordPlayMenu;", "mVoiceRecordSimpleMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordSimpleMenu;", "mContainer", "Landroid/view/View;", "mContainerParent", "mDecorViewContainer", "Landroid/widget/LinearLayout;", "mVoiceAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation;", "mSTTWindow", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/stt/STTTabletWindow;", "onConfigurationChanged", "", "hideVoicePopupView", "hidePopupMenu", "hideSpeedPopup", "getVoiceListView", "updateRecording", "updateSTTShowItem", "position", "", "hideRecordingListView", "updateStatusAnimation", "isAnimation", "", "addVoiceSimpleMenu", "addSimpleMenuToCustomToolbar", "addSimpleMenuToDecorView", "updateParamVoiceMenu", "isWrapContent", "updateMarginTopVoiceMenu", "updateView", "showInitView", "isPlay", "runWithAnimation", "showRecordingView", "showRecordingPlayView", "progress", "isHidePrevViews", "selectedItem", "onUpdateListVoiceBtnState", "isEnabled", "hideAllView", "changeMode", "isEditMode", "viewState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState;", "setRecordingTime", "time", "", "setRecordTime", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "setPlayPauseIcon", "showRecordSimpleMenu", "notifyDataChanged", "notifyItemRemoved", "notifyItemChanged", "notifyItemInserted", "setPlayTime", "setTotalRecordTime", "setProgress", "setPlaySpeed", "speed", "showAudioPlayView", "maxProgress", "hideAudioPlayView", "hideEditTrashView", "updateBackground", "color", "invert", "hasBackgroundImage", "updateDialog", "setItemSelectedMode", "selectedMode", "updateSelectedItemMenu", "showEditView", "toggleExpendVoicePanel", "initSTT", "sttContainer", "sttOnBackPressed", "release", "search", "keySearch", "isFromBackward", "clearSearchComposer", "isShowingAiResultView", "()Ljava/lang/Boolean;", "executeAudioEraser", "updateViewForEraser", "needUpdateAnimation", "releaseAudioEraser", "updateAudioEraserAnimation", "isLineVoiceLayout", "onSTTItemStateButtonClick", "index", "indexCurrentSearchSTT", "showSTTWindow", "hideSTTWindow", "expandRecordingListVerticalMenu", "notifySTTItemChanged", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceRecordMenuContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordMenuContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuContainer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,698:1\n1#2:699\n*E\n"})
public final class VoiceRecordMenuContainer implements VoiceRecordMenuContract.IView {

    @NotNull
    private static final String TAG;

    @Nullable
    private Activity mActivity;

    @Nullable
    private View mContainer;

    @Nullable
    private View mContainerParent;

    @Nullable
    private ICustomToolbar mCustomToolbar;

    @Nullable
    private final LinearLayout mDecorViewContainer;

    @Nullable
    private VoiceRecordMenuPresenter mPresenter;

    @Nullable
    private STTTabletWindow mSTTWindow;

    @NotNull
    private VoiceAnimation mVoiceAnimation;

    @Nullable
    private VoiceRecordExpandMenu mVoiceRecordExpandMenu;

    @Nullable
    private VoiceRecordPlayMenu mVoiceRecordPlayMenu;

    @NotNull
    private final VoiceRecordSimpleMenu mVoiceRecordSimpleMenu;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordMenuContainer");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordMenuContainer(@Nullable Activity activity, @NotNull VoiceRecordMenuPresenter presenter, @Nullable ICustomToolbar iCustomToolbar) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mActivity = activity;
        this.mCustomToolbar = iCustomToolbar;
        this.mPresenter = presenter;
        this.mContainerParent = activity != null ? activity.findViewById(C9086R.id.voice_record_menu_container_parent) : null;
        Activity activity2 = this.mActivity;
        this.mContainer = activity2 != null ? activity2.findViewById(C9086R.id.voice_record_menu_container) : null;
        Activity activity3 = this.mActivity;
        View viewInflate = LayoutInflater.from(activity3).inflate(C9086R.layout.comp_voice_record_simple_menu, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        VoiceRecordSimpleMenu voiceRecordSimpleMenu = new VoiceRecordSimpleMenu(activity3, viewInflate, presenter);
        this.mVoiceRecordSimpleMenu = voiceRecordSimpleMenu;
        this.mVoiceAnimation = new VoiceAnimation(voiceRecordSimpleMenu);
        Activity activity4 = this.mActivity;
        this.mDecorViewContainer = activity4 != null ? (LinearLayout) activity4.findViewById(C9086R.id.comp_voice_simple_menu_container) : null;
        this.mVoiceRecordPlayMenu = new VoiceRecordPlayMenu(this.mActivity, presenter, this.mContainer);
        this.mVoiceRecordExpandMenu = new VoiceRecordExpandMenu(this.mActivity, presenter, this.mContainer, this.mVoiceAnimation);
        addVoiceSimpleMenu();
        View view = this.mContainer;
        if (view != null) {
            view.setVisibility(0);
        }
        presenter.setView(this);
        VoiceRecordMenuContract.IView.DefaultImpls.updateBackground$default(this, presenter.getBackgroundColor(), presenter.isBackgroundColorInverted(), presenter.hasBackgroundImage(), false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSimpleMenuToCustomToolbar() {
        Logger.m10999d(TAG, "addSimpleMenuToCustomToolbar");
        LinearLayout linearLayout = this.mDecorViewContainer;
        if (linearLayout != null) {
            linearLayout.setTranslationY(0.0f);
        }
        ICustomToolbar iCustomToolbar = this.mCustomToolbar;
        if (iCustomToolbar != null) {
            iCustomToolbar.removeCustomView(this.mVoiceRecordSimpleMenu.getView());
        }
        ViewGroup viewGroup = (ViewGroup) this.mVoiceRecordSimpleMenu.getView().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mVoiceRecordSimpleMenu.getView());
        }
        ICustomToolbar iCustomToolbar2 = this.mCustomToolbar;
        if (iCustomToolbar2 != null) {
            iCustomToolbar2.addCustomView(this.mVoiceRecordSimpleMenu.getView(), 8388613);
        }
        this.mVoiceRecordSimpleMenu.updateRecordBgSimpleView();
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateRecordingButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSimpleMenuToDecorView() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter3;
        Logger.m10999d(TAG, "addSimpleMenuToDecorView");
        LinearLayout linearLayout = this.mDecorViewContainer;
        if (linearLayout != null) {
            linearLayout.removeView(this.mVoiceRecordSimpleMenu.getView());
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter4 = this.mPresenter;
        if (voiceRecordMenuPresenter4 != null && voiceRecordMenuPresenter4.compareViewState(VoiceViewState.Type.HIDE) && (((voiceRecordMenuPresenter = this.mPresenter) != null && voiceRecordMenuPresenter.isFullScreenMode()) || (((voiceRecordMenuPresenter2 = this.mPresenter) != null && voiceRecordMenuPresenter2.isSearchMode()) || ((voiceRecordMenuPresenter3 = this.mPresenter) != null && voiceRecordMenuPresenter3.isInAppCollaborationMode())))) {
            LinearLayout linearLayout2 = this.mDecorViewContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter5 = this.mPresenter;
        if (voiceRecordMenuPresenter5 != null && voiceRecordMenuPresenter5.compareViewState(VoiceViewState.Type.NORMAL_PLAY)) {
            LinearLayout linearLayout3 = this.mDecorViewContainer;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
                return;
            }
            return;
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateRecordingButton();
        }
        updateMarginTopVoiceMenu();
        ViewGroup viewGroup = (ViewGroup) this.mVoiceRecordSimpleMenu.getView().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mVoiceRecordSimpleMenu.getView());
        }
        LinearLayout linearLayout4 = this.mDecorViewContainer;
        if (linearLayout4 != null) {
            linearLayout4.addView(this.mVoiceRecordSimpleMenu.getView());
        }
        LinearLayout linearLayout5 = this.mDecorViewContainer;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(0);
        }
        this.mVoiceRecordSimpleMenu.updateRecordBgDecorView();
    }

    private final void addVoiceSimpleMenu() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
        if (voiceRecordMenuPresenter2 == null || !voiceRecordMenuPresenter2.isCoedit() || (voiceRecordMenuPresenter = this.mPresenter) == null || voiceRecordMenuPresenter.getDataVoiceListSize() != 0) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
            if (voiceRecordMenuPresenter3 != null && voiceRecordMenuPresenter3.isPDFReader()) {
                return;
            }
        } else {
            this.mVoiceRecordSimpleMenu.hideAll();
        }
        ICustomToolbar iCustomToolbar = this.mCustomToolbar;
        if (iCustomToolbar == null || iCustomToolbar.getVisibility() != 0) {
            addSimpleMenuToDecorView();
        } else {
            addSimpleMenuToCustomToolbar();
        }
        ICustomToolbar iCustomToolbar2 = this.mCustomToolbar;
        if (iCustomToolbar2 != null) {
            iCustomToolbar2.setVisibilityChangedListener(new ICustomToolbar.VisibilityChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordMenuContainer.addVoiceSimpleMenu.1
                @Override // com.samsung.android.support.senl.nt.base.winset.view.toolbar.ICustomToolbar.VisibilityChangedListener
                public boolean isRecording() {
                    VoiceViewState.Type type = VoiceViewState.Type.RECORD;
                    VoiceRecordMenuPresenter voiceRecordMenuPresenter4 = VoiceRecordMenuContainer.this.mPresenter;
                    return type == (voiceRecordMenuPresenter4 != null ? voiceRecordMenuPresenter4.getViewStateType() : null);
                }

                @Override // com.samsung.android.support.senl.nt.base.winset.view.toolbar.ICustomToolbar.VisibilityChangedListener
                public void onVisibilityChanged(int visibility, boolean isShowing) {
                    VoiceRecordMenuPresenter voiceRecordMenuPresenter4 = VoiceRecordMenuContainer.this.mPresenter;
                    if (voiceRecordMenuPresenter4 == null) {
                        return;
                    }
                    if (voiceRecordMenuPresenter4.isSearchMode()) {
                        if (voiceRecordMenuPresenter4.getViewState().isShowingRecordingState()) {
                            VoiceRecordMenuContainer.this.mVoiceRecordSimpleMenu.onExpandMenuClick();
                        }
                        ICustomToolbar iCustomToolbar3 = VoiceRecordMenuContainer.this.mCustomToolbar;
                        if (iCustomToolbar3 != null) {
                            iCustomToolbar3.removeCustomView(VoiceRecordMenuContainer.this.mVoiceRecordSimpleMenu.getView());
                            return;
                        }
                        return;
                    }
                    if (visibility != 0 || !isShowing) {
                        ICustomToolbar iCustomToolbar4 = VoiceRecordMenuContainer.this.mCustomToolbar;
                        if (iCustomToolbar4 != null) {
                            iCustomToolbar4.removeCustomView(VoiceRecordMenuContainer.this.mVoiceRecordSimpleMenu.getView());
                        }
                        VoiceRecordMenuContainer.this.addSimpleMenuToDecorView();
                        return;
                    }
                    LinearLayout linearLayout = VoiceRecordMenuContainer.this.mDecorViewContainer;
                    if (linearLayout != null) {
                        linearLayout.removeView(VoiceRecordMenuContainer.this.mVoiceRecordSimpleMenu.getView());
                    }
                    VoiceRecordMenuContainer.this.addSimpleMenuToCustomToolbar();
                    LinearLayout linearLayout2 = VoiceRecordMenuContainer.this.mDecorViewContainer;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAudioEraser$lambda$1(VoiceRecordMenuContainer voiceRecordMenuContainer) {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        if (NotificationUtils.checkedNotificationPermissions(voiceRecordMenuContainer.mActivity, 137) && (voiceRecordMenuPresenter = voiceRecordMenuContainer.mPresenter) != null) {
            voiceRecordMenuPresenter.runAudioEraser();
        }
    }

    private final View getVoiceListView() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            return voiceRecordExpandMenu.getVoiceListView();
        }
        return null;
    }

    private final void hidePopupMenu() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.hidePopupMenu();
        }
    }

    private final void hideSpeedPopup() {
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.hideSpeedPopup();
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.hideSpeedPopup();
        }
    }

    private final void notifySTTItemChanged(int position) {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        STTPresenterImpl sTTPresenter;
        if (!FeatureInfo.isSupportSTTFunction() || (voiceRecordMenuPresenter = this.mPresenter) == null || (sTTPresenter = voiceRecordMenuPresenter.getSTTPresenter()) == null) {
            return;
        }
        sTTPresenter.notifySTTItemChanged(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSTTItemStateButtonClick$lambda$2(VoiceRecordMenuContainer voiceRecordMenuContainer, int i, String str, boolean z, int i2) {
        STTPresenterImpl sTTPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = voiceRecordMenuContainer.mPresenter;
        if (voiceRecordMenuPresenter == null || (sTTPresenter = voiceRecordMenuPresenter.getSTTPresenter()) == null) {
            return;
        }
        List<SpenVoiceData> voiceDataList = sTTPresenter.getVoiceDataList();
        if ((voiceDataList != null ? voiceDataList.size() : -1) > 0) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = voiceRecordMenuContainer.mPresenter;
            if (voiceRecordMenuPresenter2 != null) {
                voiceRecordMenuPresenter2.hideRecordingListView();
            }
            sTTPresenter.setItemIndexPreShowSearch(sTTPresenter.getMItemIndexToShow());
            sTTPresenter.setIndexItemToShow(i);
            sTTPresenter.setTranscribeFromType(2);
            STTTabletWindow sTTTabletWindow = voiceRecordMenuContainer.mSTTWindow;
            if (sTTTabletWindow != null) {
                sTTTabletWindow.show(str, z, i2);
            }
            ComposerSA.insertLog("815", STTConstant.EVENT_TRANSCRIBE, "b");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSTTItemStateButtonClick$lambda$3(VoiceRecordMenuContainer voiceRecordMenuContainer, int i) {
        STTPresenterImpl sTTPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = voiceRecordMenuContainer.mPresenter;
        if (voiceRecordMenuPresenter2 == null || (sTTPresenter = voiceRecordMenuPresenter2.getSTTPresenter()) == null) {
            return;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = voiceRecordMenuContainer.mPresenter;
        if (voiceRecordMenuPresenter3 != null) {
            voiceRecordMenuPresenter3.hideRecordingListView();
        }
        boolean z = sTTPresenter.getMItemIndexToShow() != i;
        sTTPresenter.setIndexItemToShow(i);
        sTTPresenter.setTranscribeFromType(2);
        if ((Features.isAutoTranscribeEnable() && sTTPresenter.isAutoTranscribeItemRunning()) || (((voiceRecordMenuPresenter = voiceRecordMenuContainer.mPresenter) == null || !voiceRecordMenuPresenter.isVoiceDataItemSTTConverted(i)) && !sTTPresenter.isItemSTTConverting(i))) {
            sTTPresenter.onSTTItemConvertClick(i);
            ComposerSA.insertLog("815", STTConstant.EVENT_TRANSCRIBE, "a");
            return;
        }
        if (z) {
            sTTPresenter.setMode(STTMode.REPLAY);
        }
        STTTabletWindow sTTTabletWindow = voiceRecordMenuContainer.mSTTWindow;
        if (sTTTabletWindow != null) {
            sTTTabletWindow.show();
        }
        ComposerSA.insertLog("815", STTConstant.EVENT_TRANSCRIBE, "b");
    }

    private final void updateMarginTopVoiceMenu() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter == null || !voiceRecordMenuPresenter.isInAppCollaborationMode()) {
            LinearLayout linearLayout = this.mDecorViewContainer;
            if (linearLayout != null) {
                linearLayout.setTranslationY(0.0f);
            }
        } else {
            LinearLayout linearLayout2 = this.mDecorViewContainer;
            if (linearLayout2 != null) {
                linearLayout2.setTranslationY(22.0f);
            }
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
        if (voiceRecordMenuPresenter2 == null || !voiceRecordMenuPresenter2.compareViewState(VoiceViewState.Type.RECORD)) {
            updateParamVoiceMenu(false);
        } else {
            updateParamVoiceMenu(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateParamVoiceMenu(boolean isWrapContent) {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        float dimension;
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        LinearLayout linearLayout = this.mDecorViewContainer;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) (linearLayout != null ? linearLayout.getLayoutParams() : null);
        int i = -2;
        if (isWrapContent) {
            if (layoutParams != null) {
                layoutParams.height = -2;
            }
            if (layoutParams != null) {
                layoutParams.width = -2;
            }
        } else {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
            if (voiceRecordMenuPresenter2 == null || !voiceRecordMenuPresenter2.isInAppCollaborationMode()) {
                VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
                if ((voiceRecordMenuPresenter3 != null && voiceRecordMenuPresenter3.isFullScreenMode()) || ((voiceRecordMenuPresenter = this.mPresenter) != null && voiceRecordMenuPresenter.isSearchMode())) {
                    dimension = activity.getResources().getDimension(C9086R.dimen.comp_full_screen_btn_size);
                }
                if (layoutParams != null) {
                    layoutParams.width = i;
                }
                if (layoutParams != null) {
                    layoutParams.height = i;
                }
            } else {
                dimension = activity.getResources().getDimension(C9086R.dimen.voice_recording_fullsceen_toggle_selected_size);
            }
            i = (int) dimension;
            if (layoutParams != null) {
            }
            if (layoutParams != null) {
            }
        }
        LinearLayout linearLayout2 = this.mDecorViewContainer;
        if (linearLayout2 != null) {
            linearLayout2.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout3 = this.mDecorViewContainer;
        if (linearLayout3 != null) {
            linearLayout3.requestLayout();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void changeMode(boolean isEditMode, @NotNull VoiceViewState viewState) {
        VoiceRecordExpandMenu voiceRecordExpandMenu;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        if (!viewState.isShowingRecordingState() || (voiceRecordExpandMenu = this.mVoiceRecordExpandMenu) == null) {
            return;
        }
        voiceRecordExpandMenu.changeMode(isEditMode);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void clearSearchComposer() {
        STTTabletWindow sTTTabletWindow = this.mSTTWindow;
        if (sTTTabletWindow != null) {
            sTTTabletWindow.clearSearchComposer();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void executeAudioEraser() {
        AiCommonUtil.executeAudioEraserAction(this.mActivity, new RunnableC9767a(this, 18));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void expandRecordingListVerticalMenu() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.expandVerticalMenu();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void hideAllView() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            VoiceRecordExpandMenu.hide$default(voiceRecordExpandMenu, false, 1, null);
        }
        this.mVoiceRecordSimpleMenu.setRecordTime(VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, 0, false, 2, null));
        this.mVoiceRecordSimpleMenu.showOnlyRecordButton();
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.hide();
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.setViewStateType(VoiceViewState.Type.HIDE);
        }
        addVoiceSimpleMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void hideAudioPlayView() {
        List<VoiceMenuItem> itemList;
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.hideAudioPlayView();
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter == null || (itemList = voiceRecordMenuPresenter.getItemList()) == null || itemList.isEmpty()) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
            if (voiceRecordMenuPresenter2 != null) {
                voiceRecordMenuPresenter2.setViewStateType(VoiceViewState.Type.HIDE);
            }
        } else {
            this.mVoiceRecordSimpleMenu.show(false);
            VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
            VoiceViewState.Type previousViewStateType = voiceRecordMenuPresenter3 != null ? voiceRecordMenuPresenter3.getPreviousViewStateType() : null;
            VoiceViewState.Type type = VoiceViewState.Type.VOICEINIT_MINIMIZED;
            if (previousViewStateType == type) {
                VoiceRecordMenuPresenter voiceRecordMenuPresenter4 = this.mPresenter;
                if (voiceRecordMenuPresenter4 != null) {
                    voiceRecordMenuPresenter4.setViewStateType(type);
                }
            } else {
                VoiceRecordMenuPresenter voiceRecordMenuPresenter5 = this.mPresenter;
                if (voiceRecordMenuPresenter5 != null) {
                    voiceRecordMenuPresenter5.setViewStateType(VoiceViewState.Type.VOICEINIT);
                }
            }
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter6 = this.mPresenter;
        if (voiceRecordMenuPresenter6 != null) {
            voiceRecordMenuPresenter6.updateVoiceMenu();
        }
        addVoiceSimpleMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void hideEditTrashView() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.hideEditTrashView();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void hideRecordingListView() {
        VoiceRecordExpandMenu voiceRecordExpandMenu;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter == null || !voiceRecordMenuPresenter.isNeedShowList() || (voiceRecordExpandMenu = this.mVoiceRecordExpandMenu) == null) {
            return;
        }
        voiceRecordExpandMenu.collapseVerticalMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void hideSTTWindow() {
        STTTabletWindow sTTTabletWindow = this.mSTTWindow;
        if (sTTTabletWindow != null) {
            sTTTabletWindow.hide();
        }
    }

    public final void hideVoicePopupView() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.collapseVerticalMenu();
        }
        hidePopupMenu();
        hideSpeedPopup();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void initSTT(@Nullable View sttContainer) {
        if (this.mSTTWindow != null) {
            return;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        STTTabletWindow sTTTabletWindow = voiceRecordMenuPresenter != null ? new STTTabletWindow(voiceRecordMenuPresenter) : null;
        this.mSTTWindow = sTTTabletWindow;
        if (sTTTabletWindow != null) {
            sTTTabletWindow.init();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public boolean isLineVoiceLayout() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        return voiceRecordExpandMenu != null && voiceRecordExpandMenu.isLineVoiceLayout();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    @Nullable
    public Boolean isShowingAiResultView() {
        STTTabletWindow sTTTabletWindow = this.mSTTWindow;
        if (sTTTabletWindow != null) {
            return Boolean.valueOf(sTTTabletWindow.isShowingState());
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void notifyDataChanged() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.notifyDataChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void notifyItemChanged(int position) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.notifyItemChanged(position);
        }
        notifySTTItemChanged(position);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void notifyItemInserted(int position) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.notifyItemInserted(position);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void notifyItemRemoved(int position) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.notifyItemRemoved(position);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void onConfigurationChanged() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter == null) {
            return;
        }
        VoiceViewState.Type viewStateType = voiceRecordMenuPresenter.getViewStateType();
        ArrayList arrayList = new ArrayList(voiceRecordMenuPresenter.getSelectedVoiceList());
        voiceRecordMenuPresenter.setNeedHideDialog(false);
        hideVoicePopupView();
        ViewGroup viewGroup = (ViewGroup) this.mContainerParent;
        if (viewGroup != null) {
            viewGroup.removeView(this.mContainer);
        }
        Activity activity = this.mActivity;
        this.mContainerParent = activity != null ? activity.findViewById(C9086R.id.voice_record_menu_container_parent) : null;
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(C9086R.layout.comp_voice_record_menu_container, (ViewGroup) null);
        this.mContainer = viewInflate;
        if (viewInflate != null) {
            viewInflate.setId(C9086R.id.voice_record_menu_container);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, C9086R.id.toolbar_divider);
        View view = this.mContainer;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mContainerParent;
        if (viewGroup2 != null) {
            viewGroup2.addView(this.mContainer);
        }
        this.mVoiceAnimation = new VoiceAnimation(this.mVoiceRecordSimpleMenu);
        this.mVoiceRecordPlayMenu = new VoiceRecordPlayMenu(this.mActivity, voiceRecordMenuPresenter, this.mContainer);
        this.mVoiceRecordExpandMenu = new VoiceRecordExpandMenu(this.mActivity, voiceRecordMenuPresenter, this.mContainer, this.mVoiceAnimation);
        View view2 = this.mContainer;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        voiceRecordMenuPresenter.setViewStateType(viewStateType);
        voiceRecordMenuPresenter.updateSelectedVoiceList(arrayList);
        voiceRecordMenuPresenter.updateVoiceMenu();
        if (viewStateType == VoiceViewState.Type.EDIT && voiceRecordMenuPresenter.getMNeedHideDialog()) {
            voiceRecordMenuPresenter.updateDialogFragment(getVoiceListView());
        }
        voiceRecordMenuPresenter.setNeedHideDialog(true);
        VoiceRecordMenuContract.IView.DefaultImpls.updateBackground$default(this, voiceRecordMenuPresenter.getBackgroundColor(), voiceRecordMenuPresenter.isBackgroundColorInverted(), voiceRecordMenuPresenter.hasBackgroundImage(), false, 8, null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void onSTTItemStateButtonClick(int index, @NotNull String keySearch, boolean isFromBackward, int indexCurrentSearchSTT) {
        Intrinsics.checkNotNullParameter(keySearch, "keySearch");
        AiCommonUtil.executeActionByOndevice(this.mActivity, new RunnableC10887m(this, index, keySearch, isFromBackward, indexCurrentSearchSTT));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void onUpdateListVoiceBtnState(boolean isEnabled) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.onUpdateListVoiceBtnState(isEnabled);
        }
    }

    public final void release() {
        this.mContainer = null;
        this.mContainerParent = null;
        releaseAudioEraser();
        this.mVoiceRecordExpandMenu = null;
        this.mVoiceRecordPlayMenu = null;
        ICustomToolbar iCustomToolbar = this.mCustomToolbar;
        if (iCustomToolbar != null) {
            if (iCustomToolbar != null) {
                iCustomToolbar.setVisibilityChangedListener(null);
            }
            this.mCustomToolbar = null;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter != null) {
            if (voiceRecordMenuPresenter != null) {
                voiceRecordMenuPresenter.onDetachView();
            }
            this.mPresenter = null;
        }
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void releaseAudioEraser() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.releaseAudioEraser();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void search(@NotNull String keySearch, boolean isFromBackward) {
        Intrinsics.checkNotNullParameter(keySearch, "keySearch");
        STTTabletWindow sTTTabletWindow = this.mSTTWindow;
        if (sTTTabletWindow != null) {
            sTTTabletWindow.search(keySearch, isFromBackward);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setItemSelectedMode(boolean selectedMode) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.setItemSelectedMode(selectedMode);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setPlayPauseIcon(boolean isPlay) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.setPlayPauseIcon(isPlay);
        }
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.setPlayPauseIcon(isPlay);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setPlaySpeed(@NotNull String speed) {
        Intrinsics.checkNotNullParameter(speed, "speed");
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter == null || !voiceRecordMenuPresenter.isShowingRecordingMenu()) {
            VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
            if (voiceRecordPlayMenu != null) {
                voiceRecordPlayMenu.setPlaySpeed(speed);
                return;
            }
            return;
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.setPlaySpeed(speed);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setPlayTime(@NotNull String time) {
        Intrinsics.checkNotNullParameter(time, "time");
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.setPlayTime(time);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setProgress(int progress) {
        VoiceRecordExpandMenu voiceRecordExpandMenu;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter != null && voiceRecordMenuPresenter.compareViewState(VoiceViewState.Type.NORMAL_PLAY)) {
            VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
            if (voiceRecordPlayMenu != null) {
                voiceRecordPlayMenu.setPlayProgress(progress);
                return;
            }
            return;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
        if (voiceRecordMenuPresenter2 == null || !voiceRecordMenuPresenter2.isShowingRecordingMenu() || (voiceRecordExpandMenu = this.mVoiceRecordExpandMenu) == null) {
            return;
        }
        voiceRecordExpandMenu.setRecordProgress(progress);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setRecordTime(@NotNull String time, @NotNull VoiceViewState.Type type) {
        VoiceRecordExpandMenu voiceRecordExpandMenu;
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(type, "type");
        if (new VoiceViewState(type).isShowingRecordingState() && (voiceRecordExpandMenu = this.mVoiceRecordExpandMenu) != null) {
            voiceRecordExpandMenu.setRecordPlayTime(time);
        }
        this.mVoiceRecordSimpleMenu.setRecordTime(time);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setRecordingTime(@NotNull String time) {
        VoiceViewState viewState;
        Intrinsics.checkNotNullParameter(time, "time");
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter == null || (viewState = voiceRecordMenuPresenter.getViewState()) == null || viewState.canUpdateRecordingTime()) {
            this.mVoiceRecordSimpleMenu.setRecordTime(time);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void setTotalRecordTime(@NotNull String time) {
        Intrinsics.checkNotNullParameter(time, "time");
        this.mVoiceRecordSimpleMenu.setRecordTime(time);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showAudioPlayView(int maxProgress, int time, boolean isPlay) {
        this.mVoiceRecordSimpleMenu.hideAll();
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            VoiceRecordExpandMenu.hide$default(voiceRecordExpandMenu, false, 1, null);
        }
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.setPlayPauseIcon(isPlay);
        }
        VoiceRecordPlayMenu voiceRecordPlayMenu2 = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu2 != null) {
            voiceRecordPlayMenu2.setPlayTime(VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, time / 1000, false, 2, null));
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.setViewStateType(VoiceViewState.Type.NORMAL_PLAY);
        }
        VoiceRecordPlayMenu voiceRecordPlayMenu3 = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu3 != null) {
            voiceRecordPlayMenu3.showAudioPlayView(maxProgress);
        }
        VoiceRecordPlayMenu voiceRecordPlayMenu4 = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu4 != null) {
            voiceRecordPlayMenu4.setPlayProgress(time);
        }
        addVoiceSimpleMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showEditView(boolean selectedMode, int selectedItem) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.showEditView(selectedMode, selectedItem);
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.setViewStateType(VoiceViewState.Type.EDIT);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showInitView(boolean isPlay, boolean runWithAnimation) {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        VoiceViewState.Type viewStateType = voiceRecordMenuPresenter != null ? voiceRecordMenuPresenter.getViewStateType() : null;
        VoiceViewState.Type type = VoiceViewState.Type.VOICEINIT_MINIMIZED;
        if (viewStateType == type || viewStateType == VoiceViewState.Type.RECORD_MINIMIZED) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
            if (voiceRecordMenuPresenter2 != null) {
                voiceRecordMenuPresenter2.setViewStateType(type);
            }
        } else {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
            if (voiceRecordMenuPresenter3 != null) {
                voiceRecordMenuPresenter3.setViewStateType(VoiceViewState.Type.VOICEINIT);
            }
        }
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.hide();
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.hide(runWithAnimation);
        }
        this.mVoiceRecordSimpleMenu.show(isPlay);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showRecordSimpleMenu(boolean isPlay) {
        this.mVoiceRecordSimpleMenu.show(isPlay);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showRecordingPlayView(boolean isPlay, int progress, boolean isHidePrevViews, int selectedItem) {
        VoiceRecordExpandMenu voiceRecordExpandMenu;
        VoiceRecordPlayMenu voiceRecordPlayMenu;
        if (isHidePrevViews && (voiceRecordPlayMenu = this.mVoiceRecordPlayMenu) != null) {
            voiceRecordPlayMenu.hide();
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu2 = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu2 != null) {
            voiceRecordExpandMenu2.showRecordingPlayView();
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu3 = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu3 != null) {
            voiceRecordExpandMenu3.setPlayPauseIcon(isPlay);
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu4 = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu4 != null) {
            voiceRecordExpandMenu4.setRecordProgress(progress);
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu5 = this.mVoiceRecordExpandMenu;
        boolean z = false;
        if (voiceRecordExpandMenu5 != null) {
            voiceRecordExpandMenu5.setRecordPlayTime(VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, progress / 1000, false, 2, null));
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.setPlaySpeed();
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
        VoiceViewState.Type previousViewStateType = voiceRecordMenuPresenter2 != null ? voiceRecordMenuPresenter2.getPreviousViewStateType() : null;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
        if (voiceRecordMenuPresenter3 != null) {
            voiceRecordMenuPresenter3.setViewStateType(VoiceViewState.Type.EXTEND);
        }
        VoiceViewState.Type type = VoiceViewState.Type.LIST;
        if (previousViewStateType == type) {
            VoiceRecordExpandMenu voiceRecordExpandMenu6 = this.mVoiceRecordExpandMenu;
            if (voiceRecordExpandMenu6 != null) {
                voiceRecordExpandMenu6.showRecordingListView();
            }
            VoiceRecordMenuPresenter voiceRecordMenuPresenter4 = this.mPresenter;
            if (voiceRecordMenuPresenter4 != null) {
                voiceRecordMenuPresenter4.setViewStateType(type);
            }
        } else {
            VoiceViewState.Type type2 = VoiceViewState.Type.EDIT;
            if (previousViewStateType == type2) {
                VoiceRecordExpandMenu voiceRecordExpandMenu7 = this.mVoiceRecordExpandMenu;
                if (voiceRecordExpandMenu7 != null) {
                    voiceRecordExpandMenu7.showRecordingListView();
                }
                VoiceRecordExpandMenu voiceRecordExpandMenu8 = this.mVoiceRecordExpandMenu;
                if (voiceRecordExpandMenu8 != null) {
                    voiceRecordExpandMenu8.showEditTrashView(selectedItem);
                }
                VoiceRecordMenuPresenter voiceRecordMenuPresenter5 = this.mPresenter;
                if (voiceRecordMenuPresenter5 != null) {
                    voiceRecordMenuPresenter5.setViewStateType(type2);
                }
            } else {
                VoiceRecordMenuPresenter voiceRecordMenuPresenter6 = this.mPresenter;
                if (voiceRecordMenuPresenter6 != null && voiceRecordMenuPresenter6.isNeedShowList() && (voiceRecordExpandMenu = this.mVoiceRecordExpandMenu) != null) {
                    voiceRecordExpandMenu.expandVerticalMenu();
                }
            }
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu9 = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu9 != null) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter7 = this.mPresenter;
            if (voiceRecordMenuPresenter7 != null && voiceRecordMenuPresenter7.isEditMode()) {
                z = true;
            }
            voiceRecordExpandMenu9.changeMode(z);
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu10 = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu10 != null) {
            voiceRecordExpandMenu10.updateProcessingLightEffect();
        }
        this.mVoiceRecordSimpleMenu.show(isPlay);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showRecordingView() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2;
        VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
        if (voiceRecordPlayMenu != null) {
            voiceRecordPlayMenu.hide();
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
        if (voiceRecordMenuPresenter3 != null) {
            voiceRecordMenuPresenter3.setViewStateType(VoiceViewState.Type.RECORD);
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter4 = this.mPresenter;
        if ((voiceRecordMenuPresenter4 != null && voiceRecordMenuPresenter4.isFullScreenMode()) || (((voiceRecordMenuPresenter = this.mPresenter) != null && voiceRecordMenuPresenter.isSearchMode()) || ((voiceRecordMenuPresenter2 = this.mPresenter) != null && voiceRecordMenuPresenter2.isInAppCollaborationMode()))) {
            updateParamVoiceMenu(true);
        }
        this.mVoiceRecordSimpleMenu.show(false);
        VoiceRecordSimpleMenu voiceRecordSimpleMenu = this.mVoiceRecordSimpleMenu;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter5 = this.mPresenter;
        voiceRecordSimpleMenu.setRecordTime(voiceRecordMenuPresenter5 != null ? voiceRecordMenuPresenter5.getRecordingTimeString() : null);
        addVoiceSimpleMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void showSTTWindow() {
        STTTabletWindow sTTTabletWindow = this.mSTTWindow;
        if (sTTTabletWindow != null) {
            sTTTabletWindow.show();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public boolean sttOnBackPressed() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        STTPresenterImpl sTTPresenter;
        if (!FeatureInfo.isSupportSTTFunction() || (voiceRecordMenuPresenter = this.mPresenter) == null || (sTTPresenter = voiceRecordMenuPresenter.getSTTPresenter()) == null) {
            return false;
        }
        if (sTTPresenter.isSelectionMode() || sTTPresenter.isSelectionSummaryMode()) {
            STTPresenter.toggleSTTSelectionMode$default(sTTPresenter, false, 1, null);
            return true;
        }
        if (sTTPresenter.getCurrentMode() == STTMode.SEARCH) {
            sTTPresenter.toggleSTTSearchMode();
            return true;
        }
        STTTabletWindow sTTTabletWindow = this.mSTTWindow;
        if (sTTTabletWindow != null && sTTTabletWindow.isEditMode()) {
            STTTabletWindow sTTTabletWindow2 = this.mSTTWindow;
            if (sTTTabletWindow2 != null) {
                sTTTabletWindow2.checkDataChanged();
            }
            return true;
        }
        STTTabletWindow sTTTabletWindow3 = this.mSTTWindow;
        if (sTTTabletWindow3 != null && !sTTTabletWindow3.isShowingState()) {
            return false;
        }
        STTTabletWindow sTTTabletWindow4 = this.mSTTWindow;
        if (sTTTabletWindow4 != null) {
            sTTTabletWindow4.hide();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public boolean toggleExpendVoicePanel() {
        VoiceViewState viewState;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        VoiceViewState.Type viewStateType = voiceRecordMenuPresenter != null ? voiceRecordMenuPresenter.getViewStateType() : null;
        Logger.m11003i(TAG, "toggleExpendVoicePanel# ViewStateType =" + viewStateType);
        if (viewStateType == VoiceViewState.Type.VOICEINIT) {
            updateParamVoiceMenu(false);
            VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
            if (voiceRecordExpandMenu != null) {
                return voiceRecordExpandMenu.expendMenuAnimation();
            }
            return false;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
        if (voiceRecordMenuPresenter2 != null && (viewState = voiceRecordMenuPresenter2.getViewState()) != null && viewState.isShowingRecordingState()) {
            updateParamVoiceMenu(false);
            VoiceRecordExpandMenu voiceRecordExpandMenu2 = this.mVoiceRecordExpandMenu;
            if (voiceRecordExpandMenu2 != null) {
                return voiceRecordExpandMenu2.collapseMenuAnimation();
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateAudioEraserAnimation(boolean isEnabled) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateAudioEraserAnimation(isEnabled);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateBackground(int color, boolean invert, boolean hasBackgroundImage, boolean updateDialog) {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2;
        Resources resources;
        Configuration configuration;
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        if (this.mContainerParent == null) {
            this.mContainerParent = activity != null ? activity.findViewById(C9086R.id.main_layout_container_parent) : null;
        }
        if (this.mContainerParent != null) {
            int[] backgroundThemeColorTable = BackgroundColorUtil.getBackgroundThemeColorTable(this.mActivity, color, invert, hasBackgroundImage);
            Activity activity2 = this.mActivity;
            boolean z = (activity2 == null || (resources = activity2.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
            VoiceRecordMenuPresenter voiceRecordMenuPresenter3 = this.mPresenter;
            if (voiceRecordMenuPresenter3 != null && voiceRecordMenuPresenter3.isTabletLayout() && z) {
                View view = this.mContainer;
                View view2 = (View) (view != null ? view.getParent() : null);
                this.mContainerParent = view2;
                if (view2 != null) {
                    view2.setBackgroundColor(backgroundThemeColorTable[0]);
                }
            } else {
                View view3 = this.mContainerParent;
                if (view3 != null) {
                    view3.setBackgroundColor(backgroundThemeColorTable[0]);
                }
            }
            VoiceRecordPlayMenu voiceRecordPlayMenu = this.mVoiceRecordPlayMenu;
            if (voiceRecordPlayMenu != null) {
                Intrinsics.checkNotNull(backgroundThemeColorTable);
                voiceRecordPlayMenu.updateBackground(backgroundThemeColorTable);
            }
            VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
            if (voiceRecordExpandMenu != null) {
                Intrinsics.checkNotNull(backgroundThemeColorTable);
                voiceRecordExpandMenu.updateBackground(backgroundThemeColorTable);
            }
            VoiceRecordSimpleMenu voiceRecordSimpleMenu = this.mVoiceRecordSimpleMenu;
            Intrinsics.checkNotNull(backgroundThemeColorTable);
            voiceRecordSimpleMenu.updateBackground(backgroundThemeColorTable);
            if (!updateDialog || (voiceRecordMenuPresenter = this.mPresenter) == null || !voiceRecordMenuPresenter.isTabletLayout() || (voiceRecordMenuPresenter2 = this.mPresenter) == null) {
                return;
            }
            voiceRecordMenuPresenter2.updateDialogFragment(getVoiceListView());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateRecording() {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateRecording();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateSTTShowItem(int position) {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mPresenter;
        STTPresenterImpl sTTPresenter = voiceRecordMenuPresenter != null ? voiceRecordMenuPresenter.getSTTPresenter() : null;
        if (sTTPresenter == null || sTTPresenter.isSTTEditMode() || sTTPresenter.isSelectionMode()) {
            return;
        }
        if (position == sTTPresenter.getMItemIndexToShow()) {
            Logger.m10999d(TAG, "updateSTTShowItem# skip replace stt view, same position");
            return;
        }
        if (sTTPresenter.getFloatingController().getIsShowingState()) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mPresenter;
            if ((voiceRecordMenuPresenter2 == null || !voiceRecordMenuPresenter2.isVoiceDataItemSTTConverted(position)) && !sTTPresenter.isItemSTTConverting(position)) {
                sTTPresenter.setIndexItemToShow(position);
                STTTabletWindow sTTTabletWindow = this.mSTTWindow;
                if (sTTTabletWindow != null) {
                    sTTTabletWindow.showHelpView(position);
                    return;
                }
                return;
            }
            sTTPresenter.setIndexItemToShow(position);
            STTTabletWindow sTTTabletWindow2 = this.mSTTWindow;
            if (sTTTabletWindow2 != null) {
                sTTTabletWindow2.show();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateSelectedItemMenu(int selectedItem) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateSelectedItemText(selectedItem);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateStatusAnimation(boolean isAnimation) {
        this.mVoiceRecordSimpleMenu.updateStatusAnimation(isAnimation);
    }

    public final void updateView() {
        STTTabletWindow sTTTabletWindow;
        this.mVoiceRecordSimpleMenu.updateView();
        if (FeatureInfo.isSupportSTTFunction() && (sTTTabletWindow = this.mSTTWindow) != null) {
            sTTTabletWindow.hide();
        }
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateView();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void updateViewForEraser(boolean needUpdateAnimation) {
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.updateViewEraser(needUpdateAnimation);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IView
    public void onSTTItemStateButtonClick(int index) {
        Logger.m10999d(TAG, "onSTTItemStateButtonClick#");
        AiCommonUtil.executeActionByOndevice(this.mActivity, new RunnableC0050f(this, index, 22));
        VoiceRecordExpandMenu voiceRecordExpandMenu = this.mVoiceRecordExpandMenu;
        if (voiceRecordExpandMenu != null) {
            voiceRecordExpandMenu.hideBadge();
        }
    }
}

package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.pen.setting.C7522c;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceAnimation;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0010\b\u0000\u0018\u0000 ]2\u00020\u0001:\u0001]B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\u0006\u0010%\u001a\u00020\u001cJ\b\u0010&\u001a\u00020\u001cH\u0002J\u0006\u0010'\u001a\u00020\u001cJ\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020\u001cH\u0002J\u0006\u0010+\u001a\u00020\u001cJ\u0006\u0010,\u001a\u00020\u001cJ\u0006\u0010-\u001a\u00020\u001cJ\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u000e\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001aJ\u0006\u00102\u001a\u00020\u001cJ\u000e\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u001c2\u0006\u00104\u001a\u000205J\u000e\u00107\u001a\u00020\u001c2\u0006\u00104\u001a\u000205J\b\u00108\u001a\u00020\u001cH\u0002J\u0006\u00109\u001a\u00020\u001cJ\b\u0010:\u001a\u00020\u001cH\u0002J\u000e\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u000205J\u0010\u0010=\u001a\u00020\u001c2\b\u0010>\u001a\u0004\u0018\u00010?J\u0010\u0010@\u001a\u00020\u001c2\b\u0010A\u001a\u0004\u0018\u00010?J\u0010\u0010B\u001a\u00020\u001c2\b\b\u0002\u0010C\u001a\u00020\u001aJ\u0006\u0010D\u001a\u00020\u001aJ\u0006\u0010E\u001a\u00020\u001aJ\u000e\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u001aJ\u0006\u0010H\u001a\u00020\u001cJ\u000e\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u000205J\u0006\u0010K\u001a\u00020\u001cJ\u000e\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001aJ\u000e\u0010Q\u001a\u00020\u001c2\u0006\u0010J\u001a\u000205J\u0016\u0010R\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001a2\u0006\u0010J\u001a\u000205J\b\u0010S\u001a\u0004\u0018\u00010\u0007J\u000e\u0010T\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aJ\u000e\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\u001aJ\u0006\u0010W\u001a\u00020\u001cJ\u0006\u0010X\u001a\u00020\u001cJ\u0006\u0010Y\u001a\u00020\u001cJ\u000e\u0010Z\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010[\u001a\u00020\u001cJ\u0006\u0010\\\u001a\u00020\u001aR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandMenu;", "", "mActivity", "Landroid/app/Activity;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "parent", "Landroid/view/View;", "mVoiceAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation;)V", "mVoiceMenuList", "mCloseButton", "Landroid/widget/ImageView;", "mPlayPauseButton", "mRecordingButton", "mMenuDivider", "mFirstListButton", "mBadgeFirstListButton", "mPlayTimeView", "Landroid/widget/TextView;", "mMoreButton", "mVoiceSubMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandSubMenu;", "mIsTablet", "", "initMenuList", "", "updateMoreButton", "isEnabled", "updateFirstListDescription", "isLongText", "showPopUpMenu", "isUserSkip", "()Z", "hasNotUsedSTT", "hideBadge", "toggleVerticalMenu", "collapseVerticalMenu", "expandVerticalMenu", "reset", "initVoiceButton", "updateRecordingButton", "updateRecording", "updateView", "setMaxFontSize", "hideRecordingListView", "setPlayPauseIcon", "isPlay", "notifyDataChanged", "notifyItemRemoved", "position", "", "notifyItemChanged", "notifyItemInserted", "updatePlayPoint", "showRecordingPlayView", "showGuiTipSTT", "setRecordProgress", "progress", "setRecordPlayTime", "time", "", "setPlaySpeed", "speed", "hide", "runWithAnimation", "collapseMenuAnimation", "expendMenuAnimation", "changeMode", "isEditMode", "showRecordingListView", "showEditTrashView", "selectedItem", "hideEditTrashView", "updateBackground", "themeColor", "", "setItemSelectedMode", "selectedMode", "updateSelectedItemText", "showEditView", "getVoiceListView", "onUpdateListVoiceBtnState", "updateViewEraser", "needUpdateAnimation", "hideSpeedPopup", "releaseAudioEraser", "updateProcessingLightEffect", "updateAudioEraserAnimation", "hidePopupMenu", "isLineVoiceLayout", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordExpandMenu {

    @NotNull
    private static final String TAG;

    @Nullable
    private final Activity mActivity;

    @Nullable
    private View mBadgeFirstListButton;

    @Nullable
    private ImageView mCloseButton;

    @Nullable
    private ImageView mFirstListButton;
    private final boolean mIsTablet;

    @Nullable
    private ImageView mMenuDivider;

    @Nullable
    private ImageView mMoreButton;

    @Nullable
    private ImageView mPlayPauseButton;

    @Nullable
    private TextView mPlayTimeView;

    @NotNull
    private final VoiceRecordMenuPresenter mPresenter;

    @Nullable
    private ImageView mRecordingButton;

    @NotNull
    private final VoiceAnimation mVoiceAnimation;

    @Nullable
    private View mVoiceMenuList;

    @NotNull
    private final VoiceRecordExpandSubMenu mVoiceSubMenu;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordExpandMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordExpandMenu(@Nullable Activity activity, @NotNull VoiceRecordMenuPresenter mPresenter, @Nullable View view, @NotNull VoiceAnimation mVoiceAnimation) {
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        Intrinsics.checkNotNullParameter(mVoiceAnimation, "mVoiceAnimation");
        this.mActivity = activity;
        this.mPresenter = mPresenter;
        this.mVoiceAnimation = mVoiceAnimation;
        this.mIsTablet = mPresenter.isTabletLayout();
        initMenuList(view);
        initVoiceButton();
        setMaxFontSize();
        this.mVoiceSubMenu = new VoiceRecordExpandSubMenu(activity, mPresenter, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collapseMenuAnimation$lambda$10(VoiceRecordExpandMenu voiceRecordExpandMenu) {
        if (voiceRecordExpandMenu.mPresenter.isNotSupportedRecording()) {
            CoeditState.INSTANCE.setDisable(voiceRecordExpandMenu.mRecordingButton);
        }
        if (voiceRecordExpandMenu.mPresenter.isSupportAudioEraser()) {
            voiceRecordExpandMenu.mVoiceSubMenu.releaseAudioEraser();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit expendMenuAnimation$lambda$11(VoiceRecordExpandMenu voiceRecordExpandMenu) {
        if (voiceRecordExpandMenu.mPresenter.isNotSupportedRecording()) {
            CoeditState.INSTANCE.setDisable(voiceRecordExpandMenu.mRecordingButton);
        }
        return Unit.INSTANCE;
    }

    private final boolean hasNotUsedSTT() {
        if (FeatureInfo.isSupportSTTFunction()) {
            return SharedPreferencesCompat.INSTANCE.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_STT_USED_SMART_TIP_SHOWN, true);
        }
        return false;
    }

    public static /* synthetic */ void hide$default(VoiceRecordExpandMenu voiceRecordExpandMenu, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        voiceRecordExpandMenu.hide(z);
    }

    private final void hideRecordingListView() {
        this.mPresenter.setNeedShowList(false);
        this.mVoiceSubMenu.hideRecordingListView();
        this.mVoiceSubMenu.invalidateSeekBar();
        if (this.mPresenter.getViewState().canCollapseStraight()) {
            this.mPresenter.setViewStateType(VoiceViewState.Type.EXTEND);
            Logger.m10999d(TAG, "hideRecordingListView#.");
            showGuiTipSTT();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initMenuList(View parent) {
        View viewFindViewById = parent != null ? parent.findViewById(C9086R.id.voice_menu_expand_simple) : null;
        this.mVoiceMenuList = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnTouchListener(new ViewOnTouchListenerC7005f(18));
        }
        View view = this.mVoiceMenuList;
        ImageView imageView = view != null ? (ImageView) view.findViewById(C9086R.id.voice_record_close) : null;
        this.mCloseButton = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view2 = this.mVoiceMenuList;
        this.mBadgeFirstListButton = view2 != null ? view2.findViewById(C9086R.id.voice_first_list_new_badge) : null;
        View view3 = this.mVoiceMenuList;
        this.mPlayTimeView = view3 != null ? (TextView) view3.findViewById(C9086R.id.voice_record_first_play_time) : null;
        View view4 = this.mVoiceMenuList;
        this.mMenuDivider = view4 != null ? (ImageView) view4.findViewById(C9086R.id.voice_record_menu_divider) : null;
        View view5 = this.mVoiceMenuList;
        this.mFirstListButton = view5 != null ? (ImageView) view5.findViewById(C9086R.id.voice_record_first_list_button) : null;
        updateFirstListDescription((this.mPresenter.isShareOldNotebook() || this.mPresenter.isCoedit() || !hasNotUsedSTT()) ? false : true);
        ImageView imageView2 = this.mFirstListButton;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new ViewOnClickListenerC10879e(this, 0));
        }
        View view6 = this.mVoiceMenuList;
        ImageView imageView3 = view6 != null ? (ImageView) view6.findViewById(C9086R.id.voice_record_more_button) : null;
        this.mMoreButton = imageView3;
        if (imageView3 != null) {
            ViewCompat.INSTANCE.getInstance().setTooltipText(this.mMoreButton);
            ImageView imageView4 = this.mMoreButton;
            if (imageView4 != null) {
                imageView4.setOnClickListener(new ViewOnClickListenerC10879e(this, 1));
            }
        }
        View view7 = this.mVoiceMenuList;
        if (view7 != null) {
            view7.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initMenuList$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMenuList$lambda$1(VoiceRecordExpandMenu voiceRecordExpandMenu, View view) {
        if (voiceRecordExpandMenu.isUserSkip()) {
            voiceRecordExpandMenu.toggleVerticalMenu();
        }
    }

    private final void initVoiceButton() {
        View view = this.mVoiceMenuList;
        ImageView imageView = view != null ? (ImageView) view.findViewById(C9086R.id.voice_record_play_pause) : null;
        this.mPlayPauseButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new ViewOnClickListenerC10879e(this, 2));
        }
        View view2 = this.mVoiceMenuList;
        this.mRecordingButton = view2 != null ? (ImageView) view2.findViewById(C9086R.id.voice_record_recording) : null;
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mRecordingButton);
        ImageView imageView2 = this.mRecordingButton;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new ViewOnClickListenerC10879e(this, 3));
        }
        if (this.mPresenter.isNotSupportedRecording()) {
            CoeditState.INSTANCE.setDisable(this.mRecordingButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVoiceButton$lambda$7(VoiceRecordExpandMenu voiceRecordExpandMenu, View view) {
        if (voiceRecordExpandMenu.mPresenter.compareViewState(VoiceViewState.Type.EDIT)) {
            voiceRecordExpandMenu.mPresenter.cancelSelect(true);
            voiceRecordExpandMenu.hideEditTrashView();
        }
        voiceRecordExpandMenu.mPresenter.playPause(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVoiceButton$lambda$8(VoiceRecordExpandMenu voiceRecordExpandMenu, View view) {
        voiceRecordExpandMenu.updateRecording();
        ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_ADD_RECORDING);
    }

    private final boolean isUserSkip() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.VoiceRecorder;
        if (!UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            return false;
        }
        UserInputSkipper.setHoldingSingleActionEventTime(300L, tag);
        return true;
    }

    private final void setMaxFontSize() {
        Activity activity;
        if (this.mIsTablet || (activity = this.mActivity) == null) {
            return;
        }
        CharUtils.applyTextSizeUntilLargeSize(activity, this.mPlayTimeView, activity.getResources().getInteger(C9086R.integer.voice_record_text_size));
    }

    private final void showGuiTipSTT() {
        if (this.mPresenter.isShareOldNotebook() || this.mPresenter.isCoedit() || !hasNotUsedSTT()) {
            View view = this.mBadgeFirstListButton;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mBadgeFirstListButton;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPopUpMenu() {
        this.mPresenter.clearSelectionObject();
        PopupMenu popupMenu = new PopupMenu(this.mActivity, this.mMoreButton);
        popupMenu.inflate(C9086R.menu.composer_voice_more_button_menu);
        popupMenu.getMenu().removeItem(C9086R.id.action_close);
        if (!this.mPresenter.isSupportAudioEraser() || !this.mPresenter.isEnableAudioEraser()) {
            popupMenu.getMenu().removeItem(C9086R.id.action_speed);
        }
        popupMenu.setOnMenuItemClickListener(new C7522c(this, 2));
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showPopUpMenu$lambda$6(VoiceRecordExpandMenu voiceRecordExpandMenu, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C9086R.id.action_record) {
            voiceRecordExpandMenu.updateRecording();
            return false;
        }
        if (itemId == C9086R.id.action_list) {
            voiceRecordExpandMenu.toggleVerticalMenu();
            return false;
        }
        if (itemId != C9086R.id.action_speed) {
            return false;
        }
        voiceRecordExpandMenu.mVoiceSubMenu.showSpeedPopup(voiceRecordExpandMenu.mMoreButton);
        return false;
    }

    private final void toggleVerticalMenu() {
        if (this.mPresenter.compareViewState(VoiceViewState.Type.EXTEND)) {
            expandVerticalMenu();
        } else {
            collapseVerticalMenu();
        }
        this.mPresenter.clearSelectionObject();
    }

    private final void updateFirstListDescription(boolean isLongText) {
        if (isLongText) {
            Activity activity = this.mActivity;
            String string = activity != null ? activity.getString(C9086R.string.voice_menu_list) : null;
            Activity activity2 = this.mActivity;
            String string2 = activity2 != null ? activity2.getString(C9086R.string.string_comma) : null;
            Activity activity3 = this.mActivity;
            String strM2221l = AbstractC2821a.m2221l(string, string2, " ", activity3 != null ? activity3.getString(C9086R.string.badge_new_notification) : null);
            ImageView imageView = this.mFirstListButton;
            if (imageView != null) {
                imageView.setContentDescription(strM2221l);
            }
        } else {
            ImageView imageView2 = this.mFirstListButton;
            if (imageView2 != null) {
                Activity activity4 = this.mActivity;
                imageView2.setContentDescription(activity4 != null ? activity4.getString(C9086R.string.voice_menu_list) : null);
            }
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mFirstListButton);
    }

    private final void updateMoreButton(boolean isEnabled) {
        View viewFindViewById;
        if (this.mMoreButton == null) {
            return;
        }
        View view = this.mVoiceMenuList;
        ViewGroup.LayoutParams layoutParams = null;
        View viewFindViewById2 = view != null ? view.findViewById(C9086R.id.voice_record_speed) : null;
        View view2 = this.mVoiceMenuList;
        if (view2 != null && (viewFindViewById = view2.findViewById(C9086R.id.relativeLayout)) != null) {
            layoutParams = viewFindViewById.getLayoutParams();
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (!isEnabled) {
                ImageView imageView = this.mMoreButton;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setVisibility(0);
                }
                if (this.mActivity != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).setMarginStart(0);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.mMoreButton;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            if (!this.mPresenter.isSupportAudioEraser()) {
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setVisibility(0);
                }
                if (this.mActivity != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).setMarginStart(0);
                    return;
                }
                return;
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            Activity activity = this.mActivity;
            if (activity != null) {
                ((RelativeLayout.LayoutParams) layoutParams).setMarginStart(activity.getResources().getDimensionPixelSize(C9086R.dimen.voice_record_speed_button_margin_audio_eraser));
            }
        }
    }

    private final void updatePlayPoint() {
        this.mVoiceSubMenu.setPlayPoint(this.mPresenter.getVoiceDataPlayPoints());
        this.mVoiceSubMenu.updatePlayPoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRecording$lambda$9(Activity activity, String[] strArr) {
        Logger.m11004w(TAG, "to get RECORD_AUDIO permission");
        PermissionHelper.requestPermissions(activity, 113, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void changeMode(boolean isEditMode) {
        if (this.mMoreButton != null) {
            View view = this.mVoiceMenuList;
            View viewFindViewById = view != null ? view.findViewById(C9086R.id.voice_record_first_list_button_container) : null;
            if (isEditMode) {
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(8);
                }
                ImageView imageView = this.mMoreButton;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(0);
                }
                ImageView imageView2 = this.mMoreButton;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            ImageView imageView3 = this.mRecordingButton;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        } else if (isEditMode) {
            ImageView imageView4 = this.mRecordingButton;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
        } else {
            ImageView imageView5 = this.mRecordingButton;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
        }
        this.mVoiceSubMenu.changeMode(isEditMode);
    }

    public final boolean collapseMenuAnimation() {
        this.mPresenter.showInitView(true);
        VoiceAnimation voiceAnimation = this.mVoiceAnimation;
        Activity activity = this.mActivity;
        voiceAnimation.collapse(activity != null ? (ViewGroup) activity.findViewById(C9086R.id.main_container) : null, this.mVoiceMenuList, this.mIsTablet, new C10878d(this, 1));
        hideRecordingListView();
        return true;
    }

    public final void collapseVerticalMenu() {
        if (this.mPresenter.compareViewState(VoiceViewState.Type.EDIT)) {
            this.mPresenter.cancelSelect(false);
            this.mVoiceSubMenu.hideEditTrashView();
        }
        if (this.mPresenter.compareViewState(VoiceViewState.Type.NORMAL_PLAY)) {
            return;
        }
        hideRecordingListView();
    }

    public final void expandVerticalMenu() {
        this.mPresenter.hideKeyBoard();
        showRecordingListView();
        if (this.mPresenter.getSelectMode()) {
            showEditTrashView(this.mPresenter.getSelectListSize());
        }
        if (this.mPresenter.isEditMode()) {
            ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_LIST);
        } else {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_VIEW_303, ComposerSAConstants.EVENT_VOICE_VIEW_PANEL_LIST);
        }
    }

    public final boolean expendMenuAnimation() {
        VoiceAnimation voiceAnimation = this.mVoiceAnimation;
        Activity activity = this.mActivity;
        voiceAnimation.expand(activity != null ? (ViewGroup) activity.findViewById(C9086R.id.main_container) : null, this.mIsTablet, new C10878d(this, 0));
        this.mPresenter.showRecordingPlayView(false);
        return true;
    }

    @Nullable
    public final View getVoiceListView() {
        View contentView;
        PopupWindow popup = this.mVoiceSubMenu.getPopup();
        if (popup == null || (contentView = popup.getContentView()) == null) {
            return null;
        }
        return contentView.findViewById(C9086R.id.voice_record_list_container);
    }

    public final void hide(boolean runWithAnimation) {
        hideRecordingListView();
        View view = this.mVoiceMenuList;
        if (view != null) {
            view.setVisibility(8);
        }
        if (runWithAnimation || !this.mPresenter.isSupportAudioEraser()) {
            return;
        }
        this.mVoiceSubMenu.releaseAudioEraser();
    }

    public final void hideBadge() {
        if (this.mBadgeFirstListButton == null || hasNotUsedSTT()) {
            return;
        }
        View view = this.mBadgeFirstListButton;
        if (view != null) {
            view.setVisibility(8);
        }
        this.mVoiceSubMenu.hideBadge();
        updateFirstListDescription(false);
    }

    public final void hideEditTrashView() {
        this.mVoiceSubMenu.hideEditTrashView();
    }

    public final void hidePopupMenu() {
        this.mVoiceSubMenu.hidePopUpMenu();
    }

    public final void hideSpeedPopup() {
        this.mVoiceSubMenu.hideSpeedPopup();
    }

    public final boolean isLineVoiceLayout() {
        View view = this.mVoiceMenuList;
        return (view != null ? view.findViewById(C9086R.id.voice_record_second_menu_line) : null) == null;
    }

    public final void notifyDataChanged() {
        this.mVoiceSubMenu.notifyDataSetChanged();
        updatePlayPoint();
    }

    public final void notifyItemChanged(int position) {
        this.mVoiceSubMenu.notifyItemChanged(position);
    }

    public final void notifyItemInserted(int position) {
        this.mVoiceSubMenu.notifyItemInserted(position);
    }

    public final void notifyItemRemoved(int position) {
        this.mVoiceSubMenu.notifyItemRemoved(position);
        updatePlayPoint();
        Activity activity = this.mActivity;
        this.mVoiceAnimation.playListChangeBounds(activity != null ? (ViewGroup) activity.findViewById(C9086R.id.main_layout_container_parent) : null);
    }

    public final void onUpdateListVoiceBtnState(boolean isEnabled) {
        ImageView imageView = this.mFirstListButton;
        if (imageView != null) {
            imageView.setEnabled(isEnabled);
        }
        ImageView imageView2 = this.mFirstListButton;
        if (imageView2 != null) {
            imageView2.setAlpha(isEnabled ? 1.0f : 0.4f);
        }
    }

    public final void releaseAudioEraser() {
        this.mVoiceSubMenu.releaseAudioEraser();
    }

    public final void reset() {
        if (this.mPresenter.compareViewState(VoiceViewState.Type.EDIT)) {
            this.mPresenter.cancelSelect(false);
        }
        this.mPresenter.collapseSyncPlayDisable();
        this.mPresenter.clearSelectionObject();
    }

    public final void setItemSelectedMode(boolean selectedMode) {
        this.mVoiceSubMenu.setVoiceItemSelectMode(selectedMode);
    }

    public final void setPlayPauseIcon(boolean isPlay) {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        Resources resources = activity.getResources();
        if (isPlay) {
            ImageView imageView = this.mPlayPauseButton;
            if (imageView != null) {
                imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, C9086R.drawable.voice_record_pause, this.mActivity.getTheme()));
            }
            ImageView imageView2 = this.mPlayPauseButton;
            if (imageView2 != null) {
                imageView2.setContentDescription(resources.getString(C9086R.string.voice_notification_voice_ass_pause));
            }
        } else {
            ImageView imageView3 = this.mPlayPauseButton;
            if (imageView3 != null) {
                imageView3.setImageDrawable(ResourcesCompat.getDrawable(resources, C9086R.drawable.voice_record_play, this.mActivity.getTheme()));
            }
            ImageView imageView4 = this.mPlayPauseButton;
            if (imageView4 != null) {
                imageView4.setContentDescription(resources.getString(C9086R.string.voice_notification_voice_ass_play));
            }
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mPlayPauseButton);
    }

    public final void setPlaySpeed(@Nullable String speed) {
        this.mVoiceSubMenu.setPlaySpeed(speed);
    }

    public final void setRecordPlayTime(@Nullable String time) {
        if (this.mVoiceSubMenu.getMIsStartTrack()) {
            return;
        }
        if (!this.mIsTablet) {
            VoiceUtil.INSTANCE.updateTimeEms(this.mPlayTimeView, time);
        }
        this.mVoiceSubMenu.setRecordPlayTime(time);
    }

    public final void setRecordProgress(int progress) {
        this.mVoiceSubMenu.setPlayProgress(progress);
    }

    public final void showEditTrashView(int selectedItem) {
        this.mVoiceSubMenu.showEditTrashView(selectedItem);
    }

    public final void showEditView(boolean selectedMode, int selectedItem) {
        this.mVoiceSubMenu.showEditView(selectedMode, selectedItem);
    }

    public final void showRecordingListView() {
        TextView textView;
        if (!this.mIsTablet && (textView = this.mPlayTimeView) != null) {
            textView.setVisibility(8);
        }
        this.mPresenter.setNeedShowList(true);
        this.mVoiceSubMenu.showRecordingListView();
        this.mVoiceSubMenu.setPlayPoint(this.mPresenter.getVoiceDataPlayPoints());
        this.mVoiceSubMenu.invalidateSeekBar();
        this.mPresenter.setViewStateType(VoiceViewState.Type.LIST);
        View view = this.mBadgeFirstListButton;
        if (view == null || view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void showRecordingPlayView() {
        Logger.m10999d(TAG, "showRecordingPlayView#.");
        View view = this.mVoiceMenuList;
        if (view != null) {
            view.setVisibility(0);
        }
        this.mVoiceSubMenu.setPlayPoint(this.mPresenter.getVoiceDataPlayPoints());
        this.mVoiceSubMenu.initRecordingList();
        notifyDataChanged();
        int[] backgroundThemeColorTable = this.mPresenter.getBackgroundThemeColorTable();
        this.mVoiceSubMenu.setTheme(backgroundThemeColorTable[0], backgroundThemeColorTable[2] == 1);
        this.mPresenter.setViewStateType(VoiceViewState.Type.EXTEND);
        updateMoreButton(this.mPresenter.isEnableAudioEraser());
        this.mVoiceSubMenu.showRecordingPlayView();
        showGuiTipSTT();
    }

    public final void updateAudioEraserAnimation(boolean isEnabled) {
        this.mVoiceSubMenu.updateAudioEraserAnimation(isEnabled);
    }

    public final void updateBackground(@NotNull int[] themeColor) {
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        boolean z = themeColor[2] == 1;
        int alphaComponent = ColorUtils.setAlphaComponent(themeColor[1], 230);
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        int iCompositeColors = ColorUtils.compositeColors(ContextCompat.getColor(activity, C9086R.color.composer_voice_menu_composite_alpha_background), this.mPresenter.getBackgroundColor());
        int color = ContextCompat.getColor(this.mActivity, C9086R.color.composer_voice_menu_item_divider);
        int color2 = ContextCompat.getColor(this.mActivity, C9086R.color.composer_voice_menu_border_button_color);
        if (z) {
            color2 = ContextCompat.getColor(this.mActivity, C9086R.color.composer_voice_menu_dark_border_button_color);
            iCompositeColors = ContextCompat.getColor(this.mActivity, C9086R.color.composer_voice_menu_dark_background);
            if (ContextUtils.isNightMode(this.mActivity)) {
                iCompositeColors = FloatingFeature.INSTANCE.getAntiGreenishColor();
            }
            color = ContextCompat.getColor(this.mActivity, C9086R.color.composer_voice_menu_dark_item_divider);
        }
        int i = color2;
        int i2 = iCompositeColors;
        int i4 = color;
        ImageView imageView = this.mPlayPauseButton;
        if (imageView != null) {
            imageView.setColorFilter(alphaComponent);
        }
        ImageView imageView2 = this.mCloseButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(alphaComponent);
        }
        ImageView imageView3 = this.mFirstListButton;
        if (imageView3 != null) {
            imageView3.setColorFilter(alphaComponent);
        }
        ImageView imageView4 = this.mMoreButton;
        if (imageView4 != null) {
            imageView4.setColorFilter(alphaComponent);
        }
        this.mVoiceSubMenu.setTheme(themeColor[0], z);
        this.mVoiceSubMenu.invalidateSeekBar();
        if (!this.mIsTablet) {
            if (this.mActivity.getResources().getConfiguration().orientation == 1) {
                ImageView imageView5 = this.mPlayPauseButton;
                Drawable foreground = imageView5 != null ? imageView5.getForeground() : null;
                GradientDrawable gradientDrawable = foreground instanceof GradientDrawable ? (GradientDrawable) foreground : null;
                if (gradientDrawable != null) {
                    gradientDrawable.setStroke(this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_divider_height), i);
                }
            }
            TextView textView = this.mPlayTimeView;
            if (textView != null) {
                textView.setTextColor(alphaComponent);
            }
        }
        this.mVoiceSubMenu.updateBackground(alphaComponent, i2, i4, z, themeColor);
        ImageView imageView6 = this.mMenuDivider;
        if (imageView6 != null) {
            imageView6.setBackgroundColor(i4);
        }
        View view = this.mVoiceMenuList;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
        View view2 = this.mVoiceMenuList;
        if (view2 != null) {
            view2.invalidate();
        }
    }

    public final void updateProcessingLightEffect() {
        this.mVoiceSubMenu.updateProcessingLightEffect();
    }

    public final void updateRecording() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        String[] permissionsForRecordAudio = PermissionHelper.getPermissionsForRecordAudio();
        if (PermissionHelper.isPermissionGranted(activity, new RunnableC9844c(activity, permissionsForRecordAudio, 27), (String[]) Arrays.copyOf(permissionsForRecordAudio, permissionsForRecordAudio.length))) {
            if (this.mPresenter.compareViewState(VoiceViewState.Type.EDIT)) {
                this.mPresenter.cancelSelect(false);
                this.mVoiceSubMenu.hideEditTrashView();
            }
            if (this.mIsTablet) {
                hideRecordingListView();
            }
            reset();
            collapseMenuAnimation();
            this.mPresenter.startNewRecording();
        }
    }

    public final void updateRecordingButton() {
        if (this.mPresenter.isNotSupportedRecording()) {
            CoeditState.INSTANCE.setDisable(this.mRecordingButton);
            return;
        }
        ImageView imageView = this.mRecordingButton;
        if (imageView != null) {
            imageView.setEnabled(true);
        }
        ImageView imageView2 = this.mRecordingButton;
        if (imageView2 != null) {
            imageView2.setAlpha(1.0f);
        }
    }

    public final void updateSelectedItemText(int selectedItem) {
        this.mVoiceSubMenu.updateSelectedItemText(selectedItem);
    }

    public final void updateView() {
        View view;
        this.mVoiceSubMenu.updateView();
        if (!this.mPresenter.isNotSupportedRecording()) {
            if (!this.mPresenter.isShareOldNotebook() || (view = this.mBadgeFirstListButton) == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CoeditState.INSTANCE.setDisable(this.mRecordingButton);
        View view2 = this.mBadgeFirstListButton;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void updateViewEraser(boolean needUpdateAnimation) {
        this.mVoiceSubMenu.updateViewEraser();
        if (needUpdateAnimation) {
            this.mVoiceAnimation.updateAnimationForEraser(this.mVoiceMenuList, this.mPresenter.getEraserState(), this.mPresenter.isLineVoiceLayout(), this.mMoreButton != null);
        }
    }
}

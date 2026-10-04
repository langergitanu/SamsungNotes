package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.animation.C0421a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.view.C7975a;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u001b\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001_B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020&J\b\u0010)\u001a\u00020&H\u0002J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\rJ\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\rJ$\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020&H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u001a\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020:2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\u0010\u0010?\u001a\u00020&2\b\u0010@\u001a\u0004\u0018\u00010AJ\u0012\u0010B\u001a\u00020&2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u000e\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020!H\u0002J\b\u0010H\u001a\u00020&H\u0002J\b\u0010K\u001a\u00020&H\u0002J\b\u0010L\u001a\u00020&H\u0002J\b\u0010M\u001a\u00020&H\u0002J\b\u0010N\u001a\u00020&H\u0002J\u0006\u0010O\u001a\u00020&J\b\u0010P\u001a\u00020&H\u0002J\b\u0010Q\u001a\u00020&H\u0002J\b\u0010R\u001a\u00020&H\u0002J\b\u0010S\u001a\u00020&H\u0002J\u0006\u0010T\u001a\u00020&J\u0006\u0010U\u001a\u00020&J\u0006\u0010V\u001a\u00020&J\u0006\u0010W\u001a\u00020&J\u0018\u0010Y\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\rH\u0002J\u000e\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\rJ\u0010\u0010]\u001a\u00020&2\u0006\u0010^\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010X\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010J¨\u0006`"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordSimpleMenu;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$UpdateViewAnimation;", "mActivity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;)V", "getView", "()Landroid/view/View;", "mAnimation", "", "mIsRecording", "mBtnStop", "Landroid/widget/ImageView;", "mBtnStopFullScreen", "mTimeView", "Landroid/widget/TextView;", "mTimeViewFullScreen", "mRecordingGroup", "mRecordingGroupFullScreen", "mMenuToggleBtn", "mMenuToggleBtnFullScreen", "mLottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieAnimationViewFullScreen", "mRecordingBg", "mSimpleView", "mRecordingColorSpan", "Landroid/text/style/ForegroundColorSpan;", "mUpdateCount", "", "mAnimationToggleBtn", "Landroid/view/View$OnClickListener;", "mClickExpendMenu", "insertExpendCollapseSALog", "", "onExpandMenuClick", "mClickRecordingBtn", "initListener", Constants.IntentExtraValue.SHOW, "isPlay", "showToggleBtn", "updateMenuToggleBtnImage", "hideToggleView", "showSuspendView", "updateStatusAnimation", "isAnimation", "hideAnimationRecording", "toggleButton", "group", "groupBg", "showRecordingAnimation", "createBackgroundValueAnimator", "Landroid/animation/ValueAnimator;", "newWidth", "", "onAnimationUpdateWidthGroup", "width", "updateBgRecording", "hideRecordingView", "setRecordTime", "time", "", "updateTimeView", "updateBackground", "themeColor", "", "updateButtonColor", "buttonColor", "updateTextColor", "isDecorViewMode", "()Z", "updateStopPauseIcon", "updateToggleBtnIcon", "showSimpleMenu", "updateAlphaRecording", "updateRecordBgSimpleView", "showAniFullScreen", "hideAniFullScreen", "showAni", "hideAni", "updateRecordBgDecorView", "updateView", "hideAll", "showOnlyRecordButton", "isUserSkip", "enableControls", "enable", "onUpdateRecordingActionAnimation", "isEnable", "onUpdateToggleActionAnimation", "isEnabled", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceRecordSimpleMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordSimpleMenu.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordSimpleMenu\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,701:1\n255#2:702\n255#2:703\n255#2:704\n255#2:705\n255#2:706\n255#2:707\n255#2:708\n*S KotlinDebug\n*F\n+ 1 VoiceRecordSimpleMenu.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordSimpleMenu\n*L\n119#1:702\n205#1:703\n211#1:704\n451#1:705\n563#1:706\n574#1:707\n616#1:708\n*E\n"})
public final class VoiceRecordSimpleMenu implements VoiceAnimation.UpdateViewAnimation {
    private static final long ANIMATION_DELAY_UPDATE = 100;
    private static final long ANIMATION_HIDE_DURATION_ALPHA = 100;
    private static final long ANIMATION_SHOW_DURATION = 400;
    private static final long ANIMATION_SHOW_DURATION_ALPHA = 200;
    private static final long MAX_UPDATE_COUNT = 4;

    @NotNull
    private static final String TAG;
    private static final int TIME_LENGTH = 5;
    private static final float TIME_TEXT_MAX_SIZE = 12.0f;
    private static final float TIME_TEXT_SIZE = 14.0f;

    @Nullable
    private final Activity mActivity;
    private boolean mAnimation;

    @NotNull
    private final View.OnClickListener mAnimationToggleBtn;

    @NotNull
    private final ImageView mBtnStop;

    @NotNull
    private final ImageView mBtnStopFullScreen;

    @NotNull
    private final View.OnClickListener mClickExpendMenu;

    @NotNull
    private final View.OnClickListener mClickRecordingBtn;
    private boolean mIsRecording;

    @NotNull
    private final LottieAnimationView mLottieAnimationView;

    @NotNull
    private final LottieAnimationView mLottieAnimationViewFullScreen;

    @Nullable
    private final ImageView mMenuToggleBtn;

    @Nullable
    private final ImageView mMenuToggleBtnFullScreen;

    @NotNull
    private final VoiceRecordMenuPresenter mPresenter;

    @NotNull
    private final View mRecordingBg;

    @Nullable
    private ForegroundColorSpan mRecordingColorSpan;

    @Nullable
    private final View mRecordingGroup;

    @NotNull
    private final View mRecordingGroupFullScreen;

    @NotNull
    private final View mSimpleView;

    @NotNull
    private final TextView mTimeView;

    @NotNull
    private final TextView mTimeViewFullScreen;
    private int mUpdateCount;

    @NotNull
    private final View view;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordSimpleMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordSimpleMenu(@Nullable Activity activity, @NotNull View view, @NotNull VoiceRecordMenuPresenter mPresenter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mActivity = activity;
        this.view = view;
        this.mPresenter = mPresenter;
        View viewFindViewById = view.findViewById(C9086R.id.voice_recording_btn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mBtnStop = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(C9086R.id.voice_recording_btn_full_screen);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mBtnStopFullScreen = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(C9086R.id.voice_record_time);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mTimeView = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(C9086R.id.voice_record_time_full_screen);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.mTimeViewFullScreen = (TextView) viewFindViewById4;
        this.mRecordingGroup = view.findViewById(C9086R.id.recording_group);
        View viewFindViewById5 = view.findViewById(C9086R.id.recording_group_full_screen);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mRecordingGroupFullScreen = viewFindViewById5;
        this.mMenuToggleBtn = (ImageView) view.findViewById(C9086R.id.voice_record_menu_toggle_btn);
        this.mMenuToggleBtnFullScreen = (ImageView) view.findViewById(C9086R.id.voice_record_menu_toggle_btn_full_screen);
        View viewFindViewById6 = view.findViewById(C9086R.id.voice_record_menu_toggle_btn_animation);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.mLottieAnimationView = (LottieAnimationView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(C9086R.id.voice_record_menu_toggle_btn_animation_full_screen);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.mLottieAnimationViewFullScreen = (LottieAnimationView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(C9086R.id.voice_recording_group_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.mRecordingBg = viewFindViewById8;
        View viewFindViewById9 = view.findViewById(C9086R.id.comp_voice_simple_menu);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.mSimpleView = viewFindViewById9;
        final int i = 0;
        this.mAnimationToggleBtn = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.p

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceRecordSimpleMenu f7328b;

            {
                this.f7328b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i) {
                    case 0:
                        VoiceRecordSimpleMenu.mAnimationToggleBtn$lambda$0(this.f7328b, view2);
                        break;
                    case 1:
                        VoiceRecordSimpleMenu.mClickExpendMenu$lambda$1(this.f7328b, view2);
                        break;
                    default:
                        VoiceRecordSimpleMenu.mClickRecordingBtn$lambda$2(this.f7328b, view2);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mClickExpendMenu = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.p

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceRecordSimpleMenu f7328b;

            {
                this.f7328b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i2) {
                    case 0:
                        VoiceRecordSimpleMenu.mAnimationToggleBtn$lambda$0(this.f7328b, view2);
                        break;
                    case 1:
                        VoiceRecordSimpleMenu.mClickExpendMenu$lambda$1(this.f7328b, view2);
                        break;
                    default:
                        VoiceRecordSimpleMenu.mClickRecordingBtn$lambda$2(this.f7328b, view2);
                        break;
                }
            }
        };
        final int i4 = 2;
        this.mClickRecordingBtn = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.p

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceRecordSimpleMenu f7328b;

            {
                this.f7328b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i4) {
                    case 0:
                        VoiceRecordSimpleMenu.mAnimationToggleBtn$lambda$0(this.f7328b, view2);
                        break;
                    case 1:
                        VoiceRecordSimpleMenu.mClickExpendMenu$lambda$1(this.f7328b, view2);
                        break;
                    default:
                        VoiceRecordSimpleMenu.mClickRecordingBtn$lambda$2(this.f7328b, view2);
                        break;
                }
            }
        };
        initListener();
    }

    private final ValueAnimator createBackgroundValueAnimator(float newWidth) {
        onAnimationUpdateWidthGroup(newWidth, this.mRecordingGroup);
        ViewGroup.LayoutParams layoutParams = this.mRecordingBg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
        this.mRecordingBg.setLayoutParams(layoutParams2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((ViewGroup.MarginLayoutParams) layoutParams2).width, newWidth);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 27));
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createBackgroundValueAnimator$lambda$10(VoiceRecordSimpleMenu voiceRecordSimpleMenu, ValueAnimator valueAnimator) {
        voiceRecordSimpleMenu.onAnimationUpdateWidthGroup(((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue(), voiceRecordSimpleMenu.mRecordingBg);
    }

    private final void enableControls(View view, boolean enable) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    childAt.setClickable(enable);
                    if ((childAt instanceof ViewGroup) && !(childAt instanceof RecyclerView)) {
                        enableControls(childAt, enable);
                    }
                }
            }
        }
    }

    private final void hideAni() {
        this.mLottieAnimationView.cancelAnimation();
        this.mLottieAnimationView.setVisibility(8);
        ImageView imageView = this.mMenuToggleBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private final void hideAniFullScreen() {
        this.mLottieAnimationViewFullScreen.cancelAnimation();
        this.mLottieAnimationViewFullScreen.setVisibility(8);
        ImageView imageView = this.mMenuToggleBtnFullScreen;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    private final void hideAnimationRecording(ImageView toggleButton, View group, final View groupBg) {
        if (this.mAnimation || this.mIsRecording || group == null) {
            return;
        }
        Logger.m10999d(TAG, "hideAnimationRecording#");
        this.mAnimation = true;
        onUpdateRecordingActionAnimation(false);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(group, "alpha", group.getAlpha(), 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        ViewGroup.LayoutParams layoutParams = groupBg.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        final int i = ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).width;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, 1.0f);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.addUpdateListener(new C10889o(this, 0, groupBg, group));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(toggleButton, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(toggleButton, "scaleY", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(400L);
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.2f, 0.0f, 1.2f));
        objectAnimatorOfFloat3.setDuration(400L);
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.2f, 0.0f, 1.2f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu.hideAnimationRecording.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Logger.m10999d(VoiceRecordSimpleMenu.TAG, "hideAnimationRecording# onAnimationEnd");
                View view = VoiceRecordSimpleMenu.this.mRecordingGroup;
                if (view != null) {
                    view.setVisibility(8);
                }
                VoiceRecordSimpleMenu.this.onAnimationUpdateWidthGroup(i, groupBg);
                VoiceRecordSimpleMenu.this.onUpdateRecordingActionAnimation(true);
                VoiceRecordSimpleMenu.this.mAnimation = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideAnimationRecording$lambda$8(VoiceRecordSimpleMenu voiceRecordSimpleMenu, View view, View view2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        voiceRecordSimpleMenu.onAnimationUpdateWidthGroup(fFloatValue, view);
        voiceRecordSimpleMenu.onAnimationUpdateWidthGroup(fFloatValue, view2);
    }

    private final void hideRecordingView() {
        View view = this.mRecordingGroup;
        if (view != null && view.getVisibility() == 0) {
            hideAnimationRecording(this.mMenuToggleBtn, this.mRecordingGroup, this.mRecordingBg);
        } else if (this.mRecordingGroupFullScreen.getVisibility() == 0) {
            this.mRecordingGroupFullScreen.setVisibility(8);
        }
    }

    private final void hideToggleView() {
        ImageView imageView = this.mMenuToggleBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mMenuToggleBtnFullScreen;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private final void initListener() {
        this.mBtnStop.setOnClickListener(this.mClickRecordingBtn);
        this.mBtnStopFullScreen.setOnClickListener(this.mClickRecordingBtn);
        this.mTimeView.setOnClickListener(this.mClickRecordingBtn);
        this.mTimeViewFullScreen.setOnClickListener(this.mClickRecordingBtn);
        View view = this.mRecordingGroup;
        if (view != null) {
            view.setOnClickListener(this.mClickRecordingBtn);
        }
        this.mRecordingGroupFullScreen.setOnClickListener(this.mClickRecordingBtn);
        this.mSimpleView.setOnClickListener(this.mClickExpendMenu);
        ImageView imageView = this.mMenuToggleBtn;
        if (imageView != null) {
            imageView.setOnClickListener(this.mClickExpendMenu);
        }
        ImageView imageView2 = this.mMenuToggleBtnFullScreen;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.mClickExpendMenu);
        }
        this.mLottieAnimationViewFullScreen.setOnClickListener(this.mAnimationToggleBtn);
        this.mLottieAnimationView.setOnClickListener(this.mAnimationToggleBtn);
    }

    private final void insertExpendCollapseSALog() {
        if (this.mPresenter.getViewStateType() == VoiceViewState.Type.VOICEINIT) {
            ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_COLLAPSE_EXPAND, "0");
        } else if (this.mPresenter.getViewState().isShowingRecordingState()) {
            ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_COLLAPSE_EXPAND, "1");
        }
    }

    private final boolean isDecorViewMode() {
        return this.mPresenter.isFullScreenMode() || this.mPresenter.isSearchMode() || this.mPresenter.isInAppCollaborationMode();
    }

    private final boolean isUserSkip() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.VoiceRecorder;
        if (!UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            return false;
        }
        UserInputSkipper.setHoldingSingleActionEventTime(300L, tag);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mAnimationToggleBtn$lambda$0(VoiceRecordSimpleMenu voiceRecordSimpleMenu, View view) {
        voiceRecordSimpleMenu.mLottieAnimationView.cancelAnimation();
        voiceRecordSimpleMenu.mLottieAnimationView.setVisibility(8);
        voiceRecordSimpleMenu.mLottieAnimationViewFullScreen.cancelAnimation();
        voiceRecordSimpleMenu.mLottieAnimationViewFullScreen.setVisibility(8);
        if (voiceRecordSimpleMenu.isDecorViewMode()) {
            ImageView imageView = voiceRecordSimpleMenu.mMenuToggleBtnFullScreen;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = voiceRecordSimpleMenu.mMenuToggleBtn;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        voiceRecordSimpleMenu.mPresenter.expendRecordPlayView();
        voiceRecordSimpleMenu.updateMenuToggleBtnImage();
        voiceRecordSimpleMenu.insertExpendCollapseSALog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClickExpendMenu$lambda$1(VoiceRecordSimpleMenu voiceRecordSimpleMenu, View view) {
        if (voiceRecordSimpleMenu.isUserSkip()) {
            voiceRecordSimpleMenu.onExpandMenuClick();
            voiceRecordSimpleMenu.insertExpendCollapseSALog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClickRecordingBtn$lambda$2(VoiceRecordSimpleMenu voiceRecordSimpleMenu, View view) {
        if (!voiceRecordSimpleMenu.mPresenter.stopRecording()) {
            voiceRecordSimpleMenu.mPresenter.playPause(true);
        }
        voiceRecordSimpleMenu.mPresenter.clearSelectionObject();
        voiceRecordSimpleMenu.mPresenter.expendRecordPlayView();
        Activity activity = voiceRecordSimpleMenu.mActivity;
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
        ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_STOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimationUpdateWidthGroup(float width, View view) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) (view != null ? view.getLayoutParams() : null);
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) width;
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    private final void showAni() {
        this.mLottieAnimationView.setVisibility(0);
        this.mLottieAnimationView.setRepeatCount(-1);
        this.mLottieAnimationView.playAnimation();
        ImageView imageView = this.mMenuToggleBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void showAniFullScreen() {
        this.mLottieAnimationViewFullScreen.setVisibility(0);
        this.mLottieAnimationViewFullScreen.setRepeatCount(-1);
        this.mLottieAnimationViewFullScreen.playAnimation();
        ImageView imageView = this.mMenuToggleBtnFullScreen;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void showRecordingAnimation() {
        if (this.mAnimation) {
            return;
        }
        Logger.m10999d(TAG, "showRecordingAnimation#");
        this.mAnimation = true;
        onUpdateRecordingActionAnimation(false);
        View view = this.mRecordingGroup;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.mRecordingGroup;
        if (view2 != null) {
            view2.post(new RunnableC9767a(this, 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRecordingAnimation$lambda$9(final VoiceRecordSimpleMenu voiceRecordSimpleMenu) {
        voiceRecordSimpleMenu.mRecordingGroup.setVisibility(0);
        voiceRecordSimpleMenu.mRecordingGroup.measure(0, 0);
        voiceRecordSimpleMenu.mTimeView.measure(0, 0);
        float measuredWidth = voiceRecordSimpleMenu.mRecordingGroup.getMeasuredWidth();
        Logger.m10999d(TAG, "showRecordingAnimation# bgWidth " + measuredWidth + " / " + voiceRecordSimpleMenu.mTimeView.getMeasuredWidth());
        voiceRecordSimpleMenu.mRecordingGroup.setAlpha(0.0f);
        View view = voiceRecordSimpleMenu.mRecordingGroup;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 1.0f);
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setDuration(200L);
        }
        float dimensionPixelSize = voiceRecordSimpleMenu.mSimpleView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_animation_trans);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(voiceRecordSimpleMenu.mBtnStop, "translationX", dimensionPixelSize, 0.0f);
        objectAnimatorOfFloat2.setDuration(400L);
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(voiceRecordSimpleMenu.mTimeView, "translationX", dimensionPixelSize, 0.0f);
        objectAnimatorOfFloat3.setDuration(400L);
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        ValueAnimator valueAnimatorCreateBackgroundValueAnimator = voiceRecordSimpleMenu.createBackgroundValueAnimator(measuredWidth);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, valueAnimatorCreateBackgroundValueAnimator);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu$showRecordingAnimation$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Logger.m10999d(VoiceRecordSimpleMenu.TAG, "showRecordingAnimation# onAnimationEnd");
                this.this$0.onUpdateRecordingActionAnimation(true);
                this.this$0.mAnimation = false;
            }
        });
    }

    private final void showSimpleMenu() {
        if (this.view.getVisibility() != 0) {
            this.view.setVisibility(0);
        }
    }

    private final void showSuspendView() {
        showSimpleMenu();
        hideToggleView();
        if (isDecorViewMode()) {
            this.mLottieAnimationViewFullScreen.cancelAnimation();
            this.mLottieAnimationViewFullScreen.setVisibility(8);
            View view = this.mRecordingGroup;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mRecordingGroupFullScreen.setVisibility(0);
        } else {
            this.mLottieAnimationView.cancelAnimation();
            this.mLottieAnimationView.setVisibility(8);
            this.mRecordingGroupFullScreen.setVisibility(8);
            if (this.mPresenter.getPreviousViewStateType() == VoiceViewState.Type.RECORD) {
                View view2 = this.mRecordingGroup;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                updateAlphaRecording();
            } else {
                View view3 = this.mRecordingGroup;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                showRecordingAnimation();
            }
        }
        updateStopPauseIcon();
        updateBgRecording();
    }

    private final void showToggleBtn() {
        showSimpleMenu();
        hideRecordingView();
        updateToggleBtnIcon();
        if (this.mPresenter.getViewState().isHideState()) {
            ImageView imageView = this.mMenuToggleBtn;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (isDecorViewMode()) {
            ImageView imageView2 = this.mMenuToggleBtn;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.mMenuToggleBtnFullScreen;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            if (this.mLottieAnimationViewFullScreen.getVisibility() == 0) {
                hideAniFullScreen();
            }
        } else {
            ImageView imageView4 = this.mMenuToggleBtn;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            ImageView imageView5 = this.mMenuToggleBtnFullScreen;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            if (this.mLottieAnimationView.getVisibility() == 0) {
                hideAni();
            }
        }
        updateMenuToggleBtnImage();
    }

    private final void updateAlphaRecording() {
        View view = this.mRecordingGroup;
        if (view != null) {
            view.setAlpha(1.0f);
        }
    }

    private final void updateBgRecording() {
        GradientDrawable gradientDrawable;
        if (this.mActivity == null) {
            return;
        }
        this.mLottieAnimationViewFullScreen.addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new C8886c(this, 14));
        boolean z = BackgroundColorUtil.getBackgroundThemeColorTable(this.mActivity, this.mPresenter.getBackgroundColor(), this.mPresenter.isBackgroundColorInverted(), this.mPresenter.hasBackgroundImage())[2] == 1;
        boolean zIsNightMode = ContextUtils.isNightMode(this.mActivity.getApplicationContext());
        Resources resources = this.mSimpleView.getResources();
        Resources.Theme theme = this.mSimpleView.getContext().getTheme();
        this.mRecordingBg.setBackground(ResourcesCompat.getDrawable(resources, C9086R.drawable.voice_recording_simple_menu_background, theme));
        if ((this.mRecordingBg.getBackground() instanceof GradientDrawable) && (gradientDrawable = (GradientDrawable) this.mRecordingBg.getBackground()) != null) {
            gradientDrawable.setAlpha((int) (zIsNightMode ? 51.0d : 204.0d));
            if (z && !zIsNightMode) {
                gradientDrawable.setColor(resources.getColor(C9086R.color.composer_voice_menu_composite_alpha_background, null));
            } else if (this.mPresenter.isBackgroundColorInverted() || z || !zIsNightMode) {
                gradientDrawable.setColor(resources.getColor(C9086R.color.voice_recording_simple_menu_btn_background, theme));
            } else {
                gradientDrawable.setColor(resources.getColor(C9086R.color.composer_voice_menu_dark_background, theme));
                gradientDrawable.setAlpha(25);
            }
        }
        this.mBtnStopFullScreen.setBackground(ResourcesCompat.getDrawable(resources, C9086R.drawable.voice_record_stop_simple_menu, theme));
        this.mRecordingBg.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter updateBgRecording$lambda$11(VoiceRecordSimpleMenu voiceRecordSimpleMenu, LottieFrameInfo lottieFrameInfo) {
        return new PorterDuffColorFilter(voiceRecordSimpleMenu.mActivity.getResources().getColor(C9086R.color.voice_recording_btn_recording, null), PorterDuff.Mode.SRC);
    }

    private final void updateButtonColor(int buttonColor) {
        ImageView imageView = this.mMenuToggleBtn;
        if (imageView != null) {
            imageView.setColorFilter(buttonColor);
        }
        this.mLottieAnimationView.addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new C7975a(buttonColor, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter updateButtonColor$lambda$13(int i, LottieFrameInfo lottieFrameInfo) {
        return new PorterDuffColorFilter(i, PorterDuff.Mode.SRC);
    }

    private final void updateMenuToggleBtnImage() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources.Theme theme = this.view.getContext().getTheme();
        Drawable drawable = null;
        if (this.mPresenter.getViewState().isInitState()) {
            ImageView imageView = this.mMenuToggleBtnFullScreen;
            if (imageView != null) {
                Activity activity = this.mActivity;
                imageView.setBackground((activity == null || (resources4 = activity.getResources()) == null) ? null : ResourcesCompat.getDrawable(resources4, C9086R.drawable.record_done_full_screen, theme));
            }
            ImageView imageView2 = this.mMenuToggleBtn;
            if (imageView2 != null) {
                Activity activity2 = this.mActivity;
                if (activity2 != null && (resources3 = activity2.getResources()) != null) {
                    drawable = ResourcesCompat.getDrawable(resources3, C9086R.drawable.record_done, theme);
                }
                imageView2.setImageDrawable(drawable);
                return;
            }
            return;
        }
        ImageView imageView3 = this.mMenuToggleBtnFullScreen;
        if (imageView3 != null) {
            Activity activity3 = this.mActivity;
            imageView3.setBackground((activity3 == null || (resources2 = activity3.getResources()) == null) ? null : ResourcesCompat.getDrawable(resources2, C9086R.drawable.record_done_selected_full_screen, theme));
        }
        ImageView imageView4 = this.mMenuToggleBtn;
        if (imageView4 != null) {
            Activity activity4 = this.mActivity;
            if (activity4 != null && (resources = activity4.getResources()) != null) {
                drawable = ResourcesCompat.getDrawable(resources, C9086R.drawable.record_done_selected, theme);
            }
            imageView4.setImageDrawable(drawable);
        }
    }

    private final void updateStopPauseIcon() {
        if (isDecorViewMode()) {
            this.mBtnStopFullScreen.setVisibility(0);
        } else {
            this.mBtnStop.setVisibility(0);
        }
    }

    private final void updateTextColor() {
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mRecordingColorSpan = new ForegroundColorSpan(activity.getResources().getColor(C9086R.color.composer_voice_simple_menu_play_text_color, null));
        }
    }

    private final void updateTimeView(String time) {
        SpannableString spannableString = new SpannableString(time);
        spannableString.setSpan(this.mRecordingColorSpan, 0, spannableString.length(), 33);
        this.mTimeView.setText(spannableString);
        this.mTimeViewFullScreen.setText(spannableString);
        Activity activity = this.mActivity;
        if (activity != null) {
            int color = activity.getResources().getColor(C9086R.color.composer_voice_playing_simple_menu, null);
            this.mTimeView.setTextColor(color);
            this.mTimeViewFullScreen.setTextColor(color);
            TextView textView = this.mTimeView;
            int length = textView.length();
            float f = TIME_TEXT_SIZE;
            CharUtils.applyTextSizeUntilMediumSize(activity, textView, length > 5 ? 12.0f : 14.0f);
            TextView textView2 = this.mTimeViewFullScreen;
            if (textView2.length() > 5) {
                f = 12.0f;
            }
            CharUtils.applyTextSizeUntilMediumSize(activity, textView2, f);
        }
    }

    private final void updateToggleBtnIcon() {
        String string;
        Resources resources = this.view.getResources();
        updateMenuToggleBtnImage();
        String string2 = resources.getString(C9086R.string.voice_record_menu_expand, resources.getString(C9086R.string.base_string_voice_recordings));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        if (this.mPresenter.getViewState().isShowingRecordingState()) {
            Logger.m10999d(TAG, "updateToggleBtnIcon# collapse");
            string = resources.getString(C9086R.string.voice_record_menu_collapse, resources.getString(C9086R.string.base_string_voice_recordings));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else {
            Logger.m10999d(TAG, "updateToggleBtnIcon# expand");
            string = string2;
        }
        this.mLottieAnimationView.setContentDescription(string2);
        this.mLottieAnimationViewFullScreen.setContentDescription(string2);
        ImageView imageView = this.mMenuToggleBtnFullScreen;
        if (imageView != null) {
            imageView.setContentDescription(string);
        }
        ImageView imageView2 = this.mMenuToggleBtn;
        if (imageView2 != null) {
            imageView2.setContentDescription(string);
        }
        VoiceAssistantTTS.INSTANCE.getInstance().sendTalkBackMessage(string);
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setTooltipText(this.mLottieAnimationView);
        companion.getInstance().setTooltipText(this.mLottieAnimationViewFullScreen);
        companion.getInstance().setTooltipText(this.mMenuToggleBtn);
        companion.getInstance().setTooltipText(this.mMenuToggleBtnFullScreen);
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public final void hideAll() {
        Logger.m10999d(TAG, "hideAll#");
        this.view.setVisibility(8);
    }

    public final void onExpandMenuClick() {
        updateMenuToggleBtnImage();
        if (this.mPresenter.getViewStateType() == VoiceViewState.Type.NORMAL_PLAY) {
            this.mPresenter.stopAudioPlaying();
            return;
        }
        if (this.mPresenter.getViewStateType() != VoiceViewState.Type.VOICEINIT || (this.mLottieAnimationViewFullScreen.getVisibility() != 0 && this.mLottieAnimationView.getVisibility() != 0)) {
            this.mPresenter.toggleExpendVoicePanel();
            return;
        }
        if (isDecorViewMode()) {
            hideAniFullScreen();
        } else {
            hideAni();
        }
        show(true);
        updateMenuToggleBtnImage();
    }

    public final void onUpdateRecordingActionAnimation(boolean isEnable) {
        enableControls(this.view, isEnable);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceAnimation.UpdateViewAnimation
    public void onUpdateToggleActionAnimation(boolean isEnabled) {
        onUpdateRecordingActionAnimation(isEnabled);
    }

    public final void setRecordTime(@Nullable String time) {
        updateTimeView(time);
    }

    public final void show(boolean isPlay) {
        if (this.mAnimation) {
            int i = this.mUpdateCount;
            if (i < 4) {
                this.mUpdateCount = i + 1;
                this.view.postDelayed(new RunnableC0116a(16, this, isPlay), 100L);
                return;
            }
            return;
        }
        this.mUpdateCount = 0;
        Logger.m11003i(TAG, "show# " + isPlay + "  ViewState " + this.mPresenter.getViewStateType().name());
        boolean z = !this.mPresenter.isShowingRecordingMenu() && isPlay;
        if (this.mPresenter.getViewState().isRecordState()) {
            showSuspendView();
            return;
        }
        if (!z) {
            showToggleBtn();
            return;
        }
        this.mLottieAnimationViewFullScreen.setVisibility(8);
        ImageView imageView = this.mMenuToggleBtnFullScreen;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.mLottieAnimationView.setVisibility(8);
        ImageView imageView2 = this.mMenuToggleBtn;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        View view = this.mRecordingGroup;
        if (view != null) {
            view.setVisibility(8);
        }
        this.mRecordingGroupFullScreen.setVisibility(8);
        if (isDecorViewMode()) {
            showAniFullScreen();
        } else {
            showAni();
        }
    }

    public final void showOnlyRecordButton() {
        Logger.m10999d(TAG, "showOnlyRecordButton");
        View view = this.mRecordingGroup;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView = this.mMenuToggleBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mMenuToggleBtnFullScreen;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public final void updateBackground(@NotNull int[] themeColor) {
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        if (themeColor.length != 3) {
            return;
        }
        updateBgRecording();
        updateButtonColor(ColorUtils.setAlphaComponent(themeColor[1], 230));
        updateTextColor();
    }

    public final void updateRecordBgDecorView() {
        Resources resources;
        if (this.mPresenter.getViewState().isRecordState()) {
            View view = this.mRecordingGroup;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mRecordingGroupFullScreen.setVisibility(0);
        } else if (!this.mPresenter.getViewState().isHideState()) {
            View view2 = this.mRecordingGroup;
            if (view2 != null && view2.getVisibility() == 0) {
                this.mRecordingGroup.setVisibility(8);
                this.mRecordingGroupFullScreen.setVisibility(0);
            } else if (this.mLottieAnimationView.getVisibility() == 0) {
                hideAni();
                showAniFullScreen();
                ImageView imageView = this.mMenuToggleBtnFullScreen;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                ImageView imageView2 = this.mMenuToggleBtn;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            } else if (this.mLottieAnimationViewFullScreen.getVisibility() != 0) {
                ImageView imageView3 = this.mMenuToggleBtn;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                ImageView imageView4 = this.mMenuToggleBtnFullScreen;
                if (imageView4 != null) {
                    imageView4.setVisibility(0);
                }
            }
        }
        ImageView imageView5 = this.mBtnStopFullScreen;
        Activity activity = this.mActivity;
        Drawable drawable = null;
        if (activity != null && (resources = activity.getResources()) != null) {
            drawable = ResourcesCompat.getDrawable(resources, C9086R.drawable.voice_record_stop_simple_menu, null);
        }
        imageView5.setBackground(drawable);
        updateMenuToggleBtnImage();
    }

    public final void updateRecordBgSimpleView() {
        if (this.mRecordingGroupFullScreen.getVisibility() == 0) {
            this.mRecordingGroupFullScreen.setVisibility(8);
            View view = this.mRecordingGroup;
            if (view != null) {
                view.setVisibility(0);
            }
            updateAlphaRecording();
            showRecordingAnimation();
        }
        ImageView imageView = this.mMenuToggleBtnFullScreen;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.mMenuToggleBtnFullScreen.setVisibility(8);
            ImageView imageView2 = this.mMenuToggleBtn;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        updateBgRecording();
        if (this.mLottieAnimationViewFullScreen.getVisibility() == 0) {
            hideAniFullScreen();
            showAni();
            ImageView imageView3 = this.mMenuToggleBtnFullScreen;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.mMenuToggleBtn;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        }
    }

    public final void updateStatusAnimation(boolean isAnimation) {
        this.mIsRecording = isAnimation;
    }

    public final void updateView() {
        if (this.mPresenter.isCoedit() && this.mPresenter.getDataVoiceListSize() == 0) {
            hideAll();
        }
    }
}

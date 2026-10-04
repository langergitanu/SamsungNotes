package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.AIGuidingLightEffect;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceSpeedAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.PopupWindowHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001c\b \u0018\u0000 f2\u00020\u0001:\u0002efB+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010=\u001a\u00020>H\u0003J\u001a\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010\u00072\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020>H\u0002J\u0006\u0010D\u001a\u00020>J\b\u0010E\u001a\u00020>H\u0016J\u000e\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020\tJ\b\u0010H\u001a\u00020>H&J\u0012\u0010I\u001a\u00020>2\b\u0010J\u001a\u0004\u0018\u00010KH&J\b\u0010L\u001a\u00020>H\u0003J\b\u0010M\u001a\u00020>H\u0002J\b\u0010N\u001a\u00020>H\u0002J\b\u0010O\u001a\u00020>H&J\b\u0010P\u001a\u00020>H&J \u0010Q\u001a\u00020>2\u0006\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020BH\u0007J\u0006\u0010U\u001a\u00020>J\u0010\u0010V\u001a\u00020>2\b\u0010J\u001a\u0004\u0018\u00010KJ\u0010\u0010W\u001a\u00020>2\b\u0010J\u001a\u0004\u0018\u00010KJ\u000e\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020BJ\u0010\u0010Z\u001a\u00020>2\b\u0010[\u001a\u0004\u0018\u00010KJ\u0006\u0010\\\u001a\u00020>J\u0010\u0010]\u001a\u00020>2\b\u0010^\u001a\u0004\u0018\u00010\u0007J\u0006\u0010_\u001a\u00020>J\u0006\u0010`\u001a\u00020>J\u0006\u0010a\u001a\u00020>J\u000e\u0010b\u001a\u00020>2\u0006\u0010c\u001a\u00020\tJ\u0006\u0010d\u001a\u00020>R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0010\u0010*\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordControlMenu;", "", "mActivity", "Landroid/app/Activity;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "mVoiceMenu", "Landroid/view/View;", "mIsNormalPlay", "", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Landroid/view/View;Z)V", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "getMPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "setMPresenter", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;)V", "getMVoiceMenu", "()Landroid/view/View;", "setMVoiceMenu", "(Landroid/view/View;)V", "mEraserLayout", "mEraserLayoutTargetBG", "mEraser", "Landroid/widget/ImageView;", "mEraserDoneAnimation", "Lcom/airbnb/lottie/LottieAnimationView;", "mEraserText", "Landroid/widget/TextView;", "mSpeed", "Landroid/widget/Button;", "mPlayTime", "getMPlayTime", "()Landroid/widget/TextView;", "setMPlayTime", "(Landroid/widget/TextView;)V", "mTotalTime", "getMTotalTime", "setMTotalTime", "mBackward", "mForward", "mSeekBar", "Landroidx/appcompat/widget/SeslSeekBar;", "getMSeekBar", "()Landroidx/appcompat/widget/SeslSeekBar;", "setMSeekBar", "(Landroidx/appcompat/widget/SeslSeekBar;)V", "mIsStartTrack", "getMIsStartTrack", "()Z", "setMIsStartTrack", "(Z)V", "mAutoForward", "mAutoBackward", "mHandler", "Landroid/os/Handler;", "mSpeedPopup", "Landroid/widget/PopupWindow;", "initControlMenu", "", "updateMarginEnd", MarketingConstants.BUTTON, "marginEnd", "", "updateAudioEraser", "updateViewEraser", "updateView", "updateAudioEraserLayout", "isShowing", "insertSALog", "setPlayTimeView", "time", "", "initPlayControlMenu", "setToolTipText", "setMaxFontSize", "moveForwardSALog", "moveBackwardSALog", "updateBackground", "textIconColor", "isDarkTheme", "reverseColor", "moveForward", "setPlayTime", "setTotalTime", "setPlayProgress", "progress", "setPlaySpeed", "speed", "moveRewind", "showSpeedPopup", "anchorView", "hideSpeedPopup", "releaseAudioEraser", "updateProcessingLightEffect", "updateAudioEraserAnimation", "isEnable", "makeAudioEraserEffect", "AutoMoveUpdate", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceRecordControlMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordControlMenu.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordControlMenu\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,542:1\n1#2:543\n*E\n"})
public abstract class VoiceRecordControlMenu {
    private static final int DELAY_LONG_CLICK = 100;

    @NotNull
    private static final String TAG;

    @Nullable
    private Activity mActivity;
    private boolean mAutoBackward;
    private boolean mAutoForward;

    @Nullable
    private ImageView mBackward;

    @Nullable
    private ImageView mEraser;

    @Nullable
    private LottieAnimationView mEraserDoneAnimation;

    @Nullable
    private View mEraserLayout;

    @Nullable
    private View mEraserLayoutTargetBG;

    @Nullable
    private TextView mEraserText;

    @Nullable
    private ImageView mForward;

    @Nullable
    private Handler mHandler;
    private final boolean mIsNormalPlay;
    private boolean mIsStartTrack;

    @Nullable
    private TextView mPlayTime;

    @NotNull
    private VoiceRecordMenuPresenter mPresenter;

    @Nullable
    private SeslSeekBar mSeekBar;

    @Nullable
    private Button mSpeed;

    @Nullable
    private PopupWindow mSpeedPopup;

    @Nullable
    private TextView mTotalTime;

    @Nullable
    private View mVoiceMenu;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordControlMenu$AutoMoveUpdate;", "Ljava/lang/Runnable;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordControlMenu;)V", "run", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class AutoMoveUpdate implements Runnable {
        public AutoMoveUpdate() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceRecordControlMenu.this.mAutoForward) {
                VoiceRecordControlMenu.this.moveForward();
            } else if (VoiceRecordControlMenu.this.mAutoBackward) {
                VoiceRecordControlMenu.this.moveRewind();
            }
            Handler handler = VoiceRecordControlMenu.this.mHandler;
            if (handler != null) {
                handler.postDelayed(VoiceRecordControlMenu.this.new AutoMoveUpdate(), 100L);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EraserState.values().length];
            try {
                iArr[EraserState.ERASED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EraserState.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EraserState.ERASING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EraserState.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceRecordControlMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordControlMenu(@Nullable Activity activity, @NotNull VoiceRecordMenuPresenter mPresenter, @Nullable View view, boolean z) {
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mActivity = activity;
        this.mPresenter = mPresenter;
        this.mVoiceMenu = view;
        this.mIsNormalPlay = z;
        initControlMenu();
        initPlayControlMenu();
        setMaxFontSize();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initControlMenu() {
        Resources resources;
        int i;
        Integer numValueOf;
        Resources resources2;
        int i2;
        Integer numValueOf2;
        View view = this.mVoiceMenu;
        if (view != null) {
            view.setOnTouchListener(new ViewOnTouchListenerC7005f(17));
        }
        View view2 = this.mVoiceMenu;
        TextView textView = view2 != null ? (TextView) view2.findViewById(C9086R.id.voice_record_play_time) : null;
        this.mPlayTime = textView;
        if (textView != null) {
            textView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu.initControlMenu.2
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
                    TextView mPlayTime = VoiceRecordControlMenu.this.getMPlayTime();
                    Resources resources3 = mPlayTime != null ? mPlayTime.getResources() : null;
                    TextView mPlayTime2 = VoiceRecordControlMenu.this.getMPlayTime();
                    info.setContentDescription(voiceUtil.createTimeDescription(resources3, String.valueOf(mPlayTime2 != null ? mPlayTime2.getText() : null)));
                }
            });
        }
        View view3 = this.mVoiceMenu;
        TextView textView2 = view3 != null ? (TextView) view3.findViewById(C9086R.id.voice_record_total_time) : null;
        this.mTotalTime = textView2;
        if (textView2 != null) {
            textView2.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu.initControlMenu.3
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
                    TextView mTotalTime = VoiceRecordControlMenu.this.getMTotalTime();
                    Resources resources3 = mTotalTime != null ? mTotalTime.getResources() : null;
                    TextView mTotalTime2 = VoiceRecordControlMenu.this.getMTotalTime();
                    info.setContentDescription(voiceUtil.createTimeDescription(resources3, String.valueOf(mTotalTime2 != null ? mTotalTime2.getText() : null)));
                }
            });
        }
        View view4 = this.mVoiceMenu;
        this.mSpeed = view4 != null ? (Button) view4.findViewById(C9086R.id.voice_record_speed) : null;
        View view5 = this.mVoiceMenu;
        this.mSeekBar = view5 != null ? (SeslSeekBar) view5.findViewById(C9086R.id.voice_record_seek_bar) : null;
        View view6 = this.mVoiceMenu;
        this.mEraser = view6 != null ? (ImageView) view6.findViewById(C9086R.id.voice_record_eraser) : null;
        View view7 = this.mVoiceMenu;
        this.mEraserDoneAnimation = view7 != null ? (LottieAnimationView) view7.findViewById(C9086R.id.voice_record_eraser_done_animation) : null;
        View view8 = this.mVoiceMenu;
        this.mEraserText = view8 != null ? (TextView) view8.findViewById(C9086R.id.voice_record_eraser_text) : null;
        View view9 = this.mVoiceMenu;
        this.mEraserLayout = view9 != null ? view9.findViewById(C9086R.id.voice_record_eraser_layout) : null;
        View view10 = this.mVoiceMenu;
        this.mEraserLayoutTargetBG = view10 != null ? view10.findViewById(C9086R.id.voice_record_eraser_target_bg) : null;
        boolean zIsDexMode = DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mActivity);
        Activity activity = this.mActivity;
        if (zIsDexMode) {
            if (activity != null && (resources = activity.getResources()) != null) {
                i = C9086R.dimen.voice_recording_speed_button_width_dex_mode;
                numValueOf = Integer.valueOf(resources.getDimensionPixelSize(i));
            }
            numValueOf = null;
        } else {
            if (activity != null && (resources = activity.getResources()) != null) {
                i = C9086R.dimen.voice_recording_speed_button_width;
                numValueOf = Integer.valueOf(resources.getDimensionPixelSize(i));
            }
            numValueOf = null;
        }
        if (zIsDexMode) {
            Activity activity2 = this.mActivity;
            if (activity2 != null && (resources2 = activity2.getResources()) != null) {
                i2 = C9086R.dimen.voice_recording_speed_button_height_dex_mode;
                numValueOf2 = Integer.valueOf(resources2.getDimensionPixelSize(i2));
            }
            numValueOf2 = null;
        } else {
            Activity activity3 = this.mActivity;
            if (activity3 != null && (resources2 = activity3.getResources()) != null) {
                i2 = C9086R.dimen.voice_recording_speed_button_height;
                numValueOf2 = Integer.valueOf(resources2.getDimensionPixelSize(i2));
            }
            numValueOf2 = null;
        }
        Button button = this.mSpeed;
        ViewGroup.LayoutParams layoutParams = button != null ? button.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = numValueOf != null ? numValueOf.intValue() : 0;
        }
        if (layoutParams != null) {
            layoutParams.height = numValueOf2 != null ? numValueOf2.intValue() : 0;
        }
        Button button2 = this.mSpeed;
        if (button2 != null) {
            button2.setLayoutParams(layoutParams);
        }
        Button button3 = this.mSpeed;
        if (button3 != null) {
            button3.setOnClickListener(new ViewOnClickListenerC10876b(this, 2));
        }
        View view11 = this.mVoiceMenu;
        SeslSeekBar seslSeekBar = view11 != null ? (SeslSeekBar) view11.findViewById(C9086R.id.voice_record_seek_bar) : null;
        this.mSeekBar = seslSeekBar;
        if (seslSeekBar != null) {
            seslSeekBar.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu.initControlMenu.5
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    SeslSeekBar mSeekBar = VoiceRecordControlMenu.this.getMSeekBar();
                    if (mSeekBar == null) {
                        return;
                    }
                    VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
                    info.setContentDescription(voiceUtil.createTimeDescription(mSeekBar.getResources(), VoiceUtil.createTimeString$default(voiceUtil, mSeekBar.getProgress() / 1000, false, 2, null)));
                }
            });
        }
        SeslSeekBar seslSeekBar2 = this.mSeekBar;
        if (seslSeekBar2 != null) {
            seslSeekBar2.setOnSeekBarChangeListener(new SeslSeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu.initControlMenu.6
                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeslSeekBar seslSeekBar3, int progress, boolean fromUser) {
                    Intrinsics.checkNotNullParameter(seslSeekBar3, "seslSeekBar");
                    VoiceRecordControlMenu.this.setPlayTimeView(VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, progress / 1000, false, 2, null));
                }

                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeslSeekBar seslSeekBar3) {
                    Intrinsics.checkNotNullParameter(seslSeekBar3, "seslSeekBar");
                    VoiceRecordControlMenu.this.setMIsStartTrack(true);
                }

                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeslSeekBar seslSeekBar3) {
                    Intrinsics.checkNotNullParameter(seslSeekBar3, "seslSeekBar");
                    VoiceRecordControlMenu.this.getMPresenter().seekTo(seslSeekBar3.getProgress());
                    VoiceRecordControlMenu.this.setMIsStartTrack(false);
                    VoiceRecordControlMenu.this.insertSALog();
                }
            });
        }
        if (this.mIsNormalPlay || !this.mPresenter.isSupportAudioEraser()) {
            return;
        }
        TextView textView3 = this.mEraserText;
        if (textView3 != null) {
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setSingleLine(true);
            textView3.setMaxLines(1);
        }
        ImageView imageView = this.mEraser;
        if (imageView != null) {
            imageView.setOnClickListener(new ViewOnClickListenerC10876b(this, 3));
        }
        LottieAnimationView lottieAnimationView = this.mEraserDoneAnimation;
        if (lottieAnimationView != null) {
            lottieAnimationView.setOnClickListener(new ViewOnClickListenerC10876b(this, 4));
        }
        LottieAnimationView lottieAnimationView2 = this.mEraserDoneAnimation;
        if (lottieAnimationView2 != null) {
            Activity activity4 = this.mActivity;
            lottieAnimationView2.setContentDescription(activity4 != null ? activity4.getString(C9086R.string.voice_record_clean_up_audio) : null);
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mEraserDoneAnimation);
        View view12 = this.mEraserLayout;
        if (view12 != null) {
            view12.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initControlMenu$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initControlMenu$lambda$1(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        VoiceRecordMenuPresenter.changeSpeed$default(voiceRecordControlMenu.mPresenter, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initControlMenu$lambda$3(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        voiceRecordControlMenu.updateAudioEraser();
        ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_AI_CLEAN_AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initControlMenu$lambda$4(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        voiceRecordControlMenu.mPresenter.changeToNormalVoice();
        ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_AI_CLEAN_AUDIO);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initPlayControlMenu() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        this.mHandler = new Handler(looperMyLooper);
        View view = this.mVoiceMenu;
        ImageView imageView = view != null ? (ImageView) view.findViewById(C9086R.id.voice_record_forward) : null;
        this.mForward = imageView;
        if (imageView != null) {
            final int i = 0;
            imageView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordControlMenu f7278b;

                {
                    this.f7278b = this;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (i) {
                        case 0:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$8(this.f7278b, view2, motionEvent);
                        default:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$11(this.f7278b, view2, motionEvent);
                    }
                }
            });
        }
        ImageView imageView2 = this.mForward;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new ViewOnClickListenerC10876b(this, 0));
        }
        ImageView imageView3 = this.mForward;
        if (imageView3 != null) {
            final int i2 = 0;
            imageView3.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordControlMenu f7293b;

                {
                    this.f7293b = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    switch (i2) {
                        case 0:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$10(this.f7293b, view2);
                        default:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$13(this.f7293b, view2);
                    }
                }
            });
        }
        View view2 = this.mVoiceMenu;
        ImageView imageView4 = view2 != null ? (ImageView) view2.findViewById(C9086R.id.voice_record_backward) : null;
        this.mBackward = imageView4;
        if (imageView4 != null) {
            final int i4 = 1;
            imageView4.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordControlMenu f7278b;

                {
                    this.f7278b = this;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view22, MotionEvent motionEvent) {
                    switch (i4) {
                        case 0:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$8(this.f7278b, view22, motionEvent);
                        default:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$11(this.f7278b, view22, motionEvent);
                    }
                }
            });
        }
        ImageView imageView5 = this.mBackward;
        if (imageView5 != null) {
            imageView5.setOnClickListener(new ViewOnClickListenerC10876b(this, 1));
        }
        ImageView imageView6 = this.mBackward;
        if (imageView6 != null) {
            final int i5 = 1;
            imageView6.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordControlMenu f7293b;

                {
                    this.f7293b = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view22) {
                    switch (i5) {
                        case 0:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$10(this.f7293b, view22);
                        default:
                            return VoiceRecordControlMenu.initPlayControlMenu$lambda$13(this.f7293b, view22);
                    }
                }
            });
        }
        setToolTipText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initPlayControlMenu$lambda$10(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        voiceRecordControlMenu.mAutoForward = true;
        Handler handler = voiceRecordControlMenu.mHandler;
        if (handler != null) {
            handler.post(voiceRecordControlMenu.new AutoMoveUpdate());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initPlayControlMenu$lambda$11(VoiceRecordControlMenu voiceRecordControlMenu, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && voiceRecordControlMenu.mAutoBackward) {
            voiceRecordControlMenu.mAutoBackward = false;
            voiceRecordControlMenu.moveBackwardSALog();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPlayControlMenu$lambda$12(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        voiceRecordControlMenu.moveRewind();
        voiceRecordControlMenu.moveBackwardSALog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initPlayControlMenu$lambda$13(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        voiceRecordControlMenu.mAutoBackward = true;
        Handler handler = voiceRecordControlMenu.mHandler;
        if (handler != null) {
            handler.post(voiceRecordControlMenu.new AutoMoveUpdate());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initPlayControlMenu$lambda$8(VoiceRecordControlMenu voiceRecordControlMenu, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && voiceRecordControlMenu.mAutoForward) {
            voiceRecordControlMenu.mAutoForward = false;
            voiceRecordControlMenu.moveForwardSALog();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPlayControlMenu$lambda$9(VoiceRecordControlMenu voiceRecordControlMenu, View view) {
        voiceRecordControlMenu.moveForward();
        voiceRecordControlMenu.moveForwardSALog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveForward$lambda$14(VoiceRecordControlMenu voiceRecordControlMenu) {
        voiceRecordControlMenu.mPresenter.seekTo(0);
    }

    private final void setMaxFontSize() {
        Resources resources;
        Resources resources2;
        Activity activity = this.mActivity;
        Integer numValueOf = null;
        Integer numValueOf2 = (activity == null || (resources2 = activity.getResources()) == null) ? null : Integer.valueOf(resources2.getInteger(C9086R.integer.voice_record_speed_text_size));
        Activity activity2 = this.mActivity;
        if (activity2 != null && (resources = activity2.getResources()) != null) {
            numValueOf = Integer.valueOf(resources.getInteger(C9086R.integer.voice_record_text_size));
        }
        if (numValueOf2 == null || numValueOf == null) {
            return;
        }
        CharUtils.applyTextSizeUntilLargeSize(this.mActivity, this.mSpeed, numValueOf2.intValue());
        CharUtils.applyTextSizeUntilLargeSize(this.mActivity, this.mPlayTime, numValueOf.intValue());
        CharUtils.applyTextSizeUntilLargeSize(this.mActivity, this.mTotalTime, numValueOf.intValue());
        CharUtils.applyTextSizeUntilLargeSize(this.mActivity, this.mEraserText, numValueOf.intValue());
    }

    private final void setToolTipText() {
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setTooltipText(this.mBackward);
        companion.getInstance().setTooltipText(this.mForward);
        companion.getInstance().setTooltipText(this.mEraser);
    }

    private final void updateAudioEraser() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mPresenter.getEraserState().ordinal()];
        if (i == 1) {
            this.mPresenter.changeToNormalVoice();
            return;
        }
        if (i == 2) {
            this.mPresenter.executeAudioEraser();
        } else if (i == 3) {
            Logger.m10999d(TAG, "updateAudioEraser# eraser is running");
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.m11000e(TAG, "updateAudioEraser# eraser state is error");
        }
    }

    private final void updateMarginEnd(View button, int marginEnd) {
        ViewGroup.LayoutParams layoutParams = button != null ? button.getLayoutParams() : null;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(marginEnd);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).setMarginEnd(marginEnd);
        }
        if (button != null) {
            button.setLayoutParams(layoutParams);
        }
    }

    @Nullable
    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final boolean getMIsStartTrack() {
        return this.mIsStartTrack;
    }

    @Nullable
    public final TextView getMPlayTime() {
        return this.mPlayTime;
    }

    @NotNull
    public final VoiceRecordMenuPresenter getMPresenter() {
        return this.mPresenter;
    }

    @Nullable
    public final SeslSeekBar getMSeekBar() {
        return this.mSeekBar;
    }

    @Nullable
    public final TextView getMTotalTime() {
        return this.mTotalTime;
    }

    @Nullable
    public final View getMVoiceMenu() {
        return this.mVoiceMenu;
    }

    public final void hideSpeedPopup() {
        PopupWindow popupWindow = this.mSpeedPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public abstract void insertSALog();

    public final void makeAudioEraserEffect() {
        Activity activity;
        if (Build.VERSION.SDK_INT < 33 || (activity = this.mActivity) == null) {
            return;
        }
        AIGuidingLightEffect.applyGuidingLightEffectBackground(this.mEraserLayoutTargetBG, activity, 0, activity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_speed_button_radius));
    }

    public abstract void moveBackwardSALog();

    public final void moveForward() {
        SeslSeekBar seslSeekBar = this.mSeekBar;
        if (seslSeekBar == null) {
            return;
        }
        int progress = seslSeekBar.getProgress() + 10000;
        int max = seslSeekBar.getMax();
        if (progress >= max) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(new RunnableC9767a(this, 16), 100L);
            }
            progress = max;
        }
        this.mPresenter.seekTo(progress);
    }

    public abstract void moveForwardSALog();

    public final void moveRewind() {
        SeslSeekBar seslSeekBar = this.mSeekBar;
        if (seslSeekBar == null) {
            return;
        }
        int progress = seslSeekBar.getProgress() - 10000;
        if (progress < 0) {
            progress = 0;
        }
        this.mPresenter.seekTo(progress);
    }

    public final void releaseAudioEraser() {
        if (Build.VERSION.SDK_INT >= 33) {
            AIGuidingLightEffect.removeGuideLightingEffect(this.mEraserLayoutTargetBG);
            TextView textView = this.mEraserText;
            if (textView != null) {
                AIGuidingLightEffect.INSTANCE.removeProcessingLightEffect(textView);
            }
            LottieAnimationView lottieAnimationView = this.mEraserDoneAnimation;
            if (lottieAnimationView != null) {
                AIGuidingLightEffect.INSTANCE.removeProcessingLightEffect(lottieAnimationView);
            }
        }
        LottieAnimationView lottieAnimationView2 = this.mEraserDoneAnimation;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        this.mEraserDoneAnimation = null;
    }

    public final void setMActivity(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    public final void setMIsStartTrack(boolean z) {
        this.mIsStartTrack = z;
    }

    public final void setMPlayTime(@Nullable TextView textView) {
        this.mPlayTime = textView;
    }

    public final void setMPresenter(@NotNull VoiceRecordMenuPresenter voiceRecordMenuPresenter) {
        Intrinsics.checkNotNullParameter(voiceRecordMenuPresenter, "<set-?>");
        this.mPresenter = voiceRecordMenuPresenter;
    }

    public final void setMSeekBar(@Nullable SeslSeekBar seslSeekBar) {
        this.mSeekBar = seslSeekBar;
    }

    public final void setMTotalTime(@Nullable TextView textView) {
        this.mTotalTime = textView;
    }

    public final void setMVoiceMenu(@Nullable View view) {
        this.mVoiceMenu = view;
    }

    public final void setPlayProgress(int progress) {
        SeslSeekBar seslSeekBar;
        if (this.mIsStartTrack || (seslSeekBar = this.mSeekBar) == null) {
            return;
        }
        seslSeekBar.setProgress(progress);
    }

    public final void setPlaySpeed(@Nullable String speed) {
        Button button = this.mSpeed;
        if (button != null) {
            button.setText(speed);
        }
    }

    public final void setPlayTime(@Nullable String time) {
        if (this.mIsStartTrack) {
            return;
        }
        VoiceUtil.INSTANCE.updateTimeEms(this.mPlayTime, time);
    }

    public abstract void setPlayTimeView(@Nullable String time);

    public final void setTotalTime(@Nullable String time) {
        VoiceUtil.INSTANCE.updateTimeEms(this.mTotalTime, time);
    }

    public final void showSpeedPopup(@Nullable View anchorView) {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        PopupWindow popupWindow = this.mSpeedPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        View viewInflate = activity.getLayoutInflater().inflate(C9086R.layout.comp_voice_record_speed_popup_layout, (ViewGroup) null);
        PopupWindow popupWindow2 = new PopupWindow(viewInflate, -2, -2);
        this.mSpeedPopup = popupWindow2;
        PopupWindowHelper.setDefaultState(popupWindow2, activity);
        RecyclerView recyclerView = viewInflate != null ? (RecyclerView) viewInflate.findViewById(C9086R.id.list_speed_item) : null;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(1);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(new VoiceSpeedAdapter(VoiceManager.getSpeed(), new VoiceSpeedAdapter.VoiceSpeedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu.showSpeedPopup.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.VoiceSpeedAdapter.VoiceSpeedListener
                public void onItemCLick(float changeSpeed) {
                    VoiceRecordControlMenu.this.getMPresenter().changeSpeed(changeSpeed);
                    PopupWindow popupWindow3 = VoiceRecordControlMenu.this.mSpeedPopup;
                    if (popupWindow3 != null) {
                        popupWindow3.dismiss();
                    }
                }
            }, ContextUtils.isNightMode(activity)));
        }
        PopupWindow popupWindow3 = this.mSpeedPopup;
        if (popupWindow3 != null) {
            popupWindow3.showAsDropDown(anchorView);
        }
    }

    public final void updateAudioEraserAnimation(boolean isEnable) {
        if (this.mPresenter.getEraserState() != EraserState.ERASED) {
            return;
        }
        if (isEnable) {
            LottieAnimationView lottieAnimationView = this.mEraserDoneAnimation;
            if (lottieAnimationView != null) {
                lottieAnimationView.resumeAnimation();
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.mEraserDoneAnimation;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.pauseAnimation();
        }
    }

    public final void updateAudioEraserLayout(boolean isShowing) {
        if (isShowing) {
            View view = this.mEraserLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            updateViewEraser();
            return;
        }
        View view2 = this.mEraserLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        updateMarginEnd(this.mTotalTime, 0);
    }

    @SuppressLint({"RestrictedApi"})
    public final void updateBackground(int textIconColor, boolean isDarkTheme, int reverseColor) {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        TextView textView = this.mPlayTime;
        if (textView != null) {
            textView.setTextColor(textIconColor);
        }
        Button button = this.mSpeed;
        if (button != null) {
            button.setTextColor(textIconColor);
        }
        ImageView imageView = this.mForward;
        if (imageView != null) {
            imageView.setColorFilter(textIconColor);
        }
        ImageView imageView2 = this.mBackward;
        if (imageView2 != null) {
            imageView2.setColorFilter(textIconColor);
        }
        TextView textView2 = this.mTotalTime;
        if (textView2 != null) {
            textView2.setTextColor(ColorUtils.setAlphaComponent(reverseColor, 128));
        }
        int color = ContextCompat.getColor(activity, C9086R.color.composer_voice_menu_border_button_color);
        int color2 = ContextCompat.getColor(activity, C9086R.color.composer_voice_seek_bar_progress_and_thumb);
        if (isDarkTheme) {
            color = ContextCompat.getColor(activity, C9086R.color.composer_voice_menu_dark_border_button_color);
            color2 = ContextCompat.getColor(activity, C9086R.color.composer_voice_seek_bar_progress_and_thumb_dark_color);
        }
        Button button2 = this.mSpeed;
        Drawable background = button2 != null ? button2.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setStroke(activity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_divider_height), color);
        SeslSeekBar seslSeekBar = this.mSeekBar;
        if (seslSeekBar != null) {
            seslSeekBar.setProgressTintList(ColorStateList.valueOf(color2));
        }
        SeslSeekBar seslSeekBar2 = this.mSeekBar;
        if (seslSeekBar2 != null) {
            seslSeekBar2.setThumbTintList(ColorStateList.valueOf(color2));
        }
        if (this.mIsNormalPlay || !this.mPresenter.isSupportAudioEraser()) {
            return;
        }
        updateViewEraser();
    }

    public final void updateProcessingLightEffect() {
        if (this.mPresenter.getEraserState() == EraserState.ERASING && Build.VERSION.SDK_INT >= 33) {
            TextView textView = this.mEraserText;
            if (textView != null) {
                AIGuidingLightEffect.INSTANCE.makeProcessingLightEffect(textView).start();
            }
            LottieAnimationView lottieAnimationView = this.mEraserDoneAnimation;
            if (lottieAnimationView != null) {
                AIGuidingLightEffect.INSTANCE.makeProcessingLightEffect(lottieAnimationView).start();
            }
        }
    }

    public void updateView() {
        if (this.mPresenter.isSupportAudioEraser()) {
            return;
        }
        updateAudioEraserLayout(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateViewEraser() {
        String string;
        LottieAnimationView lottieAnimationView;
        ViewGroup.LayoutParams layoutParams;
        Resources resources;
        TextView textView;
        ViewGroup.LayoutParams layoutParams2;
        Resources resources2;
        if (this.mPresenter.isSupportAudioEraser()) {
            int dimensionPixelSize = 0;
            if (!this.mPresenter.isEnableAudioEraser()) {
                updateAudioEraserLayout(false);
                return;
            }
            View view = this.mEraserLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.mEraserDoneAnimation == null) {
                View view2 = this.mVoiceMenu;
                this.mEraserDoneAnimation = view2 != null ? (LottieAnimationView) view2.findViewById(C9086R.id.voice_record_eraser_done_animation) : null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[this.mPresenter.getEraserState().ordinal()];
            if (i == 1) {
                LottieAnimationView lottieAnimationView2 = this.mEraserDoneAnimation;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView3 = this.mEraserDoneAnimation;
                if (lottieAnimationView3 != null) {
                    lottieAnimationView3.setRepeatCount(-1);
                }
                LottieAnimationView lottieAnimationView4 = this.mEraserDoneAnimation;
                if (lottieAnimationView4 != null && (layoutParams = lottieAnimationView4.getLayoutParams()) != null) {
                    Activity activity = this.mActivity;
                    if (activity != null && (resources = activity.getResources()) != null) {
                        dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.voice_record_audio_eraser_done_width);
                    }
                    layoutParams.width = dimensionPixelSize;
                }
                if (ContextUtils.isNightMode(this.mActivity)) {
                    Activity activity2 = this.mActivity;
                    string = activity2 != null ? activity2.getString(C9086R.string.audio_eraser_lottie_fileName) : null;
                } else {
                    Activity activity3 = this.mActivity;
                    if (activity3 != null) {
                        string = activity3.getString(C9086R.string.audio_eraser_lottie_fileName_dark);
                    }
                }
                LottieAnimationView lottieAnimationView5 = this.mEraserDoneAnimation;
                if (lottieAnimationView5 != null) {
                    lottieAnimationView5.setAnimation(string);
                }
                LottieAnimationView lottieAnimationView6 = this.mEraserDoneAnimation;
                if (lottieAnimationView6 != null) {
                    lottieAnimationView6.setProgress(0.0f);
                }
                if (this.mPresenter.isPlayingState() && (lottieAnimationView = this.mEraserDoneAnimation) != null) {
                    lottieAnimationView.playAnimation();
                }
                TextView textView2 = this.mEraserText;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.mEraser;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                Activity activity4 = this.mActivity;
                if (activity4 != null) {
                    Resources resources3 = activity4.getResources();
                    if (this.mPresenter.isLineVoiceLayout()) {
                        updateMarginEnd(this.mTotalTime, resources3.getDimensionPixelSize(C9086R.dimen.voice_record_speed_button_margin_audio_eraser_done));
                    }
                    LottieAnimationView lottieAnimationView7 = this.mEraserDoneAnimation;
                    ViewGroup.LayoutParams layoutParams3 = lottieAnimationView7 != null ? lottieAnimationView7.getLayoutParams() : null;
                    if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                        layoutParams4.setMarginStart(resources3.getDimensionPixelSize(C9086R.dimen.voice_record_audio_eraser_done_margin));
                        layoutParams4.setMarginEnd(resources3.getDimensionPixelSize(C9086R.dimen.voice_record_audio_eraser_done_margin));
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 2) {
                LottieAnimationView lottieAnimationView8 = this.mEraserDoneAnimation;
                if (lottieAnimationView8 != null) {
                    lottieAnimationView8.cancelAnimation();
                }
                LottieAnimationView lottieAnimationView9 = this.mEraserDoneAnimation;
                if (lottieAnimationView9 != null) {
                    lottieAnimationView9.setVisibility(8);
                }
                ImageView imageView2 = this.mEraser;
                if (imageView2 != null) {
                    imageView2.setImageResource(C9086R.drawable.voice_record_audio_eraser);
                }
                TextView textView3 = this.mEraserText;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                ImageView imageView3 = this.mEraser;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
                ImageView imageView4 = this.mEraser;
                if (imageView4 != null) {
                    imageView4.setAlpha(1.0f);
                }
                Activity activity5 = this.mActivity;
                if (activity5 == null || !this.mPresenter.isLineVoiceLayout()) {
                    return;
                }
                updateMarginEnd(this.mTotalTime, activity5.getResources().getDimensionPixelSize(C9086R.dimen.voice_record_speed_button_margin_audio_eraser));
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.m11000e(TAG, "updateViewEraser# eraser state is error");
                return;
            }
            LottieAnimationView lottieAnimationView10 = this.mEraserDoneAnimation;
            if (lottieAnimationView10 != null) {
                lottieAnimationView10.setVisibility(0);
            }
            LottieAnimationView lottieAnimationView11 = this.mEraserDoneAnimation;
            if (lottieAnimationView11 != null) {
                lottieAnimationView11.setRepeatCount(-1);
            }
            LottieAnimationView lottieAnimationView12 = this.mEraserDoneAnimation;
            if (lottieAnimationView12 != null && (layoutParams2 = lottieAnimationView12.getLayoutParams()) != null) {
                Activity activity6 = this.mActivity;
                layoutParams2.width = (activity6 == null || (resources2 = activity6.getResources()) == null) ? 0 : resources2.getDimensionPixelSize(C9086R.dimen.voice_record_audio_four_star_width);
            }
            LottieAnimationView lottieAnimationView13 = this.mEraserDoneAnimation;
            if (lottieAnimationView13 != null) {
                Activity activity7 = this.mActivity;
                lottieAnimationView13.setAnimation(activity7 != null ? activity7.getString(C9086R.string.four_starts_lottie_fileName) : null);
            }
            LottieAnimationView lottieAnimationView14 = this.mEraserDoneAnimation;
            if (lottieAnimationView14 != null) {
                lottieAnimationView14.playAnimation();
            }
            ImageView imageView5 = this.mEraser;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            TextView textView4 = this.mEraserText;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = this.mEraserText;
            if (textView5 != null) {
                Activity activity8 = this.mActivity;
                textView5.setText(activity8 != null ? activity8.getString(C9086R.string.voice_record_analyzing_audio) : null);
            }
            if (this.mActivity == null || (textView = this.mEraserText) == null) {
                return;
            }
            textView.setTextSize(1, 12.0f);
        }
    }
}

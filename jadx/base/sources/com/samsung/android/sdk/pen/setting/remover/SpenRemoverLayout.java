package com.samsung.android.sdk.pen.setting.remover;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.setting.common.C7558c;
import com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.common.SpenSwitchView;
import com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p091W2.C0331a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0016\b\u0000\u0018\u0000 K2\u00020\u0001:\u0003KLMB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020&J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020&J\u000e\u0010+\u001a\u00020!2\u0006\u0010*\u001a\u00020&J\u001d\u0010,\u001a\u00020!2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0007¢\u0006\u0002\u00100J\u0010\u0010:\u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010\nJ\u0010\u0010<\u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010\fJ\u0016\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020&H\u0002J\u001a\u0010D\u001a\u00020!2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020&H\u0002J\"\u0010H\u001a\u00020!2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020&H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u00102\u001a\u00020/2\u0006\u00101\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020/0.8G¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout;", "Lcom/samsung/android/sdk/pen/setting/common/SpenRadioListLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout$OnActionListener;", "mEventListener", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout$OnEventListener;", "mSeekBar", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "mSeekBarLayout", "Landroid/widget/RelativeLayout;", "mHighlighterSwitch", "Lcom/samsung/android/sdk/pen/setting/common/SpenSwitchView;", "mDataManager", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverDataManager;", "mOnSizeChangedListener", "com/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout$mOnSizeChangedListener$1", "Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout$mOnSizeChangedListener$1;", "mOnTrackActionListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderTrackListener;", "mOnButtonActionListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderButtonListener;", "mRadioBtnListener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "mHighlighterOnlyChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "close", "", "setVisibility", "visibility", "", "setSupportHighlighterOnly", "", "highlighterOnly", "animation", "setSupportRemoverType", "support", "setSupportStrokeEraserSize", "setRemoverInfoList", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "([Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "settingCutterInfo", "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "removerInfoList", "getRemoverInfoList", "()[Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setEventListener", "setChildViewState", "enabled", "alpha", "", "construct", "updateView", "needAnimation", "scaleViewAnimation", "view", "Landroid/view/View;", Constants.IntentExtraValue.SHOW, "setViewState", "setHighlighterSwitch", "isChecked", "Companion", "OnActionListener", "OnEventListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRemoverLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRemoverLayout.kt\ncom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,270:1\n1#2:271\n*E\n"})
public final class SpenRemoverLayout extends SpenRadioListLayout {
    private static final int ERASE_AREA_MAX = 10;
    private static final int SCALE_UP_ANIMATION_OFFSET = 150;

    @NotNull
    private static final String TAG = "SpenRemoverBodyLayout";

    @Nullable
    private OnActionListener mActionListener;
    private SpenRemoverDataManager mDataManager;

    @Nullable
    private OnEventListener mEventListener;

    @NotNull
    private final CompoundButton.OnCheckedChangeListener mHighlighterOnlyChangeListener;

    @Nullable
    private SpenSwitchView mHighlighterSwitch;

    @NotNull
    private final SpenSlider.OnSliderButtonListener mOnButtonActionListener;

    @NotNull
    private final SpenRemoverLayout$mOnSizeChangedListener$1 mOnSizeChangedListener;

    @NotNull
    private final SpenSlider.OnSliderTrackListener mOnTrackActionListener;

    @NotNull
    private final RadioGroup.OnCheckedChangeListener mRadioBtnListener;
    private SpenSlider mSeekBar;
    private RelativeLayout mSeekBarLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout$OnActionListener;", "", "onTypeChanged", "", "type", "", "onSizeChanged", "size", "", "onTargetChanged", "target", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onSizeChanged(float size);

        void onTargetChanged(int target);

        void onTypeChanged(int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverLayout$OnEventListener;", "", "onSizeButtonPressed", "", "onStartTrackingTouch", "onStopTrackingTouch", "onStartSizeButtonLongClick", "onStopSizeButtonLongClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnEventListener {
        void onSizeButtonPressed();

        void onStartSizeButtonLongClick();

        void onStartTrackingTouch();

        void onStopSizeButtonLongClick();

        void onStopTrackingTouch();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnSizeChangedListener$1] */
    public SpenRemoverLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnSizeChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnSizeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int size, boolean fromUser) {
                SpenRemoverDataManager spenRemoverDataManager = this.this$0.mDataManager;
                SpenRemoverDataManager spenRemoverDataManager2 = null;
                if (spenRemoverDataManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    spenRemoverDataManager = null;
                }
                AbstractC0000a.m26w(AbstractC2821a.m2226q("onSizeChanged() size = ", size, " fromUser=", fromUser, " type="), "SpenRemoverBodyLayout", spenRemoverDataManager.getCurrentType());
                SpenRemoverDataManager spenRemoverDataManager3 = this.this$0.mDataManager;
                if (spenRemoverDataManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    spenRemoverDataManager3 = null;
                }
                float f = size;
                spenRemoverDataManager3.setCurrentSize(f);
                SpenRemoverDataManager spenRemoverDataManager4 = this.this$0.mDataManager;
                if (spenRemoverDataManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    spenRemoverDataManager4 = null;
                }
                if (!spenRemoverDataManager4.getMIsSupportStrokeEraseSize()) {
                    SpenRemoverDataManager spenRemoverDataManager5 = this.this$0.mDataManager;
                    if (spenRemoverDataManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    } else {
                        spenRemoverDataManager2 = spenRemoverDataManager5;
                    }
                    if (spenRemoverDataManager2.getCurrentType() == 1) {
                        return;
                    }
                }
                SpenRemoverLayout.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onSizeChanged(f);
                }
            }
        };
        this.mOnTrackActionListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnTrackActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStopTrackingTouch();
                }
            }
        };
        this.mOnButtonActionListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnButtonActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onSizeButtonPressed();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStartSizeButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStopSizeButtonLongClick();
                }
            }
        };
        this.mRadioBtnListener = new C7558c(this, 2);
        this.mHighlighterOnlyChangeListener = new C0331a(this, 3);
        construct(context);
    }

    private final void construct(Context context) {
        View.inflate(context, C7932R.layout.setting_remover_layout_body_v52, this);
        setClipChildren(false);
        initLayout(C7932R.id.remover_radio_group, this.mRadioBtnListener);
        setItem(C7932R.id.remover_radio_button_1, C7932R.id.remover_radio_ripple_button_view_1, C7932R.string.pen_string_stroke_eraser);
        setItem(C7932R.id.remover_radio_button_2, C7932R.id.remover_radio_ripple_button_view_2, C7932R.string.pen_string_area_eraser);
        setVisibilityCheck(true);
        View viewFindViewById = findViewById(C7932R.id.remover_cutter_seekbar);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mSeekBarLayout = (RelativeLayout) viewFindViewById;
        SpenSlider spenSlider = new SpenSlider(context, false, 1, 10, SpenSlider.SliderType.DISCRETE);
        this.mSeekBar = spenSlider;
        spenSlider.setColor(SpenSettingUtil.getColor(context, C7932R.color.component_common));
        spenSlider.setValue(1, false);
        spenSlider.setThumbAnimationEnable(false);
        RelativeLayout relativeLayout = this.mSeekBarLayout;
        SpenSlider spenSlider2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarLayout");
            relativeLayout = null;
        }
        SpenSlider spenSlider3 = this.mSeekBar;
        if (spenSlider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            spenSlider3 = null;
        }
        relativeLayout.addView(spenSlider3);
        RelativeLayout relativeLayout2 = this.mSeekBarLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarLayout");
            relativeLayout2 = null;
        }
        relativeLayout2.setVisibility(8);
        SpenSlider spenSlider4 = this.mSeekBar;
        if (spenSlider4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        } else {
            spenSlider2 = spenSlider4;
        }
        spenSlider2.setOnChangedListener(this.mOnSizeChangedListener);
        spenSlider2.setOnTrackListener(this.mOnTrackActionListener);
        spenSlider2.setOnPlusButtonActionListener(this.mOnButtonActionListener);
        spenSlider2.setOnMinusButtonActionListener(this.mOnButtonActionListener);
        spenSlider2.setAccessibilityPostfix(context.getResources().getString(C7932R.string.pen_string_size));
        SpenSwitchView spenSwitchView = (SpenSwitchView) findViewById(C7932R.id.remover_cutter_switch);
        this.mHighlighterSwitch = spenSwitchView;
        if (spenSwitchView != null) {
            spenSwitchView.setText(C7932R.string.pen_string_eraser_highlight_only);
            spenSwitchView.setOnCheckedChangeListener(this.mHighlighterOnlyChangeListener);
        }
        this.mDataManager = new SpenRemoverDataManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mHighlighterOnlyChangeListener$lambda$1(SpenRemoverLayout spenRemoverLayout, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        int i = z ? 2 : 0;
        SpenRemoverDataManager spenRemoverDataManager = spenRemoverLayout.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        spenRemoverDataManager.setTarget(i);
        OnActionListener onActionListener = spenRemoverLayout.mActionListener;
        if (onActionListener != null) {
            onActionListener.onTargetChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRadioBtnListener$lambda$0(SpenRemoverLayout spenRemoverLayout, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        Log.i(TAG, "mRadioBtnListener OnCheckedChangeListener checkedId =" + i + " mDataChangeListener=" + (spenRemoverLayout.mActionListener == null ? "NUL" : "NOT NULL"));
        int i2 = i == C7932R.id.remover_radio_button_2 ? 0 : 1;
        SpenRemoverDataManager spenRemoverDataManager = spenRemoverLayout.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        spenRemoverDataManager.setCurrentType(i2);
        OnActionListener onActionListener = spenRemoverLayout.mActionListener;
        if (onActionListener != null) {
            onActionListener.onTypeChanged(i2);
        }
        spenRemoverLayout.updateView(true);
    }

    private final void scaleViewAnimation(View view, boolean show) {
        Animation animationLoadAnimation;
        if (view == null) {
            return;
        }
        if (show) {
            view.setVisibility(0);
            animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C7932R.anim.spen_seekbar_scale_up);
            animationLoadAnimation.setStartOffset(150L);
        } else {
            view.setVisibility(8);
            animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C7932R.anim.spen_seekbar_scale_down);
        }
        view.startAnimation(animationLoadAnimation);
    }

    private final void setHighlighterSwitch(boolean isChecked) {
        SpenSwitchView spenSwitchView = this.mHighlighterSwitch;
        if (spenSwitchView == null || spenSwitchView.isChecked() == isChecked) {
            return;
        }
        spenSwitchView.setChecked(isChecked);
    }

    public static /* synthetic */ boolean setSupportHighlighterOnly$default(SpenRemoverLayout spenRemoverLayout, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return spenRemoverLayout.setSupportHighlighterOnly(z, z2);
    }

    private final void setViewState(View view, boolean enabled, float alpha) {
        if (view == null) {
            return;
        }
        view.setAlpha(alpha);
        view.setEnabled(enabled);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateView(boolean needAnimation) {
        SpenRemoverDataManager spenRemoverDataManager = this.mDataManager;
        RelativeLayout relativeLayout = null;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        SpenSettingRemoverInfo currentInfo = spenRemoverDataManager.getCurrentInfo();
        int i = currentInfo.type;
        int i2 = i == 0 ? C7932R.id.remover_radio_button_2 : C7932R.id.remover_radio_button_1;
        if (i == 0) {
            SpenSlider spenSlider = this.mSeekBar;
            if (spenSlider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                spenSlider = null;
            }
            spenSlider.setValue((int) currentInfo.size, false);
        } else {
            SpenRemoverDataManager spenRemoverDataManager2 = this.mDataManager;
            if (spenRemoverDataManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                spenRemoverDataManager2 = null;
            }
            if (spenRemoverDataManager2.getMIsSupportStrokeEraseSize()) {
            }
        }
        setHighlighterSwitch(currentInfo.target == 2);
        setInfo(i2);
        SpenRemoverDataManager spenRemoverDataManager3 = this.mDataManager;
        if (spenRemoverDataManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager3 = null;
        }
        if (spenRemoverDataManager3.getMIsSupportStrokeEraseSize()) {
            RelativeLayout relativeLayout2 = this.mSeekBarLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBarLayout");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(0);
            return;
        }
        if (needAnimation) {
            RelativeLayout relativeLayout3 = this.mSeekBarLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBarLayout");
            } else {
                relativeLayout = relativeLayout3;
            }
            scaleViewAnimation(relativeLayout, currentInfo.type != 1);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout
    public void close() {
        super.close();
        SpenRemoverDataManager spenRemoverDataManager = null;
        this.mActionListener = null;
        this.mEventListener = null;
        SpenSlider spenSlider = this.mSeekBar;
        if (spenSlider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            spenSlider = null;
        }
        spenSlider.close();
        SpenSwitchView spenSwitchView = this.mHighlighterSwitch;
        if (spenSwitchView != null) {
            spenSwitchView.close();
        }
        this.mHighlighterSwitch = null;
        SpenRemoverDataManager spenRemoverDataManager2 = this.mDataManager;
        if (spenRemoverDataManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
        } else {
            spenRemoverDataManager = spenRemoverDataManager2;
        }
        spenRemoverDataManager.close();
    }

    @NotNull
    public final SpenSettingRemoverInfo getInfo() {
        SpenRemoverDataManager spenRemoverDataManager = this.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        return spenRemoverDataManager.getCurrentInfo();
    }

    @Deprecated(message = "")
    @NotNull
    public final SpenSettingRemoverInfo[] getRemoverInfoList() {
        SpenRemoverDataManager spenRemoverDataManager = this.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        return spenRemoverDataManager.getInfoList();
    }

    public final void setActionListener(@Nullable OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setChildViewState(boolean enabled, float alpha) {
        setViewState(getRadioGroup(), enabled, alpha);
        setViewState(this.mHighlighterSwitch, enabled, alpha);
    }

    public final void setEventListener(@Nullable OnEventListener listener) {
        this.mEventListener = listener;
    }

    public final void setInfo(@NotNull SpenSettingRemoverInfo settingCutterInfo) {
        Intrinsics.checkNotNullParameter(settingCutterInfo, "settingCutterInfo");
        if (settingCutterInfo.size < 0.0f) {
            settingCutterInfo.size = 0.0f;
        }
        SpenRemoverDataManager spenRemoverDataManager = this.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        spenRemoverDataManager.setInfo(settingCutterInfo);
        updateView(false);
    }

    @Deprecated(message = "")
    public final void setRemoverInfoList(@Nullable SpenSettingRemoverInfo[] list) {
        Log.i(TAG, "setRemoverInfoList() !!!!!!!!!!!!!!!");
        if (list == null) {
            return;
        }
        SpenRemoverDataManager spenRemoverDataManager = this.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        spenRemoverDataManager.setInfoList(list);
    }

    public final boolean setSupportHighlighterOnly(boolean highlighterOnly, boolean animation) {
        int i = highlighterOnly ? 0 : 8;
        SpenSwitchView spenSwitchView = this.mHighlighterSwitch;
        if (spenSwitchView != null && spenSwitchView.getVisibility() == i) {
            return false;
        }
        if (animation) {
            scaleViewAnimation(this.mHighlighterSwitch, highlighterOnly);
        } else {
            SpenSwitchView spenSwitchView2 = this.mHighlighterSwitch;
            if (spenSwitchView2 != null) {
                spenSwitchView2.setVisibility(i);
            }
        }
        return true;
    }

    public final void setSupportRemoverType(boolean support) {
        View viewFindViewById = findViewById(C7932R.id.remover_radio_group);
        View viewFindViewById2 = findViewById(C7932R.id.remover_radio_ripple_group);
        int i = support ? 0 : 8;
        viewFindViewById.setVisibility(i);
        viewFindViewById2.setVisibility(i);
    }

    public final void setSupportStrokeEraserSize(boolean support) {
        SpenRemoverDataManager spenRemoverDataManager = this.mDataManager;
        if (spenRemoverDataManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
            spenRemoverDataManager = null;
        }
        spenRemoverDataManager.setSupportStrokeEraseSize(support);
        updateView(false);
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout, android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        SpenSlider spenSlider = null;
        if (visibility == 0 && getCheckedId() == C7932R.id.remover_radio_button_2) {
            SpenSlider spenSlider2 = this.mSeekBar;
            if (spenSlider2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            } else {
                spenSlider = spenSlider2;
            }
            spenSlider.setVisibility(0);
            return;
        }
        SpenSlider spenSlider3 = this.mSeekBar;
        if (spenSlider3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        } else {
            spenSlider = spenSlider3;
        }
        spenSlider.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnSizeChangedListener$1] */
    public SpenRemoverLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnSizeChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnSizeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int size, boolean fromUser) {
                SpenRemoverDataManager spenRemoverDataManager = this.this$0.mDataManager;
                SpenRemoverDataManager spenRemoverDataManager2 = null;
                if (spenRemoverDataManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    spenRemoverDataManager = null;
                }
                AbstractC0000a.m26w(AbstractC2821a.m2226q("onSizeChanged() size = ", size, " fromUser=", fromUser, " type="), "SpenRemoverBodyLayout", spenRemoverDataManager.getCurrentType());
                SpenRemoverDataManager spenRemoverDataManager3 = this.this$0.mDataManager;
                if (spenRemoverDataManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    spenRemoverDataManager3 = null;
                }
                float f = size;
                spenRemoverDataManager3.setCurrentSize(f);
                SpenRemoverDataManager spenRemoverDataManager4 = this.this$0.mDataManager;
                if (spenRemoverDataManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    spenRemoverDataManager4 = null;
                }
                if (!spenRemoverDataManager4.getMIsSupportStrokeEraseSize()) {
                    SpenRemoverDataManager spenRemoverDataManager5 = this.this$0.mDataManager;
                    if (spenRemoverDataManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDataManager");
                    } else {
                        spenRemoverDataManager2 = spenRemoverDataManager5;
                    }
                    if (spenRemoverDataManager2.getCurrentType() == 1) {
                        return;
                    }
                }
                SpenRemoverLayout.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onSizeChanged(f);
                }
            }
        };
        this.mOnTrackActionListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnTrackActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStopTrackingTouch();
                }
            }
        };
        this.mOnButtonActionListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.remover.SpenRemoverLayout$mOnButtonActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onSizeButtonPressed();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStartSizeButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenRemoverLayout.OnEventListener onEventListener = this.this$0.mEventListener;
                if (onEventListener != null) {
                    onEventListener.onStopSizeButtonLongClick();
                }
            }
        };
        this.mRadioBtnListener = new C7558c(this, 2);
        this.mHighlighterOnlyChangeListener = new C0331a(this, 3);
        construct(context);
    }
}

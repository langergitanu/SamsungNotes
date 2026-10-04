package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 A2\u00020\u0001:\u0002ABB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\fB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000fBA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0012BI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0013J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0017H\u0016J\u0012\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u00101\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010!H\u0016J\u0012\u00102\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010!H\u0016J\u0012\u00103\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010$H\u0016J\u0010\u00104\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\b\u00105\u001a\u00020,H\u0002J\u0018\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u0017H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u00108\u001a\u00020\u0017H\u0002J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u000bH\u0002J\b\u0010<\u001a\u00020,H\u0002J\b\u0010=\u001a\u00020,H\u0002J\u0018\u0010>\u001a\u00020,2\u0006\u00107\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0010\u0010?\u001a\u00020,2\u0006\u0010;\u001a\u00020\u000bH\u0002J\b\u0010@\u001a\u00020,H\u0002R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider;", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "context", "Landroid/content/Context;", "hasOutline", "", "sliderType", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;", "<init>", "(Landroid/content/Context;ZLcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "layoutId", "", "(Landroid/content/Context;ZILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "(Landroid/content/Context;ZIILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "minStringID", "maxStringID", "(Landroid/content/Context;ZIIIILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "(Landroid/content/Context;ZIIIIILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "mDelayHandler", "Landroid/os/Handler;", "mLabelFormat", "", "mLabelDelayRunnable", "Ljava/lang/Runnable;", "mLabelState", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider$OnLabelListener$LabelState;", "mLabelListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider$OnLabelListener;", "mChangedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnChangedListener;", "mPlusButtonListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderButtonListener;", "mMinusButtonListener", "mTrackListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderTrackListener;", "mIsWaitingToHide", "mIsWorkingLabelRunnable", "mOnChangedListener", "mOnPlusButtonListener", "mOnMinusButtonListener", "mOnSliderTrackListener", "close", "", "setLabelFormat", "format", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnPlusButtonActionListener", "setOnMinusButtonActionListener", "setOnTrackListener", "setOnLabelListener", "construct", "notifyLabelStateChanged", "state", "text", "notifyLabelChanged", "getLabelText", "value", "initStateRunnable", "closeStateRunnable", "setLabelStateChange", "setLabelTextChange", "startLabelDelayRunner", "Companion", "OnLabelListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenUserLabelSlider extends SpenSlider {
    private static final int STATE_HOLDING_MIN_TIME = 300;

    @NotNull
    private static final String TAG = "SpenUserLabelSlider";

    @Nullable
    private SpenSlider.OnChangedListener mChangedListener;
    private Handler mDelayHandler;
    private boolean mIsWaitingToHide;
    private boolean mIsWorkingLabelRunnable;
    private Runnable mLabelDelayRunnable;
    private String mLabelFormat;

    @Nullable
    private OnLabelListener mLabelListener;

    @Nullable
    private OnLabelListener.LabelState mLabelState;

    @Nullable
    private SpenSlider.OnSliderButtonListener mMinusButtonListener;

    @NotNull
    private final SpenSlider.OnChangedListener mOnChangedListener;

    @NotNull
    private final SpenSlider.OnSliderButtonListener mOnMinusButtonListener;

    @NotNull
    private final SpenSlider.OnSliderButtonListener mOnPlusButtonListener;

    @NotNull
    private final SpenSlider.OnSliderTrackListener mOnSliderTrackListener;

    @Nullable
    private SpenSlider.OnSliderButtonListener mPlusButtonListener;

    @Nullable
    private SpenSlider.OnSliderTrackListener mTrackListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider$OnLabelListener;", "", "onLabelStateChanged", "", "state", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider$OnLabelListener$LabelState;", "text", "", "onLabelChanged", "LabelState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnLabelListener {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider$OnLabelListener$LabelState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE", "SHOW", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class LabelState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ LabelState[] $VALUES;
            public static final LabelState HIDE = new LabelState("HIDE", 0);
            public static final LabelState SHOW = new LabelState("SHOW", 1);

            private static final /* synthetic */ LabelState[] $values() {
                return new LabelState[]{HIDE, SHOW};
            }

            static {
                LabelState[] labelStateArr$values = $values();
                $VALUES = labelStateArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(labelStateArr$values);
            }

            private LabelState(String str, int i) {
            }

            @NotNull
            public static EnumEntries<LabelState> getEntries() {
                return $ENTRIES;
            }

            public static LabelState valueOf(String str) {
                return (LabelState) Enum.valueOf(LabelState.class, str);
            }

            public static LabelState[] values() {
                return (LabelState[]) $VALUES.clone();
            }
        }

        void onLabelChanged(@NotNull String text);

        void onLabelStateChanged(@NotNull LabelState state, @NotNull String text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenUserLabelSlider(@NotNull Context context, boolean z, @NotNull SpenSlider.SliderType sliderType) {
        super(context, z, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mOnChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (fromUser && this.this$0.mLabelListener != null) {
                    if (this.this$0.mLabelState == SpenUserLabelSlider.OnLabelListener.LabelState.HIDE) {
                        this.this$0.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, value);
                    } else {
                        this.this$0.setLabelTextChange(value);
                    }
                }
                SpenSlider.OnChangedListener onChangedListener = this.this$0.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(value, fromUser);
                }
            }
        };
        this.mOnPlusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnPlusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnMinusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnMinusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnSliderTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnSliderTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
            }
        };
        construct();
    }

    private final void closeStateRunnable() {
        this.mIsWorkingLabelRunnable = false;
        this.mIsWaitingToHide = false;
        Handler handler = this.mDelayHandler;
        Runnable runnable = null;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDelayHandler");
            handler = null;
        }
        Runnable runnable2 = this.mLabelDelayRunnable;
        if (runnable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabelDelayRunnable");
        } else {
            runnable = runnable2;
        }
        handler.removeCallbacks(runnable);
    }

    private final void construct() {
        this.mLabelFormat = TimeModel.NUMBER_FORMAT;
        this.mLabelState = OnLabelListener.LabelState.HIDE;
        super.setOnChangedListener(this.mOnChangedListener);
        super.setOnPlusButtonActionListener(this.mOnPlusButtonListener);
        super.setOnMinusButtonActionListener(this.mOnMinusButtonListener);
        super.setOnTrackListener(this.mOnSliderTrackListener);
        initStateRunnable();
    }

    private final String getLabelText(int value) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = this.mLabelFormat;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabelFormat");
            str = null;
        }
        return AbstractC2322a.m1624n(str, new Object[]{Integer.valueOf(value)}, 1, "format(format, *args)");
    }

    private final void initStateRunnable() {
        this.mDelayHandler = new Handler();
        this.mLabelDelayRunnable = new RunnableC7599e(this, 0);
        this.mIsWorkingLabelRunnable = false;
        this.mIsWaitingToHide = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStateRunnable$lambda$0(SpenUserLabelSlider spenUserLabelSlider) {
        Log.i(TAG, "[DelayRunnable] waitingToHide=" + spenUserLabelSlider.mIsWaitingToHide + " state=" + spenUserLabelSlider.mLabelState);
        spenUserLabelSlider.mIsWorkingLabelRunnable = false;
        if (spenUserLabelSlider.mIsWaitingToHide && spenUserLabelSlider.mLabelState == OnLabelListener.LabelState.SHOW) {
            spenUserLabelSlider.setLabelStateChange(OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
        }
    }

    private final void notifyLabelChanged(String text) {
        Log.i(TAG, "notifyLabelChanged(" + this.mLabelState + ", [" + text + "])");
        OnLabelListener onLabelListener = this.mLabelListener;
        if (onLabelListener != null) {
            onLabelListener.onLabelChanged(text);
        }
    }

    private final void notifyLabelStateChanged(OnLabelListener.LabelState state, String text) {
        Log.i(TAG, "notifyLabelStateChanged(" + state + ", [" + text + "])");
        OnLabelListener onLabelListener = this.mLabelListener;
        if (onLabelListener != null) {
            onLabelListener.onLabelStateChanged(state, text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLabelStateChange(OnLabelListener.LabelState state, int value) {
        Log.i(TAG, "setLabelStateChange() " + state + " value(" + value + ")");
        if (this.mLabelListener == null) {
            return;
        }
        if (state == OnLabelListener.LabelState.SHOW) {
            startLabelDelayRunner();
        } else {
            AbstractC6670b.m4758s("workingDelay=", " waitingToHide=", TAG, this.mIsWorkingLabelRunnable, this.mIsWaitingToHide);
            if (this.mIsWorkingLabelRunnable) {
                this.mIsWaitingToHide = true;
                return;
            }
            this.mIsWaitingToHide = false;
        }
        this.mLabelState = state;
        notifyLabelStateChanged(state, getLabelText(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLabelTextChange(int value) {
        Log.i(TAG, "setLabelTextChange() state=" + this.mLabelState + " value(" + value + ")");
        if (this.mLabelListener == null || this.mLabelState == OnLabelListener.LabelState.HIDE) {
            return;
        }
        notifyLabelChanged(getLabelText(value));
        startLabelDelayRunner();
    }

    private final void startLabelDelayRunner() {
        AbstractC4539a.m3208r("startLabelDelayRunner() workingDelay=", TAG, this.mIsWorkingLabelRunnable);
        Runnable runnable = null;
        if (this.mIsWorkingLabelRunnable) {
            Handler handler = this.mDelayHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDelayHandler");
                handler = null;
            }
            Runnable runnable2 = this.mLabelDelayRunnable;
            if (runnable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabelDelayRunnable");
                runnable2 = null;
            }
            handler.removeCallbacks(runnable2);
        }
        Handler handler2 = this.mDelayHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDelayHandler");
            handler2 = null;
        }
        Runnable runnable3 = this.mLabelDelayRunnable;
        if (runnable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabelDelayRunnable");
        } else {
            runnable = runnable3;
        }
        handler2.postDelayed(runnable, 300L);
        this.mIsWorkingLabelRunnable = true;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider
    public void close() {
        closeStateRunnable();
        this.mLabelListener = null;
        this.mChangedListener = null;
        this.mPlusButtonListener = null;
        this.mMinusButtonListener = null;
        this.mTrackListener = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider
    public void setLabelFormat(@NotNull String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        super.setLabelFormat(format);
        this.mLabelFormat = format;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider
    public void setOnChangedListener(@Nullable SpenSlider.OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public final void setOnLabelListener(@Nullable OnLabelListener listener) {
        this.mLabelListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider
    public void setOnMinusButtonActionListener(@Nullable SpenSlider.OnSliderButtonListener listener) {
        this.mMinusButtonListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider
    public void setOnPlusButtonActionListener(@Nullable SpenSlider.OnSliderButtonListener listener) {
        this.mPlusButtonListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider
    public void setOnTrackListener(@Nullable SpenSlider.OnSliderTrackListener listener) {
        this.mTrackListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenUserLabelSlider(@NotNull Context context, boolean z, int i, @NotNull SpenSlider.SliderType sliderType) {
        super(context, z, i, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mOnChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (fromUser && this.this$0.mLabelListener != null) {
                    if (this.this$0.mLabelState == SpenUserLabelSlider.OnLabelListener.LabelState.HIDE) {
                        this.this$0.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, value);
                    } else {
                        this.this$0.setLabelTextChange(value);
                    }
                }
                SpenSlider.OnChangedListener onChangedListener = this.this$0.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(value, fromUser);
                }
            }
        };
        this.mOnPlusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnPlusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnMinusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnMinusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnSliderTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnSliderTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
            }
        };
        construct();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenUserLabelSlider(@NotNull Context context, boolean z, int i, int i2, @NotNull SpenSlider.SliderType sliderType) {
        super(context, z, i, i2, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mOnChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (fromUser && this.this$0.mLabelListener != null) {
                    if (this.this$0.mLabelState == SpenUserLabelSlider.OnLabelListener.LabelState.HIDE) {
                        this.this$0.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, value);
                    } else {
                        this.this$0.setLabelTextChange(value);
                    }
                }
                SpenSlider.OnChangedListener onChangedListener = this.this$0.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(value, fromUser);
                }
            }
        };
        this.mOnPlusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnPlusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnMinusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnMinusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnSliderTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnSliderTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
            }
        };
        construct();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenUserLabelSlider(@NotNull Context context, boolean z, int i, int i2, int i4, int i5, @NotNull SpenSlider.SliderType sliderType) {
        super(context, z, i, i2, i4, i5, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mOnChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (fromUser && this.this$0.mLabelListener != null) {
                    if (this.this$0.mLabelState == SpenUserLabelSlider.OnLabelListener.LabelState.HIDE) {
                        this.this$0.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, value);
                    } else {
                        this.this$0.setLabelTextChange(value);
                    }
                }
                SpenSlider.OnChangedListener onChangedListener = this.this$0.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(value, fromUser);
                }
            }
        };
        this.mOnPlusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnPlusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnMinusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnMinusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnSliderTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnSliderTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
            }
        };
        construct();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenUserLabelSlider(@NotNull Context context, boolean z, int i, int i2, int i4, int i5, int i6, @NotNull SpenSlider.SliderType sliderType) {
        super(context, z, i, i2, i4, i5, i6, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mOnChangedListener = new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                if (fromUser && this.this$0.mLabelListener != null) {
                    if (this.this$0.mLabelState == SpenUserLabelSlider.OnLabelListener.LabelState.HIDE) {
                        this.this$0.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, value);
                    } else {
                        this.this$0.setLabelTextChange(value);
                    }
                }
                SpenSlider.OnChangedListener onChangedListener = this.this$0.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(value, fromUser);
                }
            }
        };
        this.mOnPlusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnPlusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mPlusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnMinusButtonListener = new SpenSlider.OnSliderButtonListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnMinusButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onButtonClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onButtonClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStartButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStartButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderButtonListener
            public void onStopButtonLongClick() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderButtonListener onSliderButtonListener = this.this$0.mMinusButtonListener;
                if (onSliderButtonListener != null) {
                    onSliderButtonListener.onStopButtonLongClick();
                }
            }
        };
        this.mOnSliderTrackListener = new SpenSlider.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider$mOnSliderTrackListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.SHOW, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenUserLabelSlider spenUserLabelSlider = this.this$0;
                spenUserLabelSlider.setLabelStateChange(SpenUserLabelSlider.OnLabelListener.LabelState.HIDE, spenUserLabelSlider.getValue());
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
            }
        };
        construct();
    }
}

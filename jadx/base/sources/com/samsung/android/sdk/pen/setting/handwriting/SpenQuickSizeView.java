package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0003\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSizeSlider", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider;", "mSeekBarView", "Landroid/view/View;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnDataChangedListener;", "mSliderListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnSliderListener;", "close", "", "setSizeLevel", "level", "", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSliderListener", "construct", "Companion", "OnDataChangedListener", "OnSliderListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQuickSizeView extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenQuickSizeView";

    @Nullable
    private OnDataChangedListener mDataChangedListener;
    private View mSeekBarView;
    private SpenUserLabelSlider mSizeSlider;

    @Nullable
    private OnSliderListener mSliderListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnDataChangedListener;", "", "onSizeChanged", "", "sizeLevel", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener {
        void onSizeChanged(int sizeLevel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnSliderListener;", "", "onLabelStateChanged", "", "slider", "Landroid/view/View;", "state", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnSliderListener$LabelState;", "text", "", "onLabelChanged", "LabelState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderListener {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnSliderListener$LabelState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE", "SHOW", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
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

        void onLabelStateChanged(@Nullable View slider, @Nullable LabelState state, @NotNull String text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenQuickSizeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        SpenUserLabelSlider spenUserLabelSlider = new SpenUserLabelSlider(context, false, C7932R.layout.setting_bottom_align_slider_layout, SpenSlider.SliderType.DISCRETE);
        this.mSizeSlider = spenUserLabelSlider;
        spenUserLabelSlider.setColor(SpenSettingUtil.getColor(context, C7932R.color.setting_pen_size_preview_color));
        SpenUserLabelSlider spenUserLabelSlider2 = this.mSizeSlider;
        SpenUserLabelSlider spenUserLabelSlider3 = null;
        if (spenUserLabelSlider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenUserLabelSlider2 = null;
        }
        spenUserLabelSlider2.setValue(1, false);
        SpenUserLabelSlider spenUserLabelSlider4 = this.mSizeSlider;
        if (spenUserLabelSlider4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenUserLabelSlider4 = null;
        }
        spenUserLabelSlider4.setOnChangedListener(new SpenSlider.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenQuickSizeView.construct.1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSlider.OnChangedListener
            public void onChanged(int value, boolean fromUser) {
                OnDataChangedListener onDataChangedListener;
                if (!fromUser || (onDataChangedListener = SpenQuickSizeView.this.mDataChangedListener) == null) {
                    return;
                }
                onDataChangedListener.onSizeChanged(value);
            }
        });
        SpenUserLabelSlider spenUserLabelSlider5 = this.mSizeSlider;
        if (spenUserLabelSlider5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenUserLabelSlider5 = null;
        }
        spenUserLabelSlider5.setOnLabelListener(new SpenUserLabelSlider.OnLabelListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenQuickSizeView.construct.2
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider.OnLabelListener
            public void onLabelChanged(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                OnSliderListener onSliderListener = SpenQuickSizeView.this.mSliderListener;
                if (onSliderListener != null) {
                    onSliderListener.onLabelChanged(text);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider.OnLabelListener
            public void onLabelStateChanged(SpenUserLabelSlider.OnLabelListener.LabelState state, String text) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(text, "text");
                OnSliderListener onSliderListener = SpenQuickSizeView.this.mSliderListener;
                if (onSliderListener != null) {
                    View view = SpenQuickSizeView.this.mSeekBarView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSeekBarView");
                        view = null;
                    }
                    onSliderListener.onLabelStateChanged(view, state == SpenUserLabelSlider.OnLabelListener.LabelState.SHOW ? OnSliderListener.LabelState.SHOW : OnSliderListener.LabelState.HIDE, text);
                }
            }
        });
        SpenUserLabelSlider spenUserLabelSlider6 = this.mSizeSlider;
        if (spenUserLabelSlider6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
        } else {
            spenUserLabelSlider3 = spenUserLabelSlider6;
        }
        addView(spenUserLabelSlider3);
        this.mSeekBarView = findViewById(C7932R.id.seek_bar);
    }

    public final void close() {
        SpenUserLabelSlider spenUserLabelSlider = null;
        this.mDataChangedListener = null;
        this.mSliderListener = null;
        SpenUserLabelSlider spenUserLabelSlider2 = this.mSizeSlider;
        if (spenUserLabelSlider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
        } else {
            spenUserLabelSlider = spenUserLabelSlider2;
        }
        spenUserLabelSlider.close();
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setSizeLevel(int level) {
        SpenUserLabelSlider spenUserLabelSlider = this.mSizeSlider;
        if (spenUserLabelSlider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenUserLabelSlider = null;
        }
        spenUserLabelSlider.setValue(level, false);
    }

    public final void setSliderListener(@Nullable OnSliderListener listener) {
        this.mSliderListener = listener;
    }
}

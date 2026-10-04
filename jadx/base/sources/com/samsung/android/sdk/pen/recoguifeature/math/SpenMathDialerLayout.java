package com.samsung.android.sdk.pen.recoguifeature.math;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u0017J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SearchConstants.TargetContents.TAG, "", "SEEK_BAR_MAX_VALUE", "", "SEEK_BAR_MIN_VALUE", "BUTTON_ALPHA_ENABLED", "BUTTON_ALPHA_DISABLE", "mContext", "mMinusBtn", "Landroid/widget/ImageButton;", "mPlusBtn", "mSeekBar", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerSeekBar;", "mCurrentValue", "mOnDialerChangedListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerLayout$OnDialerChangedListener;", "close", "", "setOnValueChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestShow", "numberRect", "Landroid/graphics/RectF;", "viewRect", "requestHide", "", "isNotify", "resetValue", "updateValue", "value", "isUpdateSeekBar", "mSeekBarChangeLister", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "OnDialerChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMathDialerLayout extends FrameLayout {
    private final int BUTTON_ALPHA_DISABLE;
    private final int BUTTON_ALPHA_ENABLED;
    private final int SEEK_BAR_MAX_VALUE;
    private final int SEEK_BAR_MIN_VALUE;

    @NotNull
    private final String TAG;

    @Nullable
    private final Context mContext;
    private int mCurrentValue;

    @Nullable
    private ImageButton mMinusBtn;

    @Nullable
    private OnDialerChangedListener mOnDialerChangedListener;

    @Nullable
    private ImageButton mPlusBtn;

    @Nullable
    private SpenMathDialerSeekBar mSeekBar;

    @NotNull
    private final SeekBar.OnSeekBarChangeListener mSeekBarChangeLister;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerLayout$OnDialerChangedListener;", "", "onValueChanged", "", "stepCount", "", "onHide", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDialerChangedListener {
        void onHide();

        void onValueChanged(int stepCount);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenMathDialerLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenMathDialerLayout";
        this.SEEK_BAR_MAX_VALUE = 10;
        this.SEEK_BAR_MIN_VALUE = -10;
        this.BUTTON_ALPHA_ENABLED = 255;
        this.BUTTON_ALPHA_DISABLE = 102;
        this.mContext = getContext();
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.recoguifeature.math.SpenMathDialerLayout$mSeekBarChangeLister$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                this.this$0.updateValue(progress, false);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }
        };
        this.mSeekBarChangeLister = onSeekBarChangeListener;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.math_dialer_layout, (ViewGroup) this, true);
        ImageButton imageButton = (ImageButton) findViewById(C7932R.id.math_dialer_minus_button);
        this.mMinusBtn = imageButton;
        if (imageButton != null) {
            final int i = 0;
            imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.math.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenMathDialerLayout f4998b;

                {
                    this.f4998b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            SpenMathDialerLayout._init_$lambda$0(this.f4998b, view);
                            break;
                        default:
                            SpenMathDialerLayout._init_$lambda$1(this.f4998b, view);
                            break;
                    }
                }
            });
        }
        ImageButton imageButton2 = (ImageButton) findViewById(C7932R.id.math_dialer_plus_button);
        this.mPlusBtn = imageButton2;
        if (imageButton2 != null) {
            final int i2 = 1;
            imageButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.math.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenMathDialerLayout f4998b;

                {
                    this.f4998b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            SpenMathDialerLayout._init_$lambda$0(this.f4998b, view);
                            break;
                        default:
                            SpenMathDialerLayout._init_$lambda$1(this.f4998b, view);
                            break;
                    }
                }
            });
        }
        SpenMathDialerSeekBar spenMathDialerSeekBar = (SpenMathDialerSeekBar) findViewById(C7932R.id.math_dialer_seek_bar);
        this.mSeekBar = spenMathDialerSeekBar;
        if (spenMathDialerSeekBar != null) {
            spenMathDialerSeekBar.setMax(20);
        }
        SpenMathDialerSeekBar spenMathDialerSeekBar2 = this.mSeekBar;
        if (spenMathDialerSeekBar2 != null) {
            spenMathDialerSeekBar2.setProgress(spenMathDialerSeekBar2.getMax() / 2);
        }
        SpenMathDialerSeekBar spenMathDialerSeekBar3 = this.mSeekBar;
        this.mCurrentValue = spenMathDialerSeekBar3 != null ? spenMathDialerSeekBar3.getProgress() : 0;
        SpenMathDialerSeekBar spenMathDialerSeekBar4 = this.mSeekBar;
        if (spenMathDialerSeekBar4 != null) {
            spenMathDialerSeekBar4.setOnSeekBarChangeListener(onSeekBarChangeListener);
        }
        setWillNotDraw(false);
        requestHide(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SpenMathDialerLayout spenMathDialerLayout, View view) {
        SpenMathDialerSeekBar spenMathDialerSeekBar = spenMathDialerLayout.mSeekBar;
        spenMathDialerLayout.updateValue((spenMathDialerSeekBar != null ? spenMathDialerSeekBar.getProgress() : 0) - 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(SpenMathDialerLayout spenMathDialerLayout, View view) {
        SpenMathDialerSeekBar spenMathDialerSeekBar = spenMathDialerLayout.mSeekBar;
        spenMathDialerLayout.updateValue((spenMathDialerSeekBar != null ? spenMathDialerSeekBar.getProgress() : 0) + 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateValue(int value, boolean isUpdateSeekBar) {
        OnDialerChangedListener onDialerChangedListener;
        SpenMathDialerSeekBar spenMathDialerSeekBar;
        SpenMathDialerSeekBar spenMathDialerSeekBar2 = this.mSeekBar;
        if (spenMathDialerSeekBar2 != null) {
            if (isUpdateSeekBar && spenMathDialerSeekBar2 != null && spenMathDialerSeekBar2.getProgress() == value) {
                return;
            }
            SpenMathDialerSeekBar spenMathDialerSeekBar3 = this.mSeekBar;
            if (value > (spenMathDialerSeekBar3 != null ? spenMathDialerSeekBar3.getMax() : 0)) {
                SpenMathDialerSeekBar spenMathDialerSeekBar4 = this.mSeekBar;
                value = spenMathDialerSeekBar4 != null ? spenMathDialerSeekBar4.getMax() : 0;
            } else if (value < 0) {
            }
            if (isUpdateSeekBar && (spenMathDialerSeekBar = this.mSeekBar) != null) {
                spenMathDialerSeekBar.setProgress(value);
            }
            if (value == 0) {
                ImageButton imageButton = this.mMinusBtn;
                if (imageButton != null) {
                    imageButton.setEnabled(false);
                }
                ImageButton imageButton2 = this.mPlusBtn;
                if (imageButton2 != null) {
                    imageButton2.setEnabled(true);
                }
            } else {
                SpenMathDialerSeekBar spenMathDialerSeekBar5 = this.mSeekBar;
                if (spenMathDialerSeekBar5 == null || value != spenMathDialerSeekBar5.getMax()) {
                    ImageButton imageButton3 = this.mMinusBtn;
                    if (imageButton3 != null) {
                        imageButton3.setEnabled(true);
                    }
                    ImageButton imageButton4 = this.mPlusBtn;
                    if (imageButton4 != null) {
                        imageButton4.setEnabled(true);
                    }
                } else {
                    ImageButton imageButton5 = this.mMinusBtn;
                    if (imageButton5 != null) {
                        imageButton5.setEnabled(true);
                    }
                    ImageButton imageButton6 = this.mPlusBtn;
                    if (imageButton6 != null) {
                        imageButton6.setEnabled(false);
                    }
                }
            }
            ImageButton imageButton7 = this.mMinusBtn;
            if (imageButton7 != null) {
                imageButton7.setImageAlpha((imageButton7 == null || !imageButton7.isEnabled()) ? this.BUTTON_ALPHA_DISABLE : this.BUTTON_ALPHA_ENABLED);
            }
            ImageButton imageButton8 = this.mPlusBtn;
            if (imageButton8 != null) {
                imageButton8.setImageAlpha((imageButton8 == null || !imageButton8.isEnabled()) ? this.BUTTON_ALPHA_DISABLE : this.BUTTON_ALPHA_ENABLED);
            }
            int i = this.mCurrentValue;
            if (i != value && (onDialerChangedListener = this.mOnDialerChangedListener) != null) {
                onDialerChangedListener.onValueChanged(value - i);
            }
            SpenMathDialerSeekBar spenMathDialerSeekBar6 = this.mSeekBar;
            this.mCurrentValue = spenMathDialerSeekBar6 != null ? spenMathDialerSeekBar6.getProgress() : 0;
            requestLayout();
        }
    }

    public final void close() {
        SpenMathDialerSeekBar spenMathDialerSeekBar = this.mSeekBar;
        if (spenMathDialerSeekBar != null) {
            spenMathDialerSeekBar.close();
            this.mSeekBar = null;
        }
        this.mOnDialerChangedListener = null;
        this.mPlusBtn = null;
        this.mMinusBtn = null;
    }

    public final boolean requestHide(boolean isNotify) {
        OnDialerChangedListener onDialerChangedListener;
        boolean z = getVisibility() == 0;
        setVisibility(8);
        if (z && isNotify && (onDialerChangedListener = this.mOnDialerChangedListener) != null && onDialerChangedListener != null) {
            onDialerChangedListener.onHide();
        }
        return z;
    }

    public final void requestShow(@NotNull RectF numberRect, @NotNull RectF viewRect) {
        Intrinsics.checkNotNullParameter(numberRect, "numberRect");
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.math_dialer_layout_width);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.math_dialer_layout_height);
        int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.math_dialer_layout_margin);
        Rect rect = new Rect(0, 0, dimensionPixelSize, dimensionPixelSize2);
        float fCenterX = numberRect.centerX() - (dimensionPixelSize / 2.0f);
        float f = numberRect.bottom;
        float f4 = dimensionPixelSize3;
        float f5 = dimensionPixelSize2;
        rect.offset((int) fCenterX, (int) ((f + f4) + f5 > viewRect.bottom ? (numberRect.top - f4) - f5 : f + f4));
        int i = rect.left;
        float f6 = i;
        float f7 = viewRect.left;
        if (f6 < f7) {
            rect.offset((int) (f7 - i), 0);
        } else {
            int i2 = rect.right;
            float f8 = i2;
            float f9 = viewRect.right;
            if (f8 > f9) {
                rect.offset((int) (f9 - i2), 0);
            }
        }
        setX(rect.left);
        setY(rect.top);
        setVisibility(0);
    }

    public final void resetValue() {
        SpenMathDialerSeekBar spenMathDialerSeekBar = this.mSeekBar;
        if (spenMathDialerSeekBar == null) {
            return;
        }
        int max = (spenMathDialerSeekBar != null ? spenMathDialerSeekBar.getMax() : 0) / 2;
        this.mCurrentValue = max;
        SpenMathDialerSeekBar spenMathDialerSeekBar2 = this.mSeekBar;
        if (spenMathDialerSeekBar2 != null) {
            spenMathDialerSeekBar2.setProgress(max);
        }
    }

    public final void setOnValueChangedListener(@Nullable OnDialerChangedListener listener) {
        this.mOnDialerChangedListener = listener;
    }
}

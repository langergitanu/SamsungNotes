package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u0003234B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0007J\u0010\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0010\u0010&\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarSizeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", VElementFormulasCmd.FMAX, "", "(Landroid/content/Context;I)V", "mSeekBar", "Landroid/widget/SeekBar;", "mSizeText", "Landroid/widget/TextView;", "mSeekBarColorControl", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarColorControl;", "mSeekBarAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarAnimation;", "mSeekBarButtonControl", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl;", "mSeekBarBody", "Landroid/view/View;", "mSeekBarPostfixStr", "", "mSizeChangeListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarSizeView$OnSizeChangeListener;", "mSeekBarActionListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarSizeView$OnActionListener;", "onVisibilityChanged", "", "changedView", "visibility", "close", "setSizeLevel", "sizeLevel", "setColor", "color", "setOnSizeChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnActionListener", "construct", "initView", "initSeekBarText", "initSeekBar", "updateValue", "needUpdateSeekBar", "", "updateColor", "notifySizeChangedListener", "fromUser", "updateValuePosition", "Companion", "OnSizeChangeListener", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSeekBarSizeView extends LinearLayout {

    @NotNull
    private static final String TAG = "SpenSeekBarSizeView";
    private SeekBar mSeekBar;

    @Nullable
    private OnActionListener mSeekBarActionListener;
    private SpenSeekBarAnimation mSeekBarAnimation;

    @Nullable
    private View mSeekBarBody;
    private SpenSeekBarButtonControl mSeekBarButtonControl;
    private SpenSeekBarColorControl mSeekBarColorControl;

    @Nullable
    private String mSeekBarPostfixStr;

    @Nullable
    private OnSizeChangeListener mSizeChangeListener;
    private TextView mSizeText;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarSizeView$OnActionListener;", "", "onSizeButtonClicked", "", "onStartTrackingTouch", "onStopTrackingTouch", "onStartSizeButtonLongClick", "onStopSizeButtonLongClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onSizeButtonClicked();

        void onStartSizeButtonLongClick();

        void onStartTrackingTouch();

        void onStopSizeButtonLongClick();

        void onStopTrackingTouch();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarSizeView$OnSizeChangeListener;", "", "onSizeChanged", "", "sizeLevel", "", "fromUser", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSizeChangeListener {
        void onSizeChanged(int sizeLevel, boolean fromUser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSeekBarSizeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.mSeekBarPostfixStr = AbstractC2322a.m1624n(", %s, %s", new Object[]{context.getResources().getString(C7932R.string.pen_string_size), context.getResources().getString(C7932R.string.pen_string_slider)}, 2, "format(format, *args)");
        initView(context);
    }

    private final void initSeekBar() {
        SeekBar seekBar = (SeekBar) findViewById(C7932R.id.seek_bar);
        this.mSeekBar = seekBar;
        SpenSeekBarButtonControl spenSeekBarButtonControl = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        seekBar.setImportantForAccessibility(2);
        SeekBar seekBar2 = this.mSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar2 = null;
        }
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarSizeView.initSeekBar.1
            /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
            /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onProgressChanged(SeekBar seekBar3, int progress, boolean fromUser) {
                SpenSeekBarButtonControl spenSeekBarButtonControl2;
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
                StringBuilder sb = new StringBuilder("OnProgressChanged() progress=");
                sb.append(progress);
                sb.append(" fromUser=");
                AbstractC0000a.m27x(sb, fromUser, SpenSeekBarSizeView.TAG);
                SpenSeekBarSizeView.this.updateValue(progress + 1, false);
                SpenSeekBarSizeView.this.updateValuePosition();
                SpenSeekBarButtonControl spenSeekBarButtonControl3 = SpenSeekBarSizeView.this.mSeekBarButtonControl;
                SpenSeekBarButtonControl spenSeekBarButtonControl4 = null;
                if (spenSeekBarButtonControl3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                    spenSeekBarButtonControl3 = null;
                }
                if (!spenSeekBarButtonControl3.isUserEvent()) {
                    SpenSeekBarButtonControl spenSeekBarButtonControl5 = SpenSeekBarSizeView.this.mSeekBarButtonControl;
                    if (spenSeekBarButtonControl5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                        spenSeekBarButtonControl5 = null;
                    }
                    if (spenSeekBarButtonControl5.isAutoChanged()) {
                    }
                    spenSeekBarButtonControl2 = SpenSeekBarSizeView.this.mSeekBarButtonControl;
                    if (spenSeekBarButtonControl2 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                    } else {
                        spenSeekBarButtonControl4 = spenSeekBarButtonControl2;
                    }
                    spenSeekBarButtonControl4.updateButtonState();
                    if (fromUser) {
                        return;
                    }
                    SpenSeekBarSizeView.this.notifySizeChangedListener(true);
                    return;
                }
                SpenSeekBarButtonControl spenSeekBarButtonControl6 = SpenSeekBarSizeView.this.mSeekBarButtonControl;
                if (spenSeekBarButtonControl6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                    spenSeekBarButtonControl6 = null;
                }
                spenSeekBarButtonControl6.setUserEvent(false);
                fromUser = true;
                spenSeekBarButtonControl2 = SpenSeekBarSizeView.this.mSeekBarButtonControl;
                if (spenSeekBarButtonControl2 != null) {
                }
                spenSeekBarButtonControl4.updateButtonState();
                if (fromUser) {
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar3) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
                OnActionListener onActionListener = SpenSeekBarSizeView.this.mSeekBarActionListener;
                if (onActionListener != null) {
                    onActionListener.onStartTrackingTouch();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar3) {
                Intrinsics.checkNotNullParameter(seekBar3, "seekBar");
                OnActionListener onActionListener = SpenSeekBarSizeView.this.mSeekBarActionListener;
                if (onActionListener != null) {
                    onActionListener.onStopTrackingTouch();
                }
            }
        });
        Drawable roundedCornerDrawable = SpenSettingUtilDrawable.getRoundedCornerDrawable(0, SpenSettingUtil.getColor(getContext(), C7932R.color.setting_handwriting_slider_progress_bg_color), 0, 0);
        SpenSeekBarColorControl spenSeekBarColorControl = new SpenSeekBarColorControl();
        this.mSeekBarColorControl = spenSeekBarColorControl;
        SeekBar seekBar3 = this.mSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar3 = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        spenSeekBarColorControl.initSeekBar(seekBar3, context, false, roundedCornerDrawable);
        SpenSeekBarAnimation spenSeekBarAnimation = new SpenSeekBarAnimation();
        this.mSeekBarAnimation = spenSeekBarAnimation;
        SeekBar seekBar4 = this.mSeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar4 = null;
        }
        SpenSeekBarColorControl spenSeekBarColorControl2 = this.mSeekBarColorControl;
        if (spenSeekBarColorControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl2 = null;
        }
        ScaleDrawable thumbDrawable = spenSeekBarColorControl2.getThumbDrawable();
        SpenSeekBarColorControl spenSeekBarColorControl3 = this.mSeekBarColorControl;
        if (spenSeekBarColorControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl3 = null;
        }
        spenSeekBarAnimation.setTarget(seekBar4, thumbDrawable, spenSeekBarColorControl3.getThumbStrokeDrawable());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        SpenSeekBarButtonControl spenSeekBarButtonControl2 = new SpenSeekBarButtonControl(context2);
        this.mSeekBarButtonControl = spenSeekBarButtonControl2;
        SeekBar seekBar5 = this.mSeekBar;
        if (seekBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar5 = null;
        }
        View viewFindViewById = findViewById(C7932R.id.seek_bar_minus_button);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageButton");
        View viewFindViewById2 = findViewById(C7932R.id.seek_bar_plus_button);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageButton");
        spenSeekBarButtonControl2.initControlButton(seekBar5, (ImageButton) viewFindViewById, (ImageButton) viewFindViewById2);
        SpenSeekBarButtonControl spenSeekBarButtonControl3 = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
        } else {
            spenSeekBarButtonControl = spenSeekBarButtonControl3;
        }
        spenSeekBarButtonControl.setActionListener(new SpenSeekBarButtonControl.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarSizeView.initSeekBar.2
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.OnActionListener
            public void onSizeButtonClicked(SpenSeekBarButtonControl.ButtonType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.i(SpenSeekBarSizeView.TAG, "onSizeButtonPressed() type=" + type);
                OnActionListener onActionListener = SpenSeekBarSizeView.this.mSeekBarActionListener;
                if (onActionListener != null) {
                    onActionListener.onSizeButtonClicked();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.OnActionListener
            public void onStartSizeButtonLongClick(SpenSeekBarButtonControl.ButtonType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.i(SpenSeekBarSizeView.TAG, "onStartSizeButtonLongClick() type=" + type);
                OnActionListener onActionListener = SpenSeekBarSizeView.this.mSeekBarActionListener;
                if (onActionListener != null) {
                    onActionListener.onStartSizeButtonLongClick();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.OnActionListener
            public void onStopSizeButtonLongClick(SpenSeekBarButtonControl.ButtonType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.i(SpenSeekBarSizeView.TAG, "onStopSizeButtonLongClick() type=" + type);
                OnActionListener onActionListener = SpenSeekBarSizeView.this.mSeekBarActionListener;
                if (onActionListener != null) {
                    onActionListener.onStopSizeButtonLongClick();
                }
            }
        });
    }

    private final void initSeekBarText() {
        this.mSizeText = (TextView) findViewById(C7932R.id.seek_bar_value);
        Context context = getContext();
        SpenSettingUtilText.FontName fontName = SpenSettingUtilText.FontName.REGULAR;
        TextView textView = this.mSizeText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeText");
            textView = null;
        }
        SpenSettingUtilText.setTypeFace(context, fontName, textView);
        Context context2 = getContext();
        TextView textView3 = this.mSizeText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeText");
        } else {
            textView2 = textView3;
        }
        SpenSettingUtilText.applyUpToLargeLevel(context2, 13.0f, textView2);
    }

    private final void initView(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.setting_pen_size_seekbar_layout, (ViewGroup) this, true);
        this.mSeekBarBody = findViewById(C7932R.id.size_seekbar_body);
        initSeekBarText();
        initSeekBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySizeChangedListener(boolean fromUser) {
        OnSizeChangeListener onSizeChangeListener = this.mSizeChangeListener;
        if (onSizeChangeListener != null) {
            SeekBar seekBar = this.mSeekBar;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                seekBar = null;
            }
            onSizeChangeListener.onSizeChanged(seekBar.getProgress() + 1, fromUser);
        }
    }

    private final void updateColor(int color) {
        SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
        if (spenSeekBarColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        }
        spenSeekBarColorControl.setColor(color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateValue(int sizeLevel, boolean needUpdateSeekBar) {
        AbstractC6670b.m4754o("updateValue() sizeLevel=", sizeLevel, " needUpdateSeekBar=", needUpdateSeekBar, TAG);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strM1624n = AbstractC2322a.m1624n(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(sizeLevel)}, 1, "format(format, *args)");
        TextView textView = null;
        if (needUpdateSeekBar) {
            SeekBar seekBar = this.mSeekBar;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                seekBar = null;
            }
            seekBar.setProgress(sizeLevel - 1);
        }
        TextView textView2 = this.mSizeText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeText");
        } else {
            textView = textView2;
        }
        textView.setText(strM1624n);
        View view = this.mSeekBarBody;
        if (view != null) {
            view.setContentDescription(strM1624n + this.mSeekBarPostfixStr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateValuePosition() {
        SeekBar seekBar = this.mSeekBar;
        TextView textView = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        float fExactCenterX = seekBar.getThumb().getBounds().exactCenterX();
        SeekBar seekBar2 = this.mSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar2 = null;
        }
        float fExactCenterX2 = fExactCenterX - seekBar2.getProgressDrawable().getBounds().exactCenterX();
        SeekBar seekBar3 = this.mSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar3 = null;
        }
        int thumbOffset = (int) (fExactCenterX2 - seekBar3.getThumbOffset());
        TextView textView2 = this.mSizeText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeText");
        } else {
            textView = textView2;
        }
        textView.setTranslationX(thumbOffset);
    }

    public final void close() {
        Log.i(TAG, "close()");
        SpenSeekBarAnimation spenSeekBarAnimation = this.mSeekBarAnimation;
        if (spenSeekBarAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarAnimation");
            spenSeekBarAnimation = null;
        }
        spenSeekBarAnimation.close();
        SpenSeekBarButtonControl spenSeekBarButtonControl = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
            spenSeekBarButtonControl = null;
        }
        spenSeekBarButtonControl.close();
        SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
        if (spenSeekBarColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        }
        spenSeekBarColorControl.close();
        this.mSizeChangeListener = null;
        this.mSeekBarActionListener = null;
        this.mSeekBarBody = null;
        this.mSeekBarPostfixStr = null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        if (visibility == 0) {
            post(new RunnableC4617a(this, 25));
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final void setColor(int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Log.i(TAG, AbstractC1974b.m1319l("setColor() color=", color, AbstractC2322a.m1624n("#%08X", new Object[]{Integer.valueOf(color)}, 1, "format(format, *args)"), "(", ")"));
        updateColor(color);
    }

    public final void setOnActionListener(@Nullable OnActionListener listener) {
        this.mSeekBarActionListener = listener;
    }

    public final void setOnSizeChangeListener(@Nullable OnSizeChangeListener listener) {
        this.mSizeChangeListener = listener;
    }

    public final void setSizeLevel(int sizeLevel) {
        AbstractC2322a.m1631u(sizeLevel, "setSizeLevel() sizeLevel=", TAG);
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        seekBar.setProgress(sizeLevel - 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSeekBarSizeView(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        seekBar.setMax(i);
    }
}

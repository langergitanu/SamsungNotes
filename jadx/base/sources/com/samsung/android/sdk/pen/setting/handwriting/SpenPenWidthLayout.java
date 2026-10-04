package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mFixedWidthPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "mVariableWidthPreview", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayoutInterface$OnDataChangedListener;", "mPreviewColor", "", "mClickListener", "Landroid/view/View$OnClickListener;", "close", "", "setPenInfo", "penName", "", "sizeLevel", "color", "setPenWidth", "isFixed", "", "needAnimation", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "construct", "initView", "layoutId", "setPreviewBackground", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenWidthLayout extends FrameLayout implements SpenPenWidthLayoutInterface {
    private static final int DEFAULT_SIZE_LEVEL = 100;

    @NotNull
    private static final String TAG = "SpenPenWidthLayout";

    @NotNull
    private final View.OnClickListener mClickListener;

    @Nullable
    private SpenPenWidthLayoutInterface.OnDataChangedListener mDataChangedListener;
    private SpenPenPreviewV2 mFixedWidthPreview;
    private int mPreviewColor;
    private SpenPenPreviewV2 mVariableWidthPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenWidthLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClickListener = new ViewOnClickListenerC7538b(this, 14);
        construct(context);
    }

    private final void construct(Context context) {
        this.mPreviewColor = SpenSettingUtil.getColor(context, C7932R.color.component_common);
        initView(context, C7932R.layout.setting_pen_width_layout);
    }

    private final void initView(Context context, int layoutId) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        Resources resources = context.getResources();
        SpenPenPreviewV2 spenPenPreviewV2 = (SpenPenPreviewV2) findViewById(C7932R.id.fixed_width_view);
        this.mFixedWidthPreview = spenPenPreviewV2;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedWidthPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.setOnClickListener(this.mClickListener);
        SpenPenPreviewV2 spenPenPreviewV23 = this.mFixedWidthPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedWidthPreview");
            spenPenPreviewV23 = null;
        }
        SpenSettingUtilHover.setHoverText(spenPenPreviewV23, resources.getString(C7932R.string.pen_string_fixed_thickness));
        SpenPenPreviewV2 spenPenPreviewV24 = (SpenPenPreviewV2) findViewById(C7932R.id.variable_width_view);
        this.mVariableWidthPreview = spenPenPreviewV24;
        if (spenPenPreviewV24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVariableWidthPreview");
            spenPenPreviewV24 = null;
        }
        spenPenPreviewV24.setOnClickListener(this.mClickListener);
        SpenPenPreviewV2 spenPenPreviewV25 = this.mVariableWidthPreview;
        if (spenPenPreviewV25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVariableWidthPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV25;
        }
        SpenSettingUtilHover.setHoverText(spenPenPreviewV22, resources.getString(C7932R.string.pen_string_variable_thickness));
        setPreviewBackground(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClickListener$lambda$0(SpenPenWidthLayout spenPenWidthLayout, View view) {
        if (view.isSelected()) {
            return;
        }
        boolean z = view.getId() == C7932R.id.fixed_width_view;
        spenPenWidthLayout.setPenWidth(z, true);
        SpenPenWidthLayoutInterface.OnDataChangedListener onDataChangedListener = spenPenWidthLayout.mDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onPenWidthChanged(z);
        }
    }

    private final void setPreviewBackground(Context context) {
        int i = !SpenSettingUtilAccessibility.isHighContrast(context) ? C7932R.drawable.setting_pen_width_item_background : C7932R.drawable.setting_item_background_high_contrast;
        SpenPenPreviewV2 spenPenPreviewV2 = this.mFixedWidthPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedWidthPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.setBackgroundResource(i);
        SpenPenPreviewV2 spenPenPreviewV23 = this.mVariableWidthPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVariableWidthPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.setBackgroundResource(i);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void close() {
        SpenPenPreviewV2 spenPenPreviewV2 = this.mFixedWidthPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedWidthPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.close();
        SpenPenPreviewV2 spenPenPreviewV23 = this.mVariableWidthPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVariableWidthPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setDataChangedListener(@Nullable SpenPenWidthLayoutInterface.OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setPenInfo(@Nullable String penName, int sizeLevel, int color) {
        AbstractC0000a.m26w(AbstractC0541b.m780v("setPenInfo() Name=", sizeLevel, penName, " sizeLevel=", " color="), TAG, color);
        if (penName == null) {
            return;
        }
        SpenPenPreviewV2 spenPenPreviewV2 = this.mFixedWidthPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedWidthPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.setInfo(penName, 100);
        spenPenPreviewV2.setPenColor(this.mPreviewColor);
        spenPenPreviewV2.setFixedWidth(true);
        spenPenPreviewV2.invalidate();
        SpenPenPreviewV2 spenPenPreviewV23 = this.mVariableWidthPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVariableWidthPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.setInfo(penName, 100);
        spenPenPreviewV22.setPenColor(this.mPreviewColor);
        spenPenPreviewV22.setFixedWidth(false);
        spenPenPreviewV22.invalidate();
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setPenWidth(boolean isFixed, boolean needAnimation) {
        AbstractC4539a.m3208r("setPenWidth() isFixedWidth=", TAG, isFixed);
        SpenPenPreviewV2 spenPenPreviewV2 = this.mFixedWidthPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedWidthPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.setSelected(isFixed);
        SpenPenPreviewV2 spenPenPreviewV23 = this.mVariableWidthPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVariableWidthPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.setSelected(!isFixed);
    }
}

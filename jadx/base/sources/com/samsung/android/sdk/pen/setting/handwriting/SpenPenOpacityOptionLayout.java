package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityOptionLayoutInterface;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityOptionLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityOptionLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "previewColor", "", "fixedOpacityPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "variableOpacityPreview", "dataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityOptionLayoutInterface$OnDataChangedListener;", "close", "", "setPenInfo", "penName", "", "setOpacityOption", "isFixed", "", "needAnimation", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initView", "layoutId", "updateState", "animation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenOpacityOptionLayout extends FrameLayout implements SpenPenOpacityOptionLayoutInterface {

    @NotNull
    private static final String TAG = "SpenPenOpacityOptionLayout";

    @Nullable
    private SpenPenOpacityOptionLayoutInterface.OnDataChangedListener dataChangedListener;
    private SpenPenPreviewV2 fixedOpacityPreview;
    private int previewColor;
    private SpenPenPreviewV2 variableOpacityPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenOpacityOptionLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.previewColor = SpenSettingUtil.getColor(context, C7932R.color.component_common);
        initView(context, C7932R.layout.setting_pen_width_layout);
    }

    private final void initView(Context context, int layoutId) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        Resources resources = context.getResources();
        int i = !SpenSettingUtilAccessibility.isHighContrast(context) ? C7932R.drawable.setting_pen_width_item_background : C7932R.drawable.setting_item_background_high_contrast;
        SpenPenPreviewV2 spenPenPreviewV2 = (SpenPenPreviewV2) findViewById(C7932R.id.fixed_width_view);
        this.fixedOpacityPreview = spenPenPreviewV2;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fixedOpacityPreview");
            spenPenPreviewV2 = null;
        }
        final int i2 = 0;
        spenPenPreviewV2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.handwriting.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenPenOpacityOptionLayout f5064b;

            {
                this.f5064b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        SpenPenOpacityOptionLayout.initView$lambda$3$lambda$2(this.f5064b, view);
                        break;
                    default:
                        SpenPenOpacityOptionLayout.initView$lambda$5$lambda$4(this.f5064b, view);
                        break;
                }
            }
        });
        spenPenPreviewV2.setBackgroundResource(i);
        SpenSettingUtilHover.setHoverText(spenPenPreviewV2, resources.getString(C7932R.string.pen_string_fixed_opacity));
        SpenPenPreviewV2 spenPenPreviewV23 = (SpenPenPreviewV2) findViewById(C7932R.id.variable_width_view);
        this.variableOpacityPreview = spenPenPreviewV23;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variableOpacityPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        final int i4 = 1;
        spenPenPreviewV22.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.handwriting.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenPenOpacityOptionLayout f5064b;

            {
                this.f5064b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        SpenPenOpacityOptionLayout.initView$lambda$3$lambda$2(this.f5064b, view);
                        break;
                    default:
                        SpenPenOpacityOptionLayout.initView$lambda$5$lambda$4(this.f5064b, view);
                        break;
                }
            }
        });
        spenPenPreviewV22.setBackgroundResource(i);
        SpenSettingUtilHover.setHoverText(spenPenPreviewV22, resources.getString(C7932R.string.pen_string_variable_opacity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(SpenPenOpacityOptionLayout spenPenOpacityOptionLayout, View view) {
        if (view.isSelected()) {
            return;
        }
        spenPenOpacityOptionLayout.updateState(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$4(SpenPenOpacityOptionLayout spenPenOpacityOptionLayout, View view) {
        if (view.isSelected()) {
            return;
        }
        spenPenOpacityOptionLayout.updateState(false, true);
    }

    private final void updateState(boolean isFixed, boolean animation) {
        setOpacityOption(isFixed, animation);
        SpenPenOpacityOptionLayoutInterface.OnDataChangedListener onDataChangedListener = this.dataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onOpacityOptionChanged(isFixed);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityOptionLayoutInterface
    public void close() {
        SpenPenPreviewV2 spenPenPreviewV2 = this.fixedOpacityPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fixedOpacityPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.close();
        SpenPenPreviewV2 spenPenPreviewV23 = this.variableOpacityPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variableOpacityPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityOptionLayoutInterface
    public void setDataChangedListener(@Nullable SpenPenOpacityOptionLayoutInterface.OnDataChangedListener listener) {
        this.dataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityOptionLayoutInterface
    public void setOpacityOption(boolean isFixed, boolean needAnimation) {
        AbstractC4539a.m3208r("setOpacityOption() isFixed=", TAG, isFixed);
        SpenPenPreviewV2 spenPenPreviewV2 = this.fixedOpacityPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fixedOpacityPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.setSelected(isFixed);
        SpenPenPreviewV2 spenPenPreviewV23 = this.variableOpacityPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variableOpacityPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.setSelected(!isFixed);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityOptionLayoutInterface
    public void setPenInfo(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        Log.i(TAG, "setPenInfo() Name=" + penName + " ");
        SpenPenPreviewV2 spenPenPreviewV2 = this.fixedOpacityPreview;
        SpenPenPreviewV2 spenPenPreviewV22 = null;
        if (spenPenPreviewV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fixedOpacityPreview");
            spenPenPreviewV2 = null;
        }
        spenPenPreviewV2.setInfo(penName, 100);
        spenPenPreviewV2.setPenColor(this.previewColor);
        spenPenPreviewV2.setFixedOpacity(true);
        spenPenPreviewV2.invalidate();
        SpenPenPreviewV2 spenPenPreviewV23 = this.variableOpacityPreview;
        if (spenPenPreviewV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("variableOpacityPreview");
        } else {
            spenPenPreviewV22 = spenPenPreviewV23;
        }
        spenPenPreviewV22.setInfo(penName, 100);
        spenPenPreviewV22.setPenColor(this.previewColor);
        spenPenPreviewV22.setFixedOpacity(false);
        spenPenPreviewV22.invalidate();
    }
}

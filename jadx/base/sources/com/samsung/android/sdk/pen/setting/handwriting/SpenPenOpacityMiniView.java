package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityMiniView;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColor", "", "onFinishInflate", "", "setColor", "color", "setAlpha", "alpha", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenOpacityMiniView extends SpenPenAttrMiniView {
    private int mColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenOpacityMiniView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        if (getMUserDefineChildLayoutId() == 0) {
            setUserDefineChildLayout(C7932R.layout.setting_pen_attr_opacity_mini_view);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setLabelFormat("%d%%");
    }

    public final void setAlpha(int alpha) {
        setColor(SpenSettingUtilOpacity.setCurrentAlpha(this.mColor, alpha));
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView
    public void setColor(int color) {
        this.mColor = color;
        super.setColor(color);
        setValue(SpenSettingUtilOpacity.getAlphaToPercent(Color.alpha(color)));
    }
}

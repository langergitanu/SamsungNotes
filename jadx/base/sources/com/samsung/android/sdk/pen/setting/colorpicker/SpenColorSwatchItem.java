package com.samsung.android.sdk.pen.setting.colorpicker;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchItem;", "", "hue", "", "saturation", "value", "<init>", "(FFF)V", "mValue", "mRGBColor", "", "mSelectorColor", "mVoiceAssistant", "", "setVoiceAssistant", "", "colorName", "buttonName", "getColor", "getSelectorColor", "getVoiceAssistant", "setColor", "setSelectorColor", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSwatchItem {
    private static final int ADAPTIVE_SELECTOR_COLOR = 1291845632;
    private static final int DEFAULT_SELECTOR_COLOR = -1;

    @NotNull
    private static final String TAG = "SpenColorSwathItem";
    private int mRGBColor;
    private int mSelectorColor;
    private float mValue;

    @Nullable
    private String mVoiceAssistant;

    public SpenColorSwatchItem(float f, float f4, float f5) {
        setColor(f, f4, f5);
        setSelectorColor(f4, f5);
    }

    private final void setColor(float hue, float saturation, float value) {
        this.mValue = value;
        this.mRGBColor = SpenSettingUtil.HSVToColor(new float[]{hue, saturation, value});
    }

    private final void setSelectorColor(float saturation, float value) {
        if (value < 0.98f || saturation < 0.0f || saturation >= 0.19f) {
            this.mSelectorColor = -1;
        } else {
            this.mSelectorColor = ADAPTIVE_SELECTOR_COLOR;
        }
    }

    /* JADX INFO: renamed from: getColor, reason: from getter */
    public final int getMRGBColor() {
        return this.mRGBColor;
    }

    /* JADX INFO: renamed from: getSelectorColor, reason: from getter */
    public final int getMSelectorColor() {
        return this.mSelectorColor;
    }

    @Nullable
    /* JADX INFO: renamed from: getVoiceAssistant, reason: from getter */
    public final String getMVoiceAssistant() {
        return this.mVoiceAssistant;
    }

    public final void setVoiceAssistant(@Nullable String colorName, @Nullable String buttonName) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.mVoiceAssistant = AbstractC2322a.m1624n("%s, %d, %s", new Object[]{colorName, Integer.valueOf((int) (this.mValue * 100)), buttonName}, 3, "format(format, *args)");
    }
}

package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushSliderFactory;", "", "<init>", "()V", "createSlider", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "type", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushSliderFactory$SliderType;", "context", "Landroid/content/Context;", "hasStroke", "", "SliderType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushSliderFactory {

    @NotNull
    public static final SpenBrushSliderFactory INSTANCE = new SpenBrushSliderFactory();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushSliderFactory$SliderType;", "", "<init>", "(Ljava/lang/String;I)V", "SIZE", "OPACITY", "PARTICLE_DENSITY", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SliderType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SliderType[] $VALUES;
        public static final SliderType SIZE = new SliderType("SIZE", 0);
        public static final SliderType OPACITY = new SliderType("OPACITY", 1);
        public static final SliderType PARTICLE_DENSITY = new SliderType("PARTICLE_DENSITY", 2);

        private static final /* synthetic */ SliderType[] $values() {
            return new SliderType[]{SIZE, OPACITY, PARTICLE_DENSITY};
        }

        static {
            SliderType[] sliderTypeArr$values = $values();
            $VALUES = sliderTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sliderTypeArr$values);
        }

        private SliderType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<SliderType> getEntries() {
            return $ENTRIES;
        }

        public static SliderType valueOf(String str) {
            return (SliderType) Enum.valueOf(SliderType.class, str);
        }

        public static SliderType[] values() {
            return (SliderType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SliderType.values().length];
            try {
                iArr[SliderType.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SliderType.OPACITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SpenBrushSliderFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SpenSlider createSlider(@NotNull SliderType type, @NotNull Context context, boolean hasStroke) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            SpenSlider spenSlider = new SpenSlider(context, hasStroke, C7932R.layout.setting_brush_slider_layout, 1, 100, C7932R.string.pen_string_decrease, C7932R.string.pen_string_increase, SpenSlider.SliderType.DISCRETE);
            spenSlider.setAccessibilityPostfix(resources.getString(C7932R.string.pen_string_size));
            return spenSlider;
        }
        if (i != 2) {
            SpenSlider spenSlider2 = new SpenSlider(context, hasStroke, C7932R.layout.setting_brush_slider_layout, 1, 100, C7932R.string.pen_string_decrease, C7932R.string.pen_string_increase, SpenSlider.SliderType.DISCRETE);
            spenSlider2.setAccessibilityPostfix(resources.getString(C7932R.string.pen_string_softness));
            return spenSlider2;
        }
        SpenSlider spenSlider3 = new SpenSlider(context, hasStroke, C7932R.layout.setting_brush_slider_layout, 1, 100, C7932R.string.pen_string_opacity_decrease, C7932R.string.pen_string_opacity_increase, SpenSlider.SliderType.CONTINUOUS);
        spenSlider3.setAccessibilityPostfix(resources.getString(C7932R.string.pen_string_opacity));
        spenSlider3.setLabelFormat("%d%%");
        return spenSlider3;
    }
}

package com.samsung.android.vexfwk.Bokeheffect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EFFECT_TYPE_BOKEH_LENS", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class BokehEffectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BokehEffectType[] $VALUES;
    public static final BokehEffectType EFFECT_TYPE_BOKEH_LENS = new BokehEffectType("EFFECT_TYPE_BOKEH_LENS", 0, 0);
    private final int value;

    private static final /* synthetic */ BokehEffectType[] $values() {
        return new BokehEffectType[]{EFFECT_TYPE_BOKEH_LENS};
    }

    static {
        BokehEffectType[] bokehEffectTypeArr$values = $values();
        $VALUES = bokehEffectTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bokehEffectTypeArr$values);
    }

    private BokehEffectType(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<BokehEffectType> getEntries() {
        return $ENTRIES;
    }

    public static BokehEffectType valueOf(String str) {
        return (BokehEffectType) Enum.valueOf(BokehEffectType.class, str);
    }

    public static BokehEffectType[] values() {
        return (BokehEffectType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

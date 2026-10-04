package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/SummaryStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LONG", "SHORT", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SummaryStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SummaryStyle[] $VALUES;
    public static final SummaryStyle LONG = new SummaryStyle("LONG", 0);
    public static final SummaryStyle SHORT = new SummaryStyle("SHORT", 1);

    private static final /* synthetic */ SummaryStyle[] $values() {
        return new SummaryStyle[]{LONG, SHORT};
    }

    static {
        SummaryStyle[] summaryStyleArr$values = $values();
        $VALUES = summaryStyleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(summaryStyleArr$values);
    }

    private SummaryStyle(String str, int i) {
    }

    @NotNull
    public static EnumEntries<SummaryStyle> getEntries() {
        return $ENTRIES;
    }

    public static SummaryStyle valueOf(String str) {
        return (SummaryStyle) Enum.valueOf(SummaryStyle.class, str);
    }

    public static SummaryStyle[] values() {
        return (SummaryStyle[]) $VALUES.clone();
    }
}

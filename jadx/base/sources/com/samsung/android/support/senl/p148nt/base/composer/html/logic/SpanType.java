package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpanType;", "", "<init>", "(Ljava/lang/String;I)V", "BOLD", "ITALIC", "UNDERLINE", "STRIKETHROUGH", "TEXT_COLOR", "BACKGROUND_COLOR", "HREF", "SUBSCRIPT", "SUPERSCRIPT", "HEADING1", "HEADING2", "HEADING3", "HEADING4", "HEADING5", "HEADING6", "Code", "Latex", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpanType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpanType[] $VALUES;
    public static final SpanType BOLD = new SpanType("BOLD", 0);
    public static final SpanType ITALIC = new SpanType("ITALIC", 1);
    public static final SpanType UNDERLINE = new SpanType("UNDERLINE", 2);
    public static final SpanType STRIKETHROUGH = new SpanType("STRIKETHROUGH", 3);
    public static final SpanType TEXT_COLOR = new SpanType("TEXT_COLOR", 4);
    public static final SpanType BACKGROUND_COLOR = new SpanType("BACKGROUND_COLOR", 5);
    public static final SpanType HREF = new SpanType("HREF", 6);
    public static final SpanType SUBSCRIPT = new SpanType("SUBSCRIPT", 7);
    public static final SpanType SUPERSCRIPT = new SpanType("SUPERSCRIPT", 8);
    public static final SpanType HEADING1 = new SpanType("HEADING1", 9);
    public static final SpanType HEADING2 = new SpanType("HEADING2", 10);
    public static final SpanType HEADING3 = new SpanType("HEADING3", 11);
    public static final SpanType HEADING4 = new SpanType("HEADING4", 12);
    public static final SpanType HEADING5 = new SpanType("HEADING5", 13);
    public static final SpanType HEADING6 = new SpanType("HEADING6", 14);
    public static final SpanType Code = new SpanType("Code", 15);
    public static final SpanType Latex = new SpanType("Latex", 16);

    private static final /* synthetic */ SpanType[] $values() {
        return new SpanType[]{BOLD, ITALIC, UNDERLINE, STRIKETHROUGH, TEXT_COLOR, BACKGROUND_COLOR, HREF, SUBSCRIPT, SUPERSCRIPT, HEADING1, HEADING2, HEADING3, HEADING4, HEADING5, HEADING6, Code, Latex};
    }

    static {
        SpanType[] spanTypeArr$values = $values();
        $VALUES = spanTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spanTypeArr$values);
    }

    private SpanType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<SpanType> getEntries() {
        return $ENTRIES;
    }

    public static SpanType valueOf(String str) {
        return (SpanType) Enum.valueOf(SpanType.class, str);
    }

    public static SpanType[] values() {
        return (SpanType[]) $VALUES.clone();
    }
}

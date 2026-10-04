package com.samsung.android.support.senl.p148nt.composer.main.base.model.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/EraserState;", "", "<init>", "(Ljava/lang/String;I)V", "ERASED", "NORMAL", "ERASING", "ERROR", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class EraserState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EraserState[] $VALUES;
    public static final EraserState ERASED = new EraserState("ERASED", 0);
    public static final EraserState NORMAL = new EraserState("NORMAL", 1);
    public static final EraserState ERASING = new EraserState("ERASING", 2);
    public static final EraserState ERROR = new EraserState("ERROR", 3);

    private static final /* synthetic */ EraserState[] $values() {
        return new EraserState[]{ERASED, NORMAL, ERASING, ERROR};
    }

    static {
        EraserState[] eraserStateArr$values = $values();
        $VALUES = eraserStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eraserStateArr$values);
    }

    private EraserState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<EraserState> getEntries() {
        return $ENTRIES;
    }

    public static EraserState valueOf(String str) {
        return (EraserState) Enum.valueOf(EraserState.class, str);
    }

    public static EraserState[] values() {
        return (EraserState[]) $VALUES.clone();
    }
}

package com.samsung.android.support.senl.p148nt.stt.base.model.mode;

import com.samsung.scsp.odm.dos.resource.ScspResource;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "", "<init>", "(Ljava/lang/String;I)V", "RECORD", "REPLAY", "EDIT", "SELECTION", "SELECTION_SUMMARY", ScspResource.ResourceApiSpec.SEARCH, "SEARCH_COMPOSER", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ STTMode[] $VALUES;
    public static final STTMode RECORD = new STTMode("RECORD", 0);
    public static final STTMode REPLAY = new STTMode("REPLAY", 1);
    public static final STTMode EDIT = new STTMode("EDIT", 2);
    public static final STTMode SELECTION = new STTMode("SELECTION", 3);
    public static final STTMode SELECTION_SUMMARY = new STTMode("SELECTION_SUMMARY", 4);
    public static final STTMode SEARCH = new STTMode(ScspResource.ResourceApiSpec.SEARCH, 5);
    public static final STTMode SEARCH_COMPOSER = new STTMode("SEARCH_COMPOSER", 6);

    private static final /* synthetic */ STTMode[] $values() {
        return new STTMode[]{RECORD, REPLAY, EDIT, SELECTION, SELECTION_SUMMARY, SEARCH, SEARCH_COMPOSER};
    }

    static {
        STTMode[] sTTModeArr$values = $values();
        $VALUES = sTTModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sTTModeArr$values);
    }

    private STTMode(String str, int i) {
    }

    @NotNull
    public static EnumEntries<STTMode> getEntries() {
        return $ENTRIES;
    }

    public static STTMode valueOf(String str) {
        return (STTMode) Enum.valueOf(STTMode.class, str);
    }

    public static STTMode[] values() {
        return (STTMode[]) $VALUES.clone();
    }
}

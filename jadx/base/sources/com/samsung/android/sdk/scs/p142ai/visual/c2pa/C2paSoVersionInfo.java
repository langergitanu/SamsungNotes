package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paSoVersionInfo;", "", "<init>", "(Ljava/lang/String;I)V", "V1", "V2", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class C2paSoVersionInfo {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ C2paSoVersionInfo[] $VALUES;

    /* JADX INFO: renamed from: V1 */
    public static final C2paSoVersionInfo f5249V1 = new C2paSoVersionInfo("V1", 0);

    /* JADX INFO: renamed from: V2 */
    public static final C2paSoVersionInfo f5250V2 = new C2paSoVersionInfo("V2", 1);

    private static final /* synthetic */ C2paSoVersionInfo[] $values() {
        return new C2paSoVersionInfo[]{f5249V1, f5250V2};
    }

    static {
        C2paSoVersionInfo[] c2paSoVersionInfoArr$values = $values();
        $VALUES = c2paSoVersionInfoArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(c2paSoVersionInfoArr$values);
    }

    private C2paSoVersionInfo(String str, int i) {
    }

    @NotNull
    public static EnumEntries<C2paSoVersionInfo> getEntries() {
        return $ENTRIES;
    }

    public static C2paSoVersionInfo valueOf(String str) {
        return (C2paSoVersionInfo) Enum.valueOf(C2paSoVersionInfo.class, str);
    }

    public static C2paSoVersionInfo[] values() {
        return (C2paSoVersionInfo[]) $VALUES.clone();
    }
}

package com.samsung.android.vexfwk.sdk.common.runtime;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkResultCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, "NOK", "TIME_OUT", "DEAD_OBJ", "NO_INIT", "BAD_VAL", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkResultCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkResultCode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int value;

    /* JADX INFO: renamed from: OK */
    public static final VexFwkResultCode f8089OK = new VexFwkResultCode(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, 0, 0);
    public static final VexFwkResultCode NOK = new VexFwkResultCode("NOK", 1, -1);
    public static final VexFwkResultCode TIME_OUT = new VexFwkResultCode("TIME_OUT", 2, -2);
    public static final VexFwkResultCode DEAD_OBJ = new VexFwkResultCode("DEAD_OBJ", 3, -3);
    public static final VexFwkResultCode NO_INIT = new VexFwkResultCode("NO_INIT", 4, -4);
    public static final VexFwkResultCode BAD_VAL = new VexFwkResultCode("BAD_VAL", 5, -5);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkResultCode$Companion;", "", "()V", "fromInt", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkResultCode;", "value", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkResultCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkResultCode.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkResultCode$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,16:1\n1109#2,2:17\n*S KotlinDebug\n*F\n+ 1 VexFwkResultCode.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkResultCode$Companion\n*L\n13#1:17,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VexFwkResultCode fromInt(int value) {
            for (VexFwkResultCode vexFwkResultCode : VexFwkResultCode.values()) {
                if (vexFwkResultCode.getValue() == value) {
                    return vexFwkResultCode;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VexFwkResultCode[] $values() {
        return new VexFwkResultCode[]{f8089OK, NOK, TIME_OUT, DEAD_OBJ, NO_INIT, BAD_VAL};
    }

    static {
        VexFwkResultCode[] vexFwkResultCodeArr$values = $values();
        $VALUES = vexFwkResultCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkResultCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkResultCode(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<VexFwkResultCode> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkResultCode valueOf(String str) {
        return (VexFwkResultCode) Enum.valueOf(VexFwkResultCode.class, str);
    }

    public static VexFwkResultCode[] values() {
        return (VexFwkResultCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

package com.samsung.android.vexfwk.imageclipper;

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
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, "ERR_UNKNOWN", "ERR_INVALID_PARAM", "ERR_UNSUPPORTED", "ERR_NO_MEMORY", "ERR_BAD_STATE", "ERR_USER_CANCEL", "ERR_EXPIRED", "ERR_USER_PAUSE", "ERR_BUFFER_OVERFLOW", "ERR_BUFFER_UNDERFLOW", "ERR_NO_DISKSPACE", "ERR_COMPONENT_NOT_EXIST", "ERR_GLOBAL_DATA_NOT_EXIST", "ERR_NO_OBJECT", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkImageClipperResultCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkImageClipperResultCode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int value;

    /* JADX INFO: renamed from: OK */
    public static final VexFwkImageClipperResultCode f8082OK = new VexFwkImageClipperResultCode(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, 0, 0);
    public static final VexFwkImageClipperResultCode ERR_UNKNOWN = new VexFwkImageClipperResultCode("ERR_UNKNOWN", 1, 1);
    public static final VexFwkImageClipperResultCode ERR_INVALID_PARAM = new VexFwkImageClipperResultCode("ERR_INVALID_PARAM", 2, 2);
    public static final VexFwkImageClipperResultCode ERR_UNSUPPORTED = new VexFwkImageClipperResultCode("ERR_UNSUPPORTED", 3, 3);
    public static final VexFwkImageClipperResultCode ERR_NO_MEMORY = new VexFwkImageClipperResultCode("ERR_NO_MEMORY", 4, 4);
    public static final VexFwkImageClipperResultCode ERR_BAD_STATE = new VexFwkImageClipperResultCode("ERR_BAD_STATE", 5, 5);
    public static final VexFwkImageClipperResultCode ERR_USER_CANCEL = new VexFwkImageClipperResultCode("ERR_USER_CANCEL", 6, 6);
    public static final VexFwkImageClipperResultCode ERR_EXPIRED = new VexFwkImageClipperResultCode("ERR_EXPIRED", 7, 7);
    public static final VexFwkImageClipperResultCode ERR_USER_PAUSE = new VexFwkImageClipperResultCode("ERR_USER_PAUSE", 8, 8);
    public static final VexFwkImageClipperResultCode ERR_BUFFER_OVERFLOW = new VexFwkImageClipperResultCode("ERR_BUFFER_OVERFLOW", 9, 9);
    public static final VexFwkImageClipperResultCode ERR_BUFFER_UNDERFLOW = new VexFwkImageClipperResultCode("ERR_BUFFER_UNDERFLOW", 10, 10);
    public static final VexFwkImageClipperResultCode ERR_NO_DISKSPACE = new VexFwkImageClipperResultCode("ERR_NO_DISKSPACE", 11, 11);
    public static final VexFwkImageClipperResultCode ERR_COMPONENT_NOT_EXIST = new VexFwkImageClipperResultCode("ERR_COMPONENT_NOT_EXIST", 12, 12);
    public static final VexFwkImageClipperResultCode ERR_GLOBAL_DATA_NOT_EXIST = new VexFwkImageClipperResultCode("ERR_GLOBAL_DATA_NOT_EXIST", 13, 13);
    public static final VexFwkImageClipperResultCode ERR_NO_OBJECT = new VexFwkImageClipperResultCode("ERR_NO_OBJECT", 14, 14);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode$Companion;", "", "()V", "fromInt", "Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;", "value", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkImageClipperResultCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageClipperResultCode.kt\ncom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,23:1\n1109#2,2:24\n*S KotlinDebug\n*F\n+ 1 VexFwkImageClipperResultCode.kt\ncom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode$Companion\n*L\n21#1:24,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VexFwkImageClipperResultCode fromInt(int value) {
            for (VexFwkImageClipperResultCode vexFwkImageClipperResultCode : VexFwkImageClipperResultCode.values()) {
                if (vexFwkImageClipperResultCode.getValue() == value) {
                    return vexFwkImageClipperResultCode;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VexFwkImageClipperResultCode[] $values() {
        return new VexFwkImageClipperResultCode[]{f8082OK, ERR_UNKNOWN, ERR_INVALID_PARAM, ERR_UNSUPPORTED, ERR_NO_MEMORY, ERR_BAD_STATE, ERR_USER_CANCEL, ERR_EXPIRED, ERR_USER_PAUSE, ERR_BUFFER_OVERFLOW, ERR_BUFFER_UNDERFLOW, ERR_NO_DISKSPACE, ERR_COMPONENT_NOT_EXIST, ERR_GLOBAL_DATA_NOT_EXIST, ERR_NO_OBJECT};
    }

    static {
        VexFwkImageClipperResultCode[] vexFwkImageClipperResultCodeArr$values = $values();
        $VALUES = vexFwkImageClipperResultCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkImageClipperResultCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkImageClipperResultCode(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<VexFwkImageClipperResultCode> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkImageClipperResultCode valueOf(String str) {
        return (VexFwkImageClipperResultCode) Enum.valueOf(VexFwkImageClipperResultCode.class, str);
    }

    public static VexFwkImageClipperResultCode[] values() {
        return (VexFwkImageClipperResultCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

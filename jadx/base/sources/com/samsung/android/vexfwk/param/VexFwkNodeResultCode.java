package com.samsung.android.vexfwk.param;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkNodeResultCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, "PROCESS_FAIL", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkNodeResultCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkNodeResultCode[] $VALUES;
    private static final int BUFFER_SIZE = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: OK */
    public static final VexFwkNodeResultCode f8084OK = new VexFwkNodeResultCode(CoeditServiceConstants.ServerResponseCode.SERVER_RESPONSE_CODE_OK, 0, 1);
    public static final VexFwkNodeResultCode PROCESS_FAIL = new VexFwkNodeResultCode("PROCESS_FAIL", 1, 2);
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkNodeResultCode$Companion;", "Lcom/samsung/android/vexfwk/param/VexFwkParamBaseBuffer;", "Lcom/samsung/android/vexfwk/param/VexFwkNodeResultCode;", "()V", "BUFFER_SIZE", "", "fromBuffer", "buffer", "Ljava/nio/ByteBuffer;", "toBuffer", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkNodeResultCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkNodeResultCode.kt\ncom/samsung/android/vexfwk/param/VexFwkNodeResultCode$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,26:1\n288#2,2:27\n*S KotlinDebug\n*F\n+ 1 VexFwkNodeResultCode.kt\ncom/samsung/android/vexfwk/param/VexFwkNodeResultCode$Companion\n*L\n18#1:27,2\n*E\n"})
    public static final class Companion extends VexFwkParamBaseBuffer<VexFwkNodeResultCode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public VexFwkNodeResultCode fromBuffer(@NotNull ByteBuffer buffer) {
            VexFwkNodeResultCode next;
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            if (buffer.capacity() != 4) {
                throw new IllegalStateException(AbstractC0000a.m11h(buffer.capacity(), "buffer capacity must be 4. buffer capacity is ").toString());
            }
            int i = buffer.getInt();
            Iterator<VexFwkNodeResultCode> it = VexFwkNodeResultCode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getValue() == i) {
                    break;
                }
            }
            VexFwkNodeResultCode vexFwkNodeResultCode = next;
            if (vexFwkNodeResultCode != null) {
                return vexFwkNodeResultCode;
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown value "));
        }

        @Override // com.samsung.android.vexfwk.param.VexFwkParamBaseBuffer
        @NotNull
        public ByteBuffer toBuffer(@NotNull VexFwkNodeResultCode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ByteBuffer byteBufferPutInt = allocateBuffer(4).putInt(value.getValue());
            Intrinsics.checkNotNullExpressionValue(byteBufferPutInt, "putInt(...)");
            return byteBufferPutInt;
        }
    }

    private static final /* synthetic */ VexFwkNodeResultCode[] $values() {
        return new VexFwkNodeResultCode[]{f8084OK, PROCESS_FAIL};
    }

    static {
        VexFwkNodeResultCode[] vexFwkNodeResultCodeArr$values = $values();
        $VALUES = vexFwkNodeResultCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkNodeResultCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkNodeResultCode(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<VexFwkNodeResultCode> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkNodeResultCode valueOf(String str) {
        return (VexFwkNodeResultCode) Enum.valueOf(VexFwkNodeResultCode.class, str);
    }

    public static VexFwkNodeResultCode[] values() {
        return (VexFwkNodeResultCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

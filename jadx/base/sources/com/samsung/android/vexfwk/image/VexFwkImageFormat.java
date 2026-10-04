package com.samsung.android.vexfwk.image;

import android.hardware.HardwareBuffer;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/image/VexFwkImageFormat;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NV12", "NV21", "RGB_888", "RGBA_8888", "YUV_420_SP_VENUS", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkImageFormat {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkImageFormat[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int HARDWARE_BUFFER_FORMAT_YCBCR_420_SP_VENUS = 2141391876;
    private final int value;
    public static final VexFwkImageFormat UNKNOWN = new VexFwkImageFormat("UNKNOWN", 0, 0);
    public static final VexFwkImageFormat NV12 = new VexFwkImageFormat("NV12", 1, 1);
    public static final VexFwkImageFormat NV21 = new VexFwkImageFormat("NV21", 2, 2);
    public static final VexFwkImageFormat RGB_888 = new VexFwkImageFormat("RGB_888", 3, 3);
    public static final VexFwkImageFormat RGBA_8888 = new VexFwkImageFormat("RGBA_8888", 4, 4);
    public static final VexFwkImageFormat YUV_420_SP_VENUS = new VexFwkImageFormat("YUV_420_SP_VENUS", 5, 5);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/image/VexFwkImageFormat$Companion;", "", "()V", "HARDWARE_BUFFER_FORMAT_YCBCR_420_SP_VENUS", "", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/vexfwk/image/VexFwkImageFormat;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "value", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkImageFormat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageFormat.kt\ncom/samsung/android/vexfwk/image/VexFwkImageFormat$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,34:1\n1282#2,2:35\n*S KotlinDebug\n*F\n+ 1 VexFwkImageFormat.kt\ncom/samsung/android/vexfwk/image/VexFwkImageFormat$Companion\n*L\n19#1:35,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VexFwkImageFormat from(int value) {
            VexFwkImageFormat vexFwkImageFormat;
            VexFwkImageFormat[] vexFwkImageFormatArrValues = VexFwkImageFormat.values();
            int length = vexFwkImageFormatArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    vexFwkImageFormat = null;
                    break;
                }
                vexFwkImageFormat = vexFwkImageFormatArrValues[i];
                if (vexFwkImageFormat.getValue() == value) {
                    break;
                }
                i++;
            }
            if (vexFwkImageFormat != null) {
                return vexFwkImageFormat;
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(value, "Unknown image format "));
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final VexFwkImageFormat from(@NotNull HardwareBuffer hardwareBuffer) {
            Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
            int format = hardwareBuffer.getFormat();
            if (format == 1) {
                return VexFwkImageFormat.RGBA_8888;
            }
            if (format == 35) {
                return VexFwkImageFormat.NV12;
            }
            if (format == VexFwkImageFormat.HARDWARE_BUFFER_FORMAT_YCBCR_420_SP_VENUS) {
                return VexFwkImageFormat.YUV_420_SP_VENUS;
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(hardwareBuffer.getFormat(), "Unsupported hardware buffer format "));
        }
    }

    private static final /* synthetic */ VexFwkImageFormat[] $values() {
        return new VexFwkImageFormat[]{UNKNOWN, NV12, NV21, RGB_888, RGBA_8888, YUV_420_SP_VENUS};
    }

    static {
        VexFwkImageFormat[] vexFwkImageFormatArr$values = $values();
        $VALUES = vexFwkImageFormatArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkImageFormatArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkImageFormat(String str, int i, int i2) {
        this.value = i2;
    }

    @JvmStatic
    @NotNull
    public static final VexFwkImageFormat from(int i) {
        return INSTANCE.from(i);
    }

    @NotNull
    public static EnumEntries<VexFwkImageFormat> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkImageFormat valueOf(String str) {
        return (VexFwkImageFormat) Enum.valueOf(VexFwkImageFormat.class, str);
    }

    public static VexFwkImageFormat[] values() {
        return (VexFwkImageFormat[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    @NotNull
    public static final VexFwkImageFormat from(@NotNull HardwareBuffer hardwareBuffer) {
        return INSTANCE.from(hardwareBuffer);
    }
}

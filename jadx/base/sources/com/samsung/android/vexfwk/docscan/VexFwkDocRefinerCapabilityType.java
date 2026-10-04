package com.samsung.android.vexfwk.docscan;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilityType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CAPABILITY_SHADOW_REMOVAL", "CAPABILITY_DEBLUR", "CAPABILITY_OBJECT_REMOVAL", "CAPABILITY_DEFAULT_COLOR_ENHANCEMENT", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkDocRefinerCapabilityType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkDocRefinerCapabilityType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int value;
    public static final VexFwkDocRefinerCapabilityType CAPABILITY_SHADOW_REMOVAL = new VexFwkDocRefinerCapabilityType("CAPABILITY_SHADOW_REMOVAL", 0, 0);
    public static final VexFwkDocRefinerCapabilityType CAPABILITY_DEBLUR = new VexFwkDocRefinerCapabilityType("CAPABILITY_DEBLUR", 1, 1);
    public static final VexFwkDocRefinerCapabilityType CAPABILITY_OBJECT_REMOVAL = new VexFwkDocRefinerCapabilityType("CAPABILITY_OBJECT_REMOVAL", 2, 2);
    public static final VexFwkDocRefinerCapabilityType CAPABILITY_DEFAULT_COLOR_ENHANCEMENT = new VexFwkDocRefinerCapabilityType("CAPABILITY_DEFAULT_COLOR_ENHANCEMENT", 3, 3);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilityType$Companion;", "", "()V", "fromInt", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilityType;", "value", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkDocRefinerCapabilityType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocRefinerCapabilityType.kt\ncom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilityType$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,13:1\n1109#2,2:14\n*S KotlinDebug\n*F\n+ 1 VexFwkDocRefinerCapabilityType.kt\ncom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilityType$Companion\n*L\n11#1:14,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VexFwkDocRefinerCapabilityType fromInt(int value) {
            for (VexFwkDocRefinerCapabilityType vexFwkDocRefinerCapabilityType : VexFwkDocRefinerCapabilityType.values()) {
                if (vexFwkDocRefinerCapabilityType.getValue() == value) {
                    return vexFwkDocRefinerCapabilityType;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VexFwkDocRefinerCapabilityType[] $values() {
        return new VexFwkDocRefinerCapabilityType[]{CAPABILITY_SHADOW_REMOVAL, CAPABILITY_DEBLUR, CAPABILITY_OBJECT_REMOVAL, CAPABILITY_DEFAULT_COLOR_ENHANCEMENT};
    }

    static {
        VexFwkDocRefinerCapabilityType[] vexFwkDocRefinerCapabilityTypeArr$values = $values();
        $VALUES = vexFwkDocRefinerCapabilityTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkDocRefinerCapabilityTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkDocRefinerCapabilityType(String str, int i, int i2) {
        this.value = i2;
    }

    @JvmStatic
    @NotNull
    public static final VexFwkDocRefinerCapabilityType fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    @NotNull
    public static EnumEntries<VexFwkDocRefinerCapabilityType> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkDocRefinerCapabilityType valueOf(String str) {
        return (VexFwkDocRefinerCapabilityType) Enum.valueOf(VexFwkDocRefinerCapabilityType.class, str);
    }

    public static VexFwkDocRefinerCapabilityType[] values() {
        return (VexFwkDocRefinerCapabilityType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

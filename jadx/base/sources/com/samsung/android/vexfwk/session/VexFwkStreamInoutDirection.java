package com.samsung.android.vexfwk.session;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IN", "OUT", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkStreamInoutDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkStreamInoutDirection[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int value;
    public static final VexFwkStreamInoutDirection UNKNOWN = new VexFwkStreamInoutDirection("UNKNOWN", 0, -1);

    /* JADX INFO: renamed from: IN */
    public static final VexFwkStreamInoutDirection f8118IN = new VexFwkStreamInoutDirection("IN", 1, 0);
    public static final VexFwkStreamInoutDirection OUT = new VexFwkStreamInoutDirection("OUT", 2, 1);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection;", "value", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkStreamInoutDirection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkStreamInoutDirection.kt\ncom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,17:1\n1282#2,2:18\n*S KotlinDebug\n*F\n+ 1 VexFwkStreamInoutDirection.kt\ncom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection$Companion\n*L\n13#1:18,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VexFwkStreamInoutDirection from(int value) {
            VexFwkStreamInoutDirection vexFwkStreamInoutDirection;
            VexFwkStreamInoutDirection[] vexFwkStreamInoutDirectionArrValues = VexFwkStreamInoutDirection.values();
            int length = vexFwkStreamInoutDirectionArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    vexFwkStreamInoutDirection = null;
                    break;
                }
                vexFwkStreamInoutDirection = vexFwkStreamInoutDirectionArrValues[i];
                if (vexFwkStreamInoutDirection.getValue() == value) {
                    break;
                }
                i++;
            }
            if (vexFwkStreamInoutDirection != null) {
                return vexFwkStreamInoutDirection;
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(value, "Unknown stream inout direction "));
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VexFwkStreamInoutDirection[] $values() {
        return new VexFwkStreamInoutDirection[]{UNKNOWN, f8118IN, OUT};
    }

    static {
        VexFwkStreamInoutDirection[] vexFwkStreamInoutDirectionArr$values = $values();
        $VALUES = vexFwkStreamInoutDirectionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkStreamInoutDirectionArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkStreamInoutDirection(String str, int i, int i2) {
        this.value = i2;
    }

    @JvmStatic
    @NotNull
    public static final VexFwkStreamInoutDirection from(int i) {
        return INSTANCE.from(i);
    }

    @NotNull
    public static EnumEntries<VexFwkStreamInoutDirection> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkStreamInoutDirection valueOf(String str) {
        return (VexFwkStreamInoutDirection) Enum.valueOf(VexFwkStreamInoutDirection.class, str);
    }

    public static VexFwkStreamInoutDirection[] values() {
        return (VexFwkStreamInoutDirection[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

package com.samsung.android.vexfwk.imagetranslation;

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
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkTranslationResultCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "INVALID_DIRECTION", "LANGUAGE_PACK_REQUIRED", "RENDERING_FAILURE", "OCR_EMPTY", "TRANSLATION_EMPTY", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkTranslationResultCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkTranslationResultCode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int value;
    public static final VexFwkTranslationResultCode SUCCESS = new VexFwkTranslationResultCode("SUCCESS", 0, 0);
    public static final VexFwkTranslationResultCode INVALID_DIRECTION = new VexFwkTranslationResultCode("INVALID_DIRECTION", 1, 1);
    public static final VexFwkTranslationResultCode LANGUAGE_PACK_REQUIRED = new VexFwkTranslationResultCode("LANGUAGE_PACK_REQUIRED", 2, 2);
    public static final VexFwkTranslationResultCode RENDERING_FAILURE = new VexFwkTranslationResultCode("RENDERING_FAILURE", 3, 3);
    public static final VexFwkTranslationResultCode OCR_EMPTY = new VexFwkTranslationResultCode("OCR_EMPTY", 4, 4);
    public static final VexFwkTranslationResultCode TRANSLATION_EMPTY = new VexFwkTranslationResultCode("TRANSLATION_EMPTY", 5, 5);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/VexFwkTranslationResultCode$Companion;", "", "()V", "fromInt", "Lcom/samsung/android/vexfwk/imagetranslation/VexFwkTranslationResultCode;", "value", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkTranslationResultCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkTranslationResultCode.kt\ncom/samsung/android/vexfwk/imagetranslation/VexFwkTranslationResultCode$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,16:1\n223#2,2:17\n*S KotlinDebug\n*F\n+ 1 VexFwkTranslationResultCode.kt\ncom/samsung/android/vexfwk/imagetranslation/VexFwkTranslationResultCode$Companion\n*L\n13#1:17,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VexFwkTranslationResultCode fromInt(int value) {
            for (VexFwkTranslationResultCode vexFwkTranslationResultCode : VexFwkTranslationResultCode.getEntries()) {
                if (vexFwkTranslationResultCode.getValue() == value) {
                    return vexFwkTranslationResultCode;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VexFwkTranslationResultCode[] $values() {
        return new VexFwkTranslationResultCode[]{SUCCESS, INVALID_DIRECTION, LANGUAGE_PACK_REQUIRED, RENDERING_FAILURE, OCR_EMPTY, TRANSLATION_EMPTY};
    }

    static {
        VexFwkTranslationResultCode[] vexFwkTranslationResultCodeArr$values = $values();
        $VALUES = vexFwkTranslationResultCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkTranslationResultCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkTranslationResultCode(String str, int i, int i2) {
        this.value = i2;
    }

    @JvmStatic
    @NotNull
    public static final VexFwkTranslationResultCode fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    @NotNull
    public static EnumEntries<VexFwkTranslationResultCode> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkTranslationResultCode valueOf(String str) {
        return (VexFwkTranslationResultCode) Enum.valueOf(VexFwkTranslationResultCode.class, str);
    }

    public static VexFwkTranslationResultCode[] values() {
        return (VexFwkTranslationResultCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

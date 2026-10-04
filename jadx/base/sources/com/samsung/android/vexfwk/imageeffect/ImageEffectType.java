package com.samsung.android.vexfwk.imageeffect;

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
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EFFECT_TYPE_GRAYSCALE", "EFFECT_TYPE_BLUR", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ImageEffectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImageEffectType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int value;
    public static final ImageEffectType EFFECT_TYPE_GRAYSCALE = new ImageEffectType("EFFECT_TYPE_GRAYSCALE", 0, 0);
    public static final ImageEffectType EFFECT_TYPE_BLUR = new ImageEffectType("EFFECT_TYPE_BLUR", 1, 1);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType$Companion;", "", "()V", "fromInt", "Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "value", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nImageEffectType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageEffectType.kt\ncom/samsung/android/vexfwk/imageeffect/ImageEffectType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,11:1\n223#2,2:12\n*S KotlinDebug\n*F\n+ 1 ImageEffectType.kt\ncom/samsung/android/vexfwk/imageeffect/ImageEffectType$Companion\n*L\n9#1:12,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ImageEffectType fromInt(int value) {
            for (ImageEffectType imageEffectType : ImageEffectType.getEntries()) {
                if (imageEffectType.getValue() == value) {
                    return imageEffectType;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ImageEffectType[] $values() {
        return new ImageEffectType[]{EFFECT_TYPE_GRAYSCALE, EFFECT_TYPE_BLUR};
    }

    static {
        ImageEffectType[] imageEffectTypeArr$values = $values();
        $VALUES = imageEffectTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(imageEffectTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private ImageEffectType(String str, int i, int i2) {
        this.value = i2;
    }

    @JvmStatic
    @NotNull
    public static final ImageEffectType fromInt(int i) {
        return INSTANCE.fromInt(i);
    }

    @NotNull
    public static EnumEntries<ImageEffectType> getEntries() {
        return $ENTRIES;
    }

    public static ImageEffectType valueOf(String str) {
        return (ImageEffectType) Enum.valueOf(ImageEffectType.class, str);
    }

    public static ImageEffectType[] values() {
        return (ImageEffectType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

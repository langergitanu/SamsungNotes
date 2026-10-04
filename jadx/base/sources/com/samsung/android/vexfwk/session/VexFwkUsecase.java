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
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/vexfwk/session/VexFwkUsecase;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "DOCUMENT_DETECTION", "DOCUMENT_DEWARPING", "OBJECT_SEGMENTATION", "OBJECT_REMOVAL", "FRAME_RATE_CONVERSION", "WINE_DETECTION", "DOCUMENT_REFINEMENT", "VIDEO_OBJECT_REMOVAL", "OBJECT_EXTRACTION", "IMAGE_OBJECT_REMOVAL", "IMAGE_TRANSLATION", "TRANSLATION_UTIL", "IMAGE_CLIPPER", "IMAGE_TAGGER", "PORTRAIT_BOKEH_EFFECT", "IMAGE_EFFECT", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkUsecase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VexFwkUsecase[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final int id;
    public static final VexFwkUsecase DOCUMENT_DETECTION = new VexFwkUsecase("DOCUMENT_DETECTION", 0, 0);
    public static final VexFwkUsecase DOCUMENT_DEWARPING = new VexFwkUsecase("DOCUMENT_DEWARPING", 1, 1);
    public static final VexFwkUsecase OBJECT_SEGMENTATION = new VexFwkUsecase("OBJECT_SEGMENTATION", 2, 2);
    public static final VexFwkUsecase OBJECT_REMOVAL = new VexFwkUsecase("OBJECT_REMOVAL", 3, 3);
    public static final VexFwkUsecase FRAME_RATE_CONVERSION = new VexFwkUsecase("FRAME_RATE_CONVERSION", 4, 4);
    public static final VexFwkUsecase WINE_DETECTION = new VexFwkUsecase("WINE_DETECTION", 5, 5);
    public static final VexFwkUsecase DOCUMENT_REFINEMENT = new VexFwkUsecase("DOCUMENT_REFINEMENT", 6, 6);
    public static final VexFwkUsecase VIDEO_OBJECT_REMOVAL = new VexFwkUsecase("VIDEO_OBJECT_REMOVAL", 7, 7);
    public static final VexFwkUsecase OBJECT_EXTRACTION = new VexFwkUsecase("OBJECT_EXTRACTION", 8, 8);
    public static final VexFwkUsecase IMAGE_OBJECT_REMOVAL = new VexFwkUsecase("IMAGE_OBJECT_REMOVAL", 9, 9);
    public static final VexFwkUsecase IMAGE_TRANSLATION = new VexFwkUsecase("IMAGE_TRANSLATION", 10, 10);
    public static final VexFwkUsecase TRANSLATION_UTIL = new VexFwkUsecase("TRANSLATION_UTIL", 11, 11);
    public static final VexFwkUsecase IMAGE_CLIPPER = new VexFwkUsecase("IMAGE_CLIPPER", 12, 12);
    public static final VexFwkUsecase IMAGE_TAGGER = new VexFwkUsecase("IMAGE_TAGGER", 13, 13);
    public static final VexFwkUsecase PORTRAIT_BOKEH_EFFECT = new VexFwkUsecase("PORTRAIT_BOKEH_EFFECT", 14, 14);
    public static final VexFwkUsecase IMAGE_EFFECT = new VexFwkUsecase("IMAGE_EFFECT", 15, 15);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/session/VexFwkUsecase$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/vexfwk/session/VexFwkUsecase;", "id", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkUsecase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkUsecase.kt\ncom/samsung/android/vexfwk/session/VexFwkUsecase$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1#2:31\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VexFwkUsecase from(int id) {
            VexFwkUsecase vexFwkUsecase;
            VexFwkUsecase[] vexFwkUsecaseArrValues = VexFwkUsecase.values();
            int length = vexFwkUsecaseArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    vexFwkUsecase = null;
                    break;
                }
                vexFwkUsecase = vexFwkUsecaseArrValues[i];
                if (vexFwkUsecase.getId() == id) {
                    break;
                }
                i++;
            }
            if (vexFwkUsecase != null) {
                return vexFwkUsecase;
            }
            throw new IllegalArgumentException(AbstractC0000a.m11h(id, "Unknown usecase id "));
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VexFwkUsecase[] $values() {
        return new VexFwkUsecase[]{DOCUMENT_DETECTION, DOCUMENT_DEWARPING, OBJECT_SEGMENTATION, OBJECT_REMOVAL, FRAME_RATE_CONVERSION, WINE_DETECTION, DOCUMENT_REFINEMENT, VIDEO_OBJECT_REMOVAL, OBJECT_EXTRACTION, IMAGE_OBJECT_REMOVAL, IMAGE_TRANSLATION, TRANSLATION_UTIL, IMAGE_CLIPPER, IMAGE_TAGGER, PORTRAIT_BOKEH_EFFECT, IMAGE_EFFECT};
    }

    static {
        VexFwkUsecase[] vexFwkUsecaseArr$values = $values();
        $VALUES = vexFwkUsecaseArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(vexFwkUsecaseArr$values);
        INSTANCE = new Companion(null);
    }

    private VexFwkUsecase(String str, int i, int i2) {
        this.id = i2;
    }

    @JvmStatic
    @NotNull
    public static final VexFwkUsecase from(int i) {
        return INSTANCE.from(i);
    }

    @NotNull
    public static EnumEntries<VexFwkUsecase> getEntries() {
        return $ENTRIES;
    }

    public static VexFwkUsecase valueOf(String str) {
        return (VexFwkUsecase) Enum.valueOf(VexFwkUsecase.class, str);
    }

    public static VexFwkUsecase[] values() {
        return (VexFwkUsecase[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}

package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/DigitalSourceType;", "", "uri", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUri", "()Ljava/lang/String;", "DIGITAL_CAPTURE", "NEGATIVE_FILM", "POSITIVE_FILM", "PRINT", "MINOR_HUMAN_EDITS", "COMPOSITE_CAPTURE", "ALGORITHMICALLY_ENHANCED", "DATA_DRIVEN_MEDIA", "DIGITAL_ART", "VIRTUAL_RECORDING", "COMPOSITE_SYNTHETIC", "TRAINED_ALGORITHMIC_MEDIA", "COMPOSITE_WITH_TRAINED_ALGORITHMIC_MEDIA", "ALGORITHMIC_MEDIA", "C2PA_TRAINED_ALGORITHMIC_MEDIA_OLD", "C2PA_TRAINED_ALGORITHMIC_MEDIA_NEW", "C2PA_EMPTY", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class DigitalSourceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DigitalSourceType[] $VALUES;

    @NotNull
    private final String uri;
    public static final DigitalSourceType DIGITAL_CAPTURE = new DigitalSourceType("DIGITAL_CAPTURE", 0, "http://cv.iptc.org/newscodes/digitalsourcetype/digitalCapture");
    public static final DigitalSourceType NEGATIVE_FILM = new DigitalSourceType("NEGATIVE_FILM", 1, "http://cv.iptc.org/newscodes/digitalsourcetype/negativeFilm");
    public static final DigitalSourceType POSITIVE_FILM = new DigitalSourceType("POSITIVE_FILM", 2, "http://cv.iptc.org/newscodes/digitalsourcetype/positiveFilm");
    public static final DigitalSourceType PRINT = new DigitalSourceType("PRINT", 3, "http://cv.iptc.org/newscodes/digitalsourcetype/print");
    public static final DigitalSourceType MINOR_HUMAN_EDITS = new DigitalSourceType("MINOR_HUMAN_EDITS", 4, "http://cv.iptc.org/newscodes/digitalsourcetype/minorHumanEdits");
    public static final DigitalSourceType COMPOSITE_CAPTURE = new DigitalSourceType("COMPOSITE_CAPTURE", 5, "http://cv.iptc.org/newscodes/digitalsourcetype/compositeCapture");
    public static final DigitalSourceType ALGORITHMICALLY_ENHANCED = new DigitalSourceType("ALGORITHMICALLY_ENHANCED", 6, "http://cv.iptc.org/newscodes/digitalsourcetype/algorithmicallyEnhanced");
    public static final DigitalSourceType DATA_DRIVEN_MEDIA = new DigitalSourceType("DATA_DRIVEN_MEDIA", 7, "http://cv.iptc.org/newscodes/digitalsourcetype/dataDrivenMedia");
    public static final DigitalSourceType DIGITAL_ART = new DigitalSourceType("DIGITAL_ART", 8, "http://cv.iptc.org/newscodes/digitalsourcetype/digitalArt");
    public static final DigitalSourceType VIRTUAL_RECORDING = new DigitalSourceType("VIRTUAL_RECORDING", 9, "http://cv.iptc.org/newscodes/digitalsourcetype/virtualRecording");
    public static final DigitalSourceType COMPOSITE_SYNTHETIC = new DigitalSourceType("COMPOSITE_SYNTHETIC", 10, "http://cv.iptc.org/newscodes/digitalsourcetype/compositeSynthetic");
    public static final DigitalSourceType TRAINED_ALGORITHMIC_MEDIA = new DigitalSourceType("TRAINED_ALGORITHMIC_MEDIA", 11, "http://cv.iptc.org/newscodes/digitalsourcetype/trainedAlgorithmicMedia");
    public static final DigitalSourceType COMPOSITE_WITH_TRAINED_ALGORITHMIC_MEDIA = new DigitalSourceType("COMPOSITE_WITH_TRAINED_ALGORITHMIC_MEDIA", 12, "http://cv.iptc.org/newscodes/digitalsourcetype/compositeWithTrainedAlgorithmicMedia");
    public static final DigitalSourceType ALGORITHMIC_MEDIA = new DigitalSourceType("ALGORITHMIC_MEDIA", 13, "http://cv.iptc.org/newscodes/digitalsourcetype/algorithmicMedia");
    public static final DigitalSourceType C2PA_TRAINED_ALGORITHMIC_MEDIA_OLD = new DigitalSourceType("C2PA_TRAINED_ALGORITHMIC_MEDIA_OLD", 14, "c2pa.trainedAlgorithmicData");
    public static final DigitalSourceType C2PA_TRAINED_ALGORITHMIC_MEDIA_NEW = new DigitalSourceType("C2PA_TRAINED_ALGORITHMIC_MEDIA_NEW", 15, "http://c2pa.org/digitalsourcetype/trainedAlgorithmicData");
    public static final DigitalSourceType C2PA_EMPTY = new DigitalSourceType("C2PA_EMPTY", 16, "http://c2pa.org/digitalsourcetype/empty");

    private static final /* synthetic */ DigitalSourceType[] $values() {
        return new DigitalSourceType[]{DIGITAL_CAPTURE, NEGATIVE_FILM, POSITIVE_FILM, PRINT, MINOR_HUMAN_EDITS, COMPOSITE_CAPTURE, ALGORITHMICALLY_ENHANCED, DATA_DRIVEN_MEDIA, DIGITAL_ART, VIRTUAL_RECORDING, COMPOSITE_SYNTHETIC, TRAINED_ALGORITHMIC_MEDIA, COMPOSITE_WITH_TRAINED_ALGORITHMIC_MEDIA, ALGORITHMIC_MEDIA, C2PA_TRAINED_ALGORITHMIC_MEDIA_OLD, C2PA_TRAINED_ALGORITHMIC_MEDIA_NEW, C2PA_EMPTY};
    }

    static {
        DigitalSourceType[] digitalSourceTypeArr$values = $values();
        $VALUES = digitalSourceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(digitalSourceTypeArr$values);
    }

    private DigitalSourceType(String str, int i, String str2) {
        this.uri = str2;
    }

    @NotNull
    public static EnumEntries<DigitalSourceType> getEntries() {
        return $ENTRIES;
    }

    public static DigitalSourceType valueOf(String str) {
        return (DigitalSourceType) Enum.valueOf(DigitalSourceType.class, str);
    }

    public static DigitalSourceType[] values() {
        return (DigitalSourceType[]) $VALUES.clone();
    }

    @NotNull
    public final String getUri() {
        return this.uri;
    }
}

package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type;

import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterCover;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterJournalInfo;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterMeetingAutoFormat;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterSpellingCorrection;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterStructuredAutoFormat;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterSummary;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterTravelReservationInfo;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterTravelSchedule;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm.SCSRequesterTravelTip;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "", SearchConstants.TargetContents.TAG, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "StructuredAutoFormat", "MeetingAutoFormat", "SpellingCorrection", "Cover", Features.FUNCTION, "JournalInfo", "TravelSchedule", "TravelTip", "TravelReservationInfo", "STTSummary", "Translation", "SketchToImage", "TextToImage", "VirtualScsDrawing", "VirtualScsNoteDescription", "create", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", "streaming", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class SCSRequesterType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SCSRequesterType[] $VALUES;

    @NotNull
    private final String TAG;
    public static final SCSRequesterType StructuredAutoFormat = new SCSRequesterType("StructuredAutoFormat", 0) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.StructuredAutoFormat
        {
            String str = "StructuredAutoFormat";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterStructuredAutoFormat(streaming);
        }
    };
    public static final SCSRequesterType MeetingAutoFormat = new SCSRequesterType("MeetingAutoFormat", 1) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.MeetingAutoFormat
        {
            String str = "MeetingAutoFormat";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterMeetingAutoFormat(streaming);
        }
    };
    public static final SCSRequesterType SpellingCorrection = new SCSRequesterType("SpellingCorrection", 2) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.SpellingCorrection
        {
            String str = "SpellingCorrection";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterSpellingCorrection(streaming);
        }
    };
    public static final SCSRequesterType Cover = new SCSRequesterType("Cover", 3) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.Cover
        {
            String str = "Cover";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterCover(streaming);
        }
    };
    public static final SCSRequesterType Summary = new SCSRequesterType(Features.FUNCTION, 4) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.Summary
        {
            String str = Features.FUNCTION;
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterSummary(streaming);
        }
    };
    public static final SCSRequesterType JournalInfo = new SCSRequesterType("JournalInfo", 5) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.JournalInfo
        {
            String str = "JournalInfo";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterJournalInfo(streaming);
        }
    };
    public static final SCSRequesterType TravelSchedule = new SCSRequesterType("TravelSchedule", 6) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.TravelSchedule
        {
            String str = "TravelSchedule";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterTravelSchedule(streaming);
        }
    };
    public static final SCSRequesterType TravelTip = new SCSRequesterType("TravelTip", 7) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.TravelTip
        {
            String str = "TravelTip";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterTravelTip(streaming);
        }
    };
    public static final SCSRequesterType TravelReservationInfo = new SCSRequesterType("TravelReservationInfo", 8) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.TravelReservationInfo
        {
            String str = "TravelReservationInfo";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterTravelReservationInfo(streaming);
        }
    };
    public static final SCSRequesterType STTSummary = new SCSRequesterType("STTSummary", 9) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.STTSummary
        {
            String str = "STTSummary";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @NotNull
        public SCSServiceRequester create(boolean streaming) {
            return new SCSRequesterSummary(streaming);
        }
    };
    public static final SCSRequesterType Translation = new SCSRequesterType("Translation", 10) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.Translation
        {
            String str = "Translation";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @Nullable
        public SCSServiceRequester create(boolean streaming) {
            return null;
        }
    };
    public static final SCSRequesterType SketchToImage = new SCSRequesterType("SketchToImage", 11) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.SketchToImage
        {
            String str = "SketchToImage";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @Nullable
        public SCSServiceRequester create(boolean streaming) {
            return null;
        }
    };
    public static final SCSRequesterType TextToImage = new SCSRequesterType("TextToImage", 12) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.TextToImage
        {
            String str = "TextToImage";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @Nullable
        public SCSServiceRequester create(boolean streaming) {
            return null;
        }
    };
    public static final SCSRequesterType VirtualScsDrawing = new SCSRequesterType("VirtualScsDrawing", 13) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.VirtualScsDrawing
        {
            String str = "VirtualScsDrawing";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @Nullable
        public SCSServiceRequester create(boolean streaming) {
            return null;
        }
    };
    public static final SCSRequesterType VirtualScsNoteDescription = new SCSRequesterType("VirtualScsNoteDescription", 14) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.type.SCSRequesterType.VirtualScsNoteDescription
        {
            String str = "VirtualScsNoteDescription";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType
        @Nullable
        public SCSServiceRequester create(boolean streaming) {
            return null;
        }
    };

    private static final /* synthetic */ SCSRequesterType[] $values() {
        return new SCSRequesterType[]{StructuredAutoFormat, MeetingAutoFormat, SpellingCorrection, Cover, Summary, JournalInfo, TravelSchedule, TravelTip, TravelReservationInfo, STTSummary, Translation, SketchToImage, TextToImage, VirtualScsDrawing, VirtualScsNoteDescription};
    }

    static {
        SCSRequesterType[] sCSRequesterTypeArr$values = $values();
        $VALUES = sCSRequesterTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sCSRequesterTypeArr$values);
    }

    public /* synthetic */ SCSRequesterType(String str, int i, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2);
    }

    public static /* synthetic */ SCSServiceRequester create$default(SCSRequesterType sCSRequesterType, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return sCSRequesterType.create(z);
    }

    @NotNull
    public static EnumEntries<SCSRequesterType> getEntries() {
        return $ENTRIES;
    }

    public static SCSRequesterType valueOf(String str) {
        return (SCSRequesterType) Enum.valueOf(SCSRequesterType.class, str);
    }

    public static SCSRequesterType[] values() {
        return (SCSRequesterType[]) $VALUES.clone();
    }

    @Nullable
    public abstract SCSServiceRequester create(boolean streaming);

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    private SCSRequesterType(String str, int i, String str2) {
        this.TAG = str2;
    }
}

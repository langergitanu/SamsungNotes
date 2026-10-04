package com.samsung.android.support.senl.p148nt.stt.base.model;

import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AIParagraphAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISpeakerAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISummarySectionAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aSerializableAtomHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020OJ\u0006\u0010S\u001a\u00020OJ\u0006\u0010T\u001a\u00020OJ\u0006\u0010U\u001a\u00020OR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u0005R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR4\u0010\u001c\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u001dj\b\u0012\u0004\u0012\u00020\u0003`\u001e\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u001c\u0010<\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001c\u0010?\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\u001c\u0010B\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00106\"\u0004\bD\u00108R\u001c\u0010E\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00106\"\u0004\bG\u00108R\u001c\u0010H\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010'\"\u0004\bJ\u0010)R\u001c\u0010K\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010'\"\u0004\bM\u0010)¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReader;", "", "voicePath", "", "<init>", "(Ljava/lang/String;)V", "getVoicePath", "()Ljava/lang/String;", "speakerNameMapJSON", "getSpeakerNameMapJSON", "setSpeakerNameMapJSON", "summaryDataJSON", "getSummaryDataJSON", "setSummaryDataJSON", "speakerNameMap", "", "", "getSpeakerNameMap", "()Ljava/util/Map;", "setSpeakerNameMap", "(Ljava/util/Map;)V", "summaryTitle", "", "getSummaryTitle", "()[Ljava/lang/String;", "setSummaryTitle", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "summaryLines", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSummaryLines", "()[Ljava/util/ArrayList;", "setSummaryLines", "([Ljava/util/ArrayList;)V", "[Ljava/util/ArrayList;", "timeStamp", "", "getTimeStamp", "()[J", "setTimeStamp", "([J)V", "summaryStyle", "getSummaryStyle", "()Ljava/lang/Integer;", "setSummaryStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "voiceTexts", "getVoiceTexts", "setVoiceTexts", "voiceTextLengths", "", "getVoiceTextLengths", "()[I", "setVoiceTextLengths", "([I)V", "voiceTextStartTimes", "getVoiceTextStartTimes", "setVoiceTextStartTimes", "voiceTextEndTimes", "getVoiceTextEndTimes", "setVoiceTextEndTimes", "voiceTimes", "getVoiceTimes", "setVoiceTimes", "voiceSpeakerIDs", "getVoiceSpeakerIDs", "setVoiceSpeakerIDs", "paragraphSpeakerIDs", "getParagraphSpeakerIDs", "setParagraphSpeakerIDs", "paragraphStartTimes", "getParagraphStartTimes", "setParagraphStartTimes", "paragraphEndTimes", "getParagraphEndTimes", "setParagraphEndTimes", "loadDataFromFile", "", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "updateVoiceTime", "loadSpeakerDataFromFile", "loadSummaryDataFromFile", "loadParagraphDataFromFile", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenVoiceTextDataReader {

    @Nullable
    private long[] paragraphEndTimes;

    @Nullable
    private int[] paragraphSpeakerIDs;

    @Nullable
    private long[] paragraphStartTimes;

    @Nullable
    private String speakerNameMapJSON;

    @Nullable
    private String summaryDataJSON;

    @Nullable
    private Integer summaryStyle;

    @Nullable
    private final String voicePath;

    @Nullable
    private long[] voiceTextEndTimes;

    @Nullable
    private int[] voiceTextLengths;

    @Nullable
    private long[] voiceTextStartTimes;

    @Nullable
    private int[] voiceTimes;

    @Nullable
    private Map<Integer, String> speakerNameMap = MapsKt.emptyMap();

    @Nullable
    private String[] summaryTitle = new String[0];

    @Nullable
    private ArrayList<String>[] summaryLines = new ArrayList[0];

    @Nullable
    private long[] timeStamp = new long[0];

    @Nullable
    private String[] voiceTexts = new String[0];

    @Nullable
    private int[] voiceSpeakerIDs = new int[0];

    public SpenVoiceTextDataReader(@Nullable String str) {
        this.voicePath = str;
    }

    @Nullable
    public final long[] getParagraphEndTimes() {
        return this.paragraphEndTimes;
    }

    @Nullable
    public final int[] getParagraphSpeakerIDs() {
        return this.paragraphSpeakerIDs;
    }

    @Nullable
    public final long[] getParagraphStartTimes() {
        return this.paragraphStartTimes;
    }

    @Nullable
    public final Map<Integer, String> getSpeakerNameMap() {
        return this.speakerNameMap;
    }

    @Nullable
    public final String getSpeakerNameMapJSON() {
        return this.speakerNameMapJSON;
    }

    @Nullable
    public final String getSummaryDataJSON() {
        return this.summaryDataJSON;
    }

    @Nullable
    public final ArrayList<String>[] getSummaryLines() {
        return this.summaryLines;
    }

    @Nullable
    public final Integer getSummaryStyle() {
        return this.summaryStyle;
    }

    @Nullable
    public final String[] getSummaryTitle() {
        return this.summaryTitle;
    }

    @Nullable
    public final long[] getTimeStamp() {
        return this.timeStamp;
    }

    @Nullable
    public final String getVoicePath() {
        return this.voicePath;
    }

    @Nullable
    public final int[] getVoiceSpeakerIDs() {
        return this.voiceSpeakerIDs;
    }

    @Nullable
    public final long[] getVoiceTextEndTimes() {
        return this.voiceTextEndTimes;
    }

    @Nullable
    public final int[] getVoiceTextLengths() {
        return this.voiceTextLengths;
    }

    @Nullable
    public final long[] getVoiceTextStartTimes() {
        return this.voiceTextStartTimes;
    }

    @Nullable
    public final String[] getVoiceTexts() {
        return this.voiceTexts;
    }

    @Nullable
    public final int[] getVoiceTimes() {
        return this.voiceTimes;
    }

    public final void loadDataFromFile(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        String str = this.voicePath;
        if (str == null) {
            return;
        }
        M4aSerializableAtomHelper m4aSerializableAtomHelper = new M4aSerializableAtomHelper(str);
        String updatePath = m4aSerializableAtomHelper.getUpdatePath();
        if (updatePath != null) {
            voiceData.attachFile(updatePath);
            m4aSerializableAtomHelper = new M4aSerializableAtomHelper(voiceData.getAttachedFile());
        }
        this.voiceTexts = m4aSerializableAtomHelper.getVoiceTexts();
        this.voiceTextLengths = m4aSerializableAtomHelper.getVoiceTextLengths();
        this.voiceTextStartTimes = m4aSerializableAtomHelper.getVoiceTextStartTimes();
        this.voiceTextEndTimes = m4aSerializableAtomHelper.getVoiceTextEndTimes();
        this.voiceSpeakerIDs = m4aSerializableAtomHelper.getVoiceSpeakerIDs();
        updateVoiceTime();
        loadSpeakerDataFromFile();
        loadSummaryDataFromFile();
        loadParagraphDataFromFile();
    }

    public final void loadParagraphDataFromFile() {
        String str = this.voicePath;
        if (str == null) {
            return;
        }
        AIParagraphAtomHelper aIParagraphAtomHelper = new AIParagraphAtomHelper(str);
        this.paragraphSpeakerIDs = aIParagraphAtomHelper.getSpeakerIdList();
        this.paragraphStartTimes = aIParagraphAtomHelper.getStartTimeList();
        this.paragraphEndTimes = aIParagraphAtomHelper.getEndTimeList();
    }

    public final void loadSpeakerDataFromFile() {
        String str = this.voicePath;
        if (str == null) {
            return;
        }
        AISpeakerAtomHelper aISpeakerAtomHelper = new AISpeakerAtomHelper(str);
        this.speakerNameMapJSON = aISpeakerAtomHelper.getJson();
        this.speakerNameMap = aISpeakerAtomHelper.getSpeakerData();
    }

    public final void loadSummaryDataFromFile() {
        String str = this.voicePath;
        if (str == null) {
            return;
        }
        AISummarySectionAtomHelper aISummarySectionAtomHelper = new AISummarySectionAtomHelper(str);
        this.summaryDataJSON = aISummarySectionAtomHelper.getJson();
        this.summaryTitle = aISummarySectionAtomHelper.getSummaryTitle();
        this.summaryLines = aISummarySectionAtomHelper.getSummaryLines();
        this.summaryStyle = Integer.valueOf(aISummarySectionAtomHelper.getStyle());
        this.timeStamp = aISummarySectionAtomHelper.getTimeStamp();
    }

    public final void setParagraphEndTimes(@Nullable long[] jArr) {
        this.paragraphEndTimes = jArr;
    }

    public final void setParagraphSpeakerIDs(@Nullable int[] iArr) {
        this.paragraphSpeakerIDs = iArr;
    }

    public final void setParagraphStartTimes(@Nullable long[] jArr) {
        this.paragraphStartTimes = jArr;
    }

    public final void setSpeakerNameMap(@Nullable Map<Integer, String> map) {
        this.speakerNameMap = map;
    }

    public final void setSpeakerNameMapJSON(@Nullable String str) {
        this.speakerNameMapJSON = str;
    }

    public final void setSummaryDataJSON(@Nullable String str) {
        this.summaryDataJSON = str;
    }

    public final void setSummaryLines(@Nullable ArrayList<String>[] arrayListArr) {
        this.summaryLines = arrayListArr;
    }

    public final void setSummaryStyle(@Nullable Integer num) {
        this.summaryStyle = num;
    }

    public final void setSummaryTitle(@Nullable String[] strArr) {
        this.summaryTitle = strArr;
    }

    public final void setTimeStamp(@Nullable long[] jArr) {
        this.timeStamp = jArr;
    }

    public final void setVoiceSpeakerIDs(@Nullable int[] iArr) {
        this.voiceSpeakerIDs = iArr;
    }

    public final void setVoiceTextEndTimes(@Nullable long[] jArr) {
        this.voiceTextEndTimes = jArr;
    }

    public final void setVoiceTextLengths(@Nullable int[] iArr) {
        this.voiceTextLengths = iArr;
    }

    public final void setVoiceTextStartTimes(@Nullable long[] jArr) {
        this.voiceTextStartTimes = jArr;
    }

    public final void setVoiceTexts(@Nullable String[] strArr) {
        this.voiceTexts = strArr;
    }

    public final void setVoiceTimes(@Nullable int[] iArr) {
        this.voiceTimes = iArr;
    }

    public final void updateVoiceTime() {
        long[] jArr = this.voiceTextStartTimes;
        if (jArr == null || this.voiceTextEndTimes == null) {
            return;
        }
        Intrinsics.checkNotNull(jArr);
        int length = jArr.length;
        this.voiceTimes = new int[length * 2];
        for (int i = 0; i < length; i++) {
            long[] jArr2 = this.voiceTextStartTimes;
            Intrinsics.checkNotNull(jArr2);
            int i2 = (int) (jArr2[i] / 10);
            long[] jArr3 = this.voiceTextEndTimes;
            Intrinsics.checkNotNull(jArr3);
            int i4 = (int) (jArr3[i] / 10);
            int[] iArr = this.voiceTimes;
            Intrinsics.checkNotNull(iArr);
            int i5 = i * 2;
            iArr[i5] = i2;
            int[] iArr2 = this.voiceTimes;
            Intrinsics.checkNotNull(iArr2);
            iArr2[i5 + 1] = i4;
        }
    }
}

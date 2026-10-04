package com.samsung.android.support.senl.p148nt.stt.view;

import android.text.SpannableStringBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiParagraphInfo;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00105\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0003J\u0006\u0010=\u001a\u00020;J\u001c\u0010>\u001a\u00020;2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0003\u0018\u00010%J$\u0010:\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u00010\u001c2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010AR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R:\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0003\u0018\u00010%2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0003\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0004\u0018\u00010\u00132\b\u00102\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R.\u00107\u001a\u0016\u0012\u0004\u0012\u000208\u0018\u00010+j\n\u0012\u0004\u0012\u000208\u0018\u0001`-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/STTVoiceItem;", "", "name", "", DBSchema.DocumentThumbnail.PLAY_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPlayTime", "setPlayTime", "isPlaying", "", "()Z", "setPlaying", "(Z)V", "mRecognizeResult", "Landroid/text/SpannableStringBuilder;", "text", "", "getText", "()[Ljava/lang/String;", "setText", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "timeStamp", "", "getTimeStamp", "()[I", "setTimeStamp", "([I)V", "speakerIds", "getSpeakerIds", "setSpeakerIds", "value", "", "", "speakerNameMap", "getSpeakerNameMap", "()Ljava/util/Map;", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "getTextDataList", "()Ljava/util/ArrayList;", "setTextDataList", "(Ljava/util/ArrayList;)V", "recognizeResult", "getRecognizeResult", "()Landroid/text/SpannableStringBuilder;", "setRecognizeResult", "(Landroid/text/SpannableStringBuilder;)V", "paragraphInfo", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiParagraphInfo;", "getParagraphInfo", "setParagraphInfo", "", "str", "clearSpan", "setSpeakerMap", "paragraphSpeakerIDs", "paragraphStartTimes", "", "paragraphEndTimes", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTVoiceItem {
    private boolean isPlaying;

    @NotNull
    private SpannableStringBuilder mRecognizeResult;

    @NotNull
    private String name;

    @Nullable
    private ArrayList<AiParagraphInfo> paragraphInfo;

    @Nullable
    private String playTime;

    @Nullable
    private int[] speakerIds;

    @Nullable
    private Map<Integer, String> speakerNameMap;

    @Nullable
    private String[] text;

    @NotNull
    private ArrayList<TextData> textDataList;

    @Nullable
    private int[] timeStamp;

    public STTVoiceItem(@NotNull String name, @Nullable String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.playTime = str;
        this.mRecognizeResult = new SpannableStringBuilder();
        this.textDataList = new ArrayList<>();
        this.paragraphInfo = new ArrayList<>();
    }

    public final void clearSpan() {
        this.mRecognizeResult.clearSpans();
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ArrayList<AiParagraphInfo> getParagraphInfo() {
        return this.paragraphInfo;
    }

    @Nullable
    public final String getPlayTime() {
        return this.playTime;
    }

    @Nullable
    /* JADX INFO: renamed from: getRecognizeResult, reason: from getter */
    public final SpannableStringBuilder getMRecognizeResult() {
        return this.mRecognizeResult;
    }

    @Nullable
    public final int[] getSpeakerIds() {
        return this.speakerIds;
    }

    @Nullable
    public final Map<Integer, String> getSpeakerNameMap() {
        return this.speakerNameMap;
    }

    @Nullable
    public final String[] getText() {
        return this.text;
    }

    @NotNull
    public final ArrayList<TextData> getTextDataList() {
        return this.textDataList;
    }

    @Nullable
    public final int[] getTimeStamp() {
        return this.timeStamp;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setParagraphInfo(@Nullable ArrayList<AiParagraphInfo> arrayList) {
        this.paragraphInfo = arrayList;
    }

    public final void setPlayTime(@Nullable String str) {
        this.playTime = str;
    }

    public final void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public final void setRecognizeResult(@Nullable SpannableStringBuilder spannableStringBuilder) {
        this.mRecognizeResult = new SpannableStringBuilder(spannableStringBuilder);
    }

    public final void setSpeakerIds(@Nullable int[] iArr) {
        this.speakerIds = iArr;
    }

    public final void setSpeakerMap(@Nullable Map<Integer, String> speakerNameMap) {
        this.speakerNameMap = speakerNameMap;
    }

    public final void setText(@Nullable String[] strArr) {
        this.text = strArr;
    }

    public final void setTextDataList(@NotNull ArrayList<TextData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.textDataList = arrayList;
    }

    public final void setTimeStamp(@Nullable int[] iArr) {
        this.timeStamp = iArr;
    }

    public final void setParagraphInfo(@Nullable int[] paragraphSpeakerIDs, @Nullable long[] paragraphStartTimes, @Nullable long[] paragraphEndTimes) {
        if (paragraphSpeakerIDs == null || paragraphStartTimes == null || paragraphEndTimes == null) {
            return;
        }
        int length = paragraphSpeakerIDs.length;
        for (int i = 0; i < length; i++) {
            ArrayList<AiParagraphInfo> arrayList = this.paragraphInfo;
            if (arrayList != null) {
                arrayList.add(new AiParagraphInfo(Integer.valueOf(paragraphSpeakerIDs[i]), Long.valueOf(paragraphStartTimes[i]), Long.valueOf(paragraphEndTimes[i])));
            }
        }
    }

    public final void setRecognizeResult(@Nullable String str) {
        this.mRecognizeResult = new SpannableStringBuilder(str);
    }
}

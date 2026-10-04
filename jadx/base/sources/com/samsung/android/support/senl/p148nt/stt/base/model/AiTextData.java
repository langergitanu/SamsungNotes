package com.samsung.android.support.senl.p148nt.stt.base.model;

import android.text.SpannableStringBuilder;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.TranslatorCommonHelper;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001CBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u00107\u001a\u0002082\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\tJ\u0006\u0010=\u001a\u000208J\u0010\u0010>\u001a\u0002082\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u000e\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\u0003J\u0011\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020$0\u000bj\b\u0012\u0004\u0012\u00020$`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011R\u001e\u0010'\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u001c\u0010*\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102RD\u00103\u001a\u0012\u0012\u0004\u0012\u00020$0\u000bj\b\u0012\u0004\u0012\u00020$`\r2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020$0\u000bj\b\u0012\u0004\u0012\u00020$`\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\"\"\u0004\b5\u00106R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010\u001c¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData;", "", "originalId", "", "nameSpeaker", "", "startOfSpeech", "endOfSpeech", "text", "Landroid/text/SpannableStringBuilder;", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "<init>", "(ILjava/lang/String;IILandroid/text/SpannableStringBuilder;Ljava/util/ArrayList;)V", "getOriginalId", "()I", "speakerId", "getSpeakerId", "setSpeakerId", "(I)V", "value", "speakerName", "getSpeakerName", "()Landroid/text/SpannableStringBuilder;", "originalName", "getOriginalName", "()Ljava/lang/String;", "startTime", "getStartTime", "endTime", "getEndTime", "getTextDataList", "()Ljava/util/ArrayList;", "mSpannableIndexList", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData$SpannableIndex;", "startReplayPosition", "getStartReplayPosition", "endReplayPosition", "getEndReplayPosition", "getText", TranslatorCommonHelper.EXTRA_KEY_TRANSLATED_TEXT, "getTranslatedText", "setTranslatedText", "(Landroid/text/SpannableStringBuilder;)V", "isNeedToBeDeleted", "", "()Z", "setNeedToBeDeleted", "(Z)V", "spannableIndexList", "getSpannableIndexList", "setSpannableIndexList", "(Ljava/util/ArrayList;)V", "setText", "", "setSpannableText", "spannableStringBuilder", "originalText", "getOriginalText", "resetDisplayText", "setSpeakerName", "updateReplayPosition", "position", "compareTo", "o", "SpannableIndex", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiTextData implements Comparable<AiTextData> {
    private int endReplayPosition;
    private final int endTime;
    private boolean isNeedToBeDeleted;

    @NotNull
    private final ArrayList<SpannableIndex> mSpannableIndexList;
    private final int originalId;

    @NotNull
    private final String originalName;
    private int speakerId;

    @NotNull
    private SpannableStringBuilder speakerName;
    private int startReplayPosition;
    private final int startTime;

    @NotNull
    private SpannableStringBuilder text;

    @NotNull
    private final ArrayList<TextData> textDataList;

    @Nullable
    private SpannableStringBuilder translatedText;

    public AiTextData(int i, @NotNull String nameSpeaker, int i2, int i4, @NotNull SpannableStringBuilder text, @NotNull ArrayList<TextData> textDataList) {
        Intrinsics.checkNotNullParameter(nameSpeaker, "nameSpeaker");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textDataList, "textDataList");
        this.originalId = i;
        this.speakerId = i;
        this.speakerName = new SpannableStringBuilder(nameSpeaker);
        this.originalName = nameSpeaker;
        this.startTime = i2;
        this.endTime = i4;
        this.text = text;
        this.textDataList = textDataList;
        this.endReplayPosition = -1;
        this.startReplayPosition = -1;
        this.mSpannableIndexList = new ArrayList<>();
    }

    public final int getEndReplayPosition() {
        return this.endReplayPosition;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final int getOriginalId() {
        return this.originalId;
    }

    @NotNull
    public final String getOriginalName() {
        return this.originalName;
    }

    @NotNull
    public final String getOriginalText() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TextData> it = this.textDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            spannableStringBuilder.append((CharSequence) next.getText());
        }
        String string = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public final ArrayList<SpannableIndex> getSpannableIndexList() {
        return this.mSpannableIndexList;
    }

    public final int getSpeakerId() {
        return this.speakerId;
    }

    @NotNull
    public final SpannableStringBuilder getSpeakerName() {
        return this.speakerName;
    }

    public final int getStartReplayPosition() {
        return this.startReplayPosition;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final SpannableStringBuilder getText() {
        return this.text;
    }

    @NotNull
    public final ArrayList<TextData> getTextDataList() {
        return this.textDataList;
    }

    @Nullable
    public final SpannableStringBuilder getTranslatedText() {
        return this.translatedText;
    }

    /* JADX INFO: renamed from: isNeedToBeDeleted, reason: from getter */
    public final boolean getIsNeedToBeDeleted() {
        return this.isNeedToBeDeleted;
    }

    public final void resetDisplayText() {
        this.text = new SpannableStringBuilder();
        Iterator<TextData> it = this.textDataList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            this.text.append((CharSequence) next.getText());
        }
        this.speakerId = this.originalId;
        this.speakerName = new SpannableStringBuilder(this.originalName);
    }

    public final void setNeedToBeDeleted(boolean z) {
        this.isNeedToBeDeleted = z;
    }

    public final void setSpannableIndexList(@NotNull ArrayList<SpannableIndex> spannableIndexList) {
        Intrinsics.checkNotNullParameter(spannableIndexList, "spannableIndexList");
        this.mSpannableIndexList.clear();
        Iterator<SpannableIndex> it = spannableIndexList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpannableIndex next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            this.mSpannableIndexList.add(new SpannableIndex(next));
        }
    }

    public final void setSpannableText(@NotNull SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "spannableStringBuilder");
        this.text = spannableStringBuilder;
    }

    public final void setSpeakerId(int i) {
        this.speakerId = i;
    }

    public final void setSpeakerName(@Nullable String speakerName) {
        this.speakerName = new SpannableStringBuilder(speakerName);
    }

    public final void setText(@Nullable String text) {
        this.text = new SpannableStringBuilder(text);
    }

    public final void setTranslatedText(@Nullable SpannableStringBuilder spannableStringBuilder) {
        this.translatedText = spannableStringBuilder;
    }

    public final boolean updateReplayPosition(int position) {
        int endIdx;
        int startIdx = -1;
        if (this.startTime > position || this.endTime < position) {
            endIdx = -1;
        } else {
            int i = 0;
            while (i < this.textDataList.size()) {
                TextData textData = this.textDataList.get(i);
                Intrinsics.checkNotNullExpressionValue(textData, "get(...)");
                TextData textData2 = textData;
                if ((textData2.getStartTime() <= position && position < textData2.getEndTime()) || (textData2.getStartTime() == position && position == textData2.getEndTime())) {
                    startIdx = this.mSpannableIndexList.get(i).getStartIdx();
                    int endIdx2 = this.mSpannableIndexList.get(i).getEndIdx();
                    while (true) {
                        int i2 = i + 1;
                        if (i2 >= this.textDataList.size()) {
                            break;
                        }
                        TextData textData3 = this.textDataList.get(i2);
                        Intrinsics.checkNotNullExpressionValue(textData3, "get(...)");
                        TextData textData4 = textData3;
                        TextData textData5 = this.textDataList.get(i);
                        Intrinsics.checkNotNullExpressionValue(textData5, "get(...)");
                        TextData textData6 = textData5;
                        if ((textData4.getStartTime() > position || position >= textData4.getEndTime()) && !((textData4.getStartTime() == position && position == textData4.getEndTime()) || (textData4.getStartTime() == textData6.getEndTime() && textData4.getEndTime() == textData6.getEndTime()))) {
                            break;
                        }
                        endIdx2 = this.mSpannableIndexList.get(i2).getEndIdx();
                        i = i2;
                    }
                    endIdx = endIdx2;
                } else if (position >= textData2.getStartTime()) {
                    i++;
                } else if (i == 0) {
                    endIdx = 0;
                } else {
                    startIdx = this.endReplayPosition + 1;
                    endIdx = this.mSpannableIndexList.get(i - 1).getEndIdx();
                }
            }
            endIdx = -1;
        }
        if (startIdx > endIdx) {
            Logger.m12711e("AiTextData", AbstractC0622a.m1164j(startIdx, endIdx, "#updateReplayPosition error because newStartIndex (", ") > newEndIndex (", ")"));
            return false;
        }
        if (this.startReplayPosition == startIdx && this.endReplayPosition == endIdx) {
            return false;
        }
        this.startReplayPosition = startIdx;
        this.endReplayPosition = endIdx;
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull AiTextData o) {
        Intrinsics.checkNotNullParameter(o, "o");
        if (Intrinsics.areEqual(this, o)) {
            return 0;
        }
        int i = o.startTime;
        int i2 = this.startTime;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData$SpannableIndex;", "", "startIdx", "", "endIdx", "<init>", "(II)V", "spannableIndex", "(Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData$SpannableIndex;)V", "getStartIdx", "()I", "setStartIdx", "(I)V", "getEndIdx", "setEndIdx", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SpannableIndex {
        private int endIdx;
        private int startIdx;

        public SpannableIndex(int i, int i2) {
            this.startIdx = i;
            this.endIdx = i2;
        }

        public final int getEndIdx() {
            return this.endIdx;
        }

        public final int getStartIdx() {
            return this.startIdx;
        }

        public final void setEndIdx(int i) {
            this.endIdx = i;
        }

        public final void setStartIdx(int i) {
            this.startIdx = i;
        }

        public SpannableIndex(@NotNull SpannableIndex spannableIndex) {
            Intrinsics.checkNotNullParameter(spannableIndex, "spannableIndex");
            this.startIdx = spannableIndex.startIdx;
            this.endIdx = spannableIndex.endIdx;
        }
    }
}

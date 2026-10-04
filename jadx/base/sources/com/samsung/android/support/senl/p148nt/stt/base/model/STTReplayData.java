package com.samsung.android.support.senl.p148nt.stt.base.model;

import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\"\u0010\u0014\u001a\u00020\u00152\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007J'\u0010\u001d\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001bJ$\u0010\u001d\u001a\u00020\u00152\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\tJ\u0006\u0010/\u001a\u00020\u0015J\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\"R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u001e\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b$\u0010\u000bR\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010\u000b¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/STTReplayData;", "", "<init>", "()V", "mSTTData", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "progress", "", "getProgress", "()I", "setProgress", "(I)V", "mReplayStartIndex", "value", "touchedWordIndex", "getTouchedWordIndex", "touchedWordCharStart", "getTouchedWordCharStart", "updateReplayData", "", "replayTexts", "", "", "replayTimeStamp", "", "([Ljava/lang/String;[I)V", "textDataList", "initData", "replayResult", "getReplayResult", "()Ljava/lang/String;", "isUpdateReplayResult", "", "replayStartCharIndex", "getReplayStartCharIndex", "touchWordTimestamp", "", "getTouchWordTimestamp", "()J", "touchedWord", "getTouchedWord", "touchedWordCharEnd", "getTouchedWordCharEnd", "updateTouchedWordIndex", "charIndex", "resetTouchedArea", "release", "needDestroy", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTReplayData {
    private static final int DEFAULT_VALUE = -1;

    @NotNull
    private static final String EMPTY_STR = "";

    @NotNull
    private static final String TAG = "STTReplayData";
    private int mReplayStartIndex;

    @Nullable
    private ArrayList<TextData> mSTTData;
    private int progress;
    private int touchedWordCharStart;
    private int touchedWordIndex;

    private final void initData(String[] replayTexts, int[] replayTimeStamp) {
    }

    public final int getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getReplayResult() {
        StringBuilder sb = new StringBuilder();
        ArrayList<TextData> arrayList = this.mSTTData;
        Intrinsics.checkNotNull(arrayList);
        Iterator<TextData> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            sb.append(next.getText());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int getReplayStartCharIndex() {
        int i = this.mReplayStartIndex;
        int textLength = 0;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList<TextData> arrayList = this.mSTTData;
            Intrinsics.checkNotNull(arrayList);
            textLength += arrayList.get(i2).getTextLength();
        }
        return textLength;
    }

    public final long getTouchWordTimestamp() {
        int i = this.touchedWordIndex;
        if (i < 0) {
            return -1L;
        }
        ArrayList<TextData> arrayList = this.mSTTData;
        Intrinsics.checkNotNull(arrayList);
        if (i >= arrayList.size()) {
            return -1L;
        }
        Intrinsics.checkNotNull(this.mSTTData);
        return r0.get(this.touchedWordIndex).getStartTime();
    }

    @NotNull
    public final String getTouchedWord() {
        int i = this.touchedWordIndex;
        if (i < 0) {
            return "";
        }
        ArrayList<TextData> arrayList = this.mSTTData;
        Intrinsics.checkNotNull(arrayList);
        if (i >= arrayList.size()) {
            return "";
        }
        ArrayList<TextData> arrayList2 = this.mSTTData;
        Intrinsics.checkNotNull(arrayList2);
        return arrayList2.get(this.touchedWordIndex).getText();
    }

    public final int getTouchedWordCharEnd() {
        ArrayList<TextData> arrayList;
        if (this.touchedWordCharStart == -1 || (arrayList = this.mSTTData) == null) {
            return -1;
        }
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.isEmpty()) {
            return -1;
        }
        int i = this.touchedWordCharStart;
        ArrayList<TextData> arrayList2 = this.mSTTData;
        Intrinsics.checkNotNull(arrayList2);
        return arrayList2.get(this.touchedWordIndex).getTextLength() + i;
    }

    public final int getTouchedWordCharStart() {
        return this.touchedWordCharStart;
    }

    public final int getTouchedWordIndex() {
        return this.touchedWordIndex;
    }

    public final boolean isUpdateReplayResult(int progress) {
        ArrayList<TextData> arrayList;
        Logger.m12713i(TAG, "updateReplayResult - mProgress: " + this.progress + " - progress: " + progress);
        if (progress < 0 || progress == this.progress || (arrayList = this.mSTTData) == null) {
            return false;
        }
        this.progress = progress;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        ArrayList<TextData> arrayList2 = this.mSTTData;
        Intrinsics.checkNotNull(arrayList2);
        Iterator<TextData> it = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            TextData textData = next;
            if (textData.getStartTime() > progress) {
                ArrayList<TextData> arrayList3 = this.mSTTData;
                Intrinsics.checkNotNull(arrayList3);
                size = arrayList3.indexOf(textData);
                break;
            }
        }
        if (size == this.mReplayStartIndex) {
            return false;
        }
        this.mReplayStartIndex = size;
        return true;
    }

    public final void release(boolean needDestroy) {
        ArrayList<TextData> arrayList = this.mSTTData;
        Intrinsics.checkNotNull(arrayList);
        arrayList.clear();
        if (needDestroy) {
            this.mSTTData = null;
        }
    }

    public final void resetTouchedArea() {
        this.touchedWordCharStart = -1;
        this.touchedWordIndex = -1;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void updateReplayData(@Nullable String[] replayTexts, @Nullable int[] replayTimeStamp) {
        initData(replayTexts, replayTimeStamp);
    }

    public final boolean updateTouchedWordIndex(int charIndex) {
        Logger.m12710d(TAG, "updateTouchedWordIndex : " + charIndex);
        ArrayList<TextData> arrayList = this.mSTTData;
        Intrinsics.checkNotNull(arrayList);
        Iterator<TextData> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int textLength = 0;
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            TextData textData = next;
            textLength += textData.getTextLength();
            if (textLength > charIndex) {
                ArrayList<TextData> arrayList2 = this.mSTTData;
                Intrinsics.checkNotNull(arrayList2);
                this.touchedWordIndex = arrayList2.indexOf(textData);
                this.touchedWordCharStart = textLength - textData.getTextLength();
                return true;
            }
        }
        return false;
    }

    private final void initData(ArrayList<TextData> textDataList) {
        if (textDataList == null) {
            textDataList = new ArrayList<>();
        }
        this.mSTTData = textDataList;
        this.mReplayStartIndex = 0;
        this.progress = 0;
        resetTouchedArea();
    }

    public final void updateReplayData(@Nullable ArrayList<TextData> textDataList) {
        initData(textDataList);
    }
}

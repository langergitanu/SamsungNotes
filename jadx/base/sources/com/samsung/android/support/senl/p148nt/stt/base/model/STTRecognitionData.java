package com.samsung.android.support.senl.p148nt.stt.base.model;

import android.text.SpannableStringBuilder;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J:\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ<\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\rR\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u001a\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0013\u0010%\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/STTRecognitionData;", "", "<init>", "()V", "mDisplayedSttData", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "mStringRecognition", "Landroid/text/SpannableStringBuilder;", "initData", "", "isReleased", "", "()Z", "updateRecognitionData", "recognizeText", "", "recognizeTimeStamp", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "isFinal", "isNeedGetRawText", "updateData", "speakerIds", "getSpeakerIds", "()[I", "listText", "", "getListText", "()[Ljava/lang/String;", "listTime", "getListTime", "isWordAvailable", "textData", "displayText", "getDisplayText", "()Landroid/text/SpannableStringBuilder;", "release", "needDestroy", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTRecognitionData {

    @NotNull
    private static final String TAG = "STTRecognitionData";

    @Nullable
    private ArrayList<TextData> mDisplayedSttData;

    @Nullable
    private SpannableStringBuilder mStringRecognition;

    public STTRecognitionData() {
        initData();
    }

    private final void initData() {
        this.mDisplayedSttData = new ArrayList<>();
        this.mStringRecognition = new SpannableStringBuilder();
    }

    private final boolean isReleased() {
        boolean z = this.mDisplayedSttData == null || this.mStringRecognition == null;
        if (z) {
            Logger.m12711e(TAG, "Already released");
        }
        return z;
    }

    private final boolean isWordAvailable(TextData textData) {
        return (textData == null || textData.getText() == null) ? false : true;
    }

    private final void updateData(String recognizeText, int[] recognizeTimeStamp, List<? extends SpeechInfo> speechInfoList, boolean isFinal, boolean isNeedGetRawText) {
        if (recognizeText == null || recognizeTimeStamp == null) {
            return;
        }
        String processingString = STTDataHelper.getProcessingString(recognizeText);
        this.mStringRecognition = new SpannableStringBuilder(processingString);
        if (isFinal) {
            if (processingString.length() < 1) {
                this.mDisplayedSttData = STTDataHelper.INSTANCE.getEmptyWord();
                return;
            } else {
                this.mDisplayedSttData = STTDataHelper.getTextData(processingString, recognizeTimeStamp, speechInfoList, true, isNeedGetRawText);
                return;
            }
        }
        if (processingString.length() != 0 && recognizeTimeStamp.length > 0) {
            this.mDisplayedSttData = STTDataHelper.getTextData(processingString, recognizeTimeStamp, speechInfoList, false, isNeedGetRawText);
        }
    }

    @Nullable
    public final synchronized SpannableStringBuilder getDisplayText() {
        try {
            if (isReleased()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = this.mStringRecognition;
            Intrinsics.checkNotNull(spannableStringBuilder);
            spannableStringBuilder.clear();
            ArrayList<TextData> arrayList = this.mDisplayedSttData;
            Intrinsics.checkNotNull(arrayList);
            Iterator<TextData> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            int textLength = 0;
            while (it.hasNext()) {
                TextData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextData textData = next;
                if (isWordAvailable(textData)) {
                    textLength += textData.getTextLength();
                    Logger.m12710d(TAG, "display : <" + textData.getText() + "> startTime : " + textData.getStartTime() + " endTime : " + textData.getEndTime() + " Length : " + textLength);
                    SpannableStringBuilder spannableStringBuilder2 = this.mStringRecognition;
                    Intrinsics.checkNotNull(spannableStringBuilder2);
                    spannableStringBuilder2.append((CharSequence) textData.getText());
                }
            }
            SpannableStringBuilder spannableStringBuilder3 = this.mStringRecognition;
            Logger.m12710d(TAG, "disPlayText = " + ((Object) spannableStringBuilder3) + ":" + String.valueOf(spannableStringBuilder3).length());
            return this.mStringRecognition;
        } catch (Throwable th) {
            throw th;
        }
    }

    @NotNull
    public final String[] getListText() {
        ArrayList<TextData> arrayList = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        String[] strArr = new String[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = "";
        }
        ArrayList<TextData> arrayList2 = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList2);
        Iterator<TextData> it = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            strArr[i] = next.getText();
            i++;
        }
        return strArr;
    }

    @NotNull
    public final int[] getListTime() {
        ArrayList<TextData> arrayList = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size() * 2;
        int[] iArr = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = -1;
        }
        ArrayList<TextData> arrayList2 = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList2);
        Iterator<TextData> it = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            TextData textData = next;
            int i4 = i + 1;
            iArr[i] = textData.getStartTime() / 10;
            i += 2;
            iArr[i4] = textData.getEndTime() / 10;
        }
        return iArr;
    }

    @NotNull
    public final int[] getSpeakerIds() {
        ArrayList<TextData> arrayList = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList);
        int[] iArr = new int[arrayList.size()];
        ArrayList<TextData> arrayList2 = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList2);
        Iterator<TextData> it = arrayList2.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            TextData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            iArr[i] = next.getSpeakerId();
            i++;
        }
        return iArr;
    }

    public final void release(boolean needDestroy) {
        SpannableStringBuilder spannableStringBuilder = this.mStringRecognition;
        Intrinsics.checkNotNull(spannableStringBuilder);
        spannableStringBuilder.clear();
        ArrayList<TextData> arrayList = this.mDisplayedSttData;
        Intrinsics.checkNotNull(arrayList);
        arrayList.clear();
        if (needDestroy) {
            this.mStringRecognition = null;
            this.mDisplayedSttData = null;
        }
    }

    public final void updateRecognitionData(@Nullable String recognizeText, @Nullable int[] recognizeTimeStamp, @Nullable List<? extends SpeechInfo> speechInfoList, boolean isFinal, boolean isNeedGetRawText) {
        updateData(recognizeText, recognizeTimeStamp, speechInfoList, isFinal, isNeedGetRawText);
    }
}

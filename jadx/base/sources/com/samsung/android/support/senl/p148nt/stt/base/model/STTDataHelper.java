package com.samsung.android.support.senl.p148nt.stt.base.model;

import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aSerializableAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.sec.android.app.voicenote.common.util.DataConverter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0014J6\u0010\u0015\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0007J\u001b\u0010\u001a\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0007¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001fJL\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0007J \u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002JA\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007J\u001a\u00100\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b+\u0010,R!\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/STTDataHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mLastSpeakerId", "", "DEFAULT_SPEAKER_ID", "writeSTTDataToShareFile", "", "srcVoicePath", "destVoicePath", "voiceText", "", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[ILjava/util/List;)Z", "writeSTTDataToFile", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "getProcessingString", "str", "words", "([Ljava/lang/String;)Ljava/lang/String;", "getSeparateWords", "(Ljava/lang/String;)[Ljava/lang/String;", "getTextData", "times", "isFinal", "isNeedGetRawText", "getSpeakerId", "startTime", "", "speakerIds", "([Ljava/lang/String;[I[I)Ljava/util/ArrayList;", "getNoTimingInfoWord", "lastTime", "isRemoveWhiteSpaceCountry", "()Z", "emptyWord", "getEmptyWord", "()Ljava/util/ArrayList;", "removeSTTData", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSTTDataHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTDataHelper.kt\ncom/samsung/android/support/senl/nt/stt/base/model/STTDataHelper\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,376:1\n108#2:377\n80#2,22:378\n739#3,9:400\n37#4:409\n36#4,3:410\n*S KotlinDebug\n*F\n+ 1 STTDataHelper.kt\ncom/samsung/android/support/senl/nt/stt/base/model/STTDataHelper\n*L\n186#1:377\n186#1:378,22\n187#1:400,9\n187#1:409\n187#1:410,3\n*E\n"})
public final class STTDataHelper {
    public static final int DEFAULT_SPEAKER_ID = 0;

    @NotNull
    private static final String TAG = "STTDataHelper";

    @NotNull
    public static final STTDataHelper INSTANCE = new STTDataHelper();
    private static int mLastSpeakerId = 1;

    private STTDataHelper() {
    }

    @JvmStatic
    @NotNull
    public static final String getProcessingString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return str;
    }

    private final int getSpeakerId(long startTime, List<? extends SpeechInfo> speechInfoList) {
        if (speechInfoList == null || speechInfoList.isEmpty()) {
            return 1;
        }
        for (SpeechInfo speechInfo : speechInfoList) {
            if (startTime >= speechInfo.getStartTime() && startTime <= speechInfo.getEndTime()) {
                int speaker = speechInfo.getSpeaker() + 1;
                mLastSpeakerId = speaker;
                return speaker;
            }
        }
        return mLastSpeakerId;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<TextData> getTextData(@Nullable String str, @Nullable int[] times, @Nullable List<? extends SpeechInfo> speechInfoList, boolean isFinal, boolean isNeedGetRawText) {
        STTDataHelper sTTDataHelper = INSTANCE;
        String[] separateWords = sTTDataHelper.getSeparateWords(str);
        if (separateWords == null || times == null) {
            return sTTDataHelper.getEmptyWord();
        }
        int length = separateWords.length;
        int length2 = times.length / 2;
        Logger.m12713i(TAG, "getWord - num of word: " + length + " - num of time: " + length2);
        int iMin = (int) Math.min((double) length, (double) length2);
        ArrayList<TextData> arrayList = new ArrayList<>();
        mLastSpeakerId = 1;
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            int i4 = i2 * 2;
            int i5 = times[i4] * 10;
            i = times[i4 + 1] * 10;
            int speakerId = INSTANCE.getSpeakerId(i5, speechInfoList);
            String strM756B = separateWords[i2];
            if (!isNeedGetRawText) {
                strM756B = AbstractC0541b.m756B(strM756B, " ");
            }
            arrayList.add(TextDataCreator.INSTANCE.createTextData(strM756B, speakerId, i5, i));
        }
        if (isFinal && length > length2) {
            StringBuilder sb = new StringBuilder();
            while (iMin < length) {
                sb.append(separateWords[iMin]);
                if (!isNeedGetRawText) {
                    sb.append(' ');
                }
                iMin++;
            }
            STTDataHelper sTTDataHelper2 = INSTANCE;
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            arrayList.add(sTTDataHelper2.getNoTimingInfoWord(string, i));
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean removeSTTData(@Nullable String srcVoicePath, @NotNull String destVoicePath) {
        Intrinsics.checkNotNullParameter(destVoicePath, "destVoicePath");
        if (!new File(srcVoicePath).exists()) {
            Logger.m12711e(TAG, "removeSTTData: srcFile not exist");
            return false;
        }
        File file = new File(destVoicePath);
        if (file.exists()) {
            if (!file.delete()) {
                Logger.m12711e(TAG, "removeSTTData: Fail to delete desFile");
                return false;
            }
            if (!file.createNewFile()) {
                Logger.m12711e(TAG, "removeSTTData: Fail to createNewFile");
                return false;
            }
            Logger.m12710d(TAG, "removeSTTData: desFile clear");
        }
        boolean zRemoveSTTData = new M4aSerializableAtomHelper(srcVoicePath).removeSTTData(destVoicePath);
        if (!zRemoveSTTData) {
            Logger.m12711e(TAG, "removeSTTData: failed ");
            return zRemoveSTTData;
        }
        Logger.m12710d(TAG, "removeSTTData: success " + destVoicePath);
        return zRemoveSTTData;
    }

    @JvmStatic
    public static final boolean writeSTTDataToFile(@Nullable String srcVoicePath, @NotNull String destVoicePath, @Nullable ArrayList<TextData> textDataList) {
        Intrinsics.checkNotNullParameter(destVoicePath, "destVoicePath");
        if (!new File(srcVoicePath).exists()) {
            Logger.m12711e(TAG, "writeSTTDataToFile: srcFile not exist");
            return false;
        }
        File file = new File(destVoicePath);
        if (file.exists()) {
            if (!file.delete()) {
                Logger.m12711e(TAG, "writeSTTDataToFile: Fail to delete desFile");
                return false;
            }
            if (!file.createNewFile()) {
                Logger.m12711e(TAG, "writeSTTDataToFile: Fail to createNewFile");
                return false;
            }
            Logger.m12710d(TAG, "writeSTTDataToFile: desFile clear");
        }
        M4aSerializableAtomHelper m4aSerializableAtomHelper = new M4aSerializableAtomHelper(srcVoicePath);
        if (textDataList == null) {
            Logger.m12711e(TAG, "writeSTTDataToFile: textDataList is null");
            return false;
        }
        int size = textDataList.size();
        String[] strArr = new String[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = textDataList.get(i).getText();
            jArr[i] = textDataList.get(i).getStartTime();
            jArr2[i] = textDataList.get(i).getEndTime();
            iArr[i] = textDataList.get(i).getSpeakerId();
        }
        boolean zMakeFileWithSTTData = m4aSerializableAtomHelper.makeFileWithSTTData(DataConverter.convertToVRData(size, strArr, jArr, jArr2, iArr), destVoicePath);
        if (!zMakeFileWithSTTData) {
            Logger.m12711e(TAG, "writeSTTDataToFile: failed ");
            return zMakeFileWithSTTData;
        }
        Logger.m12710d(TAG, "writeSTTDataToFile: success " + destVoicePath + " textDataSize: " + size);
        return zMakeFileWithSTTData;
    }

    @JvmStatic
    public static final boolean writeSTTDataToShareFile(@Nullable String srcVoicePath, @NotNull String destVoicePath, @Nullable String[] voiceText, @Nullable int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList) throws Throwable {
        Intrinsics.checkNotNullParameter(destVoicePath, "destVoicePath");
        if (!new File(srcVoicePath).exists()) {
            Logger.m12711e(TAG, "writeSTTDataToShareFile: srcFile not exist");
            return false;
        }
        File file = new File(destVoicePath);
        if (file.exists()) {
            if (!file.delete()) {
                Logger.m12711e(TAG, "writeSTTDataToShareFile: Fail to delete desFile");
                return false;
            }
            if (!file.createNewFile()) {
                Logger.m12711e(TAG, "writeSTTDataToShareFile: Fail to createNewFile");
                return false;
            }
            Logger.m12710d(TAG, "writeSTTDataToShareFile: desFile clear");
        }
        ArrayList<TextData> textData = (timingInfo == null || timingInfo.length != 0) ? timingInfo != null ? getTextData(voiceText, timingInfo, null) : null : new ArrayList<>();
        M4aSerializableAtomHelper m4aSerializableAtomHelper = new M4aSerializableAtomHelper(srcVoicePath);
        if (textData == null) {
            boolean zMakeFileForVoiceRecordingApp = m4aSerializableAtomHelper.makeFileForVoiceRecordingApp(destVoicePath);
            if (!zMakeFileForVoiceRecordingApp) {
                Logger.m12711e(TAG, "writeSTTDataToShareFile: failed makeFileForVoiceRecordingApp");
                return zMakeFileForVoiceRecordingApp;
            }
            Logger.m12710d(TAG, "writeSTTDataToShareFile: success makeFileForVoiceRecordingApp" + destVoicePath);
            return zMakeFileForVoiceRecordingApp;
        }
        int size = textData.size();
        String[] strArr = new String[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = textData.get(i).getText();
            jArr[i] = textData.get(i).getStartTime();
            jArr2[i] = textData.get(i).getEndTime();
            iArr[i] = INSTANCE.getSpeakerId(jArr[i], speechInfoList);
        }
        boolean zMakeFileWithSTTData = m4aSerializableAtomHelper.makeFileWithSTTData(DataConverter.convertToVRData(size, strArr, jArr, jArr2, iArr), destVoicePath);
        if (!zMakeFileWithSTTData) {
            Logger.m12711e(TAG, "writeSTTDataToShareFile: failed ");
            return zMakeFileWithSTTData;
        }
        Logger.m12710d(TAG, "writeSTTDataToShareFile: success " + destVoicePath + " textDataSize: " + size);
        return zMakeFileWithSTTData;
    }

    @NotNull
    public final ArrayList<TextData> getEmptyWord() {
        ArrayList<TextData> arrayList = new ArrayList<>(1);
        arrayList.add(TextDataCreator.INSTANCE.createTextData("... ", 0, 0, 500));
        return arrayList;
    }

    @NotNull
    public final TextData getNoTimingInfoWord(@NotNull String words, int lastTime) {
        Intrinsics.checkNotNullParameter(words, "words");
        TextData textDataCreateTextData = TextDataCreator.INSTANCE.createTextData(words, 0, lastTime, lastTime);
        if (isRemoveWhiteSpaceCountry()) {
            textDataCreateTextData.trimText();
        }
        return textDataCreateTextData;
    }

    @Nullable
    public final String[] getSeparateWords(@Nullable String str) {
        List listEmptyList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intrinsics.checkNotNull(str);
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        List listM13999t = AbstractC12991c.m13999t(0, " ", new Regex("\\s+").replace(str.subSequence(i, length + 1).toString(), " "));
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        return (String[]) listEmptyList.toArray(new String[0]);
    }

    public final boolean isRemoveWhiteSpaceCountry() {
        String string = Locale.US.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.m14162r(string, "zh") || StringsKt.m14162r(string, LangPackConfigConstants.LANGUAGE_CODE_JA);
    }

    @JvmStatic
    @NotNull
    public static final String getProcessingString(@NotNull String[] words) {
        Intrinsics.checkNotNullParameter(words, "words");
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<TextData> getTextData(@Nullable String[] words, @Nullable int[] times, @Nullable int[] speakerIds) {
        if (words != null && words.length != 0) {
            int length = words.length;
            Logger.m12713i(TAG, "getWord - num of word: " + length);
            ArrayList<TextData> arrayList = new ArrayList<>();
            if (times != null) {
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    int i4 = times[i2] * 10;
                    int i5 = times[i2 + 1] * 10;
                    int i6 = speakerIds != null ? speakerIds[i] : 0;
                    String str = words[i];
                    if (str != null) {
                        arrayList.add(TextDataCreator.INSTANCE.createTextData(str, i6, i4, i5));
                    }
                }
            }
            return arrayList;
        }
        Logger.m12713i(TAG, "getWord - word is null or size of words is empty, return [...]");
        return INSTANCE.getEmptyWord();
    }
}

package com.samsung.android.sdk.pen.recogengine.wrapper;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizer;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerManager;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000bJ\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000b2\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020,J\u0018\u0010-\u001a\u00020,2\u0006\u0010 \u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%J\u0016\u00102\u001a\u00020\u00072\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\"\u00104\u001a\u00020\u00072\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u00020\u0007H\u0007J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u00109\u001a\u0004\u0018\u00010\u001dJ\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u000bJ\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u000b2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010=\u001a\u00020\u001dJ\u0010\u0010?\u001a\u0004\u0018\u00010\u001d2\u0006\u0010@\u001a\u00020;J\u001a\u0010A\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020FH\u0002J\u001a\u0010G\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u00105\u001a\u00020\u0007H\u0002J\u001e\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\u001f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020;0\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010.\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b/\u0010\"R\u0013\u00100\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b1\u0010\"R\u001d\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u000b8F¢\u0006\u0006\u001a\u0004\b7\u0010\u000e¨\u0006L"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizer;", "", "<init>", "()V", "mRecognizer", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer;", "value", "", "isReadyToRecognize", "()Z", "mStrokeObjects", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "getMStrokeObjects", "()Ljava/util/List;", "setMStrokeObjects", "(Ljava/util/List;)V", "mTextLineResults", "", "Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult;", "nonTextResult", "getNonTextResult", "()Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult;", "undefinedResult", "getUndefinedResult", "mRefiner", "Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerRefiner;", "mStrokeIndexMap", "", "Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeClass;", "[Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeClass;", "", "language", "getLanguage", "()Ljava/lang/String;", "initialize", "context", "Landroid/content/Context;", "xdpi", "", "ydpi", "getSupportedLanguages", "allSupportedLanguages", "close", "", "setLanguage", "textEngineVersion", "getTextEngineVersion", "recognizerDBVersion", "getRecognizerDBVersion", "clusterTemporalStrokes", "strokeObjects", "recognize", "refineResult", "textResults", "getTextResults", "getSpenObjectStrokesOf", "strokClass", "strokeIndices", "", "getStrokeIndicesOf", "strokeClass", "getStrokeObjectsOf", "getStrokeClass", "strokeIndex", "setResult", "resultContainer", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "isWordSeparator", "c", "", "getInitialResultFrom", "createStrokeRecognizerResult", "textString", "resultIndices", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class StrokeRecognizer {

    @NotNull
    private static final String SPEN_RECOGNIZER_PLUGIN = "com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin";

    @NotNull
    private static final String TAG = "StrokeRecognizer";
    private static final boolean WORD_BASED_VALIDATION = true;
    private boolean isReadyToRecognize;

    @Nullable
    private SpenRecognizer mRecognizer;

    @Nullable
    private StrokeRecognizerRefiner mRefiner;

    @Nullable
    private List<SpenObjectStroke> mStrokeObjects;

    @NotNull
    private final List<List<StrokeRecognizerResult>> mTextLineResults = new ArrayList();

    @NotNull
    private String language = DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;

    @NotNull
    private StrokeRecognizerResult nonTextResult = new StrokeRecognizerResult();

    @NotNull
    private final StrokeRecognizerResult undefinedResult = new StrokeRecognizerResult();

    @Nullable
    private StrokeClass[] mStrokeIndexMap = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StrokeClass.values().length];
            try {
                iArr[StrokeClass.CLASS_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrokeClass.CLASS_NONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrokeClass.CLASS_UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final StrokeRecognizerResult createStrokeRecognizerResult(String textString, List<Integer> resultIndices) {
        return new StrokeRecognizerResult(textString, resultIndices, getSpenObjectStrokesOf(resultIndices));
    }

    private final boolean getInitialResultFrom(SpenRecognizerResultContainerInterface resultContainer, boolean refineResult) {
        SpenRecognizerResultInterface.ResultType resultType;
        int i;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        SpenRecognizerResultContainerInterface spenRecognizerResultContainerInterface = resultContainer;
        int i4 = 0;
        if (spenRecognizerResultContainerInterface == null) {
            Log.e(TAG, "setResult: recognized result is null!");
            return false;
        }
        List<SpenObjectStroke> list = this.mStrokeObjects;
        int size = list != null ? list.size() : 0;
        Arrays.fill(this.mStrokeIndexMap, StrokeClass.CLASS_NONTEXT);
        int resultCount = spenRecognizerResultContainerInterface.getResultCount();
        if (resultCount > 0) {
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < resultCount; i5++) {
                arrayList3.add(spenRecognizerResultContainerInterface.getResult(i5));
            }
            int i6 = 0;
            while (i6 < resultCount) {
                SpenRecognizerResultInterface result = spenRecognizerResultContainerInterface.getResult(i6);
                if (result == null || (resultType = result.getResultType()) == null) {
                    resultType = SpenRecognizerResultInterface.ResultType.UNKNOWN;
                }
                if (resultType != SpenRecognizerResultInterface.ResultType.TEXT) {
                    Log.e(TAG, "setResult: Unknown result");
                } else {
                    SpenRecognizerResultTextInterface spenRecognizerResultTextInterface = (SpenRecognizerResultTextInterface) arrayList3.get(i6);
                    if (spenRecognizerResultTextInterface != null) {
                        String resultString = spenRecognizerResultTextInterface.getResultString(i4);
                        if (resultString == null) {
                            resultString = "";
                        }
                        ArrayList arrayList4 = new ArrayList();
                        if (refineResult) {
                            ArrayList arrayList5 = new ArrayList();
                            int length = resultString.length();
                            int i7 = i4;
                            int i8 = i7;
                            while (i7 < length) {
                                if (isWordSeparator(resultString.charAt(i7))) {
                                    i2 = resultCount;
                                    arrayList2 = arrayList3;
                                    AbstractC11014a.m12329n(i7, ")", TAG, AbstractC0541b.m780v("resultText(", i8, resultString, ").subString(", SQLKeyword.COMMA));
                                    if (i8 >= i7) {
                                        Log.w(TAG, "No word letter to word separator");
                                    } else {
                                        String strSubstring = resultString.substring(i8, i7);
                                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                                        arrayList4.add(createStrokeRecognizerResult(strSubstring, arrayList5));
                                        Log.i(TAG, "New word result (" + strSubstring + ") added");
                                    }
                                    arrayList5 = new ArrayList();
                                    i8 = i7;
                                } else {
                                    i2 = resultCount;
                                    arrayList2 = arrayList3;
                                    List<Integer> strokeIndex = spenRecognizerResultTextInterface.getStrokeIndex(i7);
                                    if (strokeIndex != null) {
                                        arrayList5.addAll(strokeIndex);
                                        StrokeClass[] strokeClassArr = this.mStrokeIndexMap;
                                        if (strokeClassArr != null) {
                                            Iterator<Integer> it = strokeIndex.iterator();
                                            while (it.hasNext()) {
                                                int iIntValue = it.next().intValue();
                                                if (iIntValue >= 0 && iIntValue < size) {
                                                    strokeClassArr[iIntValue] = StrokeClass.CLASS_TEXT;
                                                }
                                            }
                                        }
                                    }
                                }
                                i7++;
                                resultCount = i2;
                                arrayList3 = arrayList2;
                            }
                            i = resultCount;
                            arrayList = arrayList3;
                            if (i8 >= 0 && arrayList5.size() > 0) {
                                String strSubstring2 = resultString.substring(i8, resultString.length());
                                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                arrayList4.add(createStrokeRecognizerResult(strSubstring2, arrayList5));
                            }
                        } else {
                            i = resultCount;
                            arrayList = arrayList3;
                            ArrayList arrayList6 = new ArrayList();
                            int length2 = resultString.length();
                            for (int i9 = 0; i9 < length2; i9++) {
                                List<Integer> strokeIndex2 = spenRecognizerResultTextInterface.getStrokeIndex(i9);
                                if (strokeIndex2 != null) {
                                    arrayList6.addAll(strokeIndex2);
                                    StrokeClass[] strokeClassArr2 = this.mStrokeIndexMap;
                                    if (strokeClassArr2 != null) {
                                        Iterator<Integer> it2 = strokeIndex2.iterator();
                                        while (it2.hasNext()) {
                                            int iIntValue2 = it2.next().intValue();
                                            if (iIntValue2 >= 0 && iIntValue2 < size) {
                                                strokeClassArr2[iIntValue2] = StrokeClass.CLASS_TEXT;
                                            }
                                        }
                                    }
                                }
                            }
                            arrayList4.add(createStrokeRecognizerResult(resultString, arrayList6));
                        }
                        if (arrayList4.size() > 0) {
                            this.mTextLineResults.add(arrayList4);
                        } else {
                            Log.e(TAG, "Something wrong, there is no text result");
                        }
                    }
                    i6++;
                    spenRecognizerResultContainerInterface = resultContainer;
                    resultCount = i;
                    arrayList3 = arrayList;
                    i4 = 0;
                }
                i = resultCount;
                arrayList = arrayList3;
                i6++;
                spenRecognizerResultContainerInterface = resultContainer;
                resultCount = i;
                arrayList3 = arrayList;
                i4 = 0;
            }
        } else {
            Log.w(TAG, "setResult: recognized result count is 0!");
        }
        this.nonTextResult = createStrokeRecognizerResult("", getStrokeIndicesOf(StrokeClass.CLASS_NONTEXT));
        return true;
    }

    private final boolean isWordSeparator(char c) {
        return c == ' ' || c == ',' || c == '.';
    }

    public static /* synthetic */ boolean recognize$default(StrokeRecognizer strokeRecognizer, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return strokeRecognizer.recognize(list, z);
    }

    private final boolean setResult(SpenRecognizerResultContainerInterface resultContainer, boolean refineResult) {
        clusterTemporalStrokes(this.mStrokeObjects);
        if (!getInitialResultFrom(resultContainer, refineResult)) {
            return false;
        }
        if (!refineResult) {
            return true;
        }
        StrokeRecognizerRefiner strokeRecognizerRefiner = this.mRefiner;
        if (strokeRecognizerRefiner != null) {
            return strokeRecognizerRefiner.refineResults(this.mTextLineResults, this.nonTextResult, this.undefinedResult, this.mStrokeIndexMap);
        }
        return false;
    }

    public final void close() {
        SpenRecognizer spenRecognizer = this.mRecognizer;
        if (spenRecognizer != null) {
            spenRecognizer.close();
            this.mRecognizer = null;
        }
        this.isReadyToRecognize = false;
    }

    public final boolean clusterTemporalStrokes(@Nullable List<SpenObjectStroke> strokeObjects) {
        StrokeTemporalClustering strokeTemporalClustering = new StrokeTemporalClustering();
        if (!strokeTemporalClustering.cluster(strokeObjects, -1L)) {
            return false;
        }
        strokeTemporalClustering.printLog();
        return true;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final List<SpenObjectStroke> getMStrokeObjects() {
        return this.mStrokeObjects;
    }

    @NotNull
    public final StrokeRecognizerResult getNonTextResult() {
        return this.nonTextResult;
    }

    @Nullable
    public final String getRecognizerDBVersion() {
        SpenRecognizer spenRecognizer = this.mRecognizer;
        if (spenRecognizer != null) {
            return spenRecognizer.getRecognizerDBVersion();
        }
        return null;
    }

    @NotNull
    public final List<SpenObjectStroke> getSpenObjectStrokesOf(@Nullable StrokeClass strokClass) {
        List<SpenObjectStroke> list;
        ArrayList arrayList = new ArrayList();
        StrokeClass[] strokeClassArr = this.mStrokeIndexMap;
        if (strokeClassArr != null && (list = this.mStrokeObjects) != null) {
            int length = strokeClassArr.length;
            for (int i = 0; i < length; i++) {
                if (strokeClassArr[i] == strokClass) {
                    arrayList.add(list.get(i));
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final StrokeClass getStrokeClass(int strokeIndex) {
        StrokeClass[] strokeClassArr = this.mStrokeIndexMap;
        return (strokeClassArr == null || strokeIndex < 0 || strokeIndex >= strokeClassArr.length) ? StrokeClass.CLASS_UNDEFINED : strokeClassArr[strokeIndex];
    }

    @NotNull
    public final List<Integer> getStrokeIndicesOf(@NotNull StrokeClass strokeClass) {
        Intrinsics.checkNotNullParameter(strokeClass, "strokeClass");
        ArrayList arrayList = new ArrayList();
        StrokeClass[] strokeClassArr = this.mStrokeIndexMap;
        if (strokeClassArr != null) {
            int length = strokeClassArr.length;
            for (int i = 0; i < length; i++) {
                if (strokeClassArr[i] == strokeClass) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<SpenObjectStroke> getStrokeObjectsOf(@NotNull StrokeClass strokeClass) {
        Intrinsics.checkNotNullParameter(strokeClass, "strokeClass");
        ArrayList arrayList = new ArrayList();
        int i = WhenMappings.$EnumSwitchMapping$0[strokeClass.ordinal()];
        if (i == 1) {
            Iterator<List<StrokeRecognizerResult>> it = this.mTextLineResults.iterator();
            while (it.hasNext()) {
                Iterator<StrokeRecognizerResult> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    arrayList.addAll(it2.next().getStrokeObjects());
                }
            }
            return arrayList;
        }
        if (i == 2) {
            arrayList.addAll(this.nonTextResult.getStrokeObjects());
            return arrayList;
        }
        if (i == 3) {
            arrayList.addAll(this.undefinedResult.getStrokeObjects());
            return arrayList;
        }
        Log.e(TAG, "Undefined class: " + strokeClass);
        return arrayList;
    }

    @NotNull
    public final List<String> getSupportedLanguages() {
        return getSupportedLanguages(true);
    }

    @Nullable
    public final String getTextEngineVersion() {
        SpenRecognizer spenRecognizer = this.mRecognizer;
        if (spenRecognizer != null) {
            return spenRecognizer.getTextEngineVersion();
        }
        return null;
    }

    @NotNull
    public final List<List<StrokeRecognizerResult>> getTextResults() {
        return this.mTextLineResults;
    }

    @NotNull
    public final StrokeRecognizerResult getUndefinedResult() {
        return this.undefinedResult;
    }

    public final boolean initialize(@Nullable Context context, float xdpi, float ydpi) {
        try {
            SpenRecognizer spenRecognizerCreateRecognizer$default = SpenRecognizerManager.createRecognizer$default(new SpenRecognizerManager(context), "com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin", (String) null, 2, (Object) null);
            this.mRecognizer = spenRecognizerCreateRecognizer$default;
            if (spenRecognizerCreateRecognizer$default != null) {
                spenRecognizerCreateRecognizer$default.createResourceProvider(SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
                spenRecognizerCreateRecognizer$default.setDisplayMetrics(xdpi, ydpi);
                spenRecognizerCreateRecognizer$default.setRecognizerType(SpenRecognizer.RecognizerType.TEXT_EXTRACTOR);
                this.isReadyToRecognize = true;
            }
            return true;
        } catch (Exception e) {
            AbstractC2322a.m1636z("mRecognizer cannot be created : ", e.getLocalizedMessage(), TAG);
            return false;
        }
    }

    /* JADX INFO: renamed from: isReadyToRecognize, reason: from getter */
    public final boolean getIsReadyToRecognize() {
        return this.isReadyToRecognize;
    }

    @JvmOverloads
    public final boolean recognize(@Nullable List<SpenObjectStroke> list) {
        return recognize$default(this, list, false, 2, null);
    }

    public final void setLanguage(@NotNull String language, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(language, "language");
        SpenRecognizer spenRecognizer = this.mRecognizer;
        if (spenRecognizer != null) {
            this.language = language;
            spenRecognizer.setLanguage(language);
            StrokeRecognizerRefiner strokeRecognizerRefinerCreateRefiner = StrokeRecognizerRefiner.INSTANCE.createRefiner(this.language);
            this.mRefiner = strokeRecognizerRefinerCreateRefiner;
            if (strokeRecognizerRefinerCreateRefiner != null) {
                strokeRecognizerRefinerCreateRefiner.initialize(context);
            }
        }
    }

    public final void setMStrokeObjects(@Nullable List<SpenObjectStroke> list) {
        this.mStrokeObjects = list;
    }

    @NotNull
    public final List<String> getSupportedLanguages(boolean allSupportedLanguages) {
        SpenResourceProvider resourceProvider;
        String[] supportedLanguages;
        if (!this.isReadyToRecognize) {
            return new ArrayList();
        }
        SpenRecognizer spenRecognizer = this.mRecognizer;
        if (spenRecognizer == null || (resourceProvider = spenRecognizer.getResourceProvider()) == null || (supportedLanguages = resourceProvider.getSupportedLanguages()) == null) {
            return new ArrayList();
        }
        if (allSupportedLanguages) {
            return CollectionsKt.listOf(Arrays.copyOf(supportedLanguages, supportedLanguages.length));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : supportedLanguages) {
            if (!StringsKt.m14162r(str, "_")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @JvmOverloads
    public final boolean recognize(@Nullable List<SpenObjectStroke> strokeObjects, boolean refineResult) {
        SpenRecognizer spenRecognizer;
        if (!this.isReadyToRecognize) {
            Log.e(TAG, "recognize: not ready to recognize");
            return false;
        }
        if (strokeObjects == null || (spenRecognizer = this.mRecognizer) == null) {
            return false;
        }
        spenRecognizer.clearStrokes();
        spenRecognizer.clearHwrDataList();
        this.mTextLineResults.clear();
        this.nonTextResult.init();
        this.undefinedResult.init();
        this.mStrokeObjects = strokeObjects;
        int size = strokeObjects.size();
        StrokeClass[] strokeClassArr = new StrokeClass[size];
        for (int i = 0; i < size; i++) {
            strokeClassArr[i] = StrokeClass.CLASS_UNDEFINED;
        }
        this.mStrokeIndexMap = strokeClassArr;
        Log.i(TAG, "recognize: input stroke count = " + size);
        Iterator<SpenObjectStroke> it = strokeObjects.iterator();
        while (it.hasNext()) {
            spenRecognizer.addStroke(it.next());
        }
        return setResult(spenRecognizer.recognize(), refineResult);
    }

    @NotNull
    public final List<SpenObjectStroke> getSpenObjectStrokesOf(@Nullable List<Integer> strokeIndices) {
        if (strokeIndices == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        List<SpenObjectStroke> list = this.mStrokeObjects;
        if (list != null) {
            Iterator<Integer> it = strokeIndices.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue >= 0) {
                    arrayList.add(list.get(iIntValue));
                }
            }
        }
        return arrayList;
    }
}

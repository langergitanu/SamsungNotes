package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizer;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerManager;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultTextInterface;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.RecogEngineConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.ResultSpenRecognizer;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class TextRecognitionManager {
    private static final String TAG = CollectLogger.createTag("TextRecognitionManager");
    private Context mContext;
    private boolean mIsPossible;
    private SpenRecognizer mRecognizer;
    private SpenRecognizerManager mRecognizerManager;
    private String mCurrentLanguage = null;
    private boolean mIsLanguageInit = false;
    private TextRecognitionPlugInContract mTextRecognitionPlugIn = null;
    private boolean mDefaultLocalLanguageDbExist = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DivideType {
        WORD,
        LINE
    }

    public TextRecognitionManager(Context context) {
        this.mIsPossible = true;
        this.mRecognizerManager = null;
        this.mRecognizer = null;
        String str = TAG;
        DataLogger.m12302d(str, "TextRecognitionManager");
        if (!RecognitionUtil.isSDKRecognitionSupported(context)) {
            this.mIsPossible = false;
            return;
        }
        this.mContext = context;
        try {
            SpenRecognizerManager spenRecognizerManagerMakeRecognizerManager = RecogEngineConstructor.makeRecognizerManager(context);
            this.mRecognizerManager = spenRecognizerManagerMakeRecognizerManager;
            if (spenRecognizerManagerMakeRecognizerManager.getInfoList() == null) {
                DataLogger.m12303e(str, "TextRecognitionManager, list is null.");
            }
            this.mRecognizer = this.mRecognizerManager.createRecognizer(RecognitionUtil.SPEN_RECOGNIZER_PLUGIN_PACKAGE);
            initSpenRecognizer();
            initTextRecognitionLanguage(context);
            if (!RecognitionUtil.isHWREnabledChanged() && !this.mDefaultLocalLanguageDbExist) {
                this.mIsPossible = false;
            }
            DataLogger.m12302d(str, "TextRecognitionManager, mCurrentLanguage: " + this.mCurrentLanguage);
        } catch (Exception e) {
            DataLogger.m12304e(TAG, "TextRecognitionManager", e);
            this.mIsPossible = false;
            close();
        }
    }

    private RectF[] calcRect(SpenRecognizerResultTextInterface spenRecognizerResultTextInterface, ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, SpenHyperTextSpan spenHyperTextSpan, String str, int i) {
        int length = str.length();
        RectF rectF = null;
        RectF rectF2 = null;
        RectF unionRectF = null;
        for (int i2 = 0; i2 < length; i2++) {
            List<Integer> strokeIndex = spenRecognizerResultTextInterface.getStrokeIndex(i + i2);
            int size = strokeIndex.size();
            RectF unionRectF2 = null;
            for (int i4 = 0; i4 < size; i4++) {
                int iIntValue = strokeIndex.get(i4).intValue();
                if (iIntValue >= 0 && spenHyperTextSpan != null && i2 >= spenHyperTextSpan.getStart() && i2 < spenHyperTextSpan.getEnd()) {
                    unionRectF2 = getUnionRectF(arrayList, unionRectF2, iIntValue);
                    arrayList3.add(arrayList2.get(iIntValue));
                    unionRectF = getUnionRectF(arrayList, unionRectF, iIntValue);
                }
            }
            if (unionRectF2 != null) {
                if (rectF == null || rectF.left <= unionRectF2.left) {
                    rectF = unionRectF2;
                }
                if (rectF2 == null || rectF2.left >= unionRectF2.left) {
                    rectF2 = unionRectF2;
                }
            }
        }
        return new RectF[]{rectF, rectF2, unionRectF};
    }

    public static String getLang() {
        return SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_LANGUAGE, null);
    }

    private int getLinkType(SpenHyperTextSpan spenHyperTextSpan) {
        if (spenHyperTextSpan == null) {
            return 0;
        }
        int hyperTextType = spenHyperTextSpan.getHyperTextType();
        if (hyperTextType == 1) {
            return 2;
        }
        if (hyperTextType != 3) {
            return hyperTextType != 7 ? 0 : 3;
        }
        return 1;
    }

    private ResultSpenRecognizer getResultFromSpenRecognizerResult(SpenRecognizerResultContainerInterface spenRecognizerResultContainerInterface, ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, DivideType divideType) {
        ArrayList<SpenObjectStroke> arrayList3;
        ArrayList<Integer> arrayList4;
        String[] strArr;
        String[] strArrSplit;
        ResultSpenRecognizer resultSpenRecognizer = new ResultSpenRecognizer();
        ArrayList arrayList5 = new ArrayList();
        int resultCount = spenRecognizerResultContainerInterface.getResultCount();
        for (int i = 0; i < resultCount; i++) {
            arrayList5.add(spenRecognizerResultContainerInterface.getResult(i));
        }
        DataLogger.m12302d(TAG, "requestRecognition done divideType: " + divideType + " / strokeList size : " + arrayList.size() + " / resultCount : " + resultCount);
        int i2 = 0;
        while (i2 < resultCount) {
            SpenRecognizerResultTextInterface spenRecognizerResultTextInterface = (SpenRecognizerResultTextInterface) arrayList5.get(i2);
            if (spenRecognizerResultTextInterface.getResultType() == SpenRecognizerResultInterface.ResultType.TEXT) {
                if (divideType == DivideType.WORD) {
                    String[] strArrSplit2 = spenRecognizerResultTextInterface.getResultString(0).replaceAll("\n", " ").split(" ");
                    arrayList3 = arrayList;
                    strArrSplit = spenRecognizerResultTextInterface.getResultString(0).split("\n");
                    strArr = strArrSplit2;
                } else {
                    if (divideType != DivideType.LINE) {
                        return null;
                    }
                    strArr = new String[]{spenRecognizerResultTextInterface.getResultString(0)};
                    arrayList3 = arrayList;
                    strArrSplit = null;
                }
                arrayList4 = arrayList2;
                getResultTextInformation(arrayList3, arrayList4, spenRecognizerResultTextInterface, strArr, resultSpenRecognizer);
                getResultHyperLinkTextInformation(arrayList3, arrayList4, spenRecognizerResultTextInterface, strArrSplit, resultSpenRecognizer);
            } else {
                arrayList3 = arrayList;
                arrayList4 = arrayList2;
            }
            i2++;
            arrayList = arrayList3;
            arrayList2 = arrayList4;
        }
        if (resultSpenRecognizer.resultString.size() > 0) {
            return resultSpenRecognizer;
        }
        return null;
    }

    private void getResultHyperLinkTextInformation(ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, SpenRecognizerResultTextInterface spenRecognizerResultTextInterface, String[] strArr, ResultSpenRecognizer resultSpenRecognizer) {
        TextRecognitionManager textRecognitionManager = this;
        if (strArr == null || textRecognitionManager.mTextRecognitionPlugIn == null) {
            return;
        }
        int length = strArr.length;
        int iM2212c = 0;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            ArrayList<SpenHyperTextSpan> hyperText = textRecognitionManager.mTextRecognitionPlugIn.parseHyperText(textRecognitionManager.mContext, str);
            if (hyperText != null && !hyperText.isEmpty()) {
                for (SpenHyperTextSpan spenHyperTextSpan : hyperText) {
                    if (textRecognitionManager.isSupportedHyperTextType(spenHyperTextSpan.getHyperTextType())) {
                        resultSpenRecognizer.resultLinkString.add(str.substring(spenHyperTextSpan.getStart(), spenHyperTextSpan.getEnd()));
                        String id = arrayList.get(arrayList.size() - 1).getId();
                        int linkType = textRecognitionManager.getLinkType(spenHyperTextSpan);
                        RectF[] rectFArrCalcRect = textRecognitionManager.calcRect(spenRecognizerResultTextInterface, arrayList, arrayList2, arrayList3, spenHyperTextSpan, str, iM2212c);
                        RectF rectF = rectFArrCalcRect[0];
                        RectF rectF2 = rectFArrCalcRect[1];
                        RectF rectF3 = rectFArrCalcRect[2];
                        resultSpenRecognizer.resultOriginalLinkString.add(str);
                        resultSpenRecognizer.repObjectUuid.add(id);
                        resultSpenRecognizer.linkStrokeIndex.add(arrayList3);
                        resultSpenRecognizer.linkType.add(Integer.valueOf(linkType));
                        resultSpenRecognizer.resultStrokeRectF.add(rectF3);
                        resultSpenRecognizer.lastCharRect.add(rectF);
                        resultSpenRecognizer.leftCharRect.add(rectF2);
                        resultSpenRecognizer.resultLinkStringColor.add(Integer.valueOf(((SpenObjectStroke) AbstractC1974b.m1313f(1, arrayList)).getColor()));
                    }
                    textRecognitionManager = this;
                }
            }
            iM2212c = AbstractC2821a.m2212c(1, iM2212c, str);
            i++;
            textRecognitionManager = this;
        }
    }

    private void getResultTextInformation(ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, SpenRecognizerResultTextInterface spenRecognizerResultTextInterface, String[] strArr, ResultSpenRecognizer resultSpenRecognizer) {
        int i;
        int color;
        String[] strArr2 = strArr;
        int length = strArr2.length;
        int i2 = 0;
        int i4 = 0;
        int length2 = 0;
        while (i4 < length) {
            if (i4 == 0) {
                resultSpenRecognizer.resultOriginalString.add(spenRecognizerResultTextInterface.getResultString(i2));
            } else {
                resultSpenRecognizer.resultOriginalString.add("");
            }
            String str = strArr2[i4];
            resultSpenRecognizer.resultString.add(str);
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            int length3 = str.length();
            RectF unionRectF = null;
            int i5 = i2;
            while (i5 < length3) {
                List<Integer> strokeIndex = spenRecognizerResultTextInterface.getStrokeIndex(length2 + i5);
                if (strokeIndex != null) {
                    int size = strokeIndex.size();
                    for (int i6 = i2; i6 < size; i6++) {
                        int iIntValue = strokeIndex.get(i6).intValue();
                        if (iIntValue >= 0) {
                            unionRectF = getUnionRectF(arrayList, unionRectF, iIntValue);
                            arrayList3.add(arrayList2.get(iIntValue));
                        }
                    }
                }
                i5++;
                i2 = 0;
            }
            resultSpenRecognizer.recognizedStrokeIndex.add(arrayList3);
            resultSpenRecognizer.resultRectF.add(unionRectF);
            List<Integer> strokeIndex2 = spenRecognizerResultTextInterface.getStrokeIndex(length2);
            if (strokeIndex2.isEmpty()) {
                i = 0;
            } else {
                i = 0;
                int iIntValue2 = strokeIndex2.get(0).intValue();
                if (iIntValue2 >= 0) {
                    color = arrayList.get(iIntValue2).getColor();
                }
                resultSpenRecognizer.resultStringColor.add(Integer.valueOf(color));
                length2 += str.length() + 1;
                i4++;
                strArr2 = strArr;
                i2 = i;
            }
            color = i;
            resultSpenRecognizer.resultStringColor.add(Integer.valueOf(color));
            length2 += str.length() + 1;
            i4++;
            strArr2 = strArr;
            i2 = i;
        }
    }

    @Nullable
    private SpenRecognizerResultContainerInterface getSpenRecognizerResult(String str, ArrayList<SpenObjectStroke> arrayList, int i, @Nullable String str2, WorkerInfoContract workerInfoContract) {
        SpenRecognizerResultContainerInterface spenRecognizerResultContainerInterfaceRecognize;
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null || ExceptionFileManager.isExistInExceptList(applicationContext, str)) {
            return null;
        }
        ExceptionFileManager.addFileInWorkingList(applicationContext, str);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        startRecognitionMonitor(countDownLatch, str2, workerInfoContract);
        String str3 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "requestRecognition, try recognize, recognizeSleepTime/message: ", "/");
        sbM778t.append(Logger.getEncode(str2));
        DataLogger.m12302d(str3, sbM778t.toString());
        try {
            this.mRecognizer.clearStrokes();
            for (SpenObjectStroke spenObjectStroke : arrayList) {
                SpenObjectStroke spenObjectStrokeMakeObjectStroke = SpenObjectConstructor.makeObjectStroke();
                spenObjectStrokeMakeObjectStroke.copy(spenObjectStroke);
                this.mRecognizer.addStroke(spenObjectStrokeMakeObjectStroke);
            }
            spenRecognizerResultContainerInterfaceRecognize = this.mRecognizer.recognize(i);
        } catch (Exception e) {
            e = e;
            spenRecognizerResultContainerInterfaceRecognize = null;
        }
        try {
            ExceptionFileManager.removeFileInWorkingList(applicationContext, str);
        } catch (Exception e2) {
            e = e2;
            DataLogger.m12304e(TAG, "requestRecognition", e);
        }
        countDownLatch.countDown();
        String str4 = TAG;
        DataLogger.m12302d(str4, "requestRecognition, try recognize done");
        if (spenRecognizerResultContainerInterfaceRecognize != null) {
            DataLogger.m12302d(str4, "requestRecognition, result " + spenRecognizerResultContainerInterfaceRecognize.getResultCount());
            if (spenRecognizerResultContainerInterfaceRecognize.getResultCount() <= 0) {
                return null;
            }
        }
        return spenRecognizerResultContainerInterfaceRecognize;
    }

    @NonNull
    private RectF getUnionRectF(ArrayList<SpenObjectStroke> arrayList, RectF rectF, int i) {
        if (rectF == null) {
            return new RectF(arrayList.get(i).getDrawnRect());
        }
        rectF.union(arrayList.get(i).getDrawnRect());
        return rectF;
    }

    private void initLanguage(SpenRecognizer.RecognizerType recognizerType) {
        if (this.mIsLanguageInit) {
            return;
        }
        this.mRecognizer.setLanguage(this.mCurrentLanguage);
        this.mRecognizer.setRecognizerType(recognizerType);
        this.mIsLanguageInit = true;
    }

    private void initSpenRecognizer() {
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getRectSize(new Rect());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        this.mRecognizer.setDisplayMetrics(displayMetrics.xdpi, displayMetrics.ydpi);
    }

    private void initTextRecognitionLanguage(Context context) {
        TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(context);
        textRecognitionLanguage.initTextRecognitionLanguage(false);
        this.mCurrentLanguage = textRecognitionLanguage.getFirstLanguageForTextRecognition();
        this.mDefaultLocalLanguageDbExist = textRecognitionLanguage.findDefaultLocaleLanguageInRecognizerList() != null;
    }

    private boolean isSupportedHyperTextType(int i) {
        return i == 3 || i == 1 || i == 2 || i == 7;
    }

    private void startRecognitionMonitor(final CountDownLatch countDownLatch, @Nullable String str, final WorkerInfoContract workerInfoContract) {
        String str2 = TAG;
        DataLogger.m12302d(str2, "startRecognitionMonitor");
        new SenlThreadFactory(str2).newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionManager.1
            @Override // java.lang.Runnable
            public void run() {
                DataLogger.m12302d(TextRecognitionManager.TAG, "startRecognitionMonitor$run, start cancel monitor");
                while (true) {
                    try {
                        if (countDownLatch.await(1L, TimeUnit.SECONDS)) {
                            DataLogger.m12302d(TextRecognitionManager.TAG, "startRecognitionMonitor$run, await recognize, true");
                            break;
                        }
                        WorkerInfoContract workerInfoContract2 = workerInfoContract;
                        if (workerInfoContract2 != null ? workerInfoContract2.isCanceled() : false) {
                            DataLogger.m12302d(TextRecognitionManager.TAG, "startRecognitionMonitor$run, call cancel");
                            TextRecognitionManager.this.mRecognizer.cancel();
                            break;
                        }
                    } catch (InterruptedException unused) {
                        DataLogger.m12303e(TextRecognitionManager.TAG, "startRecognitionMonitor$run, InterruptedException");
                        Thread.currentThread().interrupt();
                    }
                }
                DataLogger.m12302d(TextRecognitionManager.TAG, "startRecognitionMonitor$run, done");
            }
        }).start();
    }

    public void close() {
        SpenRecognizerManager spenRecognizerManager = this.mRecognizerManager;
        if (spenRecognizerManager != null) {
            SpenRecognizer spenRecognizer = this.mRecognizer;
            if (spenRecognizer != null) {
                spenRecognizerManager.destroyRecognizer(spenRecognizer);
                this.mRecognizer = null;
            }
            this.mRecognizerManager.close();
            this.mRecognizerManager = null;
        }
    }

    public boolean isPossible() {
        DataLogger.m12302d(TAG, "isPossible : " + this.mIsPossible);
        return this.mIsPossible;
    }

    public synchronized ResultSpenRecognizer requestRecognition(ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, DivideType divideType, int i, @Nullable String str, WorkerInfoContract workerInfoContract) {
        return requestRecognition("", arrayList, arrayList2, divideType, i, str, workerInfoContract, SpenRecognizer.RecognizerType.TEXT_EXTRACTOR);
    }

    public void setTextRecognitionPlugIn(TextRecognitionPlugInContract textRecognitionPlugInContract) {
        this.mTextRecognitionPlugIn = textRecognitionPlugInContract;
    }

    public synchronized ResultSpenRecognizer requestRecognition(String str, ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, DivideType divideType, int i, @Nullable String str2, WorkerInfoContract workerInfoContract) {
        return requestRecognition(str, arrayList, arrayList2, divideType, i, str2, workerInfoContract, SpenRecognizer.RecognizerType.TEXT_EXTRACTOR);
    }

    public synchronized ResultSpenRecognizer requestRecognition(String str, ArrayList<SpenObjectStroke> arrayList, ArrayList<Integer> arrayList2, DivideType divideType, int i, @Nullable String str2, WorkerInfoContract workerInfoContract, SpenRecognizer.RecognizerType recognizerType) throws Throwable {
        try {
            try {
                initLanguage(recognizerType);
                SpenRecognizerResultContainerInterface spenRecognizerResult = getSpenRecognizerResult(str, arrayList, i, str2, workerInfoContract);
                if (spenRecognizerResult == null) {
                    DataLogger.m12302d(TAG, "requestRecognition result null");
                    return null;
                }
                return getResultFromSpenRecognizerResult(spenRecognizerResult, arrayList, arrayList2, divideType);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

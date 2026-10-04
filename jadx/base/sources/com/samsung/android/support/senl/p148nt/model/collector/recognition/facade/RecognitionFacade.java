package com.samsung.android.support.senl.p148nt.model.collector.recognition.facade;

import android.content.Context;
import android.graphics.RectF;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.contract.DataToComposerManager;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionExtractor;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionPlugInContract;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RecognitionFacade {
    private static final String TAG = CollectLogger.createTag("RecognitionFacade");

    public List<TextInfo> recognizeLine(Context context, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        if (!RecognitionUtil.isSupported(context)) {
            DataLogger.m12302d(TAG, "recognize not supported");
            return arrayList;
        }
        TextRecognitionExtractor textRecognitionExtractor = new TextRecognitionExtractor(context);
        arrayList.addAll(textRecognitionExtractor.requestLineRecognize(str, cancellationSignal).getTextInfoList());
        textRecognitionExtractor.close();
        return arrayList;
    }

    public List<TextInfo> recognizeWord(Context context, @NonNull String str, @NonNull SpenWNote spenWNote, @NonNull List<String> list, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        if (!RecognitionUtil.isSupported(context)) {
            DataLogger.m12302d(TAG, "recognize not supported");
            return arrayList;
        }
        TextRecognitionExtractor textRecognitionExtractor = new TextRecognitionExtractor(context);
        textRecognitionExtractor.setTextRecognitionPlugIn(new TextRecognitionPlugInContract() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.facade.RecognitionFacade.1
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionPlugInContract
            public ArrayList<SpenHyperTextSpan> parseHyperText(Context context2, String str2) {
                return DataToComposerManager.getInstance().getParseHyperTextContract().parseHyperText(context2, str2, 0, true);
            }
        });
        arrayList.addAll(textRecognitionExtractor.requestWordRecognize(str, spenWNote, list, cancellationSignal).getRecognizedText());
        textRecognitionExtractor.close();
        DataLogger.m12302d(TAG, "recognize end " + arrayList.size());
        return arrayList;
    }

    public List<TextInfo> recognizeWord(Context context, @NonNull String str, @NonNull SpenWNote spenWNote, RectF rectF, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        if (!RecognitionUtil.isSupported(context)) {
            DataLogger.m12302d(TAG, "recognize not supported");
            return arrayList;
        }
        String str2 = TAG;
        DataLogger.m12302d(str2, "recognizeWord recognitionRect " + rectF);
        TextRecognitionExtractor textRecognitionExtractor = new TextRecognitionExtractor(context);
        textRecognitionExtractor.setTextRecognitionPlugIn(new TextRecognitionPlugInContract() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.facade.RecognitionFacade.2
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionPlugInContract
            public ArrayList<SpenHyperTextSpan> parseHyperText(Context context2, String str3) {
                return DataToComposerManager.getInstance().getParseHyperTextContract().parseHyperText(context2, str3, 0, true);
            }
        });
        arrayList.addAll(textRecognitionExtractor.requestWordRecognize(str, spenWNote, rectF, cancellationSignal).getRecognizedText());
        textRecognitionExtractor.close();
        DataLogger.m12302d(str2, "recognize end " + arrayList.size());
        return arrayList;
    }

    public List<TextInfo> recognizeWord(Context context, @NonNull String str, int i, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        if (!RecognitionUtil.isSupported(context)) {
            DataLogger.m12302d(TAG, "recognize not supported");
            return arrayList;
        }
        TextRecognitionExtractor textRecognitionExtractor = new TextRecognitionExtractor(context);
        textRecognitionExtractor.setTextRecognitionPlugIn(new TextRecognitionPlugInContract() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.facade.RecognitionFacade.3
            @Override // com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionPlugInContract
            public ArrayList<SpenHyperTextSpan> parseHyperText(Context context2, String str2) {
                return DataToComposerManager.getInstance().getParseHyperTextContract().parseHyperText(context2, str2, 0, true);
            }
        });
        arrayList.addAll(textRecognitionExtractor.requestWordRecognize(str, i, cancellationSignal).getRecognizedText());
        textRecognitionExtractor.close();
        DataLogger.m12302d(TAG, "recognize end " + arrayList.size());
        return arrayList;
    }
}

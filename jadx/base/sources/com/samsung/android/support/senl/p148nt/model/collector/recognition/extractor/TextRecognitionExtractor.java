package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

import android.content.Context;
import android.graphics.RectF;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.ResultSpenRecognizer;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.ResultTextRecognition;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionManager;
import com.samsung.android.support.senl.p148nt.model.collector.util.NoteCreateModeUtil;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextRecognitionExtractor {
    private static final String MAGIC_PEN = "com.samsung.android.sdk.pen.pen.preload.MagicPen";
    private static final String OBJECT_KEY_ACTION_LINK = "action_link";
    private static final String OBJECT_VALUE_SHAPE = "shape";
    private static final String TAG = CollectLogger.createTag("TextRecognitionExtractor");
    private final CollectInfo mCollectInfo;
    private final Context mContext;
    private SpenNoteDoc mNoteDoc;
    private ArrayList<Integer> mStrokeIndex;
    private ArrayList<SpenObjectStroke> mStrokeList;
    private TextRecognitionManager mTextRecognitionManager;

    public TextRecognitionExtractor(Context context) {
        this(context, null);
    }

    private void extractStrokeFromObjectList(ArrayList<Pair<SpenObjectBase, Integer>> arrayList) {
        DataLogger.m12307i(TAG, "extractStrokeFromObjectList");
        ArrayList<SpenObjectStroke> arrayList2 = this.mStrokeList;
        if (arrayList2 == null || this.mStrokeIndex == null) {
            return;
        }
        arrayList2.clear();
        this.mStrokeIndex.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SpenObjectBase spenObjectBase = (SpenObjectBase) arrayList.get(i).first;
            if (spenObjectBase.getType() == 1) {
                SpenObjectStroke spenObjectStroke = (SpenObjectStroke) spenObjectBase;
                if (spenObjectStroke.getPenName().compareTo("com.samsung.android.sdk.pen.pen.preload.MagicPen") != 0 && !"shape".equals(spenObjectBase.getExtraDataString(OBJECT_KEY_ACTION_LINK))) {
                    this.mStrokeList.add(spenObjectStroke);
                    this.mStrokeIndex.add(Integer.valueOf(i));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void requestExtractForSDoc(WorkerInfoContract workerInfoContract, ResultTextRecognition resultTextRecognition) {
        WorkerInfoContract workerInfoContract2;
        int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        if (i2 >= i) {
            i2 = i;
        }
        ArrayList<SpenContentBase> contentList = this.mCollectInfo.getSDoc().getContentList();
        if (contentList == null) {
            DataLogger.m12309w(TAG, "requestExtractForSDoc : null content list");
            return;
        }
        for (SpenContentBase spenContentBase : contentList) {
            if (spenContentBase.getType() == 3) {
                SpenNoteDoc spenNoteDocMakeSpenNoteDoc = DocumentConstructor.makeSpenNoteDoc(this.mContext, ((SpenContentHandWriting) spenContentBase).getAttachedFile(), i2, 0);
                this.mNoteDoc = spenNoteDocMakeSpenNoteDoc;
                SpenPageDoc page = spenNoteDocMakeSpenNoteDoc.getPage(0);
                DataLogger.m12302d(TAG, "requestExtractForSDoc " + this.mNoteDoc.getId());
                ArrayList<Pair<SpenObjectBase, Integer>> arrayList = new ArrayList<>();
                Iterator<SpenObjectBase> it = page.getObjectList().iterator();
                while (it.hasNext()) {
                    arrayList.add(new Pair<>(it.next(), 0));
                }
                if (this.mTextRecognitionManager != null) {
                    extractStrokeFromObjectList(arrayList);
                    if (this.mStrokeList.isEmpty()) {
                        workerInfoContract2 = workerInfoContract;
                    } else {
                        workerInfoContract2 = workerInfoContract;
                        resultTextRecognition.convertFromResultSpenRecognizer(this.mTextRecognitionManager.requestRecognition(this.mStrokeList, this.mStrokeIndex, TextRecognitionManager.DivideType.WORD, RecognitionUtil.getRecognizeSleepTime(this.mContext, this.mCollectInfo.getPriority()), this.mCollectInfo.getNotePath(), workerInfoContract2), page.getId(), page.getWidth());
                    }
                    try {
                        try {
                            this.mNoteDoc.close(true);
                        } catch (Exception e) {
                            DataLogger.m12303e(TAG, "requestExtractForSDoc, exception : " + e.getMessage());
                        }
                        this.mNoteDoc = null;
                    } catch (Throwable th) {
                        this.mNoteDoc = null;
                        throw th;
                    }
                }
            } else {
                workerInfoContract2 = workerInfoContract;
            }
            workerInfoContract = workerInfoContract2;
        }
    }

    private void requestExtractForWDoc(WorkerInfoContract workerInfoContract, ResultTextRecognition resultTextRecognition) {
        int i = 0;
        int i2 = 0;
        for (SpenWPage spenWPage : this.mCollectInfo.getChangedWPages()) {
            ArrayList<Pair<SpenObjectBase, Integer>> arrayList = new ArrayList<>();
            String id = spenWPage.getId();
            Iterator<SpenObjectBase> it = spenWPage.getObjectList().iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair<>(it.next(), Integer.valueOf(i2)));
                i2++;
            }
            if (this.mTextRecognitionManager != null) {
                extractStrokeFromObjectList(arrayList);
                if (!this.mStrokeList.isEmpty()) {
                    int size = this.mStrokeList.size() + i;
                    resultTextRecognition.convertFromResultSpenRecognizer(this.mTextRecognitionManager.requestRecognition(this.mStrokeList, this.mStrokeIndex, TextRecognitionManager.DivideType.WORD, RecognitionUtil.getRecognizeSleepTime(this.mContext, this.mCollectInfo.getPriority()), this.mCollectInfo.getNotePath(), workerInfoContract), id, spenWPage.getWidth());
                    i = size;
                }
            }
        }
        DataLogger.m12305f(TAG, "requestExtractForWDoc, uuid/page/recognizedStrokeSize/textInfo/linkInfo size : " + this.mCollectInfo.getUuid() + "/" + this.mCollectInfo.getChangedWPages().size() + "/" + i + "/" + resultTextRecognition.getTextInfoList().size() + "/" + resultTextRecognition.getLinkInfoList().size());
    }

    private void requestLineRecognizeByObjectList(ResultTextRecognition resultTextRecognition, ArrayList<Pair<SpenObjectBase, Integer>> arrayList, String str, CancellationSignal cancellationSignal) {
        if (this.mTextRecognitionManager == null) {
            return;
        }
        String str2 = TAG;
        DataLogger.m12302d(str2, "requestLineRecognizeByObjectList object count : " + arrayList.size());
        extractStrokeFromObjectList(arrayList);
        if (this.mStrokeList.isEmpty()) {
            return;
        }
        if (cancellationSignal != null) {
            if (cancellationSignal.isCanceled()) {
                DataLogger.m12307i(str2, "requestLineRecognizeByObjectList cancellationSignal.isCanceled() true");
                return;
            }
            DataLogger.m12307i(str2, "requestLineRecognizeByObjectList cancellationSignal.isCanceled() false");
        }
        ResultSpenRecognizer resultSpenRecognizerRequestRecognition = this.mTextRecognitionManager.requestRecognition(this.mStrokeList, this.mStrokeIndex, TextRecognitionManager.DivideType.LINE, 0, "ExtractStrokeFromObjectList", null);
        if (resultSpenRecognizerRequestRecognition != null) {
            int size = resultSpenRecognizerRequestRecognition.resultString.size();
            for (int i = 0; i < size; i++) {
                TextInfo textInfo = new TextInfo();
                textInfo.str = resultSpenRecognizerRequestRecognition.resultString.get(i);
                textInfo.rect = new RectF(resultSpenRecognizerRequestRecognition.resultRectF.get(i));
                textInfo.contentType = 1;
                textInfo.strokeColor = resultSpenRecognizerRequestRecognition.resultStringColor.get(i).intValue();
                textInfo.pageUuid = str;
                resultTextRecognition.getTextInfoList().add(textInfo);
            }
        }
    }

    private ResultSpenRecognizer requestWordRecognizeByObjectList(ArrayList<Pair<SpenObjectBase, Integer>> arrayList, CancellationSignal cancellationSignal) {
        return requestWordRecognizeByObjectList("", arrayList, cancellationSignal);
    }

    public void close() {
        DataLogger.m12307i(TAG, "close");
        TextRecognitionManager textRecognitionManager = this.mTextRecognitionManager;
        if (textRecognitionManager != null) {
            textRecognitionManager.close();
            this.mTextRecognitionManager = null;
        }
        ArrayList<SpenObjectStroke> arrayList = this.mStrokeList;
        if (arrayList != null) {
            arrayList.clear();
            this.mStrokeList = null;
        }
        ArrayList<Integer> arrayList2 = this.mStrokeIndex;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.mStrokeIndex = null;
        }
        SpenNoteDoc spenNoteDoc = this.mNoteDoc;
        if (spenNoteDoc != null) {
            try {
                spenNoteDoc.close(true);
            } catch (IOException e) {
                DataLogger.m12303e(TAG, "close, fail to close doc : " + e.getMessage());
            } finally {
                this.mNoteDoc = null;
            }
        }
    }

    @NonNull
    public synchronized ResultTextRecognition requestExtract(WorkerInfoContract workerInfoContract) {
        try {
            String str = TAG;
            DataLogger.m12302d(str, "requestExtract, start - notePath: " + Logger.getEncode(this.mCollectInfo.getNotePath()));
            try {
                ResultTextRecognition resultTextRecognition = new ResultTextRecognition();
                if (this.mCollectInfo.getNoteType() == CollectInfo.NoteType.S_DOC) {
                    requestExtractForSDoc(workerInfoContract, resultTextRecognition);
                } else {
                    requestExtractForWDoc(workerInfoContract, resultTextRecognition);
                }
                if (!resultTextRecognition.getTextInfoList().isEmpty()) {
                    Collections.sort(resultTextRecognition.getTextInfoList(), new Comparator<TextInfo>() { // from class: com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionExtractor.1
                        @Override // java.util.Comparator
                        public int compare(TextInfo textInfo, TextInfo textInfo2) {
                            return (int) (textInfo.rect.top - textInfo2.rect.top);
                        }
                    });
                    DataLogger.m12307i(str, "requestExtract, end - size : " + resultTextRecognition.getTextInfoList().size());
                    return resultTextRecognition;
                }
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "requestExtract, exception :" + e.getMessage());
                close();
            }
            DataLogger.m12307i(TAG, "requestExtract, end");
            return new ResultTextRecognition();
        } catch (Throwable th) {
            throw th;
        }
    }

    public ResultTextRecognition requestLineRecognize(String str, CancellationSignal cancellationSignal) throws Throwable {
        String str2;
        Throwable th;
        Exception exc;
        String str3;
        StringBuilder sb;
        DataLogger.m12302d(TAG, "requestLineRecognize, start notePath: " + Logger.getEncode(str));
        ResultTextRecognition resultTextRecognition = new ResultTextRecognition();
        try {
            try {
                int noteCreateMode = NoteCreateModeUtil.getNoteCreateMode();
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                Context context = this.mContext;
                str2 = str;
                try {
                    SpenWNote spenWNoteOpen = documentFileManager.open(context, str2, SpenDocumentDisplayUtils.getScreenWidth(context), noteCreateMode, false, false);
                    ArrayList<SpenWPage> pageList = spenWNoteOpen.getPageList();
                    int size = pageList.size();
                    for (int i = 0; i < size; i++) {
                        SpenWPage spenWPage = pageList.get(i);
                        String id = spenWPage.getId();
                        ArrayList<Pair<SpenObjectBase, Integer>> arrayList = new ArrayList<>();
                        Iterator<SpenObjectBase> it = spenWPage.getObjectList().iterator();
                        while (it.hasNext()) {
                            arrayList.add(new Pair<>(it.next(), Integer.valueOf(i)));
                        }
                        requestLineRecognizeByObjectList(resultTextRecognition, arrayList, id, cancellationSignal);
                    }
                    if (!resultTextRecognition.getTextInfoList().isEmpty()) {
                        DataLogger.m12307i(TAG, "requestLineRecognize, end success");
                        try {
                            DocumentFileManager.getInstance().close(str2, spenWNoteOpen, true);
                            return resultTextRecognition;
                        } catch (Exception e) {
                            AbstractC11014a.m12333r(e, new StringBuilder("requestLineRecognize fail to close, e : "), TAG);
                            return resultTextRecognition;
                        }
                    }
                    DataLogger.m12307i(TAG, "requestLineRecognize, no result");
                    try {
                        DocumentFileManager.getInstance().close(str2, spenWNoteOpen, true);
                        return resultTextRecognition;
                    } catch (Exception e2) {
                        exc = e2;
                        str3 = TAG;
                        sb = new StringBuilder("requestLineRecognize fail to close, e : ");
                        AbstractC11014a.m12333r(exc, sb, str3);
                        return resultTextRecognition;
                    }
                } catch (Exception e3) {
                    e = e3;
                    Exception exc2 = e;
                    DataLogger.m12303e(TAG, "requestLineRecognize, exception : " + exc2.getMessage());
                    try {
                        DocumentFileManager.getInstance().close(str2, null, true);
                    } catch (Exception e5) {
                        exc = e5;
                        str3 = TAG;
                        sb = new StringBuilder("requestLineRecognize fail to close, e : ");
                        AbstractC11014a.m12333r(exc, sb, str3);
                        return resultTextRecognition;
                    }
                    return resultTextRecognition;
                }
            } catch (Throwable th2) {
                th = th2;
                th = th;
                try {
                    DocumentFileManager.getInstance().close(str, null, true);
                    throw th;
                } catch (Exception e6) {
                    AbstractC11014a.m12333r(e6, new StringBuilder("requestLineRecognize fail to close, e : "), TAG);
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            str2 = str;
        } catch (Throwable th3) {
            th = th3;
            th = th;
            DocumentFileManager.getInstance().close(str, null, true);
            throw th;
        }
    }

    public ResultTextRecognition requestRecognizeFromObjectList(WorkerInfoContract workerInfoContract, ArrayList<Pair<SpenObjectBase, Integer>> arrayList) {
        ResultTextRecognition resultTextRecognition = new ResultTextRecognition();
        if (this.mTextRecognitionManager != null) {
            extractStrokeFromObjectList(arrayList);
            if (!this.mStrokeList.isEmpty()) {
                resultTextRecognition.convertFromResultSpenRecognizer(this.mTextRecognitionManager.requestRecognition(this.mStrokeList, this.mStrokeIndex, TextRecognitionManager.DivideType.WORD, RecognitionUtil.getRecognizeSleepTime(this.mContext, this.mCollectInfo.getPriority()), this.mCollectInfo.getNotePath(), workerInfoContract), "", 0);
            }
        }
        return resultTextRecognition;
    }

    public ResultTextRecognition requestWordRecognize(String str, int i, CancellationSignal cancellationSignal) throws Throwable {
        String str2;
        Throwable th;
        Exception exc;
        String str3;
        StringBuilder sb;
        ResultTextRecognition resultTextRecognition = new ResultTextRecognition();
        try {
            try {
                int noteCreateMode = NoteCreateModeUtil.getNoteCreateMode();
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                Context context = this.mContext;
                str2 = str;
                try {
                    SpenWNote spenWNoteOpen = documentFileManager.open(context, str2, SpenDocumentDisplayUtils.getScreenWidth(context), noteCreateMode, false, false);
                    for (int i2 = 0; i2 < i; i2++) {
                        SpenWPage page = spenWNoteOpen.getPage(i2);
                        String id = page.getId();
                        ArrayList<Pair<SpenObjectBase, Integer>> arrayList = new ArrayList<>();
                        Iterator<SpenObjectBase> it = page.getObjectList().iterator();
                        while (it.hasNext()) {
                            arrayList.add(new Pair<>(it.next(), Integer.valueOf(i2)));
                        }
                        resultTextRecognition.convertFromResultSpenRecognizer(requestWordRecognizeByObjectList(arrayList, cancellationSignal), id, page.getWidth());
                    }
                    if (!resultTextRecognition.getTextInfoList().isEmpty()) {
                        DataLogger.m12307i(TAG, "requestLineRecognize, end success");
                        try {
                            DocumentFileManager.getInstance().close(str2, spenWNoteOpen, true);
                            return resultTextRecognition;
                        } catch (Exception e) {
                            AbstractC11014a.m12333r(e, new StringBuilder("requestLineRecognize fail to close, e : "), TAG);
                            return resultTextRecognition;
                        }
                    }
                    DataLogger.m12307i(TAG, "requestLineRecognize, no result");
                    try {
                        DocumentFileManager.getInstance().close(str2, spenWNoteOpen, true);
                        return resultTextRecognition;
                    } catch (Exception e2) {
                        exc = e2;
                        str3 = TAG;
                        sb = new StringBuilder("requestLineRecognize fail to close, e : ");
                        AbstractC11014a.m12333r(exc, sb, str3);
                        return resultTextRecognition;
                    }
                } catch (Exception e3) {
                    e = e3;
                    Exception exc2 = e;
                    DataLogger.m12303e(TAG, "requestLineRecognize, exception : " + exc2.getMessage());
                    try {
                        DocumentFileManager.getInstance().close(str2, null, true);
                    } catch (Exception e5) {
                        exc = e5;
                        str3 = TAG;
                        sb = new StringBuilder("requestLineRecognize fail to close, e : ");
                        AbstractC11014a.m12333r(exc, sb, str3);
                        return resultTextRecognition;
                    }
                    return resultTextRecognition;
                }
            } catch (Throwable th2) {
                th = th2;
                th = th;
                try {
                    DocumentFileManager.getInstance().close(str, null, true);
                    throw th;
                } catch (Exception e6) {
                    AbstractC11014a.m12333r(e6, new StringBuilder("requestLineRecognize fail to close, e : "), TAG);
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            str2 = str;
        } catch (Throwable th3) {
            th = th3;
            th = th;
            DocumentFileManager.getInstance().close(str, null, true);
            throw th;
        }
    }

    public void setTextRecognitionPlugIn(TextRecognitionPlugInContract textRecognitionPlugInContract) {
        TextRecognitionManager textRecognitionManager = this.mTextRecognitionManager;
        if (textRecognitionManager != null) {
            textRecognitionManager.setTextRecognitionPlugIn(textRecognitionPlugInContract);
        }
    }

    public TextRecognitionExtractor(Context context, CollectInfo collectInfo) {
        this.mStrokeList = new ArrayList<>();
        this.mStrokeIndex = new ArrayList<>();
        DataLogger.m12307i(TAG, "created");
        this.mContext = context;
        this.mCollectInfo = collectInfo;
        TextRecognitionManager textRecognitionManager = new TextRecognitionManager(context);
        this.mTextRecognitionManager = textRecognitionManager;
        if (textRecognitionManager.isPossible()) {
            return;
        }
        close();
    }

    private ResultSpenRecognizer requestWordRecognizeByObjectList(@NonNull String str, ArrayList<Pair<SpenObjectBase, Integer>> arrayList, CancellationSignal cancellationSignal) {
        ResultSpenRecognizer resultSpenRecognizer = new ResultSpenRecognizer();
        if (this.mTextRecognitionManager != null) {
            String str2 = TAG;
            DataLogger.m12302d(str2, "requestWordRecognizeByObjectList object count : " + arrayList.size());
            extractStrokeFromObjectList(arrayList);
            if (!this.mStrokeList.isEmpty()) {
                if (cancellationSignal != null) {
                    if (cancellationSignal.isCanceled()) {
                        DataLogger.m12307i(str2, "requestWordRecognizeByObjectList cancellationSignal.isCanceled() true");
                        return resultSpenRecognizer;
                    }
                    DataLogger.m12307i(str2, "requestWordRecognizeByObjectList cancellationSignal.isCanceled() false");
                }
                return this.mTextRecognitionManager.requestRecognition(str, this.mStrokeList, this.mStrokeIndex, TextRecognitionManager.DivideType.WORD, 0, "ExtractStrokeFromObjectList", null);
            }
        }
        return resultSpenRecognizer;
    }

    public ResultTextRecognition requestWordRecognize(String str, SpenWNote spenWNote, List<String> list, CancellationSignal cancellationSignal) {
        DataLogger.m12302d(TAG, "requestWordRecognize");
        ResultTextRecognition resultTextRecognition = new ResultTextRecognition();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                SpenWPage page = spenWNote.getPage(spenWNote.getPageIndexById(list.get(i)));
                String id = page.getId();
                ArrayList<Pair<SpenObjectBase, Integer>> arrayList = new ArrayList<>();
                Iterator<SpenObjectBase> it = page.getObjectList().iterator();
                while (it.hasNext()) {
                    arrayList.add(new Pair<>(it.next(), Integer.valueOf(i)));
                }
                resultTextRecognition.convertFromResultSpenRecognizer(requestWordRecognizeByObjectList(str, arrayList, cancellationSignal), id, page.getWidth());
            } catch (IndexOutOfBoundsException e) {
                DataLogger.m12303e(TAG, "requestWordRecognize, e: " + e.getMessage());
            }
        }
        if (!resultTextRecognition.getTextInfoList().isEmpty()) {
            DataLogger.m12307i(TAG, "requestWordRecognize, end success");
        } else {
            DataLogger.m12307i(TAG, "requestWordRecognize, no result");
        }
        return resultTextRecognition;
    }

    public ResultTextRecognition requestWordRecognize(String str, SpenWNote spenWNote, RectF rectF, CancellationSignal cancellationSignal) {
        SpenWPage page;
        String id;
        ResultTextRecognition resultTextRecognition = new ResultTextRecognition();
        float height = spenWNote.getPage(0).getHeight();
        int i = (int) (rectF.top / height);
        int pageCount = (int) (rectF.bottom / height);
        if (pageCount >= spenWNote.getPageCount()) {
            pageCount = spenWNote.getPageCount() - 1;
        }
        int i2 = pageCount;
        DataLogger.m12302d(TAG, "requestWordRecognize startPageIndex/endPageIndex " + i + "/" + i2);
        ArrayList<Pair<SpenObjectBase, Integer>> arrayList = new ArrayList<>();
        while (i <= i2) {
            try {
                page = spenWNote.getPage(i);
                id = page.getId();
                for (SpenObjectBase spenObjectBase : page.getObjectList()) {
                    if (rectF.contains(spenObjectBase.getDrawnRect())) {
                        arrayList.add(new Pair<>(spenObjectBase, Integer.valueOf(i)));
                    }
                }
                DataLogger.m12302d(TAG, "requestWordRecognize pageIndex/objectSize " + i + "/" + page.findObjectInRect(1, rectF, true).size());
            } catch (IndexOutOfBoundsException e) {
                e = e;
            }
            try {
                resultTextRecognition.convertFromResultSpenRecognizer(requestWordRecognizeByObjectList(str, arrayList, cancellationSignal), id, page.getWidth());
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                DataLogger.m12303e(TAG, "requestWordRecognize, e: " + e.getMessage());
            }
            i++;
        }
        if (!resultTextRecognition.getTextInfoList().isEmpty()) {
            DataLogger.m12307i(TAG, "requestWordRecognize, end success");
        } else {
            DataLogger.m12307i(TAG, "requestWordRecognize, no result");
        }
        return resultTextRecognition;
    }
}

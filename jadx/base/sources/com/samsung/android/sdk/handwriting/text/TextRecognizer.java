package com.samsung.android.sdk.handwriting.text;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.handwriting.GSIMLogger;
import com.samsung.android.sdk.handwriting.LanguageID;
import com.samsung.android.sdk.handwriting.Recognizer;
import com.samsung.android.sdk.handwriting.UninitializedException;
import com.samsung.android.sdk.handwriting.text.impl.TextRecognizerImpl;
import com.samsung.android.sdk.handwriting.text.interfaces.TextRecognizerInterface;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class TextRecognizer {
    public static final int STATUS_FAILURE_INTERNAL_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    private static final String TAG = "TextRecognizer";
    private static final Object mLock = new Object();
    private TextRecognizerInterface mEngine;
    private boolean mAsyncMode = false;
    private RecognitionListener mListener = null;
    private int mStrokeCount = 0;
    private int mRecognizeCount = 0;
    private String mLanguage = "";
    private TextRecognizerInterface.EventListener mEventListener = new TextRecognizerInterface.EventListener() { // from class: com.samsung.android.sdk.handwriting.text.TextRecognizer.1
        @Override // com.samsung.android.sdk.handwriting.text.interfaces.TextRecognizerInterface.EventListener
        public void onResult(int i, TextRecognizerInterface.ResultInterface resultInterface) {
            if (TextRecognizer.this.mListener == null) {
                return;
            }
            TextRecognizer.this.mListener.onResult(i, new Result(resultInterface));
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RecognitionListener {
        void onResult(int i, Result result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RecognitionMode {
        CHARACTER,
        SINGLE_LINE,
        MULTI_LINE,
        OVERLAY;

        public static RecognitionMode[] getValues() {
            return values();
        }

        public String getString() {
            int iOrdinal = ordinal();
            return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? "" : "overlaid" : "mline" : "sline" : "char";
        }

        public int getValue() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return 0;
            }
            if (iOrdinal == 1) {
                return 2;
            }
            if (iOrdinal != 2) {
                return iOrdinal != 3 ? -1 : 4;
            }
            return 3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return getString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RecognitionType {
        TEXT_PLAIN,
        TEXT_SYMBOL,
        EMAIL,
        URL,
        NUMBER,
        PHONE;

        public static RecognitionType[] getValues() {
            return values();
        }

        public String getString() {
            int iOrdinal = ordinal();
            return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? super.toString() : "phone" : TextConst.KEY_PARAM_NUMBER : "url" : "email" : "text_symbol" : "text";
        }

        public int getValue() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return 0;
            }
            int i = 1;
            if (iOrdinal != 1) {
                i = 2;
                if (iOrdinal != 2) {
                    i = 3;
                    if (iOrdinal != 3) {
                        i = 4;
                        if (iOrdinal != 4) {
                            i = 5;
                            if (iOrdinal != 5) {
                                return -1;
                            }
                        }
                    }
                }
            }
            return i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return getString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private final String[] NULL_STRING_ARRAY;
        private TextRecognizerInterface.ResultInterface mResult;

        public String[] getCandidates() {
            TextRecognizerInterface.ResultInterface resultInterface = this.mResult;
            if (resultInterface != null) {
                return resultInterface.getCandidates();
            }
            Log.e(TextRecognizer.TAG, "result is null");
            return this.NULL_STRING_ARRAY;
        }

        public int getEndPointOffset(int i) {
            TextRecognizerInterface.ResultInterface resultInterface = this.mResult;
            if (resultInterface != null) {
                return resultInterface.getEndPointOffset(i);
            }
            Log.e(TextRecognizer.TAG, "result is null");
            return -1;
        }

        public int getEndStrokeIndex(int i) {
            TextRecognizerInterface.ResultInterface resultInterface = this.mResult;
            if (resultInterface != null) {
                return resultInterface.getEndStrokeIndex(i);
            }
            Log.e(TextRecognizer.TAG, "result is null");
            return -1;
        }

        public int getStartPointOffset(int i) {
            TextRecognizerInterface.ResultInterface resultInterface = this.mResult;
            if (resultInterface != null) {
                return resultInterface.getStartPointOffset(i);
            }
            Log.e(TextRecognizer.TAG, "result is null");
            return -1;
        }

        public int getStartStrokeIndex(int i) {
            TextRecognizerInterface.ResultInterface resultInterface = this.mResult;
            if (resultInterface != null) {
                return resultInterface.getStartStrokeIndex(i);
            }
            Log.e(TextRecognizer.TAG, "result is null");
            return -1;
        }

        private Result(TextRecognizerInterface.ResultInterface resultInterface) {
            this.NULL_STRING_ARRAY = new String[0];
            this.mResult = resultInterface;
        }
    }

    public TextRecognizer(Context context, boolean z) {
        this.mEngine = null;
        if (!Recognizer.isTextRecognizerAvailable(context)) {
            Log.e(TAG, "Recognizer SDK for Text Recognizer has not been initialized");
            throw new UninitializedException("Recognizer SDK for Text Recognizer has not been initialized");
        }
        String str = TAG;
        Log.i(str, "Async mode = " + z);
        GSIMLogger.init(context);
        if (Recognizer.isSDLAvailable()) {
            Log.i(str, "framework recognizer is not supported");
            this.mEngine = null;
        } else {
            if (!Recognizer.isSDKAvailable()) {
                throw new UninitializedException("Text Recognizer is not available");
            }
            Log.i(str, "recognizer in sdk starts");
            this.mEngine = new TextRecognizerImpl(context, z);
        }
        setAsyncModeEnabled(z);
    }

    private static TextRecognizer create(Context context, boolean z) {
        return new TextRecognizer(context, z);
    }

    private void setAsyncModeEnabled(boolean z) {
        try {
            this.mEngine.setAsyncMode(z);
            this.mAsyncMode = z;
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    private void setListener(RecognitionListener recognitionListener) {
        try {
            this.mEngine.setListener(this.mEventListener);
            this.mListener = recognitionListener;
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addStroke(float[] fArr, float[] fArr2) {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        if (textRecognizerInterface == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (fArr == null) {
            throw new IllegalArgumentException("stroke x point data is null");
        }
        if (fArr2 == null) {
            throw new IllegalArgumentException("stroke y point data is null");
        }
        if (fArr.length != fArr2.length) {
            throw new IllegalArgumentException("invalid stroke");
        }
        if (fArr.length <= 0) {
            throw new IllegalArgumentException("stroke x point data is invalid");
        }
        if (fArr2.length <= 0) {
            throw new IllegalArgumentException("stroke y point data is invalid");
        }
        try {
            textRecognizerInterface.addStroke(fArr, fArr2);
            this.mStrokeCount++;
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    public void cancel() {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        if (textRecognizerInterface != null) {
            try {
                textRecognizerInterface.cancel();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }
        this.mStrokeCount = 0;
    }

    public void clearStrokes() {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        if (textRecognizerInterface == null) {
            throw new IllegalStateException("Engine is null");
        }
        try {
            textRecognizerInterface.clearStrokes();
            this.mStrokeCount = 0;
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    public void close() {
        try {
            TextRecognizerInterface textRecognizerInterface = this.mEngine;
            if (textRecognizerInterface != null) {
                textRecognizerInterface.dispose();
                this.mEngine = null;
            }
            if (this.mEventListener != null) {
                this.mEventListener = null;
            }
            if (this.mListener != null) {
                this.mListener = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mStrokeCount = 0;
        this.mRecognizeCount = 0;
        this.mLanguage = "";
        Log.i(TAG, "recognizer closed");
    }

    public List<String> getSupportedLanguages() {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        if (textRecognizerInterface == null) {
            throw new IllegalStateException("Engine is null");
        }
        try {
            return textRecognizerInterface.getSupportedLanguages();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    public int getTypeOfEngineIstance() {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        return (textRecognizerInterface != null && (textRecognizerInterface instanceof TextRecognizerImpl)) ? 1 : 0;
    }

    public Result recognize() throws IncorrectUsageException {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (this.mStrokeCount == 0) {
            return null;
        }
        if (this.mAsyncMode) {
            throw new IncorrectUsageException("Sync API is not allowed in Async mode.");
        }
        this.mStrokeCount = 0;
        this.mRecognizeCount++;
        GSIMLogger.insertLog("TN", "Count");
        try {
            return new Result(this.mEngine.recognize());
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestRecognition(final RecognitionListener recognitionListener) throws IncorrectUsageException {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (this.mStrokeCount == 0) {
            Runnable runnable = new Runnable() { // from class: com.samsung.android.sdk.handwriting.text.TextRecognizer.2
                @Override // java.lang.Runnable
                public void run() {
                    recognitionListener.onResult(2, null);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Handler().post(runnable);
                return;
            } else {
                new Thread(runnable).start();
                return;
            }
        }
        if (recognitionListener == null) {
            throw new IllegalArgumentException("Listener is null");
        }
        if (!this.mAsyncMode) {
            throw new IncorrectUsageException("Async API is not allowed in Sync mode.");
        }
        this.mStrokeCount = 0;
        this.mRecognizeCount++;
        GSIMLogger.insertLog("TN", "Count");
        synchronized (mLock) {
            try {
                setListener(recognitionListener);
                try {
                    this.mEngine.request();
                } catch (IllegalStateException e) {
                    throw new IllegalStateException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setLanguage(String str) {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (str == null) {
            throw new IllegalArgumentException("language is null");
        }
        String str2 = TAG;
        Log.i(str2, "language = " + LanguageID.getID(str));
        GSIMLogger.insertLog("TL", str);
        if (this.mLanguage.compareTo(str) == 0) {
            Log.i(str2, "skipped because the language is already set");
            return;
        }
        synchronized (mLock) {
            try {
                try {
                    this.mEngine.setLanguage(str);
                    this.mLanguage = str;
                } catch (IllegalStateException e) {
                    throw new IllegalStateException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setLanguageData(String str, byte[] bArr, byte[] bArr2) {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (str == null) {
            throw new IllegalArgumentException("language is null");
        }
        String str2 = TAG;
        Log.i(str2, "language = " + LanguageID.getID(str));
        GSIMLogger.insertLog("TL", str);
        if (this.mLanguage.compareTo(str) == 0) {
            Log.i(str2, "skipped because the language is already set");
            return;
        }
        synchronized (mLock) {
            try {
                try {
                    this.mEngine.setLanguageData(str, bArr, bArr2);
                    this.mLanguage = str;
                } catch (IllegalStateException e) {
                    throw new IllegalStateException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRecognitionConfigs(String str, RecognitionType recognitionType, RecognitionMode recognitionMode) {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null..");
        }
        if (str == null) {
            throw new IllegalArgumentException("language is null..");
        }
        if (recognitionType == null) {
            throw new IllegalArgumentException("recognition type is null..");
        }
        if (recognitionMode == null) {
            throw new IllegalArgumentException("recognition mode is null..");
        }
        String str2 = TAG;
        Log.i(str2, "(1/3) language : " + LanguageID.getID(str));
        Log.i(str2, "(2/3) recognition type : " + recognitionType.toString());
        Log.i(str2, "(3/3) recognition mode : " + recognitionMode.toString());
        synchronized (mLock) {
            try {
                if (this.mLanguage.compareTo(str) == 0) {
                    Log.i(str2, "skipped because the language is already set");
                } else {
                    GSIMLogger.insertLog("TL", str);
                    this.mEngine.setLanguage(str);
                    this.mLanguage = str;
                }
                if (recognitionType == RecognitionType.URL) {
                    Log.i(str2, "Recognition type [" + recognitionType.toString() + "] is deprecated!");
                    recognitionType = RecognitionType.TEXT_PLAIN;
                    Log.i(str2, "Recognition type is changed to [" + recognitionType.toString() + "]");
                }
                this.mEngine.setRecognitionType(recognitionType);
                this.mEngine.setRecognitionMode(recognitionMode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRecognitionMode(RecognitionMode recognitionMode) {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (recognitionMode == null) {
            throw new IllegalArgumentException("recognition mode is null");
        }
        Log.i(TAG, "recognition mode = " + recognitionMode.toString());
        synchronized (mLock) {
            try {
                try {
                    this.mEngine.setRecognitionMode(recognitionMode);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                } catch (IllegalStateException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRecognitionType(RecognitionType recognitionType) {
        if (this.mEngine == null) {
            throw new IllegalStateException("Engine is null");
        }
        if (recognitionType == null) {
            throw new IllegalArgumentException("recognition type is null");
        }
        String str = TAG;
        Log.i(str, "recognition type = " + recognitionType.toString());
        if (recognitionType == RecognitionType.URL) {
            Log.i(str, "Recognition type [" + recognitionType.toString() + "] is deprecated!");
            recognitionType = RecognitionType.TEXT_PLAIN;
            Log.i(str, "Recognition type is changed to [" + recognitionType.toString() + "]");
        }
        synchronized (mLock) {
            try {
                try {
                    this.mEngine.setRecognitionType(recognitionType);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                } catch (IllegalStateException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setStrokeModeEnabled(boolean z) {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        if (textRecognizerInterface == null) {
            throw new IllegalStateException("Engine is null");
        }
        try {
            textRecognizerInterface.setStrokeMode(z);
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    public void setUserDictionary(List<String> list) {
        TextRecognizerInterface textRecognizerInterface = this.mEngine;
        if (textRecognizerInterface == null) {
            throw new IllegalStateException("Engine is null");
        }
        try {
            textRecognizerInterface.setUserDictionary(list);
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }

    private static TextRecognizer create(Context context, boolean z, boolean z2) {
        return new TextRecognizer(context, z, z2);
    }

    public TextRecognizer(Context context, boolean z, boolean z2) {
        this.mEngine = null;
        if (Recognizer.isTextRecognizerAvailable(context)) {
            String str = TAG;
            AbstractC6670b.m4758s("Async mode = ", ", framework library use = ", str, z, z2);
            GSIMLogger.init(context);
            this.mEngine = null;
            if (z2) {
                if (Recognizer.isSDLAvailable()) {
                    this.mEngine = null;
                } else if (Recognizer.isSDKAvailable()) {
                    this.mEngine = new TextRecognizerImpl(context, z);
                }
            } else if (Recognizer.isSDKAvailable()) {
                this.mEngine = new TextRecognizerImpl(context, z);
            } else if (Recognizer.isSDLAvailable()) {
                this.mEngine = null;
            }
            if (this.mEngine != null) {
                setAsyncModeEnabled(z);
                return;
            }
            Log.e(str, " SDL apis: " + Recognizer.isSDLAvailable() + " SDK apis: " + Recognizer.isSDKAvailable());
            throw new UninitializedException("Text Recognizer is not available");
        }
        Log.e(TAG, "Recognizer SDK for Text Recognizer has not been initialized");
        throw new UninitializedException("Recognizer SDK for Text Recognizer has not been initialized");
    }
}

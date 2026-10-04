package com.samsung.android.support.senl.p148nt.model.assist.llm;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterStreamingImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.Operator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Operator {
    private static final String TAG = "Ai$LLM$Operator";
    private final String mCacheKey;
    Callback mCallback;
    String mContent;
    String mExecutedContent;
    SCSLLMRequesterImpl mImpl;
    protected SCSTextResultListener.Callback mResponse;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.assist.llm.Operator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C114071 implements SCSTextResultListener.Callback {
        public C114071() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$0() {
            Operator.this.mCallback.onRetry(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.llm.Operator.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Operator operator = Operator.this;
                    operator.onExecute(operator.mExecutedContent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$1() {
            Operator operator = Operator.this;
            operator.onExecute(operator.mExecutedContent);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public boolean onFailed(@NonNull String str) {
            Operator operator = Operator.this;
            if (operator.mCallback == null) {
                return true;
            }
            if (operator.mImpl.couldTokenRetry(str)) {
                final int i = 0;
                new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.model.assist.llm.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ Operator.C114071 f7690b;

                    {
                        this.f7690b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                this.f7690b.lambda$onFailed$0();
                                break;
                            default:
                                this.f7690b.lambda$onFailed$1();
                                break;
                        }
                    }
                });
                Logger.m8697d(Operator.TAG, "onFailed : retry - " + str + ":1");
                return false;
            }
            if (!Operator.this.mImpl.couldRetry(str)) {
                Operator.this.mCallback.onFailed(str);
                Operator.this.loggingSafetyFilter(str);
                return true;
            }
            final int i2 = 1;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.model.assist.llm.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Operator.C114071 f7690b;

                {
                    this.f7690b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            this.f7690b.lambda$onFailed$0();
                            break;
                        default:
                            this.f7690b.lambda$onFailed$1();
                            break;
                    }
                }
            }, 100L);
            Logger.m8697d(Operator.TAG, "onFailed : retry - " + str + ":1");
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
        public void onSuccess(@NonNull String str, boolean z) {
            Operator operator = Operator.this;
            if (operator.mCallback != null) {
                String strPostProcessing = operator.postProcessing(str);
                if (Operator.this.isPostProcessingError(strPostProcessing)) {
                    onFailed(strPostProcessing);
                    return;
                }
                Operator.this.mCallback.onSuccess(strPostProcessing, z);
                Operator operator2 = Operator.this;
                operator2.mImpl.saveToCache(operator2.getCacheKey(), Operator.this.mExecutedContent, strPostProcessing, z);
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.assist.llm.Operator$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C114082 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$base$common$ai$scs$requester$type$SCSRequesterType */
        static final /* synthetic */ int[] f7682x8892577f;

        static {
            int[] iArr = new int[SCSRequesterType.values().length];
            f7682x8892577f = iArr;
            try {
                iArr[SCSRequesterType.StructuredAutoFormat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7682x8892577f[SCSRequesterType.MeetingAutoFormat.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7682x8892577f[SCSRequesterType.SpellingCorrection.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7682x8892577f[SCSRequesterType.Summary.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7682x8892577f[SCSRequesterType.Cover.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback extends SCSTextResultListener.Callback {
        void onRetry(Runnable runnable);
    }

    public Operator(String str) {
        this(str, false);
    }

    private void initImpl(boolean z) {
        if (z) {
            this.mImpl = new SCSLLMRequesterStreamingImpl();
        } else {
            this.mImpl = new SCSLLMRequesterImpl();
        }
        this.mImpl.setCallback(this.mResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(String str) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$1(String str) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSuccess(str, true);
        }
    }

    public void deleteCache() {
        this.mImpl.deleteCache(getCacheKey());
    }

    public final boolean execute() {
        if (this.mResponse == null) {
            return false;
        }
        String strReplaceAll = this.mContent.replaceAll("\\s+", "");
        int length = strReplaceAll.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount < length) {
                int iCodePointAt = strReplaceAll.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            } else if (this.mCallback != null) {
                final String string = BaseUtils.getApplicationContext().getString(C8875R.string.ai_error_can_not_find_any_text);
                final int i = 0;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.model.assist.llm.b

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ Operator f7687b;

                    {
                        this.f7687b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                this.f7687b.lambda$execute$0(string);
                                break;
                            default:
                                this.f7687b.lambda$execute$1(string);
                                break;
                        }
                    }
                }, 1000L);
                return false;
            }
        }
        if (getRequestType() == SCSRequesterType.StructuredAutoFormat) {
            this.mExecutedContent = this.mContent;
        } else {
            String str = this.mContent;
            this.mExecutedContent = StringUtils.extractString(str, this.mImpl.getLimitedStringSize(str, getRequestType()));
        }
        onPreExecute(this.mExecutedContent);
        final String strLoadFromCache = this.mImpl.loadFromCache(getCacheKey(), this.mExecutedContent);
        if (TextUtils.isEmpty(strLoadFromCache) || this.mCallback == null) {
            return onExecute(this.mExecutedContent);
        }
        onPostExecute();
        final int i2 = 1;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.model.assist.llm.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ Operator f7687b;

            {
                this.f7687b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f7687b.lambda$execute$0(strLoadFromCache);
                        break;
                    default:
                        this.f7687b.lambda$execute$1(strLoadFromCache);
                        break;
                }
            }
        }, 1000L);
        return true;
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public abstract SCSRequesterType getRequestType();

    public boolean isPostProcessingError(String str) {
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void loggingSafetyFilter(String str) {
        String str2;
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1240620589:
                if (str.equals("SAFE_FILTER_ERROR")) {
                    b = 0;
                }
                break;
            case -682865452:
                if (str.equals("SAFE_FILTER_ERROR_CHN_SENSITIVE")) {
                    b = 1;
                }
                break;
            case 1128404880:
                if (str.equals("SAFE_FILTER_ERROR_CHILD")) {
                    b = 2;
                }
                break;
            case 1285812526:
                if (str.equals("SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE")) {
                    b = 3;
                }
                break;
            case 1337820166:
                if (str.equals("SAFE_FILTER_ERROR_RECITATION")) {
                    b = 4;
                }
                break;
        }
        String str3 = "a";
        switch (b) {
            case 0:
            case 1:
                str2 = "e";
                break;
            case 2:
                str2 = "a";
                break;
            case 3:
                str2 = "c";
                break;
            case 4:
                str2 = "b";
                break;
            default:
                return;
        }
        CommonSamsungAnalytics.insertLog("802", "8361", str2);
        int i = C114082.f7682x8892577f[getRequestType().ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                str3 = "c";
            } else if (i == 4) {
                str3 = "b";
            } else if (i != 5) {
                return;
            } else {
                str3 = "d";
            }
        }
        CommonSamsungAnalytics.insertLog("802", "8360", str3);
    }

    public boolean onExecute(String str) {
        Logger.m8697d(TAG, "call operate : input - " + str.length());
        if (TextUtils.isEmpty(str)) {
            Logger.m8703w(TAG, "operate - empty content");
            return false;
        }
        try {
            operate(preProcessing(str));
            return true;
        } catch (Exception e) {
            Logger.m8703w(TAG, "operate - " + e.getMessage());
            this.mResponse.onFailed(e.getMessage());
            return true;
        }
    }

    public void onPreExecute(String str) {
        Logger.m8697d(TAG, "onPreExecute " + str.length());
    }

    public abstract void operate(String str);

    public void registerCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void release() {
        this.mCallback = null;
        this.mResponse = null;
        SCSLLMRequesterImpl sCSLLMRequesterImpl = this.mImpl;
        if (sCSLLMRequesterImpl != null) {
            sCSLLMRequesterImpl.release(getRequestType());
            this.mImpl.close();
            this.mImpl = null;
        }
        Logger.m8697d(TAG, "release - " + getClass().getSimpleName() + " : " + hashCode());
    }

    public Operator(String str, boolean z) {
        String simpleName = getClass().getSimpleName();
        this.mCacheKey = simpleName;
        StringBuilder sbM15l = AbstractC0000a.m15l("Constructed - ", simpleName, " : ");
        sbM15l.append(hashCode());
        Logger.m8697d(TAG, sbM15l.toString());
        this.mContent = str == null ? "" : str.trim();
        this.mResponse = new C114071();
        initImpl(z);
    }

    public void onPostExecute() {
    }

    public String postProcessing(String str) {
        return str;
    }

    public String preProcessing(String str) {
        return str;
    }
}

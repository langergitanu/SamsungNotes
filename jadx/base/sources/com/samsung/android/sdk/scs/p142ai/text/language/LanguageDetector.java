package com.samsung.android.sdk.scs.p142ai.text.language;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LanguageDetector {
    private static final String TAG = "ScsApi@LanguageDetector";
    private final boolean isLDSupported;
    private TextServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LanguageDetector(@NonNull Context context) {
        this.isLDSupported = Feature.checkFeature(context, "FEATURE_TEXT_DETECT_LANGUAGE") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$detect$0(String str) {
        String str2 = "";
        int length = str.length();
        if (length > 100000) {
            Log.m6489i(TAG, String.format("Language detect input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length), 100000, 100000));
            str = str.substring(0, 100000);
        }
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("string", str);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_DETECT_LANGUAGE, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "LanguageDetector.detect(). ContentResolver result is null!!");
                return "";
            }
            int i = bundleCall.getInt("resultCode");
            if (i != 1) {
                Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
                return "";
            }
            String string = bundleCall.getString(TextConst.KEY_DETECTED_LANGUAGE_TEXT);
            if (string != null) {
                try {
                    if (string.length() != 0) {
                        return string;
                    }
                } catch (Exception e) {
                    str2 = string;
                    e = e;
                    Log.m6488e(TAG, "Exception :: detect", e);
                    return str2;
                }
            }
            Log.m6487e(TAG, "null!! detectedLanguage: " + string);
            return "";
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Nullable
    public String detect(@NonNull String str) {
        if (!this.isLDSupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_DETECT_LANGUAGE not supported!");
            return "";
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC7766b(this, str, 8));
        try {
            try {
                return (String) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in detect : " + e.getMessage());
                return "";
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in detect : " + e2.getMessage());
                return "";
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }
}

package com.samsung.android.sdk.scs.p142ai.text.phrase;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import p012C1.CallableC0047c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyPhraseExtractor {
    public static final int EXTRA_HANDWRITING = 1;
    public static final int EXTRA_LOCATION = 2;
    public static final int EXTRA_TITLE = 0;
    private static final Set<String> SUPPORTED_LANGUAGE = (Set) Stream.of((Object[]) new String[]{"KO", "ZH", "EN", "DE", "FR", "ES", "IT"}).collect(Collectors.collectingAndThen(Collectors.toSet(), new C4662f(18)));
    private static final String TAG = "ScsApi@KeyPhraseExtractor";
    private final boolean isEventTitleGeneratorSupported;
    private TextServiceExecutor mServiceExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ActionType {
        MANUAL,
        AUTO
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExtractOptions {
        String actionType;
        Map<Integer, String> extraInfo;
        String language;
        String requestType;
        int topK;
        Map<String, Integer> userTags;

        public ExtractOptions(RequestType requestType, ActionType actionType) {
            this.requestType = requestType.name();
            this.actionType = actionType.name();
        }

        public String getActionType() {
            return this.actionType;
        }

        public Map<Integer, String> getExtraInfo() {
            return this.extraInfo;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getRequestType() {
            return this.requestType;
        }

        public int getTopK() {
            return this.topK;
        }

        public Map<String, Integer> getUserTags() {
            return this.userTags;
        }

        public ExtractOptions setExtraInfo(Map<Integer, String> map) {
            this.extraInfo = map;
            return this;
        }

        public ExtractOptions setLanguage(String str) {
            this.language = str;
            return this;
        }

        public ExtractOptions setTopK(int i) {
            this.topK = i;
            return this;
        }

        public ExtractOptions setUserTags(Map<String, Integer> map) {
            this.userTags = map;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestType {
        IMAGE_TAG,
        NOTE_TAG,
        NOTE_TITLE,
        EVENT_TITLE
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPhraseExtractor(@NonNull Context context) {
        this.isEventTitleGeneratorSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_KEY_PHRASE_EVENT_TITLE") == 0;
        initConnection(context);
    }

    private void initConnection(@NonNull Context context) {
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isSupported$0(RequestType requestType, String str) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString(TextConst.KEY_PARAM_REQUEST_TYPE, requestType.name());
            bundle.putString("language", str);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_KEY_PHRASE_SUPPORTED, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "KeyPhraseExtractor.isSupported(). ContentResolver result is null!!");
                return Boolean.FALSE;
            }
            if (bundleCall.isEmpty()) {
                Log.m6487e(TAG, "KeyPhraseExtractor.isSupported(). result is empty!! App version is lower than Sdk so just check in static Array");
                return Boolean.valueOf(SUPPORTED_LANGUAGE.contains(str.toUpperCase()));
            }
            int i = bundleCall.getInt("resultCode");
            if (i == 1) {
                return Boolean.valueOf(bundleCall.getBoolean(TextConst.KEY_TEXT_SUPPORTED_BOOLEAN));
            }
            Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
            return Boolean.FALSE;
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: isSupported", e);
            return Boolean.FALSE;
        }
    }

    @Nullable
    public Task<List<KeyPhrase>> extract(@NonNull String str, @NonNull ExtractOptions extractOptions) {
        Log.m6485d(TAG, "KeyPhraseExtractor extract");
        KeyPhraseExtractRunnable keyPhraseExtractRunnable = new KeyPhraseExtractRunnable(this.mServiceExecutor, extractOptions.requestType);
        int length = str.length();
        if (length > 100000) {
            Log.m6489i(TAG, String.format("KeyPhraseExtractor input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length), 100000, 100000));
            str = str.substring(0, 100000);
        }
        keyPhraseExtractRunnable.setText(str);
        keyPhraseExtractRunnable.setOptions(extractOptions);
        this.mServiceExecutor.execute(keyPhraseExtractRunnable);
        return keyPhraseExtractRunnable.getTask();
    }

    public boolean isSupported(@NonNull String str) {
        Log.m6485d(TAG, "KeyPhraseExtractor isSupported - language : " + str);
        return SUPPORTED_LANGUAGE.contains(str.toUpperCase());
    }

    public boolean isSupported(@NonNull RequestType requestType, @NonNull String str) {
        Boolean bool;
        Log.m6485d(TAG, "KeyPhraseExtractor isSupported - requestType : " + requestType.name() + ", language : " + str);
        if (!this.isEventTitleGeneratorSupported && requestType == RequestType.EVENT_TITLE) {
            return false;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC0047c(this, 6, requestType, str));
        try {
            try {
                bool = (Boolean) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in isSupported : " + e.getMessage());
                bool = Boolean.FALSE;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in isSupported : " + e2.getMessage());
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }
}

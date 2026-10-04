package com.samsung.android.sdk.scs.p142ai.text.event;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EventExtractor {
    private static final String TAG = "ScsApi@EventExtractor";
    private final boolean isEventExtractorSupported;
    private final boolean isEventHasYearMonthDaySupported;
    private final boolean isEventIndexSupported;
    private TextServiceExecutor mServiceExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SourceType {
        DEFAULT,
        TEXT_SELECTION
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EventExtractor(@NonNull Context context) {
        this.isEventExtractorSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_EVENT") == 0;
        this.isEventHasYearMonthDaySupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_EVENT_HAS_YEAR_MONTH_DAY") == 0;
        this.isEventIndexSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_EVENT_INDEX") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isSupported$0(String str) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_EVENT_SUPPORTED, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "EventExtractor.isSupported(). ContentResolver result is null!!");
                return Boolean.FALSE;
            }
            if (bundleCall.isEmpty()) {
                Log.m6487e(TAG, "EventExtractor.isSupported(). result is empty!!");
                return Boolean.FALSE;
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

    public Task<List<Event>> extract(@NonNull String str, @NonNull String str2, @NonNull SourceType sourceType) {
        Log.m6485d(TAG, "EventExtractor extract");
        EventExtractRunnable eventExtractRunnable = new EventExtractRunnable(this.mServiceExecutor);
        eventExtractRunnable.setLanguage(str);
        eventExtractRunnable.setText(str2);
        eventExtractRunnable.setSourceType(sourceType);
        eventExtractRunnable.setEventHasYearMonthDaySupported(this.isEventHasYearMonthDaySupported);
        eventExtractRunnable.setEventIndexSupported(this.isEventIndexSupported);
        this.mServiceExecutor.execute(eventExtractRunnable);
        return eventExtractRunnable.getTask();
    }

    public boolean isSupported(@NonNull String str) {
        Boolean bool;
        Log.m6485d(TAG, "EventExtractor isSupported - language : " + str);
        if (!this.isEventExtractorSupported) {
            return false;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC7766b(this, str, 2));
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

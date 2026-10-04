package com.samsung.android.sdk.scs.p142ai.text.reminder;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.sdk.scs.p142ai.text.reminder.ReminderEntity;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p012C1.CallableC0047c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ReminderEntityExtractor {
    private static final String TAG = "ScsApi@ReminderEntityExtractor";
    private final boolean isReminderEntityExtractorSupported;
    private final TextServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ReminderEntityExtractor(@NonNull Context context) {
        this.isReminderEntityExtractorSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_REMINDER_ENTITY") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isSupported$0(String str) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_REMINDER_ENTITY_SUPPORTED, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "ReminderEntityExtractor.isSupported(). ContentResolver result is null!!");
                return Boolean.FALSE;
            }
            if (bundleCall.isEmpty()) {
                Log.m6487e(TAG, "ReminderEntityExtractor.isSupported(). result is empty!!");
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$requestExtract$1(String str, String str2) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            bundle.putString("string", str2);
            return textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_REMINDER_ENTITY, (String) null, bundle);
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: requestExtract", e);
            return null;
        }
    }

    private Bundle requestExtract(String str, String str2) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC0047c(this, 7, str2, str));
        try {
            try {
                try {
                    return (Bundle) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    futureSubmit.cancel(true);
                    Log.m6487e(TAG, "Timeout in requestExtract : " + e.getMessage());
                    return null;
                }
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in requestExtract : " + e2.getMessage());
                return null;
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    @Nullable
    public ReminderEntity extract(@NonNull String str, @NonNull String str2) {
        Log.m6485d(TAG, "ReminderEntity extract - language: " + str2);
        if (!this.isReminderEntityExtractorSupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_REMINDER_ENTITY not supported!");
            return null;
        }
        Bundle bundleRequestExtract = requestExtract(str, str2);
        if (bundleRequestExtract == null) {
            Log.m6487e(TAG, "ReminderEntityExtractor.extract(). ContentResolver result is null!!");
            return null;
        }
        int i = bundleRequestExtract.getInt("resultCode");
        if (i == 1) {
            return new ReminderEntity(ReminderEntity.Place.valueOf(bundleRequestExtract.getString(TextConst.KEY_REMINDER_PLACE)), ReminderEntity.State.valueOf(bundleRequestExtract.getString(TextConst.KEY_REMINDER_STATE)), bundleRequestExtract.getInt(TextConst.KEY_START_INDEX), bundleRequestExtract.getInt(TextConst.KEY_END_INDEX));
        }
        AbstractC6670b.m4750k(i, "unexpected resultCode! resultCode: ", TAG);
        return null;
    }

    public boolean isSupported(@NonNull String str) {
        Boolean bool;
        Log.m6485d(TAG, "ReminderEntityExtractor isSupported - language : " + str);
        if (!this.isReminderEntityExtractorSupported) {
            return false;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC7766b(this, str, 3));
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

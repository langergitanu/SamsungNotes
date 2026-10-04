package com.samsung.android.sdk.scs.p142ai.text.event;

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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EventCategoryClassifier {
    private static final String TAG = "ScsApi@EventCategoryClassifier";
    private final boolean isCECSupported;
    private final TextServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EventCategoryClassifier(@NonNull Context context) {
        this.isCECSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_EVENT_CATEGORY") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$classify$0(ArrayList arrayList) {
        ArrayList<String> arrayList2 = null;
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("string", arrayList);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_EVENT_CATEGORY, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "EventCategoryClassifier.classify(). ContentResolver result is null!!");
                return null;
            }
            int i = bundleCall.getInt("resultCode");
            if (i != 1) {
                Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
                return null;
            }
            ArrayList<String> stringArrayList = bundleCall.getStringArrayList(TextConst.KEY_EVENT_CATEGORY_LIST);
            if (stringArrayList != null) {
                return stringArrayList;
            }
            try {
                Log.m6487e(TAG, "null!!");
                return null;
            } catch (Exception e) {
                arrayList2 = stringArrayList;
                e = e;
                Log.m6488e(TAG, "Exception :: classify", e);
                return arrayList2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Nullable
    public List<String> classify(@NonNull ArrayList<String> arrayList) {
        if (!this.isCECSupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_EVENT_CATEGORY not supported!");
            return null;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC7766b(this, arrayList, 1));
        try {
            try {
                return (List) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in classify : " + e.getMessage());
                return null;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in classify : " + e2.getMessage());
                return null;
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }
}

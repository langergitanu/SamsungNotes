package com.samsung.android.sdk.scs.p142ai.text.unit;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UnitConverter {
    private static final String TAG = "ScsApi@UnitConverter";
    private final boolean isUnitConverterSupported;
    private final TextServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public UnitConverter(@NonNull Context context) {
        this.isUnitConverterSupported = Feature.checkFeature(context, "FEATURE_TEXT_CONVERT_UNIT") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    private Bundle getBundleFromInput(String str) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC7766b(this, str, 9));
        try {
            try {
                return (Bundle) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in getSupportedSymbolList:getBundleFromInput : " + e.getMessage());
                return null;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in getSupportedSymbolList:getBundleFromInput : " + e2.getMessage());
                return null;
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    private Quantity getQuantityFromBundle(Bundle bundle) {
        try {
            if (bundle == null) {
                Log.m6487e(TAG, "UnitConverter.convert(). ContentResolver result is null!");
                return new Quantity();
            }
            int i = bundle.getInt("resultCode");
            if (i != 1) {
                Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
                return new Quantity();
            }
            String string = bundle.getString(TextConst.KEY_UNIT_TYPE);
            String string2 = bundle.getString(TextConst.KEY_UNIT_NAME);
            String string3 = bundle.getString(TextConst.KEY_UNIT_SYMBOL);
            BigDecimal bigDecimal = (BigDecimal) bundle.getSerializable(TextConst.KEY_UNIT_VALUE);
            if (string != null && string2 != null && string3 != null && bigDecimal != null) {
                return new Quantity(string, string2, string3, bigDecimal);
            }
            Log.m6487e(TAG, "null!! type: " + string + ", name: " + string2 + ", symbol: " + string3 + ", value: " + bigDecimal);
            return new Quantity();
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception: getQuantityFromBundle", e);
            return new Quantity();
        }
    }

    private List<String> getSymbolListFromBundle(Bundle bundle) {
        try {
            if (bundle == null) {
                Log.m6487e(TAG, "UnitConverter.getSupportedSymbolList(). ContentResolver result is null!");
                return Collections.EMPTY_LIST;
            }
            int i = bundle.getInt("resultCode");
            if (i != 1) {
                Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
                return Collections.EMPTY_LIST;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(TextConst.KEY_SYMBOL_LIST);
            if (stringArrayList != null) {
                return stringArrayList;
            }
            Log.m6487e(TAG, "null!! symbolList: " + stringArrayList);
            return Collections.EMPTY_LIST;
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception: getSymbolListFromBundle", e);
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$getBundleFromInput$0(String str) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            return textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_SUPPORTED_UNIT, (String) null, bundle);
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception: getSupportedSymbolList getBundleFromInput", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$getBundleFromInput$1(BigDecimal bigDecimal, String str, String str2, String str3) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putSerializable(TextConst.KEY_PARAM_NUMBER, bigDecimal);
            bundle.putString("source", str);
            bundle.putString("target", str2);
            bundle.putString("country", str3);
            return textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_CONVERT_UNIT, (String) null, bundle);
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception: convert getBundleFromInput", e);
            return null;
        }
    }

    @Nullable
    public Quantity convert(@NonNull BigDecimal bigDecimal, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        Log.m6485d(TAG, "UnitConverter convert - country : " + str3);
        if (this.isUnitConverterSupported) {
            return getQuantityFromBundle(getBundleFromInput(bigDecimal, str, str2, str3));
        }
        Log.m6487e(TAG, "Feature.FEATURE_TEXT_CONVERT_UNIT not supported!");
        return new Quantity();
    }

    @Nullable
    public List<String> getSupportedSymbolList(@NonNull String str) {
        Log.m6485d(TAG, "UnitConverter getSupportedSymbolList");
        if (this.isUnitConverterSupported) {
            return getSymbolListFromBundle(getBundleFromInput(str));
        }
        Log.m6487e(TAG, "Feature.FEATURE_TEXT_CONVERT_UNIT not supported!");
        return Collections.EMPTY_LIST;
    }

    private Bundle getBundleFromInput(final BigDecimal bigDecimal, final String str, final String str2, final String str3) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: o2.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f9641a.lambda$getBundleFromInput$1(bigDecimal, str, str2, str3);
            }
        });
        try {
            try {
                try {
                    Bundle bundle = (Bundle) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
                    executorServiceNewSingleThreadExecutor.shutdownNow();
                    return bundle;
                } catch (Exception e) {
                    Log.m6487e(TAG, "Exception occurred in convert:getBundleFromInput : " + e.getMessage());
                    executorServiceNewSingleThreadExecutor.shutdownNow();
                    return null;
                }
            } catch (TimeoutException e2) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in convert:getBundleFromInput : " + e2.getMessage());
                executorServiceNewSingleThreadExecutor.shutdownNow();
                return null;
            }
        } catch (Throwable th) {
            executorServiceNewSingleThreadExecutor.shutdownNow();
            throw th;
        }
    }
}

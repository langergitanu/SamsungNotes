package com.samsung.android.sdk.scs.p142ai.text.category;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.material.color.utilities.C4662f;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import p001A.AbstractC0000a;
import p012C1.CallableC0047c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DocumentCategoryClassifier {
    private static final Set<String> SUPPORTED_COUNTRY = (Set) Stream.of((Object[]) new String[]{AbstractDevicePopManager.CertificateProperties.COUNTRY, Constants.GIGABYTE, "CA", "KR"}).collect(Collectors.collectingAndThen(Collectors.toSet(), new C4662f(18)));
    private static final String TAG = "ScsApi@DocumentCategoryClassifier";
    private final boolean isDocumentCategoryClassifierSupported;
    private TextServiceExecutor mServiceExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ClassifyOptions {
        String country;
        String language;
        String requestType;

        public ClassifyOptions(RequestType requestType) {
            this.requestType = requestType.name();
        }

        public String getCountry() {
            return this.country;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getRequestType() {
            return this.requestType;
        }

        public ClassifyOptions setCountry(String str) {
            this.country = str;
            return this;
        }

        public ClassifyOptions setLanguage(String str) {
            this.language = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestType {
        MESSAGE,
        NOTIFICATION
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DocumentCategoryClassifier(@NonNull Context context) {
        this.isDocumentCategoryClassifierSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_DOCUMENT_CATEGORY") == 0;
        initConnection(context);
    }

    private void initConnection(@NonNull Context context) {
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$classifySynchronously$2(String str, ClassifyOptions classifyOptions) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(str);
        String language = classifyOptions.getLanguage() != null ? classifyOptions.getLanguage() : Locale.getDefault().getLanguage();
        Bundle bundleCall = null;
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", language);
            bundle.putString(TextConst.KEY_PARAM_REQUEST_TYPE, classifyOptions.getRequestType());
            bundle.putString("country", classifyOptions.getCountry());
            bundle.putStringArrayList("string", arrayList2);
            bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_CATEGORY_CLASSIFY, (String) null, bundle);
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: classifySynchronously ", e);
        }
        if (bundleCall == null) {
            Log.m6487e(TAG, "DocumentCategoryClassifier.classify(). ContentResolver result is null!!");
            return arrayList;
        }
        int i = bundleCall.getInt("resultCode");
        if (i != 1) {
            AbstractC6670b.m4750k(i, "unexpected resultCode!!! resultCode: ", TAG);
            return arrayList;
        }
        long[] longArray = bundleCall.getLongArray(TextConst.KEY_DOCUMENT_CATEGORY_ID_ARRAY);
        ArrayList<String> stringArrayList = bundleCall.getStringArrayList(TextConst.KEY_DOCUMENT_CATEGORY_NAME_LIST);
        double[] doubleArray = bundleCall.getDoubleArray(TextConst.KEY_DOCUMENT_CATEGORY_SCORE_ARRAY);
        if (longArray == null || stringArrayList == null || doubleArray == null) {
            Log.m6487e(TAG, "null!! categoryIdArray: " + Arrays.toString(longArray) + ", categoryNameList: " + stringArrayList + ", categoryScoreArray: " + Arrays.toString(doubleArray));
            return arrayList;
        }
        int length = longArray.length;
        if (length != stringArrayList.size() || length != doubleArray.length) {
            StringBuilder sbM778t = AbstractC0541b.m778t(length, "unexpected size!!! : ", " vs ");
            sbM778t.append(stringArrayList.size());
            sbM778t.append(" vs ");
            sbM778t.append(doubleArray.length);
            Log.m6487e(TAG, sbM778t.toString());
            return arrayList;
        }
        for (int i2 = 0; i2 < length; i2++) {
            DocumentCategory documentCategory = new DocumentCategory();
            documentCategory.setId(Long.valueOf(longArray[i2]));
            documentCategory.setName(stringArrayList.get(i2));
            documentCategory.setScore(doubleArray[i2]);
            arrayList.add(documentCategory);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map lambda$getCategoryInfo$1(RequestType requestType, String str) {
        HashMap map = new HashMap();
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString(TextConst.KEY_PARAM_REQUEST_TYPE, requestType.name());
            bundle.putString("language", str);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_CATEGORY_INFO, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "DocumentCategoryClassifier.getCategoryInfo(). ContentResolver result is null!!");
                return null;
            }
            int i = bundleCall.getInt("resultCode");
            if (i != 1) {
                Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
                return null;
            }
            long[] longArray = bundleCall.getLongArray(TextConst.KEY_DOCUMENT_CATEGORY_ID_ARRAY);
            ArrayList<String> stringArrayList = bundleCall.getStringArrayList(TextConst.KEY_DOCUMENT_CATEGORY_NAME_LIST);
            if (longArray != null && stringArrayList != null) {
                int length = longArray.length;
                if (length == stringArrayList.size()) {
                    for (int i2 = 0; i2 < length; i2++) {
                        map.put(stringArrayList.get(i2), Long.valueOf(longArray[i2]));
                    }
                    return map;
                }
                Log.m6487e(TAG, "unexpected size!!! : " + length + " vs " + stringArrayList.size());
                return null;
            }
            Log.m6487e(TAG, "null!! categoryIdArray: " + Arrays.toString(longArray) + ", categoryNameList: " + stringArrayList);
            return null;
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: getCategoryInfo", e);
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isSupported$0(RequestType requestType, String str, String str2) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString(TextConst.KEY_PARAM_REQUEST_TYPE, requestType.name());
            bundle.putString("language", str);
            bundle.putString("country", str2);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_CATEGORY_SUPPORTED, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "DocumentCategory.isSupported(). ContentResolver result is null!!");
                return Boolean.FALSE;
            }
            if (bundleCall.isEmpty()) {
                Log.m6487e(TAG, "DocumentCategory.isSupported(). result is empty!! App version is lower than Sdk so just check in static Array");
                return (requestType != RequestType.MESSAGE || str2 == null) ? Boolean.FALSE : Boolean.valueOf(SUPPORTED_COUNTRY.contains(str2.toUpperCase()));
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
    public Task<List<DocumentCategory>> classify(@NonNull String str, @NonNull ClassifyOptions classifyOptions) {
        Log.m6485d(TAG, "DocumentCategory classify for singleDocument");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        return classify(arrayList, classifyOptions);
    }

    @Nullable
    public List<DocumentCategory> classifySynchronously(@NonNull String str, @NonNull ClassifyOptions classifyOptions) {
        List<DocumentCategory> list = Collections.EMPTY_LIST;
        Log.m6485d(TAG, "DocumentCategory classify synchronously for singleDocument");
        if (!this.isDocumentCategoryClassifierSupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_DOCUMENT_CATEGORY not supported!");
            return list;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC0047c(this, 4, str, classifyOptions));
        try {
            try {
                return (List) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in classifySynchronously : " + e.getMessage());
                List list2 = Collections.EMPTY_LIST;
                return list;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in classifySynchronously : " + e2.getMessage());
                List list3 = Collections.EMPTY_LIST;
                return list;
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    @Nullable
    public Map<String, Long> getCategoryInfo(@NonNull RequestType requestType, @NonNull String str) {
        Log.m6485d(TAG, "DocumentCategory getCategoryInfo - language : " + str);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC0047c(this, 5, requestType, str));
        try {
            try {
                return (Map) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout getCategoryInfo : " + e.getMessage());
                return null;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in getCategoryInfo : " + e2.getMessage());
                return null;
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    @Nullable
    public Task<List<DocumentSimilarity>> isSimilar(@NonNull String str, @NonNull ArrayList<String> arrayList, @NonNull ClassifyOptions classifyOptions) {
        Log.m6485d(TAG, "DocumentCategory isSimilar for multiple target");
        SimilarityRunnable similarityRunnable = new SimilarityRunnable(this.mServiceExecutor);
        int length = str.length();
        if (length > 100000) {
            Log.m6489i(TAG, String.format("DocumentCategory isSimilar source input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length), 100000, 100000));
            str = str.substring(length - 100000, length);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String strSubstring : arrayList) {
            int length2 = strSubstring.length();
            if (length2 > 100000) {
                Log.m6489i(TAG, String.format("DocumentCategory isSimilar target input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length2), 100000, 100000));
                strSubstring = strSubstring.substring(length2 - 100000, length2);
            }
            arrayList2.add(strSubstring);
        }
        similarityRunnable.setSourceText(str);
        similarityRunnable.setTargetTextList(arrayList2);
        similarityRunnable.setOptions(classifyOptions);
        this.mServiceExecutor.execute(similarityRunnable);
        return similarityRunnable.getTask();
    }

    public boolean isSupported(@NonNull final RequestType requestType, final String str, final String str2) {
        Boolean bool;
        StringBuilder sbM16m = AbstractC0000a.m16m("DocumentCategory isSupported - requestType : ", requestType.name(), ", language : ", str, ", country : ");
        sbM16m.append(str2);
        Log.m6485d(TAG, sbM16m.toString());
        if (!this.isDocumentCategoryClassifierSupported && requestType == RequestType.MESSAGE) {
            return false;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: com.samsung.android.sdk.scs.ai.text.category.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5220a.lambda$isSupported$0(requestType, str, str2);
            }
        });
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

    @Nullable
    public Task<List<DocumentCategory>> classify(@NonNull ArrayList<String> arrayList, @NonNull ClassifyOptions classifyOptions) {
        Log.m6485d(TAG, "DocumentCategory classify for multiDocuments");
        CategoryClassifyRunnable categoryClassifyRunnable = new CategoryClassifyRunnable(this.mServiceExecutor);
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String strSubstring : arrayList) {
            if (strSubstring != null) {
                int length = strSubstring.length();
                if (length > 100000) {
                    Log.m6489i(TAG, String.format("DocumentCategory classify input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length), 100000, 100000));
                    strSubstring = strSubstring.substring(length - 100000, length);
                }
                arrayList2.add(strSubstring);
            }
        }
        categoryClassifyRunnable.setTextList(arrayList2);
        categoryClassifyRunnable.setOptions(classifyOptions);
        this.mServiceExecutor.execute(categoryClassifyRunnable);
        return categoryClassifyRunnable.getTask();
    }
}

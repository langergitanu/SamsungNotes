package com.samsung.android.sdk.scs.p142ai.text.bnlp;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BasicNlpAnalyzer {
    private static final Set<String> SUPPORTED_LANGUAGE = (Set) Stream.of((Object[]) new String[]{"EN", "DE", "ES", "FR", "IT", "KO", "ZH"}).collect(Collectors.collectingAndThen(Collectors.toSet(), new C4662f(18)));
    private static final String TAG = "ScsApi@BasicNlpAnalyzer";
    private final boolean isBnlpSupported;
    private final boolean isBnlpTokenSupported;
    private TextServiceExecutor mServiceExecutor;

    public BasicNlpAnalyzer(@NonNull Context context) {
        this.isBnlpSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_BNLP") == 0;
        this.isBnlpTokenSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_BNLP_TOKEN") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    private List<Sentence> analyzeCore(@NonNull String str, @NonNull String str2, boolean z) {
        ArrayList arrayList = new ArrayList();
        Bundle bundleRequestAnalyze = requestAnalyze(str, str2, z, false, false);
        if (bundleRequestAnalyze == null) {
            Log.m6487e(TAG, "BasicNlpAnalyzer.analyze(). ContentResolver result is null!");
            return arrayList;
        }
        int i = bundleRequestAnalyze.getInt("resultCode");
        if (i != 1) {
            AbstractC6670b.m4750k(i, "unexpected resultCode!!! resultCode: ", TAG);
            return arrayList;
        }
        ArrayList<String> stringArrayList = bundleRequestAnalyze.getStringArrayList(TextConst.KEY_SENTENCE_RAW_TEXT_LIST);
        ArrayList<Integer> integerArrayList = bundleRequestAnalyze.getIntegerArrayList(TextConst.KEY_SENTENCE_POSITION_LIST);
        ArrayList arrayList2 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_WORD_RAW_TEXT_LIST);
        ArrayList arrayList3 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_WORD_POSITION_LIST);
        ArrayList arrayList4 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_TOKEN_RAW_TEXT_LIST);
        ArrayList arrayList5 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_TOKEN_POSITION_LIST);
        ArrayList arrayList6 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_TOKEN_POS_TAG_LIST);
        ArrayList arrayList7 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_TOKEN_STEM_LIST);
        ArrayList arrayList8 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_TOKEN_LEMMA_LIST);
        ArrayList arrayList9 = (ArrayList) bundleRequestAnalyze.getSerializable(TextConst.KEY_TOKEN_MP_TAGS_LIST);
        if (stringArrayList == null || integerArrayList == null || arrayList2 == null || arrayList3 == null || arrayList4 == null || arrayList5 == null || arrayList6 == null) {
            Log.m6487e(TAG, "null!! sentenceRawTextList: " + stringArrayList + ", sentencePositionList: " + integerArrayList + ", wordRawTextList: " + arrayList2 + ", wordPositionList: " + arrayList3 + ", tokenRawTextList: " + arrayList4 + ", tokenPositionList: " + arrayList5 + ", tokenPosTagList: " + arrayList6);
            return arrayList;
        }
        int size = integerArrayList.size();
        int i2 = 0;
        while (i2 < size) {
            ArrayList arrayList10 = (ArrayList) arrayList2.get(i2);
            ArrayList arrayList11 = (ArrayList) arrayList3.get(i2);
            ArrayList arrayList12 = (ArrayList) arrayList4.get(i2);
            int i4 = size;
            ArrayList arrayList13 = (ArrayList) arrayList5.get(i2);
            ArrayList arrayList14 = arrayList6;
            ArrayList arrayList15 = (ArrayList) arrayList6.get(i2);
            ArrayList arrayList16 = arrayList7;
            ArrayList arrayList17 = (ArrayList) arrayList7.get(i2);
            ArrayList arrayList18 = arrayList8;
            ArrayList arrayList19 = (ArrayList) arrayList8.get(i2);
            ArrayList arrayList20 = arrayList9;
            ArrayList arrayList21 = (ArrayList) arrayList9.get(i2);
            ArrayList arrayList22 = arrayList5;
            ArrayList arrayList23 = new ArrayList();
            ArrayList arrayList24 = arrayList4;
            int size2 = arrayList11.size();
            ArrayList arrayList25 = arrayList3;
            int i5 = 0;
            while (i5 < size2) {
                int i6 = size2;
                ArrayList arrayList26 = (ArrayList) arrayList12.get(i5);
                ArrayList arrayList27 = arrayList13;
                ArrayList arrayList28 = (ArrayList) arrayList13.get(i5);
                ArrayList arrayList29 = arrayList15;
                ArrayList arrayList30 = (ArrayList) arrayList15.get(i5);
                ArrayList arrayList31 = arrayList17;
                ArrayList arrayList32 = (ArrayList) arrayList17.get(i5);
                ArrayList arrayList33 = arrayList19;
                ArrayList arrayList34 = (ArrayList) arrayList19.get(i5);
                ArrayList arrayList35 = arrayList21;
                ArrayList arrayList36 = (ArrayList) arrayList21.get(i5);
                ArrayList arrayList37 = arrayList12;
                ArrayList arrayList38 = new ArrayList();
                ArrayList arrayList39 = arrayList2;
                int size3 = arrayList28.size();
                ArrayList arrayList40 = arrayList;
                for (int i7 = 0; i7 < size3; i7++) {
                    arrayList38.add(new Token((String) arrayList26.get(i7), ((Integer) arrayList28.get(i7)).intValue(), (String) arrayList30.get(i7), (String) arrayList32.get(i7), (String) arrayList34.get(i7), (String) arrayList36.get(i7)));
                }
                arrayList23.add(new Word((String) arrayList10.get(i5), ((Integer) arrayList11.get(i5)).intValue(), arrayList38));
                i5++;
                arrayList12 = arrayList37;
                size2 = i6;
                arrayList13 = arrayList27;
                arrayList15 = arrayList29;
                arrayList17 = arrayList31;
                arrayList19 = arrayList33;
                arrayList21 = arrayList35;
                arrayList2 = arrayList39;
                arrayList = arrayList40;
            }
            ArrayList arrayList41 = arrayList;
            arrayList41.add(new Sentence(stringArrayList.get(i2), integerArrayList.get(i2).intValue(), arrayList23));
            i2++;
            size = i4;
            arrayList6 = arrayList14;
            arrayList = arrayList41;
            arrayList5 = arrayList22;
            arrayList7 = arrayList16;
            arrayList8 = arrayList18;
            arrayList9 = arrayList20;
            arrayList4 = arrayList24;
            arrayList3 = arrayList25;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isSupportedLanguage$0(String str) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_BNLP_SUPPORTED, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "BasicNlpAnalyzer.isSupported(). ContentResolver result is null!!");
                return Boolean.FALSE;
            }
            if (bundleCall.isEmpty()) {
                Log.m6487e(TAG, "BasicNlpAnalyzer.isSupported(). result is empty!! App version is lower than Sdk so just check in static Array");
                return Boolean.valueOf(SUPPORTED_LANGUAGE.contains(str.toUpperCase()));
            }
            int i = bundleCall.getInt("resultCode");
            if (i == 1) {
                return Boolean.valueOf(bundleCall.getBoolean(TextConst.KEY_TEXT_SUPPORTED_BOOLEAN));
            }
            Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
            return Boolean.FALSE;
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: isSupportedLanguage", e);
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$requestAnalyze$1(String str, String str2, boolean z, boolean z2, boolean z3) {
        try {
            int length = str.length();
            if (length > 100000) {
                Log.m6489i(TAG, String.format("BasicNLP input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length), 100000, 100000));
                str = str.substring(0, 100000);
            }
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", str2);
            bundle.putString("string", str);
            bundle.putBoolean(TextConst.KEY_PARAM_KEEP_SYLLABLE, z);
            bundle.putBoolean(TextConst.KEY_PARAM_LIGHT_MODEL, z2);
            Uri uri = Uri.parse(TextConst.URI_STRING);
            return z3 ? textContentResolver.call(uri, TextConst.METHOD_GET_BNLP_TOKEN, (String) null, bundle) : textContentResolver.call(uri, TextConst.METHOD_GET_BNLP, (String) null, bundle);
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: requestAnalyze", e);
            return null;
        }
    }

    private Bundle requestAnalyze(final String str, final String str2, final boolean z, final boolean z2, final boolean z3) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: com.samsung.android.sdk.scs.ai.text.bnlp.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5211a.lambda$requestAnalyze$1(str2, str, z, z3, z2);
            }
        });
        try {
            try {
                Bundle bundle = (Bundle) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
                executorServiceNewSingleThreadExecutor.shutdownNow();
                return bundle;
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in requestAnalyze : " + e.getMessage());
                executorServiceNewSingleThreadExecutor.shutdownNow();
                return null;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in requestAnalyze : " + e2.getMessage());
                executorServiceNewSingleThreadExecutor.shutdownNow();
                return null;
            }
        } catch (Throwable th) {
            executorServiceNewSingleThreadExecutor.shutdownNow();
            throw th;
        }
    }

    @Nullable
    public List<Sentence> analyze(@NonNull String str, @NonNull String str2) {
        Log.m6485d(TAG, "BasicNLP analyze - language : " + str);
        if (this.isBnlpSupported) {
            return analyzeCore(str, str2, false);
        }
        Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_BNLP not supported!");
        return new ArrayList();
    }

    @Nullable
    public List<Token> analyzeToken(@NonNull String str, @NonNull String str2) {
        return analyzeToken(str, str2, false);
    }

    public boolean isSupportedLanguage(@NonNull String str) {
        Boolean bool;
        Log.m6485d(TAG, "BasicNlpAnalyzer isSupportedLanguage : " + str);
        if (!this.isBnlpSupported) {
            return false;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC7766b(this, str, 0));
        try {
            try {
                bool = (Boolean) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                futureSubmit.cancel(true);
                Log.m6487e(TAG, "Timeout in isSupportedLanguage : " + e.getMessage());
                bool = Boolean.FALSE;
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in isSupportedLanguage : " + e2.getMessage());
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    @Nullable
    public List<Token> analyzeToken(@NonNull String str, @NonNull String str2, boolean z) {
        return analyzeToken(str, str2, z, false);
    }

    @Nullable
    public List<Token> analyzeToken(@NonNull String str, @NonNull String str2, boolean z, boolean z2) {
        Log.m6485d(TAG, "BasicNLP analyzeToken - language : " + str);
        ArrayList arrayList = new ArrayList();
        if (!this.isBnlpTokenSupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_BNLP_TOKEN not supported!");
            return arrayList;
        }
        Bundle bundleRequestAnalyze = requestAnalyze(str, str2, z, true, z2);
        if (bundleRequestAnalyze == null) {
            Log.m6487e(TAG, "BasicNlpAnalyzer.analyzeToken(). ContentResolver result is null!");
            return arrayList;
        }
        int i = bundleRequestAnalyze.getInt("resultCode");
        if (i != 1) {
            AbstractC6670b.m4750k(i, "unexpected resultCode!!! resultCode: ", TAG);
            return arrayList;
        }
        ArrayList<String> stringArrayList = bundleRequestAnalyze.getStringArrayList(TextConst.KEY_TOKEN_RAW_TEXT_LIST);
        ArrayList<Integer> integerArrayList = bundleRequestAnalyze.getIntegerArrayList(TextConst.KEY_TOKEN_POSITION_LIST);
        ArrayList<String> stringArrayList2 = bundleRequestAnalyze.getStringArrayList(TextConst.KEY_TOKEN_POS_TAG_LIST);
        ArrayList<String> stringArrayList3 = bundleRequestAnalyze.getStringArrayList(TextConst.KEY_TOKEN_STEM_LIST);
        ArrayList<String> stringArrayList4 = bundleRequestAnalyze.getStringArrayList(TextConst.KEY_TOKEN_LEMMA_LIST);
        ArrayList<String> stringArrayList5 = bundleRequestAnalyze.getStringArrayList(TextConst.KEY_TOKEN_MP_TAGS_LIST);
        if (stringArrayList != null && integerArrayList != null && stringArrayList2 != null && stringArrayList3 != null && stringArrayList4 != null && stringArrayList5 != null) {
            int size = integerArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new Token(stringArrayList.get(i2), integerArrayList.get(i2).intValue(), stringArrayList2.get(i2), stringArrayList3.get(i2), stringArrayList4.get(i2), stringArrayList5.get(i2)));
            }
            return arrayList;
        }
        Log.m6487e(TAG, "null!! tokenRawTextList: " + stringArrayList + ", tokenPositionList: " + integerArrayList + ", tokenPosTagList: " + stringArrayList2 + ", tokenStemList: " + stringArrayList3 + ", tokenLemmaList: " + stringArrayList4 + ", tokenMpTagsList: " + stringArrayList5);
        return arrayList;
    }

    @Nullable
    public List<Sentence> analyze(@NonNull String str, @NonNull String str2, boolean z) {
        Log.m6485d(TAG, "BasicNLP analyze keepSyllable - language : " + str);
        if (!this.isBnlpTokenSupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_BNLP_TOKEN not supported!");
            return new ArrayList();
        }
        return analyzeCore(str, str2, z);
    }
}

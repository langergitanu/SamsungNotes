package com.samsung.android.support.senl.p148nt.model.collector.common;

import android.annotation.SuppressLint;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"RestrictedApi"})
public class CollectFeature {
    private static final String TAG;
    private static final ExecutorService mExecutor;
    private static int sStatusCode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeyPhraseCollectSupportedCallable implements Callable {
        public /* synthetic */ KeyPhraseCollectSupportedCallable(int i) {
            this();
        }

        private KeyPhraseCollectSupportedCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(CollectFeature.getIsKeyPhraseCollectSupported());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeyPhraseCollectSupportedLanguageCallable implements Callable {
        public /* synthetic */ KeyPhraseCollectSupportedLanguageCallable(int i) {
            this();
        }

        private KeyPhraseCollectSupportedLanguageCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            String language = LocaleUtils.getLocale(BaseUtils.getApplicationContext().getResources().getConfiguration()).getLanguage();
            boolean zIsSupported = AiServices.getKeyPhraseExtractor(BaseUtils.getContext()).isSupported(language);
            DataLogger.m12302d(CollectFeature.TAG, "KeyPhraseCollectSupportedLanguageCallable, result/language : " + zIsSupported + "/" + language);
            return Boolean.valueOf(zIsSupported);
        }
    }

    static {
        String strCreateTag = CollectLogger.createTag("CollectFeature");
        TAG = strCreateTag;
        sStatusCode = -1000;
        mExecutor = AbstractC4539a.m3201k(strCreateTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getIsKeyPhraseCollectSupported() {
        if (sStatusCode == -1000) {
            try {
                sStatusCode = Feature.checkFeature(BaseUtils.getApplicationContext(), "FEATURE_TEXT_GET_KEY_PHRASE");
            } catch (NoClassDefFoundError e) {
                DataLogger.m12303e(TAG, "KeyPhraseCollectSupportedCallable, NoClassDefFoundError] " + e.getMessage());
            } catch (NoSuchMethodError e2) {
                DataLogger.m12303e(TAG, "KeyPhraseCollectSupportedCallable, NoSuchMethodError] " + e2.getMessage());
            }
            DataLogger.m12302d(TAG, "KeyPhraseCollectSupportedCallable, sStatusCode/version scs-api : " + sStatusCode + "/" + Feature.getScsVersionName(BaseUtils.getApplicationContext()) + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + Feature.getApiVersionName());
        }
        return sStatusCode == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized boolean isKeyPhraseCollectSupported() {
        boolean zBooleanValue;
        zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) ((FutureTask) mExecutor.submit(new KeyPhraseCollectSupportedCallable(0 == true ? 1 : 0))).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            DataLogger.m12303e(TAG, "isKeyPhraseCollectSupported# " + e.getMessage());
        }
        return zBooleanValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized boolean isKeyPhraseCollectSupportedLanguage() {
        boolean zBooleanValue;
        zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) ((FutureTask) mExecutor.submit(new KeyPhraseCollectSupportedLanguageCallable(0 == true ? 1 : 0))).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            DataLogger.m12303e(TAG, "isKeyPhraseCollectSupportedLanguage# " + e.getMessage());
        }
        return zBooleanValue;
    }
}

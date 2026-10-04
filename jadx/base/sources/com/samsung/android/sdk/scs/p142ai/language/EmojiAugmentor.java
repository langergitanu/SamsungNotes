package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.app.notes.sync.importing.core.types.C6776b;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.EmojiAugmentationServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.OnDeviceServiceExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p017D1.C0061b;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EmojiAugmentor {
    private static final String TAG = "EmojiAugmentor";
    private final String featureName = "FEATURE_AI_GEN_EMOJI_AUGMENTATION";
    private final EmojiAugmentationServiceExecutor mServiceExecutor;
    private final OnDeviceServiceExecutor onDeviceServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EmojiAugmentor(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mServiceExecutor = new EmojiAugmentationServiceExecutor(context);
        this.onDeviceServiceExecutor = new OnDeviceServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emojiAugment$0(AppInfo appInfo, String str, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().augmentWithHeader3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
        this.onDeviceServiceExecutor.deInit();
    }

    public Task<Result> emojiAugment(AppInfo appInfo, @NonNull String str) {
        return emojiAugment(appInfo, str, new HashMap());
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_EMOJI_AUGMENTATION", false, new C4191n(this, 6), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C0061b(this, 28));
    }

    @Deprecated
    public void unLoadOndeviceModel(AppInfo appInfo) {
        this.onDeviceServiceExecutor.execute(new OnDeviceRunnable(this.onDeviceServiceExecutor));
    }

    public Task<Result> emojiAugment(AppInfo appInfo, @NonNull String str, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_EMOJI_AUGMENTATION", appInfo.isStreamingMode(), new C6776b(4, this, appInfo, str, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}

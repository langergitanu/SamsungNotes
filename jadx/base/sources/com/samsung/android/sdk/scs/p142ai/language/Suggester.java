package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.app.notes.sync.importing.core.types.C6776b;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import com.samsung.android.sdk.scs.p142ai.language.service.SuggestionServiceExecutor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Suggester {
    private static final String TAG = "Suggester";
    private final String featureName = "FEATURE_AI_GEN_SUGGESTION";
    private final SuggestionServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Suggester(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mServiceExecutor = new SuggestionServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$5(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportGeneration$3(AppInfo appInfo, String str, String str2, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().reportGeneration(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, str2, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$suggestion$0(AppInfo appInfo, String str, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().suggestionWithHeader(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$suggestion$1(AppInfo.RequestType requestType, AppInfo appInfo, String str, SuggestionCategory suggestionCategory, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            if (requestType == AppInfo.RequestType.CLOUD) {
                this.mServiceExecutor.getService().suggestionWithCategory(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, suggestionCategory.getName(), llmServiceObserver2, map);
            } else {
                this.mServiceExecutor.getService().suggestionWithHeaderOnDevice(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, suggestionCategory.getName(), llmServiceObserver2, map);
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$suggestion$2(SuggestionInputParams suggestionInputParams, AppInfo appInfo, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            Context context = this.mServiceExecutor.context;
            ParcelFileDescriptor parcelFileDescriptorOpen = null;
            if (suggestionInputParams.getData() != null) {
                File file = new File(context.getFilesDir().getAbsolutePath(), "suggest_image");
                if (file.exists() || file.mkdirs()) {
                    File file2 = new File(file, "suggest_image_file");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            fileOutputStream.write(suggestionInputParams.getData());
                            parcelFileDescriptorOpen = ParcelFileDescriptor.open(file2, 268435456);
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (IOException e) {
                        Log.m6487e(TAG, "datafile failure: " + e.getMessage());
                    }
                } else {
                    Log.m6485d(TAG, "suggest_image folder creation failed");
                }
            }
            this.mServiceExecutor.getService().suggestionMultiModal(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), suggestionInputParams.getInputText(), suggestionInputParams.getCategory().getName(), suggestionInputParams.getDataMimeType(), parcelFileDescriptorOpen, llmServiceObserver2, map);
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        if (Feature.checkFeature(this.mServiceExecutor.context, "FEATURE_AI_GEN_SUGGESTION_ONDEVICE") != 0) {
            this.mServiceExecutor.deInit();
            return;
        }
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_SUGGESTION", false, new C4191n(this, 10), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C7737b(this, 2));
    }

    @NonNull
    public Task<Result> reportGeneration(@NonNull AppInfo appInfo, @NonNull String str, @NonNull String str2, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_SUGGESTION", appInfo.isStreamingMode(), new C7736a(this, appInfo, str, str2, map, 8), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> suggestion(AppInfo appInfo, @NonNull String str) {
        return suggestion(appInfo, str, new HashMap());
    }

    public Task<Result> suggestion(AppInfo appInfo, @NonNull String str, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_AI_GEN_SUGGESTION", appInfo.isStreamingMode(), new C6776b(7, this, appInfo, str, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> suggestion(AppInfo appInfo, @NonNull String str, SuggestionCategory suggestionCategory) {
        return suggestion(appInfo, str, suggestionCategory, new HashMap());
    }

    public Task<Result> suggestion(AppInfo appInfo, @NonNull String str, SuggestionCategory suggestionCategory, @NonNull Map<String, String> map) {
        AppInfo.RequestType requestType = appInfo.getRequestType();
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(requestType == AppInfo.RequestType.CLOUD ? "FEATURE_AI_GEN_SUGGESTION" : "FEATURE_AI_GEN_SUGGESTION_ONDEVICE", appInfo.isStreamingMode(), new C7738c(this, requestType, appInfo, str, suggestionCategory, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> suggestion(AppInfo appInfo, SuggestionInputParams suggestionInputParams) {
        return suggestion(appInfo, suggestionInputParams, new HashMap());
    }

    public Task<Result> suggestion(AppInfo appInfo, SuggestionInputParams suggestionInputParams, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(appInfo.getRequestType() == AppInfo.RequestType.CLOUD ? "FEATURE_AI_GEN_SUGGESTION" : "FEATURE_AI_GEN_SUGGESTION_ONDEVICE", appInfo.isStreamingMode(), new C6776b(8, this, suggestionInputParams, appInfo, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}

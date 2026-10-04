package com.samsung.android.sdk.scs.p142ai.language;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.service.AuthHeader;
import com.samsung.android.sdk.scs.p142ai.language.service.ExtractionServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceObserver2;
import com.samsung.android.sdk.scs.p142ai.language.service.LlmServiceRunnable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p017D1.C0061b;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Extractor {
    private static final String TAG = "Extractor";
    private final String featureName = "FEATURE_SIVS_EXTRACTION";
    private final ExtractionServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Extractor(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        this.mServiceExecutor = new ExtractionServiceExecutor(context);
    }

    private File createFolder(String str) {
        File file = new File(this.mServiceExecutor.context.getFilesDir().getAbsolutePath(), str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Log.m6485d(TAG, "extract_image folder creation failed");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extract$0(AppInfo appInfo, String str, ExtractionCategory extractionCategory, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().extractor3(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), str, extractionCategory.name(), llmServiceObserver2, map);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extract$1(ExtractionInputParams extractionInputParams, AppInfo.RequestType requestType, AppInfo appInfo, Map map, LlmServiceObserver2 llmServiceObserver2) {
        File fileCreateFolder;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen = null;
            if (extractionInputParams.getData() != null && (fileCreateFolder = createFolder("extract_image")) != null) {
                File file = new File(fileCreateFolder, "extract_image_file");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(extractionInputParams.getData());
                        parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 268435456);
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (IOException e) {
                    Log.m6487e(TAG, "datafile failure: " + e.getMessage());
                }
            }
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpen;
            if (requestType == AppInfo.RequestType.CLOUD) {
                this.mServiceExecutor.getService().extractorMultiModal(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), extractionInputParams.getInputText(), extractionInputParams.getCategory().getName(), extractionInputParams.getDataMimeType(), parcelFileDescriptor, llmServiceObserver2, map);
            } else {
                this.mServiceExecutor.getService().extractorMultiModalOnDeviceOnly(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), extractionInputParams.getInputText(), extractionInputParams.getCategory().getName(), parcelFileDescriptor, llmServiceObserver2, map);
            }
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extract$2(ExtractionMultiInputParams extractionMultiInputParams, AppInfo.RequestType requestType, AppInfo appInfo, Map map, LlmServiceObserver2 llmServiceObserver2) {
        try {
            List<byte[]> dataList = extractionMultiInputParams.getDataList();
            ArrayList arrayList = new ArrayList();
            File fileCreateFolder = createFolder("extract_image");
            if (fileCreateFolder != null) {
                for (int i = 0; i < dataList.size(); i++) {
                    File file = new File(fileCreateFolder, "extract_image_file_" + i);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            fileOutputStream.write(dataList.get(i));
                            arrayList.add(ParcelFileDescriptor.open(file, 268435456));
                            fileOutputStream.close();
                        } finally {
                        }
                    } catch (IOException e) {
                        Log.m6487e(TAG, "datafile failure: " + e.getMessage());
                    }
                }
            }
            if (requestType == AppInfo.RequestType.CLOUD) {
                this.mServiceExecutor.getService().extractorMultiModal2(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), extractionMultiInputParams.getInputText(), extractionMultiInputParams.getCategory().getName(), extractionMultiInputParams.getDataMimeTypeList(), arrayList, llmServiceObserver2, map);
                return;
            }
            Log.m6487e(TAG, "ExtractionMultiInput requestType: " + requestType + ", now only support CLOUD");
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    public Task<Result> extract(AppInfo appInfo, @NonNull String str, ExtractionCategory extractionCategory) {
        return extract(appInfo, str, extractionCategory, new HashMap());
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        if (Feature.checkFeature(this.mServiceExecutor.context, "FEATURE_SIVS_EXTRACTION_ONDEVICE") != 0) {
            this.mServiceExecutor.deInit();
            return;
        }
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_SIVS_EXTRACTION", false, new C4191n(this, 7), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C0061b(this, 29));
    }

    public Task<Result> extract(AppInfo appInfo, @NonNull String str, ExtractionCategory extractionCategory, @NonNull Map<String, String> map) {
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_SIVS_EXTRACTION", appInfo.isStreamingMode(), new C7736a(this, appInfo, str, extractionCategory, map, 3), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> extract(AppInfo appInfo, ExtractionInputParams extractionInputParams) {
        return extract(appInfo, extractionInputParams, new HashMap());
    }

    public Task<Result> extract(AppInfo appInfo, ExtractionInputParams extractionInputParams, @NonNull Map<String, String> map) {
        AppInfo.RequestType requestType = appInfo.getRequestType();
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(requestType == AppInfo.RequestType.CLOUD ? "FEATURE_SIVS_EXTRACTION" : "FEATURE_SIVS_EXTRACTION_ONDEVICE", appInfo.isStreamingMode(), new C7736a(this, extractionInputParams, requestType, appInfo, map, 1), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> extract(AppInfo appInfo, ExtractionMultiInputParams extractionMultiInputParams, @NonNull Map<String, String> map) {
        AppInfo.RequestType requestType = appInfo.getRequestType();
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(requestType == AppInfo.RequestType.CLOUD ? "FEATURE_SIVS_EXTRACTION" : "FEATURE_SIVS_EXTRACTION_ONDEVICE", appInfo.isStreamingMode(), new C7736a(this, extractionMultiInputParams, requestType, appInfo, map, 2), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}

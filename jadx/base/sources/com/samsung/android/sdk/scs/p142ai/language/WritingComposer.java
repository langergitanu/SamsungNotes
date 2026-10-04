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
import com.samsung.android.sdk.scs.p142ai.language.service.WritingComposerServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.language.service.WritingComposerServiceExecutorForExternal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WritingComposer {
    private static final String TAG = "WritingComposer";
    protected WritingComposerServiceExecutor mServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public WritingComposer(@NonNull Context context) {
        Log.m6485d(TAG, TAG);
        createExecutor(context);
    }

    private File createFolder(String str) {
        File file = new File(this.mServiceExecutor.context.getFilesDir().getAbsolutePath(), str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Log.m6485d(TAG, "writing_composer folder creation failed");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$compose$0(WritingComposerInputParams writingComposerInputParams, AppInfo appInfo, Map map, LlmServiceObserver2 llmServiceObserver2) {
        File fileCreateFolder;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen = null;
            if (writingComposerInputParams.getData() != null && (fileCreateFolder = createFolder("writing_composer")) != null) {
                File file = new File(fileCreateFolder, "writing_composer_file");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(writingComposerInputParams.getData());
                        parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 268435456);
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (IOException e) {
                    Log.m6487e(TAG, "datafile failure: " + e.getMessage());
                }
            }
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpen;
            if (writingComposerInputParams.getDynamicFormat().isEmpty() || writingComposerInputParams.getDynamicTone().isEmpty()) {
                this.mServiceExecutor.getService().compose(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), writingComposerInputParams.getInputText(), writingComposerInputParams.getDataMimeType(), parcelFileDescriptor, writingComposerInputParams.getFormat().name(), writingComposerInputParams.getTone().name(), writingComposerInputParams.getOutputSentenceCount(), llmServiceObserver2, map);
            } else {
                this.mServiceExecutor.getService().composeDynamicStyle(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), writingComposerInputParams.getInputText(), writingComposerInputParams.getDataMimeType(), parcelFileDescriptor, writingComposerInputParams.getDynamicFormat(), writingComposerInputParams.getDynamicTone(), writingComposerInputParams.getOutputSentenceCount(), llmServiceObserver2, map);
            }
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$compose$1(WritingComposerMultiInputParams writingComposerMultiInputParams, AppInfo appInfo, Map map, LlmServiceObserver2 llmServiceObserver2) {
        FileOutputStream fileOutputStream;
        try {
            List<byte[]> dataList = writingComposerMultiInputParams.getDataList();
            ArrayList arrayList = new ArrayList();
            File fileCreateFolder = createFolder("writing_composer");
            if (fileCreateFolder != null) {
                for (int i = 0; i < dataList.size(); i++) {
                    File file = new File(fileCreateFolder, "writing_composer_file_" + i);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e) {
                        Log.m6487e(TAG, "datafile failure: " + e.getMessage());
                    }
                    try {
                        fileOutputStream.write(dataList.get(i));
                        arrayList.add(ParcelFileDescriptor.open(file, 268435456));
                        fileOutputStream.close();
                    } finally {
                    }
                }
            }
            this.mServiceExecutor.getService().compose2(new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context), writingComposerMultiInputParams.getInputText(), writingComposerMultiInputParams.getDataMimeTypeList(), arrayList, writingComposerMultiInputParams.getFormat().name(), writingComposerMultiInputParams.getTone().name(), writingComposerMultiInputParams.getOutputSentenceCount(), llmServiceObserver2, map);
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(LlmServiceObserver2 llmServiceObserver2) {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            llmServiceObserver2.onNext(new ArrayList());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3(Task task) {
        Log.m6489i(TAG, "connected: " + this.mServiceExecutor.isConnected());
        this.mServiceExecutor.deInit();
    }

    public Task<Result> compose(AppInfo appInfo, @NonNull WritingComposerInputParams writingComposerInputParams) {
        return compose(appInfo, writingComposerInputParams, new HashMap());
    }

    public void createExecutor(Context context) {
        this.mServiceExecutor = new WritingComposerServiceExecutor(context);
    }

    public void release() {
        Log.m6489i(TAG, "release: " + this.mServiceExecutor.isConnected());
        if (Feature.checkFeature(this.mServiceExecutor.context, "FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE") != 0) {
            this.mServiceExecutor.deInit();
            return;
        }
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable("FEATURE_SIVS_WRITING_COMPOSER", false, new C4191n(this, 14), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        llmServiceRunnable.getTask().addOnCompleteListener(new C7737b(this, 6));
    }

    public Task<Result> compose(AppInfo appInfo, @NonNull WritingComposerInputParams writingComposerInputParams, @NonNull Map<String, String> map) {
        String str = appInfo.getRequestType() == AppInfo.RequestType.CLOUD ? "FEATURE_SIVS_WRITING_COMPOSER" : "FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE";
        if (this.mServiceExecutor instanceof WritingComposerServiceExecutorForExternal) {
            str = "FEATURE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL";
        }
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(str, appInfo.isStreamingMode(), new C6776b(9, this, writingComposerInputParams, appInfo, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }

    public Task<Result> compose(AppInfo appInfo, @NonNull WritingComposerMultiInputParams writingComposerMultiInputParams, @NonNull Map<String, String> map) {
        String str = appInfo.getRequestType() == AppInfo.RequestType.CLOUD ? "FEATURE_SIVS_WRITING_COMPOSER" : "FEATURE_SIVS_WRITING_COMPOSER_ONDEVICE";
        if (this.mServiceExecutor instanceof WritingComposerServiceExecutorForExternal) {
            str = "FEATURE_SIVS_WRITING_COMPOSER_FOR_EXTERNAL";
        }
        LlmServiceRunnable llmServiceRunnable = new LlmServiceRunnable(str, appInfo.isStreamingMode(), new C6776b(10, this, writingComposerMultiInputParams, appInfo, map), new C4662f(15));
        this.mServiceExecutor.execute(llmServiceRunnable);
        return llmServiceRunnable.getTask();
    }
}

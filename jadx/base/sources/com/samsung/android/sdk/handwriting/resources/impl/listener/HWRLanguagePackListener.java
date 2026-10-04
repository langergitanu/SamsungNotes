package com.samsung.android.sdk.handwriting.resources.impl.listener;

import com.samsung.android.sdk.handwriting.resources.impl.HWRRMLanguageModel;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface HWRLanguagePackListener {
    boolean onUpdateAvailableLanguageList(Map<String, HWRRMLanguageModel> map);

    boolean onUpdateDownloadingLanguageList(Map<String, HWRRMLanguageModel> map);

    boolean onUpdateInstalledLanguageList(Map<String, HWRRMLanguageModel> map);
}

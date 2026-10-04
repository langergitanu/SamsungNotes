package com.samsung.android.support.senl.p148nt.model.repository.data.sdoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpenDocumentRepositoryFactory {
    private final String mCaller;
    private final DocumentSubscriptionId mDocumentSubscriptionId;
    private final String mLoadPath;
    private final String mLockConfirm;
    private final String mSavePath;
    private final String mUuid;

    private SpenDocumentRepositoryFactory(String str, String str2, String str3, String str4, String str5, DocumentSubscriptionId documentSubscriptionId) {
        this.mUuid = str;
        this.mLoadPath = str2;
        this.mSavePath = str3;
        this.mLockConfirm = str4;
        this.mCaller = str5;
        this.mDocumentSubscriptionId = documentSubscriptionId;
    }

    public static SpenDocumentRepositoryFactory newInstance(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        return new SpenDocumentRepositoryFactory(str, str2, str3, str4, str5, documentSubscriptionId);
    }

    public SpenWordDocRepository createWordDocRepository() {
        return SpenWordDocRepository.create(this.mUuid, this.mLoadPath, this.mSavePath, this.mLockConfirm, this.mCaller, this.mDocumentSubscriptionId);
    }
}

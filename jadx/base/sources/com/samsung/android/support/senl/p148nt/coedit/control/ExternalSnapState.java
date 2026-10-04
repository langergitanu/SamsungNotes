package com.samsung.android.support.senl.p148nt.coedit.control;

import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.coedit.control.common.UpdatePriority;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalSnapState {
    private final ExternalSnapContract mExternalSnapContract;
    private final UpdatePriority mUpdatePriority;
    private final String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ExternalSnapContract {
        boolean isExceedExternalSnap();

        void wakeExternalSnap();
    }

    public ExternalSnapState(String str, ExternalSnapContract externalSnapContract, UpdatePriority updatePriority) {
        this.mUuid = str;
        this.mExternalSnapContract = externalSnapContract;
        this.mUpdatePriority = updatePriority;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ExternalSnapState)) {
            return false;
        }
        return this.mUuid.equals(((ExternalSnapState) obj).getUuid());
    }

    public UpdatePriority getUpdatePriority() {
        return this.mUpdatePriority;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public boolean isExceedExternalSnap() {
        ExternalSnapContract externalSnapContract = this.mExternalSnapContract;
        if (externalSnapContract == null) {
            return false;
        }
        return externalSnapContract.isExceedExternalSnap();
    }

    public boolean isHighUpdatePriority() {
        UpdatePriority updatePriority = this.mUpdatePriority;
        return updatePriority == UpdatePriority.COMPOSE_PRIORITY || updatePriority == UpdatePriority.IMPORT_PRIORITY || updatePriority == UpdatePriority.STANDALONE_PRIORITY;
    }

    public boolean isLowUpdatePriority() {
        UpdatePriority updatePriority = this.mUpdatePriority;
        return updatePriority == UpdatePriority.BACKGROUND_PRIORITY || updatePriority == UpdatePriority.LIST_PRIORITY;
    }

    public void wakeExternalSnap() {
        ExternalSnapContract externalSnapContract = this.mExternalSnapContract;
        if (externalSnapContract == null) {
            return;
        }
        externalSnapContract.wakeExternalSnap();
    }
}

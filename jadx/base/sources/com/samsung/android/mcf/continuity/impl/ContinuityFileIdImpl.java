package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.NonNull;
import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.common.DLog;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityFileIdImpl implements ContinuityFileId {
    private final int mFileSequence;

    @NonNull
    private final String mSrcBtMac;

    @NonNull
    private final String mTargetBtMac;

    public ContinuityFileIdImpl(@NonNull String str, @NonNull String str2, int i) {
        this.mSrcBtMac = str;
        this.mTargetBtMac = str2;
        this.mFileSequence = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ContinuityFileId continuityFileId = (ContinuityFileId) obj;
            if (getFileSequence() == continuityFileId.getFileSequence() && getSrcBtMac().equals(continuityFileId.getSrcBtMac()) && getTargetBtMac().equals(continuityFileId.getTargetBtMac())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityFileId
    public int getFileSequence() {
        return this.mFileSequence;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityFileId
    @NonNull
    public String getSrcBtMac() {
        return this.mSrcBtMac;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityFileId
    @NonNull
    public String getTargetBtMac() {
        return this.mTargetBtMac;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ContinuityFileIdImpl{src = ");
        sb.append(DLog.secureMac(this.mSrcBtMac));
        sb.append(", target = ");
        sb.append(DLog.secureMac(this.mTargetBtMac));
        sb.append(", seq = ");
        return AbstractC0000a.m13j(sb, this.mFileSequence, '}');
    }
}

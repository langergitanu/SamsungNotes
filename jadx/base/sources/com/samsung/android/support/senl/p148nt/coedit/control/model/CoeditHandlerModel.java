package com.samsung.android.support.senl.p148nt.coedit.control.model;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditHandlerModel {
    private String mFilePath;
    private String mJwt;
    private String mRegionDomain;
    private final CoeditConstants.User mUser;
    private final String mUuid;
    private final AtomicInteger mState = new AtomicInteger(0);
    private final AtomicBoolean mIsCancelled = new AtomicBoolean(false);

    public CoeditHandlerModel(@NonNull String str, CoeditConstants.User user) {
        this.mUuid = str;
        this.mUser = user;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public String getJwt() {
        return this.mJwt;
    }

    public String getRegionDomain() {
        return this.mRegionDomain;
    }

    public int getState() {
        return this.mState.get();
    }

    public CoeditConstants.User getUser() {
        return this.mUser;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public boolean isCancelled() {
        return this.mIsCancelled.get();
    }

    public void setCancelled() {
        this.mIsCancelled.set(true);
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setJwt(String str) {
        this.mJwt = str;
    }

    public void setRegionDomain(String str) {
        this.mRegionDomain = str;
    }

    public void setState(int i) {
        this.mState.set(i);
    }

    @NonNull
    public String toString() {
        return "#user: " + this.mUser + ", uuid: " + this.mUuid + ", state: " + this.mState.get();
    }
}

package com.google.android.play.core.install;

import com.google.android.play.core.install.model.C5150a;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.tasks.AbstractC5346j;

/* JADX INFO: loaded from: classes5.dex */
public class InstallException extends AbstractC5346j {

    /* JADX INFO: renamed from: a */
    @InstallErrorCode
    private final int f2923a;

    public InstallException(@InstallErrorCode int i) {
        super(String.format("Install Error(%d): %s", Integer.valueOf(i), C5150a.m3863a(i)));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
        this.f2923a = i;
    }

    @Override // com.google.android.play.core.tasks.AbstractC5346j
    @InstallErrorCode
    public int getErrorCode() {
        return this.f2923a;
    }
}

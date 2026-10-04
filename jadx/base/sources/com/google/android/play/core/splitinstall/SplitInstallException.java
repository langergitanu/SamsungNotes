package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.C5312a;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.tasks.AbstractC5346j;

/* JADX INFO: loaded from: classes5.dex */
public class SplitInstallException extends AbstractC5346j {

    /* JADX INFO: renamed from: a */
    @SplitInstallErrorCode
    private final int f3058a;

    public SplitInstallException(@SplitInstallErrorCode int i) {
        super(String.format("Split Install Error(%d): %s", Integer.valueOf(i), C5312a.m4141a(i)));
        if (i == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
        this.f3058a = i;
    }

    @Override // com.google.android.play.core.tasks.AbstractC5346j
    @SplitInstallErrorCode
    public int getErrorCode() {
        return this.f3058a;
    }
}

package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class C2paResult {

    @Nullable
    private String errorString;
    private boolean isCompleted;
    private boolean isSuccess;
    private boolean isTrusted;

    @Nullable
    private String manifestResult;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private boolean isSuccess = false;
        private boolean isTrusted = false;
        private boolean isCompleted = false;

        @Nullable
        private String manifestResult = "";

        @Nullable
        private String errorString = "";

        public C2paResult build() {
            return new C2paResult(this, 0);
        }

        public Builder setCompleted(boolean z) {
            this.isCompleted = z;
            return this;
        }

        public Builder setError(String str) {
            this.errorString = str;
            return this;
        }

        public Builder setManifestResult(String str) {
            this.manifestResult = str;
            return this;
        }

        public Builder setSuccess(boolean z) {
            this.isSuccess = z;
            return this;
        }

        public Builder setTrusted(boolean z) {
            this.isTrusted = z;
            return this;
        }
    }

    public /* synthetic */ C2paResult(Builder builder, int i) {
        this(builder);
    }

    public String getError() {
        return this.errorString;
    }

    public String getManifestResult() {
        return this.manifestResult;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public boolean isTrusted() {
        return this.isTrusted;
    }

    private C2paResult(Builder builder) {
        this.isSuccess = builder.isSuccess;
        this.isTrusted = builder.isTrusted;
        this.isCompleted = builder.isCompleted;
        this.manifestResult = builder.manifestResult;
        this.errorString = builder.errorString;
    }
}

package com.google.android.play.core.splitinstall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class SplitInstallRequest {

    /* JADX INFO: renamed from: a */
    private final List<String> f3060a;

    /* JADX INFO: renamed from: b */
    private final List<Locale> f3061b;

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final List<String> f3062a = new ArrayList();

        /* JADX INFO: renamed from: b */
        private final List<Locale> f3063b = new ArrayList();

        private Builder() {
        }

        @NonNull
        public Builder addLanguage(@Nullable Locale locale) {
            this.f3063b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.f3062a.add(str);
            return this;
        }

        @NonNull
        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }

        public /* synthetic */ Builder(byte[] bArr) {
        }
    }

    public /* synthetic */ SplitInstallRequest(Builder builder) {
        this.f3060a = new ArrayList(builder.f3062a);
        this.f3061b = new ArrayList(builder.f3063b);
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(null);
    }

    public List<Locale> getLanguages() {
        return this.f3061b;
    }

    public List<String> getModuleNames() {
        return this.f3060a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.f3060a, this.f3061b);
    }
}

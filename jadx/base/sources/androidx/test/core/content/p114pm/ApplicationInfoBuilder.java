package androidx.test.core.content.p114pm;

import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationInfoBuilder {
    private int flags = 0;

    @Nullable
    private String name;

    @Nullable
    private String packageName;

    private ApplicationInfoBuilder() {
    }

    public static ApplicationInfoBuilder newBuilder() {
        return new ApplicationInfoBuilder();
    }

    public ApplicationInfo build() {
        Checks.checkNotNull(this.packageName, "Mandatory field 'packageName' missing.");
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.flags = this.flags;
        applicationInfo.name = this.name;
        applicationInfo.packageName = this.packageName;
        return applicationInfo;
    }

    public ApplicationInfoBuilder setFlags(int i) {
        this.flags = i;
        return this;
    }

    public ApplicationInfoBuilder setName(@Nullable String str) {
        this.name = str;
        return this;
    }

    public ApplicationInfoBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }
}

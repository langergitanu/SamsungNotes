package com.microsoft.identity.common.java.p132ui;

import com.google.gson.annotations.SerializedName;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrowserDescriptor implements Serializable {
    private static final long serialVersionUID = 3745812401643512530L;

    @SerializedName("browser_package_name")
    private String mPackageName;

    @SerializedName("browser_signature_hashes")
    private Set<String> mSignatureHashes;

    @SerializedName("browser_version_lower_bound")
    private String mVersionLowerBound;

    @SerializedName("browser_version_upper_bound")
    private String mVersionUpperBound;

    public BrowserDescriptor(@NonNull String str, @NonNull Set<String> set, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        if (set == null) {
            throw new NullPointerException("signatureHashes is marked non-null but is null");
        }
        this.mPackageName = str;
        this.mSignatureHashes = set;
        this.mVersionLowerBound = str2;
        this.mVersionUpperBound = str3;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public Set<String> getSignatureHashes() {
        return this.mSignatureHashes;
    }

    public String getVersionLowerBound() {
        return this.mVersionLowerBound;
    }

    public String getVersionUpperBound() {
        return this.mVersionUpperBound;
    }

    public BrowserDescriptor(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        if (str == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        if (str2 != null) {
            this.mPackageName = str;
            this.mSignatureHashes = Collections.singleton(str2);
            this.mVersionLowerBound = str3;
            this.mVersionUpperBound = str4;
            return;
        }
        throw new NullPointerException("signatureHash is marked non-null but is null");
    }
}

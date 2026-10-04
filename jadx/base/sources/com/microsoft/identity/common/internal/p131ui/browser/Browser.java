package com.microsoft.identity.common.internal.p131ui.browser;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Browser {
    private static final String DIGEST_SHA_512 = "SHA-512";
    private static final int PRIME_HASH_FACTOR = 92821;
    private final Boolean mIsCustomTabsServiceSupported;
    private final String mPackageName;
    private final Set<String> mSignatureHashes;
    private final String mVersion;

    public Browser(@NonNull PackageInfo packageInfo) {
        this(packageInfo.packageName, generateSignatureHashes(PackageHelper.getSignatures(packageInfo)), packageInfo.versionName, false);
    }

    @NonNull
    public static Set<String> generateSignatureHashes(@NonNull Signature[] signatureArr) {
        HashSet hashSet = new HashSet();
        for (Signature signature : signatureArr) {
            try {
                hashSet.add(Base64.encodeToString(MessageDigest.getInstance(DIGEST_SHA_512).digest(signature.toByteArray()), 10));
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("Platform does not supportSHA-512 hashing");
            }
        }
        return hashSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Browser)) {
            Browser browser = (Browser) obj;
            if (this.mPackageName.equals(browser.getPackageName()) && this.mVersion.equals(browser.getVersion()) && this.mSignatureHashes.equals(browser.getSignatureHashes())) {
                return true;
            }
        }
        return false;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public Set<String> getSignatureHashes() {
        return this.mSignatureHashes;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public int hashCode() {
        int iM1202c = (this.mIsCustomTabsServiceSupported.booleanValue() ? 1 : 0) + AbstractC1038a.m1202c(this.mPackageName.hashCode() * PRIME_HASH_FACTOR, PRIME_HASH_FACTOR, this.mVersion);
        Iterator<String> it = this.mSignatureHashes.iterator();
        while (it.hasNext()) {
            iM1202c = (iM1202c * PRIME_HASH_FACTOR) + it.next().hashCode();
        }
        return iM1202c;
    }

    public boolean isCustomTabsServiceSupported() {
        return this.mIsCustomTabsServiceSupported.booleanValue();
    }

    public Browser(@NonNull PackageInfo packageInfo, Boolean bool) {
        this(packageInfo.packageName, generateSignatureHashes(PackageHelper.getSignatures(packageInfo)), packageInfo.versionName, bool.booleanValue());
    }

    public Browser(@NonNull String str, @NonNull Set<String> set, @NonNull String str2, boolean z) {
        this.mPackageName = str;
        this.mSignatureHashes = set;
        this.mVersion = str2;
        this.mIsCustomTabsServiceSupported = Boolean.valueOf(z);
    }
}

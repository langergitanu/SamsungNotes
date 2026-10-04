package com.microsoft.identity.common.java.adal.cache;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.util.StringUtil;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CacheKey implements Serializable {
    static final String FRT_ENTRY_PREFIX = "foci-";
    private static final long serialVersionUID = 8067972995583126404L;
    private String mAuthority;
    private String mClientId;
    private String mFamilyClientId;
    private boolean mIsMultipleResourceRefreshToken;
    private String mResource;
    private String mUserId;

    public static String createCacheKey(String str, String str2, String str3, boolean z, String str4, String str5) {
        if (str == null) {
            throw new IllegalArgumentException("authority");
        }
        if (str3 == null && str5 == null) {
            throw new IllegalArgumentException("both clientId and familyClientId are null");
        }
        CacheKey cacheKey = new CacheKey();
        if (!z) {
            if (str2 == null) {
                throw new IllegalArgumentException("resource");
            }
            cacheKey.mResource = str2;
        }
        Locale locale = Locale.US;
        String lowerCase = str.toLowerCase(locale);
        cacheKey.mAuthority = lowerCase;
        if (lowerCase.endsWith("/")) {
            cacheKey.mAuthority = (String) cacheKey.mAuthority.subSequence(0, r3.length() - 1);
        }
        if (str3 != null) {
            cacheKey.mClientId = str3.toLowerCase(locale);
        }
        if (str5 != null) {
            cacheKey.mFamilyClientId = FRT_ENTRY_PREFIX.concat(str5).toLowerCase(locale);
        }
        cacheKey.mIsMultipleResourceRefreshToken = z;
        if (!StringUtil.isNullOrEmpty(str4)) {
            cacheKey.mUserId = str4.toLowerCase(locale);
        }
        return cacheKey.toString();
    }

    public static String createCacheKeyForFRT(String str, String str2, String str3) {
        return createCacheKey(str, null, null, true, str3, str2);
    }

    public static String createCacheKeyForMRRT(String str, String str2, String str3) {
        return createCacheKey(str, null, str2, true, str3, null);
    }

    public static String createCacheKeyForRTEntry(String str, String str2, String str3, String str4) {
        return createCacheKey(str, str2, str3, false, str4, null);
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public boolean getIsMultipleResourceRefreshToken() {
        return this.mIsMultipleResourceRefreshToken;
    }

    public String getResource() {
        return this.mResource;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String toString() {
        if (StringUtil.isNullOrEmpty(this.mFamilyClientId)) {
            Locale locale = Locale.US;
            return AbstractC0541b.m776r(AbstractC2821a.m2228s(this.mAuthority, "$", this.mResource, "$", this.mClientId), "$", this.mIsMultipleResourceRefreshToken ? "y" : "n", "$", this.mUserId);
        }
        Locale locale2 = Locale.US;
        String str = this.mAuthority;
        String str2 = this.mResource;
        String str3 = this.mClientId;
        String str4 = this.mIsMultipleResourceRefreshToken ? "y" : "n";
        String str5 = this.mUserId;
        String str6 = this.mFamilyClientId;
        StringBuilder sbM2228s = AbstractC2821a.m2228s(str, "$", str2, "$", str3);
        AbstractC2821a.m2207B(sbM2228s, "$", str4, "$", str5);
        return AbstractC0622a.m1170p("$", str6, sbM2228s);
    }
}

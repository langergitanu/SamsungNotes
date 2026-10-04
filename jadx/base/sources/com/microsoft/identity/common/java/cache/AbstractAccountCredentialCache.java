package com.microsoft.identity.common.java.cache;

import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.PrimaryRefreshTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractAccountCredentialCache implements IAccountCredentialCache {
    private static final String NEW_LINE = "\n";
    private static final String TAG = "AbstractAccountCredentialCache";
    protected final INameValueStorage<String> mSharedPreferencesFileManager;

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.cache.AbstractAccountCredentialCache$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C63561 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType;

        static {
            int[] iArr = new int[CredentialType.values().length];
            $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType = iArr;
            try {
                iArr[CredentialType.AccessToken.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.AccessToken_With_AuthScheme.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.RefreshToken.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.IdToken.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.V1IdToken.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.PrimaryRefreshToken.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public AbstractAccountCredentialCache(@NonNull INameValueStorage<String> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("sharedPreferencesFileManager is marked non-null but is null");
        }
        this.mSharedPreferencesFileManager = iNameValueStorage;
    }

    public static boolean targetsIntersect(@NonNull String str, @NonNull String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("targetToMatch is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("credentialTarget is marked non-null but is null");
        }
        String[] strArrSplit = str.trim().split("\\s+");
        String[] strArrSplit2 = str2.trim().split("\\s+");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str3 : strArrSplit) {
            hashSet.add(str3.toLowerCase(Locale.ROOT));
        }
        for (String str4 : strArrSplit2) {
            hashSet2.add(str4.toLowerCase(Locale.ROOT));
        }
        if (z) {
            Set<String> set = AuthenticationConstants.DEFAULT_SCOPES;
            hashSet.removeAll(set);
            hashSet2.removeAll(set);
        }
        return hashSet2.containsAll(hashSet);
    }

    @NonNull
    public List<AccountRecord> getAccountsFilteredByInternal(@Nullable String str, @Nullable String str2, @Nullable String str3, @NonNull List<AccountRecord> list) {
        if (list == null) {
            throw new NullPointerException("allAccounts is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str);
        boolean zIsNullOrEmpty2 = StringUtil.isNullOrEmpty(str2);
        boolean zIsNullOrEmpty3 = StringUtil.isNullOrEmpty(str3);
        String str4 = TAG;
        StringBuilder sb = new StringBuilder("Account lookup filtered by home_account_id? [");
        sb.append(!zIsNullOrEmpty);
        sb.append("]\nAccount lookup filtered by realm? [");
        sb.append(!zIsNullOrEmpty3);
        sb.append("]");
        Logger.verbose(str4, sb.toString());
        ArrayList arrayList = new ArrayList();
        for (AccountRecord accountRecord : list) {
            boolean zEqualsIgnoreCaseTrimBoth = !zIsNullOrEmpty ? StringUtil.equalsIgnoreCaseTrimBoth(str, accountRecord.getHomeAccountId()) : true;
            if (!zIsNullOrEmpty2) {
                zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str2, accountRecord.getEnvironment());
            }
            if (!zIsNullOrEmpty3) {
                zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str3, accountRecord.getRealm());
            }
            if (zEqualsIgnoreCaseTrimBoth) {
                arrayList.add(accountRecord);
            }
        }
        Logger.verbose(TAG, "Found [" + arrayList.size() + "] matching accounts");
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Credential> getCredentialsFilteredByInternal(@NonNull List<Credential> list, @Nullable String str, @Nullable String str2, @Nullable CredentialType credentialType, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        boolean z;
        String str11 = str6;
        String str12 = str7;
        if (list == null) {
            throw new NullPointerException("allCredentials is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str2);
        boolean zIsNullOrEmpty2 = StringUtil.isNullOrEmpty(str);
        boolean z2 = !zIsNullOrEmpty2;
        boolean zIsNullOrEmpty3 = StringUtil.isNullOrEmpty(str11);
        boolean z3 = !zIsNullOrEmpty3;
        boolean zIsNullOrEmpty4 = StringUtil.isNullOrEmpty(str12);
        boolean z4 = !zIsNullOrEmpty4;
        boolean zIsNullOrEmpty5 = StringUtil.isNullOrEmpty(str3);
        boolean z5 = !zIsNullOrEmpty5;
        boolean zIsNullOrEmpty6 = StringUtil.isNullOrEmpty(str4);
        boolean z6 = !zIsNullOrEmpty6;
        boolean zIsNullOrEmpty7 = StringUtil.isNullOrEmpty(str5);
        boolean z7 = !zIsNullOrEmpty7;
        boolean z8 = credentialType != null;
        if (z8 && !StringUtil.isNullOrEmpty(str8)) {
            z = zIsNullOrEmpty3;
            boolean z9 = credentialType == CredentialType.AccessToken_With_AuthScheme;
            boolean zIsNullOrEmpty8 = StringUtil.isNullOrEmpty(str10);
            boolean zIsNullOrEmpty9 = StringUtil.isNullOrEmpty(str9);
            String str13 = TAG;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("Credential lookup filtered by home_account_id? [", "]\nCredential lookup filtered by realm? [", "]\nCredential lookup filtered by target? [", z2, z3);
            AbstractC2821a.m2208C(sbM2230u, z4, "]\nCredential lookup filtered by clientId? [", z5, "]\nCredential lookup filtered by applicationIdentifier? [");
            AbstractC2821a.m2208C(sbM2230u, z6, "]\nCredential lookup filtered by mamEnrollmentIdentifier? [", z7, "]\nCredential lookup filtered by credential type? [");
            AbstractC2821a.m2208C(sbM2230u, z8, "]\nCredential lookup filtered by auth scheme? [", z9, "]\nCredential lookup filtered by requested claims? [");
            sbM2230u.append(!zIsNullOrEmpty9);
            sbM2230u.append("]");
            Logger.verbose(str13, sbM2230u.toString());
            ArrayList arrayList = new ArrayList();
            for (Credential credential : list) {
                boolean zEqualsIgnoreCaseTrimBoth = !zIsNullOrEmpty2 ? StringUtil.equalsIgnoreCaseTrimBoth(str, credential.getHomeAccountId()) : true;
                if (!zIsNullOrEmpty) {
                    zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str2, credential.getEnvironment());
                }
                if (z8) {
                    zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(credentialType.name(), credential.getCredentialType());
                }
                if (!zIsNullOrEmpty5) {
                    zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str3, credential.getClientId());
                }
                if (!zIsNullOrEmpty6) {
                    if (credential instanceof AccessTokenRecord) {
                        zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str4, ((AccessTokenRecord) credential).getApplicationIdentifier());
                    } else {
                        Logger.verbose(TAG, "Query specified applicationIdentifier match, but credential type does not have application identifier");
                    }
                }
                if (!zIsNullOrEmpty7) {
                    if (credential instanceof AccessTokenRecord) {
                        zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str5, ((AccessTokenRecord) credential).getMamEnrollmentIdentifier());
                    } else {
                        Logger.verbose(TAG, "Query specified mamEnrollmentIdentifier match, but credential type does not have MAM enrollment identifier");
                    }
                }
                if (!z && (credential instanceof AccessTokenRecord)) {
                    zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str11, ((AccessTokenRecord) credential).getRealm());
                }
                if (!z && (credential instanceof IdTokenRecord)) {
                    zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str11, ((IdTokenRecord) credential).getRealm());
                }
                if (!zIsNullOrEmpty4) {
                    if (credential instanceof AccessTokenRecord) {
                        zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && targetsIntersect(str12, ((AccessTokenRecord) credential).getTarget(), true);
                    } else if (credential instanceof RefreshTokenRecord) {
                        RefreshTokenRecord refreshTokenRecord = (RefreshTokenRecord) credential;
                        if (zEqualsIgnoreCaseTrimBoth && targetsIntersect(str12, refreshTokenRecord.getTarget(), true)) {
                            zEqualsIgnoreCaseTrimBoth = true;
                        }
                    } else {
                        Logger.verbose(TAG, "Query specified target-match, but no target to match.");
                    }
                }
                if (z9 && (credential instanceof AccessTokenRecord)) {
                    String accessTokenType = ((AccessTokenRecord) credential).getAccessTokenType();
                    if (accessTokenType != null) {
                        accessTokenType = accessTokenType.trim();
                    }
                    zEqualsIgnoreCaseTrimBoth = !"pop".equalsIgnoreCase(accessTokenType) ? !(zEqualsIgnoreCaseTrimBoth && str8.equalsIgnoreCase(accessTokenType)) : !(zEqualsIgnoreCaseTrimBoth && (str8.equalsIgnoreCase(PopAuthenticationSchemeWithClientKeyInternal.SCHEME_POP_WITH_CLIENT_KEY) || str8.equalsIgnoreCase(PopAuthenticationSchemeInternal.SCHEME_POP)));
                }
                if (!zIsNullOrEmpty8 && (credential instanceof AccessTokenRecord)) {
                    zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && str10.equalsIgnoreCase(((AccessTokenRecord) credential).getKid());
                }
                if (!zIsNullOrEmpty9) {
                    if (credential instanceof AccessTokenRecord) {
                        zEqualsIgnoreCaseTrimBoth = zEqualsIgnoreCaseTrimBoth && StringUtil.equalsIgnoreCaseTrimBoth(str9, ((AccessTokenRecord) credential).getRequestedClaims());
                    } else {
                        Logger.verbose(TAG, "Query specified requested_claims-match, but attempted to match with non-AT credential type.");
                    }
                }
                if (zEqualsIgnoreCaseTrimBoth) {
                    arrayList.add(credential);
                }
                str11 = str6;
                str12 = str7;
            }
            return arrayList;
        }
        z = zIsNullOrEmpty3;
        boolean zIsNullOrEmpty82 = StringUtil.isNullOrEmpty(str10);
        boolean zIsNullOrEmpty92 = StringUtil.isNullOrEmpty(str9);
        String str132 = TAG;
        StringBuilder sbM2230u2 = AbstractC2821a.m2230u("Credential lookup filtered by home_account_id? [", "]\nCredential lookup filtered by realm? [", "]\nCredential lookup filtered by target? [", z2, z3);
        AbstractC2821a.m2208C(sbM2230u2, z4, "]\nCredential lookup filtered by clientId? [", z5, "]\nCredential lookup filtered by applicationIdentifier? [");
        AbstractC2821a.m2208C(sbM2230u2, z6, "]\nCredential lookup filtered by mamEnrollmentIdentifier? [", z7, "]\nCredential lookup filtered by credential type? [");
        AbstractC2821a.m2208C(sbM2230u2, z8, "]\nCredential lookup filtered by auth scheme? [", z9, "]\nCredential lookup filtered by requested claims? [");
        sbM2230u2.append(!zIsNullOrEmpty92);
        sbM2230u2.append("]");
        Logger.verbose(str132, sbM2230u2.toString());
        ArrayList arrayList2 = new ArrayList();
        while (r4.hasNext()) {
        }
        return arrayList2;
    }

    @Nullable
    public Class<? extends Credential> getTargetClassForCredentialType(@Nullable String str, @NonNull CredentialType credentialType) {
        if (credentialType == null) {
            throw new NullPointerException("targetType is marked non-null but is null");
        }
        switch (C63561.$SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[credentialType.ordinal()]) {
            case 1:
            case 2:
                return AccessTokenRecord.class;
            case 3:
                return RefreshTokenRecord.class;
            case 4:
            case 5:
                return IdTokenRecord.class;
            case 6:
                return PrimaryRefreshTokenRecord.class;
            default:
                String str2 = TAG;
                Logger.warn(str2, "Could not match CredentialType to class. Did you forget to update this method with a new type?");
                if (str != null) {
                    Logger.warnPII(str2, "Sought key was: [" + str + "]");
                }
                return null;
        }
    }
}

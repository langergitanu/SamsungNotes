package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.exception.MsalDeclinedScopeException;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthenticationResultAdapter {
    private static final String TAG = "com.microsoft.identity.client.AuthenticationResultAdapter";

    public static IAuthenticationResult adapt(@NonNull ILocalAuthenticationResult iLocalAuthenticationResult) {
        return new AuthenticationResult(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData(), iLocalAuthenticationResult.getCorrelationId());
    }

    public static MsalDeclinedScopeException declinedScopeExceptionFromResult(@NonNull ILocalAuthenticationResult iLocalAuthenticationResult, @NonNull List<String> list, @NonNull TokenParameters tokenParameters) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":declinedScopeExceptionFromResult", new StringBuilder());
        List<String> listAsList = Arrays.asList(iLocalAuthenticationResult.getScope());
        com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Returning DeclinedScopeException as not all requested scopes are granted, Requested scopes: " + tokenParameters.getScopes().toString() + " Granted scopes:" + listAsList.toString());
        AcquireTokenSilentParameters acquireTokenSilentParametersSilentParametersFromInteractive = tokenParameters instanceof AcquireTokenSilentParameters ? (AcquireTokenSilentParameters) tokenParameters : TokenParametersAdapter.silentParametersFromInteractive((AcquireTokenParameters) tokenParameters, iLocalAuthenticationResult);
        acquireTokenSilentParametersSilentParametersFromInteractive.setScopes(listAsList);
        return new MsalDeclinedScopeException(listAsList, list, acquireTokenSilentParametersSilentParametersFromInteractive);
    }

    public static List<String> getDeclinedScopes(@NonNull List<String> list, @NonNull List<String> list2) {
        HashSet hashSet = new HashSet();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toLowerCase(Locale.ROOT));
        }
        HashSet<String> hashSet2 = new HashSet();
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().toLowerCase(Locale.ROOT));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : hashSet2) {
            if (!hashSet.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}

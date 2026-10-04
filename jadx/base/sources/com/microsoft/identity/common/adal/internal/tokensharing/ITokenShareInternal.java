package com.microsoft.identity.common.adal.internal.tokensharing;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ITokenShareInternal {
    String getMsaFamilyRefreshToken(String str);

    ITokenShareResultInternal getMsaFamilyRefreshTokenWithMetadata(String str);

    String getOrgIdFamilyRefreshToken(String str);

    ITokenShareResultInternal getOrgIdFamilyRefreshTokenWithMetadata(String str);

    void saveMsaFamilyRefreshToken(String str);

    void saveOrgIdFamilyRefreshToken(String str);
}

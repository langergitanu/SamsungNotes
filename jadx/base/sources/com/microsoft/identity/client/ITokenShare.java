package com.microsoft.identity.client;

import com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ITokenShare extends ITokenShareInternal {
    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    String getMsaFamilyRefreshToken(String str);

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    TokenShareResult getMsaFamilyRefreshTokenWithMetadata(String str);

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    String getOrgIdFamilyRefreshToken(String str);

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    TokenShareResult getOrgIdFamilyRefreshTokenWithMetadata(String str);

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    void saveMsaFamilyRefreshToken(String str);

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    void saveOrgIdFamilyRefreshToken(String str);
}

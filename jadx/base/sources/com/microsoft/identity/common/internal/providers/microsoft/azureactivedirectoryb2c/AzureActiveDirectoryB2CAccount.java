package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.java.BaseAccount;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryB2CAccount extends BaseAccount {
    public boolean canEqual(Object obj) {
        return obj instanceof AzureActiveDirectoryB2CAccount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AzureActiveDirectoryB2CAccount) && ((AzureActiveDirectoryB2CAccount) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAlternativeAccountId() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAuthorityType() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getAvatarUrl() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.BaseAccount
    public List<String> getCacheIdentifiers() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getClientInfo() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getEnvironment() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getFamilyName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getFirstName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getHomeAccountId() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getLocalAccountId() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getMiddleName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getName() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getRealm() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.BaseAccount
    public String getUniqueIdentifier() {
        throw new UnsupportedOperationException("Method stub!");
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public String getUsername() {
        throw new UnsupportedOperationException("Method stub!");
    }

    public int hashCode() {
        return super.hashCode();
    }
}

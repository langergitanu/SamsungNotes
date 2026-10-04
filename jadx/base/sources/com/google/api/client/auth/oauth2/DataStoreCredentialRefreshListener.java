package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public final class DataStoreCredentialRefreshListener implements CredentialRefreshListener {
    private final DataStore<StoredCredential> credentialDataStore;
    private final String userId;

    public DataStoreCredentialRefreshListener(String str, DataStoreFactory dataStoreFactory) {
        this(str, StoredCredential.getDefaultDataStore(dataStoreFactory));
    }

    public DataStore<StoredCredential> getCredentialDataStore() {
        return this.credentialDataStore;
    }

    public void makePersistent(Credential credential) {
        this.credentialDataStore.set(this.userId, new StoredCredential(credential));
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) {
        makePersistent(credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void onTokenResponse(Credential credential, TokenResponse tokenResponse) {
        makePersistent(credential);
    }

    public DataStoreCredentialRefreshListener(String str, DataStore<StoredCredential> dataStore) {
        this.userId = (String) Preconditions.checkNotNull(str);
        this.credentialDataStore = (DataStore) Preconditions.checkNotNull(dataStore);
    }
}

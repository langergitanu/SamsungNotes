package com.google.api.client.googleapis.batch.json;

import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.http.HttpHeaders;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JsonBatchCallback<T> implements BatchCallback<T, GoogleJsonErrorContainer> {
    public abstract void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders);

    @Override // com.google.api.client.googleapis.batch.BatchCallback
    public final void onFailure(GoogleJsonErrorContainer googleJsonErrorContainer, HttpHeaders httpHeaders) {
        onFailure(googleJsonErrorContainer.getError(), httpHeaders);
    }
}

package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class ClientLoginResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4974317674023010928L;
    private final transient ClientLogin.ErrorInfo details;

    public ClientLoginResponseException(HttpResponseException.Builder builder, ClientLogin.ErrorInfo errorInfo) {
        super(builder);
        this.details = errorInfo;
    }

    public final ClientLogin.ErrorInfo getDetails() {
        return this.details;
    }
}

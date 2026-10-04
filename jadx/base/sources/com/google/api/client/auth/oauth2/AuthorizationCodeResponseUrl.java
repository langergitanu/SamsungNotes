package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AuthorizationCodeResponseUrl extends GenericUrl {

    @Key
    private String code;

    @Key
    private String error;

    @Key("error_description")
    private String errorDescription;

    @Key("error_uri")
    private String errorUri;

    @Key
    private String state;

    public AuthorizationCodeResponseUrl(String str) {
        super(str);
        Preconditions.checkArgument((this.code == null) != (this.error == null));
    }

    public final String getCode() {
        return this.code;
    }

    public final String getError() {
        return this.error;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getErrorUri() {
        return this.errorUri;
    }

    public final String getState() {
        return this.state;
    }

    public AuthorizationCodeResponseUrl setCode(String str) {
        this.code = str;
        return this;
    }

    public AuthorizationCodeResponseUrl setError(String str) {
        this.error = str;
        return this;
    }

    public AuthorizationCodeResponseUrl setErrorDescription(String str) {
        this.errorDescription = str;
        return this;
    }

    public AuthorizationCodeResponseUrl setErrorUri(String str) {
        this.errorUri = str;
        return this;
    }

    public AuthorizationCodeResponseUrl setState(String str) {
        this.state = str;
        return this;
    }

    @Override // com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData
    public AuthorizationCodeResponseUrl set(String str, Object obj) {
        return (AuthorizationCodeResponseUrl) super.set(str, obj);
    }

    @Override // com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AuthorizationCodeResponseUrl clone() {
        return (AuthorizationCodeResponseUrl) super.clone();
    }
}

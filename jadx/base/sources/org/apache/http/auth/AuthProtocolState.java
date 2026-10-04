package org.apache.http.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum AuthProtocolState {
    UNCHALLENGED,
    CHALLENGED,
    HANDSHAKE,
    FAILURE,
    SUCCESS;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AuthProtocolState[] valuesCustom() {
        AuthProtocolState[] authProtocolStateArrValuesCustom = values();
        int length = authProtocolStateArrValuesCustom.length;
        AuthProtocolState[] authProtocolStateArr = new AuthProtocolState[length];
        System.arraycopy(authProtocolStateArrValuesCustom, 0, authProtocolStateArr, 0, length);
        return authProtocolStateArr;
    }
}

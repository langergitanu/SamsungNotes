package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.JsonFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CloudShellCredential extends GoogleCredential {
    private static final int ACCESS_TOKEN_INDEX = 2;
    protected static final String GET_AUTH_TOKEN_REQUEST = "2\n[]";
    private static final int READ_TIMEOUT_MS = 5000;
    private final int authPort;
    private final JsonFactory jsonFactory;

    public CloudShellCredential(int i, JsonFactory jsonFactory) {
        this.authPort = i;
        this.jsonFactory = jsonFactory;
    }

    @Override // com.google.api.client.googleapis.auth.oauth2.GoogleCredential, com.google.api.client.auth.oauth2.Credential
    public TokenResponse executeRefreshToken() throws IOException {
        Socket socket = new Socket(StringLookupFactory.KEY_LOCALHOST, getAuthPort());
        socket.setSoTimeout(5000);
        TokenResponse tokenResponse = new TokenResponse();
        try {
            new PrintWriter(socket.getOutputStream(), true).println(GET_AUTH_TOKEN_REQUEST);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.readLine();
            tokenResponse.setAccessToken(((List) this.jsonFactory.createJsonParser(bufferedReader).parseArray(LinkedList.class, Object.class)).get(2).toString());
            return tokenResponse;
        } finally {
            socket.close();
        }
    }

    public int getAuthPort() {
        return this.authPort;
    }
}

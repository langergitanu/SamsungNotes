package io.grpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ChoiceServerCredentials extends ServerCredentials {
    private final List<ServerCredentials> creds;

    private ChoiceServerCredentials(ServerCredentials... serverCredentialsArr) {
        for (ServerCredentials serverCredentials : serverCredentialsArr) {
            serverCredentials.getClass();
        }
        this.creds = Collections.unmodifiableList(new ArrayList(Arrays.asList(serverCredentialsArr)));
    }

    public static ServerCredentials create(ServerCredentials... serverCredentialsArr) {
        if (serverCredentialsArr.length != 0) {
            return new ChoiceServerCredentials(serverCredentialsArr);
        }
        throw new IllegalArgumentException("At least one credential is required");
    }

    public List<ServerCredentials> getCredentialsList() {
        return this.creds;
    }
}

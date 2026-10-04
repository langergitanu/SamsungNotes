package io.grpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ChoiceChannelCredentials extends ChannelCredentials {
    private final List<ChannelCredentials> creds;

    private ChoiceChannelCredentials(List<ChannelCredentials> list) {
        this.creds = list;
    }

    public static ChannelCredentials create(ChannelCredentials... channelCredentialsArr) {
        if (channelCredentialsArr.length == 0) {
            throw new IllegalArgumentException("At least one credential is required");
        }
        for (ChannelCredentials channelCredentials : channelCredentialsArr) {
            channelCredentials.getClass();
        }
        return new ChoiceChannelCredentials(Collections.unmodifiableList(new ArrayList(Arrays.asList(channelCredentialsArr))));
    }

    public List<ChannelCredentials> getCredentialsList() {
        return this.creds;
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        ArrayList arrayList = new ArrayList();
        Iterator<ChannelCredentials> it = this.creds.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().withoutBearerTokens());
        }
        return new ChoiceChannelCredentials(Collections.unmodifiableList(arrayList));
    }
}

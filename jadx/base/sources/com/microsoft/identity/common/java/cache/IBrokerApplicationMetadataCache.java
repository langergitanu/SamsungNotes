package com.microsoft.identity.common.java.cache;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IBrokerApplicationMetadataCache extends ISimpleCache<BrokerApplicationMetadata> {
    Set<String> getAllClientIds();

    List<BrokerApplicationMetadata> getAllFociApplicationMetadata();

    Set<String> getAllFociClientIds();

    Set<String> getAllNonFociClientIds();

    @Nullable
    BrokerApplicationMetadata getMetadata(String str, String str2, int i);
}

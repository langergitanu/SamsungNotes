package com.microsoft.identity.common.java.cache;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings(justification = "Lombok inserts more null checks than we need", value = {SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
public class NameValueStorageBrokerApplicationMetadataCache extends NameValueStorageFileManagerSimpleCacheImpl<BrokerApplicationMetadata> implements IBrokerApplicationMetadataCache {
    private static final String DEFAULT_APP_METADATA_CACHE_NAME = "com.microsoft.identity.app-meta-cache";
    private static final String KEY_CACHE_LIST = "app-meta-cache";
    private static final String TAG = "NameValueStorageBrokerApplicationMetadataCache";

    public NameValueStorageBrokerApplicationMetadataCache(@NonNull IPlatformComponents iPlatformComponents) {
        super(iPlatformComponents, DEFAULT_APP_METADATA_CACHE_NAME, KEY_CACHE_LIST, true);
        if (iPlatformComponents == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public Set<String> getAllClientIds() {
        HashSet hashSet = new HashSet();
        Iterator<BrokerApplicationMetadata> it = getAll().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getClientId());
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAllClientIds", new StringBuilder()), "Found [" + hashSet.size() + "] client ids.");
        return hashSet;
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public List<BrokerApplicationMetadata> getAllFociApplicationMetadata() {
        Set<String> allFociClientIds = getAllFociClientIds();
        ArrayList arrayList = new ArrayList();
        for (BrokerApplicationMetadata brokerApplicationMetadata : getAll()) {
            if (allFociClientIds.contains(brokerApplicationMetadata.getClientId())) {
                arrayList.add(brokerApplicationMetadata);
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public Set<String> getAllFociClientIds() {
        return getAllFociClientIds(false);
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    public Set<String> getAllNonFociClientIds() {
        return getAllFociClientIds(true);
    }

    @Override // com.microsoft.identity.common.java.cache.IListTypeToken
    public Type getListTypeToken() {
        return TypeToken.getParameterized(List.class, BrokerApplicationMetadata.class).getType();
    }

    @Override // com.microsoft.identity.common.java.cache.IBrokerApplicationMetadataCache
    @Nullable
    public BrokerApplicationMetadata getMetadata(@NonNull String str, @NonNull String str2, int i) {
        BrokerApplicationMetadata next;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        Iterator<BrokerApplicationMetadata> it = getAll().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (str.equals(next.getClientId()) && str2.equals(next.getEnvironment()) && i == next.getUid()) {
                Logger.verbose(TAG + next, "Metadata located.");
                break;
            }
        }
        if (next == null) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getMetadata", new StringBuilder()), AbstractC0541b.m775q("Metadata could not be found for clientId, environment: [", str, SQLKeyword.COMMA, str2, "]"));
        }
        return next;
    }

    public void remove(@NonNull String str, int i) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        for (BrokerApplicationMetadata brokerApplicationMetadata : getAll()) {
            if (str.equalsIgnoreCase(brokerApplicationMetadata.getClientId()) && i == brokerApplicationMetadata.getUid()) {
                remove(brokerApplicationMetadata);
            }
        }
    }

    private Set<String> getAllFociClientIds(boolean z) {
        HashSet hashSet = new HashSet();
        for (BrokerApplicationMetadata brokerApplicationMetadata : getAll()) {
            if (z) {
                if (StringUtil.isNullOrEmpty(brokerApplicationMetadata.getFoci())) {
                    hashSet.add(brokerApplicationMetadata.getClientId());
                }
            } else if (!StringUtil.isNullOrEmpty(brokerApplicationMetadata.getFoci())) {
                hashSet.add(brokerApplicationMetadata.getClientId());
            }
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAllFociClientIds", new StringBuilder()), "Found [" + hashSet.size() + "] client ids.");
        return hashSet;
    }
}

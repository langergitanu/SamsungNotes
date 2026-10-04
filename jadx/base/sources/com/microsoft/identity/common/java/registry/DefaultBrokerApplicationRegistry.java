package com.microsoft.identity.common.java.registry;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultBrokerApplicationRegistry extends NameValueStorageFileManagerSimpleCacheImpl<BrokerApplicationRegistryData> implements IBrokerApplicationRegistry {
    private static final String DEFAULT_APP_REGISTRY_CACHE_NAME = "com.microsoft.identity.app-registry";
    private static final String KEY_APP_REGISTRY = "app-registry";
    private static final String TAG = "DefaultBrokerApplicationRegistry";

    public DefaultBrokerApplicationRegistry(@NonNull IPlatformComponents iPlatformComponents) {
        super(iPlatformComponents, DEFAULT_APP_REGISTRY_CACHE_NAME, KEY_APP_REGISTRY);
        if (iPlatformComponents == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IListTypeToken
    public Type getListTypeToken() {
        return TypeToken.getParameterized(List.class, BrokerApplicationRegistryData.class).getType();
    }

    @Override // com.microsoft.identity.common.java.registry.IBrokerApplicationRegistry
    public BrokerApplicationRegistryData getMetadata(@NonNull String str, @Nullable String str2, int i) {
        BrokerApplicationRegistryData next;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        Iterator<BrokerApplicationRegistryData> it = getAll().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (str.equals(next.getClientId()) && i == next.getUid() && (str2 == null || str2.equals(next.getEnvironment()))) {
                Logger.verbose(TAG + next, "Metadata located.");
                break;
            }
        }
        next = null;
        if (next == null) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getMetadata", new StringBuilder()), AbstractC0541b.m775q("Metadata could not be found for clientId, environment: [", str, SQLKeyword.COMMA, str2, "]"));
        }
        return next;
    }
}

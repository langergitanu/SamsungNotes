package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Singleton
class MetadataBackendRegistry implements BackendRegistry {
    private static final String BACKEND_KEY_PREFIX = "backend:";
    private static final String TAG = "BackendRegistry";
    private final BackendFactoryProvider backendFactoryProvider;
    private final Map<String, TransportBackend> backends;
    private final CreationContextFactory creationContextFactory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BackendFactoryProvider {
        private final Context applicationContext;
        private Map<String, String> backendProviders = null;

        public BackendFactoryProvider(Context context) {
            this.applicationContext = context;
        }

        private Map<String, String> discover(Context context) {
            Bundle metadata = getMetadata(context);
            if (metadata == null) {
                Log.w(MetadataBackendRegistry.TAG, "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            for (String str : metadata.keySet()) {
                Object obj = metadata.get(str);
                if ((obj instanceof String) && str.startsWith(MetadataBackendRegistry.BACKEND_KEY_PREFIX)) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        private Map<String, String> getBackendProviders() {
            if (this.backendProviders == null) {
                this.backendProviders = discover(this.applicationContext);
            }
            return this.backendProviders;
        }

        private static Bundle getMetadata(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(MetadataBackendRegistry.TAG, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(MetadataBackendRegistry.TAG, "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(MetadataBackendRegistry.TAG, "Application info not found.");
                return null;
            }
        }

        @Nullable
        public BackendFactory get(String str) {
            String str2 = getBackendProviders().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e) {
                Log.w(MetadataBackendRegistry.TAG, "Class " + str2 + " is not found.", e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w(MetadataBackendRegistry.TAG, "Could not instantiate " + str2 + Extension.DOT, e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w(MetadataBackendRegistry.TAG, "Could not instantiate " + str2 + Extension.DOT, e3);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.w(MetadataBackendRegistry.TAG, "Could not instantiate ".concat(str2), e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.w(MetadataBackendRegistry.TAG, "Could not instantiate ".concat(str2), e6);
                return null;
            }
        }
    }

    @Inject
    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        this(new BackendFactoryProvider(context), creationContextFactory);
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    @Nullable
    public synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return this.backends.get(str);
        }
        BackendFactory backendFactory = this.backendFactoryProvider.get(str);
        if (backendFactory == null) {
            return null;
        }
        TransportBackend transportBackendCreate = backendFactory.create(this.creationContextFactory.create(str));
        this.backends.put(str, transportBackendCreate);
        return transportBackendCreate;
    }

    public MetadataBackendRegistry(BackendFactoryProvider backendFactoryProvider, CreationContextFactory creationContextFactory) {
        this.backends = new HashMap();
        this.backendFactoryProvider = backendFactoryProvider;
        this.creationContextFactory = creationContextFactory;
    }
}

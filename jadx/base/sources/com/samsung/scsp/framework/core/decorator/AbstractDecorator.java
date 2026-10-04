package com.samsung.scsp.framework.core.decorator;

import android.content.Context;
import android.util.Pair;
import androidx.emoji2.text.flatbuffer.C2747a;
import androidx.glance.AbstractC2821a;
import androidx.transition.C3970a;
import com.google.gson.JsonObject;
import com.samsung.scsp.common.Invoker;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.framework.core.api.ApiControl;
import com.samsung.scsp.framework.core.decorator.SdkConfig;
import com.samsung.scsp.framework.core.identity.ScspIdentityFactory;
import com.samsung.scsp.framework.core.listeners.ListenersHolder;
import com.samsung.scsp.framework.core.network.Network;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import p001A.AbstractC0000a;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AbstractDecorator {
    private static final Object CONFIG_LOCK = new Object();
    private final Map<String, Object> FEATURES = new HashMap();
    protected ApiControl apiControl;
    private final Supplier<Context> context;
    protected Network network;
    private final PlatformConfigurationImpl platformConfiguration;
    protected SContextHolder scontextHolder;

    public AbstractDecorator(Class<? extends ApiControl> cls, SdkFeature... sdkFeatureArr) {
        String strName;
        SdkConfig.Domain domain;
        boolean z;
        boolean z2;
        String str;
        boolean zPlatformConfigurationRequired;
        SdkConfig sdkConfig = (SdkConfig) getClass().getAnnotation(SdkConfig.class);
        SdkConfig.Domain domain2 = SdkConfig.Domain.play;
        sdkConfig = sdkConfig == null ? (SdkConfig) FaultBarrier.get(new C11648a(this), null).obj : sdkConfig;
        if (sdkConfig != null) {
            String strVersion = sdkConfig.version();
            strName = sdkConfig.name();
            boolean zAccountRequired = sdkConfig.accountRequired();
            boolean zDrsSupported = sdkConfig.drsSupported();
            SdkConfig.Domain domain3 = sdkConfig.domain();
            zPlatformConfigurationRequired = sdkConfig.platformConfigurationRequired();
            domain = domain3;
            z = zDrsSupported;
            z2 = zAccountRequired;
            str = strVersion;
        } else {
            strName = "none";
            domain = domain2;
            z = false;
            z2 = true;
            str = "0";
            zPlatformConfigurationRequired = false;
        }
        Logger logger = Logger.get(getClass().getSimpleName());
        StringBuilder sbM16m = AbstractC0000a.m16m("name: ", strName, ", version : ", str, ", isAccountRequiredFeature = ");
        AbstractC2821a.m2208C(sbM16m, z2, ", isDrsSupported = ", z, ", platformConfigurationRequire = ");
        sbM16m.append(zPlatformConfigurationRequired);
        logger.m12934i(sbM16m.toString());
        ScspIdentityFactory.getInstance(z2).initialize();
        SContextHolder sContextHolder = new SContextHolder(strName, str, z2, z, domain);
        this.scontextHolder = sContextHolder;
        this.network = sContextHolder.network;
        this.context = new C2747a(9);
        setupFeatures(sdkFeatureArr);
        if (cls != null) {
            FaultBarrier.run(new C0287e(this, cls, 27));
        }
        this.platformConfiguration = new PlatformConfigurationImpl(this.scontextHolder);
        if (zPlatformConfigurationRequired && z2) {
            FaultBarrier.run(new C11648a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadPlatformConfiguration() {
        synchronized (CONFIG_LOCK) {
            try {
                this.platformConfiguration.downloadPlatformConfiguration();
            } catch (ScspException e) {
                if (e.rcode == 40100002) {
                    this.platformConfiguration.downloadPlatformConfiguration();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getFeature$3(String str, Object obj) {
        Object obj2 = this.FEATURES.get(str);
        return obj2 == null ? obj : obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SdkConfig lambda$new$0() {
        return (SdkConfig) getClass().getSuperclass().getAnnotation(SdkConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ApiControl lambda$new$1(Constructor constructor) {
        return (ApiControl) constructor.newInstance(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Class cls) throws NoSuchMethodException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Logger.get(getClass().getSimpleName()).m12934i(declaredConstructor.toString());
        this.apiControl = (ApiControl) FaultBarrier.get(new C11650c(declaredConstructor, 3), null).obj;
    }

    private void setupFeatures(SdkFeature... sdkFeatureArr) {
        if (sdkFeatureArr != null) {
            for (SdkFeature sdkFeature : sdkFeatureArr) {
                this.FEATURES.put(sdkFeature.name, sdkFeature.value);
            }
        }
    }

    public void close() {
        Network network = this.network;
        if (network != null) {
            network.close();
        }
    }

    @SafeVarargs
    public final ApiContext createApiContext(String str, JsonObject jsonObject, String str2, Invoker invoker, Pair<String, Object>... pairArr) {
        ApiContext apiContextCreate = ApiContext.create(this.scontextHolder, str);
        if (pairArr != null) {
            for (Pair<String, Object> pair : pairArr) {
                Object obj = pair.second;
                if (obj != null) {
                    apiContextCreate.parameters.put((String) pair.first, obj);
                }
            }
        }
        Pair<String, Object>[] commonParameter = getCommonParameter();
        if (commonParameter != null) {
            for (Pair<String, Object> pair2 : commonParameter) {
                Object obj2 = pair2.second;
                if (obj2 != null) {
                    apiContextCreate.parameters.put((String) pair2.first, obj2);
                }
            }
        }
        if (jsonObject != null) {
            apiContextCreate.payload = jsonObject.toString();
        }
        if (str2 != null) {
            apiContextCreate.etag = str2;
        }
        if (invoker != null) {
            SContextHolder sContextHolder = this.scontextHolder;
            invoker.set(sContextHolder.applicationId, sContextHolder.version);
            apiContextCreate.invoker = invoker.toString();
        }
        return apiContextCreate;
    }

    @SafeVarargs
    public final <T> T execute(String str, JsonObject jsonObject, String str2, Pair<String, Object>... pairArr) {
        ListenersHolder listenersHolderCreate = ListenersHolder.create();
        this.apiControl.execute(createApiContext(str, jsonObject, str2, null, pairArr), listenersHolderCreate.getListeners());
        return (T) listenersHolderCreate.getResult();
    }

    public Pair<String, Object>[] getCommonParameter() {
        return null;
    }

    public Context getContext() {
        return this.context.get();
    }

    public <T> T getFeature(String str, T t) {
        return FaultBarrier.get(new C3970a(this, 6, str, t), t, true).obj;
    }

    public Map<String, String> getPlatformConfiguration(String... strArr) {
        return this.platformConfiguration.getPlatformConfiguration(strArr);
    }

    public void close(int i) {
        Network network = this.network;
        if (network != null) {
            network.close(i);
        }
    }

    @SafeVarargs
    public final <T> T execute(String str, JsonObject jsonObject, String str2, Invoker invoker, Pair<String, Object>... pairArr) {
        ListenersHolder listenersHolderCreate = ListenersHolder.create();
        this.apiControl.execute(createApiContext(str, jsonObject, str2, invoker, pairArr), listenersHolderCreate.getListeners());
        return (T) listenersHolderCreate.getResult();
    }
}

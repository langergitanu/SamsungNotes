package com.microsoft.identity.client.internal.controllers;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.PublicClientApplicationConfiguration;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClientFactory;
import com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.controllers.BrokerMsalController;
import com.microsoft.identity.common.internal.controllers.LocalMSALController;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.controllers.IControllerFactory;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B%\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/client/internal/controllers/MSALControllerFactory;", "Lcom/microsoft/identity/common/java/controllers/IControllerFactory;", "applicationConfiguration", "Lcom/microsoft/identity/client/PublicClientApplicationConfiguration;", "(Lcom/microsoft/identity/client/PublicClientApplicationConfiguration;)V", "authority", "Lcom/microsoft/identity/common/java/authorities/Authority;", "(Lcom/microsoft/identity/client/PublicClientApplicationConfiguration;Lcom/microsoft/identity/common/java/authorities/Authority;)V", "applicationContext", "Landroid/content/Context;", "platformComponents", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", "(Landroid/content/Context;Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;Lcom/microsoft/identity/common/java/authorities/Authority;Lcom/microsoft/identity/client/PublicClientApplicationConfiguration;)V", "discoveryClient", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "brokerEligible", "", "brokerEligibleAndInstalled", "getActiveBrokerPackageName", "", "getAllControllers", "", "Lcom/microsoft/identity/common/java/controllers/BaseController;", "getDefaultController", "powerOptimizationEnabled", "Companion", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class MSALControllerFactory implements IControllerFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(MSALControllerFactory.class).getSimpleName();

    @Nullable
    private static BaseController injectedMockDefaultController;

    @NotNull
    private final PublicClientApplicationConfiguration applicationConfiguration;

    @NotNull
    private final Context applicationContext;

    @NotNull
    private final Authority authority;

    @NotNull
    private final IBrokerDiscoveryClient discoveryClient;

    @NotNull
    private final IPlatformComponents platformComponents;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/client/internal/controllers/MSALControllerFactory$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "injectedMockDefaultController", "Lcom/microsoft/identity/common/java/controllers/BaseController;", "getInjectedMockDefaultController$annotations", "getInjectedMockDefaultController", "()Lcom/microsoft/identity/common/java/controllers/BaseController;", "setInjectedMockDefaultController", "(Lcom/microsoft/identity/common/java/controllers/BaseController;)V", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final BaseController getInjectedMockDefaultController() {
            return MSALControllerFactory.injectedMockDefaultController;
        }

        public final void setInjectedMockDefaultController(@Nullable BaseController baseController) {
            MSALControllerFactory.injectedMockDefaultController = baseController;
        }

        private Companion() {
        }

        @JvmStatic
        @VisibleForTesting
        public static /* synthetic */ void getInjectedMockDefaultController$annotations() {
        }
    }

    public MSALControllerFactory(@NotNull Context applicationContext, @NotNull IPlatformComponents platformComponents, @NotNull Authority authority, @NotNull PublicClientApplicationConfiguration applicationConfiguration) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(platformComponents, "platformComponents");
        Intrinsics.checkNotNullParameter(authority, "authority");
        Intrinsics.checkNotNullParameter(applicationConfiguration, "applicationConfiguration");
        this.applicationContext = applicationContext;
        this.platformComponents = platformComponents;
        this.authority = authority;
        this.applicationConfiguration = applicationConfiguration;
        this.discoveryClient = BrokerDiscoveryClientFactory.INSTANCE.getInstanceForClientSdk(applicationContext, platformComponents);
    }

    private final boolean brokerEligible() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":brokerEligible", new StringBuilder());
        if (!this.applicationConfiguration.getUseBroker().booleanValue() || !(this.authority instanceof AzureActiveDirectoryAuthority)) {
            Logger.verbose(strM1170p, "Eligible to call broker? [false]. App does not ask for Broker or the authority is not AAD authority.");
            return false;
        }
        if (!powerOptimizationEnabled()) {
            return true;
        }
        Logger.verbose(strM1170p, "Is the power optimization enabled? [true]");
        return true;
    }

    @WorkerThread
    private final String getActiveBrokerPackageName() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getActiveBrokerPackageName", new StringBuilder());
        BrokerData activeBroker = this.discoveryClient.getActiveBroker(false);
        if (activeBroker != null) {
            return activeBroker.getPackageName();
        }
        Logger.info(strM1170p, "Broker application is not installed.");
        return null;
    }

    @Nullable
    public static final BaseController getInjectedMockDefaultController() {
        return INSTANCE.getInjectedMockDefaultController();
    }

    private final boolean powerOptimizationEnabled() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":powerOptimizationEnabled", new StringBuilder());
        String packageName = this.applicationContext.getPackageName();
        Object systemService = this.applicationContext.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        boolean zIsIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(packageName);
        Logger.verbose(strM1170p, "Is power optimization on? [" + zIsIgnoringBatteryOptimizations + PropertyUtils.INDEXED_DELIM2);
        return zIsIgnoringBatteryOptimizations;
    }

    public static final void setInjectedMockDefaultController(@Nullable BaseController baseController) {
        INSTANCE.setInjectedMockDefaultController(baseController);
    }

    public final boolean brokerEligibleAndInstalled() {
        return getActiveBrokerPackageName() != null && brokerEligible();
    }

    @Override // com.microsoft.identity.common.java.controllers.IControllerFactory
    @NotNull
    public List<BaseController> getAllControllers() {
        String activeBrokerPackageName = getActiveBrokerPackageName();
        ArrayList arrayList = new ArrayList();
        if (activeBrokerPackageName != null && activeBrokerPackageName.length() != 0 && brokerEligible()) {
            arrayList.add(new BrokerMsalController(this.applicationContext, this.platformComponents, activeBrokerPackageName));
        }
        arrayList.add(new LocalMSALController());
        return CollectionsKt.toList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.controllers.IControllerFactory
    @NotNull
    public BaseController getDefaultController() {
        String activeBrokerPackageName = getActiveBrokerPackageName();
        return (activeBrokerPackageName == null || activeBrokerPackageName.length() == 0 || !brokerEligible()) ? new LocalMSALController() : new BrokerMsalController(this.applicationContext, this.platformComponents, activeBrokerPackageName);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MSALControllerFactory(@NotNull PublicClientApplicationConfiguration applicationConfiguration) {
        Intrinsics.checkNotNullParameter(applicationConfiguration, "applicationConfiguration");
        Authority defaultAuthority = applicationConfiguration.getDefaultAuthority();
        Intrinsics.checkNotNullExpressionValue(defaultAuthority, "applicationConfiguration.defaultAuthority");
        this(applicationConfiguration, defaultAuthority);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MSALControllerFactory(@NotNull PublicClientApplicationConfiguration applicationConfiguration, @NotNull Authority authority) {
        Intrinsics.checkNotNullParameter(applicationConfiguration, "applicationConfiguration");
        Intrinsics.checkNotNullParameter(authority, "authority");
        Context appContext = applicationConfiguration.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "applicationConfiguration.appContext");
        IPlatformComponents iPlatformComponentsCreateFromContext = AndroidPlatformComponentsFactory.createFromContext(applicationConfiguration.getAppContext());
        Intrinsics.checkNotNullExpressionValue(iPlatformComponentsCreateFromContext, "createFromContext(applic…Configuration.appContext)");
        this(appContext, iPlatformComponentsCreateFromContext, authority, applicationConfiguration);
    }
}

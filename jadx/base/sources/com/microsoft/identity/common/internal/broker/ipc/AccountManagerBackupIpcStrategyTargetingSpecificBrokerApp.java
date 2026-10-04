package com.microsoft.identity.common.internal.broker.ipc;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.broker.IBrokerValidator;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.util.AccountManagerUtil;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBo\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp;", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "accountTypeForEachPackage", "", "", "sendRequestViaAccountManager", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "accountType", "Landroid/os/Bundle;", "bundle", "getAccountManagerApps", "Lkotlin/Function0;", "", "Landroid/accounts/AuthenticatorDescription;", "brokerValidator", "Lcom/microsoft/identity/common/internal/broker/IBrokerValidator;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lcom/microsoft/identity/common/internal/broker/IBrokerValidator;)V", "communicateToBroker", "Lcom/microsoft/identity/common/internal/broker/ipc/BrokerOperationBundle;", "getType", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "isSupportedByTargetedBroker", "", "targetedBrokerPackageName", "validateTargetApp", "", "targetPackageName", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp implements IIpcStrategy {

    @NotNull
    public static final String AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE = "com.microsoft.authapppassthroughbackup";

    @NotNull
    public static final String CONTENT_PROVIDER_PATH_KEY = "CONTENT_PROVIDER_PATH";

    @NotNull
    public static final String CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE = "com.microsoft.cppassthroughbackup";

    @NotNull
    public static final String LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE = "com.microsoft.ltwpassthroughbackup";

    @NotNull
    public static final String REQUEST_BUNDLE_KEY = "REQUEST_BUNDLE";

    @NotNull
    private final Map<String, String> accountTypeForEachPackage;

    @NotNull
    private final IBrokerValidator brokerValidator;

    @NotNull
    private final Function0<AuthenticatorDescription[]> getAccountManagerApps;

    @NotNull
    private final Function2<String, Bundle, Bundle> sendRequestViaAccountManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.class).getSimpleName();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp$Companion;", "", "()V", "AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE", "", "CONTENT_PROVIDER_PATH_KEY", "CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE", "LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE", "REQUEST_BUNDLE_KEY", SearchConstants.TargetContents.TAG, "getTAG", "()Ljava/lang/String;", "getAccountTypeForEachPackage", "", "getAccountTypeForEachPackage$common_distRelease", "tryCreateInstance", "Lcom/microsoft/identity/common/internal/broker/ipc/AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp;", "context", "Landroid/content/Context;", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<String, String> getAccountTypeForEachPackage$common_distRelease() {
            BrokerData.Companion companion = BrokerData.INSTANCE;
            Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.m13893to(companion.getDebugMockLtw().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.m13893to(companion.getProdLTW().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.m13893to(companion.getDebugMockCp().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.m13893to(companion.getProdCompanyPortal().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.m13893to(companion.getDebugMockAuthApp().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.m13893to(companion.getProdMicrosoftAuthenticator().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE));
            Iterator<T> it = companion.getProdBrokers().iterator();
            while (it.hasNext()) {
                mapMapOf.containsKey(((BrokerData) it.next()).getPackageName());
            }
            return mapMapOf;
        }

        @Nullable
        public final String getTAG() {
            return AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.TAG;
        }

        @Nullable
        public final AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp tryCreateInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!AccountManagerUtil.canUseAccountManagerOperation(context, SetsKt.setOf((Object[]) new String[]{AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE, AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE, AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE}))) {
                return null;
            }
            final AccountManager accountManager = AccountManager.get(context);
            return new AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp(getAccountTypeForEachPackage$common_distRelease(), new Function2<String, Bundle, Bundle>() { // from class: com.microsoft.identity.common.internal.broker.ipc.AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp$Companion$tryCreateInstance$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Bundle invoke(@NotNull String accountType, @NotNull Bundle requestBundle) throws OperationCanceledException, IOException, AuthenticatorException {
                    Intrinsics.checkNotNullParameter(accountType, "accountType");
                    Intrinsics.checkNotNullParameter(requestBundle, "requestBundle");
                    Bundle result = accountManager.addAccount(accountType, null, null, requestBundle, null, null, ProcessUtil.getPreferredHandler()).getResult(5L, TimeUnit.SECONDS);
                    Intrinsics.checkNotNullExpressionValue(result, "accountManager.addAccoun…sult(5, TimeUnit.SECONDS)");
                    return result;
                }
            }, new Function0<AuthenticatorDescription[]>() { // from class: com.microsoft.identity.common.internal.broker.ipc.AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp$Companion$tryCreateInstance$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AuthenticatorDescription[] invoke() {
                    AuthenticatorDescription[] authenticatorTypes = accountManager.getAuthenticatorTypes();
                    Intrinsics.checkNotNullExpressionValue(authenticatorTypes, "accountManager.authenticatorTypes");
                    return authenticatorTypes;
                }
            }, new BrokerValidator(context));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp(@NotNull Map<String, String> accountTypeForEachPackage, @NotNull Function2<? super String, ? super Bundle, Bundle> sendRequestViaAccountManager, @NotNull Function0<AuthenticatorDescription[]> getAccountManagerApps, @NotNull IBrokerValidator brokerValidator) {
        Intrinsics.checkNotNullParameter(accountTypeForEachPackage, "accountTypeForEachPackage");
        Intrinsics.checkNotNullParameter(sendRequestViaAccountManager, "sendRequestViaAccountManager");
        Intrinsics.checkNotNullParameter(getAccountManagerApps, "getAccountManagerApps");
        Intrinsics.checkNotNullParameter(brokerValidator, "brokerValidator");
        this.accountTypeForEachPackage = accountTypeForEachPackage;
        this.sendRequestViaAccountManager = sendRequestViaAccountManager;
        this.getAccountManagerApps = getAccountManagerApps;
        this.brokerValidator = brokerValidator;
    }

    private final void validateTargetApp(String targetPackageName, String accountType) throws BrokerCommunicationException {
        for (AuthenticatorDescription authenticatorDescription : this.getAccountManagerApps.invoke()) {
            AuthenticatorDescription authenticatorDescription2 = authenticatorDescription;
            if (Intrinsics.areEqual(authenticatorDescription2.packageName, targetPackageName) && Intrinsics.areEqual(authenticatorDescription2.type, accountType)) {
                AuthenticatorDescription authenticatorDescription3 = authenticatorDescription;
                IBrokerValidator iBrokerValidator = this.brokerValidator;
                String str = authenticatorDescription3.packageName;
                Intrinsics.checkNotNullExpressionValue(str, "targetAppInfo.packageName");
                if (iBrokerValidator.isValidBrokerPackage(str)) {
                    return;
                }
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.VALIDATION_ERROR, getType(), AbstractC0622a.m1170p(authenticatorDescription3.packageName, " is not a valid broker app.", new StringBuilder()), null);
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    @Nullable
    public Bundle communicateToBroker(@NotNull BrokerOperationBundle bundle) throws BrokerCommunicationException {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String strM1170p = AbstractC0622a.m1170p(TAG, ":communicateToBroker", new StringBuilder());
        String str = bundle.targetBrokerAppPackageName;
        Intrinsics.checkNotNullExpressionValue(str, "bundle.targetBrokerAppPackageName");
        String str2 = this.accountTypeForEachPackage.get(str);
        if (str2 == null) {
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, getType(), AbstractC0541b.m773o("AccountManagerBackupIpcStrategy doesn't recognize ", str, " as a broker"), null);
        }
        String str3 = str2;
        validateTargetApp(str, str3);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(REQUEST_BUNDLE_KEY, bundle.bundle);
        bundle2.putString(CONTENT_PROVIDER_PATH_KEY, bundle.operation.getContentApi().getPath());
        try {
            return this.sendRequestViaAccountManager.invoke(str3, bundle2);
        } catch (Throwable th) {
            String message = th.getMessage();
            String strConcat = (message == null || message.length() == 0) ? th.getClass().getSimpleName().concat(" is thrown") : th.getMessage();
            Logger.error(strM1170p, strConcat, th);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), AbstractC0541b.m772n("AccountManager failed to respond - ", strConcat), th);
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    @NotNull
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.ACCOUNT_MANAGER_ADD_ACCOUNT;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(@NotNull String targetedBrokerPackageName) {
        Intrinsics.checkNotNullParameter(targetedBrokerPackageName, "targetedBrokerPackageName");
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isSupportedByTargetedBroker", new StringBuilder());
        try {
            String str = this.accountTypeForEachPackage.get(targetedBrokerPackageName);
            if (str != null) {
                validateTargetApp(targetedBrokerPackageName, str);
                return true;
            }
            Logger.info(strM1170p, "AccountManagerBackupIpcStrategy doesn't recognize " + targetedBrokerPackageName + " as a broker");
            return false;
        } catch (Throwable th) {
            Logger.error(strM1170p, th.getMessage(), th);
            return false;
        }
    }
}

package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.java.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0016"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/BrokerData;", "", "packageName", "", "signingCertificateThumbprint", "(Ljava/lang/String;Ljava/lang/String;)V", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getSigningCertificateThumbprint", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final /* data */ class BrokerData {

    @NotNull
    private static final Set<String> accountManagerBrokers;

    @NotNull
    private static final Set<BrokerData> allBrokers;

    @NotNull
    private static final Set<BrokerData> debugBrokers;

    @NotNull
    private static final Set<BrokerData> prodBrokers;

    @Nullable
    private final String nickName;

    @NotNull
    private final String packageName;

    @NotNull
    private final String signingCertificateThumbprint;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(BrokerData.class).getSimpleName();
    private static boolean sShouldTrustDebugBrokers = false;

    @NotNull
    private static final BrokerData debugMicrosoftAuthenticator = new BrokerData(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME, AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_DEBUG_SIGNATURE_SHA512, "debugMicrosoftAuthenticator");

    @NotNull
    private static final BrokerData prodMicrosoftAuthenticator = new BrokerData(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME, AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_RELEASE_SIGNATURE_SHA512, "prodMicrosoftAuthenticator");

    @NotNull
    private static final BrokerData debugCompanyPortal = new BrokerData(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME, AuthenticationConstants.Broker.COMPANY_PORTAL_APP_DEBUG_SIGNATURE_SHA512, "debugCompanyPortal");

    @NotNull
    private static final BrokerData prodCompanyPortal = new BrokerData(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME, AuthenticationConstants.Broker.COMPANY_PORTAL_APP_RELEASE_SIGNATURE_SHA512, "prodCompanyPortal");

    @NotNull
    private static final BrokerData debugBrokerHost = new BrokerData(AuthenticationConstants.Broker.BROKER_HOST_APP_PACKAGE_NAME, AuthenticationConstants.Broker.BROKER_HOST_APP_SIGNATURE_SHA512, "debugBrokerHost");

    @NotNull
    private static final BrokerData debugMockCp = new BrokerData(AuthenticationConstants.Broker.MOCK_CP_PACKAGE_NAME, AuthenticationConstants.Broker.MOCK_CP_SIGNATURE_SHA512, "debugMockCp");

    @NotNull
    private static final BrokerData debugMockAuthApp = new BrokerData(AuthenticationConstants.Broker.MOCK_AUTH_APP_PACKAGE_NAME, AuthenticationConstants.Broker.MOCK_AUTH_APP_SIGNATURE_SHA512, "debugMockAuthApp");

    @NotNull
    private static final BrokerData debugMockLtw = new BrokerData(AuthenticationConstants.Broker.MOCK_LTW_PACKAGE_NAME, AuthenticationConstants.Broker.MOCK_LTW_SIGNATURE_SHA512, "debugMockLtw");

    @NotNull
    private static final BrokerData prodLTW = new BrokerData(AuthenticationConstants.Broker.LTW_APP_PACKAGE_NAME, AuthenticationConstants.Broker.LTW_APP_SHA512_RELEASE_SIGNATURE, "prodLTW");

    @NotNull
    private static final BrokerData debugLTW = new BrokerData(AuthenticationConstants.Broker.LTW_APP_PACKAGE_NAME, AuthenticationConstants.Broker.LTW_APP_SHA512_DEBUG_SIGNATURE, "debugLTW");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u00107\u001a\u0004\u0018\u00010\r2\u0006\u00108\u001a\u000209H\u0007J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0007J\b\u0010;\u001a\u000206H\u0007J\u0010\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u0004H\u0007J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u000206H\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0013R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0002\u001a\u0004\b+\u0010\u000bR\u001c\u0010,\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\u0013R\u001c\u0010/\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0002\u001a\u0004\b1\u0010\u0013R\u001c\u00102\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0002\u001a\u0004\b4\u0010\u0013R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/BrokerData$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "accountManagerBrokers", "", "getAccountManagerBrokers$annotations", "getAccountManagerBrokers", "()Ljava/util/Set;", "allBrokers", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "getAllBrokers$annotations", "getAllBrokers", "debugBrokerHost", "getDebugBrokerHost$annotations", "getDebugBrokerHost", "()Lcom/microsoft/identity/common/internal/broker/BrokerData;", "debugBrokers", "getDebugBrokers$annotations", "getDebugBrokers", "debugCompanyPortal", "getDebugCompanyPortal$annotations", "getDebugCompanyPortal", "debugLTW", "getDebugLTW$annotations", "getDebugLTW", "debugMicrosoftAuthenticator", "getDebugMicrosoftAuthenticator$annotations", "getDebugMicrosoftAuthenticator", "debugMockAuthApp", "getDebugMockAuthApp$annotations", "getDebugMockAuthApp", "debugMockCp", "getDebugMockCp$annotations", "getDebugMockCp", "debugMockLtw", "getDebugMockLtw$annotations", "getDebugMockLtw", "prodBrokers", "getProdBrokers$annotations", "getProdBrokers", "prodCompanyPortal", "getProdCompanyPortal$annotations", "getProdCompanyPortal", "prodLTW", "getProdLTW$annotations", "getProdLTW", "prodMicrosoftAuthenticator", "getProdMicrosoftAuthenticator$annotations", "getProdMicrosoftAuthenticator", "sShouldTrustDebugBrokers", "", "getFromContext", "context", "Landroid/content/Context;", "getKnownBrokerApps", "getShouldTrustDebugBrokers", "isAccountManagerSupported", "packageName", "setShouldTrustDebugBrokers", "", "value", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Set<String> getAccountManagerBrokers() {
            return BrokerData.accountManagerBrokers;
        }

        @NotNull
        public final Set<BrokerData> getAllBrokers() {
            return BrokerData.allBrokers;
        }

        @NotNull
        public final BrokerData getDebugBrokerHost() {
            return BrokerData.debugBrokerHost;
        }

        @NotNull
        public final Set<BrokerData> getDebugBrokers() {
            return BrokerData.debugBrokers;
        }

        @NotNull
        public final BrokerData getDebugCompanyPortal() {
            return BrokerData.debugCompanyPortal;
        }

        @NotNull
        public final BrokerData getDebugLTW() {
            return BrokerData.debugLTW;
        }

        @NotNull
        public final BrokerData getDebugMicrosoftAuthenticator() {
            return BrokerData.debugMicrosoftAuthenticator;
        }

        @NotNull
        public final BrokerData getDebugMockAuthApp() {
            return BrokerData.debugMockAuthApp;
        }

        @NotNull
        public final BrokerData getDebugMockCp() {
            return BrokerData.debugMockCp;
        }

        @NotNull
        public final BrokerData getDebugMockLtw() {
            return BrokerData.debugMockLtw;
        }

        @JvmStatic
        @Nullable
        public final BrokerData getFromContext(@NotNull Context context) {
            Object next;
            Intrinsics.checkNotNullParameter(context, "context");
            String sha512SignatureForPackage = new PackageHelper(context).getSha512SignatureForPackage(context.getPackageName());
            if (Intrinsics.areEqual(context.getPackageName(), getDebugBrokerHost().getPackageName()) && (sha512SignatureForPackage == null || sha512SignatureForPackage.length() == 0)) {
                return getDebugBrokerHost();
            }
            Iterator<T> it = getAllBrokers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                BrokerData brokerData = (BrokerData) next;
                if (Intrinsics.areEqual(brokerData.getPackageName(), context.getPackageName()) && Intrinsics.areEqual(brokerData.getSigningCertificateThumbprint(), sha512SignatureForPackage)) {
                    break;
                }
            }
            return (BrokerData) next;
        }

        @JvmStatic
        @NotNull
        public final Set<BrokerData> getKnownBrokerApps() {
            return BrokerData.sShouldTrustDebugBrokers ? getAllBrokers() : getProdBrokers();
        }

        @NotNull
        public final Set<BrokerData> getProdBrokers() {
            return BrokerData.prodBrokers;
        }

        @NotNull
        public final BrokerData getProdCompanyPortal() {
            return BrokerData.prodCompanyPortal;
        }

        @NotNull
        public final BrokerData getProdLTW() {
            return BrokerData.prodLTW;
        }

        @NotNull
        public final BrokerData getProdMicrosoftAuthenticator() {
            return BrokerData.prodMicrosoftAuthenticator;
        }

        @JvmStatic
        public final boolean getShouldTrustDebugBrokers() {
            return BrokerData.sShouldTrustDebugBrokers;
        }

        @Nullable
        public final String getTAG() {
            return BrokerData.TAG;
        }

        @JvmStatic
        public final boolean isAccountManagerSupported(@NotNull String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return getAccountManagerBrokers().contains(packageName);
        }

        @JvmStatic
        public final void setShouldTrustDebugBrokers(boolean value) {
            String str = getTAG() + ":setShouldTrustDebugBrokers";
            if (value) {
                Logger.warn(str, "You are forcing to trust debug brokers in non-debug builds.");
            }
            BrokerData.sShouldTrustDebugBrokers = value;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getAccountManagerBrokers$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getAllBrokers$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugBrokerHost$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugBrokers$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugCompanyPortal$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugLTW$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugMicrosoftAuthenticator$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugMockAuthApp$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugMockCp$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDebugMockLtw$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProdBrokers$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProdCompanyPortal$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProdLTW$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getProdMicrosoftAuthenticator$annotations() {
        }
    }

    static {
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet<String>() { // from class: com.microsoft.identity.common.internal.broker.BrokerData$Companion$accountManagerBrokers$1
            {
                add(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME);
                add(AuthenticationConstants.Broker.COMPANY_PORTAL_APP_PACKAGE_NAME);
                add(AuthenticationConstants.Broker.BROKER_HOST_APP_PACKAGE_NAME);
                add(AuthenticationConstants.Broker.MOCK_AUTH_APP_PACKAGE_NAME);
                add(AuthenticationConstants.Broker.MOCK_CP_PACKAGE_NAME);
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof String) {
                    return contains((String) obj);
                }
                return false;
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return false;
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ int size() {
                return getSize();
            }

            public /* bridge */ boolean contains(String str) {
                return super.contains((Object) str);
            }

            public /* bridge */ boolean remove(String str) {
                return super.remove((Object) str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(object :…         }\n            })");
        accountManagerBrokers = setUnmodifiableSet;
        Set<BrokerData> setUnmodifiableSet2 = Collections.unmodifiableSet(new HashSet<BrokerData>() { // from class: com.microsoft.identity.common.internal.broker.BrokerData$Companion$debugBrokers$1
            {
                BrokerData.Companion companion = BrokerData.INSTANCE;
                add(companion.getDebugMicrosoftAuthenticator());
                add(companion.getDebugLTW());
                add(companion.getDebugCompanyPortal());
                add(companion.getDebugBrokerHost());
                add(companion.getDebugMockCp());
                add(companion.getDebugMockAuthApp());
                add(companion.getDebugMockLtw());
            }

            public /* bridge */ boolean contains(BrokerData brokerData) {
                return super.contains((Object) brokerData);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ boolean remove(BrokerData brokerData) {
                return super.remove((Object) brokerData);
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof BrokerData) {
                    return contains((BrokerData) obj);
                }
                return false;
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean remove(Object obj) {
                if (obj instanceof BrokerData) {
                    return remove((BrokerData) obj);
                }
                return false;
            }
        });
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet2, "unmodifiableSet(object :…         }\n            })");
        debugBrokers = setUnmodifiableSet2;
        Set<BrokerData> setUnmodifiableSet3 = Collections.unmodifiableSet(new HashSet<BrokerData>() { // from class: com.microsoft.identity.common.internal.broker.BrokerData$Companion$prodBrokers$1
            {
                BrokerData.Companion companion = BrokerData.INSTANCE;
                add(companion.getProdMicrosoftAuthenticator());
                add(companion.getProdCompanyPortal());
                add(companion.getProdLTW());
            }

            public /* bridge */ boolean contains(BrokerData brokerData) {
                return super.contains((Object) brokerData);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ boolean remove(BrokerData brokerData) {
                return super.remove((Object) brokerData);
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof BrokerData) {
                    return contains((BrokerData) obj);
                }
                return false;
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean remove(Object obj) {
                if (obj instanceof BrokerData) {
                    return remove((BrokerData) obj);
                }
                return false;
            }
        });
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet3, "unmodifiableSet(object :…         }\n            })");
        prodBrokers = setUnmodifiableSet3;
        Set<BrokerData> setUnmodifiableSet4 = Collections.unmodifiableSet(new HashSet<BrokerData>() { // from class: com.microsoft.identity.common.internal.broker.BrokerData$Companion$allBrokers$1
            {
                BrokerData.Companion companion = BrokerData.INSTANCE;
                addAll(companion.getDebugBrokers());
                addAll(companion.getProdBrokers());
            }

            public /* bridge */ boolean contains(BrokerData brokerData) {
                return super.contains((Object) brokerData);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ boolean remove(BrokerData brokerData) {
                return super.remove((Object) brokerData);
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof BrokerData) {
                    return contains((BrokerData) obj);
                }
                return false;
            }

            @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final /* bridge */ boolean remove(Object obj) {
                if (obj instanceof BrokerData) {
                    return remove((BrokerData) obj);
                }
                return false;
            }
        });
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet4, "unmodifiableSet(object :…         }\n            })");
        allBrokers = setUnmodifiableSet4;
    }

    public BrokerData(@NotNull String packageName, @NotNull String signingCertificateThumbprint, @Nullable String str) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingCertificateThumbprint, "signingCertificateThumbprint");
        this.packageName = packageName;
        this.signingCertificateThumbprint = signingCertificateThumbprint;
        this.nickName = str;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final String getNickName() {
        return this.nickName;
    }

    public static /* synthetic */ BrokerData copy$default(BrokerData brokerData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brokerData.packageName;
        }
        if ((i & 2) != 0) {
            str2 = brokerData.signingCertificateThumbprint;
        }
        if ((i & 4) != 0) {
            str3 = brokerData.nickName;
        }
        return brokerData.copy(str, str2, str3);
    }

    @NotNull
    public static final Set<String> getAccountManagerBrokers() {
        return INSTANCE.getAccountManagerBrokers();
    }

    @NotNull
    public static final Set<BrokerData> getAllBrokers() {
        return INSTANCE.getAllBrokers();
    }

    @NotNull
    public static final BrokerData getDebugBrokerHost() {
        return INSTANCE.getDebugBrokerHost();
    }

    @NotNull
    public static final Set<BrokerData> getDebugBrokers() {
        return INSTANCE.getDebugBrokers();
    }

    @NotNull
    public static final BrokerData getDebugCompanyPortal() {
        return INSTANCE.getDebugCompanyPortal();
    }

    @NotNull
    public static final BrokerData getDebugLTW() {
        return INSTANCE.getDebugLTW();
    }

    @NotNull
    public static final BrokerData getDebugMicrosoftAuthenticator() {
        return INSTANCE.getDebugMicrosoftAuthenticator();
    }

    @NotNull
    public static final BrokerData getDebugMockAuthApp() {
        return INSTANCE.getDebugMockAuthApp();
    }

    @NotNull
    public static final BrokerData getDebugMockCp() {
        return INSTANCE.getDebugMockCp();
    }

    @NotNull
    public static final BrokerData getDebugMockLtw() {
        return INSTANCE.getDebugMockLtw();
    }

    @JvmStatic
    @Nullable
    public static final BrokerData getFromContext(@NotNull Context context) {
        return INSTANCE.getFromContext(context);
    }

    @JvmStatic
    @NotNull
    public static final Set<BrokerData> getKnownBrokerApps() {
        return INSTANCE.getKnownBrokerApps();
    }

    @NotNull
    public static final Set<BrokerData> getProdBrokers() {
        return INSTANCE.getProdBrokers();
    }

    @NotNull
    public static final BrokerData getProdCompanyPortal() {
        return INSTANCE.getProdCompanyPortal();
    }

    @NotNull
    public static final BrokerData getProdLTW() {
        return INSTANCE.getProdLTW();
    }

    @NotNull
    public static final BrokerData getProdMicrosoftAuthenticator() {
        return INSTANCE.getProdMicrosoftAuthenticator();
    }

    @JvmStatic
    public static final boolean getShouldTrustDebugBrokers() {
        return INSTANCE.getShouldTrustDebugBrokers();
    }

    @JvmStatic
    public static final boolean isAccountManagerSupported(@NotNull String str) {
        return INSTANCE.isAccountManagerSupported(str);
    }

    @JvmStatic
    public static final void setShouldTrustDebugBrokers(boolean z) {
        INSTANCE.setShouldTrustDebugBrokers(z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSigningCertificateThumbprint() {
        return this.signingCertificateThumbprint;
    }

    @NotNull
    public final BrokerData copy(@NotNull String packageName, @NotNull String signingCertificateThumbprint, @Nullable String nickName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingCertificateThumbprint, "signingCertificateThumbprint");
        return new BrokerData(packageName, signingCertificateThumbprint, nickName);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof BrokerData)) {
            return false;
        }
        BrokerData brokerData = (BrokerData) other;
        return StringsKt__StringsJVMKt.equals(this.packageName, brokerData.packageName, true) && Intrinsics.areEqual(this.signingCertificateThumbprint, brokerData.signingCertificateThumbprint);
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getSigningCertificateThumbprint() {
        return this.signingCertificateThumbprint;
    }

    public int hashCode() {
        return this.signingCertificateThumbprint.hashCode() + (this.packageName.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        String str = this.nickName;
        if (str != null && str.length() != 0) {
            return this.nickName;
        }
        return this.packageName + "::" + this.signingCertificateThumbprint;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrokerData(@NotNull String packageName, @NotNull String signingCertificateThumbprint) {
        this(packageName, signingCertificateThumbprint, null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingCertificateThumbprint, "signingCertificateThumbprint");
    }
}

package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.util.PackageUtils;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B|\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012'\u0010\b\u001a#\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\t\u0012<\u0010\u0010\u001a8\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a#\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0010\u001a8\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/BrokerValidator;", "Lcom/microsoft/identity/common/internal/broker/IBrokerValidator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowedBrokerApps", "", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "getSigningCertificateForApp", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "packageName", "", "Ljava/security/cert/X509Certificate;", "validateSigningCertificate", "Lkotlin/Function2;", "expectedSigningCertificateSignature", "signingCertificates", "", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "expectedSigningCertificateThumbprint", "isSignedByKnownKeys", "", "brokerData", "isValidBrokerPackage", "verifySignature", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public class BrokerValidator implements IBrokerValidator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(BrokerValidator.class).getSimpleName();

    @NotNull
    private final Set<BrokerData> allowedBrokerApps;

    @NotNull
    private final Function1<String, List<X509Certificate>> getSigningCertificateForApp;

    @NotNull
    private final Function2<String, List<? extends X509Certificate>, Unit> validateSigningCertificate;

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.broker.BrokerValidator$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public /* synthetic */ class C62432 extends FunctionReferenceImpl implements Function2<String, List<? extends X509Certificate>, Unit> {
        public C62432(Object obj) {
            super(2, obj, Companion.class, "validateSigningCertificate", "validateSigningCertificate(Ljava/lang/String;Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends X509Certificate> list) throws NoSuchAlgorithmException, CertificateException, CertPathValidatorException, ClientException, InvalidAlgorithmParameterException {
            invoke2(str, list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String p0, @NotNull List<? extends X509Certificate> p1) throws NoSuchAlgorithmException, CertificateException, CertPathValidatorException, ClientException, InvalidAlgorithmParameterException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((Companion) this.receiver).validateSigningCertificate(p0, p1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/broker/BrokerValidator$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "validateSigningCertificate", "", "expectedSigningCertificateThumbprint", "signingCertificates", "", "Ljava/security/cert/X509Certificate;", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void validateSigningCertificate(@NotNull String expectedSigningCertificateThumbprint, @NotNull List<? extends X509Certificate> signingCertificates) throws NoSuchAlgorithmException, CertificateException, CertPathValidatorException, ClientException, InvalidAlgorithmParameterException {
            Intrinsics.checkNotNullParameter(expectedSigningCertificateThumbprint, "expectedSigningCertificateThumbprint");
            Intrinsics.checkNotNullParameter(signingCertificates, "signingCertificates");
            PackageUtils.verifySignatureHash(signingCertificates, SetsKt.setOf(expectedSigningCertificateThumbprint).iterator());
            if (signingCertificates.size() > 1) {
                PackageUtils.verifyCertificateChain(signingCertificates);
            }
        }

        private Companion() {
        }
    }

    public BrokerValidator(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.allowedBrokerApps = BrokerData.INSTANCE.getKnownBrokerApps();
        this.getSigningCertificateForApp = new Function1<String, List<X509Certificate>>() { // from class: com.microsoft.identity.common.internal.broker.BrokerValidator.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<X509Certificate> invoke(@NotNull String packageName) throws ClientException {
                Intrinsics.checkNotNullParameter(packageName, "packageName");
                List<X509Certificate> certDataForApp = PackageUtils.readCertDataForApp(packageName, context);
                Intrinsics.checkNotNullExpressionValue(certDataForApp, "readCertDataForApp(packageName, context)");
                return certDataForApp;
            }
        };
        this.validateSigningCertificate = new C62432(INSTANCE);
    }

    @Override // com.microsoft.identity.common.internal.broker.IBrokerValidator
    public boolean isSignedByKnownKeys(@NotNull BrokerData brokerData) {
        Intrinsics.checkNotNullParameter(brokerData, "brokerData");
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isSignedByKnownKeys", new StringBuilder());
        try {
            this.validateSigningCertificate.invoke(brokerData.getSigningCertificateThumbprint(), this.getSigningCertificateForApp.invoke(brokerData.getPackageName()));
            Logger.verbose(strM1170p, brokerData + " is a valid broker app.");
            return true;
        } catch (Throwable th) {
            Logger.verbose(strM1170p, brokerData + " verification failed: " + th.getMessage());
            return false;
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.IBrokerValidator
    public boolean isValidBrokerPackage(@NotNull String packageName) {
        Object next;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isValidBrokerPackage", new StringBuilder());
        Set<BrokerData> set = this.allowedBrokerApps;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (StringsKt__StringsJVMKt.equals(((BrokerData) obj).getPackageName(), packageName, true)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (isSignedByKnownKeys((BrokerData) next)) {
                break;
            }
        }
        if (((BrokerData) next) != null) {
            return true;
        }
        Logger.info(strM1170p, packageName + " does not match with any known broker apps.");
        return false;
    }

    public boolean verifySignature(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return isValidBrokerPackage(packageName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BrokerValidator(@NotNull Set<BrokerData> allowedBrokerApps, @NotNull Function1<? super String, ? extends List<? extends X509Certificate>> getSigningCertificateForApp, @NotNull Function2<? super String, ? super List<? extends X509Certificate>, Unit> validateSigningCertificate) {
        Intrinsics.checkNotNullParameter(allowedBrokerApps, "allowedBrokerApps");
        Intrinsics.checkNotNullParameter(getSigningCertificateForApp, "getSigningCertificateForApp");
        Intrinsics.checkNotNullParameter(validateSigningCertificate, "validateSigningCertificate");
        this.allowedBrokerApps = allowedBrokerApps;
        this.getSigningCertificateForApp = getSigningCertificateForApp;
        this.validateSigningCertificate = validateSigningCertificate;
    }
}

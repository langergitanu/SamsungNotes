package androidx.credentials;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/CredentialProviderFactory;", "", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CredentialProviderFactory {

    @NotNull
    private static final String CREDENTIAL_PROVIDER_KEY = "androidx.credentials.CREDENTIAL_PROVIDER_KEY";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CRED_MAN_PRE_FRAMEWORK_API_LEVEL = 33;

    @NotNull
    private static final String TAG = "CredProviderFactory";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\u000f\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Landroidx/credentials/CredentialProviderFactory$Companion;", "", "()V", "CREDENTIAL_PROVIDER_KEY", "", "MAX_CRED_MAN_PRE_FRAMEWORK_API_LEVEL", "", SearchConstants.TargetContents.TAG, "getAllowedProvidersFromManifest", "", "context", "Landroid/content/Context;", "getBestAvailableProvider", "Landroidx/credentials/CredentialProvider;", "getUAndAboveProvider", "instantiatePreUProvider", "classNames", "tryCreatePreUOemProvider", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> getAllowedProvidersFromManifest(Context context) throws PackageManager.NameNotFoundException {
            String string;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
            ArrayList arrayList = new ArrayList();
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                Intrinsics.checkNotNullExpressionValue(serviceInfoArr, "packageInfo.services");
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    Bundle bundle = serviceInfo.metaData;
                    if (bundle != null && (string = bundle.getString(CredentialProviderFactory.CREDENTIAL_PROVIDER_KEY)) != null) {
                        arrayList.add(string);
                    }
                }
            }
            return CollectionsKt.toList(arrayList);
        }

        private final CredentialProvider instantiatePreUProvider(List<String> classNames, Context context) {
            Iterator<String> it = classNames.iterator();
            CredentialProvider credentialProvider = null;
            while (it.hasNext()) {
                try {
                    Object objNewInstance = Class.forName(it.next()).getConstructor(Context.class).newInstance(context);
                    Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.credentials.CredentialProvider");
                    CredentialProvider credentialProvider2 = (CredentialProvider) objNewInstance;
                    if (!credentialProvider2.isAvailableOnDevice()) {
                        continue;
                    } else {
                        if (credentialProvider != null) {
                            Log.i(CredentialProviderFactory.TAG, "Only one active OEM CredentialProvider allowed");
                            return null;
                        }
                        credentialProvider = credentialProvider2;
                    }
                } catch (Throwable unused) {
                }
            }
            return credentialProvider;
        }

        private final CredentialProvider tryCreatePreUOemProvider(Context context) throws PackageManager.NameNotFoundException {
            List<String> allowedProvidersFromManifest = getAllowedProvidersFromManifest(context);
            if (allowedProvidersFromManifest.isEmpty()) {
                return null;
            }
            return instantiatePreUProvider(allowedProvidersFromManifest, context);
        }

        @Nullable
        public final CredentialProvider getBestAvailableProvider(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                return new CredentialProviderFrameworkImpl(context);
            }
            if (i <= 33) {
                return tryCreatePreUOemProvider(context);
            }
            return null;
        }

        @RequiresApi(34)
        @NotNull
        public final CredentialProvider getUAndAboveProvider(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new CredentialProviderFrameworkImpl(context);
        }

        private Companion() {
        }
    }
}

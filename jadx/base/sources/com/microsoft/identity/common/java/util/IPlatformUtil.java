package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.commands.ICommand;
import com.microsoft.identity.common.java.p132ui.BrowserDescriptor;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.List;
import javax.net.ssl.KeyManagerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IPlatformUtil {
    List<BrowserDescriptor> getBrowserSafeListForBroker();

    @Nullable
    String getEnrollmentId(@NonNull String str, @NonNull String str2);

    @Nullable
    String getInstalledCompanyPortalVersion();

    long getNanosecondTime();

    @Nullable
    String getPackageNameFromUid(int i);

    KeyManagerFactory getSslContextKeyManagerFactory();

    boolean isValidCallingApp(@NonNull String str, @NonNull String str2);

    void onReturnCommandResult(@NonNull ICommand<?> iCommand);

    void postCommandResult(@NonNull Runnable runnable);

    void removeCookiesFromWebView();

    void throwIfNetworkNotAvailable(boolean z);
}

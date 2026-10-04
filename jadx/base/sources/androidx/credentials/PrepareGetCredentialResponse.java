package androidx.credentials;

import android.annotation.SuppressLint;
import android.credentials.PrepareGetCredentialResponse;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eBa\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\u0004\u0018\u0001`\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\fH\u0007J\b\u0010\u001b\u001a\u00020\u0006H\u0007R%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\u0004\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, m13886d2 = {"Landroidx/credentials/PrepareGetCredentialResponse;", "", "pendingGetCredentialHandle", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "hasRemoteResultsDelegate", "Lkotlin/Function0;", "", "Landroidx/credentials/HasRemoteResultsDelegate;", "hasAuthResultsDelegate", "Landroidx/credentials/HasAuthenticationResultsDelegate;", "credentialTypeDelegate", "Lkotlin/Function1;", "", "Landroidx/credentials/HasCredentialResultsDelegate;", "isNullHandlesForTest", "(Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "getCredentialTypeDelegate", "()Lkotlin/jvm/functions/Function1;", "getHasAuthResultsDelegate", "()Lkotlin/jvm/functions/Function0;", "getHasRemoteResultsDelegate", "()Z", "getPendingGetCredentialHandle", "()Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "hasAuthenticationResults", "hasCredentialResults", "credentialType", "hasRemoteResults", "Builder", "PendingGetCredentialHandle", "TestBuilder", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SuppressLint({"MissingGetterMatchingBuilder"})
public final class PrepareGetCredentialResponse {

    @Nullable
    private final Function1<String, Boolean> credentialTypeDelegate;

    @Nullable
    private final Function0<Boolean> hasAuthResultsDelegate;

    @Nullable
    private final Function0<Boolean> hasRemoteResultsDelegate;
    private final boolean isNullHandlesForTest;

    @Nullable
    private final PendingGetCredentialHandle pendingGetCredentialHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0007H\u0003J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0003J\b\u0010\u0016\u001a\u00020\u0007H\u0003J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nj\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Landroidx/credentials/PrepareGetCredentialResponse$Builder;", "", "()V", "frameworkResponse", "Landroid/credentials/PrepareGetCredentialResponse;", "hasAuthResultsDelegate", "Lkotlin/Function0;", "", "Landroidx/credentials/HasAuthenticationResultsDelegate;", "hasCredentialResultsDelegate", "Lkotlin/Function1;", "", "Landroidx/credentials/HasCredentialResultsDelegate;", "hasRemoteResultsDelegate", "Landroidx/credentials/HasRemoteResultsDelegate;", "pendingGetCredentialHandle", "Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "build", "Landroidx/credentials/PrepareGetCredentialResponse;", "hasAuthenticationResults", "hasCredentialType", "credentialType", "hasRemoteResults", "setFrameworkResponse", "resp", "setPendingGetCredentialHandle", "handle", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class Builder {

        @Nullable
        private android.credentials.PrepareGetCredentialResponse frameworkResponse;

        @Nullable
        private Function0<Boolean> hasAuthResultsDelegate;

        @Nullable
        private Function1<? super String, Boolean> hasCredentialResultsDelegate;

        @Nullable
        private Function0<Boolean> hasRemoteResultsDelegate;

        @Nullable
        private PendingGetCredentialHandle pendingGetCredentialHandle;

        /* JADX INFO: Access modifiers changed from: private */
        @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
        public final boolean hasAuthenticationResults() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasAuthenticationResults();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
        public final boolean hasCredentialType(String credentialType) {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasCredentialResults(credentialType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
        public final boolean hasRemoteResults() {
            android.credentials.PrepareGetCredentialResponse prepareGetCredentialResponse = this.frameworkResponse;
            Intrinsics.checkNotNull(prepareGetCredentialResponse);
            return prepareGetCredentialResponse.hasRemoteResults();
        }

        @NotNull
        public final PrepareGetCredentialResponse build() {
            return new PrepareGetCredentialResponse(this.pendingGetCredentialHandle, this.hasRemoteResultsDelegate, this.hasAuthResultsDelegate, this.hasCredentialResultsDelegate, false, null);
        }

        @NotNull
        public final Builder setFrameworkResponse(@Nullable android.credentials.PrepareGetCredentialResponse resp) {
            this.frameworkResponse = resp;
            if (resp != null) {
                this.hasCredentialResultsDelegate = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$1(this);
                this.hasAuthResultsDelegate = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$2(this);
                this.hasRemoteResultsDelegate = new PrepareGetCredentialResponse$Builder$setFrameworkResponse$3(this);
            }
            return this;
        }

        @NotNull
        public final Builder setPendingGetCredentialHandle(@NotNull PendingGetCredentialHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "handle");
            this.pendingGetCredentialHandle = handle;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "", "frameworkHandle", "Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "(Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;)V", "getFrameworkHandle", "()Landroid/credentials/PrepareGetCredentialResponse$PendingGetCredentialHandle;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class PendingGetCredentialHandle {

        @Nullable
        private final PrepareGetCredentialResponse.PendingGetCredentialHandle frameworkHandle;

        public PendingGetCredentialHandle(@Nullable PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle) {
            this.frameworkHandle = pendingGetCredentialHandle;
            if (Build.VERSION.SDK_INT >= 34) {
                Intrinsics.checkNotNull(pendingGetCredentialHandle);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Nullable
        public final PrepareGetCredentialResponse.PendingGetCredentialHandle getFrameworkHandle() {
            return this.frameworkHandle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00002\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bj\u0002`\nH\u0007J\u001a\u0010\u0011\u001a\u00020\u00002\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0007J\u001a\u0010\u0012\u001a\u00020\u00002\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\fH\u0007R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Landroidx/credentials/PrepareGetCredentialResponse$TestBuilder;", "", "()V", "hasAuthResultsDelegate", "Lkotlin/Function0;", "", "Landroidx/credentials/HasAuthenticationResultsDelegate;", "hasCredentialResultsDelegate", "Lkotlin/Function1;", "", "Landroidx/credentials/HasCredentialResultsDelegate;", "hasRemoteResultsDelegate", "Landroidx/credentials/HasRemoteResultsDelegate;", "build", "Landroidx/credentials/PrepareGetCredentialResponse;", "setCredentialTypeDelegate", "handler", "setHasAuthResultsDelegate", "setHasRemoteResultsDelegate", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @VisibleForTesting
    public static final class TestBuilder {

        @Nullable
        private Function0<Boolean> hasAuthResultsDelegate;

        @Nullable
        private Function1<? super String, Boolean> hasCredentialResultsDelegate;

        @Nullable
        private Function0<Boolean> hasRemoteResultsDelegate;

        @NotNull
        public final PrepareGetCredentialResponse build() {
            return new PrepareGetCredentialResponse(null, this.hasRemoteResultsDelegate, this.hasAuthResultsDelegate, this.hasCredentialResultsDelegate, true, null);
        }

        @VisibleForTesting
        @NotNull
        public final TestBuilder setCredentialTypeDelegate(@NotNull Function1<? super String, Boolean> handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.hasCredentialResultsDelegate = handler;
            return this;
        }

        @VisibleForTesting
        @NotNull
        public final TestBuilder setHasAuthResultsDelegate(@NotNull Function0<Boolean> handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.hasAuthResultsDelegate = handler;
            return this;
        }

        @VisibleForTesting
        @NotNull
        public final TestBuilder setHasRemoteResultsDelegate(@NotNull Function0<Boolean> handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.hasRemoteResultsDelegate = handler;
            return this;
        }
    }

    public /* synthetic */ PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle, Function0 function0, Function0 function02, Function1 function1, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingGetCredentialHandle, function0, function02, function1, z);
    }

    @Nullable
    public final Function1<String, Boolean> getCredentialTypeDelegate() {
        return this.credentialTypeDelegate;
    }

    @Nullable
    public final Function0<Boolean> getHasAuthResultsDelegate() {
        return this.hasAuthResultsDelegate;
    }

    @Nullable
    public final Function0<Boolean> getHasRemoteResultsDelegate() {
        return this.hasRemoteResultsDelegate;
    }

    @Nullable
    public final PendingGetCredentialHandle getPendingGetCredentialHandle() {
        return this.pendingGetCredentialHandle;
    }

    @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
    public final boolean hasAuthenticationResults() {
        Function0<Boolean> function0 = this.hasAuthResultsDelegate;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
    public final boolean hasCredentialResults(@NotNull String credentialType) {
        Intrinsics.checkNotNullParameter(credentialType, "credentialType");
        Function1<String, Boolean> function1 = this.credentialTypeDelegate;
        if (function1 != null) {
            return function1.invoke(credentialType).booleanValue();
        }
        return false;
    }

    @RequiresPermission("android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS")
    public final boolean hasRemoteResults() {
        Function0<Boolean> function0 = this.hasRemoteResultsDelegate;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    /* JADX INFO: renamed from: isNullHandlesForTest, reason: from getter */
    public final boolean getIsNullHandlesForTest() {
        return this.isNullHandlesForTest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PrepareGetCredentialResponse(PendingGetCredentialHandle pendingGetCredentialHandle, Function0<Boolean> function0, Function0<Boolean> function02, Function1<? super String, Boolean> function1, boolean z) {
        this.pendingGetCredentialHandle = pendingGetCredentialHandle;
        this.hasRemoteResultsDelegate = function0;
        this.hasAuthResultsDelegate = function02;
        this.credentialTypeDelegate = function1;
        this.isNullHandlesForTest = z;
        if (Build.VERSION.SDK_INT < 34 || z) {
            return;
        }
        Intrinsics.checkNotNull(pendingGetCredentialHandle);
    }
}

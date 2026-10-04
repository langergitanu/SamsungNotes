package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0003\u0012\u0013\u0014BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse;", "", "credentialEntries", "", "Landroidx/credentials/provider/CredentialEntry;", "actions", "Landroidx/credentials/provider/Action;", "authenticationActions", "Landroidx/credentials/provider/AuthenticationAction;", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/credentials/provider/RemoteEntry;)V", "getActions", "()Ljava/util/List;", "getAuthenticationActions", "getCredentialEntries", "getRemoteEntry", "()Landroidx/credentials/provider/RemoteEntry;", "Api34Impl", "Builder", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BeginGetCredentialResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final List<Action> actions;

    @NotNull
    private final List<AuthenticationAction> authenticationActions;

    @NotNull
    private final List<CredentialEntry> credentialEntries;

    @Nullable
    private final RemoteEntry remoteEntry;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse$Api34Impl;", "", "()V", "REQUEST_KEY", "", "asBundle", "", "bundle", "Landroid/os/Bundle;", "response", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "fromBundle", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Api34Impl {

        @NotNull
        public static final Api34Impl INSTANCE = new Api34Impl();

        @NotNull
        private static final String REQUEST_KEY = "androidx.credentials.provider.BeginGetCredentialResponse";

        private Api34Impl() {
        }

        @JvmStatic
        @DoNotInline
        public static final void asBundle(@NotNull Bundle bundle, @NotNull BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(response, "response");
            bundle.putParcelable(REQUEST_KEY, BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
        }

        @JvmStatic
        @DoNotInline
        @Nullable
        public static final BeginGetCredentialResponse fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            android.service.credentials.BeginGetCredentialResponse beginGetCredentialResponse = (android.service.credentials.BeginGetCredentialResponse) bundle.getParcelable(REQUEST_KEY, android.service.credentials.BeginGetCredentialResponse.class);
            if (beginGetCredentialResponse != null) {
                return BeginGetCredentialUtil.INSTANCE.convertToJetpackResponse(beginGetCredentialResponse);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0014\u0010\u0016\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015J\u0014\u0010\u0018\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0015J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse$Builder;", "", "()V", "actions", "", "Landroidx/credentials/provider/Action;", "authenticationActions", "Landroidx/credentials/provider/AuthenticationAction;", "credentialEntries", "Landroidx/credentials/provider/CredentialEntry;", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", Bixby2Constants.BIXBY_ACTION_ADD_ACTION, "action", "addAuthenticationAction", "authenticationAction", "addCredentialEntry", "entry", "build", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "setActions", "", "setAuthenticationActions", "authenticationEntries", "setCredentialEntries", SearchIndexablesContract.RawData.COLUMN_ENTRIES, "setRemoteEntry", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Builder {

        @Nullable
        private RemoteEntry remoteEntry;

        @NotNull
        private List<CredentialEntry> credentialEntries = new ArrayList();

        @NotNull
        private List<Action> actions = new ArrayList();

        @NotNull
        private List<AuthenticationAction> authenticationActions = new ArrayList();

        @NotNull
        public final Builder addAction(@NotNull Action action) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.actions.add(action);
            return this;
        }

        @NotNull
        public final Builder addAuthenticationAction(@NotNull AuthenticationAction authenticationAction) {
            Intrinsics.checkNotNullParameter(authenticationAction, "authenticationAction");
            this.authenticationActions.add(authenticationAction);
            return this;
        }

        @NotNull
        public final Builder addCredentialEntry(@NotNull CredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.credentialEntries.add(entry);
            return this;
        }

        @NotNull
        public final BeginGetCredentialResponse build() {
            return new BeginGetCredentialResponse(CollectionsKt.toList(this.credentialEntries), CollectionsKt.toList(this.actions), CollectionsKt.toList(this.authenticationActions), this.remoteEntry);
        }

        @NotNull
        public final Builder setActions(@NotNull List<Action> actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            this.actions = CollectionsKt.toMutableList((Collection) actions);
            return this;
        }

        @NotNull
        public final Builder setAuthenticationActions(@NotNull List<AuthenticationAction> authenticationEntries) {
            Intrinsics.checkNotNullParameter(authenticationEntries, "authenticationEntries");
            this.authenticationActions = CollectionsKt.toMutableList((Collection) authenticationEntries);
            return this;
        }

        @NotNull
        public final Builder setCredentialEntries(@NotNull List<? extends CredentialEntry> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.credentialEntries = CollectionsKt.toMutableList((Collection) entries);
            return this;
        }

        @NotNull
        public final Builder setRemoteEntry(@Nullable RemoteEntry remoteEntry) {
            this.remoteEntry = remoteEntry;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetCredentialResponse$Companion;", "", "()V", "asBundle", "Landroid/os/Bundle;", "response", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "fromBundle", "bundle", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Bundle asBundle(@NotNull BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Bundle bundle = new Bundle();
            if (Build.VERSION.SDK_INT >= 34) {
                Api34Impl.asBundle(bundle, response);
            }
            return bundle;
        }

        @JvmStatic
        @Nullable
        public final BeginGetCredentialResponse fromBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (Build.VERSION.SDK_INT >= 34) {
                return Api34Impl.fromBundle(bundle);
            }
            return null;
        }

        private Companion() {
        }
    }

    public BeginGetCredentialResponse() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    @NotNull
    public static final Bundle asBundle(@NotNull BeginGetCredentialResponse beginGetCredentialResponse) {
        return INSTANCE.asBundle(beginGetCredentialResponse);
    }

    @JvmStatic
    @Nullable
    public static final BeginGetCredentialResponse fromBundle(@NotNull Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    @NotNull
    public final List<Action> getActions() {
        return this.actions;
    }

    @NotNull
    public final List<AuthenticationAction> getAuthenticationActions() {
        return this.authenticationActions;
    }

    @NotNull
    public final List<CredentialEntry> getCredentialEntries() {
        return this.credentialEntries;
    }

    @Nullable
    public final RemoteEntry getRemoteEntry() {
        return this.remoteEntry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeginGetCredentialResponse(@NotNull List<? extends CredentialEntry> credentialEntries, @NotNull List<Action> actions, @NotNull List<AuthenticationAction> authenticationActions, @Nullable RemoteEntry remoteEntry) {
        Intrinsics.checkNotNullParameter(credentialEntries, "credentialEntries");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(authenticationActions, "authenticationActions");
        this.credentialEntries = credentialEntries;
        this.actions = actions;
        this.authenticationActions = authenticationActions;
        this.remoteEntry = remoteEntry;
    }

    public /* synthetic */ BeginGetCredentialResponse(List list, List list2, List list3, RemoteEntry remoteEntry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? null : remoteEntry);
    }
}

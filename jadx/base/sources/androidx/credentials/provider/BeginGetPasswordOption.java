package androidx.credentials.provider;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.GetPasswordOption;
import androidx.credentials.PasswordCredential;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetPasswordOption;", "Landroidx/credentials/provider/BeginGetCredentialOption;", "allowedUserIds", "", "", "candidateQueryData", "Landroid/os/Bundle;", "id", "(Ljava/util/Set;Landroid/os/Bundle;Ljava/lang/String;)V", "getAllowedUserIds", "()Ljava/util/Set;", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BeginGetPasswordOption extends BeginGetCredentialOption {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Set<String> allowedUserIds;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetPasswordOption$Companion;", "", "()V", "createForTest", "Landroidx/credentials/provider/BeginGetPasswordOption;", "data", "Landroid/os/Bundle;", "id", "", "createFrom", "createFrom$credentials_release", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @VisibleForTesting
        @NotNull
        public final BeginGetPasswordOption createForTest(@NotNull Bundle data, @NotNull String id) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            return createFrom$credentials_release(data, id);
        }

        @NotNull
        public final BeginGetPasswordOption createFrom$credentials_release(@NotNull Bundle data, @NotNull String id) {
            Set setEmptySet;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            ArrayList<String> stringArrayList = data.getStringArrayList(GetPasswordOption.BUNDLE_KEY_ALLOWED_USER_IDS);
            if (stringArrayList == null || (setEmptySet = CollectionsKt.toSet(stringArrayList)) == null) {
                setEmptySet = SetsKt.emptySet();
            }
            return new BeginGetPasswordOption(setEmptySet, data, id);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginGetPasswordOption(@NotNull Set<String> allowedUserIds, @NotNull Bundle candidateQueryData, @NotNull String id) {
        super(id, PasswordCredential.TYPE_PASSWORD_CREDENTIAL, candidateQueryData);
        Intrinsics.checkNotNullParameter(allowedUserIds, "allowedUserIds");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(id, "id");
        this.allowedUserIds = allowedUserIds;
    }

    @JvmStatic
    @VisibleForTesting
    @NotNull
    public static final BeginGetPasswordOption createForTest(@NotNull Bundle bundle, @NotNull String str) {
        return INSTANCE.createForTest(bundle, str);
    }

    @NotNull
    public final Set<String> getAllowedUserIds() {
        return this.allowedUserIds;
    }
}

package androidx.credentials.provider;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetCustomCredentialOption;", "Landroidx/credentials/provider/BeginGetCredentialOption;", "id", "", "type", "candidateQueryData", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBeginGetCustomCredentialOption.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BeginGetCustomCredentialOption.kt\nandroidx/credentials/provider/BeginGetCustomCredentialOption\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1#2:71\n*E\n"})
public class BeginGetCustomCredentialOption extends BeginGetCredentialOption {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0002\b\nJ%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0002\b\f¨\u0006\r"}, m13886d2 = {"Landroidx/credentials/provider/BeginGetCustomCredentialOption$Companion;", "", "()V", "createFrom", "Landroidx/credentials/provider/BeginGetCustomCredentialOption;", "data", "Landroid/os/Bundle;", "id", "", "type", "createFrom$credentials_release", "createFromEntrySlice", "createFromEntrySlice$credentials_release", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final BeginGetCustomCredentialOption createFrom$credentials_release(@NotNull Bundle data, @NotNull String id, @NotNull String type) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new BeginGetCustomCredentialOption(id, type, data);
        }

        @JvmStatic
        @NotNull
        public final BeginGetCustomCredentialOption createFromEntrySlice$credentials_release(@NotNull Bundle data, @NotNull String id, @NotNull String type) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new BeginGetCustomCredentialOption(id, type, data);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginGetCustomCredentialOption(@NotNull String id, @NotNull String type, @NotNull Bundle candidateQueryData) {
        super(id, type, candidateQueryData);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        if (id.length() <= 0) {
            throw new IllegalArgumentException("id should not be empty");
        }
        if (type.length() <= 0) {
            throw new IllegalArgumentException("type should not be empty");
        }
    }
}

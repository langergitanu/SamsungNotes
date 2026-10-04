package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m13886d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialDescriptor;", "", "type", "", "id", "", "transports", "", "(Ljava/lang/String;[BLjava/util/List;)V", "getId", "()[B", "getTransports", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final /* data */ class PublicKeyCredentialDescriptor {

    @NotNull
    private final byte[] id;

    @NotNull
    private final List<String> transports;

    @NotNull
    private final String type;

    public PublicKeyCredentialDescriptor(@NotNull String type, @NotNull byte[] id, @NotNull List<String> transports) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(transports, "transports");
        this.type = type;
        this.id = id;
        this.transports = transports;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublicKeyCredentialDescriptor copy$default(PublicKeyCredentialDescriptor publicKeyCredentialDescriptor, String str, byte[] bArr, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publicKeyCredentialDescriptor.type;
        }
        if ((i & 2) != 0) {
            bArr = publicKeyCredentialDescriptor.id;
        }
        if ((i & 4) != 0) {
            list = publicKeyCredentialDescriptor.transports;
        }
        return publicKeyCredentialDescriptor.copy(str, bArr, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getId() {
        return this.id;
    }

    @NotNull
    public final List<String> component3() {
        return this.transports;
    }

    @NotNull
    public final PublicKeyCredentialDescriptor copy(@NotNull String type, @NotNull byte[] id, @NotNull List<String> transports) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(transports, "transports");
        return new PublicKeyCredentialDescriptor(type, id, transports);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) other;
        return Intrinsics.areEqual(this.type, publicKeyCredentialDescriptor.type) && Intrinsics.areEqual(this.id, publicKeyCredentialDescriptor.id) && Intrinsics.areEqual(this.transports, publicKeyCredentialDescriptor.transports);
    }

    @NotNull
    public final byte[] getId() {
        return this.id;
    }

    @NotNull
    public final List<String> getTransports() {
        return this.transports;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.transports.hashCode() + ((Arrays.hashCode(this.id) + (this.type.hashCode() * 31)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PublicKeyCredentialDescriptor(type=");
        sb.append(this.type);
        sb.append(", id=");
        sb.append(Arrays.toString(this.id));
        sb.append(", transports=");
        return AbstractC1974b.m1321n(sb, this.transports, PropertyUtils.MAPPED_DELIM2);
    }
}

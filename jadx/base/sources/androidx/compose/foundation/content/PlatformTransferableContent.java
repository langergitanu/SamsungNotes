package androidx.compose.foundation.content;

import android.net.Uri;
import android.os.Bundle;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/content/PlatformTransferableContent;", "", "linkUri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "(Landroid/net/Uri;Landroid/os/Bundle;)V", "getExtras", "()Landroid/os/Bundle;", "getLinkUri", "()Landroid/net/Uri;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PlatformTransferableContent {
    public static final int $stable = 8;

    @NotNull
    private final Bundle extras;

    @Nullable
    private final Uri linkUri;

    public PlatformTransferableContent(@Nullable Uri uri, @NotNull Bundle bundle) {
        this.linkUri = uri;
        this.extras = bundle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformTransferableContent)) {
            return false;
        }
        PlatformTransferableContent platformTransferableContent = (PlatformTransferableContent) other;
        return Intrinsics.areEqual(this.linkUri, platformTransferableContent.linkUri) && Intrinsics.areEqual(this.extras, platformTransferableContent.extras);
    }

    @NotNull
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public int hashCode() {
        Uri uri = this.linkUri;
        return this.extras.hashCode() + ((uri != null ? uri.hashCode() : 0) * 31);
    }

    @NotNull
    public String toString() {
        return "PlatformTransferableContent(linkUri=" + this.linkUri + ", extras=" + this.extras + PropertyUtils.MAPPED_DELIM2;
    }
}

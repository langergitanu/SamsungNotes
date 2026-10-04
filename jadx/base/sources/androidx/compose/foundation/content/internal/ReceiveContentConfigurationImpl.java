package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/foundation/content/internal/ReceiveContentConfigurationImpl;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class ReceiveContentConfigurationImpl extends ReceiveContentConfiguration {

    @NotNull
    private final ReceiveContentListener receiveContentListener;

    public ReceiveContentConfigurationImpl(@NotNull ReceiveContentListener receiveContentListener) {
        this.receiveContentListener = receiveContentListener;
    }

    public static /* synthetic */ ReceiveContentConfigurationImpl copy$default(ReceiveContentConfigurationImpl receiveContentConfigurationImpl, ReceiveContentListener receiveContentListener, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveContentListener = receiveContentConfigurationImpl.receiveContentListener;
        }
        return receiveContentConfigurationImpl.copy(receiveContentListener);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    @NotNull
    public final ReceiveContentConfigurationImpl copy(@NotNull ReceiveContentListener receiveContentListener) {
        return new ReceiveContentConfigurationImpl(receiveContentListener);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReceiveContentConfigurationImpl) && Intrinsics.areEqual(this.receiveContentListener, ((ReceiveContentConfigurationImpl) other).receiveContentListener);
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    @NotNull
    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public int hashCode() {
        return this.receiveContentListener.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReceiveContentConfigurationImpl(receiveContentListener=" + this.receiveContentListener + PropertyUtils.MAPPED_DELIM2;
    }
}

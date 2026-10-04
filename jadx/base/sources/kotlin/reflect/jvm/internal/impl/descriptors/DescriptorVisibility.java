package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DescriptorVisibility {
    @Nullable
    public final Integer compareTo(@NotNull DescriptorVisibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return getDelegate().compareTo(visibility.getDelegate());
    }

    @NotNull
    public abstract Visibility getDelegate();

    @NotNull
    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor, boolean z);

    @NotNull
    public abstract DescriptorVisibility normalize();

    @NotNull
    public final String toString() {
        return getDelegate().toString();
    }
}

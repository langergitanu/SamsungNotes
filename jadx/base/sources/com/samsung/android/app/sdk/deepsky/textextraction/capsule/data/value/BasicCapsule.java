package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value;

import android.net.Uri;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/BasicCapsule;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/SimpleCapsule;", "title", "", "capsuleActionType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "icon", "Landroid/net/Uri;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;", "(Ljava/lang/String;Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;Landroid/net/Uri;Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;)V", "getCapsuleActionType", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "getIcon", "()Landroid/net/Uri;", "getListener", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class BasicCapsule extends SimpleCapsule {

    @NotNull
    private final CapsuleActionType capsuleActionType;

    @NotNull
    private final Uri icon;

    @NotNull
    private final SimpleCapsuleClickListener listener;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicCapsule(@NotNull String title, @NotNull CapsuleActionType capsuleActionType, @NotNull Uri icon, @NotNull SimpleCapsuleClickListener listener) {
        super(title, capsuleActionType, icon, listener);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.title = title;
        this.capsuleActionType = capsuleActionType;
        this.icon = icon;
        this.listener = listener;
    }

    public static /* synthetic */ BasicCapsule copy$default(BasicCapsule basicCapsule, String str, CapsuleActionType capsuleActionType, Uri uri, SimpleCapsuleClickListener simpleCapsuleClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            str = basicCapsule.getTitle();
        }
        if ((i & 2) != 0) {
            capsuleActionType = basicCapsule.getCapsuleActionType();
        }
        if ((i & 4) != 0) {
            uri = basicCapsule.getIcon();
        }
        if ((i & 8) != 0) {
            simpleCapsuleClickListener = basicCapsule.getListener();
        }
        return basicCapsule.copy(str, capsuleActionType, uri, simpleCapsuleClickListener);
    }

    @NotNull
    public final String component1() {
        return getTitle();
    }

    @NotNull
    public final CapsuleActionType component2() {
        return getCapsuleActionType();
    }

    @NotNull
    public final Uri component3() {
        return getIcon();
    }

    @NotNull
    public final SimpleCapsuleClickListener component4() {
        return getListener();
    }

    @NotNull
    public final BasicCapsule copy(@NotNull String title, @NotNull CapsuleActionType capsuleActionType, @NotNull Uri icon, @NotNull SimpleCapsuleClickListener listener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new BasicCapsule(title, capsuleActionType, icon, listener);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BasicCapsule)) {
            return false;
        }
        BasicCapsule basicCapsule = (BasicCapsule) other;
        return Intrinsics.areEqual(getTitle(), basicCapsule.getTitle()) && getCapsuleActionType() == basicCapsule.getCapsuleActionType() && Intrinsics.areEqual(getIcon(), basicCapsule.getIcon()) && Intrinsics.areEqual(getListener(), basicCapsule.getListener());
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.SimpleCapsule, com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule
    @NotNull
    public CapsuleActionType getCapsuleActionType() {
        return this.capsuleActionType;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.SimpleCapsule
    @NotNull
    public Uri getIcon() {
        return this.icon;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.SimpleCapsule
    @NotNull
    public SimpleCapsuleClickListener getListener() {
        return this.listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.SimpleCapsule, com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule
    @NotNull
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return getListener().hashCode() + ((getIcon().hashCode() + ((getCapsuleActionType().hashCode() + (getTitle().hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "BasicCapsule(title=" + getTitle() + ", capsuleActionType=" + getCapsuleActionType() + ", icon=" + getIcon() + ", listener=" + getListener() + ")";
    }
}

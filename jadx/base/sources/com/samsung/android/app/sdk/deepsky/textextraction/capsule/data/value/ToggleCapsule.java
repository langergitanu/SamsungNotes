package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value;

import android.net.Uri;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.ToggleCapsuleListener;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/ToggleCapsule;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/Capsule;", "title", "", "capsuleActionType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "icon", "Landroid/net/Uri;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/ToggleCapsuleListener;", "isOn", "", "(Ljava/lang/String;Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;Landroid/net/Uri;Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/ToggleCapsuleListener;Z)V", "getCapsuleActionType", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "getIcon", "()Landroid/net/Uri;", "()Z", "setOn", "(Z)V", "getListener", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/ToggleCapsuleListener;", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class ToggleCapsule extends Capsule {

    @NotNull
    private final CapsuleActionType capsuleActionType;

    @NotNull
    private final Uri icon;
    private boolean isOn;

    @NotNull
    private final ToggleCapsuleListener listener;

    @NotNull
    private final String title;

    public /* synthetic */ ToggleCapsule(String str, CapsuleActionType capsuleActionType, Uri uri, ToggleCapsuleListener toggleCapsuleListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, capsuleActionType, uri, toggleCapsuleListener, (i & 16) != 0 ? false : z);
    }

    public static /* synthetic */ ToggleCapsule copy$default(ToggleCapsule toggleCapsule, String str, CapsuleActionType capsuleActionType, Uri uri, ToggleCapsuleListener toggleCapsuleListener, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toggleCapsule.getTitle();
        }
        if ((i & 2) != 0) {
            capsuleActionType = toggleCapsule.getCapsuleActionType();
        }
        if ((i & 4) != 0) {
            uri = toggleCapsule.icon;
        }
        if ((i & 8) != 0) {
            toggleCapsuleListener = toggleCapsule.listener;
        }
        if ((i & 16) != 0) {
            z = toggleCapsule.isOn;
        }
        boolean z2 = z;
        Uri uri2 = uri;
        return toggleCapsule.copy(str, capsuleActionType, uri2, toggleCapsuleListener, z2);
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
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Uri getIcon() {
        return this.icon;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ToggleCapsuleListener getListener() {
        return this.listener;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsOn() {
        return this.isOn;
    }

    @NotNull
    public final ToggleCapsule copy(@NotNull String title, @NotNull CapsuleActionType capsuleActionType, @NotNull Uri icon, @NotNull ToggleCapsuleListener listener, boolean isOn) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new ToggleCapsule(title, capsuleActionType, icon, listener, isOn);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToggleCapsule)) {
            return false;
        }
        ToggleCapsule toggleCapsule = (ToggleCapsule) other;
        return Intrinsics.areEqual(getTitle(), toggleCapsule.getTitle()) && getCapsuleActionType() == toggleCapsule.getCapsuleActionType() && Intrinsics.areEqual(this.icon, toggleCapsule.icon) && Intrinsics.areEqual(this.listener, toggleCapsule.listener) && this.isOn == toggleCapsule.isOn;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule
    @NotNull
    public CapsuleActionType getCapsuleActionType() {
        return this.capsuleActionType;
    }

    @NotNull
    public final Uri getIcon() {
        return this.icon;
    }

    @NotNull
    public final ToggleCapsuleListener getListener() {
        return this.listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule
    @NotNull
    public String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int iHashCode = (this.listener.hashCode() + ((this.icon.hashCode() + ((getCapsuleActionType().hashCode() + (getTitle().hashCode() * 31)) * 31)) * 31)) * 31;
        boolean z = this.isOn;
        ?? r02 = z;
        if (z) {
            r02 = 1;
        }
        return iHashCode + r02;
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setOn(boolean z) {
        this.isOn = z;
    }

    @NotNull
    public String toString() {
        String title = getTitle();
        CapsuleActionType capsuleActionType = getCapsuleActionType();
        Uri uri = this.icon;
        ToggleCapsuleListener toggleCapsuleListener = this.listener;
        boolean z = this.isOn;
        StringBuilder sb = new StringBuilder("ToggleCapsule(title=");
        sb.append(title);
        sb.append(", capsuleActionType=");
        sb.append(capsuleActionType);
        sb.append(", icon=");
        sb.append(uri);
        sb.append(", listener=");
        sb.append(toggleCapsuleListener);
        sb.append(", isOn=");
        return AbstractC0000a.m14k(sb, z, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleCapsule(@NotNull String title, @NotNull CapsuleActionType capsuleActionType, @NotNull Uri icon, @NotNull ToggleCapsuleListener listener, boolean z) {
        super(title, capsuleActionType);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.title = title;
        this.capsuleActionType = capsuleActionType;
        this.icon = icon;
        this.listener = listener;
        this.isOn = z;
    }
}

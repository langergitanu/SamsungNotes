package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value;

import android.net.Uri;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.SimpleCapsuleClickListener;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/SimpleCapsule;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/Capsule;", "title", "", "capsuleActionType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "icon", "Landroid/net/Uri;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;", "(Ljava/lang/String;Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;Landroid/net/Uri;Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;)V", "getCapsuleActionType", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "getIcon", "()Landroid/net/Uri;", "getListener", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class SimpleCapsule extends Capsule {

    @NotNull
    private final CapsuleActionType capsuleActionType;

    @NotNull
    private final Uri icon;

    @NotNull
    private final SimpleCapsuleClickListener listener;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleCapsule(@NotNull String title, @NotNull CapsuleActionType capsuleActionType, @NotNull Uri icon, @NotNull SimpleCapsuleClickListener listener) {
        super(title, capsuleActionType);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(capsuleActionType, "capsuleActionType");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.title = title;
        this.capsuleActionType = capsuleActionType;
        this.icon = icon;
        this.listener = listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule
    @NotNull
    public CapsuleActionType getCapsuleActionType() {
        return this.capsuleActionType;
    }

    @NotNull
    public Uri getIcon() {
        return this.icon;
    }

    @NotNull
    public SimpleCapsuleClickListener getListener() {
        return this.listener;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule
    @NotNull
    public String getTitle() {
        return this.title;
    }
}

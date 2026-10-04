package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b \u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0012H&J\u0014\u0010\u0019\u001a\u00020\u0005*\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "getContext", "()Landroid/content/Context;", "iconUri", "getIconUri", "()Landroid/net/Uri;", "getImageUri", "getInfo", "()Lcom/google/gson/JsonObject;", "isSupportAction", "", "()Z", "title", "", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "runAction", "getResourceUri", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class Action {

    @NotNull
    private final Context context;

    @NotNull
    private final Uri imageUri;

    @NotNull
    private final JsonObject info;
    private final boolean isSupportAction;

    public Action(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.context = context;
        this.imageUri = imageUri;
        this.info = info;
        this.isSupportAction = true;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public abstract Uri getIconUri();

    @NotNull
    public final Uri getImageUri() {
        return this.imageUri;
    }

    @NotNull
    public final JsonObject getInfo() {
        return this.info;
    }

    @NotNull
    public final Uri getResourceUri(int i, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Uri uriBuild = resources != null ? new Uri.Builder().scheme("android.resource").authority(resources.getResourcePackageName(i)).appendPath(resources.getResourceTypeName(i)).appendPath(resources.getResourceEntryName(i)).build() : null;
        if (uriBuild != null) {
            return uriBuild;
        }
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return EMPTY;
    }

    @NotNull
    public abstract String getTitle();

    /* JADX INFO: renamed from: isSupportAction, reason: from getter */
    public boolean getIsSupportAction() {
        return this.isSupportAction;
    }

    public abstract boolean runAction();
}

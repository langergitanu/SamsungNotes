package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/LocationAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "iconUri", "getIconUri", "()Landroid/net/Uri;", "placeName", "", "title", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "runAction", "", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLocationAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocationAction.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/action/data/LocationAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class LocationAction extends Action {

    @NotNull
    private static final String JSON_KEY_ADDRESS = "Address";

    @NotNull
    private static final String JSON_KEY_PLACE_NAME = "PlaceName";

    @NotNull
    private static final String MAP_URI = "geo:0,0?q=";

    /* JADX INFO: renamed from: NA */
    @NotNull
    private static final String f4740NA = "N/A";

    @NotNull
    private static final String TAG = "LocationAction";

    @NotNull
    private final Uri iconUri;

    @NotNull
    private final String placeName;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocationAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        String string;
        String asString;
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.iconUri = getResourceUri(C7039R.drawable.capsule_location, context);
        String string2 = context.getString(C7039R.string.show_on_map);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.show_on_map)");
        this.title = string2;
        JsonElement jsonElement = info.get(JSON_KEY_PLACE_NAME);
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || (string = StringsKt.trim((CharSequence) asString).toString()) == null) {
            string = "";
        } else {
            string = Intrinsics.areEqual(string, f4740NA) ? null : string;
            if (string == null) {
            }
        }
        this.placeName = string;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public Uri getIconUri() {
        return this.iconUri;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    public boolean runAction() {
        String asString;
        LibLogger.m5432i(TAG, "runAction");
        StringBuilder sb = new StringBuilder();
        sb.append(this.placeName);
        JsonElement jsonElement = getInfo().get(JSON_KEY_ADDRESS);
        if (jsonElement != null && (asString = jsonElement.getAsString()) != null && asString.length() > 0 && !Intrinsics.areEqual(asString, f4740NA)) {
            if (sb.length() > 0) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(asString);
        }
        if (sb.length() <= 0) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MAP_URI + ((Object) sb)));
        intent.setFlags(268435456);
        getContext().startActivity(intent);
        return true;
    }
}

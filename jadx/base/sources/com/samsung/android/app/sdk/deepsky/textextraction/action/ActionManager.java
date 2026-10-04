package com.samsung.android.app.sdk.deepsky.textextraction.action;

import android.content.Context;
import android.net.Uri;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/ActionManager;", "", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "data", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "classification", "", "targetAction", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "extractClassification", "getClassification", "getIconUri", DynamicActionBarProvider.METHOD_GET_DATA, "isSupportAction", "", "runAction", "", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ActionManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String JSON_KEY_CLASSIFICATION = "Classification";

    @NotNull
    private static final String TAG = "ActionManager";

    @NotNull
    private final String classification;

    @NotNull
    private final Action targetAction;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/ActionManager$Companion;", "", "()V", "JSON_KEY_CLASSIFICATION", "", SearchConstants.TargetContents.TAG, "isValidClassification", "", "classification", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isValidClassification(@NotNull String classification) {
            Intrinsics.checkNotNullParameter(classification, "classification");
            return ArraysKt.contains(ActionConstants.INSTANCE.getACTION_CATEGORY_LIST(), classification);
        }

        private Companion() {
        }
    }

    public ActionManager(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject data) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(data, "data");
        String strExtractClassification = extractClassification(data);
        this.classification = strExtractClassification;
        if (INSTANCE.isValidClassification(strExtractClassification)) {
            JsonElement jsonElement = data.get(strExtractClassification);
            jsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
            if (jsonObject == null) {
                jsonObject = new JsonObject();
                LibLogger.m5430e(TAG, "Extracted data is null : " + data);
            }
        } else {
            LibLogger.m5432i(TAG, "Invalid classification : " + strExtractClassification);
            jsonObject = new JsonObject();
        }
        this.targetAction = ActionFactory.INSTANCE.getAction(strExtractClassification, context, imageUri, jsonObject);
    }

    private final String extractClassification(JsonObject data) {
        JsonElement jsonElement = data.get(JSON_KEY_CLASSIFICATION);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            LibLogger.m5432i(TAG, "Classification is null or json null");
            return ActionConstants.ACTION_CATEGORY_NULL;
        }
        String asString = jsonElement.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "classificationElement.asString");
        return asString;
    }

    @NotNull
    public final String getClassification() {
        return this.classification;
    }

    @NotNull
    public final Uri getIconUri() {
        return this.targetAction.getIconUri();
    }

    @NotNull
    public final String getTitle() {
        return this.targetAction.getTitle();
    }

    public final boolean isSupportAction() {
        return this.targetAction.getIsSupportAction();
    }

    public final void runAction() {
        this.targetAction.runAction();
    }
}

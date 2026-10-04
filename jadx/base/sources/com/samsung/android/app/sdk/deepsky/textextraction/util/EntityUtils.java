package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.app.RemoteAction;
import android.os.Bundle;
import android.view.textclassifier.TextClassification;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/EntityUtils;", "", "()V", "getEntityEndIndex", "", "classification", "Landroid/view/textclassifier/TextClassification;", "action", "Landroid/app/RemoteAction;", "getEntityExtras", "Landroid/os/Bundle;", "getEntityStartIndex", "getEntityText", "", "getEntityTypeID", "isDateTimeEntity", "", "entityType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class EntityUtils {

    @NotNull
    public static final EntityUtils INSTANCE = new EntityUtils();

    private EntityUtils() {
    }

    private final Bundle getEntityExtras(TextClassification classification, RemoteAction action) {
        Integer orNull;
        int[] intArray = classification.getExtras().getIntArray("entity-index");
        int iIntValue = (intArray == null || (orNull = ArraysKt.getOrNull(intArray, classification.getActions().indexOf(action))) == null) ? 0 : orNull.intValue();
        ArrayList parcelableArrayList = classification.getExtras().getParcelableArrayList("entities");
        if (parcelableArrayList != null) {
            return (Bundle) CollectionsKt.getOrNull(parcelableArrayList, iIntValue);
        }
        return null;
    }

    public final int getEntityEndIndex(@NotNull TextClassification classification, @NotNull RemoteAction action) {
        Intrinsics.checkNotNullParameter(classification, "classification");
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle entityExtras = getEntityExtras(classification, action);
        if (entityExtras != null) {
            return entityExtras.getInt(TextClassificationConstants.ENTITY_EXTRAS_END, 0);
        }
        return 0;
    }

    public final int getEntityStartIndex(@NotNull TextClassification classification, @NotNull RemoteAction action) {
        Intrinsics.checkNotNullParameter(classification, "classification");
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle entityExtras = getEntityExtras(classification, action);
        if (entityExtras != null) {
            return entityExtras.getInt(TextClassificationConstants.ENTITY_EXTRAS_START, 0);
        }
        return 0;
    }

    @NotNull
    public final String getEntityText(@NotNull TextClassification classification, @NotNull RemoteAction action) {
        Intrinsics.checkNotNullParameter(classification, "classification");
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle entityExtras = getEntityExtras(classification, action);
        String string = entityExtras != null ? entityExtras.getString("text", "") : null;
        return string == null ? "" : string;
    }

    @NotNull
    public final String getEntityTypeID(@NotNull TextClassification classification, @NotNull RemoteAction action) {
        Intrinsics.checkNotNullParameter(classification, "classification");
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle entityExtras = getEntityExtras(classification, action);
        String string = entityExtras != null ? entityExtras.getString("entity-type", "") : null;
        return string == null ? "" : string;
    }

    public final boolean isDateTimeEntity(@NotNull EntityType entityType) {
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        return entityType == EntityType.DATE || entityType == EntityType.DATE_TIME;
    }
}

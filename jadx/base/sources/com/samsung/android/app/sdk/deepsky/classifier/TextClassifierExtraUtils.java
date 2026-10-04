package com.samsung.android.app.sdk.deepsky.classifier;

import android.app.RemoteAction;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.textclassifier.TextClassification;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import p066P2.C0200b;
import p074R1.C0230b;
import p074R1.C0231c;
import p074R1.C0232d;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 29)
public final class TextClassifierExtraUtils {
    public static final String ACTION_ID = "action-id";
    public static final String ENTITIES = "entities";
    public static final String ENTITY_INDEX = "entity-index";
    public static final String ENTITY_TYPE = "entity-type";
    private static final String IS_DUPLICATED_ENTITY_ENABLED = "is-duplicated-entity-enabled";
    public static final String TEXT = "text";
    private static final String TYPE_UNKNOWN = "";

    @NonNull
    public static String getActionId(@NonNull TextClassification textClassification, @NonNull RemoteAction remoteAction) {
        Objects.requireNonNull(textClassification);
        Objects.requireNonNull(remoteAction);
        return (String) Optional.ofNullable(getEntityExtras(textClassification, remoteAction)).map(new C0200b(5)).orElse("");
    }

    @Nullable
    private static Bundle getEntityExtras(@NonNull TextClassification textClassification, @NonNull RemoteAction remoteAction) {
        int iIndexOf = textClassification.getActions().indexOf(remoteAction);
        Bundle extras = textClassification.getExtras();
        int entityIndex = getEntityIndex(extras, iIndexOf);
        int i = 1;
        return (Bundle) Optional.ofNullable(extras).map(new C0200b(6)).filter(new C0231c(entityIndex, i)).map(new C0232d(entityIndex, i)).filter(new C0233e(0)).map(new C0200b(1)).orElse(null);
    }

    private static int getEntityIndex(@Nullable Bundle bundle, int i) {
        int i2 = 0;
        return ((Integer) Optional.ofNullable(bundle).map(new C0200b(4)).filter(new C0231c(i, i2)).map(new C0232d(i, i2)).orElse(0)).intValue();
    }

    @NonNull
    public static String getEntityText(@NonNull TextClassification textClassification, @NonNull RemoteAction remoteAction) {
        Objects.requireNonNull(textClassification);
        Objects.requireNonNull(remoteAction);
        return (String) Optional.ofNullable(getEntityExtras(textClassification, remoteAction)).map(new C0200b(2)).orElseGet(new C0230b(textClassification, 0));
    }

    @NonNull
    public static String getEntityType(@NonNull TextClassification textClassification, @NonNull RemoteAction remoteAction) {
        Objects.requireNonNull(textClassification);
        Objects.requireNonNull(remoteAction);
        return (String) Optional.ofNullable(getEntityExtras(textClassification, remoteAction)).map(new C0200b(3)).orElse("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getActionId$10(Bundle bundle) {
        return bundle.getString(ACTION_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getEntityExtras$6(Bundle bundle) {
        return bundle.getParcelableArrayList("entities");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getEntityExtras$7(int i, ArrayList arrayList) {
        return i >= 0 && i < arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Parcelable lambda$getEntityExtras$8(int i, ArrayList arrayList) {
        return (Parcelable) arrayList.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getEntityExtras$9(Parcelable parcelable) {
        return parcelable instanceof Bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int[] lambda$getEntityIndex$3(Bundle bundle) {
        return bundle.getIntArray("entity-index");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getEntityIndex$4(int i, int[] iArr) {
        return i < iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getEntityIndex$5(int i, int[] iArr) {
        return Integer.valueOf(iArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getEntityText$1(Bundle bundle) {
        return bundle.getString("text");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getEntityText$2(TextClassification textClassification) {
        return (String) Optional.ofNullable(textClassification.getText()).orElse("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getEntityType$0(Bundle bundle) {
        return bundle.getString("entity-type");
    }

    public static void putIsDuplicatedEntityEnabled(Bundle bundle, boolean z) {
        bundle.putBoolean("is-duplicated-entity-enabled", z);
    }
}

package com.google.android.appfunctions.contextual;

import android.os.Bundle;
import com.google.android.appfunctions.AppFunctionExperimental;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AppFunctionExperimental
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/google/android/appfunctions/contextual/AppFunctionAssistContent;", "Lcom/google/android/appfunctions/contextual/Bundleable;", "entityDataList", "", "Lcom/google/android/appfunctions/contextual/EntityData;", "<init>", "(Ljava/util/List;)V", "getEntityDataList", "()Ljava/util/List;", "writeToBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "toString", "equals", "", "other", "", "hashCode", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AppFunctionAssistContent implements Bundleable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENTITY_DATA_BUNDLE_KEY = "EntityData";

    @NotNull
    private static final String ENTITY_DATA_COUNT_BUNDLE_KEY = "EntityDataCount";

    @NotNull
    public static final String EXTRA_APP_FUNCTION_DATA = "android.app.assist.extra.APP_FUNCTION_DATA";

    @NotNull
    private final List<EntityData> entityDataList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/google/android/appfunctions/contextual/AppFunctionAssistContent$Companion;", "", "<init>", "()V", "EXTRA_APP_FUNCTION_DATA", "", "getEXTRA_APP_FUNCTION_DATA$annotations", "ENTITY_DATA_COUNT_BUNDLE_KEY", "ENTITY_DATA_BUNDLE_KEY", "getEntityDataBundleKey", "index", "", "readFromBundle", "Lcom/google/android/appfunctions/contextual/AppFunctionAssistContent;", "bundle", "Landroid/os/Bundle;", "key", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getEntityDataBundleKey(int index) {
            return AbstractC0000a.m11h(index, "EntityData_");
        }

        @JvmStatic
        @Nullable
        public final AppFunctionAssistContent readFromBundle(@NotNull Bundle bundle, @NotNull String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundle2 = bundle.getBundle(key);
            if (bundle2 == null) {
                return null;
            }
            int i = bundle2.getInt(AppFunctionAssistContent.ENTITY_DATA_COUNT_BUNDLE_KEY, -1);
            if (i == -1) {
                throw new IllegalArgumentException("Corrupt bundle for AppFunctionAssistContent: Cannot find EntityDataCount");
            }
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                EntityData fromBundle = EntityData.INSTANCE.readFromBundle(bundle2, AppFunctionAssistContent.INSTANCE.getEntityDataBundleKey(i2));
                if (fromBundle == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                listCreateListBuilder.add(fromBundle);
            }
            return new AppFunctionAssistContent(CollectionsKt.build(listCreateListBuilder));
        }

        private Companion() {
        }

        public static /* synthetic */ void getEXTRA_APP_FUNCTION_DATA$annotations() {
        }
    }

    public AppFunctionAssistContent(@NotNull List<EntityData> entityDataList) {
        Intrinsics.checkNotNullParameter(entityDataList, "entityDataList");
        this.entityDataList = entityDataList;
    }

    @JvmStatic
    @Nullable
    public static final AppFunctionAssistContent readFromBundle(@NotNull Bundle bundle, @NotNull String str) {
        return INSTANCE.readFromBundle(bundle, str);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AppFunctionAssistContent) {
            return Intrinsics.areEqual(this.entityDataList, ((AppFunctionAssistContent) other).entityDataList);
        }
        return false;
    }

    @NotNull
    public final List<EntityData> getEntityDataList() {
        return this.entityDataList;
    }

    public int hashCode() {
        return Objects.hash(this.entityDataList);
    }

    @NotNull
    public String toString() {
        return "AppFunctionAssistContent(entityDataList=" + this.entityDataList + ")";
    }

    @Override // com.google.android.appfunctions.contextual.Bundleable
    public void writeToBundle(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(ENTITY_DATA_COUNT_BUNDLE_KEY, this.entityDataList.size());
        Iterator<T> it = this.entityDataList.iterator();
        int i = 0;
        while (it.hasNext()) {
            ((EntityData) it.next()).writeToBundle(bundle2, INSTANCE.getEntityDataBundleKey(i));
            i++;
        }
        bundle.putBundle(key, bundle2);
    }
}

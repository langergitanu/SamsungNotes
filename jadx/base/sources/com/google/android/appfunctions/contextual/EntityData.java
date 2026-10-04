package com.google.android.appfunctions.contextual;

import android.os.Bundle;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.appfunctions.AppFunctionExperimental;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AppFunctionExperimental
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/google/android/appfunctions/contextual/EntityData;", "Lcom/google/android/appfunctions/contextual/Bundleable;", "entityId", "", "entityType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "getEntityType", "writeToBundle", "", "bundle", "Landroid/os/Bundle;", "key", "toString", "equals", "", "other", "", "hashCode", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class EntityData implements Bundleable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ENTITY_ID_BUNDLE_KEY = "EntityId";

    @NotNull
    private static final String ENTITY_TYPE_BUNDLE_KEY = "EntityType";

    @NotNull
    private final String entityId;

    @NotNull
    private final String entityType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/google/android/appfunctions/contextual/EntityData$Companion;", "", "<init>", "()V", "ENTITY_ID_BUNDLE_KEY", "", "ENTITY_TYPE_BUNDLE_KEY", "readFromBundle", "Lcom/google/android/appfunctions/contextual/EntityData;", "bundle", "Landroid/os/Bundle;", "key", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final EntityData readFromBundle(@NotNull Bundle bundle, @NotNull String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundle2 = bundle.getBundle(key);
            if (bundle2 == null) {
                return null;
            }
            String string = bundle2.getString(EntityData.ENTITY_ID_BUNDLE_KEY);
            if (string == null) {
                throw new IllegalStateException("Required value was null.");
            }
            String string2 = bundle2.getString(EntityData.ENTITY_TYPE_BUNDLE_KEY);
            if (string2 != null) {
                return new EntityData(string, string2);
            }
            throw new IllegalStateException("Required value was null.");
        }

        private Companion() {
        }
    }

    public EntityData(@NotNull String entityId, @NotNull String entityType) {
        Intrinsics.checkNotNullParameter(entityId, "entityId");
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        this.entityId = entityId;
        this.entityType = entityType;
    }

    @JvmStatic
    @Nullable
    public static final EntityData readFromBundle(@NotNull Bundle bundle, @NotNull String str) {
        return INSTANCE.readFromBundle(bundle, str);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityData)) {
            return false;
        }
        EntityData entityData = (EntityData) other;
        return Intrinsics.areEqual(this.entityId, entityData.entityId) && Intrinsics.areEqual(this.entityType, entityData.entityType);
    }

    @NotNull
    public final String getEntityId() {
        return this.entityId;
    }

    @NotNull
    public final String getEntityType() {
        return this.entityType;
    }

    public int hashCode() {
        return Objects.hash(this.entityId, this.entityType);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("EntityData(entityId=", this.entityId, ", entityType=", this.entityType, ")");
    }

    @Override // com.google.android.appfunctions.contextual.Bundleable
    public void writeToBundle(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle2 = new Bundle();
        bundle2.putString(ENTITY_ID_BUNDLE_KEY, this.entityId);
        bundle2.putString(ENTITY_TYPE_BUNDLE_KEY, this.entityType);
        bundle.putBundle(key, bundle2);
    }
}

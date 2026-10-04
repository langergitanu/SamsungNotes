package com.google.android.appfunctions.schema.agent.internal;

import androidx.glance.AbstractC2821a;
import com.google.android.appfunctions.AppFunctionMetadata;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\bR\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/agent/internal/SchemaFunctionInventory;", "", "schemaFunctionMap", "", "Lcom/google/android/appfunctions/schema/agent/internal/SchemaFunctionInventory$SchemaFunctionKey;", "Lcom/google/android/appfunctions/AppFunctionMetadata;", "getSchemaFunctionMap", "()Ljava/util/Map;", "SchemaFunctionKey", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SchemaFunctionInventory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/agent/internal/SchemaFunctionInventory$SchemaFunctionKey;", "", "category", "", "schemaName", "schemaVersion", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCategory", "()Ljava/lang/String;", "getSchemaName", "getSchemaVersion", "()I", "equals", "", "other", "hashCode", "toString", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SchemaFunctionKey {

        @NotNull
        private final String category;

        @NotNull
        private final String schemaName;
        private final int schemaVersion;

        public SchemaFunctionKey(@NotNull String category, @NotNull String schemaName, int i) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(schemaName, "schemaName");
            this.category = category;
            this.schemaName = schemaName;
            this.schemaVersion = i;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SchemaFunctionKey)) {
                return false;
            }
            SchemaFunctionKey schemaFunctionKey = (SchemaFunctionKey) other;
            return Objects.equals(this.category, schemaFunctionKey.category) && Objects.equals(this.schemaName, schemaFunctionKey.schemaName) && this.schemaVersion == schemaFunctionKey.schemaVersion;
        }

        @NotNull
        public final String getCategory() {
            return this.category;
        }

        @NotNull
        public final String getSchemaName() {
            return this.schemaName;
        }

        public final int getSchemaVersion() {
            return this.schemaVersion;
        }

        public int hashCode() {
            return Objects.hash(this.category, this.schemaName, Integer.valueOf(this.schemaVersion));
        }

        @NotNull
        public String toString() {
            String str = this.category;
            String str2 = this.schemaName;
            return AbstractC2821a.m2223n(AbstractC0000a.m16m("SchemaFunctionKey(category='", str, "', schemaName='", str2, "', schemaVersion="), ")", this.schemaVersion);
        }
    }

    @NotNull
    Map<SchemaFunctionKey, AppFunctionMetadata> getSchemaFunctionMap();
}

package com.google.android.appfunctions.schema.agent;

import androidx.annotation.RestrictTo;
import com.google.android.appfunctions.AppFunctionMetadata;
import com.google.android.appfunctions.internal.utils.KClassUtil;
import com.google.android.appfunctions.schema.agent.internal.SchemaFunctionInventory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/agent/SchemaFunctionManager;", "", "schemaFunctionInventory", "Lcom/google/android/appfunctions/schema/agent/internal/SchemaFunctionInventory;", "<init>", "(Lcom/google/android/appfunctions/schema/agent/internal/SchemaFunctionInventory;)V", "getSchemaAppFunctionMetadata", "Lcom/google/android/appfunctions/AppFunctionMetadata;", "request", "Lcom/google/android/appfunctions/schema/agent/GetSchemaAppFunctionMetadataRequest;", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SchemaFunctionManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static volatile SchemaFunctionManager instance;

    @NotNull
    private final SchemaFunctionInventory schemaFunctionInventory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/agent/SchemaFunctionManager$Companion;", "", "<init>", "()V", "instance", "Lcom/google/android/appfunctions/schema/agent/SchemaFunctionManager;", "getInstance", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SchemaFunctionManager getInstance() {
            SchemaFunctionManager schemaFunctionManager;
            SchemaFunctionManager schemaFunctionManager2 = SchemaFunctionManager.instance;
            if (schemaFunctionManager2 != null) {
                return schemaFunctionManager2;
            }
            synchronized (this) {
                schemaFunctionManager = SchemaFunctionManager.instance;
                if (schemaFunctionManager == null) {
                    schemaFunctionManager = new SchemaFunctionManager((SchemaFunctionInventory) KClassUtil.findImpl$default(SchemaFunctionInventory.class, null, 1, null));
                }
            }
            return schemaFunctionManager;
        }

        private Companion() {
        }
    }

    public SchemaFunctionManager(@NotNull SchemaFunctionInventory schemaFunctionInventory) {
        Intrinsics.checkNotNullParameter(schemaFunctionInventory, "schemaFunctionInventory");
        this.schemaFunctionInventory = schemaFunctionInventory;
    }

    @JvmStatic
    @NotNull
    public static final SchemaFunctionManager getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final AppFunctionMetadata getSchemaAppFunctionMetadata(@NotNull GetSchemaAppFunctionMetadataRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.schemaFunctionInventory.getSchemaFunctionMap().get(new SchemaFunctionInventory.SchemaFunctionKey(request.getCategory(), request.getSchemaName(), request.getSchemaVersion()));
    }
}

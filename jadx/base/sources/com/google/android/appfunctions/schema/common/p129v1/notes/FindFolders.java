package com.google.android.appfunctions.schema.common.p129v1.notes;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.AppFunctionSchemaDefinition;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AppFunctionSchemaDefinition(category = Privacy.KEY_NOTES, name = "findFolders", version = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/notes/FindFolders;", "", "findFolders", "", "Lcom/google/android/appfunctions/schema/common/v1/notes/Folder;", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "findFoldersParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface FindFolders {
    @Nullable
    Object findFolders(@NotNull AppFunctionContext appFunctionContext, @NotNull FindFoldersParams findFoldersParams, @NotNull Continuation<? super List<Folder>> continuation);
}

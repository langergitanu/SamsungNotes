package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.impl.repository.search.SemanticSearchRepositoryImpl;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/sync/providers/ExternalDataUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getEmbeddingConfigBundle", "Landroid/os/Bundle;", "getSelectionFields", "getDefaultQueryArgs", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nExternalDataUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExternalDataUtils.kt\ncom/samsung/android/support/senl/nt/app/sync/providers/ExternalDataUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,50:1\n37#2:51\n36#2,3:52\n*S KotlinDebug\n*F\n+ 1 ExternalDataUtils.kt\ncom/samsung/android/support/senl/nt/app/sync/providers/ExternalDataUtils\n*L\n41#1:51\n41#1:52,3\n*E\n"})
public final class ExternalDataUtils {

    @NotNull
    public static final ExternalDataUtils INSTANCE = new ExternalDataUtils();

    @NotNull
    public static final String TAG = "ExternalDataUtils";

    private ExternalDataUtils() {
    }

    @JvmStatic
    @NotNull
    public static final Bundle getDefaultQueryArgs() {
        return SemanticSearchRepositoryImpl.INSTANCE.createDefaultSearchQueryArgs();
    }

    @JvmStatic
    @Nullable
    public static final Bundle getEmbeddingConfigBundle() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("method", "char");
            jSONObject2.put("size", 1000);
            jSONObject2.put(ExternalDataConstants.EmbeddingConfig.CHUNK_OVERLAP, 0);
            jSONObject2.put(ExternalDataConstants.EmbeddingConfig.CHUNK_CONTEXT_FIELD, "title");
            jSONObject.put(ExternalDataConstants.EmbeddingConfig.TARGET_FIELDS, new JSONArray((Collection) ExternalDataConstants.getTargetFieldsForSearch()));
            jSONObject.put(ExternalDataConstants.EmbeddingConfig.CHUNK_POLICY, jSONObject2);
            Bundle bundle = new Bundle();
            bundle.putString(ExternalDataConstants.EmbeddingConfig.KEY, jSONObject.toString());
            return bundle;
        } catch (JSONException e) {
            AbstractC4539a.m3214x("getEmbeddingConfigBundle, e: ", e.getMessage(), TAG);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final Bundle getSelectionFields() {
        Bundle bundle = new Bundle();
        List<String> projection = ExternalDataConstants.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "getProjection(...)");
        bundle.putStringArray(ExternalDataConstants.Key.PROJECTION_FIELDS_FOR_SEARCH_ENGINE, (String[]) projection.toArray(new String[0]));
        return bundle;
    }
}

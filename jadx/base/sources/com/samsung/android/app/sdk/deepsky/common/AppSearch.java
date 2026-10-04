package com.samsung.android.app.sdk.deepsky.common;

import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.GenericDocument;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH'¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;", "", "putDocument", "", "appSearchSchema", "Landroid/app/appsearch/AppSearchSchema;", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Landroid/app/appsearch/GenericDocument;", "permissions", "", "", "permittedSssOnly", "removeDocument", "id", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface AppSearch {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean putDocument$default(AppSearch appSearch, AppSearchSchema appSearchSchema, GenericDocument genericDocument, List list, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putDocument");
            }
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((i & 8) != 0) {
                z = false;
            }
            return appSearch.putDocument(appSearchSchema, genericDocument, list, z);
        }
    }

    @RequiresApi(33)
    boolean putDocument(@NotNull AppSearchSchema appSearchSchema, @NotNull GenericDocument document, @NotNull List<Integer> permissions, boolean permittedSssOnly);

    @RequiresApi(33)
    boolean removeDocument(@NotNull String id);
}

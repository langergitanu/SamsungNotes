package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.converter;

import android.content.Context;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.memoconverter.JSONConverter;
import com.samsung.android.support.senl.document.memoconverter.ScrapBookConverter;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/converter/ImportItemConverter;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "fromImportItem", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "srcImportItem", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "context", "Landroid/content/Context;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportItemConverter {

    @NotNull
    public static final ImportItemConverter INSTANCE = new ImportItemConverter();

    @NotNull
    private static final String TAG = "ST$ImportItemConverter";

    private ImportItemConverter() {
    }

    @JvmStatic
    @Nullable
    public static final MemoMetaDataItem fromImportItem(@NotNull ImportItem srcImportItem, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(srcImportItem, "srcImportItem");
        Object extraObject = srcImportItem.getExtraObject();
        if (extraObject instanceof MemoMetaDataItem) {
            return (MemoMetaDataItem) extraObject;
        }
        if (srcImportItem.getLocalFullPath() == null) {
            return null;
        }
        if (srcImportItem.getItemType() != 33) {
            String localFullPath = srcImportItem.getLocalFullPath();
            String localFullPath2 = srcImportItem.getLocalFullPath();
            Intrinsics.checkNotNullExpressionValue(localFullPath2, "getLocalFullPath(...)");
            return JSONConverter.getMemoMetaData(localFullPath, StringsKt.m14139M(localFullPath2, "MEMO_DATA/", "MEMO_DATA_V_1/"), srcImportItem.getContainerName());
        }
        if (context == null) {
            MainLogger.m7258i(TAG, "context is null!");
            return null;
        }
        ScrapBookConverter scrapBookConverter = new ScrapBookConverter(context, ImageUtils.getMaxTextureSize());
        Intrinsics.checkNotNull(extraObject, "null cannot be cast to non-null type org.json.JSONObject");
        return scrapBookConverter.getMetaData((JSONObject) extraObject, srcImportItem.getLocalFullPath(), srcImportItem.getCategoryUUID());
    }
}

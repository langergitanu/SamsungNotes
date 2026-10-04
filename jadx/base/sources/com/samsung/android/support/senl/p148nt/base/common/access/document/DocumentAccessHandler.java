package com.samsung.android.support.senl.p148nt.base.common.access.document;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/document/DocumentAccessHandler;", "", "<init>", "()V", "contract", "Lcom/samsung/android/support/senl/nt/base/common/access/document/DocumentAccessHandler$DocumentAccessContract;", "setContract", "", "getContract", "DocumentAccessContract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocumentAccessHandler {

    @NotNull
    public static final DocumentAccessHandler INSTANCE = new DocumentAccessHandler();

    @Nullable
    private static DocumentAccessContract contract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&JL\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u0019H&J&\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H&R\u0018\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/document/DocumentAccessHandler$DocumentAccessContract;", "", "docOpenTriggerClass", "Ljava/lang/Class;", "getDocOpenTriggerClass", "()Ljava/lang/Class;", "cancelAllConvertTasks", "", "cancelImportBySetting", "cancelImportCloudDataBySetting", "isExternalCoeditRunning", "", "()Z", "isSyncRunning", "isSmartSwitchRunning", "createCoverPreview", "context", "Landroid/content/Context;", DBSchema.DocumentCover.SUMMARY, "", "categoryUuid", "templateUuid", "colorId", "noteUuid", "state", "", "copyDocument", "srcPath", "dstPath", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DocumentAccessContract {
        void cancelAllConvertTasks();

        void cancelImportBySetting();

        void cancelImportCloudDataBySetting();

        boolean copyDocument(@Nullable Context context, @Nullable String srcPath, @Nullable String dstPath);

        void createCoverPreview(@Nullable Context context, @Nullable String summary, @Nullable String categoryUuid, @Nullable String templateUuid, @Nullable String colorId, @Nullable String noteUuid, int state);

        @Nullable
        Class<?> getDocOpenTriggerClass();

        boolean isExternalCoeditRunning();

        boolean isSmartSwitchRunning();

        boolean isSyncRunning();
    }

    private DocumentAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final DocumentAccessContract getContract() {
        return contract;
    }

    @JvmStatic
    public static final void setContract(@Nullable DocumentAccessContract contract2) {
        contract = contract2;
    }
}

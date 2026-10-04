package com.samsung.android.support.senl.p148nt.model.importer.utils;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.DocumentCustomDataUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/importer/utils/ImportUtils;", "", "<init>", "()V", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/importer/utils/ImportUtils$Companion;", "", "<init>", "()V", "createNewUuid", "", "context", "Landroid/content/Context;", "filePath", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String createNewUuid(@NotNull Context context, @NotNull String filePath) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            if (!SpenSdkInitializer.initialize(context)) {
                throw new RuntimeException("fail to init spen sdk");
            }
            String strNewUUID = UUIDUtils.newUUID(context);
            String appCustomData = SpenWNoteFile.getAppCustomData(filePath);
            if (TextUtils.isEmpty(appCustomData)) {
                return strNewUUID;
            }
            String strUpdateDynamicTemplateUuid = DocumentCustomDataUtils.updateDynamicTemplateUuid(strNewUUID, appCustomData);
            Intrinsics.checkNotNullExpressionValue(strUpdateDynamicTemplateUuid, "updateDynamicTemplateUuid(...)");
            return strUpdateDynamicTemplateUuid;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final String createNewUuid(@NotNull Context context, @NotNull String str) {
        return INSTANCE.createNewUuid(context, str);
    }
}

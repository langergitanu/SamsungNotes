package com.samsung.android.support.senl.p145cm.base.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.SNBConverter;
import com.samsung.android.support.senl.document.memoconverter.SPDConverter;
import com.samsung.android.support.senl.p145cm.base.common.constants.Constants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u0014\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/LockFileUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getLockTypeFromSdoc", "", "context", "Landroid/content/Context;", "spenSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "getLockTypeFromSdocx", "spenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getLockType", "targetPath", "isLockedSPD", "", "filePath", "isLockedSNB", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockFileUtils {

    @NotNull
    public static final LockFileUtils INSTANCE = new LockFileUtils();

    @NotNull
    private static final String TAG = "LockFileUtils";

    private LockFileUtils() {
    }

    @JvmStatic
    public static final int getLockType(@Nullable Context context, @Nullable String targetPath) {
        if (TextUtils.isEmpty(targetPath)) {
            return 0;
        }
        if ((targetPath != null && StringsKt.m14167w(targetPath, ".spd")) || (targetPath != null && StringsKt.m14167w(targetPath, ".spdbak"))) {
            return INSTANCE.isLockedSPD(context, targetPath) ? 2 : 0;
        }
        if (targetPath == null || !StringsKt.m14167w(targetPath, ".memo")) {
            return (((targetPath == null || !StringsKt.m14167w(targetPath, ".snb")) && (targetPath == null || !StringsKt.m14167w(targetPath, ".snbbak"))) || !INSTANCE.isLockedSNB(context, targetPath)) ? 0 : 3;
        }
        return 0;
    }

    @JvmStatic
    public static final int getLockTypeFromSdoc(@Nullable Context context, @NotNull SpenSDoc spenSDoc) {
        String boundFilePath;
        Intrinsics.checkNotNullParameter(spenSDoc, "spenSDoc");
        try {
            boundFilePath = spenSDoc.getBoundFilePath(Constants.SNote.SDOC_LOCKED_FILE_KEY);
        } catch (IllegalArgumentException e) {
            AbstractC0000a.m23t("getLockTypeFromSdoc, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            boundFilePath = null;
        }
        return getLockType(context, boundFilePath);
    }

    @JvmStatic
    public static final int getLockTypeFromSdocx(@Nullable Context context, @NotNull SpenWNote spenWNote) {
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        try {
        } catch (IllegalArgumentException e) {
            AbstractC0000a.m23t("getLockTypeFromSdocx, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        String attachedFile = spenWNote.hasAttachedFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY) ? spenWNote.getAttachedFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY) : null;
        return getLockType(context, attachedFile);
    }

    private final boolean isLockedSNB(Context context, String filePath) {
        return new SNBConverter(context).isLocked(filePath);
    }

    private final boolean isLockedSPD(Context context, String filePath) {
        return new SPDConverter(context).isLocked(filePath);
    }
}

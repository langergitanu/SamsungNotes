package com.samsung.android.support.senl.p148nt.base.common.sdk.wrapper;

import android.content.Context;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sdk/wrapper/SpenSDocFileCompat;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getUncompressedSized", "", "sdocFilePath", "", "getModifiedTime", "checkUnsupportedVersionException", "", "getCreatedTime", "setFavorite", "", "flag", "checkValidity", "AbsolutePath", "getDocumentType", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenSDocFileCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenSDocFileCompat";

    @NotNull
    private final Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sdk/wrapper/SpenSDocFileCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "of", "Lcom/samsung/android/support/senl/nt/base/common/sdk/wrapper/SpenSDocFileCompat;", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* JADX INFO: renamed from: of */
        public final SpenSDocFileCompat m8642of(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Logger.m8697d(SpenSDocFileCompat.TAG, "of, isInitialized : " + SpenSdkInitializer.initialize(context));
            return new SpenSDocFileCompat(context, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SpenSDocFileCompat(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public final void checkValidity(@NotNull String AbsolutePath) {
        Intrinsics.checkNotNullParameter(AbsolutePath, "AbsolutePath");
        SpenSDocFile.checkValidity(AbsolutePath);
    }

    public final long getCreatedTime(@NotNull String sdocFilePath, boolean checkUnsupportedVersionException) {
        Intrinsics.checkNotNullParameter(sdocFilePath, "sdocFilePath");
        return SpenSDocFile.getCreatedTime(sdocFilePath, checkUnsupportedVersionException);
    }

    public final int getDocumentType(@NotNull String AbsolutePath) {
        Intrinsics.checkNotNullParameter(AbsolutePath, "AbsolutePath");
        return SpenSDocFile.getDocumentType(AbsolutePath);
    }

    public final long getModifiedTime(@NotNull String sdocFilePath, boolean checkUnsupportedVersionException) {
        Intrinsics.checkNotNullParameter(sdocFilePath, "sdocFilePath");
        return SpenSDocFile.getModifiedTime(sdocFilePath, checkUnsupportedVersionException);
    }

    public final long getUncompressedSized(@NotNull String sdocFilePath) {
        Intrinsics.checkNotNullParameter(sdocFilePath, "sdocFilePath");
        return SpenSDocFile.getUncompressedSize(sdocFilePath);
    }

    public final void setFavorite(@NotNull String sdocFilePath, boolean flag) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        Intrinsics.checkNotNullParameter(sdocFilePath, "sdocFilePath");
        SpenSDocFile.setFavorite(sdocFilePath, flag);
    }

    private SpenSDocFileCompat(Context context) {
        this.mContext = context;
    }

    public final long getCreatedTime(@NotNull String AbsolutePath) {
        Intrinsics.checkNotNullParameter(AbsolutePath, "AbsolutePath");
        return SpenSDocFile.getCreatedTime(AbsolutePath);
    }
}

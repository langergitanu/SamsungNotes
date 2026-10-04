package com.samsung.android.support.senl.p148nt.base.framework.provider;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.FileProvider;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/provider/ShareFileProvider;", "Landroidx/core/content/FileProvider;", "<init>", "()V", "attachInfo", "", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", "getType", "", "uri", "Landroid/net/Uri;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShareFileProvider extends FileProvider {

    @NotNull
    private static final String TAG = "ShareFileProvider";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String AUTHORITY = "com.samsung.android.app.notes.shareprovider";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/framework/provider/ShareFileProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "AUTHORITY", "getAUTHORITY$annotations", "getAUTHORITY", "()Ljava/lang/String;", "setAUTHORITY", "(Ljava/lang/String;)V", "setAuthority", "", "authority", "getShareDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "getExternalDir", "getUri", "Landroid/net/Uri;", "sharePath", "srcPath", "fileName", "getFileExt", "copySDocX", "", "isMyShareFileProvider", "uri", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean copySDocX(Context context, String srcPath, String sharePath) {
            if (DocumentAccessHandler.getContract() == null) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            }
            DocumentAccessHandler.DocumentAccessContract contract = DocumentAccessHandler.getContract();
            if (contract == null) {
                return false;
            }
            return contract.copyDocument(context, srcPath, sharePath);
        }

        @JvmStatic
        public static /* synthetic */ void getAUTHORITY$annotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getFileExt(String fileName) {
            int iM14130D;
            if (!StringsKt.m14162r(fileName, Extension.DOT) || (iM14130D = StringsKt.m14130D(fileName, '.') + 1) < ((int) Math.max(StringsKt.m14130D(fileName, '/'), StringsKt.m14130D(fileName, '\\')))) {
                return "";
            }
            int length = fileName.length();
            if (iM14130D == fileName.length()) {
                return "";
            }
            String strSubstring = fileName.substring(iM14130D, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void setAuthority(String authority) {
            setAUTHORITY(authority);
        }

        @NotNull
        public final String getAUTHORITY() {
            return ShareFileProvider.AUTHORITY;
        }

        @JvmStatic
        @NotNull
        public final File getExternalDir(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getExternalFilesDir(null), Extension.DOT);
            if (!file.exists() && !file.mkdir()) {
                Logger.m8698e(ShareFileProvider.TAG, "getExternalDir# mkdir fail");
            }
            return file;
        }

        @JvmStatic
        @NotNull
        public final File getShareDir(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getFilesDir(), ShareCacheHelper.CACHE_PATH);
            if (!file.exists() && !file.mkdir()) {
                Logger.m8698e(ShareFileProvider.TAG, "getShareDir# mkdir fail");
            }
            return file;
        }

        @JvmStatic
        @Nullable
        public final Uri getUri(@NotNull Context context, @Nullable String sharePath) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(sharePath);
            if (file.exists()) {
                return FileProvider.getUriForFile(context, getAUTHORITY(), file);
            }
            Logger.m8698e(ShareFileProvider.TAG, "getUri, the path is invalid.");
            return null;
        }

        @JvmStatic
        public final boolean isMyShareFileProvider(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return Intrinsics.areEqual(getAUTHORITY(), uri.getAuthority());
        }

        public final void setAUTHORITY(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ShareFileProvider.AUTHORITY = str;
        }

        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final Uri getUri(@NotNull Context context, @NotNull String srcPath, @NotNull String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(srcPath, "srcPath");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Logger.m8697d(ShareFileProvider.TAG, "getUri, srcPath: " + Logger.getEncode(srcPath) + ", fileName: " + fileName);
            if (!TextUtils.isEmpty(srcPath) && AbstractC2322a.m1607A(srcPath)) {
                if (TextUtils.isEmpty(fileName)) {
                    fileName = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(fileName, "toString(...)");
                }
                try {
                    String canonicalPath = getShareDir(context).getCanonicalPath();
                    Intrinsics.checkNotNullExpressionValue(canonicalPath, "getCanonicalPath(...)");
                    String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(canonicalPath, fileName, getFileExt(srcPath));
                    if (copySDocX(context, srcPath, strGenerateUniqueFilePath)) {
                        return getUri(context, strGenerateUniqueFilePath);
                    }
                    return null;
                } catch (Exception e) {
                    Logger.m8699e(ShareFileProvider.TAG, "getUri", e);
                }
            }
            return null;
        }
    }

    @NotNull
    public static final String getAUTHORITY() {
        return INSTANCE.getAUTHORITY();
    }

    @JvmStatic
    @NotNull
    public static final File getExternalDir(@NotNull Context context) {
        return INSTANCE.getExternalDir(context);
    }

    @JvmStatic
    @NotNull
    public static final File getShareDir(@NotNull Context context) {
        return INSTANCE.getShareDir(context);
    }

    @JvmStatic
    @Nullable
    public static final Uri getUri(@NotNull Context context, @Nullable String str) {
        return INSTANCE.getUri(context, str);
    }

    @JvmStatic
    public static final boolean isMyShareFileProvider(@NotNull Uri uri) {
        return INSTANCE.isMyShareFileProvider(uri);
    }

    public static final void setAUTHORITY(@NotNull String str) {
        INSTANCE.setAUTHORITY(str);
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(@NotNull Context context, @NotNull ProviderInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            Logger.m8697d(TAG, "attachInfo, ProviderInfo info: " + info);
            Companion companion = INSTANCE;
            String authority = info.authority;
            Intrinsics.checkNotNullExpressionValue(authority, "authority");
            companion.setAuthority(authority);
            super.attachInfo(context, info);
        } catch (Exception e) {
            Logger.m8699e(TAG, "attachInfo", e);
        }
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        String path;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String type = super.getType(uri);
        if (Intrinsics.areEqual("application/octet-stream", type) && (path = uri.getPath()) != null) {
            String fileExt = INSTANCE.getFileExt(path);
            if (Intrinsics.areEqual("sdocx", fileExt) || Intrinsics.areEqual("sdoc", fileExt)) {
                return Constants.MIME_SDOC;
            }
        }
        return type;
    }

    @JvmStatic
    @Nullable
    public static final Uri getUri(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        return INSTANCE.getUri(context, str, str2);
    }
}

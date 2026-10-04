package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.PermissionUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027F3.RunnableC0101a;
import p107a4.RunnableC0355a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001MB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0007JE\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00102\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001f0\u001e\"\u0004\u0018\u00010\u001fH\u0007¢\u0006\u0002\u0010 JM\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001f0\u001e\"\u0004\u0018\u00010\u001fH\u0007¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0007J(\u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0007J;\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u001f2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001e\"\u00020\u0005H\u0007¢\u0006\u0002\u0010)J7\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001e\"\u00020\u0005¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rJ\u0018\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\b\u00101\u001a\u0004\u0018\u000102H\u0007J\u0012\u00103\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000202H\u0007J\u0012\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u000202H\u0007J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u000202H\u0002J\u001e\u00106\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020\u0005H\u0002J\u0014\u00108\u001a\u0004\u0018\u0001002\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0002J*\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00050;j\b\u0012\u0004\u0012\u00020\u0005`<2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000102J\u001e\u0010=\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000102H\u0007J \u0010>\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0007J*\u0010?\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010@\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rJ\u0018\u0010A\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J&\u0010B\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u0005J2\u0010B\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u0005H\u0002J*\u0010D\u001a\u00020E2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u0002002\b\b\u0002\u0010H\u001a\u00020IH\u0007J \u0010J\u001a\u00020E2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u000200H\u0007J0\u0010K\u001a\u00020E2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u0002002\u0006\u0010L\u001a\u00020\u00052\u0006\u0010H\u001a\u00020IH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ContentPickerUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MYFILES_PACKAGE", "MYFILES_EXTRA_URI", "MYFILES_EXTRA_PATH", "MYFILES_EXTRA_PATH_URI", "AUDIO_PICKER_NAME", ContentPickerUtils.AUDIO_PICKER_MODE, "AUDIO_PICKER_MODE_COMPOSER", "", "AUDIO_PICKER_MODE_MAIN_LIST", "canExportFileMenu", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "canAddPdfFileMenu", "context", "Landroid/content/Context;", "startPdfPickerActivityForResult", "", "fragment", "Landroidx/fragment/app/Fragment;", "permissionCode", "requestCode", "isMultiple", "preAction", "", "Ljava/lang/Runnable;", "(Landroidx/fragment/app/Fragment;IIZ[Ljava/lang/Runnable;)V", "isFragmentStart", "(Landroidx/fragment/app/Fragment;IIZZ[Ljava/lang/Runnable;)V", "isShowingAddPdfFileMenuErrorToast", "startImagePickerActivityForResult", "requestedAnchorType", "startAttachActivityForResult", "action", "permissions", "(Landroidx/fragment/app/Fragment;ILjava/lang/Runnable;[Ljava/lang/String;)V", "startMyfilesPickerActivityForResult", "typeList", "(Landroidx/fragment/app/Fragment;II[Ljava/lang/String;)V", "startSNBAKPickerActivityForResult", "getUriListFromResult", "", "Landroid/net/Uri;", "data", "Landroid/content/Intent;", "getUriFromSingleData", "getTitleFromSingleData", "getUriListFromClipData", "getUriListFromMyFile", "key", "getUriFromObject", "entry", "getPathListFromResult", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPathFromResult", "startSaveDirectoryPickerActivityForResult", "isSaveAsPermissionGranted", "permissionType", "requestMyFilesAppToPickPath", "isStoragePermissionGranted", NotesConstants.KEY_CALLER, "downloadPdf", "Lcom/samsung/android/support/senl/nt/base/common/util/ContentPickerUtils$DownloadFileResult;", "cacheDir", "uri", "limitDocumentSize", "", "downloadText", "downloadFile", "fileName", "DownloadFileResult", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContentPickerUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentPickerUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/ContentPickerUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,567:1\n1#2:568\n37#3:569\n36#3,3:570\n37#3:573\n36#3,3:574\n37#3:577\n36#3,3:578\n*S KotlinDebug\n*F\n+ 1 ContentPickerUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/ContentPickerUtils\n*L\n428#1:569\n428#1:570,3\n445#1:573\n445#1:574,3\n495#1:577\n495#1:578,3\n*E\n"})
public final class ContentPickerUtils {

    @NotNull
    public static final String AUDIO_PICKER_MODE = "AUDIO_PICKER_MODE";
    public static final int AUDIO_PICKER_MODE_COMPOSER = 1;
    public static final int AUDIO_PICKER_MODE_MAIN_LIST = 2;

    @NotNull
    public static final String AUDIO_PICKER_NAME = "FILE_TITLE";

    @NotNull
    public static final ContentPickerUtils INSTANCE = new ContentPickerUtils();

    @NotNull
    private static final String MYFILES_EXTRA_PATH = "FILE";

    @NotNull
    private static final String MYFILES_EXTRA_PATH_URI = "uri";

    @NotNull
    public static final String MYFILES_EXTRA_URI = "FILE_URI";

    @NotNull
    public static final String MYFILES_PACKAGE = "com.sec.android.app.myfiles";

    @NotNull
    public static final String TAG = "ContentPickerUtils";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ContentPickerUtils$DownloadFileResult;", "", "mFilePath", "", "mSaveResult", "", "<init>", "(Ljava/lang/String;I)V", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DownloadFileResult {

        @JvmField
        @Nullable
        public String mFilePath;

        @JvmField
        public int mSaveResult;

        public DownloadFileResult(@Nullable String str, int i) {
            this.mFilePath = str;
            this.mSaveResult = i;
        }

        @NotNull
        public String toString() {
            return "DownloadFileResult# filePath: " + Logger.getEncode(this.mFilePath) + " saveResult: " + this.mSaveResult;
        }
    }

    private ContentPickerUtils() {
    }

    @JvmStatic
    public static final boolean canAddPdfFileMenu(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (CommonUtils.isPackageInstalledAndEnabled(context, MYFILES_PACKAGE)) {
            return true;
        }
        if (INSTANCE.isShowingAddPdfFileMenuErrorToast(context)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_PDF);
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        String string = context.getResources().getString(C8875R.string.myfiles_string);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getResources().getString(C8875R.string.app_is_not_installed, string, string);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ToastHandler.show(context, string2, 1);
        return false;
    }

    @JvmStatic
    public static final boolean canExportFileMenu(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (CommonUtils.isPackageInstalledAndEnabled(activity, MYFILES_PACKAGE)) {
            return true;
        }
        String string = activity.getResources().getString(C8875R.string.myfiles_string);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = activity.getResources().getString(C8875R.string.app_is_not_installed, string, string);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ToastHandler.show(activity, string2, 1);
        return false;
    }

    private final DownloadFileResult downloadFile(Context context, String cacheDir, Uri uri, String fileName, long limitDocumentSize) {
        String strM756B = cacheDir;
        Logger.m8702i(TAG, "downloadFile# start");
        long availableInternalMemorySize = StorageUtils.getAvailableInternalMemorySize() - 10485760;
        long jMin = (long) Math.min(availableInternalMemorySize, limitDocumentSize);
        long fileSize = FileUtils.getFileSize(context, uri);
        if (jMin < fileSize) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(fileSize, "downloadFile# too large file: ", " / ");
            sbM1323p.append(jMin);
            Logger.m8702i(TAG, sbM1323p.toString());
            return new DownloadFileResult(null, availableInternalMemorySize < limitDocumentSize ? 3 : 2);
        }
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        if (!StringsKt.m14167w(strM756B, separator)) {
            strM756B = AbstractC0541b.m756B(strM756B, separator);
        }
        String strM756B2 = AbstractC0541b.m756B(strM756B, fileName);
        int iSaveUriToFile$default = UriFileUtils.saveUriToFile$default(UriFileUtils.INSTANCE, context, uri, strM756B2, jMin, false, 16, (Object) null);
        if (iSaveUriToFile$default != 0) {
            if (!TextUtils.isEmpty(strM756B2)) {
                FileUtils.deleteFile$default(strM756B2, false, 2, null);
            }
        } else if (limitDocumentSize < new File(strM756B2).length()) {
            FileUtils.deleteFile$default(strM756B2, false, 2, null);
            return new DownloadFileResult(null, 2);
        }
        DownloadFileResult downloadFileResult = new DownloadFileResult(strM756B2, iSaveUriToFile$default);
        Logger.m8702i(TAG, "downloadFile# end " + downloadFileResult);
        return downloadFileResult;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final DownloadFileResult downloadPdf(@NotNull Context context, @NotNull String cacheDir, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return downloadPdf$default(context, cacheDir, uri, 0L, 8, null);
    }

    public static /* synthetic */ DownloadFileResult downloadPdf$default(Context context, String str, Uri uri, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 1073741824;
        }
        return downloadPdf(context, str, uri, j);
    }

    @JvmStatic
    @NotNull
    public static final DownloadFileResult downloadText(@NotNull Context context, @NotNull String cacheDir, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return INSTANCE.downloadFile(context, cacheDir, uri, AbstractC1974b.m1317j(System.currentTimeMillis(), "text_", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.TEXT_EXTENSION), 1073741824L);
    }

    @JvmStatic
    @Nullable
    public static final String getPathFromResult(@Nullable Context context, @Nullable Intent data) {
        if (context == null || data == null) {
            return "";
        }
        String stringExtra = data.getStringExtra("uri");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        String stringExtra2 = data.getStringExtra(MYFILES_EXTRA_PATH);
        return !TextUtils.isEmpty(stringExtra2) ? stringExtra2 : UriFileUtils.getPath(context, getUriFromSingleData(data));
    }

    @JvmStatic
    @Nullable
    public static final String getTitleFromSingleData(@NotNull Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getStringExtra(AUDIO_PICKER_NAME);
    }

    private final Uri getUriFromObject(Object entry) {
        if (entry instanceof Uri) {
            return (Uri) entry;
        }
        if (!(entry instanceof String)) {
            return null;
        }
        String str = (String) entry;
        File file = new File(str);
        return file.exists() ? Uri.fromFile(file) : Uri.parse(str);
    }

    @JvmStatic
    @Nullable
    public static final Uri getUriFromSingleData(@NotNull Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Uri data2 = data.getData();
        return data2 == null ? (Uri) data.getParcelableExtra(MYFILES_EXTRA_URI) : data2;
    }

    private final List<Uri> getUriListFromClipData(Intent data) {
        ArrayList arrayList = new ArrayList();
        ClipData clipData = data.getClipData();
        if (clipData != null) {
            int itemCount = clipData.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                Uri uri = clipData.getItemAt(i).getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    private final List<Uri> getUriListFromMyFile(Intent data, String key) {
        ArrayList arrayList = new ArrayList();
        Bundle extras = data.getExtras();
        if (extras != null && extras.containsKey(key)) {
            Object obj = extras.get(key);
            if (obj instanceof Object[]) {
                for (Object obj2 : (Object[]) obj) {
                    Uri uriFromObject = getUriFromObject(obj2);
                    if (uriFromObject != null) {
                        arrayList.add(uriFromObject);
                    }
                }
            } else {
                Uri uriFromObject2 = getUriFromObject(obj);
                if (uriFromObject2 != null) {
                    arrayList.add(uriFromObject2);
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<Uri> getUriListFromResult(@Nullable Intent data) {
        if (data == null) {
            Logger.m8698e(TAG, "getUriListFromResult# data is null");
            return CollectionsKt.emptyList();
        }
        Uri uriFromSingleData = getUriFromSingleData(data);
        if (uriFromSingleData != null) {
            return CollectionsKt.listOf(uriFromSingleData);
        }
        ContentPickerUtils contentPickerUtils = INSTANCE;
        List<Uri> uriListFromClipData = contentPickerUtils.getUriListFromClipData(data);
        if (!uriListFromClipData.isEmpty()) {
            return uriListFromClipData;
        }
        List<Uri> uriListFromMyFile = contentPickerUtils.getUriListFromMyFile(data, MYFILES_EXTRA_URI);
        if (!uriListFromMyFile.isEmpty()) {
            return uriListFromMyFile;
        }
        List<Uri> uriListFromMyFile2 = contentPickerUtils.getUriListFromMyFile(data, MYFILES_EXTRA_PATH);
        if (!uriListFromMyFile2.isEmpty()) {
            return uriListFromMyFile2;
        }
        Logger.m8698e(TAG, "getUriListFromResult# We can't find any uri from the intent." + LoggerBase.INSTANCE.getEncode(data.toString()));
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isSaveAsPermissionGranted$lambda$4(String[] strArr, Activity activity, Fragment fragment, int i) {
        String string = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m8702i(TAG, "startSaveDirectoryPickerActivityForResult# to request " + string + " permission");
        if (PermissionCompat.FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE && Build.VERSION.SDK_INT >= 30) {
            PermissionUtils.showAllFilesAccessPermission(activity, 53);
        } else if (fragment != null) {
            PermissionHelper.requestPermissions(fragment, i, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    private final boolean isShowingAddPdfFileMenuErrorToast(Context context) {
        if (SettingsCompat.INSTANCE.getInstance().isUPSM(context)) {
            String string = context.getResources().getString(C8875R.string.composer_upsm_to_add_pdf, context.getResources().getString(C8875R.string.myfiles_string));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
            return true;
        }
        if (!EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(context)) {
            return false;
        }
        String string2 = context.getResources().getString(C8875R.string.app_chooser_emergency_mode_unable_to_use_attach, context.getString(C8875R.string.app_chooser_attach));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ToastHandler.show(context, string2, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isStoragePermissionGranted$lambda$5(String str, String[] strArr, Fragment fragment, int i) {
        String string = Arrays.toString(strArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m8702i(TAG, "isStoragePermissionGranted#" + str + "# to request " + string + " permission");
        PermissionHelper.requestPermissions(fragment, i, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final void requestMyFilesAppToPickPath(int requestCode, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(5)).toArray(new String[0]);
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(activity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                String string = activity.getResources().getString(C8875R.string.need_to_allow_permission, activity.getResources().getString(C8875R.string.storage_permission_title));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ToastHandler.show(activity, string, 1);
                return;
            }
        }
        try {
            Intent intent = new Intent("com.sec.android.app.myfiles.PICK_SELECT_PATH");
            if (i == 28) {
                Logger.m8702i(TAG, "startSaveDirectoryPickerActivityForResult# EXCLUDE_SD is true");
                intent.putExtra("EXCLUDE_SD", true);
            }
            intent.putExtra("EXCLUDE_CLOUD", true);
            activity.startActivityForResult(intent, requestCode);
        } catch (ActivityNotFoundException e) {
            Logger.m8697d(TAG, e.getMessage());
        }
    }

    @JvmStatic
    public static final void startAttachActivityForResult(@NotNull Fragment fragment, int permissionCode, @Nullable Runnable action, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            Logger.m8697d(TAG, "activity is null");
        } else if (PermissionHelper.isPermissionGranted(activity, new RunnableC0101a(fragment, permissionCode, permissions, 11), (String[]) Arrays.copyOf(permissions, permissions.length)) && action != null) {
            action.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAttachActivityForResult$lambda$0(Fragment fragment, int i, String[] strArr) {
        Logger.m8697d(TAG, "to get permissions");
        PermissionHelper.requestPermissions(fragment, i, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final void startImagePickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        startImagePickerActivityForResult(fragment, permissionCode, requestCode, -3);
    }

    @JvmStatic
    public static final void startPdfPickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode, boolean isMultiple, @NotNull Runnable... preAction) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(preAction, "preAction");
        startPdfPickerActivityForResult(fragment, permissionCode, requestCode, isMultiple, false, (Runnable[]) Arrays.copyOf(preAction, preAction.length));
    }

    @JvmStatic
    public static final void startSaveDirectoryPickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && INSTANCE.isSaveAsPermissionGranted(activity, fragment, 5, permissionCode)) {
            Logger.m8702i(TAG, "startSaveDirectoryPickerActivityForResult# requestCode : " + requestCode);
            requestMyFilesAppToPickPath(requestCode, activity);
        }
    }

    @NotNull
    public final ArrayList<String> getPathListFromResult(@Nullable Context context, @Nullable Intent data) {
        List<Uri> uriListFromResult;
        ArrayList<String> arrayList = new ArrayList<>();
        if (context != null && data != null && (uriListFromResult = getUriListFromResult(data)) != null) {
            Iterator<Uri> it = uriListFromResult.iterator();
            while (it.hasNext()) {
                String path = UriFileUtils.getPath(context, it.next());
                if (path != null) {
                    arrayList.add(path);
                }
            }
        }
        return arrayList;
    }

    public final boolean isSaveAsPermissionGranted(@Nullable Activity activity, @Nullable Fragment fragment, int permissionType, int permissionCode) {
        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(permissionType)).toArray(new String[0]);
        return PermissionHelper.isPermissionGranted(activity, new RunnableC0355a(strArr, activity, fragment, permissionCode), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final boolean isStoragePermissionGranted(@NotNull Fragment fragment, int permissionType, int permissionCode, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(caller, "caller");
        return isStoragePermissionGranted(fragment.getActivity(), fragment, permissionType, permissionCode, caller);
    }

    public final void startMyfilesPickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode, @NotNull String... typeList) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        String simpleName = fragment.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        if (isStoragePermissionGranted(fragment, 3, permissionCode, simpleName)) {
            Intent intent = new Intent();
            String strArrayJoin = CharUtils.arrayJoin(";", typeList);
            if (CommonUtils.isPackageInstalledAndEnabled(fragment.getContext(), MYFILES_PACKAGE)) {
                intent.setAction("com.sec.android.app.myfiles.PICK_DATA_MULTIPLE");
                intent.putExtra("EXCLUDE_CLOUD", true);
                intent.putExtra("PICKER_TYPE", "import");
                intent.putExtra("CONTENT_TYPE", strArrayJoin);
            } else {
                intent.setAction("android.intent.action.PICK");
                intent.setType(strArrayJoin);
            }
            try {
                fragment.startActivityForResult(intent, requestCode);
            } catch (ActivityNotFoundException e) {
                Logger.m8697d(TAG, e.getMessage());
            }
        }
    }

    public final void startSNBAKPickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        String simpleName = fragment.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        if (isStoragePermissionGranted(fragment, 3, permissionCode, simpleName)) {
            Intent intent = new Intent();
            if (CommonUtils.isPackageInstalledAndEnabled(fragment.getContext(), MYFILES_PACKAGE)) {
                intent.setAction("com.sec.android.app.myfiles.PICK_DATA_MULTIPLE");
                intent.putExtra("EXCLUDE_CLOUD", true);
                intent.putExtra("PICKER_TYPE", "import");
                intent.putExtra("CONTENT_EXTENSION", "snbak");
            } else {
                intent.setAction("android.intent.action.PICK");
            }
            try {
                fragment.startActivityForResult(intent, requestCode);
            } catch (ActivityNotFoundException e) {
                Logger.m8697d(TAG, e.getMessage());
            }
        }
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final DownloadFileResult downloadPdf(@NotNull Context context, @NotNull String cacheDir, @NotNull Uri uri, long limitDocumentSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return INSTANCE.downloadFile(context, cacheDir, uri, AbstractC1974b.m1317j(System.currentTimeMillis(), "pdf_", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PDF_EXTENSION_WITH_DOT), limitDocumentSize);
    }

    @JvmStatic
    public static final void startImagePickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode, int requestedAnchorType) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ContentPickerUtils contentPickerUtils = INSTANCE;
        String simpleName = fragment.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        if (contentPickerUtils.isStoragePermissionGranted(fragment, 1, permissionCode, simpleName)) {
            try {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_IMAGE);
                Intent intentCreateChooser = Intent.createChooser(intent, fragment.getResources().getString(C8875R.string.chooser_dialog_title));
                if (requestedAnchorType == -3) {
                    requestedAnchorType = PopOverActivityWrapper.getCurrentLayoutAnchorType(fragment.getActivity());
                }
                if (requestedAnchorType != -2) {
                    PopOverActivityWrapper.startActivityForResult(fragment, intentCreateChooser, requestCode, requestedAnchorType);
                } else {
                    fragment.startActivityForResult(intentCreateChooser, requestCode);
                }
            } catch (ActivityNotFoundException e) {
                Logger.m8698e(TAG, "startImagePickerActivityForResult# " + e.getMessage());
                String string = fragment.getResources().getString(C8875R.string.cannot_open_ps_app_chooser, fragment.getResources().getString(C8875R.string.gallery_title));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (fragment.getContext() != null) {
                    ToastHandler.show(fragment.getContext(), string, 1);
                }
            }
        }
    }

    @JvmStatic
    public static final void startPdfPickerActivityForResult(@NotNull Fragment fragment, int permissionCode, int requestCode, boolean isMultiple, boolean isFragmentStart, @NotNull Runnable... preAction) {
        Runnable runnable;
        Runnable runnable2;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(preAction, "preAction");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        ContentPickerUtils contentPickerUtils = INSTANCE;
        String simpleName = fragment.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        if (contentPickerUtils.isStoragePermissionGranted(activity, fragment, 3, permissionCode, simpleName)) {
            boolean z = preAction.length == 2;
            if (z && (runnable2 = preAction[0]) != null && runnable2 != null) {
                runnable2.run();
            }
            Intent intent = new Intent();
            if (CommonUtils.isPackageInstalledAndEnabled(fragment.getActivity(), MYFILES_PACKAGE)) {
                if (isMultiple) {
                    intent.setAction("com.sec.android.app.myfiles.PICK_DATA_MULTIPLE");
                } else {
                    intent.setAction("com.sec.android.app.myfiles.PICK_DATA");
                }
                intent.putExtra("CONTENT_TYPE", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_PDF);
            } else {
                intent.setAction("android.intent.action.PICK");
                intent.setType(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.MIME_PDF);
            }
            try {
                if (isFragmentStart) {
                    fragment.startActivityForResult(intent, requestCode);
                } else {
                    activity.startActivityForResult(intent, requestCode);
                }
                if (!z || (runnable = preAction[1]) == null || runnable == null) {
                    return;
                }
                runnable.run();
            } catch (ActivityNotFoundException e) {
                ContentPickerUtils contentPickerUtils2 = INSTANCE;
                Context contextRequireContext = fragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                if (contentPickerUtils2.isShowingAddPdfFileMenuErrorToast(contextRequireContext)) {
                    return;
                }
                Logger.m8697d(TAG, e.getMessage());
            }
        }
    }

    private final boolean isStoragePermissionGranted(Activity activity, Fragment fragment, int permissionType, int permissionCode, String caller) {
        if (activity == null) {
            Logger.m8697d(TAG, "isStoragePermissionGranted#" + caller + "# activity is null");
            return false;
        }
        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(permissionType)).toArray(new String[0]);
        return PermissionHelper.isPermissionGranted(activity, new RunnableC0355a(caller, strArr, fragment, permissionCode), (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}

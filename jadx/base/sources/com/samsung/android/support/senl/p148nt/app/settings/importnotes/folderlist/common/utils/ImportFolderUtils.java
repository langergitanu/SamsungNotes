package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.utils;

import android.os.Build;
import android.os.Environment;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common.ImportFolderConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p042J1.AbstractC0155m;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b0\u00072\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000b\"\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\fJQ\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b0\u00132\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000b\"\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000b\"\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/common/utils/ImportFolderUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getFileListHasSpecificExtension", "", "Lkotlin/Pair;", "", "extList", "", "([Ljava/lang/String;)Ljava/util/List;", "scanHasSpecificExtensionFiles", "", "file", "Ljava/io/File;", "storageType", "fileInfoList", "", "(Ljava/io/File;ILjava/util/List;[Ljava/lang/String;)V", "hasSpecificExtension", "", "path", "(Ljava/lang/String;[Ljava/lang/String;)Z", "isLocalNotePickerNeeds", "isLocalNotePickerNeeds$annotations", "()Z", "getSnotePickerType", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/common/ImportFolderConstants$SnotePickerType;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportFolderUtils {

    @NotNull
    public static final ImportFolderUtils INSTANCE = new ImportFolderUtils();

    @NotNull
    private static final String TAG = "ImportFolderUtils";

    private ImportFolderUtils() {
    }

    @JvmStatic
    @NotNull
    public static final List<Pair<Integer, String>> getFileListHasSpecificExtension(@NotNull String... extList) {
        Intrinsics.checkNotNullParameter(extList, "extList");
        ArrayList arrayList = new ArrayList();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            INSTANCE.scanHasSpecificExtensionFiles(externalStorageDirectory, 101, arrayList, (String[]) Arrays.copyOf(extList, extList.length));
        } else {
            MainLogger.m7258i(TAG, "deviceStorageDirectory is null! ");
        }
        File fileM391f = AbstractC0155m.m391f();
        if (fileM391f != null) {
            INSTANCE.scanHasSpecificExtensionFiles(fileM391f, 103, arrayList, (String[]) Arrays.copyOf(extList, extList.length));
            return arrayList;
        }
        MainLogger.m7258i(TAG, "sdCardDirectory is null! ");
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final ImportFolderConstants.SnotePickerType getSnotePickerType() {
        int i = Build.VERSION.SDK_INT;
        return 34 <= i ? ImportFolderConstants.SnotePickerType.RESTRICTED_LOCAL : 29 <= i ? ImportFolderConstants.SnotePickerType.MY_FILES : ImportFolderConstants.SnotePickerType.LOCAL;
    }

    private final boolean hasSpecificExtension(String path, String... extList) {
        for (String str : extList) {
            int length = path.length();
            Intrinsics.checkNotNull(str);
            if (length > str.length()) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = path.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.m14167w(lowerCase, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isLocalNotePickerNeeds() {
        ImportFolderConstants.SnotePickerType snotePickerType = getSnotePickerType();
        return snotePickerType == ImportFolderConstants.SnotePickerType.LOCAL || snotePickerType == ImportFolderConstants.SnotePickerType.RESTRICTED_LOCAL;
    }

    @JvmStatic
    public static /* synthetic */ void isLocalNotePickerNeeds$annotations() {
    }

    private final void scanHasSpecificExtensionFiles(File file, int storageType, List<Pair<Integer, String>> fileInfoList, String... extList) {
        File[] fileArrListFiles;
        if (file != null) {
            try {
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (!file2.isHidden()) {
                            if (file2.isDirectory()) {
                                scanHasSpecificExtensionFiles(file2, storageType, fileInfoList, (String[]) Arrays.copyOf(extList, extList.length));
                            } else {
                                String absolutePath = file2.getAbsolutePath();
                                Intrinsics.checkNotNull(absolutePath);
                                if (hasSpecificExtension(absolutePath, (String[]) Arrays.copyOf(extList, extList.length))) {
                                    fileInfoList.add(new Pair<>(Integer.valueOf(storageType), absolutePath));
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                AbstractC6670b.m4738C("scanHasSpecificExtensionFiles - ", th.getMessage(), TAG);
            }
        }
    }
}

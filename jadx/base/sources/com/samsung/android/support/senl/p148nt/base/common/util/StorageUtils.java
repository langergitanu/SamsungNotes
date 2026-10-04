package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.sdk.SpenSdkCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003()*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005H\u0007J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0005H\u0007J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0014\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001c\u0010\u0017¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/StorageUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "GB_SIZE", "", "MB_SIZE", "MINIMUM_AVAILABLE_MEMORY_SIZE_FOR_NEW_MEMO", "MINIMUM_AVAILABLE_MEMORY_SIZE", "MAXIMUM_DOCUMENT_SIZE_MB", "MAXIMUM_DOCUMENT_SIZE_BYTE", "availableInternalMemorySize", "getAvailableInternalMemorySize$annotations", "getAvailableInternalMemorySize", "()J", "availableConvertingMemorySizeForNewMemo", "getAvailableConvertingMemorySizeForNewMemo$annotations", "getAvailableConvertingMemorySizeForNewMemo", "isAvailableMemoryForNewMemo", "", "isAvailableMemoryForNewMemo$annotations", "()Z", "isAvailableMemoryForShare", BundleContract.STORAGE, "getSdocStorage", "filePath", "isAvailableMinimumMemory", "isAvailableMinimumMemory$annotations", "getUncompressedSdocSize", "context", "Landroid/content/Context;", "sdocFilePath", "getDocumentSize", "path", "directory", "Ljava/io/File;", "hasEnoughSpace", "requiredSpace", "GetSizeOfSDocTask", "GetSDocStorageTask", "GetSizeOfSDocShareTask", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStorageUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/StorageUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,203:1\n13472#2,2:204\n*S KotlinDebug\n*F\n+ 1 StorageUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/StorageUtils\n*L\n179#1:204,2\n*E\n"})
public final class StorageUtils {
    public static final long GB_SIZE = 1073741824;

    @NotNull
    public static final StorageUtils INSTANCE = new StorageUtils();
    public static final long MAXIMUM_DOCUMENT_SIZE_BYTE = 1073741824;
    public static final long MAXIMUM_DOCUMENT_SIZE_MB = 1024;
    public static final long MB_SIZE = 1048576;
    public static final long MINIMUM_AVAILABLE_MEMORY_SIZE = 10485760;
    public static final long MINIMUM_AVAILABLE_MEMORY_SIZE_FOR_NEW_MEMO = 10485760;

    @NotNull
    private static final String TAG = "StorageUtils";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/StorageUtils$GetSDocStorageTask;", "Ljava/util/concurrent/RecursiveTask;", "", XmlErrorCodes.LIST, "", "", "<init>", "(Ljava/util/List;)V", "compute", "()Ljava/lang/Long;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class GetSDocStorageTask extends RecursiveTask<Long> {

        @NotNull
        private final List<String> list;

        public GetSDocStorageTask(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.RecursiveTask
        @NotNull
        public Long compute() {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.list.iterator();
            while (it.hasNext()) {
                GetSizeOfSDocTask getSizeOfSDocTask = new GetSizeOfSDocTask(it.next());
                getSizeOfSDocTask.fork();
                arrayList.add(getSizeOfSDocTask);
            }
            Iterator it2 = arrayList.iterator();
            long jLongValue = 0;
            while (it2.hasNext()) {
                Long lJoin = ((GetSizeOfSDocTask) it2.next()).join();
                Intrinsics.checkNotNullExpressionValue(lJoin, "join(...)");
                jLongValue += lJoin.longValue();
            }
            return Long.valueOf(jLongValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/StorageUtils$GetSizeOfSDocShareTask;", "Lcom/samsung/android/support/senl/nt/base/common/util/StorageUtils$GetSizeOfSDocTask;", "filePath", "", "uuid", "title", "createdAt", "lastModifiedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class GetSizeOfSDocShareTask extends GetSizeOfSDocTask {

        @JvmField
        @NotNull
        public final String createdAt;

        @JvmField
        @NotNull
        public final String filePath;

        @JvmField
        @NotNull
        public final String lastModifiedAt;

        @JvmField
        @NotNull
        public final String title;

        @JvmField
        @NotNull
        public final String uuid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSizeOfSDocShareTask(@NotNull String filePath, @NotNull String uuid, @NotNull String title, @NotNull String createdAt, @NotNull String lastModifiedAt) {
            super(filePath);
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(createdAt, "createdAt");
            Intrinsics.checkNotNullParameter(lastModifiedAt, "lastModifiedAt");
            this.filePath = filePath;
            this.uuid = uuid;
            this.title = title;
            this.createdAt = createdAt;
            this.lastModifiedAt = lastModifiedAt;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\r\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/StorageUtils$GetSizeOfSDocTask;", "Ljava/util/concurrent/RecursiveTask;", "", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "filePath", "", "(Ljava/lang/String;)V", "compute", "()Ljava/lang/Long;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class GetSizeOfSDocTask extends RecursiveTask<Long> {

        @NotNull
        private final File file;

        public GetSizeOfSDocTask(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            Objects.requireNonNull(file);
            Intrinsics.checkNotNullExpressionValue(file, "requireNonNull(...)");
            this.file = file;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.RecursiveTask
        @NotNull
        public Long compute() {
            if (this.file.isFile()) {
                return Long.valueOf(this.file.length());
            }
            ArrayList arrayList = new ArrayList();
            File[] fileArrListFiles = this.file.listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    File file = (File) it.next();
                    Intrinsics.checkNotNull(file);
                    GetSizeOfSDocTask getSizeOfSDocTask = new GetSizeOfSDocTask(file);
                    getSizeOfSDocTask.fork();
                    arrayList.add(getSizeOfSDocTask);
                }
            }
            Iterator it2 = arrayList.iterator();
            long jLongValue = 0;
            while (it2.hasNext()) {
                Long lJoin = ((GetSizeOfSDocTask) it2.next()).join();
                Intrinsics.checkNotNullExpressionValue(lJoin, "join(...)");
                jLongValue += lJoin.longValue();
            }
            return Long.valueOf(jLongValue);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public GetSizeOfSDocTask(@NotNull String filePath) {
            this(new File(filePath));
            Intrinsics.checkNotNullParameter(filePath, "filePath");
        }
    }

    private StorageUtils() {
    }

    public static final long getAvailableConvertingMemorySizeForNewMemo() {
        return 10485760L;
    }

    @JvmStatic
    public static /* synthetic */ void getAvailableConvertingMemorySizeForNewMemo$annotations() {
    }

    public static final long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    @JvmStatic
    public static /* synthetic */ void getAvailableInternalMemorySize$annotations() {
    }

    @JvmStatic
    public static final long getDocumentSize(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!StringsKt.m14162r(path, ".sdocx")) {
            AbstractC4539a.m3188B("getDocumentSize, not .sdocx: ", Logger.getEncode(path), TAG);
            return 0L;
        }
        long documentSize = INSTANCE.getDocumentSize(new File(path));
        Logger.m8697d(TAG, "getDocumentSize: " + documentSize);
        return documentSize;
    }

    @JvmStatic
    public static final long getSdocStorage(@NotNull String filePath) {
        long length;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        long j = 0;
        if (!file.isDirectory()) {
            if (file.exists()) {
                return file.length();
            }
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    String path = file2.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    length = getSdocStorage(path);
                } else {
                    length = file2.length();
                }
                j += length;
            }
        }
        return j;
    }

    @JvmStatic
    public static final long getUncompressedSdocSize(@NotNull Context context, @NotNull String sdocFilePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdocFilePath, "sdocFilePath");
        if (TextUtils.isEmpty(sdocFilePath) || !AbstractC2322a.m1607A(sdocFilePath)) {
            return 0L;
        }
        try {
            return SpenSdkCompat.with(context).asSpenSDocFile().getUncompressedSized(sdocFilePath);
        } catch (Exception e) {
            Logger.m8699e(TAG, e.getMessage(), e);
            return 0L;
        }
    }

    @JvmStatic
    public static final boolean hasEnoughSpace(long requiredSpace) {
        long availableInternalMemorySize = getAvailableInternalMemorySize();
        if (availableInternalMemorySize < 10485760) {
            return false;
        }
        long j = requiredSpace + 10485760;
        boolean z = availableInternalMemorySize > j;
        if (!z) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(availableInternalMemorySize, "hasEnoughStorage, available/required: ", "/");
            sbM1323p.append(j);
            Logger.m8697d(TAG, sbM1323p.toString());
        }
        return z;
    }

    public static final boolean isAvailableMemoryForNewMemo() {
        return getAvailableInternalMemorySize() > 10485760;
    }

    @JvmStatic
    public static /* synthetic */ void isAvailableMemoryForNewMemo$annotations() {
    }

    @JvmStatic
    public static final boolean isAvailableMemoryForShare(long storage) {
        return getAvailableInternalMemorySize() - storage > 10485760;
    }

    public static final boolean isAvailableMinimumMemory() {
        long availableInternalMemorySize = getAvailableInternalMemorySize();
        if (availableInternalMemorySize > 10485760) {
            return true;
        }
        Logger.m8697d(TAG, "isAvailableMinimumMemory# " + availableInternalMemorySize);
        return false;
    }

    @JvmStatic
    public static /* synthetic */ void isAvailableMinimumMemory$annotations() {
    }

    private final long getDocumentSize(File directory) {
        long length;
        long j = 0;
        if (directory.exists() && directory.isDirectory()) {
            File[] fileArrListFiles = directory.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file.isDirectory()) {
                        StorageUtils storageUtils = INSTANCE;
                        Intrinsics.checkNotNull(file);
                        length = storageUtils.getDocumentSize(file);
                    } else {
                        length = file.length();
                    }
                    j += length;
                }
            }
            return j;
        }
        AbstractC4539a.m3188B("getDocumentSize, invalid path: ", Logger.getEncode(directory.getPath()), TAG);
        return 0L;
    }
}

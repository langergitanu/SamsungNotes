package com.samsung.android.support.senl.p145cm.base.framework.sem.support;

import android.os.Build;
import android.os.storage.StorageVolume;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/support/StorageManagerUtil;", "", "<init>", "()V", "getPath", "", "volume", "Landroid/os/storage/StorageVolume;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StorageManagerUtil {

    @NotNull
    public static final StorageManagerUtil INSTANCE = new StorageManagerUtil();

    private StorageManagerUtil() {
    }

    @JvmStatic
    @NotNull
    public static final String getPath(@NotNull StorageVolume volume) {
        String path;
        Intrinsics.checkNotNullParameter(volume, "volume");
        if (Build.VERSION.SDK_INT >= 30) {
            File directory = volume.getDirectory();
            return (directory == null || (path = directory.getPath()) == null) ? "" : path;
        }
        String strSemGetPath = volume.semGetPath();
        Intrinsics.checkNotNull(strSemGetPath);
        return strSemGetPath;
    }
}

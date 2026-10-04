package com.samsung.android.support.senl.p145cm.base.framework.securefolder;

import android.content.Context;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p145cm.base.framework.sem.securefolder.SecureFolderCompatImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/securefolder/SecureFolderCompat;", "", "<init>", "()V", "moveFiles", "", "context", "Landroid/content/Context;", "srcPaths", "", "", "containerId", "", "isSupported", StateHandler.KEY_APP_STATE, "checker", "Lcom/samsung/android/support/senl/cm/base/framework/securefolder/SecureFolderCompat$SupportChecker;", "SupportChecker", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SecureFolderCompat {

    @NotNull
    public static final SecureFolderCompat INSTANCE = new SecureFolderCompat();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/securefolder/SecureFolderCompat$SupportChecker;", "", "onContainerTypeSupported", "", "containerId", "", "containerName", "", "onPersonalTypeSupported", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SupportChecker {
        void onContainerTypeSupported(int containerId, @Nullable String containerName);

        void onPersonalTypeSupported(int containerId, @Nullable String containerName);
    }

    private SecureFolderCompat() {
    }

    @JvmStatic
    public static final boolean isSupported(@Nullable Context appContext, @Nullable SupportChecker checker) {
        return SecureFolderCompatImpl.INSTANCE.isSupported(appContext, checker);
    }

    @JvmStatic
    public static final boolean moveFiles(@NotNull Context context, @NotNull List<String> srcPaths, int containerId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(srcPaths, "srcPaths");
        return SecureFolderCompatImpl.INSTANCE.moveFiles(context, srcPaths, containerId);
    }
}

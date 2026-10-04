package com.samsung.android.support.senl.p148nt.model.importer.task;

import android.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J:\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fH\u0016J*\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/importer/task/ImportTaskListener;", "", "onStart", "", "uuid", "", "path", "onSuccess", "srcPath", "destUuid", "destPath", "uuidPair", "Landroid/util/Pair;", "onFail", "errorCode", "", "message", "onUnsupportedVersionError", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportTaskListener {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static void onFail(@NotNull ImportTaskListener importTaskListener, @NotNull String uuid, @NotNull String path, int i, @Nullable String str) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(path, "path");
        }

        public static void onStart(@NotNull ImportTaskListener importTaskListener, @NotNull String uuid, @NotNull String path) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(path, "path");
        }

        public static void onSuccess(@NotNull ImportTaskListener importTaskListener, @NotNull String srcPath, @NotNull String destUuid, @NotNull String destPath, @Nullable Pair<String, String> pair) {
            Intrinsics.checkNotNullParameter(srcPath, "srcPath");
            Intrinsics.checkNotNullParameter(destUuid, "destUuid");
            Intrinsics.checkNotNullParameter(destPath, "destPath");
        }

        public static void onUnsupportedVersionError(@NotNull ImportTaskListener importTaskListener, @NotNull String uuid, @NotNull String path) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Intrinsics.checkNotNullParameter(path, "path");
        }
    }

    void onFail(@NotNull String uuid, @NotNull String path, int errorCode, @Nullable String message);

    void onStart(@NotNull String uuid, @NotNull String path);

    void onSuccess(@NotNull String srcPath, @NotNull String destUuid, @NotNull String destPath, @Nullable Pair<String, String> uuidPair);

    void onUnsupportedVersionError(@NotNull String uuid, @NotNull String path);
}

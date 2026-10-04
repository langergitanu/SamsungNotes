package com.samsung.android.support.senl.p148nt.app.addons;

import com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/IAddonsListener;", "", "onRequestOpenNote", "", "openOldComposer", "", "sdocUuid", "", "sdocxUuid", "path", "onStubUpdateTaskFinished", "onTaskCanceled", "lockHelper", "Lcom/samsung/android/support/senl/nt/app/lock/helper/ILockHelper;", "getLockHelper", "()Lcom/samsung/android/support/senl/nt/app/lock/helper/ILockHelper;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IAddonsListener {
    @NotNull
    ILockHelper getLockHelper();

    void onRequestOpenNote(boolean openOldComposer, @Nullable String sdocUuid, @Nullable String sdocxUuid, @Nullable String path);

    void onStubUpdateTaskFinished();

    void onTaskCanceled();
}

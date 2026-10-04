package com.samsung.android.support.senl.p148nt.base.common.jobscheduler;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/jobscheduler/JobTestLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LOG_FILE_NAME", "log", "", "content", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class JobTestLogger {

    @NotNull
    public static final JobTestLogger INSTANCE = new JobTestLogger();

    @NotNull
    private static final String LOG_FILE_NAME = "notes_JobScheduler.txt";

    @NotNull
    private static final String TAG = "JobTestLogger";

    private JobTestLogger() {
    }

    @JvmStatic
    public static final void log(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
    }
}

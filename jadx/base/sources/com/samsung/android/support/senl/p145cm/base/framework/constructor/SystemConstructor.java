package com.samsung.android.support.senl.p145cm.base.framework.constructor;

import android.app.job.JobInfo;
import android.content.ComponentName;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/constructor/SystemConstructor;", "", "<init>", "()V", "createJobInfoBuilder", "Landroid/app/job/JobInfo$Builder;", "id", "", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemConstructor {

    @NotNull
    public static final SystemConstructor INSTANCE = new SystemConstructor();

    private SystemConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final JobInfo.Builder createJobInfoBuilder(int id, @NotNull ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        return new JobInfo.Builder(id, componentName);
    }
}

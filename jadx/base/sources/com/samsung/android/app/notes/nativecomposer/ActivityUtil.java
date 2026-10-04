package com.samsung.android.app.notes.nativecomposer;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/notes/nativecomposer/ActivityUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "executePostLaunchManager", "", "makeIntentForComposer", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "needToCreateWithNewTask", "", "getOptionsForPopupWindow", "Landroid/os/Bundle;", "rect", "Landroid/os/Parcelable;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nActivityUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityUtil.kt\ncom/samsung/android/app/notes/nativecomposer/ActivityUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
public final class ActivityUtil {

    @NotNull
    public static final ActivityUtil INSTANCE = new ActivityUtil();

    @NotNull
    private static final String TAG = "NativeComposerActivityUtil";

    private ActivityUtil() {
    }

    private final boolean needToCreateWithNewTask(Context context, String className) {
        if (Build.VERSION.SDK_INT <= 29) {
            return true;
        }
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.AppTask> it = ((ActivityManager) systemService).getAppTasks().iterator();
        while (it.hasNext()) {
            ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
            if (taskInfo.baseActivity != null && taskInfo.topActivity != null) {
                ComponentName componentName = taskInfo.baseActivity;
                if (Intrinsics.areEqual(componentName != null ? componentName.getClassName() : null, className)) {
                    ComponentName componentName2 = taskInfo.topActivity;
                    if (Intrinsics.areEqual(componentName2 != null ? componentName2.getClassName() : null, className)) {
                        Logger.m8703w(TAG, "needToCreateWithNewTask false ");
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    public final void executePostLaunchManager() {
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
    }

    @Nullable
    public final Bundle getOptionsForPopupWindow(@Nullable Parcelable rect) {
        if (!(rect instanceof Rect)) {
            return null;
        }
        Logger.m8702i(TAG, "getOptionsForPopupWindow rect = " + rect);
        return ContextCompat.INSTANCE.getInstance().makeLaunchBoundOption((Rect) rect).toBundle();
    }

    public final void makeIntentForComposer(@NotNull Context context, @NotNull Intent intent, @NotNull String className) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(className, "className");
        intent.removeExtra("sdoc_uuid");
        Class<?> composerActivityClass = ComposerAccessHandler.getComposerActivityClass();
        if (composerActivityClass != null) {
            intent.setClass(context, composerActivityClass);
        }
        int flags = intent.getFlags();
        AbstractC4539a.m3203m(flags, "makeIntentForComposer flags: ", TAG);
        int i = (-16777217) & flags;
        if (needToCreateWithNewTask(context, className) || (268435456 & flags) != 0) {
            i |= 403177472;
        }
        intent.setFlags(i);
    }
}

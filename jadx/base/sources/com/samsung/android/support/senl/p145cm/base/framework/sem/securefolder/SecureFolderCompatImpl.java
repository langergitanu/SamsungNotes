package com.samsung.android.support.senl.p145cm.base.framework.sem.securefolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.samsung.android.knox.SemPersonaManager;
import com.samsung.android.knox.SemRemoteContentManager;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p145cm.base.framework.securefolder.SecureFolderCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u001c\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/securefolder/SecureFolderCompatImpl;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SAMSUNG_NOTES_SECURE_FOLDER_ID", "", "KEY_CONTAINER_TYPE", "KEY_CONTAINER_ID", "KEY_CONTAINER_NAME", "moveFiles", "", "context", "Landroid/content/Context;", "srcPaths", "", "containerId", "isSupported", StateHandler.KEY_APP_STATE, "checker", "Lcom/samsung/android/support/senl/cm/base/framework/securefolder/SecureFolderCompat$SupportChecker;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSecureFolderCompatImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SecureFolderCompatImpl.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/securefolder/SecureFolderCompatImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class SecureFolderCompatImpl {

    @NotNull
    public static final SecureFolderCompatImpl INSTANCE = new SecureFolderCompatImpl();

    @NotNull
    private static final String KEY_CONTAINER_ID = "com.sec.knox.moveto.containerId";

    @NotNull
    private static final String KEY_CONTAINER_NAME = "com.sec.knox.moveto.name";

    @NotNull
    private static final String KEY_CONTAINER_TYPE = "com.sec.knox.moveto.containerType";
    private static final int SAMSUNG_NOTES_SECURE_FOLDER_ID = 5;

    @NotNull
    private static final String TAG = "SecureFolderCompatImpl";

    private SecureFolderCompatImpl() {
    }

    @SuppressLint({"WrongConstant"})
    public final boolean isSupported(@Nullable Context appContext, @Nullable SecureFolderCompat.SupportChecker checker) {
        Object systemService;
        if (appContext != null) {
            try {
                systemService = appContext.getSystemService("persona");
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("isSupported, e:", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("isSupported, e:", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        } else {
            systemService = null;
        }
        SemPersonaManager semPersonaManager = systemService instanceof SemPersonaManager ? (SemPersonaManager) systemService : null;
        ArrayList moveToKnoxMenuList = semPersonaManager != null ? semPersonaManager.getMoveToKnoxMenuList(appContext) : null;
        if (moveToKnoxMenuList == null) {
            LoggerBase.INSTANCE.m7137i(TAG, "isSupported, not exist knox container!");
            return false;
        }
        Iterator it = moveToKnoxMenuList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            if (bundle == null) {
                LoggerBase.INSTANCE.m7137i(TAG, "isSupported, item is null");
            } else {
                int i = bundle.getInt(KEY_CONTAINER_TYPE);
                if (i == 1002) {
                    if (checker != null) {
                        checker.onContainerTypeSupported(bundle.getInt(KEY_CONTAINER_ID), bundle.getString(KEY_CONTAINER_NAME));
                    }
                    return true;
                }
                if (i == 1003) {
                    if (checker != null) {
                        checker.onPersonalTypeSupported(bundle.getInt(KEY_CONTAINER_ID), bundle.getString(KEY_CONTAINER_NAME));
                    }
                    return true;
                }
                LoggerBase.INSTANCE.m7137i(TAG, "isSupported, unknown type");
            }
        }
        return false;
    }

    @SuppressLint({"WrongConstant"})
    public final boolean moveFiles(@NotNull Context context, @NotNull List<String> srcPaths, int containerId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(srcPaths, "srcPaths");
        try {
            Object systemService = context.getSystemService("rcp");
            SemRemoteContentManager semRemoteContentManager = systemService instanceof SemRemoteContentManager ? (SemRemoteContentManager) systemService : null;
            if (semRemoteContentManager != null) {
                return semRemoteContentManager.moveFiles(5, srcPaths, srcPaths, containerId) == 0;
            }
            LoggerBase.INSTANCE.m7133e(TAG, "rcp service is null");
            return false;
        } catch (Exception e) {
            LoggerBase.INSTANCE.m7135f(TAG, "moveFiles, e: " + e.getMessage());
            return false;
        }
    }
}

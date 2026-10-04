package com.samsung.android.support.senl.p148nt.base.common.collect;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Process;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/collect/CollectTestLogger;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LOG_FILE_NAME", "PREF_NAME", "COLLECT_LOGGING_ENABLED", "checkCollectLoggingEnabled", "", "()Ljava/lang/Boolean;", "log", "", "content", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CollectTestLogger {

    @NotNull
    private static final String COLLECT_LOGGING_ENABLED = "CollectLoggingEnabled";

    @NotNull
    public static final CollectTestLogger INSTANCE = new CollectTestLogger();

    @NotNull
    private static final String LOG_FILE_NAME = "notes_Collect.txt";

    @NotNull
    private static final String PREF_NAME = "CollectLogging";

    @NotNull
    private static final String TAG = "CollectTestLogger";

    private CollectTestLogger() {
    }

    private final Boolean checkCollectLoggingEnabled() {
        Context applicationContext = BaseUtils.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext != null ? applicationContext.getSharedPreferences(PREF_NAME, 0) : null;
        if (sharedPreferences != null) {
            return Boolean.valueOf(sharedPreferences.getBoolean(COLLECT_LOGGING_ENABLED, false));
        }
        return null;
    }

    @JvmStatic
    public static final void log(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Boolean boolCheckCollectLoggingEnabled = INSTANCE.checkCollectLoggingEnabled();
        Intrinsics.checkNotNull(boolCheckCollectLoggingEnabled);
        if (!boolCheckCollectLoggingEnabled.booleanValue()) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + LOG_FILE_NAME, true);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
                try {
                    bufferedWriter.write(Calendar.getInstance().getTime() + " : " + content + " @ " + Process.myPid() + "\n");
                    bufferedWriter.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedWriter, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AbstractC0000a.m23t("error on test logging : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        }
    }
}

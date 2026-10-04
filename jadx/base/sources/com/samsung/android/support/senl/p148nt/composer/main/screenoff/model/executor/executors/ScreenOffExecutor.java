package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.SkipPreInitializeFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/ScreenOffExecutor;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AbsExecutor;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffExecutor extends AbsExecutor {

    @NotNull
    private static final String ACTIVITY_CLASS_NAME = "com.samsung.android.support.senl.nt.composer.main.screenoff.ScreenOffActivity";

    @NotNull
    private static final String ACTIVITY_CLASS_SIMPLE_NAME = "ScreenOffActivity";

    @NotNull
    private static final String SERVICE_CLASS_NAME = "com.samsung.android.app.notes.screenoffmemo.ScreenOffMemoService";

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffExecutor");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AbsExecutor
    public void execute(@Nullable Context context, @Nullable Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(Constants.StringExtraKey.EXECUTE_TYPE) : null;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        AbstractC8014b.m7208j("execute executeType ", stringExtra, sOLogger, str);
        if (Intrinsics.areEqual(stringExtra, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)) {
            if (context == null) {
                return;
            }
            intent.setClassName(context.getApplicationContext(), ACTIVITY_CLASS_NAME);
            intent.putExtra("category_id", PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
            intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, 0);
            intent.putExtra("tool_type", 2);
            intent.addFlags(402653184);
            intent.addFlags(65536);
            if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(context)) {
                context.startActivity(intent, ContextCompat.INSTANCE.getInstance().makeLaunchBoundOption(0, 0, 0, 0).toBundle());
                return;
            } else {
                context.startActivity(intent);
                return;
            }
        }
        if (Intrinsics.areEqual(stringExtra, "service")) {
            intent.setClassName("com.samsung.android.app.notes", SERVICE_CLASS_NAME);
            if (ServiceManager.INSTANCE.getInstance().canWorkOnBackground()) {
                ContextCompat.INSTANCE.getInstance().startServiceAsUser(context, intent);
                return;
            }
            SkipPreInitializeFeature skipPreInitializeFeature = SkipPreInitializeFeature.INSTANCE;
            if (skipPreInitializeFeature.needToSkipPreInitialize()) {
                boolean booleanExtra = intent.getBooleanExtra(Constants.BooleanExtraKey.PRE_INITIALIZED_COM, false);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.BooleanExtraKey.CONTROL_SERVICE, false);
                sOLogger.SOLoggerD(str, "execute# isPreInit/isControlService " + booleanExtra + "/" + booleanExtra2);
                if (booleanExtra2) {
                    sOLogger.SOLoggerD(str, "execute# skip");
                    return;
                }
                String screenOffActivityState = skipPreInitializeFeature.getScreenOffActivityState();
                boolean zIsActivityRunning = ApplicationManager.INSTANCE.getInstance().getActivityTracker().isActivityRunning(ACTIVITY_CLASS_SIMPLE_NAME);
                sOLogger.SOLoggerD(str, "execute# screenOffActivityState/isScreenOffRunning " + screenOffActivityState + "/" + zIsActivityRunning);
                if (!Intrinsics.areEqual(SkipPreInitializeFeature.STATE_CREATED, screenOffActivityState) || zIsActivityRunning) {
                    sOLogger.SOLoggerD(str, "execute# skip");
                    return;
                } else {
                    sOLogger.SOLoggerD(str, "execute# abnormal case!, need to call startForegroundService");
                    skipPreInitializeFeature.setScreenOffActivityState(SkipPreInitializeFeature.STATE_DESTROYED);
                }
            }
            if (context != null) {
                context.startForegroundService(intent);
            }
        }
    }
}

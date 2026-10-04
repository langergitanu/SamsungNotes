package com.samsung.android.app.notes.widget.lockbrief;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/lockbrief/WidgetCreatorLockBriefUnlockActivity;", "Lcom/samsung/android/support/senl/nt/base/widget/lockbrief/BaseWidgetLockBriefUnlockActivity;", "<init>", "()V", "startActivity", "", "startMemoListActivity", "startComposerActivity", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorLockBriefUnlockActivity extends BaseWidgetLockBriefUnlockActivity {

    @NotNull
    private static final String TAG = "WidgetCreatorLockBriefUnlockActivity";
    public static final int $stable = 8;

    private final void startComposerActivity() {
        Intent intent = new Intent(this, ComposerAccessHandler.getComposerActivityClass());
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        intent.putExtras(extras);
        intent.setAction(ComposerConstants.ACTION_WIDGET);
        intent.addFlags(276856832);
        startActivity(intent);
    }

    private final void startMemoListActivity() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(getPackageName());
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        if (listQueryIntentActivities.isEmpty()) {
            return;
        }
        ActivityInfo activityInfo = listQueryIntentActivities.get(0).activityInfo;
        Intent intent2 = new Intent();
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        intent2.setFlags(276856832);
        startActivity(intent2);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.lockbrief.BaseWidgetLockBriefUnlockActivity
    public void startActivity() {
        int intExtra = getIntent().getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        String action = getIntent().getAction();
        WidgetLogger.m5154d(TAG, "startActivity - widgetId : " + intExtra + ", action : " + action);
        if (Intrinsics.areEqual(action, WidgetCreatorLockBriefProvider.ACTION_LAUNCH_NOTES)) {
            startMemoListActivity();
        } else if (Intrinsics.areEqual(action, WidgetCreatorLockBriefProvider.ACTION_LAUNCH_COMPOSER_OTHER)) {
            startComposerActivity();
        }
        finish();
    }
}

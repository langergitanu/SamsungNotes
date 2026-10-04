package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/NotificationTaskMoveActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotificationTaskMoveActivity extends AppCompatActivity {

    @NotNull
    private static final String TAG;

    static {
        String strCreateTag = Logger.createTag("NotificationTaskMoveActivity");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Integer numFindTaskIdByNotification;
        super.onCreate(savedInstanceState);
        Logger.m11003i(TAG, "onCreate# NotificationTaskMoveActivity is called from notification.");
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_KEY, -1);
        Intent intent2 = new Intent(VoiceNotificationHelper.NOTIFICATION_INTENT_FILTER);
        intent2.setPackage(getPackageName());
        intent2.putExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_KEY, intExtra);
        getApplicationContext().sendBroadcast(intent2);
        if (intent.getBooleanExtra(ComposerConstants.ARG_COMPOSER_FROM_VOICE_NOTIFICATION, false)) {
            Integer numFindTaskIdByNotification2 = ComposerManager.INSTANCE.getInstance().findTaskIdByNotification(ComposerConstants.ARG_VOICE_NOTIFICATION_ON);
            if (numFindTaskIdByNotification2 != null) {
                AppTaskCompat.INSTANCE.getInstance().moveToFront(getApplicationContext(), numFindTaskIdByNotification2.intValue());
            }
        } else if (intent.getBooleanExtra(ComposerConstants.ARG_COMPOSER_FROM_TRANSLATION_NOTIFICATION, false) && (numFindTaskIdByNotification = ComposerManager.INSTANCE.getInstance().findTaskIdByNotification(ComposerConstants.ARG_TRANSLATION_NOTIFICATION_ON)) != null) {
            AppTaskCompat.INSTANCE.getInstance().moveToFront(getApplicationContext(), numFindTaskIdByNotification.intValue());
        }
        finishAndRemoveTask();
    }
}

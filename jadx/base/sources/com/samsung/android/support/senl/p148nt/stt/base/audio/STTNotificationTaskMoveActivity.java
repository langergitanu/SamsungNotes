package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/STTNotificationTaskMoveActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTNotificationTaskMoveActivity extends AppCompatActivity {

    @NotNull
    private static final String TAG = "STTNotificationTaskMoveActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.m12713i(TAG, "onCreate# STTNotificationTaskMoveActivity is called from notification.");
        Integer numFindTaskIdByNotification = ComposerManager.INSTANCE.getInstance().findTaskIdByNotification(STTConstant.ARG_FAST_CONVERT_NOTIFICATION_ON);
        AppTaskCompat companion = AppTaskCompat.INSTANCE.getInstance();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNull(numFindTaskIdByNotification);
        companion.moveToFront(applicationContext, numFindTaskIdByNotification.intValue());
        finishAndRemoveTask();
    }
}

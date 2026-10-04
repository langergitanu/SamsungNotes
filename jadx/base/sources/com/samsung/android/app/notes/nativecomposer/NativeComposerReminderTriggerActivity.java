package com.samsung.android.app.notes.nativecomposer;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/notes/nativecomposer/NativeComposerReminderTriggerActivity;", "Lcom/samsung/android/support/senl/nt/app/trigger/DocOpenTriggerActivity;", "<init>", "()V", "startComposerActivityByOption", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NativeComposerReminderTriggerActivity extends DocOpenTriggerActivity {

    @NotNull
    public static final String ARG_POS_RECT_POPUP = "app_pos_rect_popup";

    @Override // com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity
    public void startComposerActivityByOption(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle optionsForPopupWindow = ActivityUtil.INSTANCE.getOptionsForPopupWindow(getIntent().getParcelableExtra(ARG_POS_RECT_POPUP));
        if (optionsForPopupWindow != null) {
            startActivity(intent, optionsForPopupWindow);
        } else {
            startActivity(intent);
        }
    }
}

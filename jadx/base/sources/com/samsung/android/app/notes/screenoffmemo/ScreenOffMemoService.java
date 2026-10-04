package com.samsung.android.app.notes.screenoffmemo;

import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.ScreenOffService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/notes/screenoffmemo/ScreenOffMemoService;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffService;", "<init>", "()V", "onStartCommand", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "flags", "startId", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffMemoService extends ScreenOffService {

    @NotNull
    private static final String TAG = "ScreenOffMemoService";

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.ScreenOffService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        if (intent != null) {
            return super.onStartCommand(intent, flags, startId);
        }
        Logger.m8697d("ScreenOffMemoService", "onStartCommand, not enabled");
        return 2;
    }
}

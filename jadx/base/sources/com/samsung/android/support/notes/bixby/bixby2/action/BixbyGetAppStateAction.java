package com.samsung.android.support.notes.bixby.bixby2.action;

import android.os.Bundle;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyGetAppStateAction;", "Lcom/samsung/android/support/notes/bixby/bixby2/action/AbsBixbyAction;", ActionHandler.PARAMS, "Landroid/os/Bundle;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "<init>", "(Landroid/os/Bundle;Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;)V", "execute", "", "asyncParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyGetAppStateAction extends AbsBixbyAction {

    @NotNull
    private static final String TAG = "BixbyGetAppStateAction";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BixbyGetAppStateAction(@Nullable Bundle bundle, @NotNull ResponseCallback callback) {
        super(callback);
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void execute(@NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        Logger.m8697d(TAG, "execute()");
        BixbyActionNoteListController companion = BixbyActionNoteListController.INSTANCE.getInstance();
        if (companion != null) {
            companion.getAppState(asyncParam);
        }
    }
}

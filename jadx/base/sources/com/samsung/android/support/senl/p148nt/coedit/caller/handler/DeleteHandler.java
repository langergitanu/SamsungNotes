package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import java.util.List;
import java.util.concurrent.Executor;
import p070Q1.RunnableC0218a;
import p079T.InterfaceC0290h;
import p079T.RunnableC0285c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DeleteHandler {
    private static final String TAG = "DeleteHandler";
    private final Executor mDeleteExecutor = AbstractC4539a.m3201k("DeleteHandler_delete");

    public void requestDeleteItems(@NonNull Context context, @NonNull String str, @NonNull List<String> list, @Nullable InterfaceC0290h interfaceC0290h) {
        this.mDeleteExecutor.execute(new RunnableC0218a(context, str, list, interfaceC0290h, 15));
    }

    public void requestDeleteLocalNoteByPush(@NonNull String str, @Nullable DeleteCoeditNoteUseCase.ResultCallback resultCallback) {
        this.mDeleteExecutor.execute(new RunnableC0285c(str, resultCallback, 2));
    }
}

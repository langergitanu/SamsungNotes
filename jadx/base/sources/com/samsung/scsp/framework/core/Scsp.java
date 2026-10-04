package com.samsung.scsp.framework.core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.identity.ScspIdentityFactory;
import com.samsung.scsp.framework.core.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Scsp {
    private static final Object LOCK = new Object();
    private static final Logger logger = Logger.get("Scsp");

    private static void checkAppId(String str) throws ScspException {
        if (StringUtil.isEmpty(str)) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "AccountInfoSupplier is null or empty");
        }
    }

    private static void checkContext(Context context) throws ScspException {
        if (context == null) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, "The context is null");
        }
        ContextFactory.attachApplicationContext(context.getApplicationContext());
    }

    @WorkerThread
    public static String getToken() {
        return ScspIdentityFactory.getUserInstance().getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$signOut$0() {
        ScspIdentityFactory.getUserInstance().signOut();
    }

    @WorkerThread
    public static void refreshToken() {
        ScspIdentityFactory.getUserInstance().renewToken();
    }

    public static void setUp(@NonNull Context context, @NonNull String str) {
        setUp(context, str, null);
    }

    public static void signOut(Context context) {
        ContextFactory.attachApplicationContext(context);
        FaultBarrier.run(new C8416h(16));
    }

    public static void setUp(@NonNull Context context, @NonNull String str, @Nullable ScspSuppliers scspSuppliers) {
        logger.m12934i("setUp");
        synchronized (LOCK) {
            checkContext(context);
            checkAppId(str);
            SContext.initialize(str, scspSuppliers);
        }
    }
}

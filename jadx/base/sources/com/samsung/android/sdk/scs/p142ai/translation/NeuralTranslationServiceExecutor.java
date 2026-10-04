package com.samsung.android.sdk.scs.p142ai.translation;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.ConnectionHelper;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.INeuralTranslationService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"LogNotTimber"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
class NeuralTranslationServiceExecutor extends ServiceExecutor {
    private static final String TAG = "ScsApi@TranslationServiceExecutor";
    Context context;
    private final IBinder.DeathRecipient deathRecipient;
    private final boolean isPublic;
    INeuralTranslationService translationService;

    public NeuralTranslationServiceExecutor(Context context) {
        this(context, false);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return this.isPublic ? ConnectionHelper.getTranslationServiceIntentForExternal() : ConnectionHelper.getTranslationServiceIntent();
    }

    public INeuralTranslationService getTranslationService() {
        return this.translationService;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        try {
            INeuralTranslationService iNeuralTranslationServiceAsInterface = INeuralTranslationService.Stub.asInterface(iBinder);
            this.translationService = iNeuralTranslationServiceAsInterface;
            iNeuralTranslationServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.m6487e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.m6485d(TAG, "onServiceDisconnected " + componentName);
        this.translationService = null;
    }

    public NeuralTranslationServiceExecutor(Context context, boolean z) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.translation.NeuralTranslationServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.m6485d(NeuralTranslationServiceExecutor.TAG, "binderDied deathRecipient callback");
                INeuralTranslationService iNeuralTranslationService = NeuralTranslationServiceExecutor.this.translationService;
                if (iNeuralTranslationService != null) {
                    iNeuralTranslationService.asBinder().unlinkToDeath(NeuralTranslationServiceExecutor.this.deathRecipient, 0);
                }
            }
        };
        this.context = context.getApplicationContext();
        this.isPublic = z;
    }
}

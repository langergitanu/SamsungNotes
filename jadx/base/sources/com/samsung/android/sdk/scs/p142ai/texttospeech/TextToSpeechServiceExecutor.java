package com.samsung.android.sdk.scs.p142ai.texttospeech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.ConnectionHelper;
import com.samsung.android.sivs.p144ai.sdkcommon.tts.ITextToSpeechService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TextToSpeechServiceExecutor extends ServiceExecutor {
    private static final String TAG = "ScsApi@TTSServiceExecutor";
    private IBinder.DeathRecipient deathRecipient;
    private int mCallerId;
    private Context mContext;
    private ITextToSpeechService mTTSService;

    public TextToSpeechServiceExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.mContext = null;
        this.mCallerId = -1;
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.samsung.android.sdk.scs.ai.texttospeech.TextToSpeechServiceExecutor.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Log.d(TextToSpeechServiceExecutor.TAG, "binderDied deathRecipient callback");
                TextToSpeechServiceExecutor.this.mTTSService.asBinder().unlinkToDeath(TextToSpeechServiceExecutor.this.deathRecipient, 0);
            }
        };
        this.mContext = context.getApplicationContext();
        this.mCallerId = hashCode();
    }

    public int callerId() {
        return this.mCallerId;
    }

    public String callerName() {
        return this.mContext.getPackageName();
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    public Intent getServiceIntent() {
        return ConnectionHelper.getTextToSpeechServiceIntent();
    }

    public ITextToSpeechService getTTService() {
        return this.mTTSService;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(TAG, "onServiceConnected");
        ITextToSpeechService iTextToSpeechServiceAsInterface = ITextToSpeechService.Stub.asInterface(iBinder);
        this.mTTSService = iTextToSpeechServiceAsInterface;
        try {
            iTextToSpeechServiceAsInterface.asBinder().linkToDeath(this.deathRecipient, 0);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException");
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.d(TAG, "onServiceDisconnected " + componentName);
        this.mTTSService = null;
    }
}

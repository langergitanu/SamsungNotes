package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;
import com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import p004A2.RunnableC0015b;
import p122b2.RunnableC4198u;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuitySimpleMessageManagerImpl implements ContinuitySimpleMessageManager {
    private static final String TAG = "ContinuitySimpleMessageManagerImpl";

    @NonNull
    private final ContinuityCallbackManager mContinuityCallbackManager;

    @NonNull
    private final ContinuityCommandManager mContinuityCommandManager;

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySimpleMessageManagerImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72071 extends ContinuityMessageManager.MessageListener {
        public final /* synthetic */ ContinuityMessageManager.MessageListener val$messageListener;

        public C72071(ContinuityMessageManager.MessageListener messageListener) {
            this.val$messageListener = messageListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager.MessageListener
        public void onReceived(@NonNull String str, @NonNull byte[] bArr) {
            ExecutorUtil.executeOnCallback(new RunnableC4198u(this.val$messageListener, str, bArr, 1));
        }
    }

    public ContinuitySimpleMessageManagerImpl(@NonNull ContinuityCommandManager continuityCommandManager, @NonNull ContinuityCallbackManager continuityCallbackManager) {
        this.mContinuityCommandManager = continuityCommandManager;
        this.mContinuityCallbackManager = continuityCallbackManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerMessageListener$0(ContinuityMessageManager.MessageListener messageListener) {
        this.mContinuityCallbackManager.setSimpleMessageListener(new C72071(messageListener));
        if (this.mContinuityCommandManager.sendRegisterSimpleMessageListenerCommand()) {
            return;
        }
        DLog.m5611w(TAG, "registerMessageListener", "fail sendRegisterMessageListenerCommand");
        this.mContinuityCallbackManager.setSimpleMessageListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unregisterMessageListener$1() {
        this.mContinuityCallbackManager.setSimpleMessageListener(null);
        this.mContinuityCommandManager.sendUnregisterSimpleMessageListenerCommand();
    }

    @MainThread
    public void destroy() {
        this.mContinuityCallbackManager.setSimpleMessageListener(null);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager
    @Nullable
    public String getMessageIntentAction() {
        DLog.m5610i(TAG, "getMessageIntentAction", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuityCommandManager.getMessageIntentAction();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager
    public boolean registerMessageIntentListener(@NonNull String str, @NonNull String str2) {
        DLog.m5610i(TAG, "registerMessageIntentListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuityCommandManager.sendRegisterMessageIntentListenerCommand(str, str2);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager
    public boolean registerMessageListener(@NonNull ContinuityMessageManager.MessageListener messageListener) {
        DLog.m5610i(TAG, "registerMessageListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC4199v(this, messageListener, 1));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager
    public boolean sendMessage(@NonNull String str, @NonNull byte[] bArr) {
        DLog.m5610i(TAG, "sendMessage", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuityCommandManager.sendSimpleMessageCommand(str, bArr);
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager
    public void unregisterMessageIntentListener() {
        DLog.m5610i(TAG, "unregisterMessageIntentListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        this.mContinuityCommandManager.sendUnregisterMessageIntentListenerCommand();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityMessageManager
    public void unregisterMessageListener() {
        DLog.m5610i(TAG, "unregisterMessageListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        ExecutorUtil.executeOnMain(new RunnableC0015b(this, 28));
    }
}

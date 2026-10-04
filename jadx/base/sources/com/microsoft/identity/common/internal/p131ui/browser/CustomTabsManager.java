package com.microsoft.identity.common.internal.p131ui.browser;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.logging.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CustomTabsManager {
    private static final long CUSTOM_TABS_MAX_CONNECTION_TIMEOUT = 1;
    private static final String TAG = "CustomTabsManager";
    private final WeakReference<Context> mContextRef;
    private CustomTabsIntent mCustomTabsIntent;
    private boolean mCustomTabsServiceIsBound;
    private CustomTabsServiceConnection mCustomTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.microsoft.identity.common.internal.ui.browser.CustomTabsManager.1
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            String str = CustomTabsManager.TAG + ":onBindingDied";
            StringBuilder sb = new StringBuilder("Binding died callback on custom tabs service, there will likely be failures.  Component class that failed: ");
            sb.append(componentName == null ? "null" : componentName.getClassName());
            Logger.warn(str, sb.toString());
            super.onBindingDied(componentName);
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            Logger.info(CustomTabsManager.TAG + ":onCustomTabsServiceConnection", "CustomTabsService is connected");
            customTabsClient.warmup(0L);
            CustomTabsManager.this.mCustomTabsServiceIsBound = true;
            CustomTabsManager.this.mCustomTabsClient.set(customTabsClient);
            CustomTabsManager.this.mClientLatch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            String str = CustomTabsManager.TAG + ":onNullBinding";
            StringBuilder sb = new StringBuilder("Null binding callback on custom tabs service, there will likely be failures. Component class that failed: ");
            sb.append(componentName == null ? "null" : componentName.getClassName());
            Logger.warn(str, sb.toString());
            super.onNullBinding(componentName);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.info(CustomTabsManager.TAG + ":onServiceDisconnected", "CustomTabsService is disconnected");
            CustomTabsManager.this.mCustomTabsServiceIsBound = false;
            CustomTabsManager.this.mCustomTabsClient.set(null);
            CustomTabsManager.this.mClientLatch.countDown();
        }
    };
    private final AtomicReference<CustomTabsClient> mCustomTabsClient = new AtomicReference<>();
    private final CountDownLatch mClientLatch = new CountDownLatch(1);

    public CustomTabsManager(@NonNull Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    private CustomTabsSession createSession(@Nullable CustomTabsCallback customTabsCallback) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":createSession", new StringBuilder());
        CustomTabsClient client = getClient();
        if (client == null) {
            Logger.warn(strM1170p, "Failed to create custom tabs session with null CustomTabClient.");
            return null;
        }
        CustomTabsSession customTabsSessionNewSession = client.newSession(customTabsCallback);
        if (customTabsSessionNewSession == null) {
            Logger.warn(strM1170p, "Failed to create custom tabs session through custom tabs client.");
        }
        return customTabsSessionNewSession;
    }

    public synchronized boolean bind(@Nullable Context context, @NonNull String str) {
        String str2 = TAG + ":bind";
        if (context != null && CustomTabsClient.bindCustomTabsService(context, str, this.mCustomTabsServiceConnection)) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder(createSession(null)).setShowTitle(true).build();
            this.mCustomTabsIntent = customTabsIntentBuild;
            customTabsIntentBuild.intent.setPackage(str);
            return true;
        }
        Logger.info(str2, "Unable to bind custom tabs service ".concat(context == null ? "because the context was null" : "because the bind call failed"));
        this.mClientLatch.countDown();
        return false;
    }

    public CustomTabsClient getClient() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getClient", new StringBuilder());
        try {
            this.mClientLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Logger.info(strM1170p, "Interrupted while waiting for browser connection");
            this.mClientLatch.countDown();
        }
        return this.mCustomTabsClient.get();
    }

    public CustomTabsIntent getCustomTabsIntent() {
        return this.mCustomTabsIntent;
    }

    public synchronized void unbind() {
        String str = TAG + ":unbind";
        Context context = this.mContextRef.get();
        if (context == null || !this.mCustomTabsServiceIsBound) {
            this.mCustomTabsServiceIsBound = false;
            this.mCustomTabsClient.set(null);
            Logger.info(str, "CustomTabsService is unbound.");
        } else {
            try {
                context.unbindService(this.mCustomTabsServiceConnection);
            } catch (Exception e) {
                Logger.warn(str, "Error unbinding custom tabs service, likely failed to bind or previously died: " + e.getMessage());
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
            this.mCustomTabsServiceIsBound = false;
            this.mCustomTabsClient.set(null);
            Logger.info(str, "CustomTabsService is unbound.");
        }
    }
}

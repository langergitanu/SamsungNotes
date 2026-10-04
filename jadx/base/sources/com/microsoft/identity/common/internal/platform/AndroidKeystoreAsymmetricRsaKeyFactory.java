package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidKeystoreAsymmetricRsaKeyFactory implements AsymmetricRsaKeyFactory {
    private final Context mContext;

    public AndroidKeystoreAsymmetricRsaKeyFactory(@NonNull Context context) {
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    public synchronized boolean clearAsymmetricKey(@NonNull String str) {
        return AndroidPlatformComponentsFactory.createFromContext(this.mContext).getDevicePopManager(str).clearAsymmetricKey();
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKeyFactory, com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    public synchronized AsymmetricRsaKey generateAsymmetricKey(@NonNull String str) {
        return new AndroidKeystoreAsymmetricRsaKey(AndroidPlatformComponentsFactory.createFromContext(this.mContext).getDevicePopManager(str), str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKeyFactory, com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    public synchronized AsymmetricRsaKey loadAsymmetricKey(@NonNull String str) {
        return generateAsymmetricKey(str);
    }
}

package com.microsoft.identity.common.components;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.internal.platform.AndroidDevicePopManager;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPopManagerSupplier;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidPopManagerSupplier implements IPopManagerSupplier {

    @NonNull
    private final Context mContext;

    public AndroidPopManagerSupplier(@NonNull Context context) {
        if (context == null) {
            throw new NullPointerException("mContext is marked non-null but is null");
        }
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPopManagerSupplier
    @NonNull
    public IDevicePopManager getDevicePopManager(@Nullable String str) throws ClientException {
        String str2;
        try {
            return str == null ? new AndroidDevicePopManager(this.mContext) : new AndroidDevicePopManager(this.mContext, str);
        } catch (IOException e) {
            e = e;
            str2 = "io_error";
            throw new ClientException(str2, AbstractC2322a.m1619i(e, new StringBuilder("Failed to initialize DevicePoPManager = ")), e);
        } catch (KeyStoreException e2) {
            e = e2;
            str2 = ClientException.KEYSTORE_NOT_INITIALIZED;
            throw new ClientException(str2, AbstractC2322a.m1619i(e, new StringBuilder("Failed to initialize DevicePoPManager = ")), e);
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str2 = "no_such_algorithm";
            throw new ClientException(str2, AbstractC2322a.m1619i(e, new StringBuilder("Failed to initialize DevicePoPManager = ")), e);
        } catch (CertificateException e5) {
            e = e5;
            str2 = ClientException.CERTIFICATE_LOAD_FAILURE;
            throw new ClientException(str2, AbstractC2322a.m1619i(e, new StringBuilder("Failed to initialize DevicePoPManager = ")), e);
        }
    }
}

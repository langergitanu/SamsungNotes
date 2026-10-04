package com.yubico.yubikit.core.application;

import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationSession;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ApplicationSession<T extends ApplicationSession<T>> implements Closeable {
    public abstract Version getVersion();

    public void require(Feature<T> feature) {
        if (!supports(feature)) {
            throw new UnsupportedOperationException(feature.getRequiredMessage());
        }
    }

    public boolean supports(Feature<T> feature) {
        return feature.isSupportedBy(getVersion());
    }
}

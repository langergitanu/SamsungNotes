package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Keep
public class CctBackendFactory implements BackendFactory {
    @Override // com.google.android.datatransport.runtime.backends.BackendFactory
    public TransportBackend create(CreationContext creationContext) {
        return new CctTransportBackend(creationContext.getApplicationContext(), creationContext.getWallClock(), creationContext.getMonotonicClock());
    }
}

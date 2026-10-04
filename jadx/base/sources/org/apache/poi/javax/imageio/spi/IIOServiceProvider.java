package org.apache.poi.javax.imageio.spi;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IIOServiceProvider implements RegisterableService {
    protected String vendorName;
    protected String version;

    public IIOServiceProvider(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("vendorName == null!");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("version == null!");
        }
        this.vendorName = str;
        this.version = str2;
    }

    public abstract String getDescription(Locale locale);

    public String getVendorName() {
        return this.vendorName;
    }

    public String getVersion() {
        return this.version;
    }

    public IIOServiceProvider() {
    }

    @Override // org.apache.poi.javax.imageio.spi.RegisterableService
    public void onDeregistration(ServiceRegistry serviceRegistry, Class<?> cls) {
    }

    @Override // org.apache.poi.javax.imageio.spi.RegisterableService
    public void onRegistration(ServiceRegistry serviceRegistry, Class<?> cls) {
    }
}

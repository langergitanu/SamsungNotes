package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeviceId {
    /* JADX WARN: Multi-variable type inference failed */
    private String generateStrongDeviceIDHash(String str) {
        return (String) FaultBarrier.get(new C11658c(this, str, 7), null).obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$generateStrongDeviceIDHash$0(String str) {
        return toHex(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), "LINDOR".getBytes(StandardCharsets.UTF_8), 30, 128)).getEncoded());
    }

    private String toHex(byte[] bArr) {
        String string = new BigInteger(1, bArr).toString(16);
        int length = (bArr.length * 2) - string.length();
        if (length <= 0) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return ((Object) sb) + string;
    }

    public String getClientDeviceId() {
        String strGenerateStrongDeviceIDHash = ScspCorePreferences.get().cdid.get();
        if (StringUtil.isEmpty(strGenerateStrongDeviceIDHash)) {
            strGenerateStrongDeviceIDHash = generateStrongDeviceIDHash(DeviceUtil.getAndroidId(ContextFactory.getApplicationContext()));
            if (!StringUtil.isEmpty(strGenerateStrongDeviceIDHash)) {
                ScspCorePreferences.get().cdid.accept(strGenerateStrongDeviceIDHash);
            }
        }
        return strGenerateStrongDeviceIDHash;
    }

    public String getPhysicalDeviceId(DeviceIdSupplier deviceIdSupplier) {
        String str = ScspCorePreferences.get().pdid.get();
        if (!StringUtil.isEmpty(str)) {
            return str;
        }
        String strGenerateStrongDeviceIDHash = generateStrongDeviceIDHash(DeviceUtil.getDeviceUniqueId(ContextFactory.getApplicationContext(), deviceIdSupplier));
        if (!StringUtil.isEmpty(strGenerateStrongDeviceIDHash)) {
            ScspCorePreferences.get().pdid.accept(strGenerateStrongDeviceIDHash);
        }
        return strGenerateStrongDeviceIDHash;
    }

    public String getSsdid() {
        String ssdid = ScspDevicePreferences.get().ssdid.get();
        if (StringUtil.isEmpty(ssdid)) {
            ssdid = DeviceUtil.getSsdid(ContextFactory.getApplicationContext());
            if (!StringUtil.isEmpty(ssdid)) {
                ScspDevicePreferences.get().ssdid.accept(ssdid);
            }
        }
        return ssdid;
    }
}

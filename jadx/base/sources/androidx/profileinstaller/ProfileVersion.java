package androidx.profileinstaller;

import androidx.annotation.RestrictTo;
import com.yubico.yubikit.core.fido.CtapException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ProfileVersion {
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V015_S = {48, 49, CtapException.ERR_PIN_NOT_SET, 0};
    static final byte[] V010_P = {48, 49, 48, 0};
    static final byte[] V009_O_MR1 = {48, 48, CtapException.ERR_REQUEST_TOO_LARGE, 0};
    static final byte[] V005_O = {48, 48, CtapException.ERR_PIN_NOT_SET, 0};
    static final byte[] V001_N = {48, 48, 49, 0};
    static final byte[] METADATA_V001_N = {48, 48, 49, 0};
    static final byte[] METADATA_V002 = {48, 48, CtapException.ERR_PIN_BLOCKED, 0};

    private ProfileVersion() {
    }

    public static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? ":" : "!";
    }
}

package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface MathVariantMaps {
    public static final MathVariantMap SCRIPT = new MathVariantMap(StringLookupFactory.KEY_SCRIPT, new char[]{'B', 8492, 'E', 8496, 'F', 8497, 'H', 8459, 'I', 8464, 'L', 8466, 'M', 8499, 'R', 8475, 'e', 8495, DeviceInfoUtil.FLAVOR_TYPE_G, 8458, 'o', 8500});
    public static final MathVariantMap DOUBLE_STRUCK = new MathVariantMap("double-struck", new char[]{'C', 8450, 'H', 8461, 'N', 8469, 'P', 8473, 'Q', 8474, 'R', 8477, 'Z', 8484});
    public static final MathVariantMap FRAKTUR = new MathVariantMap("fraktur", new char[]{'C', 8493, 'H', 8460, 'I', 8465, 'R', 8476, 'Z', 8488, 'R', 8475, 'e', 8495, DeviceInfoUtil.FLAVOR_TYPE_G, 8458, 'o', 8500});
}

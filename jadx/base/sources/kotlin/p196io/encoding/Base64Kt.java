package kotlin.p196io.encoding;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0005¨\u0006\r"}, m13886d2 = {"base64EncodeMap", "", "base64DecodeMap", "", "getBase64DecodeMap$annotations", "()V", "base64UrlEncodeMap", "base64UrlDecodeMap", "getBase64UrlDecodeMap$annotations", "isInMimeAlphabet", "", "symbol", "", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,826:1\n13547#2,3:827\n13547#2,3:830\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n762#1:827,3\n779#1:830,3\n*E\n"})
public final class Base64Kt {

    @NotNull
    private static final int[] base64DecodeMap;

    @NotNull
    private static final byte[] base64EncodeMap;

    @NotNull
    private static final int[] base64UrlDecodeMap;

    @NotNull
    private static final byte[] base64UrlEncodeMap;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 43, 47};
        base64EncodeMap = bArr;
        int[] iArr = new int[256];
        int i = 0;
        ArraysKt___ArraysJvmKt.fill$default(iArr, -1, 0, 0, 6, (Object) null);
        iArr[61] = -2;
        int i2 = 0;
        int i4 = 0;
        while (i2 < 64) {
            iArr[bArr[i2]] = i4;
            i2++;
            i4++;
        }
        base64DecodeMap = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 45, 95};
        base64UrlEncodeMap = bArr2;
        int[] iArr2 = new int[256];
        ArraysKt___ArraysJvmKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
        iArr2[61] = -2;
        int i5 = 0;
        while (i < 64) {
            iArr2[bArr2[i]] = i5;
            i++;
            i5++;
        }
        base64UrlDecodeMap = iArr2;
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    public static final boolean isInMimeAlphabet(int i) {
        if (i < 0) {
            return false;
        }
        int[] iArr = base64DecodeMap;
        return i < iArr.length && iArr[i] != -1;
    }

    @ExperimentalEncodingApi
    private static /* synthetic */ void getBase64DecodeMap$annotations() {
    }

    @ExperimentalEncodingApi
    private static /* synthetic */ void getBase64UrlDecodeMap$annotations() {
    }
}

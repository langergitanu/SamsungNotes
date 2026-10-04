package p194k0;

import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.yubico.yubikit.core.fido.CtapException;
import java.nio.ByteBuffer;
import okio.Utf8;
import p185h0.InterfaceC12017b;
import p186h1.C12020a;

/* JADX INFO: renamed from: k0.x */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12966x implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f9296a;

    /* JADX INFO: renamed from: a */
    public final int m13870a(C12020a c12020a, int i) {
        int i2 = ((ByteBuffer) c12020a.f8772b).getShort(i);
        int i4 = i + 2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (i2 <= 0) {
                break;
            }
            int i5 = i4 + 1;
            byte b = ((ByteBuffer) c12020a.f8772b).get(i4);
            int i6 = i2 - 1;
            if (b == 0) {
                i4 = i5;
                i2 = i6;
                break;
            }
            if ((b & 128) != 0) {
                int i7 = i4 + 2;
                byte b5 = ((ByteBuffer) c12020a.f8772b).get(i5);
                int i8 = i2 - 2;
                if ((b & CtapException.ERR_EXTENSION_FIRST) != 192) {
                    int i9 = i4 + 3;
                    byte b6 = ((ByteBuffer) c12020a.f8772b).get(i7);
                    int i10 = i2 - 3;
                    if ((b & CtapException.ERR_VENDOR_FIRST) != 224) {
                        int i11 = i4 + 4;
                        byte b7 = ((ByteBuffer) c12020a.f8772b).get(i9);
                        int i12 = i2 - 4;
                        if ((b & 248) != 240) {
                            i5 = i4 + 5;
                            c12020a.m13636i(i11);
                            i6 = i2 - 5;
                            if ((b & 252) != 248) {
                                i4 += 6;
                                c12020a.m13636i(i5);
                                i2 -= 6;
                                if ((b & 254) != 252) {
                                    break;
                                }
                                sb.append((char) 9633);
                            } else {
                                sb.append((char) 9633);
                            }
                        } else {
                            int i13 = ((b & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 12) | ((b6 & Utf8.REPLACEMENT_BYTE) << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
                            int i14 = ((64512 & i13) >> 10) | 55296;
                            int i15 = (i13 & 1023) | Utf8.LOG_SURROGATE_HEADER;
                            sb.append((char) i14);
                            sb.append((char) i15);
                            i4 = i11;
                            i2 = i12;
                        }
                    } else {
                        sb.append((char) (((b & 15) << 12) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE)));
                        i4 = i9;
                        i2 = i10;
                    }
                } else {
                    sb.append((char) (((b & 31) << 6) | (b5 & Utf8.REPLACEMENT_BYTE)));
                    i4 = i7;
                    i2 = i8;
                }
            } else {
                sb.append((char) b);
            }
            i4 = i5;
            i2 = i6;
        }
        if (i2 > 0) {
            i4 += i2;
        }
        String string = sb.toString();
        this.f9296a = string;
        if (string.length() > 36) {
            this.f9296a = this.f9296a.substring(0, 36);
        }
        return i4 - i;
    }

    /* JADX INFO: renamed from: b */
    public final int m13871b(C12020a c12020a, int i) {
        String str = this.f9296a;
        if (str == null || str.isEmpty()) {
            throw new IllegalStateException("object uuid is invalid");
        }
        c12020a.m13647t(i, 36);
        int i2 = i + 2;
        int i4 = 0;
        for (char c : this.f9296a.toCharArray()) {
            if (c == 0) {
                break;
            }
            if (c <= 127) {
                c12020a.m13646s(i2, c);
                i4++;
                i2++;
            } else if (c <= 2047) {
                int i5 = i2 + 1;
                c12020a.m13646s(i2, ((c & 1984) >> 6) | 192);
                i2 += 2;
                c12020a.m13646s(i5, (c & '?') | 128);
                i4 += 2;
            } else {
                c12020a.m13646s(i2, ((61440 & c) >> 12) | JPEG.APP0);
                int i6 = i2 + 2;
                c12020a.m13646s(i2 + 1, ((c & 4032) >> 6) | 128);
                i2 += 3;
                c12020a.m13646s(i6, (c & '?') | 128);
                i4 += 3;
            }
        }
        while (i4 < 36) {
            c12020a.m13646s(i2, 0);
            i4++;
            i2++;
        }
        return i2 - i;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12966x)) {
            return false;
        }
        C12966x c12966x = (C12966x) obj;
        if (TextUtils.equals(this.f9296a, c12966x.f9296a)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(" !! equals() - NE - mUuid[");
        sb.append(this.f9296a);
        sb.append(" - ");
        AbstractC4539a.m3209s(sb, c12966x.f9296a, "]", "WCon_ObjectUuid");
        return false;
    }
}

package org.apache.poi.poifs.filesystem;

import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum FileMagic {
    OLE2(-2226271756974174256L),
    OOXML(POIFSConstants.OOXML_FILE_HEADER),
    XML(POIFSConstants.RAW_XML_FILE_HEADER),
    BIFF2(new byte[]{9, 0, 4, 0, 0, 0, SprAttributeBase.TYPE_SHADOW, 0}),
    BIFF3(new byte[]{9, 2, 6, 0, 0, 0, SprAttributeBase.TYPE_SHADOW, 0}),
    BIFF4(new byte[]{9, 4, 6, 0, 0, 0, SprAttributeBase.TYPE_SHADOW, 0}, new byte[]{9, 4, 6, 0, 0, 0, 0, 1}),
    MSWRITE(new byte[]{49, -66, 0, 0}, new byte[]{CtapException.ERR_PIN_BLOCKED, -66, 0, 0}),
    RTF("{\\rtf"),
    PDF("%PDF"),
    UNKNOWN(new byte[0]);

    final byte[][] magic;

    FileMagic(long j) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, 8);
        this.magic = bArr;
        LittleEndian.putLong(bArr[0], 0, j);
    }

    public static InputStream prepareToCheckMagic(InputStream inputStream) {
        return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
    }

    public static FileMagic valueOf(byte[] bArr) {
        for (FileMagic fileMagic : values()) {
            boolean z = true;
            int i = 0;
            for (byte[] bArr2 : fileMagic.magic) {
                int length = bArr2.length;
                int i2 = 0;
                while (i2 < length) {
                    byte b = bArr2[i2];
                    int i4 = i + 1;
                    byte b5 = bArr[i];
                    if (b5 != b && (b != 112 || (b5 != 16 && b5 != 32 && b5 != 64))) {
                        z = false;
                        i = i4;
                        break;
                    }
                    i2++;
                    i = i4;
                }
                if (z) {
                    return fileMagic;
                }
            }
        }
        return UNKNOWN;
    }

    FileMagic(byte[]... bArr) {
        this.magic = bArr;
    }

    FileMagic(String str) {
        this(str.getBytes(LocaleUtil.CHARSET_1252));
    }

    public static FileMagic valueOf(InputStream inputStream) throws IOException {
        if (inputStream.markSupported()) {
            return valueOf(IOUtils.peekFirst8Bytes(inputStream));
        }
        throw new IOException("getFileMagic() only operates on streams which support mark(int)");
    }
}

package p042J1;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: renamed from: J1.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0156n {

    /* JADX INFO: renamed from: a */
    public static String f479a;

    /* JADX INFO: renamed from: a */
    public static void m405a(File file) throws IOException {
        if (file.exists() || file.mkdirs()) {
            return;
        }
        throw new IOException("fail to make directory " + file.getPath());
    }

    /* JADX INFO: renamed from: b */
    public static void m406b(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        if (file.isDirectory()) {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = AbstractC0541b.m756B(str, str2);
            }
            zipOutputStream.putNextEntry(new ZipEntry(str));
            zipOutputStream.closeEntry();
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                    sbM1324q.append(file2.getName());
                    m406b(file2, sbM1324q.toString(), zipOutputStream);
                }
                return;
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ZipEntry zipEntry = new ZipEntry(str);
            zipEntry.setTime(file.lastModified());
            String strSubstring = str.substring(str.lastIndexOf(46) + 1, str.length());
            if ("mp4".equals(strSubstring) || "mp3".equals(strSubstring) || "zip".equals(strSubstring) || "jpg".equals(strSubstring) || "spd".equals(strSubstring) || Constants.VOICE_EXTENSION.equals(strSubstring)) {
                zipEntry.setMethod(0);
                zipEntry.setCompressedSize(file.length());
                zipEntry.setSize(file.length());
                CRC32 crc32 = new CRC32();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i = bufferedInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            crc32.update(bArr, 0, i);
                        }
                    }
                    bufferedInputStream.close();
                    zipEntry.setCrc(crc32.getValue());
                } finally {
                }
            }
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr2 = new byte[10240];
            while (true) {
                int i2 = fileInputStream.read(bArr2);
                if (i2 < 0) {
                    fileInputStream.close();
                    return;
                }
                zipOutputStream.write(bArr2, 0, i2);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

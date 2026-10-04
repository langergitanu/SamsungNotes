package org.apache.poi.p226sl.usermodel;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SlideShowFactory {

    /* JADX INFO: renamed from: org.apache.poi.sl.usermodel.SlideShowFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140721 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.OLE2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static SlideShow<?, ?> create(NPOIFSFileSystem nPOIFSFileSystem) {
        return create(nPOIFSFileSystem, (String) null);
    }

    public static SlideShow<?, ?> createHSLFSlideShow(Object... objArr) {
        return createSlideShow("org.apache.poi.hslf.usermodel.HSLFSlideShowFactory", objArr);
    }

    public static SlideShow<?, ?> createSlideShow(String str, Object[] objArr) throws IOException {
        try {
            Class<?> clsLoadClass = Thread.currentThread().getContextClassLoader().loadClass(str);
            Class<?>[] clsArr = new Class[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Class<?> cls = objArr[i].getClass();
                if (Boolean.class.isAssignableFrom(cls)) {
                    cls = Boolean.TYPE;
                } else if (InputStream.class.isAssignableFrom(cls)) {
                    cls = InputStream.class;
                }
                clsArr[i2] = cls;
                i++;
                i2++;
            }
            return (SlideShow) clsLoadClass.getMethod("createSlideShow", clsArr).invoke(null, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            throw new IOException(cause);
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    public static SlideShow<?, ?> createXSLFSlideShow(Object... objArr) {
        return createSlideShow("org.apache.poi.xslf.usermodel.XSLFSlideShowFactory", objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SlideShow<?, ?> create(NPOIFSFileSystem nPOIFSFileSystem, String str) {
        boolean z;
        InputStream decryptedStream = null;
        Object[] objArr = 0;
        if (nPOIFSFileSystem.getRoot().hasEntry("EncryptedPackage")) {
            try {
                decryptedStream = DocumentFactoryHelper.getDecryptedStream(nPOIFSFileSystem, str);
                return createXSLFSlideShow(decryptedStream);
            } finally {
                IOUtils.closeQuietly(decryptedStream);
            }
        }
        if (str != null) {
            Biff8EncryptionKey.setCurrentUserPassword(str);
            z = true;
        } else {
            z = false;
        }
        try {
            return createHSLFSlideShow(nPOIFSFileSystem);
        } finally {
            if (z) {
                Biff8EncryptionKey.setCurrentUserPassword((String) null);
            }
        }
    }

    public static SlideShow<?, ?> create(InputStream inputStream) {
        return create(inputStream, (String) null);
    }

    public static SlideShow<?, ?> create(InputStream inputStream, String str) throws IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        int i = C140721.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.valueOf(inputStreamPrepareToCheckMagic).ordinal()];
        if (i == 1) {
            return create(new NPOIFSFileSystem(inputStreamPrepareToCheckMagic), str);
        }
        if (i == 2) {
            return createXSLFSlideShow(inputStreamPrepareToCheckMagic);
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

    public static SlideShow<?, ?> create(File file) {
        return create(file, (String) null);
    }

    public static SlideShow<?, ?> create(File file, String str) {
        return create(file, str, false);
    }

    public static SlideShow<?, ?> create(File file, String str, boolean z) throws FileNotFoundException {
        Closeable nPOIFSFileSystem;
        if (file.exists()) {
            Closeable closeable = null;
            try {
                nPOIFSFileSystem = new NPOIFSFileSystem(file, z);
            } catch (OfficeXmlFileException unused) {
            } catch (RuntimeException e) {
                e = e;
            }
            try {
                return create((NPOIFSFileSystem) nPOIFSFileSystem, str);
            } catch (RuntimeException e2) {
                e = e2;
                closeable = nPOIFSFileSystem;
                IOUtils.closeQuietly(closeable);
                throw e;
            } catch (OfficeXmlFileException unused2) {
                closeable = nPOIFSFileSystem;
                IOUtils.closeQuietly(closeable);
                return createXSLFSlideShow(file, Boolean.valueOf(z));
            }
        }
        throw new FileNotFoundException(file.toString());
    }
}

package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.poi.UnsupportedFileFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public final class ZipHelper {
    private static final String FORWARD_SLASH = "/";

    @Removal(version = "3.18")
    @Deprecated
    public static final int READ_WRITE_FILE_BUFFER_SIZE = 8192;

    /* JADX INFO: renamed from: org.apache.poi.openxml4j.opc.internal.ZipHelper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140611 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.OLE2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private ZipHelper() {
    }

    public static ZipEntry getContentTypeZipEntry(ZipPackage zipPackage) {
        Enumeration<? extends ZipEntry> entries = zipPackage.getZipArchive().getEntries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = entries.nextElement();
            if (zipEntryNextElement.getName().equals(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                return zipEntryNextElement;
            }
        }
        return null;
    }

    public static ZipEntry getCorePropertiesZipEntry(ZipPackage zipPackage) {
        PackageRelationship relationship = zipPackage.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").getRelationship(0);
        if (relationship == null) {
            return null;
        }
        return new ZipEntry(relationship.getTargetURI().getPath());
    }

    public static String getOPCNameFromZipItemName(String str) {
        if (str != null) {
            return str.startsWith("/") ? str : "/".concat(str);
        }
        throw new IllegalArgumentException("zipItemName cannot be null");
    }

    public static String getZipItemNameFromOPCName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName cannot be null");
        }
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        return str;
    }

    public static URI getZipURIFromOPCName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName");
        }
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static ZipFile openZipFile(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            verifyZipHeader(fileInputStream);
            fileInputStream.close();
            return new ZipSecureFile(file);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public static ZipSecureFile.ThresholdInputStream openZipStream(InputStream inputStream) {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        verifyZipHeader(inputStreamPrepareToCheckMagic);
        return ZipSecureFile.addThreshold(new ZipInputStream(inputStreamPrepareToCheckMagic));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.UnsupportedFileFormatException */
    public static void verifyZipHeader(InputStream inputStream) throws UnsupportedFileFormatException, IOException {
        int i = C140611.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.valueOf(FileMagic.prepareToCheckMagic(inputStream)).ordinal()];
        if (i == 1) {
            throw new OLE2NotOfficeXmlFileException("The supplied data appears to be in the OLE2 Format. You are calling the part of POI that deals with OOXML (Office Open XML) Documents. You need to call a different part of POI to process this data (eg HSSF instead of XSSF)");
        }
        if (i == 2) {
            throw new NotOfficeXmlFileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
        }
    }

    public static ZipFile openZipFile(String str) {
        return openZipFile(new File(str));
    }
}

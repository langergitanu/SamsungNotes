package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipContentTypeManager extends ContentTypeManager {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) ZipContentTypeManager.class);

    public ZipContentTypeManager(InputStream inputStream, OPCPackage oPCPackage) {
        super(inputStream, oPCPackage);
    }

    @Override // org.apache.poi.openxml4j.opc.internal.ContentTypeManager
    public boolean saveImpl(Document document, OutputStream outputStream) {
        ZipOutputStream zipOutputStream = outputStream instanceof ZipOutputStream ? (ZipOutputStream) outputStream : new ZipOutputStream(outputStream);
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ContentTypeManager.CONTENT_TYPES_PART_NAME));
            if (!StreamHelper.saveXmlInStream(document, zipOutputStream)) {
                return false;
            }
            zipOutputStream.closeEntry();
            return true;
        } catch (IOException e) {
            logger.log(7, "Cannot write: [Content_Types].xml in Zip !", e);
            return false;
        }
    }
}

package org.apache.poi.openxml4j.opc;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.BooleanUtils;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class StreamHelper {
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private StreamHelper() {
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    return true;
                }
                outputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return false;
        }
    }

    private static synchronized Transformer getIdentityTransformer() {
        return transformerFactory.newTransformer();
    }

    public static boolean saveXmlInStream(Document document, OutputStream outputStream) {
        try {
            Transformer identityTransformer = getIdentityTransformer();
            DOMSource dOMSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new FilterOutputStream(outputStream) { // from class: org.apache.poi.openxml4j.opc.StreamHelper.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    ((FilterOutputStream) this).out.flush();
                }

                @Override // java.io.FilterOutputStream, java.io.OutputStream
                public void write(byte[] bArr, int i, int i2) throws IOException {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                }
            });
            identityTransformer.setOutputProperty(XMLWriter.ENCODING, "UTF-8");
            identityTransformer.setOutputProperty(XMLWriter.INDENT, BooleanUtils.f9757NO);
            identityTransformer.setOutputProperty(XMLWriter.STANDALONE, BooleanUtils.YES);
            identityTransformer.transform(dOMSource, streamResult);
            return true;
        } catch (TransformerException unused) {
            return false;
        }
    }
}

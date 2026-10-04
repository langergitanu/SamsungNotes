package opennlp.tools.formats.frenchtreebank;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import opennlp.tools.parser.Parse;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.XmlUtil;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConstitParseSampleStream extends FilterObjectStream<byte[], Parse> {
    private final List<Parse> parses;
    private final SAXParser saxParser;

    public ConstitParseSampleStream(ObjectStream<byte[]> objectStream) {
        super(objectStream);
        this.parses = new ArrayList();
        this.saxParser = XmlUtil.createSaxParser();
    }

    @Override // opennlp.tools.util.ObjectStream
    public Parse read() throws IOException {
        byte[] bArr;
        if (this.parses.isEmpty() && (bArr = (byte[]) this.samples.read()) != null) {
            ArrayList arrayList = new ArrayList();
            try {
                this.saxParser.parse(new ByteArrayInputStream(bArr), new ConstitDocumentHandler(arrayList));
                this.parses.addAll(arrayList);
            } catch (SAXException e) {
                throw new IOException(e.getMessage(), e);
            }
        }
        if (this.parses.size() > 0) {
            return this.parses.remove(0);
        }
        return null;
    }
}

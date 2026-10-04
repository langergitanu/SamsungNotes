package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SharedStringsTable extends POIXMLDocumentPart {
    private static final XmlOptions options;
    private SstDocument _sstDoc;
    private int count;
    private final Map<String, Integer> stmap;
    private final List<CTRst> strings;
    private int uniqueCount;

    static {
        XmlOptions xmlOptions = new XmlOptions();
        options = xmlOptions;
        xmlOptions.put(XmlOptions.SAVE_INNER);
        xmlOptions.put(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
        xmlOptions.put(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        xmlOptions.setSaveImplicitNamespaces(Collections.singletonMap("", XSSFRelation.NS_SPREADSHEETML));
    }

    public SharedStringsTable() {
        this.strings = new ArrayList();
        this.stmap = new HashMap();
        SstDocument sstDocumentNewInstance = SstDocument.Factory.newInstance();
        this._sstDoc = sstDocumentNewInstance;
        sstDocumentNewInstance.addNewSst();
    }

    private String getKey(CTRst cTRst) {
        return cTRst.xmlText(options);
    }

    public int addEntry(CTRst cTRst) {
        String key = getKey(cTRst);
        this.count++;
        if (this.stmap.containsKey(key)) {
            return this.stmap.get(key).intValue();
        }
        this.uniqueCount++;
        CTRst cTRstAddNewSi = this._sstDoc.getSst().addNewSi();
        cTRstAddNewSi.set(cTRst);
        int size = this.strings.size();
        this.stmap.put(key, Integer.valueOf(size));
        this.strings.add(cTRstAddNewSi);
        return size;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public int getCount() {
        return this.count;
    }

    public CTRst getEntryAt(int i) {
        return this.strings.get(i);
    }

    public List<CTRst> getItems() {
        return Collections.unmodifiableList(this.strings);
    }

    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            SstDocument sstDocument = SstDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            this._sstDoc = sstDocument;
            CTSst sst = sstDocument.getSst();
            this.count = (int) sst.getCount();
            this.uniqueCount = (int) sst.getUniqueCount();
            int i = 0;
            for (CTRst cTRst : sst.getSiArray()) {
                this.stmap.put(getKey(cTRst), Integer.valueOf(i));
                this.strings.add(cTRst);
                i++;
            }
        } catch (XmlException e) {
            throw new IOException("unable to parse shared strings table", e);
        }
    }

    public void writeTo(OutputStream outputStream) {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveCDataLengthThreshold(1000000);
        xmlOptions.setSaveCDataEntityCountThreshold(-1);
        CTSst sst = this._sstDoc.getSst();
        sst.setCount(this.count);
        sst.setUniqueCount(this.uniqueCount);
        this._sstDoc.save(outputStream, xmlOptions);
    }

    public SharedStringsTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        this.strings = new ArrayList();
        this.stmap = new HashMap();
        readFrom(packagePart.getInputStream());
    }
}

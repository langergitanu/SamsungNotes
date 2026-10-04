package org.apache.poi.xssf.model;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.Name;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ExternalLinksTable extends POIXMLDocumentPart {
    private CTExternalLink link;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ExternalName implements Name {
        private CTExternalDefinedName name;

        public ExternalName(CTExternalDefinedName cTExternalDefinedName) {
            this.name = cTExternalDefinedName;
        }

        public String getComment() {
            return null;
        }

        public String getNameName() {
            return this.name.getName();
        }

        public String getRefersToFormula() {
            return this.name.getRefersTo().substring(1);
        }

        public int getSheetIndex() {
            if (this.name.isSetSheetId()) {
                return (int) this.name.getSheetId();
            }
            return -1;
        }

        public String getSheetName() {
            int sheetIndex = getSheetIndex();
            if (sheetIndex >= 0) {
                return ExternalLinksTable.this.getSheetNames().get(sheetIndex);
            }
            return null;
        }

        public boolean isDeleted() {
            return false;
        }

        public boolean isFunctionName() {
            return false;
        }

        public void setComment(String str) {
            throw new IllegalStateException("Not Supported");
        }

        public void setFunction(boolean z) {
            throw new IllegalStateException("Not Supported");
        }

        public void setNameName(String str) {
            this.name.setName(str);
        }

        public void setRefersToFormula(String str) {
            this.name.setRefersTo(AbstractC0541b.m772n(MarketingConstants.REFERRER_DELIMITER_U003D, str));
        }

        public void setSheetIndex(int i) {
            this.name.setSheetId(i);
        }
    }

    public ExternalLinksTable() {
        CTExternalLink cTExternalLinkNewInstance = CTExternalLink.Factory.newInstance();
        this.link = cTExternalLinkNewInstance;
        cTExternalLinkNewInstance.addNewExternalBook();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public CTExternalLink getCTExternalLink() {
        return this.link;
    }

    public List<Name> getDefinedNames() {
        CTExternalDefinedName[] definedNameArray = this.link.getExternalBook().getDefinedNames().getDefinedNameArray();
        ArrayList arrayList = new ArrayList(definedNameArray.length);
        for (CTExternalDefinedName cTExternalDefinedName : definedNameArray) {
            arrayList.add(new ExternalName(cTExternalDefinedName));
        }
        return arrayList;
    }

    public String getLinkedFileName() {
        PackageRelationship relationship = getPackagePart().getRelationship(this.link.getExternalBook().getId());
        if (relationship == null || relationship.getTargetMode() != TargetMode.EXTERNAL) {
            return null;
        }
        return relationship.getTargetURI().toString();
    }

    public List<String> getSheetNames() {
        CTExternalSheetName[] sheetNameArray = this.link.getExternalBook().getSheetNames().getSheetNameArray();
        ArrayList arrayList = new ArrayList(sheetNameArray.length);
        for (CTExternalSheetName cTExternalSheetName : sheetNameArray) {
            arrayList.add(cTExternalSheetName.getVal());
        }
        return arrayList;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.link = ExternalLinkDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getExternalLink();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void setLinkedFileName(String str) {
        String id = this.link.getExternalBook().getId();
        if (id != null && !id.isEmpty()) {
            getPackagePart().removeRelationship(id);
        }
        this.link.getExternalBook().setId(getPackagePart().addExternalRelationship(str, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLinkPath").getId());
    }

    public void writeTo(OutputStream outputStream) {
        ExternalLinkDocument externalLinkDocumentNewInstance = ExternalLinkDocument.Factory.newInstance();
        externalLinkDocumentNewInstance.setExternalLink(this.link);
        externalLinkDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    public ExternalLinksTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }
}

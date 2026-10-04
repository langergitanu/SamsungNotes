package org.apache.poi;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.xmlbeans.impl.common.SystemCache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class POIXMLDocument extends POIXMLDocumentPart implements Closeable {
    public static final String DOCUMENT_CREATOR = "Apache POI";
    public static final String OLE_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject";
    public static final String PACK_OBJECT_REL_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package";
    private OPCPackage pkg;
    private POIXMLProperties properties;

    public POIXMLDocument(OPCPackage oPCPackage) {
        super(oPCPackage);
        init(oPCPackage);
    }

    private void init(OPCPackage oPCPackage) {
        this.pkg = oPCPackage;
        SystemCache.get().setSaxLoader(null);
    }

    public static OPCPackage openPackage(String str) throws IOException {
        try {
            return OPCPackage.open(str);
        } catch (InvalidFormatException e) {
            throw new IOException(e.toString(), e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OPCPackage oPCPackage = this.pkg;
        if (oPCPackage != null) {
            if (oPCPackage.getPackageAccess() == PackageAccess.READ) {
                this.pkg.revert();
            } else {
                this.pkg.close();
            }
            this.pkg = null;
        }
    }

    public abstract List<PackagePart> getAllEmbedds();

    public PackagePart getCorePart() {
        return getPackagePart();
    }

    public OPCPackage getPackage() {
        return this.pkg;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public POIXMLProperties getProperties() throws POIXMLException {
        if (this.properties == null) {
            try {
                this.properties = new POIXMLProperties(this.pkg);
            } catch (Exception e) {
                throw new POIXMLException(e);
            }
        }
        return this.properties;
    }

    public PackagePart[] getRelatedByType(String str) {
        PackageRelationshipCollection relationshipsByType = getPackagePart().getRelationshipsByType(str);
        PackagePart[] packagePartArr = new PackagePart[relationshipsByType.size()];
        Iterator<PackageRelationship> it = relationshipsByType.iterator();
        int i = 0;
        while (it.hasNext()) {
            packagePartArr[i] = getPackagePart().getRelatedPart(it.next());
            i++;
        }
        return packagePartArr;
    }

    public final void load(POIXMLFactory pOIXMLFactory) {
        HashMap map = new HashMap();
        try {
            read(pOIXMLFactory, map);
            onDocumentRead();
            map.clear();
        } catch (OpenXML4JException e) {
            throw new POIXMLException(e);
        }
    }

    public final void write(OutputStream outputStream) {
        OPCPackage oPCPackage = getPackage();
        if (oPCPackage == null) {
            throw new IOException("Cannot write data, document seems to have been closed already");
        }
        HashSet hashSet = new HashSet();
        onSave(hashSet);
        hashSet.clear();
        getProperties().commit();
        oPCPackage.save(outputStream);
    }

    public POIXMLDocument(OPCPackage oPCPackage, String str) {
        super(oPCPackage, str);
        init(oPCPackage);
    }
}

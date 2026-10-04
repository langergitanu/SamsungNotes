package org.apache.poi;

import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class POIXMLRelation {
    private static final POILogger log = POILogFactory.getLogger((Class<?>) POIXMLRelation.class);
    private Class<? extends POIXMLDocumentPart> _cls;
    private String _defaultName;
    private String _relation;
    private String _type;

    public POIXMLRelation(String str, String str2, String str3, Class<? extends POIXMLDocumentPart> cls) {
        this._type = str;
        this._relation = str2;
        this._defaultName = str3;
        this._cls = cls;
    }

    public String getContentType() {
        return this._type;
    }

    public InputStream getContents(PackagePart packagePart) {
        Iterator<PackageRelationship> it = packagePart.getRelationshipsByType(getRelation()).iterator();
        if (it.hasNext()) {
            return packagePart.getPackage().getPart(PackagingURIHelper.createPartName(it.next().getTargetURI())).getInputStream();
        }
        log.log(5, "No part " + getDefaultFileName() + " found");
        return null;
    }

    public String getDefaultFileName() {
        return this._defaultName;
    }

    public String getFileName(int i) {
        return !this._defaultName.contains(ContentUtils.HASH_SYMBOL) ? getDefaultFileName() : this._defaultName.replace(ContentUtils.HASH_SYMBOL, Integer.toString(i));
    }

    public Integer getFileNameIndex(POIXMLDocumentPart pOIXMLDocumentPart) {
        return Integer.valueOf(pOIXMLDocumentPart.getPackagePart().getPartName().getName().replaceAll(this._defaultName.replace(ContentUtils.HASH_SYMBOL, "(\\d+)"), "$1"));
    }

    public String getRelation() {
        return this._relation;
    }

    public Class<? extends POIXMLDocumentPart> getRelationClass() {
        return this._cls;
    }

    public POIXMLRelation(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }
}

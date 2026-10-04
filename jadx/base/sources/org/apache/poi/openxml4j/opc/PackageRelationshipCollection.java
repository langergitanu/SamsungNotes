package org.apache.poi.openxml4j.opc;

import androidx.appcompat.widget.AbstractC0541b;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class PackageRelationshipCollection implements Iterable<PackageRelationship> {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) PackageRelationshipCollection.class);
    private OPCPackage container;
    private HashMap<String, PackageRelationship> internalRelationshipsByTargetName;
    private int nextRelationshipId;
    private PackagePartName partName;
    private PackagePart relationshipPart;
    private TreeMap<String, PackageRelationship> relationshipsByID;
    private TreeMap<String, PackageRelationship> relationshipsByType;
    private PackagePart sourcePart;

    public PackageRelationshipCollection() {
        this.internalRelationshipsByTargetName = new HashMap<>();
        this.nextRelationshipId = -1;
        this.relationshipsByID = new TreeMap<>();
        this.relationshipsByType = new TreeMap<>();
    }

    private static PackagePartName getRelationshipPartName(PackagePart packagePart) {
        return PackagingURIHelper.getRelationshipPartName(packagePart == null ? PackagingURIHelper.PACKAGE_ROOT_PART_NAME : packagePart.getPartName());
    }

    public void addRelationship(PackageRelationship packageRelationship) {
        this.relationshipsByID.put(packageRelationship.getId(), packageRelationship);
        this.relationshipsByType.put(packageRelationship.getRelationshipType(), packageRelationship);
    }

    public void clear() {
        this.relationshipsByID.clear();
        this.relationshipsByType.clear();
        this.internalRelationshipsByTargetName.clear();
    }

    public PackageRelationship findExistingInternalRelation(PackagePart packagePart) {
        return this.internalRelationshipsByTargetName.get(packagePart.getPartName().getName());
    }

    public PackageRelationship getRelationship(int i) {
        if (i < 0 || i > this.relationshipsByID.values().size()) {
            throw new IllegalArgumentException("index");
        }
        int i2 = 0;
        for (PackageRelationship packageRelationship : this.relationshipsByID.values()) {
            int i4 = i2 + 1;
            if (i == i2) {
                return packageRelationship;
            }
            i2 = i4;
        }
        return null;
    }

    public PackageRelationship getRelationshipByID(String str) {
        return this.relationshipsByID.get(str);
    }

    public PackageRelationshipCollection getRelationships(String str) {
        return new PackageRelationshipCollection(this, str);
    }

    @Override // java.lang.Iterable
    public Iterator<PackageRelationship> iterator() {
        return this.relationshipsByID.values().iterator();
    }

    public void parseRelationshipsPart(PackagePart packagePart) throws InvalidFormatException {
        try {
            logger.log(1, "Parsing relationship: " + packagePart.getPartName());
            NodeList elementsByTagNameNS = DocumentHelper.readDocument(packagePart.getInputStream()).getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/relationships", PackageRelationship.RELATIONSHIP_TAG_NAME);
            int length = elementsByTagNameNS.getLength();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                Element element = (Element) elementsByTagNameNS.item(i);
                String attribute = element.getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME);
                String attribute2 = element.getAttribute(PackageRelationship.TYPE_ATTRIBUTE_NAME);
                if (attribute2.equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties")) {
                    if (z) {
                        throw new InvalidFormatException("OPC Compliance error [M4.1]: there is more than one core properties relationship in the package !");
                    }
                    z = true;
                }
                Attr attributeNode = element.getAttributeNode(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME);
                TargetMode targetMode = TargetMode.INTERNAL;
                if (attributeNode != null && !attributeNode.getValue().toLowerCase(Locale.ROOT).equals("internal")) {
                    targetMode = TargetMode.EXTERNAL;
                }
                URI uri = PackagingURIHelper.toURI("http://invalid.uri");
                String attribute3 = element.getAttribute(PackageRelationship.TARGET_ATTRIBUTE_NAME);
                try {
                    uri = PackagingURIHelper.toURI(attribute3);
                } catch (URISyntaxException e) {
                    logger.log(7, "Cannot convert " + attribute3 + " in a valid relationship URI-> dummy-URI used", e);
                }
                addRelationship(uri, targetMode, attribute2, attribute);
            }
        } catch (Exception e2) {
            logger.log(7, e2);
            throw new InvalidFormatException(e2.getMessage());
        }
    }

    public void removeRelationship(String str) {
        PackageRelationship packageRelationship;
        TreeMap<String, PackageRelationship> treeMap = this.relationshipsByID;
        if (treeMap == null || this.relationshipsByType == null || (packageRelationship = treeMap.get(str)) == null) {
            return;
        }
        this.relationshipsByID.remove(packageRelationship.getId());
        this.relationshipsByType.values().remove(packageRelationship);
        this.internalRelationshipsByTargetName.values().remove(packageRelationship);
    }

    public int size() {
        return this.relationshipsByID.values().size();
    }

    public String toString() {
        String str;
        String strM756B;
        String strM756B2;
        String strM756B3;
        if (this.relationshipsByID == null) {
            str = "relationshipsByID=null";
        } else {
            str = this.relationshipsByID.size() + " relationship(s) = [";
        }
        PackagePart packagePart = this.relationshipPart;
        if (packagePart == null || packagePart._partName == null) {
            strM756B = AbstractC0541b.m756B(str, ",relationshipPart=null");
        } else {
            StringBuilder sbM781w = AbstractC0541b.m781w(str, ",");
            sbM781w.append(this.relationshipPart._partName);
            strM756B = sbM781w.toString();
        }
        PackagePart packagePart2 = this.sourcePart;
        if (packagePart2 == null || packagePart2._partName == null) {
            strM756B2 = AbstractC0541b.m756B(strM756B, ",sourcePart=null");
        } else {
            StringBuilder sbM781w2 = AbstractC0541b.m781w(strM756B, ",");
            sbM781w2.append(this.sourcePart._partName);
            strM756B2 = sbM781w2.toString();
        }
        if (this.partName != null) {
            StringBuilder sbM781w3 = AbstractC0541b.m781w(strM756B2, ",");
            sbM781w3.append(this.partName);
            strM756B3 = sbM781w3.toString();
        } else {
            strM756B3 = AbstractC0541b.m756B(strM756B2, ",uri=null)");
        }
        return AbstractC0541b.m756B(strM756B3, "]");
    }

    public Iterator<PackageRelationship> iterator(String str) {
        ArrayList arrayList = new ArrayList();
        for (PackageRelationship packageRelationship : this.relationshipsByID.values()) {
            if (packageRelationship.getRelationshipType().equals(str)) {
                arrayList.add(packageRelationship);
            }
        }
        return arrayList.iterator();
    }

    public PackageRelationship addRelationship(URI uri, TargetMode targetMode, String str, String str2) {
        if (str2 == null) {
            if (this.nextRelationshipId == -1) {
                this.nextRelationshipId = size() + 1;
            }
            do {
                StringBuilder sb = new StringBuilder("rId");
                int i = this.nextRelationshipId;
                this.nextRelationshipId = i + 1;
                sb.append(i);
                str2 = sb.toString();
            } while (this.relationshipsByID.get(str2) != null);
        }
        PackageRelationship packageRelationship = new PackageRelationship(this.container, this.sourcePart, uri, targetMode, str, str2);
        this.relationshipsByID.put(packageRelationship.getId(), packageRelationship);
        this.relationshipsByType.put(packageRelationship.getRelationshipType(), packageRelationship);
        if (targetMode == TargetMode.INTERNAL) {
            this.internalRelationshipsByTargetName.put(uri.toASCIIString(), packageRelationship);
        }
        return packageRelationship;
    }

    public PackageRelationshipCollection(PackageRelationshipCollection packageRelationshipCollection, String str) {
        this();
        for (PackageRelationship packageRelationship : packageRelationshipCollection.relationshipsByID.values()) {
            if (str == null || packageRelationship.getRelationshipType().equals(str)) {
                addRelationship(packageRelationship);
            }
        }
    }

    public PackageRelationshipCollection(OPCPackage oPCPackage) {
        this(oPCPackage, (PackagePart) null);
    }

    public PackageRelationshipCollection(PackagePart packagePart) {
        this(packagePart._container, packagePart);
    }

    public PackageRelationshipCollection(OPCPackage oPCPackage, PackagePart packagePart) throws InvalidFormatException {
        this();
        if (oPCPackage != null) {
            if (packagePart != null && packagePart.isRelationshipPart()) {
                throw new IllegalArgumentException("part");
            }
            this.container = oPCPackage;
            this.sourcePart = packagePart;
            this.partName = getRelationshipPartName(packagePart);
            if (oPCPackage.getPackageAccess() == PackageAccess.WRITE || !oPCPackage.containPart(this.partName)) {
                return;
            }
            PackagePart part = oPCPackage.getPart(this.partName);
            this.relationshipPart = part;
            parseRelationshipsPart(part);
            return;
        }
        throw new IllegalArgumentException("container needs to be specified");
    }
}

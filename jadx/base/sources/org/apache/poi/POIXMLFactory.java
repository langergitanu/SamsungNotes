package org.apache.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class POIXMLFactory {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) POIXMLFactory.class);
    private static final Class<?>[] PARENT_PART = {POIXMLDocumentPart.class, PackagePart.class};
    private static final Class<?>[] ORPHAN_PART = {PackagePart.class};

    public abstract POIXMLDocumentPart createDocumentPart(Class<? extends POIXMLDocumentPart> cls, Class<?>[] clsArr, Object[] objArr);

    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        PackageRelationship packageRelationship = getPackageRelationship(pOIXMLDocumentPart, packagePart);
        POIXMLRelation descriptor = getDescriptor(packageRelationship.getRelationshipType());
        if (descriptor == null || descriptor.getRelationClass() == null) {
            LOGGER.log(1, "using default POIXMLDocumentPart for " + packageRelationship.getRelationshipType());
            return new POIXMLDocumentPart(pOIXMLDocumentPart, packagePart);
        }
        Class<? extends POIXMLDocumentPart> relationClass = descriptor.getRelationClass();
        try {
            try {
                return createDocumentPart(relationClass, PARENT_PART, new Object[]{pOIXMLDocumentPart, packagePart});
            } catch (NoSuchMethodException unused) {
                return createDocumentPart(relationClass, ORPHAN_PART, new Object[]{packagePart});
            }
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    public abstract POIXMLRelation getDescriptor(String str);

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public PackageRelationship getPackageRelationship(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) throws POIXMLException {
        try {
            String name = packagePart.getPartName().getName();
            for (PackageRelationship packageRelationship : pOIXMLDocumentPart.getPackagePart().getRelationships()) {
                if (packageRelationship.getTargetURI().toASCIIString().equalsIgnoreCase(name)) {
                    return packageRelationship;
                }
            }
            throw new POIXMLException("package part isn't a child of the parent document.");
        } catch (InvalidFormatException e) {
            throw new POIXMLException("error while determining package relations", e);
        }
    }

    public POIXMLDocumentPart newDocumentPart(POIXMLRelation pOIXMLRelation) {
        try {
            return createDocumentPart(pOIXMLRelation.getRelationClass(), null, null);
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }
}

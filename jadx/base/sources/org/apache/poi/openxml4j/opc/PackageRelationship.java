package org.apache.poi.openxml4j.opc;

import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class PackageRelationship {
    public static final String ID_ATTRIBUTE_NAME = "Id";
    public static final String RELATIONSHIPS_TAG_NAME = "Relationships";
    public static final String RELATIONSHIP_TAG_NAME = "Relationship";
    public static final String TARGET_ATTRIBUTE_NAME = "Target";
    public static final String TARGET_MODE_ATTRIBUTE_NAME = "TargetMode";
    public static final String TYPE_ATTRIBUTE_NAME = "Type";
    private static URI containerRelationshipPart;
    private OPCPackage container;

    /* JADX INFO: renamed from: id */
    private String f10160id;
    private String relationshipType;
    private PackagePart source;
    private TargetMode targetMode;
    private URI targetUri;

    static {
        try {
            containerRelationshipPart = new URI("/_rels/.rels");
        } catch (URISyntaxException unused) {
        }
    }

    public PackageRelationship(OPCPackage oPCPackage, PackagePart packagePart, URI uri, TargetMode targetMode, String str, String str2) {
        if (oPCPackage == null) {
            throw new IllegalArgumentException("pkg");
        }
        if (uri == null) {
            throw new IllegalArgumentException("targetUri");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("id");
        }
        this.container = oPCPackage;
        this.source = packagePart;
        this.targetUri = uri;
        this.targetMode = targetMode;
        this.relationshipType = str;
        this.f10160id = str2;
    }

    public static URI getContainerPartRelationship() {
        return containerRelationshipPart;
    }

    public boolean equals(Object obj) {
        PackagePart packagePart;
        if (!(obj instanceof PackageRelationship)) {
            return false;
        }
        PackageRelationship packageRelationship = (PackageRelationship) obj;
        return this.f10160id.equals(packageRelationship.f10160id) && this.relationshipType.equals(packageRelationship.relationshipType) && ((packagePart = packageRelationship.source) == null || packagePart.equals(this.source)) && this.targetMode == packageRelationship.targetMode && this.targetUri.equals(packageRelationship.targetUri);
    }

    public String getId() {
        return this.f10160id;
    }

    public OPCPackage getPackage() {
        return this.container;
    }

    public String getRelationshipType() {
        return this.relationshipType;
    }

    public PackagePart getSource() {
        return this.source;
    }

    public URI getSourceURI() {
        PackagePart packagePart = this.source;
        return packagePart == null ? PackagingURIHelper.PACKAGE_ROOT_URI : packagePart._partName.getURI();
    }

    public TargetMode getTargetMode() {
        return this.targetMode;
    }

    public URI getTargetURI() {
        return this.targetMode == TargetMode.EXTERNAL ? this.targetUri : !this.targetUri.toASCIIString().startsWith("/") ? PackagingURIHelper.resolvePartUri(getSourceURI(), this.targetUri) : this.targetUri;
    }

    public int hashCode() {
        int iHashCode = this.relationshipType.hashCode() + this.f10160id.hashCode();
        PackagePart packagePart = this.source;
        return this.targetUri.hashCode() + this.targetMode.hashCode() + iHashCode + (packagePart == null ? 0 : packagePart.hashCode());
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        StringBuilder sb = new StringBuilder();
        if (this.f10160id == null) {
            str = "id=null";
        } else {
            str = "id=" + this.f10160id;
        }
        sb.append(str);
        if (this.container == null) {
            str2 = " - container=null";
        } else {
            str2 = " - container=" + this.container;
        }
        sb.append(str2);
        if (this.relationshipType == null) {
            str3 = " - relationshipType=null";
        } else {
            str3 = " - relationshipType=" + this.relationshipType;
        }
        sb.append(str3);
        if (this.source == null) {
            str4 = " - source=null";
        } else {
            str4 = " - source=" + getSourceURI().toASCIIString();
        }
        sb.append(str4);
        if (this.targetUri == null) {
            str5 = " - target=null";
        } else {
            str5 = " - target=" + getTargetURI().toASCIIString();
        }
        sb.append(str5);
        if (this.targetMode == null) {
            str6 = ",targetMode=null";
        } else {
            str6 = ",targetMode=" + this.targetMode;
        }
        sb.append(str6);
        return sb.toString();
    }
}

package org.apache.poi.xslf.usermodel;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.net.MailTo;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.p226sl.usermodel.Hyperlink;
import org.apache.poi.p226sl.usermodel.Slide;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFHyperlink implements Hyperlink<XSLFShape, XSLFTextParagraph> {
    final CTHyperlink _link;
    final XSLFSheet _sheet;

    public XSLFHyperlink(CTHyperlink cTHyperlink, XSLFSheet xSLFSheet) {
        this._sheet = xSLFSheet;
        this._link = cTHyperlink;
    }

    private void linkToExternal(String str) {
        PackagePart packagePart = this._sheet.getPackagePart();
        if (this._link.isSetId() && !this._link.getId().isEmpty()) {
            packagePart.removeRelationship(this._link.getId());
        }
        this._link.setId(packagePart.addExternalRelationship(str, XSLFRelation.HYPERLINK.getRelation()).getId());
        if (this._link.isSetAction()) {
            this._link.unsetAction();
        }
    }

    private void linkToRelativeSlide(String str) {
        PackagePart packagePart = this._sheet.getPackagePart();
        if (this._link.isSetId() && !this._link.getId().isEmpty()) {
            packagePart.removeRelationship(this._link.getId());
        }
        this._link.setId("");
        this._link.setAction("ppaction://hlinkshowjump?jump=" + str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getAddress() {
        String id = this._link.getId();
        return (id == null || "".equals(id)) ? this._link.getAction() : this._sheet.getPackagePart().getRelationship(id).getTargetURI().toASCIIString();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getLabel() {
        return this._link.getTooltip();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public int getType() {
        return getTypeEnum().getCode();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public HyperlinkType getTypeEnum() {
        String action = this._link.getAction();
        if (action == null) {
            action = "";
        }
        if (action.equals("ppaction://hlinksldjump") || action.startsWith("ppaction://hlinkshowjump")) {
            return HyperlinkType.DOCUMENT;
        }
        String address = getAddress();
        return (address != null ? address : "").startsWith(MailTo.MAILTO_SCHEME) ? HyperlinkType.EMAIL : HyperlinkType.URL;
    }

    @Internal
    public CTHyperlink getXmlObject() {
        return this._link;
    }

    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToEmail(String str) {
        linkToExternal(AbstractC0541b.m772n(MailTo.MAILTO_SCHEME, str));
        setLabel(str);
    }

    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToFirstSlide() {
        linkToRelativeSlide("firstslide");
    }

    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToLastSlide() {
        linkToRelativeSlide("lastslide");
    }

    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToNextSlide() {
        linkToRelativeSlide("nextslide");
    }

    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToPreviousSlide() {
        linkToRelativeSlide("previousslide");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToSlide(Slide<XSLFShape, XSLFTextParagraph> slide) {
        PackagePart packagePart = this._sheet.getPackagePart();
        PackagePartName partName = ((XSLFSheet) slide).getPackagePart().getPartName();
        if (this._link.isSetId() && !this._link.getId().isEmpty()) {
            packagePart.removeRelationship(this._link.getId());
        }
        this._link.setId(packagePart.addRelationship(partName, TargetMode.INTERNAL, XSLFRelation.SLIDE.getRelation()).getId());
        this._link.setAction("ppaction://hlinksldjump");
    }

    @Override // org.apache.poi.p226sl.usermodel.Hyperlink
    public void linkToUrl(String str) {
        linkToExternal(str);
        setLabel(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setAddress(String str) {
        linkToUrl(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setLabel(String str) {
        this._link.setTooltip(str);
    }
}

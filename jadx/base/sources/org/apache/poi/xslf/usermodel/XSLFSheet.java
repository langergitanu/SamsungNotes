package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.p226sl.draw.DrawPictureShape;
import org.apache.poi.p226sl.usermodel.PictureData;
import org.apache.poi.p226sl.usermodel.Placeholder;
import org.apache.poi.p226sl.usermodel.Sheet;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.Removal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XSLFSheet extends POIXMLDocumentPart implements XSLFShapeContainer, Sheet<XSLFShape, XSLFTextParagraph> {
    private static POILogger LOG = POILogFactory.getLogger((Class<?>) XSLFSheet.class);
    private XSLFCommonSlideData _commonSlideData;
    private XSLFDrawing _drawing;
    private Map<Integer, XSLFSimpleShape> _placeholderByIdMap;
    private Map<Integer, XSLFSimpleShape> _placeholderByTypeMap;
    private List<XSLFTextShape> _placeholders;
    private List<XSLFShape> _shapes;
    private CTGroupShape _spTree;

    public XSLFSheet() {
    }

    public static List<XSLFShape> buildShapes(CTGroupShape cTGroupShape, XSLFSheet xSLFSheet) {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTGroupShape.newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTShape) {
                    arrayList.add(XSLFAutoShape.create((CTShape) object, xSLFSheet));
                } else if (object instanceof CTGroupShape) {
                    arrayList.add(new XSLFGroupShape((CTGroupShape) object, xSLFSheet));
                } else if (object instanceof CTConnector) {
                    arrayList.add(new XSLFConnectorShape((CTConnector) object, xSLFSheet));
                } else if (object instanceof CTPicture) {
                    arrayList.add(new XSLFPictureShape((CTPicture) object, xSLFSheet));
                } else if (object instanceof CTGraphicalObjectFrame) {
                    arrayList.add(XSLFGraphicFrame.create((CTGraphicalObjectFrame) object, xSLFSheet));
                } else if (object instanceof XmlAnyTypeImpl) {
                    xmlCursorNewCursor.push();
                    if (xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/markup-compatibility/2006", "Choice") && xmlCursorNewCursor.toFirstChild()) {
                        try {
                            arrayList.addAll(buildShapes(CTGroupShape.Factory.parse(xmlCursorNewCursor.newXMLStreamReader()), xSLFSheet));
                        } catch (XmlException e) {
                            LOG.log(1, "unparsable alternate content", e);
                        }
                    }
                    xmlCursorNewCursor.pop();
                }
            }
            xmlCursorNewCursor.dispose();
            return arrayList;
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
    }

    private XSLFDrawing getDrawing() {
        initDrawingAndShapes();
        return this._drawing;
    }

    private void initDrawingAndShapes() {
        CTGroupShape spTree = getSpTree();
        if (this._drawing == null) {
            this._drawing = new XSLFDrawing(this, spTree);
        }
        if (this._shapes == null) {
            this._shapes = buildShapes(spTree, this);
        }
    }

    public XSLFSheet appendContent(XSLFSheet xSLFSheet) {
        CTGroupShape spTree = getSpTree();
        int size = getShapes().size();
        for (XmlObject xmlObject : xSLFSheet.getSpTree().selectPath("*")) {
            if (xmlObject instanceof CTShape) {
                spTree.addNewSp().set(xmlObject);
            } else if (xmlObject instanceof CTGroupShape) {
                spTree.addNewGrpSp().set(xmlObject);
            } else if (xmlObject instanceof CTConnector) {
                spTree.addNewCxnSp().set(xmlObject);
            } else if (xmlObject instanceof CTPicture) {
                spTree.addNewPic().set(xmlObject);
            } else if (xmlObject instanceof CTGraphicalObjectFrame) {
                spTree.addNewGraphicFrame().set(xmlObject);
            }
        }
        this._shapes = null;
        this._drawing = null;
        this._spTree = null;
        this._placeholders = null;
        List<XSLFShape> shapes = getShapes();
        List<XSLFShape> shapes2 = xSLFSheet.getShapes();
        for (int i = 0; i < shapes2.size(); i++) {
            shapes.get(size + i).copy(shapes2.get(i));
        }
        return this;
    }

    public boolean canDraw(XSLFShape xSLFShape) {
        return true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public void clear() throws POIXMLException {
        Iterator it = new ArrayList(getShapes()).iterator();
        while (it.hasNext()) {
            removeShape((XSLFShape) it.next());
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public final void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        String rootElementName = getRootElementName();
        if (rootElementName != null) {
            xmlOptions.setSaveSyntheticDocumentElement(new QName("http://schemas.openxmlformats.org/presentationml/2006/main", rootElementName));
        }
        OutputStream outputStream = getPackagePart().getOutputStream();
        getXmlObject().save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public void draw(Graphics2D graphics2D) {
        DrawFactory.getInstance(graphics2D).getDrawable(this).draw(graphics2D);
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        return null;
    }

    @Removal(version = "3.18")
    @Internal
    public XSLFCommonSlideData getCommonSlideData() {
        return this._commonSlideData;
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public boolean getFollowMasterGraphics() {
        return false;
    }

    public XSLFSimpleShape getPlaceholder(CTPlaceholder cTPlaceholder) {
        XSLFSimpleShape placeholderById = cTPlaceholder.isSetIdx() ? getPlaceholderById((int) cTPlaceholder.getIdx()) : null;
        return (placeholderById == null && cTPlaceholder.isSetType()) ? getPlaceholderByType(cTPlaceholder.getType().intValue()) : placeholderById;
    }

    public XSLFSimpleShape getPlaceholderById(int i) {
        initPlaceholders();
        return this._placeholderByIdMap.get(Integer.valueOf(i));
    }

    public XSLFSimpleShape getPlaceholderByType(int i) {
        initPlaceholders();
        return this._placeholderByTypeMap.get(Integer.valueOf(i));
    }

    public XSLFTextShape[] getPlaceholders() {
        initPlaceholders();
        List<XSLFTextShape> list = this._placeholders;
        return (XSLFTextShape[]) list.toArray(new XSLFTextShape[list.size()]);
    }

    public abstract String getRootElementName();

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public List<XSLFShape> getShapes() {
        initDrawingAndShapes();
        return this._shapes;
    }

    public CTGroupShape getSpTree() {
        if (this._spTree == null) {
            XmlObject[] xmlObjectArrSelectPath = getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:spTree");
            if (xmlObjectArrSelectPath.length == 0) {
                throw new IllegalStateException("CTGroupShape was not found");
            }
            this._spTree = (CTGroupShape) xmlObjectArrSelectPath[0];
        }
        return this._spTree;
    }

    public XSLFTextShape getTextShapeByType(Placeholder placeholder) {
        for (XSLFShape xSLFShape : getShapes()) {
            if (xSLFShape instanceof XSLFTextShape) {
                XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
                if (xSLFTextShape.getTextType() == placeholder) {
                    return xSLFTextShape;
                }
            }
        }
        return null;
    }

    public XSLFTheme getTheme() {
        return null;
    }

    public abstract XmlObject getXmlObject();

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public String importBlip(String str, PackagePart packagePart) throws POIXMLException {
        try {
            XSLFPictureData xSLFPictureData = new XSLFPictureData(packagePart.getRelatedPart(packagePart.getRelationship(str)));
            return addRelation(str, XSLFRelation.IMAGES, new XSLFPictureData(getSlideShow().addPicture(xSLFPictureData.getData(), xSLFPictureData.getType()).getPackagePart())).getRelationship().getId();
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public XSLFSheet importContent(XSLFSheet xSLFSheet) {
        this._shapes = null;
        this._drawing = null;
        this._spTree = null;
        this._placeholders = null;
        getSpTree().set(xSLFSheet.getSpTree());
        List<XSLFShape> shapes = getShapes();
        List<XSLFShape> shapes2 = xSLFSheet.getShapes();
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).copy(shapes2.get(i));
        }
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.util.RecordFormatException */
    public PackagePart importPart(PackageRelationship packageRelationship, PackagePart packagePart) throws POIXMLException, RecordFormatException {
        PackagePart packagePart2 = getPackagePart();
        PackagePartName partName = packagePart.getPartName();
        OPCPackage oPCPackage = packagePart2.getPackage();
        if (oPCPackage.containPart(partName)) {
            return oPCPackage.getPart(partName);
        }
        packagePart2.addRelationship(partName, TargetMode.INTERNAL, packageRelationship.getRelationshipType());
        PackagePart packagePartCreatePart = oPCPackage.createPart(partName, packagePart.getContentType());
        try {
            OutputStream outputStream = packagePartCreatePart.getOutputStream();
            InputStream inputStream = packagePart.getInputStream();
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.close();
            return packagePartCreatePart;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public void initPlaceholders() {
        XSLFTextShape xSLFTextShape;
        CTPlaceholder cTPlaceholder;
        if (this._placeholders == null) {
            this._placeholders = new ArrayList();
            this._placeholderByIdMap = new HashMap();
            this._placeholderByTypeMap = new HashMap();
            for (XSLFShape xSLFShape : getShapes()) {
                if ((xSLFShape instanceof XSLFTextShape) && (cTPlaceholder = (xSLFTextShape = (XSLFTextShape) xSLFShape).getCTPlaceholder()) != null) {
                    this._placeholders.add(xSLFTextShape);
                    if (cTPlaceholder.isSetIdx()) {
                        this._placeholderByIdMap.put(Integer.valueOf((int) cTPlaceholder.getIdx()), xSLFTextShape);
                    }
                    if (cTPlaceholder.isSetType()) {
                        this._placeholderByTypeMap.put(Integer.valueOf(cTPlaceholder.getType().intValue()), xSLFTextShape);
                    }
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return getShapes().iterator();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public void removePictureRelation(XSLFPictureShape xSLFPictureShape) throws POIXMLException {
        removeRelation(getRelationById(xSLFPictureShape.getBlipId()));
    }

    @Removal(version = "3.18")
    public void setCommonSlideData(CTCommonSlideData cTCommonSlideData) {
        if (cTCommonSlideData == null) {
            this._commonSlideData = null;
        } else {
            this._commonSlideData = new XSLFCommonSlideData(cTCommonSlideData);
        }
    }

    public XSLFSheet(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public void addShape(XSLFShape xSLFShape) {
        throw new UnsupportedOperationException("Adding a shape from a different container is not supported - create it from scratch witht XSLFSheet.create* methods");
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFAutoShape createAutoShape() {
        XSLFAutoShape xSLFAutoShapeCreateAutoShape = getDrawing().createAutoShape();
        getShapes().add(xSLFAutoShapeCreateAutoShape);
        xSLFAutoShapeCreateAutoShape.setParent(this);
        return xSLFAutoShapeCreateAutoShape;
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFConnectorShape createConnector() {
        XSLFConnectorShape xSLFConnectorShapeCreateConnector = getDrawing().createConnector();
        getShapes().add(xSLFConnectorShapeCreateConnector);
        xSLFConnectorShapeCreateConnector.setParent(this);
        return xSLFConnectorShapeCreateConnector;
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFFreeformShape createFreeform() {
        XSLFFreeformShape xSLFFreeformShapeCreateFreeform = getDrawing().createFreeform();
        getShapes().add(xSLFFreeformShapeCreateFreeform);
        xSLFFreeformShapeCreateFreeform.setParent(this);
        return xSLFFreeformShapeCreateFreeform;
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFGroupShape createGroup() {
        XSLFGroupShape xSLFGroupShapeCreateGroup = getDrawing().createGroup();
        getShapes().add(xSLFGroupShapeCreateGroup);
        xSLFGroupShapeCreateGroup.setParent(this);
        return xSLFGroupShapeCreateGroup;
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFPictureShape createPicture(PictureData pictureData) {
        if (!(pictureData instanceof XSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
        }
        XSLFPictureShape xSLFPictureShapeCreatePicture = getDrawing().createPicture(addRelation(null, XSLFRelation.IMAGES, new XSLFPictureData(((XSLFPictureData) pictureData).getPackagePart())).getRelationship().getId());
        new DrawPictureShape(xSLFPictureShapeCreatePicture).resize();
        getShapes().add(xSLFPictureShapeCreatePicture);
        xSLFPictureShapeCreatePicture.setParent(this);
        return xSLFPictureShapeCreatePicture;
    }

    public XSLFTable createTable() {
        XSLFTable xSLFTableCreateTable = getDrawing().createTable();
        getShapes().add(xSLFTableCreateTable);
        xSLFTableCreateTable.setParent(this);
        return xSLFTableCreateTable;
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFTextBox createTextBox() {
        XSLFTextBox xSLFTextBoxCreateTextBox = getDrawing().createTextBox();
        getShapes().add(xSLFTextBoxCreateTextBox);
        xSLFTextBoxCreateTextBox.setParent(this);
        return xSLFTextBoxCreateTextBox;
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public XMLSlideShow getSlideShow() {
        for (POIXMLDocumentPart parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof XMLSlideShow) {
                return (XMLSlideShow) parent;
            }
        }
        throw new IllegalStateException("SlideShow was not found");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public boolean removeShape(XSLFShape xSLFShape) throws POIXMLException {
        XmlObject xmlObject = xSLFShape.getXmlObject();
        CTGroupShape spTree = getSpTree();
        if (xmlObject instanceof CTShape) {
            spTree.getSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGroupShape) {
            spTree.getGrpSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTConnector) {
            spTree.getCxnSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGraphicalObjectFrame) {
            spTree.getGraphicFrameList().remove(xmlObject);
        } else {
            if (!(xmlObject instanceof CTPicture)) {
                throw new IllegalArgumentException("Unsupported shape: " + xSLFShape);
            }
            removePictureRelation((XSLFPictureShape) xSLFShape);
            spTree.getPicList().remove(xmlObject);
        }
        return getShapes().remove(xSLFShape);
    }

    @Override // org.apache.poi.p226sl.usermodel.ShapeContainer
    public XSLFTable createTable(int i, int i2) {
        if (i >= 1 && i2 >= 1) {
            XSLFTable xSLFTableCreateTable = getDrawing().createTable();
            getShapes().add(xSLFTableCreateTable);
            xSLFTableCreateTable.setParent(this);
            for (int i4 = 0; i4 < i; i4++) {
                XSLFTableRow xSLFTableRowAddRow = xSLFTableCreateTable.addRow();
                for (int i5 = 0; i5 < i2; i5++) {
                    xSLFTableRowAddRow.addCell();
                }
            }
            return xSLFTableCreateTable;
        }
        throw new IllegalArgumentException("numRows and numCols must be greater than 0");
    }

    public XSLFTextShape getPlaceholder(int i) {
        initPlaceholders();
        return this._placeholders.get(i);
    }
}

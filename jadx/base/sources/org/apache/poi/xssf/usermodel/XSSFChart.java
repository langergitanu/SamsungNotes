package org.apache.poi.xssf.usermodel;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p227ss.usermodel.Chart;
import org.apache.poi.p227ss.usermodel.charts.ChartAxis;
import org.apache.poi.p227ss.usermodel.charts.ChartAxisFactory;
import org.apache.poi.p227ss.usermodel.charts.ChartData;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.charts.XSSFCategoryAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFChartDataFactory;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.apache.poi.xssf.usermodel.charts.XSSFDateAxis;
import org.apache.poi.xssf.usermodel.charts.XSSFManualLayout;
import org.apache.poi.xssf.usermodel.charts.XSSFValueAxis;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XSSFChart extends POIXMLDocumentPart implements Chart, ChartAxisFactory {
    List<XSSFChartAxis> axis;
    private CTChart chart;
    private CTChartSpace chartSpace;
    private XSSFGraphicFrame frame;

    public XSSFChart() {
        this.axis = new ArrayList();
        createChart();
    }

    private void createChart() {
        CTChartSpace cTChartSpaceNewInstance = CTChartSpace.Factory.newInstance();
        this.chartSpace = cTChartSpaceNewInstance;
        CTChart cTChartAddNewChart = cTChartSpaceNewInstance.addNewChart();
        this.chart = cTChartAddNewChart;
        cTChartAddNewChart.addNewPlotArea().addNewLayout();
        this.chart.addNewPlotVisOnly().setVal(true);
        CTPrintSettings cTPrintSettingsAddNewPrintSettings = this.chartSpace.addNewPrintSettings();
        cTPrintSettingsAddNewPrintSettings.addNewHeaderFooter();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTPrintSettingsAddNewPrintSettings.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setB(0.75d);
        cTPageMarginsAddNewPageMargins.setL(0.7d);
        cTPageMarginsAddNewPageMargins.setR(0.7d);
        cTPageMarginsAddNewPageMargins.setT(0.75d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPrintSettingsAddNewPrintSettings.addNewPageSetup();
    }

    private boolean hasAxis() {
        CTPlotArea plotArea = this.chart.getPlotArea();
        return ((plotArea.sizeOfValAxArray() + plotArea.sizeOfCatAxArray()) + plotArea.sizeOfDateAxArray()) + plotArea.sizeOfSerAxArray() > 0;
    }

    private void parseAxis() {
        parseCategoryAxis();
        parseDateAxis();
        parseValueAxis();
    }

    private void parseCategoryAxis() {
        for (CTCatAx cTCatAx : this.chart.getPlotArea().getCatAxArray()) {
            this.axis.add(new XSSFCategoryAxis(this, cTCatAx));
        }
    }

    private void parseDateAxis() {
        for (CTDateAx cTDateAx : this.chart.getPlotArea().getDateAxArray()) {
            this.axis.add(new XSSFDateAxis(this, cTDateAx));
        }
    }

    private void parseValueAxis() {
        for (CTValAx cTValAx : this.chart.getPlotArea().getValAxArray()) {
            this.axis.add(new XSSFValueAxis(this, cTValAx));
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.chartSpace.save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.p227ss.usermodel.Chart
    public void deleteLegend() {
        if (this.chart.isSetLegend()) {
            this.chart.unsetLegend();
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Chart
    public List<? extends XSSFChartAxis> getAxis() {
        if (this.axis.isEmpty() && hasAxis()) {
            parseAxis();
        }
        return this.axis;
    }

    @Internal
    public CTChart getCTChart() {
        return this.chart;
    }

    @Internal
    public CTChartSpace getCTChartSpace() {
        return this.chartSpace;
    }

    @Override // org.apache.poi.p227ss.usermodel.Chart
    public XSSFChart getChartAxisFactory() {
        return this;
    }

    public XSSFGraphicFrame getGraphicFrame() {
        return this.frame;
    }

    @Removal(version = AuthenticationConstants.FOUR_POINT_ZERO)
    @Deprecated
    public XSSFRichTextString getTitle() {
        return getTitleText();
    }

    public String getTitleFormula() {
        if (!this.chart.isSetTitle()) {
            return null;
        }
        CTTitle title = this.chart.getTitle();
        if (!title.isSetTx()) {
            return null;
        }
        CTTx tx = title.getTx();
        if (tx.isSetStrRef()) {
            return tx.getStrRef().getF();
        }
        return null;
    }

    public XSSFRichTextString getTitleText() {
        if (!this.chart.isSetTitle()) {
            return null;
        }
        CTTitle title = this.chart.getTitle();
        StringBuffer stringBuffer = new StringBuffer();
        for (XmlObject xmlObject : title.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t")) {
            NodeList childNodes = xmlObject.getDomNode().getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node nodeItem = childNodes.item(i);
                if (nodeItem instanceof Text) {
                    stringBuffer.append(nodeItem.getNodeValue());
                }
            }
        }
        return new XSSFRichTextString(stringBuffer.toString());
    }

    public boolean isPlotOnlyVisibleCells() {
        return this.chart.getPlotVisOnly().getVal();
    }

    @Override // org.apache.poi.p227ss.usermodel.Chart
    public void plot(ChartData chartData, ChartAxis... chartAxisArr) {
        chartData.fillChart(this, chartAxisArr);
    }

    public void setGraphicFrame(XSSFGraphicFrame xSSFGraphicFrame) {
        this.frame = xSSFGraphicFrame;
    }

    public void setPlotOnlyVisibleCells(boolean z) {
        this.chart.getPlotVisOnly().setVal(z);
    }

    public void setTitleFormula(String str) {
        CTTitle title = this.chart.isSetTitle() ? this.chart.getTitle() : this.chart.addNewTitle();
        CTTx tx = title.isSetTx() ? title.getTx() : title.addNewTx();
        if (tx.isSetRich()) {
            tx.unsetRich();
        }
        (tx.isSetStrRef() ? tx.getStrRef() : tx.addNewStrRef()).setF(str);
    }

    public void setTitleText(String str) {
        CTTextBody cTTextBodyAddNewRich;
        CTTitle title = this.chart.isSetTitle() ? this.chart.getTitle() : this.chart.addNewTitle();
        CTTx tx = title.isSetTx() ? title.getTx() : title.addNewTx();
        if (tx.isSetStrRef()) {
            tx.unsetStrRef();
        }
        if (tx.isSetRich()) {
            cTTextBodyAddNewRich = tx.getRich();
        } else {
            cTTextBodyAddNewRich = tx.addNewRich();
            cTTextBodyAddNewRich.addNewBodyPr();
        }
        CTTextParagraph pArray = cTTextBodyAddNewRich.sizeOfPArray() > 0 ? cTTextBodyAddNewRich.getPArray(0) : cTTextBodyAddNewRich.addNewP();
        if (pArray.sizeOfRArray() > 0) {
            pArray.getRArray(0).setT(str);
        } else if (pArray.sizeOfFldArray() > 0) {
            pArray.getFldArray(0).setT(str);
        } else {
            pArray.addNewR().setT(str);
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.charts.ChartAxisFactory
    public XSSFCategoryAxis createCategoryAxis(AxisPosition axisPosition) {
        ChartAxis xSSFCategoryAxis = new XSSFCategoryAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            ChartAxis chartAxis = this.axis.get(0);
            chartAxis.crossAxis(xSSFCategoryAxis);
            xSSFCategoryAxis.crossAxis(chartAxis);
        }
        this.axis.add(xSSFCategoryAxis);
        return xSSFCategoryAxis;
    }

    @Override // org.apache.poi.p227ss.usermodel.charts.ChartAxisFactory
    public XSSFDateAxis createDateAxis(AxisPosition axisPosition) {
        ChartAxis xSSFDateAxis = new XSSFDateAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            ChartAxis chartAxis = this.axis.get(0);
            chartAxis.crossAxis(xSSFDateAxis);
            xSSFDateAxis.crossAxis(chartAxis);
        }
        this.axis.add(xSSFDateAxis);
        return xSSFDateAxis;
    }

    @Override // org.apache.poi.p227ss.usermodel.charts.ChartAxisFactory
    public XSSFValueAxis createValueAxis(AxisPosition axisPosition) {
        ChartAxis xSSFValueAxis = new XSSFValueAxis(this, this.axis.size() + 1, axisPosition);
        if (this.axis.size() == 1) {
            ChartAxis chartAxis = this.axis.get(0);
            chartAxis.crossAxis(xSSFValueAxis);
            xSSFValueAxis.crossAxis(chartAxis);
        }
        this.axis.add(xSSFValueAxis);
        return xSSFValueAxis;
    }

    @Override // org.apache.poi.p227ss.usermodel.Chart
    public XSSFChartDataFactory getChartDataFactory() {
        return XSSFChartDataFactory.getInstance();
    }

    @Override // org.apache.poi.p227ss.usermodel.charts.ManuallyPositionable
    public XSSFManualLayout getManualLayout() {
        return new XSSFManualLayout(this);
    }

    @Override // org.apache.poi.p227ss.usermodel.Chart
    public XSSFChartLegend getOrCreateLegend() {
        return new XSSFChartLegend(this);
    }

    public XSSFChart(PackagePart packagePart) {
        super(packagePart);
        this.axis = new ArrayList();
        CTChartSpace chartSpace = ChartSpaceDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartSpace();
        this.chartSpace = chartSpace;
        this.chart = chartSpace.getChart();
    }

    @Removal(version = AuthenticationConstants.FOUR_POINT_ZERO)
    @Deprecated
    public void setTitle(String str) {
    }
}

package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.parser.sax;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataInfo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VmlSaxParser {
    public ArrayList<VMetaDataInfo> mMetaDataInfos;
    private String mVmlData;
    private InputStream mVmlDataInputStream;

    public ArrayList<VMetaDataInfo> getMetaDataInfos() {
        return this.mMetaDataInfos;
    }

    public String getVmlData() {
        return this.mVmlData;
    }

    public void parse() {
        try {
            this.mMetaDataInfos = new ArrayList<>();
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            VmlSaxParserHandler vmlSaxParserHandler = new VmlSaxParserHandler();
            vmlSaxParserHandler.setMetaDataList(this.mMetaDataInfos);
            vmlSaxParserHandler.resetGroup();
            xMLReader.setContentHandler(vmlSaxParserHandler);
            xMLReader.parse(new InputSource(this.mVmlDataInputStream));
        } catch (IOException | ParserConfigurationException | SAXException unused) {
        }
    }

    public void setMetaDataInfos(ArrayList<VMetaDataInfo> arrayList) {
        this.mMetaDataInfos = arrayList;
    }

    public void setVmlData(String str) {
        this.mVmlData = str;
        this.mVmlDataInputStream = new ByteArrayInputStream(str.getBytes());
    }

    public void setVmlData(InputStream inputStream) {
        this.mVmlDataInputStream = inputStream;
        try {
            this.mVmlData = VUtilString.convertStreamToString(inputStream);
        } catch (Exception unused) {
        }
    }
}

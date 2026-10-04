package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.parser.pull;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataInfo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VmlPullParser {
    public ArrayList<VMetaDataInfo> mMetaDataInfos;
    private String mVmlData;
    private InputStream mVmlDataInputStream;

    public ArrayList<VMetaDataInfo> getMetaDataInfos() {
        return this.mMetaDataInfos;
    }

    public String getVmlData() {
        return this.mVmlData;
    }

    public InputStream getVmlDataInputStream() {
        return this.mVmlDataInputStream;
    }

    public void parse() {
        XmlPullParser xmlPullParser;
        XmlPullParserFactory xmlPullParserFactoryNewInstance;
        XmlPullParserFactory xmlPullParserFactory = null;
        XmlPullParser xmlPullParserNewPullParser = null;
        try {
            xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException unused) {
            xmlPullParser = null;
        }
        try {
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(this.mVmlData));
        } catch (XmlPullParserException unused2) {
            xmlPullParser = xmlPullParserNewPullParser;
            xmlPullParserFactory = xmlPullParserFactoryNewInstance;
            XmlPullParser xmlPullParser2 = xmlPullParser;
            xmlPullParserFactoryNewInstance = xmlPullParserFactory;
            xmlPullParserNewPullParser = xmlPullParser2;
        }
        if (xmlPullParserFactoryNewInstance == null || xmlPullParserNewPullParser == null) {
            return;
        }
        this.mMetaDataInfos = new ArrayList<>();
        VmlPullParserHandler vmlPullParserHandler = new VmlPullParserHandler();
        vmlPullParserHandler.setParser(xmlPullParserNewPullParser);
        vmlPullParserHandler.setMetaDataList(this.mMetaDataInfos);
        vmlPullParserHandler.resetShapes();
        vmlPullParserHandler.resetElements();
        vmlPullParserHandler.resetGroup();
        vmlPullParserHandler.parse();
    }

    public void setMetaDataInfos(ArrayList<VMetaDataInfo> arrayList) {
        this.mMetaDataInfos = arrayList;
    }

    public void setVmlData(String str) {
        this.mVmlData = str;
        this.mVmlDataInputStream = new ByteArrayInputStream(str.getBytes());
    }

    public void setVmlDataInputStream(InputStream inputStream) {
        this.mVmlDataInputStream = inputStream;
    }

    public void setVmlData(InputStream inputStream) {
        setVmlDataInputStream(inputStream);
        try {
            this.mVmlData = VUtilString.convertStreamToString(inputStream);
        } catch (Exception unused) {
        }
    }
}

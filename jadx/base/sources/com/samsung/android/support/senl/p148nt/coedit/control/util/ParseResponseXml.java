package com.samsung.android.support.senl.p148nt.coedit.control.util;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ParseResponseXml {
    private static final String DOWNLOAD_URLS_END_TAG = "</downloadUrls>";
    private static final String DOWNLOAD_URLS_START_TAG = "<downloadUrls";
    private static final String END_TAG = "</noteResource>";
    private static final String START_TAG = "<noteResource";
    private static final String TAG = "ParseResponseXml";
    private final Map<String, String> mDownloadUrlMap = new HashMap();
    private String mXmlBody = "";

    private void extractEntity(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        String strM15134S = null;
        String strM15134S2 = null;
        while (true) {
            if (eventType != 0) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equalsIgnoreCase("id")) {
                        strM15134S = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("url")) {
                        strM15134S2 = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (!isValideName(name)) {
                        CoeditLogger.m8919d(TAG, "fromXMLString - invalid name = [" + name + "]");
                    }
                } else if (eventType != 3) {
                    if (eventType != 4) {
                        CoeditLogger.m8919d(TAG, "fromXMLString - not handled eventType = [" + eventType + "]");
                    }
                } else if (xmlPullParser.getName().equalsIgnoreCase("downloadUrl")) {
                    this.mDownloadUrlMap.put(strM15134S, strM15134S2);
                }
            }
            int iM15119D = AbstractC14517a.m15119D(xmlPullParser, 1);
            if ((iM15119D == 3 && xmlPullParser.getName() != null && xmlPullParser.getName().equals("CompareNoteView")) || iM15119D == 1) {
                return;
            } else {
                eventType = iM15119D;
            }
        }
    }

    private String getSubXml(String str, String str2, String str3) {
        CoeditLogger.m8919d(TAG, "getSubXml: from startTag, " + str2 + " to endTag, " + str3);
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf < 0) {
            return "";
        }
        int length = str3.length() + str.indexOf(str3, iIndexOf);
        CoeditLogger.m8919d(TAG, "getSubXml: start, " + iIndexOf + " end, " + length);
        return iIndexOf < length ? str.substring(iIndexOf, length) : "";
    }

    private boolean isValideName(String str) {
        return str.equalsIgnoreCase("CompareNoteView") || str.equalsIgnoreCase("noteResource") || str.equalsIgnoreCase("downloadUrls") || str.equalsIgnoreCase("downloadUrl") || str.equalsIgnoreCase(IdentityApiContract.Parameter.MODEL_NAME) || str.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID);
    }

    public void extractDownloadUrls(String str) {
        try {
            CoeditLogger.m8919d(TAG, "extractDownloadUrls");
            String subXml = getSubXml(str, DOWNLOAD_URLS_START_TAG, DOWNLOAD_URLS_END_TAG);
            if (TextUtils.isEmpty(subXml)) {
                return;
            }
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(subXml));
            extractEntity(xmlPullParserNewPullParser);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("extractDownloadUrls, parseXml : "), TAG);
        }
    }

    public void extractNoteResource(String str) {
        try {
            CoeditLogger.m8919d(TAG, "extractNoteResource");
            this.mXmlBody = getSubXml(str, START_TAG, END_TAG);
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("extractNoteResource, parseXml : "), TAG);
        }
    }

    public Map<String, String> getDownloadUrlMap() {
        return this.mDownloadUrlMap;
    }

    public String getXmlBody() {
        return this.mXmlBody;
    }
}

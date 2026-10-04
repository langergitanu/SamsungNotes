package p259y0;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.social.SocialApi;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentTempDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.DocumentTempDataJsonUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentTempDataEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentTempDataRepository;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p001A.AbstractC0000a;
import p038I1.AbstractC0125a;
import p042J1.AbstractC0147e;
import p042J1.C0145c;
import p042J1.C0148f;
import p044K.C0158a;
import p079T.C0283a;
import p079T.RunnableC0295m;
import p191j0.AbstractC12916b;
import p191j0.C12917c;
import p191j0.C12918d;
import p191j0.C12919e;
import p191j0.C12920f;
import p191j0.C12921g;
import p191j0.C12922h;
import p191j0.C12923i;
import p191j0.C12924j;
import p191j0.C12926l;
import p191j0.C12927m;
import p191j0.C12930p;
import p191j0.C12931q;
import p191j0.C12932r;
import p191j0.C12933s;
import p191j0.C12934t;
import p191j0.C12935u;
import p198l0.AbstractC13493b;
import p198l0.AbstractC13495d;
import p198l0.C13496e;
import p198l0.C13497f;
import p198l0.C13498g;
import p198l0.C13499h;
import p198l0.C13500i;
import p198l0.C13501j;
import p198l0.C13502k;
import p198l0.C13503l;
import p198l0.C13504m;
import p198l0.C13505n;
import p198l0.C13506o;
import p198l0.C13507p;
import p198l0.C13508q;
import p198l0.C13509r;
import p198l0.C13510s;
import p198l0.C13511t;
import p198l0.C13512u;
import p198l0.C13513v;
import p198l0.C13514w;
import p198l0.C13515x;
import p198l0.C13516y;
import p234q1.C14433b;
import p243u0.AbstractC14471a;
import p243u0.C14472b;
import p243u0.C14473c;
import p243u0.C14474d;
import p243u0.C14475e;
import p243u0.C14476f;

/* JADX INFO: renamed from: y0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC14517a {

    /* JADX INFO: renamed from: a */
    public static String f10346a;

    /* JADX INFO: renamed from: b */
    public static TemporalServerNoteInfo f10347b;

    /* JADX INFO: renamed from: c */
    public static ContextWrapper f10348c;

    /* JADX INFO: renamed from: A */
    public static boolean m15116A(String str, String str2) {
        return (str2 != null && str2.equals(str)) || TextUtils.isEmpty(str);
    }

    /* JADX INFO: renamed from: B */
    public static boolean m15117B(Context context) {
        Set set;
        Debugger.m8607d("Mde$SesInfoUtil", "isSesFeatureAvailable() : start");
        boolean zContainsAll = false;
        if (!C0158a.m412j(context)) {
            return false;
        }
        if (DeviceInfo.getSemPlatformVersionInt(0) >= 100500 && DeviceInfo.getSemPlatformVersionInt(0) < 120000) {
            Debugger.m8607d("Mde$SesInfoUtil", "isSesFeatureAvailable() : return true");
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(Arrays.asList(SeMobileService.SOCIAL_FEATURE_FAMILY_GROUP_SHARING, SeMobileService.SOCIAL_FEATURE_GLOBAL_GROUP_SHARING, SeMobileService.SOCIAL_FEATURE_LOCAL_GROUP_SHARING));
        Debugger.m8607d("Mde$SesInfoUtil", "isSesFeatureAvailable() : SeMobileService.getSupportedSocialFeatureList()");
        CompletableFuture completableFuture = new CompletableFuture();
        new SenlThreadFactory("Mde$SesInfoUtil").newThread(new RunnableC0295m(context, jElapsedRealtime, completableFuture, 0)).start();
        try {
            set = (Set) completableFuture.get(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Debugger.m8609e("Mde$SesInfoUtil", "isSesFeatureAvailable() : InterruptedException " + e);
            set = null;
        } catch (ExecutionException e2) {
            Debugger.m8609e("Mde$SesInfoUtil", "isSesFeatureAvailable() : ExecutionException " + e2);
            set = null;
        } catch (TimeoutException e3) {
            Debugger.m8609e("Mde$SesInfoUtil", "isSesFeatureAvailable() : TimeoutException " + e3);
            set = null;
        }
        if (set != null && !set.isEmpty()) {
            zContainsAll = set.containsAll(arrayList);
        }
        StringBuilder sbM3200j = AbstractC4539a.m3200j("isSesFeatureAvailable() : ", " , et = ", zContainsAll);
        sbM3200j.append(SystemClock.elapsedRealtime() - jElapsedRealtime);
        Debugger.m8607d("Mde$SesInfoUtil", sbM3200j.toString());
        return zContainsAll;
    }

    /* JADX INFO: renamed from: C */
    public static int m15118C(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int iNextTag = xmlPullParser.nextTag();
        while (iNextTag != 2 && iNextTag != 1) {
            iNextTag = xmlPullParser.next();
        }
        return iNextTag;
    }

    /* JADX INFO: renamed from: D */
    public static int m15119D(XmlPullParser xmlPullParser, int i) {
        if (i <= 0) {
            throw new XmlPullParserException(AbstractC0541b.m767i(i, "step(", ") is invalid."));
        }
        int next = -1;
        while (i > 0) {
            next = xmlPullParser.next();
            if (next == 2 || next == 3 || next == 1) {
                i--;
            }
        }
        return next;
    }

    /* JADX INFO: renamed from: E */
    public static double m15120E(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return Double.parseDouble(str.replace(',', '.'));
        }
    }

    /* JADX INFO: renamed from: F */
    public static float m15121F(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return Float.parseFloat(str.replace(',', '.'));
        }
    }

    /* JADX INFO: renamed from: G */
    public static boolean m15122G(String str) {
        File file = new File(str);
        if (file.exists()) {
            FileUtil.deleteFile(file);
        }
        return file.mkdirs();
    }

    /* JADX INFO: renamed from: H */
    public static String m15123H(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        String strDecodeBase64 = Base64Utils.decodeBase64(xmlPullParser.getAttributeValue(0));
        String name2 = name;
        while (eventType != 3 && TextUtils.equals(name, name2)) {
            eventType = xmlPullParser.next();
            name2 = xmlPullParser.getName();
        }
        return strDecodeBase64;
    }

    /* JADX INFO: renamed from: I */
    public static PointF m15124I(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        PointF pointF = new PointF();
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("x")) {
                pointF.x = m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("y")) {
                pointF.y = m15121F(xmlPullParser.getAttributeValue(i));
            }
        }
        String name2 = name;
        while (eventType != 3 && TextUtils.equals(name, name2)) {
            eventType = xmlPullParser.next();
            name2 = xmlPullParser.getName();
        }
        return pointF;
    }

    /* JADX INFO: renamed from: J */
    public static Rect m15125J(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Rect rect = new Rect();
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("l")) {
                rect.left = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("t")) {
                rect.top = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("r")) {
                rect.right = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("b")) {
                rect.bottom = Integer.parseInt(xmlPullParser.getAttributeValue(i));
            }
        }
        String name2 = name;
        while (eventType != 3 && TextUtils.equals(name, name2)) {
            eventType = xmlPullParser.next();
            name2 = xmlPullParser.getName();
        }
        return rect;
    }

    /* JADX INFO: renamed from: K */
    public static SpenRectD m15126K(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        SpenRectD spenRectD = new SpenRectD();
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("l")) {
                spenRectD.left = m15120E(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("t")) {
                spenRectD.top = m15120E(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("r")) {
                spenRectD.right = m15120E(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("b")) {
                spenRectD.bottom = m15120E(xmlPullParser.getAttributeValue(i));
            }
        }
        String name2 = name;
        while (eventType != 3 && TextUtils.equals(name, name2)) {
            eventType = xmlPullParser.next();
            name2 = xmlPullParser.getName();
        }
        return spenRectD;
    }

    /* JADX INFO: renamed from: L */
    public static RectF m15127L(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        RectF rectF = new RectF();
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (attributeName.equalsIgnoreCase("l")) {
                rectF.left = m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("t")) {
                rectF.top = m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("r")) {
                rectF.right = m15121F(xmlPullParser.getAttributeValue(i));
            } else if (attributeName.equalsIgnoreCase("b")) {
                rectF.bottom = m15121F(xmlPullParser.getAttributeValue(i));
            }
        }
        String name2 = name;
        while (eventType != 3 && TextUtils.equals(name, name2)) {
            eventType = xmlPullParser.next();
            name2 = xmlPullParser.getName();
        }
        return rectF;
    }

    /* JADX INFO: renamed from: M */
    public static String m15128M(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        String attributeValue = xmlPullParser.getAttributeValue(0);
        String name2 = name;
        while (eventType != 3 && TextUtils.equals(name, name2)) {
            eventType = xmlPullParser.next();
            name2 = xmlPullParser.getName();
        }
        return attributeValue;
    }

    /* JADX INFO: renamed from: N */
    public static byte[] m15129N(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int next = xmlPullParser.next();
        byte[] bArrDecodeBase64ToByteArray = null;
        if (next != 4) {
            if (next == 3) {
                return null;
            }
            throw new XmlPullParserException("next type is not TEXT.");
        }
        try {
            bArrDecodeBase64ToByteArray = Base64Utils.decodeBase64ToByteArray(xmlPullParser.getText());
        } catch (Exception unused) {
            Debugger.m8609e("WDocXmlUtil", "invalid base64 byte array!");
        }
        xmlPullParser.next();
        return bArrDecodeBase64ToByteArray;
    }

    /* JADX INFO: renamed from: O */
    public static String m15130O(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text;
        if (xmlPullParser.getEventType() != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int next = xmlPullParser.next();
        if (next != 4) {
            if (next == 3) {
                return "";
            }
            throw new XmlPullParserException("next type is not TEXT.");
        }
        try {
            text = Base64Utils.decodeBase64(xmlPullParser.getText());
        } catch (Exception unused) {
            Debugger.m8609e("WDocXmlUtil", "invalid base64 string!");
            text = xmlPullParser.getText();
        }
        xmlPullParser.next();
        return text;
    }

    /* JADX INFO: renamed from: P */
    public static boolean m15131P(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        if (xmlPullParser.next() != 4) {
            throw new XmlPullParserException("next type is not TEXT.");
        }
        boolean z = Boolean.parseBoolean(xmlPullParser.getText());
        xmlPullParser.next();
        return z;
    }

    /* JADX INFO: renamed from: Q */
    public static int m15132Q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        if (xmlPullParser.next() != 4) {
            throw new XmlPullParserException("next type is not TEXT.");
        }
        String text = xmlPullParser.getText();
        int i = text.startsWith("0x") ? Integer.parseInt(text.substring(2), 16) : Integer.parseInt(text);
        xmlPullParser.next();
        return i;
    }

    /* JADX INFO: renamed from: R */
    public static long m15133R(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        if (xmlPullParser.next() != 4) {
            throw new XmlPullParserException("next type is not TEXT.");
        }
        String text = xmlPullParser.getText();
        long j = text.startsWith("0x") ? Long.parseLong(text.substring(2), 16) : Long.parseLong(text);
        xmlPullParser.next();
        return j;
    }

    /* JADX INFO: renamed from: S */
    public static String m15134S(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new XmlPullParserException("current tag is not start tag.");
        }
        int next = xmlPullParser.next();
        if (next == 4) {
            String text = xmlPullParser.getText();
            xmlPullParser.next();
            return text;
        }
        if (next == 3) {
            return "";
        }
        throw new XmlPullParserException("next type is not TEXT.");
    }

    /* JADX INFO: renamed from: T */
    public static void m15135T(C6748q c6748q) {
        DocumentTempDataEntity entity;
        String str = c6748q.f4132e;
        DocumentTempDataRepository documentTempDataRepository = c6748q.f4131d;
        String tempData = (documentTempDataRepository == null || (entity = documentTempDataRepository.getEntity(str)) == null) ? null : entity.getTempData();
        if (tempData == null) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
        NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
        DocumentTempDataRepository documentTempDataRepositoryCreateDocumentTempDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        new C14433b(12);
        if (TextUtils.isEmpty(tempData)) {
            documentTempDataRepositoryCreateDocumentTempDataRepository.deleteByUuid(str);
            return;
        }
        try {
            JSONObject jSONObjectRemoveTempData = DocumentTempDataJsonUtils.removeTempData(DocumentTempDataConstants.KEY_AI_COVER, tempData);
            if (jSONObjectRemoveTempData.length() == 0) {
                documentTempDataRepositoryCreateDocumentTempDataRepository.deleteByUuid(str);
                return;
            }
            String string = jSONObjectRemoveTempData.toString();
            DocumentTempDataEntity documentTempDataEntity = new DocumentTempDataEntity();
            documentTempDataEntity.setUuid(str);
            documentTempDataEntity.setTempData(string);
            documentTempDataRepositoryCreateDocumentTempDataRepository.insert(documentTempDataEntity);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("removeTempData() : fail to remove AiCover, "), "DocumentTempDataUtil");
        }
    }

    /* JADX INFO: renamed from: U */
    public static void m15136U(C6903f c6903f, int i) {
        if (((Type$Process) c6903f.f4475c) == Type$Process.ENTIRE) {
            String str = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m354i(i);
        } else {
            String str2 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            C0148f.m355k(i);
        }
    }

    /* JADX INFO: renamed from: V */
    public static void m15137V(C6748q c6748q, String str) {
        DocumentTempDataEntity entity;
        String str2 = c6748q.f4132e;
        Context applicationContext = BaseUtils.getApplicationContext();
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
        NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
        DocumentTempDataRepository documentTempDataRepositoryCreateDocumentTempDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        DocumentTempDataRepository documentTempDataRepository = c6748q.f4131d;
        String tempData = (documentTempDataRepository == null || (entity = documentTempDataRepository.getEntity(str2)) == null) ? null : entity.getTempData();
        try {
            JSONObject jSONObject = TextUtils.isEmpty(tempData) ? new JSONObject() : new JSONObject(tempData);
            jSONObject.put(DocumentTempDataConstants.KEY_AI_COVER, str);
            String string = jSONObject.toString();
            DocumentTempDataEntity documentTempDataEntity = new DocumentTempDataEntity();
            documentTempDataEntity.setUuid(str2);
            documentTempDataEntity.setTempData(string);
            documentTempDataRepositoryCreateDocumentTempDataRepository.insert(documentTempDataEntity);
        } catch (JSONException e) {
            Debugger.m8609e("DocumentTempDataUtil", "setTempData() :  " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: W */
    public static void m15138W(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        if (eventType != 2) {
            LoggerBase.m7126e("WDocXmlUtil", AbstractC1974b.m1319l("skipCurrentTag - current <", eventType, name, ">, event type = [", "] is not start tag."));
            return;
        }
        int i = 0;
        while (eventType != 1) {
            if (eventType == 3 && name.equalsIgnoreCase(xmlPullParser.getName())) {
                i--;
            } else if (eventType == 2 && name.equalsIgnoreCase(xmlPullParser.getName())) {
                i++;
            }
            if (i == 0) {
                return;
            } else {
                eventType = xmlPullParser.next();
            }
        }
    }

    /* JADX INFO: renamed from: X */
    public static void m15139X(C6865p c6865p) throws SyncException {
        SyncException syncException = new SyncException(315, c6865p.f4346c);
        syncException.setStatusCode(c6865p.f4344a);
        throw syncException;
    }

    /* JADX INFO: renamed from: Y */
    public static synchronized void m15140Y(String str) {
        Logger.m8697d("ImportCacheRepository", "trimCache, path: " + Logger.getEncode(str));
        try {
            FileUtils.deleteFile(new File(str));
        } catch (IOException e) {
            Logger.m8698e("ImportCacheRepository", "trimCache, e: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m15141a(XmlPullParser xmlPullParser, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        int next;
        xmlPullParser.getEventType();
        String name = xmlPullParser.getName();
        xmlSerializer.startTag("", name);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            xmlSerializer.attribute("", xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
        }
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                m15141a(xmlPullParser, xmlSerializer);
            } else if (next == 3) {
                xmlSerializer.endTag("", name);
            } else {
                if (next != 4) {
                    throw new XmlPullParserException(AbstractC0541b.m767i(next, "cloneXml - invalid eventType = [", "]"), xmlPullParser, null);
                }
                xmlSerializer.text(xmlPullParser.getText());
            }
        } while (next != 3);
    }

    /* JADX INFO: renamed from: b */
    public static long m15142b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MSLogger.m8632d("GraphTimeUtil", "convertToUnixTime, iso8601Time : " + str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        try {
            Date date = simpleDateFormat.parse(str);
            if (date != null) {
                jCurrentTimeMillis = date.getTime();
            } else {
                MSLogger.m8633e("GraphTimeUtil", "convertToUnixTime, Failed. date is null!");
            }
        } catch (ParseException e) {
            MSLogger.m8633e("GraphTimeUtil", "Failed. " + e.getMessage());
        }
        MSLogger.m8632d("GraphTimeUtil", "convertToUnixTime, unixEpochTime : " + jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    /* JADX INFO: renamed from: c */
    public static AbstractC12916b m15143c(int i, C6906i c6906i) {
        if (i != 1) {
            int i2 = 2;
            if (i == 2) {
                return new C12920f(i2, c6906i, 1);
            }
            int i4 = 3;
            if (i == 3) {
                return new C12920f(i4, c6906i, 0);
            }
            if (i == 7) {
                return new C12927m(c6906i);
            }
            if (i == 8) {
                return new C12921g(c6906i);
            }
            if (i == 10) {
                return new C12934t(c6906i);
            }
            if (i == 11) {
                return new C12919e(c6906i);
            }
            if (i == 17) {
                return new C12922h(c6906i);
            }
            if (i == 100) {
                return new C12931q(c6906i);
            }
            switch (i) {
                case 13:
                    return new C12935u(c6906i);
                case 14:
                    return new C12924j(c6906i);
                case 15:
                    break;
                default:
                    switch (i) {
                        case 19:
                            return new C12933s(c6906i);
                        case 20:
                            return new C12926l(c6906i);
                        case 21:
                            return new C12923i(c6906i);
                        case 22:
                            return new C12932r(c6906i);
                        case 23:
                            return new C12917c(c6906i);
                        default:
                            AbstractC0541b.m758D(i, "WRONG OBJECT TYPE : ", "WDocObjectFactory");
                            return null;
                    }
            }
        }
        return new C12930p(c6906i);
    }

    /* JADX INFO: renamed from: d */
    public static AbstractC12916b m15144d(String str, C6906i c6906i) {
        if (str == null) {
            return null;
        }
        if (str.equals("stroke")) {
            return new C12930p(c6906i);
        }
        if (str.equals(ExternalDataConstants.Column.TEXT_BOX)) {
            return new C12920f(2, c6906i, 1);
        }
        if (str.equals("image")) {
            return new C12920f(3, c6906i, 0);
        }
        if (str.equals("container")) {
            return new C12918d(c6906i);
        }
        if (str.equals(VMetaDataKey.META_KEY_SHAPE)) {
            return new C12927m(c6906i);
        }
        if (str.equals("line")) {
            return new C12921g(c6906i);
        }
        if (str.equals("voice")) {
            return new C12934t(c6906i);
        }
        if (str.equals("formula")) {
            return new C12919e(c6906i);
        }
        if (str.equals("tableNew")) {
            return new C12932r(c6906i);
        }
        if (str.equals("web")) {
            return new C12935u(c6906i);
        }
        if (str.equals(ComposerCacheFileUtil.PAINTING_FOLDER_NAME)) {
            return new C12924j(c6906i);
        }
        if (str.equals("link")) {
            return new C12922h(c6906i);
        }
        if (str.equals("unknown")) {
            return new C12933s(c6906i);
        }
        if (str.equals("strokeGroup")) {
            return new C12931q(c6906i);
        }
        if (str.equals("plot")) {
            return new C12926l(c6906i);
        }
        if (str.equals("math")) {
            return new C12923i(c6906i);
        }
        if (str.equals("codeBlock")) {
            return new C12917c(c6906i);
        }
        Log.e("WDocObjectFactory", "createObject - type = [" + str + "] is invalid type.");
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static AbstractC13493b m15145e(int i) {
        switch (i) {
            case 2:
                return new C13507p();
            case 3:
                return new C13496e();
            case 4:
                return new C13509r();
            case 5:
                return new C13499h();
            case 6:
                return new C13510s();
            case 7:
            default:
                Debugger.m8609e("WDocTextStyleFactory", "createObjectParagraph - type [" + i + "] is invalid type");
                return null;
            case 8:
                return new C13513v();
            case 9:
                return new C13512u();
            case 10:
                return new C13511t();
        }
    }

    /* JADX INFO: renamed from: f */
    public static AbstractC13495d m15146f(int i) {
        if (i == 1) {
            return new C13505n();
        }
        if (i == 9) {
            return new C13506o();
        }
        if (i == 3) {
            return new C13504m(3);
        }
        if (i == 4) {
            return new C13503l(4);
        }
        if (i == 5) {
            return new C13498g(5);
        }
        if (i == 6) {
            return new C13508q();
        }
        if (i == 7) {
            return new C13516y();
        }
        switch (i) {
            case 15:
                C13500i c13500i = new C13500i(15);
                c13500i.f9483f = 0;
                return c13500i;
            case 16:
                return new C13501j(16);
            case 17:
                return new C13497f();
            case 18:
                return new C13502k(18);
            case 19:
                return new C13515x();
            case 20:
                return new C13514w();
            default:
                Debugger.m8609e("WDocTextStyleFactory", "createObjectSPan - type [" + i + "] is invalid type");
                return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static SecretKeySpec m15147g(String str, byte[] bArr) {
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 256)).getEncoded(), AES256KeyLoader.AES_ALGORITHM);
    }

    /* JADX INFO: renamed from: h */
    public static SecretKeySpec m15148h(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes("UTF-8"));
        byte[] bArr = new byte[16];
        System.arraycopy(messageDigest.digest(), 0, bArr, 0, 16);
        return new SecretKeySpec(bArr, AES256KeyLoader.AES_ALGORITHM);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m15149i(Context context) {
        if (context == null || context.getCacheDir() == null) {
            Logger.m8703w("ImportCacheRepository", "getCacheDirPath#, context or getCacheDir is null");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getPath());
        String strM1170p = AbstractC0622a.m1170p(File.separator, "importCache", sb);
        File file = new File(strM1170p);
        if (file.exists()) {
            if (!file.isDirectory()) {
                try {
                    FileUtils.deleteFile(file);
                    if (!file.mkdir()) {
                    }
                } catch (IOException unused) {
                    Logger.m8698e("ImportCacheRepository", "getCacheDirPath, failed to delete an abnormal file");
                    return "";
                }
            }
        } else if (!file.mkdir()) {
            Logger.m8698e("ImportCacheRepository", "getCacheDirPath, failed to make a cache dir");
            return "";
        }
        return strM1170p;
    }

    /* JADX INFO: renamed from: j */
    public static CipherInputStream m15150j(int i, BufferedInputStream bufferedInputStream, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpecM15148h;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr = new byte[cipher.getBlockSize()];
        if (bufferedInputStream.read(bArr) == -1) {
            return null;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        if (i == 1) {
            byte[] bArr2 = new byte[16];
            if (bufferedInputStream.read(bArr2) == -1) {
                return null;
            }
            secretKeySpecM15148h = m15147g(str, bArr2);
        } else {
            secretKeySpecM15148h = m15148h(str);
        }
        cipher.init(2, secretKeySpecM15148h, ivParameterSpec);
        return new CipherInputStream(bufferedInputStream, cipher);
    }

    /* JADX INFO: renamed from: k */
    public static CipherOutputStream m15151k(int i, FileOutputStream fileOutputStream, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpecM15148h;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr = new byte[cipher.getBlockSize()];
        JavaInstanceConstructor.getSecureRandom().nextBytes(bArr);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        fileOutputStream.write(bArr);
        if (i == 1) {
            byte[] bArr2 = new byte[16];
            JavaInstanceConstructor.getSecureRandom().nextBytes(bArr2);
            fileOutputStream.write(bArr2);
            secretKeySpecM15148h = m15147g(str, bArr2);
        } else {
            secretKeySpecM15148h = m15148h(str);
        }
        cipher.init(1, secretKeySpecM15148h, ivParameterSpec);
        return new CipherOutputStream(fileOutputStream, cipher);
    }

    /* JADX INFO: renamed from: l */
    public static int m15152l(int i) {
        if (i == 2) {
            Debugger.m8607d("SyncNotificationType", String.format("getImportTypeFromSyncType(%d) : TIP_CARD_FAIL_TO_IMPORT_SERVER_ERROR", Integer.valueOf(i)));
            return 3;
        }
        if (i != 3) {
            return i != 4 ? -1 : 5;
        }
        Debugger.m8607d("SyncNotificationType", String.format("getImportTypeFromSyncType(%d) : TIP_CARD_FAIL_TO_IMPORT_NETWORK_ERROR", Integer.valueOf(i)));
        return 4;
    }

    /* JADX INFO: renamed from: m */
    public static String m15153m(String str, ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.api.services.drive.model.File file = (com.google.api.services.drive.model.File) it.next();
            if (str.equals(file.getId())) {
                stringBuffer.append(file.getTitle());
                String strM15153m = m15153m(file.getParents().get(0).getId(), arrayList);
                if (strM15153m != null && !strM15153m.isEmpty()) {
                    stringBuffer.insert(0, '/').insert(0, strM15153m);
                }
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: n */
    public static int m15154n(DocTypeConstants docTypeConstants) {
        switch (AbstractC0125a.f388a[docTypeConstants.ordinal()]) {
            case 1:
            case 2:
            case 3:
                Debugger.m8607d("SyncNotificationType", "getImportTypeFromDocType : IMPORT_TYPE_MEMO with " + docTypeConstants);
                return 1;
            case 4:
            case 5:
            case 6:
                Debugger.m8607d("SyncNotificationType", "getImportTypeFromSyncType : IMPORT_TYPE_SNOTE with " + docTypeConstants);
                return 0;
            case 7:
                Debugger.m8607d("SyncNotificationType", "getImportTypeFromSyncType : IMPORT_TYPE_SCRAPBOOK with " + docTypeConstants);
                return 2;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: o */
    public static String m15155o(Intent intent) {
        if (intent == null) {
            return "";
        }
        String action = intent.getAction();
        return TextUtils.isEmpty(action) ? "" : action;
    }

    /* JADX INFO: renamed from: p */
    public static Type$Interface m15156p(Intent intent) {
        String strM15155o = m15155o(intent);
        return (TextUtils.isEmpty(strM15155o) || !strM15155o.contains("OSMOSIS")) ? Type$Interface.INDEPENDENT : Type$Interface.OSMOSIS;
    }

    /* JADX INFO: renamed from: q */
    public static int m15157q(int i, int i2) {
        return (768 << i) | (3 << i2);
    }

    /* JADX INFO: renamed from: r */
    public static Type$Process m15158r(Intent intent) {
        String strM15155o = m15155o(intent);
        return (TextUtils.isEmpty(strM15155o) || !strM15155o.contains("INSTANT")) ? Type$Process.ENTIRE : Type$Process.INSTANT;
    }

    /* JADX INFO: renamed from: s */
    public static SocialApi m15159s() throws ShareException {
        try {
            return new SocialApi(C6715o.m4808q().m4798f());
        } catch (NotAuthorizedException e) {
            String str = "NotAuthorizedException : " + e.getMessage();
            Debugger.m8609e("SesSocialApi", str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
        } catch (NotConnectedException e2) {
            String str2 = "NotConnectedException : " + e2.getMessage();
            Debugger.m8609e("SesSocialApi", str2);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
        } catch (NotSupportedApiException e3) {
            String str3 = "NotSupportedApiException : " + e3.getMessage();
            Debugger.m8609e("SesSocialApi", str3);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
        } catch (Exception e5) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
        }
    }

    /* JADX INFO: renamed from: t */
    public static String m15160t(Intent intent, String str) {
        return intent.hasExtra(str) ? intent.getStringExtra(str) : "";
    }

    /* JADX INFO: renamed from: u */
    public static long m15161u() {
        return C0145c.m328m(0L, "SyncSuccessTime", "SyncSuccessTimeKey");
    }

    /* JADX INFO: renamed from: v */
    public static SyncDelayInfoEntity m15162v(int i, String str, String str2) {
        SyncDelayInfoEntity syncDelayInfoEntity = new SyncDelayInfoEntity();
        syncDelayInfoEntity.setUuid(str);
        syncDelayInfoEntity.setServerId(str2);
        syncDelayInfoEntity.setAppVersion(C0145c.m322g());
        syncDelayInfoEntity.setReason(i);
        return syncDelayInfoEntity;
    }

    /* JADX INFO: renamed from: w */
    public static AbstractC14471a m15163w(int i, int i2) {
        if (i == 1) {
            return new C14472b(19);
        }
        if (i == 124) {
            C14472b c14472b = new C14472b(21, false);
            c14472b.f10274b = 124;
            return c14472b;
        }
        if (i == 126) {
            C14472b c14472b2 = new C14472b(15, false);
            c14472b2.f10274b = 126;
            return c14472b2;
        }
        if (i == 200) {
            return new C14472b(12);
        }
        if (i == 201) {
            C14472b c14472b3 = new C14472b(18, false);
            c14472b3.f10274b = 201;
            return c14472b3;
        }
        switch (i) {
            case 100:
                C14472b c14472b4 = new C14472b(9, false);
                c14472b4.f10274b = 100;
                return c14472b4;
            case 101:
                C14475e c14475e = new C14475e();
                c14475e.f10278c = i2;
                c14475e.f10274b = 101;
                return c14475e;
            case 102:
                C14472b c14472b5 = new C14472b(13, false);
                c14472b5.f10274b = 102;
                return c14472b5;
            case 103:
                C14474d c14474d = new C14474d(1);
                c14474d.f10277d = i2;
                c14474d.f10274b = 103;
                return c14474d;
            case 104:
                C14472b c14472b6 = new C14472b(10, false);
                c14472b6.f10274b = 104;
                return c14472b6;
            case 105:
                C14472b c14472b7 = new C14472b(8, false);
                c14472b7.f10274b = 105;
                return c14472b7;
            case 106:
                C14472b c14472b8 = new C14472b(17, false);
                c14472b8.f10274b = 106;
                return c14472b8;
            case 107:
                C14472b c14472b9 = new C14472b(11, false);
                c14472b9.f10274b = 107;
                return c14472b9;
            case 108:
                C14476f c14476f = new C14476f();
                c14476f.f10274b = 108;
                return c14476f;
            case 109:
                C14472b c14472b10 = new C14472b(5, false);
                c14472b10.f10274b = 109;
                return c14472b10;
            case 110:
                C14472b c14472b11 = new C14472b(20, false);
                c14472b11.f10274b = 110;
                return c14472b11;
            case 111:
                C14472b c14472b12 = new C14472b(16, false);
                c14472b12.f10274b = 111;
                return c14472b12;
            case 112:
                C14472b c14472b13 = new C14472b(4, false);
                c14472b13.f10274b = 112;
                return c14472b13;
            case 113:
                C14472b c14472b14 = new C14472b(14, false);
                c14472b14.f10274b = 113;
                return c14472b14;
            case 114:
                C14473c c14473c = new C14473c();
                c14473c.f10274b = 114;
                return c14473c;
            case 115:
                C14472b c14472b15 = new C14472b(3, false);
                c14472b15.f10274b = 115;
                return c14472b15;
            case 116:
                C14472b c14472b16 = new C14472b(0, false);
                c14472b16.f10274b = 116;
                return c14472b16;
            case 117:
                C14472b c14472b17 = new C14472b(2, false);
                c14472b17.f10274b = 117;
                return c14472b17;
            case 118:
                C14474d c14474d2 = new C14474d(0);
                c14474d2.f10277d = i2;
                c14474d2.f10274b = 118;
                return c14474d2;
            case 119:
                C14472b c14472b18 = new C14472b(6, false);
                c14472b18.f10274b = 119;
                return c14472b18;
            case 120:
                C14472b c14472b19 = new C14472b(7, false);
                c14472b19.f10274b = 120;
                return c14472b19;
            case 121:
                C14472b c14472b20 = new C14472b(1, false);
                c14472b20.f10274b = 121;
                return c14472b20;
            default:
                Debugger.m8609e("SyncErrorManager", "No matched Sync error : " + i);
                return new C14472b(19);
        }
    }

    /* JADX INFO: renamed from: x */
    public static boolean m15164x(Context context) {
        Set set;
        Debugger.m8607d("Mde$SesInfoUtil", "isCoeditSesFeatureAvailable() : start");
        boolean zContainsAll = false;
        if (!C0158a.m412j(context)) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(Arrays.asList(SeMobileService.SOCIAL_FEATURE_NOTE_COEDIT, SeMobileService.SOCIAL_FEATURE_INVITATION_LINK));
        Debugger.m8607d("Mde$SesInfoUtil", "isCoeditSesFeatureAvailable() : SeMobileService.getSupportedSocialFeatureList()");
        CompletableFuture completableFuture = new CompletableFuture();
        new SenlThreadFactory("Mde$SesInfoUtil").newThread(new RunnableC0295m(context, jElapsedRealtime, completableFuture, 1)).start();
        try {
            set = (Set) completableFuture.get(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Debugger.m8609e("Mde$SesInfoUtil", "isCoeditSesFeatureAvailable() : InterruptedException " + e);
            set = null;
        } catch (ExecutionException e2) {
            Debugger.m8609e("Mde$SesInfoUtil", "isCoeditSesFeatureAvailable() : ExecutionException " + e2);
            set = null;
        } catch (TimeoutException e3) {
            Debugger.m8609e("Mde$SesInfoUtil", "isCoeditSesFeatureAvailable() : TimeoutException " + e3);
            set = null;
        }
        if (set != null && !set.isEmpty()) {
            zContainsAll = set.containsAll(arrayList);
        }
        StringBuilder sbM3200j = AbstractC4539a.m3200j("isCoeditSesFeatureAvailable() : ", " , et = ", zContainsAll);
        sbM3200j.append(SystemClock.elapsedRealtime() - jElapsedRealtime);
        Debugger.m8607d("Mde$SesInfoUtil", sbM3200j.toString());
        return zContainsAll;
    }

    /* JADX INFO: renamed from: y */
    public static boolean m15165y(Context context, String str) {
        NotesDocumentEntity notesDocumentEntityM9f;
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        if (notesDocumentEntityM9f != null) {
            String mdeExtra = notesDocumentEntityM9f.getMdeExtra();
            if (mdeExtra.isEmpty()) {
                return false;
            }
            try {
                if (new JSONObject(mdeExtra).getBoolean("isSdocConverted")) {
                    return true;
                }
            } catch (JSONException e) {
                Debugger.m8609e("Mde$SesInfoUtil", "isItemOwnedByMe() : " + e.getMessage());
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: z */
    public static boolean m15166z(Context context, String str) {
        C0283a.m562d().getClass();
        try {
            return m15116A(NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getGcsOwnerId(str), C0283a.m561c());
        } catch (Exception e) {
            Debugger.m8609e("Mde$SesInfoUtil", "isItemOwnedByMe() : " + e.getMessage());
            Debugger.m8609e("Mde$SesInfoUtil", "fail to get the owner state!");
            return false;
        }
    }
}

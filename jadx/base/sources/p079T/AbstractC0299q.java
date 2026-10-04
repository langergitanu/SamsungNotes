package p079T;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.core.view.MotionEventCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.app.notes.sync.synchronization.managers.C6900c;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.sdk.mobileservice.auth.AuthApi;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.sdk.mobileservice.social.SocialApi;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.LockUtilsContractImpl;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.SyncNotificationReceiverActivity;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.json.JSONObject;
import org.jsoup.helper.StringUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import p001A.AbstractC0000a;
import p007B0.C0025h;
import p007B0.C0026i;
import p020E.C0073a;
import p026F1.C0097a;
import p033H0.C0112b;
import p037I0.C0124c;
import p042J1.C0145c;
import p044K.C0158a;
import p068Q.AbstractC0205b;
import p068Q.C0204a;
import p086V.C0322h;
import p185h0.InterfaceC12017b;
import p207n1.C13541h;
import p211o0.C13567a;
import p211o0.C13569c;
import p212o1.C13573a;
import p234q1.C14434c;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: T.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0299q {

    /* JADX INFO: renamed from: a */
    public static C0097a f768a;

    /* JADX INFO: renamed from: b */
    public static boolean f769b;

    /* JADX INFO: renamed from: c */
    public static int f770c;

    /* JADX INFO: renamed from: d */
    public static boolean f771d;

    /* JADX INFO: renamed from: A */
    public static File m591A(String str, String str2) throws IOException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException(str.concat(" - filePath is invalid"));
        }
        File file = new File(str2);
        if (!file.exists()) {
            return file;
        }
        File file2 = new File(str2.concat(".bak"));
        if (file2.exists() && !file2.delete()) {
            throw new IOException(str.concat(" - Cannot delete backup file"));
        }
        if (file.renameTo(file2)) {
            return new File(str2);
        }
        throw new IOException(str.concat(" - Cannot create backup file"));
    }

    /* JADX INFO: renamed from: B */
    public static synchronized Set m592B(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SesSkipItemManagerPref", 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getStringSet("SesSkipItemManagerPref_Key_FileNames", null);
    }

    /* JADX INFO: renamed from: C */
    public static long m593C() {
        return Long.parseLong(C0145c.m331p("SDocLastSyncTime", "SDocLastSyncTimeKey", "1464416139847"));
    }

    /* JADX INFO: renamed from: D */
    public static String m594D() {
        return DeviceInfo.isVSTModel() ? C13541h.m14287e().m14293g() : m648s().getAuthInfo().getResult().getGuid();
    }

    /* JADX INFO: renamed from: E */
    public static int m595E(String str) {
        if (StringUtil.isBlank(str)) {
            Debugger.m8609e("NT$WDocServiceHelper", "getRCodeFromServerError() : empty errMessage!");
            return -1;
        }
        if (str.charAt(0) == '{') {
            try {
                return new JSONObject(str).getInt("rcode");
            } catch (Exception e) {
                Debugger.m8609e("NT$WDocServiceHelper", e.getMessage());
                return -1;
            }
        }
        try {
            C0025h c0025h = new C0025h();
            c0025h.m48b(str);
            return c0025h.f136f;
        } catch (Exception e2) {
            Debugger.m8609e("NT$WDocServiceHelper", e2.getMessage());
            return -1;
        }
    }

    /* JADX INFO: renamed from: F */
    public static byte[] m596F(String str) {
        File file = new File(str);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[(int) file.length()];
            try {
                try {
                    dataInputStream.readFully(bArr);
                } catch (IOException e) {
                    Debugger.m8611e("GraphImageUtil", e);
                }
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                    Debugger.m8611e("GraphImageUtil", e2);
                }
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    Debugger.m8611e("GraphImageUtil", e3);
                }
                MSLogger.m8632d("GraphImageUtil", "getByte exist : " + file.exists());
                return bArr;
            } finally {
            }
        } catch (FileNotFoundException e5) {
            Debugger.m8611e("GraphImageUtil", e5);
            return null;
        }
    }

    /* JADX INFO: renamed from: G */
    public static String m597G(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            Debugger.m8611e("WDocConverterUtil", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: H */
    public static SocialApi m598H() throws ShareException {
        try {
            return new SocialApi(C6716p.m4809q().m4798f());
        } catch (NotAuthorizedException e) {
            String str = "NotAuthorizedException : " + e.getMessage();
            Debugger.m8609e("SesAuthApi", str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
        } catch (NotConnectedException e2) {
            String str2 = "NotConnectedException : " + e2.getMessage();
            Debugger.m8609e("SesAuthApi", str2);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
        } catch (NotSupportedApiException e3) {
            String str3 = "NotSupportedApiException : " + e3.getMessage();
            Debugger.m8609e("SesAuthApi", str3);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
        } catch (Exception e5) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
        }
    }

    /* JADX INFO: renamed from: I */
    public static String m599I(String str) {
        return AbstractC0541b.m774p(" SELECT hashtagContent.sdocUUID AS sdocUUID, MAX(hashtagContent.isDirty) AS isDirtyMax , MAX(hashtagContent.serverTimestamp) AS serverTimestampMax , COUNT(hashtagContent.sdocUUID) AS sdocCount   FROM hashtagContent ", TextUtils.isEmpty(str) ? "" : AbstractC0541b.m773o(" WHERE (", str, ") "), "  GROUP BY hashtagContent.sdocUUID ", TextUtils.isEmpty("") ? "" : SQLKeyword.ORDER_BY);
    }

    /* JADX INFO: renamed from: J */
    public static void m600J(Context context, C6865p c6865p) {
        String str;
        Debugger.m8607d("NT$WDocServiceHelper", "handleCommonResponse() status code = " + c6865p.f4344a);
        int i = c6865p.f4344a;
        if (i == 200) {
            Debugger.m8607d("NT$WDocServiceHelper", "Success");
            return;
        }
        if (i == 302) {
            Debugger.m8615i("NT$WDocServiceHelper", "URL redirection");
            return;
        }
        if (i == 409) {
            Debugger.m8609e("NT$WDocServiceHelper", "Conflict");
            return;
        }
        if (i == 429) {
            Debugger.m8609e("NT$WDocServiceHelper", "Too Many Requests");
            long currentTime = TimeManager.getCurrentTime(context) + c6865p.m5049c();
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("WDocServiceHelper", 0).edit();
            editorEdit.putLong("TimeWithRetryAfter", currentTime);
            editorEdit.apply();
            AbstractC14517a.m15139X(c6865p);
            throw null;
        }
        if (i == 500) {
            Debugger.m8609e("NT$WDocServiceHelper", "Internal Server Error");
            Exception exc = new Exception(DiagMonLogger.getExceptionMsg("SERVER_ERROR", 100, ""));
            AbstractC0000a.m21r(exc, new StringBuilder("sendOnceDay() : mainErrCode = SERVER_ERROR , "), "SyncErrorDiagmon");
            try {
                if (TextUtils.isEmpty(null)) {
                    DiagMonLogger.reportOnceDay(exc, "SERVER_ERROR");
                } else {
                    DiagMonLogger.reportOnceDay(exc, "SERVER_ERROR", null);
                }
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("sendOnceDay() : fail to report = "), "SyncErrorDiagmon");
            }
            AbstractC14517a.m15139X(c6865p);
            throw null;
        }
        if (i == 507) {
            Debugger.m8609e("NT$WDocServiceHelper", "Storage Insufficient");
            throw new SyncException(311, c6865p.f4346c);
        }
        if (i == 400) {
            int iM595E = m595E(c6865p.f4346c);
            Debugger.m8609e("NT$WDocServiceHelper", "400 : Bad request, rCode = " + iM595E);
            if (iM595E == 128999) {
                Debugger.m8609e("NT$WDocServiceHelper", "SDK version is not acceptable!");
                throw new SyncException(12000, "High formated note");
            }
            if (iM595E == 19008 || iM595E == 19018 || iM595E == 102004) {
                Debugger.m8609e("NT$WDocServiceHelper", "Access token is expired!");
                C13541h.m14287e().m14296j();
                SCloudPamHelper.handleExpiredSAToken();
                throw new SyncException(508, c6865p.f4346c);
            }
            if (iM595E == 128406) {
                Debugger.m8615i("NT$WDocServiceHelper", "Invalid Payload!");
                throw new SyncException(333, c6865p.f4346c);
            }
            if (iM595E != 400222201 && iM595E != 400222202 && iM595E != 400222203 && iM595E != 400222204) {
                AbstractC14517a.m15139X(c6865p);
                throw null;
            }
            if (!AbstractC4539a.m3210t()) {
                C0158a.m407a().getClass();
                Debugger.m8609e("ConditionalFeature", "setEdpSupported() : Not supported");
            }
            if (!AbstractC4539a.m3210t() || !C13569c.m14375c().m14381g()) {
                throw new SyncException(600, c6865p.f4346c);
            }
            switch (iM595E) {
                case 400222201:
                    if (C13567a.m14371a().m14372c()) {
                        C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF);
                    }
                    str = "Plaintext Document Requested!";
                    break;
                case 400222202:
                    if (!C13567a.m14371a().m14372c()) {
                        C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON);
                    }
                    str = "Encrypted Document Requested!";
                    break;
                case 400222203:
                    if (!C13567a.m14371a().m14372c()) {
                        C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON);
                    }
                    str = "EDP On Requested!";
                    break;
                case 400222204:
                    C13567a.m14371a().getClass();
                    if (!C0145c.m331p("SyncEdp", "SyncEdpState", CoverStickerConstants.Category.NONE.NAME).equals(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF)) {
                        C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF);
                    }
                    str = "EDP Off Requested!";
                    break;
                default:
                    str = "Unknown EDP Error";
                    break;
            }
            throw new SyncException(507, str);
        }
        if (i == 401) {
            Debugger.m8609e("NT$WDocServiceHelper", "Unauthenticated For SC");
            if (m595E(c6865p.f4346c) != 101000) {
                AbstractC14517a.m15139X(c6865p);
                throw null;
            }
            Debugger.m8615i("NT$WDocServiceHelper", "isUnauthenticatedForSC() : true");
            C13541h.m14287e().m14296j();
            SCloudPamHelper.handleExpiredCloudToken();
            Debugger.m8609e("NT$WDocServiceHelper", "SC Access token is expired");
            throw new SyncException(509, c6865p.f4346c);
        }
        switch (i) {
            case 403:
                Debugger.m8609e("NT$WDocServiceHelper", "Forbidden");
                long jM595E = m595E(c6865p.f4346c);
                C6900c.m5110c().getClass();
                if (jM595E == ErrorCodeConvertor.GDPR_PROCESSED_ERROR || jM595E == ErrorCodeConvertor.GDPR_RESTRICTED_ERROR || jM595E == ErrorCodeConvertor.GDPR_DELETED_ERROR) {
                    Debugger.m8615i("NT$WDocServiceHelper", "isServerBlocked() : [GDPR] server is blocked!");
                    C6900c c6900cM5110c = C6900c.m5110c();
                    String str2 = c6865p.f4346c;
                    c6900cM5110c.getClass();
                    throw new SyncException(324, str2);
                }
                if (m595E(c6865p.f4346c) != 403222205) {
                    AbstractC14517a.m15139X(c6865p);
                    throw null;
                }
                Debugger.m8615i("NT$WDocServiceHelper", "isServerBlocked() : [EDP] Unsupported edp device!");
                C0158a.m407a().getClass();
                if (!SyncState.isEdpMode()) {
                    C0158a.m407a().getClass();
                    Debugger.m8609e("ConditionalFeature", "setEdpSupported() : Not supported");
                }
                if (!C13567a.m14371a().m14372c()) {
                    C13567a.m14371a().m14374e(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON);
                }
                if (!AbstractC4539a.m3210t() || !C13569c.m14375c().m14381g()) {
                    throw new SyncException(600, c6865p.f4346c);
                }
                throw new SyncException(507, c6865p.f4346c);
            case 404:
                Debugger.m8609e("NT$WDocServiceHelper", "Not Found");
                AbstractC14517a.m15139X(c6865p);
                throw null;
            case 405:
                Debugger.m8609e("NT$WDocServiceHelper", "Method Not Allowed");
                AbstractC14517a.m15139X(c6865p);
                throw null;
            default:
                switch (i) {
                    case 502:
                        Debugger.m8609e("NT$WDocServiceHelper", "Bad Gateway");
                        AbstractC14517a.m15139X(c6865p);
                        throw null;
                    case 503:
                        Debugger.m8609e("NT$WDocServiceHelper", "Service Unavailable");
                        long currentTime2 = TimeManager.getCurrentTime(context) + c6865p.m5049c();
                        SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("WDocServiceHelper", 0).edit();
                        editorEdit2.putLong("TimeWithRetryAfter", currentTime2);
                        editorEdit2.apply();
                        AbstractC14517a.m15139X(c6865p);
                        throw null;
                    case 504:
                        Debugger.m8609e("NT$WDocServiceHelper", "Gateway Timeout");
                        AbstractC14517a.m15139X(c6865p);
                        throw null;
                    default:
                        if (i >= 300) {
                            Debugger.m8609e("NT$WDocServiceHelper", "Unhandled response : " + c6865p.f4346c);
                        }
                        AbstractC14517a.m15139X(c6865p);
                        throw null;
                }
        }
    }

    /* JADX INFO: renamed from: K */
    public static void m601K(String str) {
        if (C0145c.m328m(-1L, "pref_sync_sa_logging_time", "5044".concat(str)) != -1) {
            m604N("5044", str);
            C0145c.m302J("pref_sync_sa_logging_time", "5044".concat(str));
        }
    }

    /* JADX INFO: renamed from: L */
    public static void m602L(String str) {
        if (C0145c.m328m(-1L, "pref_sync_sa_logging_time", str) == -1) {
            CommonSamsungAnalytics.insertStatusLog(str, "0");
        } else {
            CommonSamsungAnalytics.insertStatusLog(str, "1");
            C0145c.m302J("pref_sync_sa_logging_time", str);
        }
    }

    /* JADX INFO: renamed from: M */
    public static final void m603M(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m8702i(tag, msg);
    }

    /* JADX INFO: renamed from: N */
    public static void m604N(String str, String str2) {
        CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_SETTINGS, str, str2);
    }

    /* JADX INFO: renamed from: O */
    public static boolean m605O() {
        Debugger.m8615i("SesAuthApi", "isReadyToUseSharedService() start");
        if (Build.VERSION.SDK_INT >= 29) {
            return !m598H().isAgreementProcedureNeeded();
        }
        boolean result = m648s().isServiceRegistered(32).getResult();
        Debugger.m8615i("SesAuthApi", "isReadyToUseSharedService() finish : " + Boolean.valueOf(result));
        return result;
    }

    /* JADX INFO: renamed from: P */
    public static int m606P(RandomAccessFile randomAccessFile) throws IOException {
        byte b = randomAccessFile.readByte();
        byte b5 = randomAccessFile.readByte();
        byte b6 = randomAccessFile.readByte();
        return ((randomAccessFile.readByte() << 24) & (-16777216)) | (b & 255) | ((b5 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((b6 << 16) & 16711680);
    }

    /* JADX INFO: renamed from: Q */
    public static long m607Q(RandomAccessFile randomAccessFile) {
        return (((long) m606P(randomAccessFile)) & 4294967295L) | (((long) m606P(randomAccessFile)) << 32);
    }

    /* JADX INFO: renamed from: R */
    public static RectF m608R(RandomAccessFile randomAccessFile) {
        RectF rectF = new RectF();
        rectF.left = Float.intBitsToFloat(m606P(randomAccessFile));
        rectF.top = Float.intBitsToFloat(m606P(randomAccessFile));
        rectF.right = Float.intBitsToFloat(m606P(randomAccessFile));
        rectF.bottom = Float.intBitsToFloat(m606P(randomAccessFile));
        return rectF;
    }

    /* JADX INFO: renamed from: S */
    public static int m609S(RandomAccessFile randomAccessFile) throws IOException {
        byte b = randomAccessFile.readByte();
        return ((randomAccessFile.readByte() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b & 255);
    }

    /* JADX INFO: renamed from: T */
    public static String m610T(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i == 0) {
            return "";
        }
        if (i == -1) {
            return null;
        }
        if (i < -1) {
            throw new IOException(AbstractC0000a.m11h(i, "Failed to read string size - read: "));
        }
        byte[] bArr = new byte[i];
        randomAccessFile.read(bArr);
        return new String(bArr);
    }

    /* JADX INFO: renamed from: U */
    public static String m611U(RandomAccessFile randomAccessFile, int i) throws IOException {
        short sM609S = (short) m609S(randomAccessFile);
        if (sM609S == 0) {
            return "";
        }
        if (sM609S == -1) {
            return null;
        }
        if (sM609S < -1) {
            throw new IOException(AbstractC0000a.m11h(sM609S, "Failed to read string size - read: "));
        }
        if (i != -1 && sM609S > i) {
            throw new IOException(AbstractC1038a.m1214o(sM609S, i, "Failed to read string size - read: ", " but max size: "));
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < sM609S; i2++) {
            sb.append((char) ((randomAccessFile.readByte() & 255) | ((randomAccessFile.readByte() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: V */
    public static String m612V(RandomAccessFile randomAccessFile) throws IOException {
        int iM606P = m606P(randomAccessFile);
        if (iM606P == 0) {
            return "";
        }
        if (iM606P == -1) {
            return null;
        }
        if (iM606P < -1) {
            throw new IOException(AbstractC0000a.m11h(iM606P, "Failed to read string size - read: "));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iM606P; i++) {
            sb.append((char) ((randomAccessFile.readByte() & 255) | ((randomAccessFile.readByte() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: W */
    public static void m613W() {
        m621c("e");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01fb  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX INFO: renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0124c m614X(String str, String str2, String str3, String str4, String str5) {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        StringBuilder sb;
        ?? r6 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (httpURLConnection == null) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                try {
                    httpURLConnection.setConnectTimeout(29000);
                    httpURLConnection.setReadTimeout(120000);
                    httpURLConnection.setRequestMethod(str2);
                    httpURLConnection.setRequestProperty("Authorization", IdentityApiContract.Token.BEARER_ + str3);
                    if (!TextUtils.isEmpty(str4)) {
                        httpURLConnection.setRequestProperty("Content-Type", str4);
                    }
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            try {
                                outputStream.write(str5.getBytes(StandardCharsets.UTF_8));
                                outputStream.flush();
                                outputStream.close();
                            } catch (Throwable th) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e) {
                            Debugger.m8611e("RequestHttpURLConnection", e);
                        }
                    }
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 201 || responseCode == 202) {
                        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8);
                        try {
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                sb = new StringBuilder();
                            } catch (Exception e2) {
                                Debugger.m8611e("RequestHttpURLConnection", e2);
                                inputStreamReader.close();
                                httpURLConnection.disconnect();
                                return new C0124c(null, -1);
                            }
                        } finally {
                            inputStreamReader.close();
                        }
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                C0124c c0124c = new C0124c(sb.toString(), responseCode);
                                inputStreamReader.close();
                                httpURLConnection.disconnect();
                                return c0124c;
                            }
                            sb.append(line);
                            inputStreamReader.close();
                        }
                    }
                    MSLogger.m8633e("RequestHttpURLConnection", "HTTP Fail, response code : " + responseCode);
                    if (responseCode == 204) {
                        C0124c c0124c2 = new C0124c("NO_CONTENT", responseCode);
                        httpURLConnection.disconnect();
                        return c0124c2;
                    }
                    if (responseCode == 429) {
                        List<String> list = httpURLConnection.getHeaderFields().get("Retry-After");
                        if (list == null) {
                            list = httpURLConnection.getHeaderFields().get("Retry-After".toLowerCase());
                        }
                        String str6 = "";
                        int i = 0;
                        if (list != null && !list.isEmpty()) {
                            str6 = list.get(0);
                        }
                        MSLogger.m8632d("RequestHttpURLConnection", "Response header retry-After : " + str6);
                        if (str6 != null) {
                            try {
                                i = Integer.parseInt(str6);
                            } catch (NumberFormatException unused) {
                            }
                        }
                        C0145c.m308P((((long) i) * 1000) + SystemClock.elapsedRealtime(), "GRAPH_PREFERENCE", "key_retry_after_time");
                        C0124c c0124c3 = new C0124c(str6, 429);
                        httpURLConnection.disconnect();
                        return c0124c3;
                    }
                    if (responseCode == 401) {
                        C0124c c0124c4 = new C0124c("HTTP_UNAUTHORIZED", responseCode);
                        httpURLConnection.disconnect();
                        return c0124c4;
                    }
                    if (responseCode == 404) {
                        MSLogger.m8632d("RequestHttpURLConnection", "Response HTTP_NOT_FOUND");
                        C0124c c0124c5 = new C0124c(m654y(httpURLConnection), responseCode);
                        httpURLConnection.disconnect();
                        return c0124c5;
                    }
                    if (DeviceInfo.isEngMode()) {
                        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                            StringBuilder sb2 = new StringBuilder();
                            for (String str7 : entry.getValue()) {
                                sb2.append(',');
                                sb2.append(str7);
                            }
                            MSLogger.m8632d("RequestHttpURLConnection", "Response header : " + entry.getKey() + " - " + ((Object) sb2));
                        }
                    }
                    m654y(httpURLConnection);
                    C0124c c0124c6 = new C0124c(null, -1);
                    httpURLConnection.disconnect();
                    return c0124c6;
                } catch (IOException e3) {
                    e = e3;
                    Debugger.m8611e("RequestHttpURLConnection", e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return new C0124c(null, -1);
                }
            } catch (Throwable th3) {
                th = th3;
                r6 = str;
                if (r6 != 0) {
                    r6.disconnect();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            if (r6 != 0) {
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: Y */
    public static void m615Y(Context context, boolean z) {
        if (context == null) {
            Debugger.m8609e("SDocShareData", "setLastShareCompleted() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ShareService", 0).edit();
        editorEdit.putBoolean("ShareCompletedStatus", z);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: Z */
    public static void m616Z(long j) {
        C0145c.m310R("SDocLastSyncTime", "SDocLastSyncTimeKey", Long.toString(j));
    }

    /* JADX INFO: renamed from: a */
    public static CoeditMainListEntry m617a(Context context, MainListDocumentData mainListDocumentData, SyncNoteDataRepository syncNoteDataRepository, long j, int i) {
        SharedItem sharedItemByItemId;
        CoeditMainListEntry coeditMainListEntry = new CoeditMainListEntry();
        if (TextUtils.isEmpty(mainListDocumentData.getMdeGroupId())) {
            return null;
        }
        coeditMainListEntry.setMainListEntry(mainListDocumentData, i);
        coeditMainListEntry.setType(0);
        coeditMainListEntry.setAuthority("r/w");
        if (!TextUtils.isEmpty(mainListDocumentData.getMdeItemId()) && (sharedItemByItemId = SesCoeditShareReadResolver.getInstance().getSharedItemByItemId(context, mainListDocumentData.getMdeSpaceId(), mainListDocumentData.getMdeItemId())) != null) {
            coeditMainListEntry.setSocialServerChangePoint(AbstractC0291i.m572i(sharedItemByItemId.getMemo()));
        }
        coeditMainListEntry.setClientSavedChangePoint(syncNoteDataRepository.getCheckpoint(mainListDocumentData.getUuid()));
        if (coeditMainListEntry.isSnapShotUpdateRequired() && j != mainListDocumentData.getFirstOpenedAt()) {
            mainListDocumentData.setFirstOpenedAt(0L);
        }
        return coeditMainListEntry;
    }

    /* JADX INFO: renamed from: a0 */
    public static void m618a0(Context context, Boolean bool) {
        if (context == null) {
            Debugger.m8609e("SDocShareData", "setNeededToShare() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ShareService", 0).edit();
        editorEdit.putBoolean("NeedToShare", bool.booleanValue());
        editorEdit.apply();
        Debugger.m8607d("SDocShareData", "save as NeedToShare = " + Boolean.toString(bool.booleanValue()));
    }

    /* JADX INFO: renamed from: b */
    public static void m619b(String str, String str2) {
        try {
            C0145c.m308P(System.currentTimeMillis(), "pref_sync_sa_error_event_".concat(str2), str);
        } catch (Exception e) {
            Logger.m8702i("SyncSALoggingHelper", e.toString());
        }
    }

    /* JADX INFO: renamed from: b0 */
    public static void m620b0(String str) {
        C0145c.m310R("sync_v2_pref", "lastChangePoint", str);
    }

    /* JADX INFO: renamed from: c */
    public static void m621c(String str) {
        C0145c.m308P(System.currentTimeMillis(), "pref_sync_sa_logging_time", "5044".concat(str));
    }

    /* JADX INFO: renamed from: c0 */
    public static void m622c0(SyncNotificationReceiverActivity syncNotificationReceiverActivity) {
        String packageName = syncNotificationReceiverActivity.getPackageName();
        Debugger.m8607d("SyncPermissionHelper", "\t showDetailsSettingsDialog()");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + packageName));
        try {
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            if (syncNotificationReceiverActivity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                syncNotificationReceiverActivity.startActivity(intent);
            } else {
                Debugger.m8609e("SyncPermissionHelper", "\t Detail Settings Activity Not Found");
            }
        } catch (ActivityNotFoundException e) {
            Debugger.m8609e("SyncPermissionHelper", "fail to startActivity() : " + e.toString());
            Debugger.m8617s("SyncPermissionHelper", "\t ActivityNotFoundException : Permission Activity Open Failed : android.settings.APPLICATION_DETAILS_SETTINGS", e);
        } catch (SecurityException e2) {
            Debugger.m8609e("SyncPermissionHelper", "fail to startActivity() : " + e2.toString());
            Debugger.m8617s("SyncPermissionHelper", "\t SecurityException : Permission Activity Open Failed : android.settings.APPLICATION_DETAILS_SETTINGS", e2);
        }
    }

    /* JADX INFO: renamed from: d */
    public static synchronized void m623d(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SesSkipItemManagerPref", 0);
        if (sharedPreferences != null) {
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet("SesSkipItemManagerPref_Key_FileNames", new HashSet()));
            hashSet.add(str2 + str);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit != null) {
                editorEdit.putStringSet("SesSkipItemManagerPref_Key_FileNames", hashSet);
                editorEdit.apply();
            }
        }
    }

    /* JADX INFO: renamed from: d0 */
    public static ArrayList m624d0(List list, int i) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = (size / i) + (size % i == 0 ? 0 : 1);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * i;
            arrayList.add(list.subList(i5, Math.min(i5 + i, list.size())));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: e */
    public static void m625e(String str) {
        C0145c.m308P(System.currentTimeMillis(), "pref_sync_sa_logging_time", str);
    }

    /* JADX INFO: renamed from: e0 */
    public static void m626e0(C6903f c6903f, Context context, C0097a c0097a, C0112b c0112b) throws SyncException {
        Debugger.m8607d("NT$WDocServiceHelper", "upsyncSettings() start");
        StringBuilder sb = new StringBuilder();
        if (c0097a.f318a == 3) {
            sb.append("/samsungnotes/v3");
        } else {
            sb.append("/samsungnotes/v1");
        }
        sb.append("/settings");
        String strM15044b = C14434c.m15043a().m15044b(sb.toString());
        c6903f.m5131p("SU");
        C6861l c6861l = new C6861l(c6903f, context, c0097a);
        c6861l.f4309j = "upsyncSettings";
        c6861l.f4304e = strM15044b;
        C0026i c0026i = (C0026i) ((C13573a) c0112b.f363b).f9635b;
        LockUtilsContractImpl lockUtilsContractImpl = C0322h.m670a().f826l;
        Context context2 = (Context) c0112b.f362a;
        c0026i.f140a = lockUtilsContractImpl.getPasswordHash(context2);
        c0026i.f141b = C0322h.m670a().f826l.getPasswordSalt(context2);
        c0026i.f142c = C0145c.m328m(0L, "serverPassword", "serverPasswordKey");
        if (TextUtils.isEmpty(c0026i.f140a) || TextUtils.isEmpty(c0026i.f141b)) {
            Debugger.m8609e("UpSyncSettingsItem", "fillPassInfo() : invalid PasswordInfo!");
            throw new SyncException(326, "invalid PasswordInfo!");
        }
        try {
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            if (xmlSerializerNewSerializer == null) {
                throw new IllegalArgumentException("xmlSerializer is null.");
            }
            StringWriter stringWriter = new StringWriter();
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startTag("", "Settings");
            xmlSerializerNewSerializer.startTag("", "passcode");
            xmlSerializerNewSerializer.attribute("", "syncModifiedTime", Long.toString(c0026i.f142c));
            xmlSerializerNewSerializer.text(c0026i.f140a + "," + c0026i.f141b);
            xmlSerializerNewSerializer.endTag("", "passcode");
            xmlSerializerNewSerializer.endTag("", "Settings");
            xmlSerializerNewSerializer.endDocument();
            c6861l.f4303d = stringWriter.toString();
            c6861l.f4305f = "PATCH";
            C6865p c6865pM5040b = c6861l.m5033c().m5040b();
            c6903f.f4475c = null;
            if (c6865pM5040b.f4344a != 200) {
                m600J(context, c6865pM5040b);
            }
            Debugger.m8607d("NT$WDocServiceHelper", "upsyncSettings() finish");
        } catch (Exception e) {
            Debugger.m8609e("UpSyncSettingsItem", "toXml : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m627f(StringBuilder sb, String str, String str2, boolean z) throws SyncException {
        try {
            if (z) {
                if (TextUtils.isEmpty(str2)) {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                    sb.append('=');
                    return;
                } else {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    return;
                }
            }
            if (TextUtils.isEmpty(str2)) {
                sb.append(Typography.amp);
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append('=');
            } else {
                sb.append(Typography.amp);
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(str2, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            Debugger.m8617s("UriTool", AbstractC0541b.m774p("addUrlParameter - key : ", str, ", value : ", str2), e);
            throw new SyncException(303, e);
        } catch (NullPointerException e2) {
            Debugger.m8616s("UriTool", "NullPointerException : addUrlParameter - key : " + str + ", value : " + str2);
            throw new SyncException(303, e2);
        }
    }

    /* JADX INFO: renamed from: f0 */
    public static void m628f0(RandomAccessFile randomAccessFile, double d) throws IOException {
        m634i0(randomAccessFile, Double.doubleToLongBits(d));
    }

    /* JADX INFO: renamed from: g */
    public static void m629g(String str) {
        C0145c.m316a("pref_sync_sa_error_event_".concat(str));
    }

    /* JADX INFO: renamed from: g0 */
    public static void m630g0(RandomAccessFile randomAccessFile, float f) throws IOException {
        m632h0(randomAccessFile, Float.floatToIntBits(f));
    }

    /* JADX INFO: renamed from: h */
    public static boolean m631h(List list, List list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list != null && list2 != null && list.size() == list2.size()) {
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList(list2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    if ((next instanceof InterfaceC12017b) && (next2 instanceof InterfaceC12017b)) {
                        if (((InterfaceC12017b) next).isSame(next2)) {
                            it2.remove();
                            it.remove();
                        }
                    } else if (next.equals(next2)) {
                        it2.remove();
                        it.remove();
                    }
                }
                return false;
            }
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: h0 */
    public static void m632h0(RandomAccessFile randomAccessFile, int i) throws IOException {
        randomAccessFile.write(i & 255);
        randomAccessFile.write((i >> 8) & 255);
        randomAccessFile.write((i >> 16) & 255);
        randomAccessFile.write((i >> 24) & 255);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m633i(Map map, Map map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            Object obj3 = map2.get(obj);
            if (obj2 != null) {
                if ((obj2 instanceof InterfaceC12017b) && (obj3 instanceof InterfaceC12017b)) {
                    if (((InterfaceC12017b) obj2).isSame(obj3)) {
                    }
                } else if (obj2.equals(obj3)) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: i0 */
    public static void m634i0(RandomAccessFile randomAccessFile, long j) throws IOException {
        randomAccessFile.write(((int) j) & 255);
        randomAccessFile.write(((int) (j >> 8)) & 255);
        randomAccessFile.write(((int) (j >> 16)) & 255);
        randomAccessFile.write(((int) (j >> 24)) & 255);
        randomAccessFile.write(((int) (j >> 32)) & 255);
        randomAccessFile.write(((int) (j >> 40)) & 255);
        randomAccessFile.write(((int) (j >> 48)) & 255);
        randomAccessFile.write(((int) (j >> 56)) & 255);
    }

    /* JADX INFO: renamed from: j */
    public static boolean m635j(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return ((obj instanceof InterfaceC12017b) && (obj2 instanceof InterfaceC12017b)) ? ((InterfaceC12017b) obj).isSame(obj2) : obj.equals(obj2);
    }

    /* JADX INFO: renamed from: j0 */
    public static void m636j0(RandomAccessFile randomAccessFile, int i) throws IOException {
        randomAccessFile.write(i & 255);
        randomAccessFile.write((i >> 8) & 255);
    }

    /* JADX INFO: renamed from: k */
    public static int m637k(int i) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (i == 303) {
            if (applicationContext == null || !C0145c.m341z(applicationContext)) {
                return 101;
            }
            Debugger.m8609e("SyncErrorConvertUtil", "convertToSyncServiceServerError() : FAIL_HTTP -> ERROR_CODE_POWER_SAVING_MODE");
            m625e("5033");
            return 126;
        }
        if (i == 304 || i == 307) {
            return 201;
        }
        if (i == 321) {
            if (applicationContext == null || !C0145c.m341z(applicationContext)) {
                return 201;
            }
            Debugger.m8609e("SyncErrorConvertUtil", "convertToSyncServiceServerError() : FAIL_HTTP_TIMEOUT -> ERROR_CODE_POWER_SAVING_MODE");
            m625e("5033");
            return 126;
        }
        if (i == 340) {
            return 901;
        }
        if (i == 501) {
            return 201;
        }
        if (i == 600) {
            return 124;
        }
        if (i == 311) {
            return 100;
        }
        if (i == 312) {
            return 201;
        }
        if (i != 315) {
            if (i == 316) {
                return 900;
            }
            if (i != 323) {
                return i != 324 ? 1 : 108;
            }
            return 104;
        }
        if (applicationContext == null || !C0145c.m341z(applicationContext)) {
            return 201;
        }
        Debugger.m8609e("SyncErrorConvertUtil", "convertToSyncServiceServerError() : FAIL_SERVER_ERR -> ERROR_CODE_POWER_SAVING_MODE");
        m625e("5033");
        return 126;
    }

    /* JADX INFO: renamed from: k0 */
    public static void m638k0(RandomAccessFile randomAccessFile, String str) throws IOException {
        if (str.isEmpty()) {
            throw new IOException("writeStdString() - string is invalid");
        }
        randomAccessFile.write(str.getBytes());
    }

    /* JADX INFO: renamed from: l */
    public static int m639l(SyncException syncException) {
        int i;
        try {
            String message = syncException.getMessage();
            int iIndexOf = message.indexOf(58, message.indexOf("rcode")) + 1;
            i = Integer.parseInt(message.substring(iIndexOf, message.indexOf(44, iIndexOf)));
        } catch (Exception e) {
            Debugger.m8607d("SyncErrorConvertUtil", e.getMessage());
            i = 0;
        }
        if (i != 101901 && i != 101902 && i != 101903) {
            return 315;
        }
        Debugger.m8609e("SyncErrorConvertUtil", "convertToSyncServiceServerError() : server is blocked");
        return 324;
    }

    /* JADX INFO: renamed from: l0 */
    public static void m640l0(RandomAccessFile randomAccessFile, String str) throws IOException {
        if (str == null) {
            m636j0(randomAccessFile, -1);
            return;
        }
        if (str.isEmpty()) {
            m636j0(randomAccessFile, 0);
            return;
        }
        int length = str.length();
        m636j0(randomAccessFile, length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            randomAccessFile.write(cCharAt & 255);
            randomAccessFile.write((cCharAt >> '\b') & 255);
        }
    }

    /* JADX INFO: renamed from: m */
    public static int m641m(String str) {
        Map<String, ?> all = SharedPreferencesCompat.getInstance("pref_sync_sa_error_event_".concat(str)).getAll();
        if (all != null) {
            return all.size();
        }
        return 0;
    }

    /* JADX INFO: renamed from: m0 */
    public static void m642m0(RandomAccessFile randomAccessFile, String str) throws IOException {
        if (str == null) {
            m632h0(randomAccessFile, -1);
            return;
        }
        if (str.isEmpty()) {
            m632h0(randomAccessFile, 0);
            return;
        }
        int length = str.length();
        m632h0(randomAccessFile, length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            randomAccessFile.write(cCharAt & 255);
            randomAccessFile.write((cCharAt >> '\b') & 255);
        }
    }

    /* JADX INFO: renamed from: n */
    public static final void m643n(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m8697d(tag, msg);
    }

    /* JADX INFO: renamed from: o */
    public static void m644o(String str, String str2) {
        File file = new File(AbstractC0541b.m756B(str2, ".bak"));
        if (file.exists() && file.delete()) {
            Log.e(str, "Cannot delete backup file");
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m645p(C6903f c6903f, Context context, C0097a c0097a, C0073a c0073a) throws SyncException {
        Debugger.m8607d("NT$WDocServiceHelper", "downsyncSettings() start");
        StringBuilder sb = new StringBuilder();
        if (c0097a.f318a == 3) {
            sb.append("/samsungnotes/v3");
        } else {
            sb.append("/samsungnotes/v1");
        }
        sb.append("/settings");
        String strM15044b = C14434c.m15043a().m15044b(sb.toString());
        c6903f.m5131p("SD");
        C6861l c6861l = new C6861l(c6903f, context, c0097a);
        c6861l.f4309j = "downsyncSettings";
        c6861l.f4304e = strM15044b;
        c6861l.m5035e();
        C6865p c6865pM5034d = c6861l.m5034d();
        c6903f.f4475c = null;
        if (c6865pM5034d.f4344a == 200) {
            String str = c6865pM5034d.f4346c;
            try {
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                xmlPullParserNewPullParser.setInput(new StringReader(str));
                int eventType = xmlPullParserNewPullParser.getEventType();
                do {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xmlPullParserNewPullParser.getName();
                            if (!name.equalsIgnoreCase("Settings")) {
                                if (name.equalsIgnoreCase("passcode")) {
                                    c0073a.m205k(xmlPullParserNewPullParser);
                                } else if (!name.equalsIgnoreCase("sorting")) {
                                    Debugger.m8609e("DownSyncSettingsItem", "fromXMLString - invalid name = [" + name + "]");
                                }
                            }
                        } else if (eventType != 3 && eventType != 4) {
                            Debugger.m8615i("DownSyncSettingsItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                        }
                    }
                    eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                    if (eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("Settings")) {
                        break;
                    }
                } while (eventType != 1);
            } catch (Exception e) {
                Debugger.m8609e("DownSyncSettingsItem", "fromXMLString : " + e.getMessage());
                throw new SyncException(327, e.getMessage(), e);
            }
        } else {
            m600J(context, c6865pM5034d);
        }
        Debugger.m8607d("NT$WDocServiceHelper", "downsyncSettings() finish");
    }

    /* JADX INFO: renamed from: q */
    public static final void m646q(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m8698e(tag, msg);
    }

    /* JADX INFO: renamed from: r */
    public static final void m647r(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m8700f(tag, msg);
    }

    /* JADX INFO: renamed from: s */
    public static AuthApi m648s() throws ShareException {
        try {
            return new AuthApi(C6716p.m4809q().m4798f());
        } catch (NotAuthorizedException e) {
            String str = "NotAuthorizedException : " + e.getMessage();
            Debugger.m8609e("SesAuthApi", str);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
        } catch (NotConnectedException e2) {
            String str2 = "NotConnectedException : " + e2.getMessage();
            Debugger.m8609e("SesAuthApi", str2);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
        } catch (NotSupportedApiException e3) {
            String str3 = "NotSupportedApiException : " + e3.getMessage();
            Debugger.m8609e("SesAuthApi", str3);
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
        } catch (Exception e5) {
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [android.graphics.Bitmap$CompressFormat] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0049 -> B:32:0x005b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: t */
    public static byte[] m649t(String str) throws Throwable {
        FileInputStream fileInputStream;
        ?? r32;
        File file = new File(str);
        byte[] byteArray = new byte[1];
        ?? r33 = 0;
        FileInputStream fileInputStream2 = null;
        r33 = 0;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            }
        } catch (IOException e2) {
            Debugger.m8611e("GraphImageUtil", e2);
            r33 = r33;
        }
        try {
            try {
                ?? sb = new StringBuilder("getByte exist : ");
                sb.append(file.exists());
                MSLogger.m8632d("GraphImageUtil", sb.toString());
                ?? DecodeStream = BitmapFactory.decodeStream(fileInputStream);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    sb = Bitmap.CompressFormat.JPEG;
                    DecodeStream.compress(sb, 50, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                    DecodeStream.recycle();
                    r32 = sb;
                } catch (Exception e3) {
                    Debugger.m8611e("GraphImageUtil", e3);
                    r32 = sb;
                }
                fileInputStream.close();
                r33 = r32;
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                Debugger.m8611e("GraphImageUtil", e);
                r33 = fileInputStream2;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                    r33 = fileInputStream2;
                }
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            r33 = fileInputStream;
            if (r33 != 0) {
                try {
                    r33.close();
                } catch (IOException e6) {
                    Debugger.m8611e("GraphImageUtil", e6);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: u */
    public static long m650u(String str) {
        return C0145c.m328m(0L, "SyncControlCorruptedNote", str);
    }

    /* JADX INFO: renamed from: v */
    public static String m651v() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawColor(-1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bitmapCreateBitmap.recycle();
        try {
            return Base64Utils.encodeBase64(byteArrayOutputStream.toByteArray());
        } catch (UnsupportedEncodingException e) {
            MSLogger.m8633e("GraphImageUtil", "Failed to make empty encoded base64 string. " + e.getMessage());
            return "";
        }
    }

    /* JADX INFO: renamed from: w */
    public static final String m652w(String str) {
        return Logger.getEncode(str);
    }

    /* JADX INFO: renamed from: x */
    public static ArrayList m653x(ShareConstants$ResultCode shareConstants$ResultCode) {
        ArrayList arrayList = new ArrayList();
        switch (AbstractC0205b.f636a[shareConstants$ResultCode.ordinal()]) {
            case 1:
                arrayList.add(new C0204a("Session error!", 7));
                break;
            case 2:
                arrayList.add(new C0204a("Auth Error!", 3));
                break;
            case 3:
            case 4:
                arrayList.add(new C0204a(1024, "Fail to share!", 1));
                break;
            case 5:
                arrayList.add(new C0204a(1, "Not Enough Cloud Storage!", 4));
                break;
            case 6:
                arrayList.add(new C0204a(16, "Device storage is full!", 0));
                break;
            case 7:
                arrayList.add(new C0204a(4, "Network Error!", 2));
                break;
            case 8:
                arrayList.add(new C0204a(8, "Server Error!", 6));
                break;
            case 9:
                arrayList.add(new C0204a("Wifi Only Error!", 9));
                break;
            default:
                arrayList.add(new C0204a("Unknown share error!", 8));
                break;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: y */
    public static String m654y(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader;
        StringBuilder sb;
        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getErrorStream(), StandardCharsets.UTF_8);
        try {
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                sb = new StringBuilder();
            } catch (Exception e) {
                Debugger.m8611e("RequestHttpURLConnection", e);
                inputStreamReader.close();
                return "";
            }
        } catch (Throwable th) {
            inputStreamReader.close();
            throw th;
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                String string = sb.toString();
                inputStreamReader.close();
                return string;
            }
            sb.append(line);
            if (DeviceInfo.isEngMode()) {
                MSLogger.m8632d("RequestHttpURLConnection", "Response body : " + line);
            }
            inputStreamReader.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: z */
    public static File m655z(String str, String str2, String str3) throws IOException {
        if (str3 == null || str3.isEmpty()) {
            throw new IOException(str2.concat(" - filePath is invalid"));
        }
        File file = new File(str3);
        if (file.exists()) {
            return file;
        }
        Log.d(str, str2.concat(" - Fail to load data file. Try to load backup file"));
        File file2 = new File(str3.concat(".bak"));
        if (file2.exists()) {
            return file2;
        }
        throw new IOException(str2.concat(" - Fail to load data file"));
    }
}

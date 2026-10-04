package com.sec.android.diagmonagent.log.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.context.sdk.samsunganalytics.BuildConfig;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class newLogProvider extends ContentProvider {
    private static final String AGREED = "agreed";
    private static final String AUTHORITY_LIST = "authorityList";
    private static final String DEFAULT_SERVICE_NAME = "Samsung Software";
    private static final String DEVICE_ID = "deviceId";
    private static final String DEVICE_INFO = "deviceInfo";
    private static final String DIAGMON_PREFERENCES = "diagmon_preferences";
    private static final String DIAGMON_SUPPORT_V1_VERSION_CODE = "diagmonSupportV1VersionCode";
    private static final String DIAGMON_SUPPORT_V1_VERSION_NAME = "diagmonSupportV1VersionName";
    private static final String LOG_LIST = "logList";
    private static final String NONCE = "nonce";
    private static final String OPERATION_NOT_SUPPORTED = "Operation not supported";
    private static final String PLAIN_LOG_LIST = "plainLogList";
    private static final String PUSH_REGISTERED = "pushRegistered";
    private static final String REGISTERED = "registered";
    private static final String SERVICE_NAME = "serviceName";
    private static final String SUPPORT_PUSH = "supportPush";
    private static final String TRY_REGISTERING = "tryRegistering";
    private static final String UPLOAD_WIFIONLY = "uploadWifionly";
    private String AUTHORITY;
    private Bundle data;

    private Bundle getDiagmonSupportV1VersionCodeBundle() {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(DIAGMON_SUPPORT_V1_VERSION_CODE, BuildConfig.class.getDeclaredField("VERSION_CODE").getInt(null));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
        }
        return bundle;
    }

    private Bundle getDiagmonSupportV1VersionNameBundle() {
        Bundle bundle = new Bundle();
        try {
            Object obj = BuildConfig.class.getDeclaredField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                bundle.putString(DIAGMON_SUPPORT_V1_VERSION_NAME, (String) String.class.cast(obj));
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
        }
        return bundle;
    }

    private Bundle makeAuthorityListBundle(List<String> list) {
        Bundle bundle = new Bundle();
        for (String str : list) {
            bundle.putString(str, str);
        }
        return bundle;
    }

    private Bundle makeBundle(String str, String str2) {
        return AbstractC2821a.m2215f(str, str2);
    }

    private List<String> makeLogList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] fileArrListFiles = new File(str).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    arrayList.add(file.getPath());
                    AppLog.m13144w("found file : " + file.getPath());
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private String setDeviceId() {
        String twid = PackageInformation.getTWID();
        AbstractC2322a.m1609C("setDeviceId : ", twid, DiagMonUtil.TAG);
        return twid;
    }

    private Bundle setDeviceInfo() {
        return PackageInformation.instance.getDeviceInfoBundle(getContext());
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return "service_registration".equals(str) ? init(bundle) : "update_path".equals(str) ? setLogPath(str2) : "clear".equals(str) ? clear() : FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX.equals(str) ? set(str2, bundle) : (!"get".equals(str) || contains(str2) || this.data.getBundle(str2) == null) ? "get".equals(str) ? get(str2) : super.call(str, str2, bundle) : this.data.getBundle(str2);
    }

    public Bundle clear() {
        SharedPreferences.Editor editorEdit = getDiagMonSharedPreferences().edit();
        editorEdit.clear();
        editorEdit.apply();
        return Bundle.EMPTY;
    }

    public boolean contains(String str) {
        return getDiagMonSharedPreferences().contains(str);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new RuntimeException(OPERATION_NOT_SUPPORTED);
    }

    public Bundle get(String str) {
        SharedPreferences diagMonSharedPreferences = getDiagMonSharedPreferences();
        Bundle bundle = new Bundle();
        try {
            bundle.putBoolean(str, diagMonSharedPreferences.getBoolean(str, false));
        } catch (ClassCastException unused) {
        }
        try {
            bundle.putFloat(str, diagMonSharedPreferences.getFloat(str, 0.0f));
        } catch (ClassCastException unused2) {
        }
        try {
            bundle.putInt(str, diagMonSharedPreferences.getInt(str, 0));
        } catch (ClassCastException unused3) {
        }
        try {
            bundle.putLong(str, diagMonSharedPreferences.getLong(str, 0L));
        } catch (ClassCastException unused4) {
        }
        try {
            bundle.putString(str, diagMonSharedPreferences.getString(str, null));
        } catch (ClassCastException unused5) {
        }
        return bundle;
    }

    public SharedPreferences getDiagMonSharedPreferences() {
        return getContext().getSharedPreferences(DIAGMON_PREFERENCES, 0);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "text/plain";
    }

    public Bundle init(Bundle bundle) {
        String string = bundle.getString("serviceId", "");
        this.AUTHORITY = string;
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        this.data.putBundle(AUTHORITY_LIST, makeAuthorityListBundle(arrayList));
        String string2 = bundle.getString("deviceId", "");
        if (TextUtils.isEmpty(string2)) {
            string2 = setDeviceId();
        }
        this.data.putBundle("deviceId", makeBundle("deviceId", string2));
        this.data.putBundle(AGREED, makeBundle(AGREED, bundle.getBoolean(BundleContract.SERVICE_AGREE, false)));
        return Bundle.EMPTY;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new RuntimeException(OPERATION_NOT_SUPPORTED);
    }

    public Bundle makeLogListBundle(List<String> list) {
        Bundle bundle = new Bundle();
        for (String canonicalPath : list) {
            try {
                canonicalPath = new File(canonicalPath).getCanonicalPath();
            } catch (IOException unused) {
            }
            bundle.putParcelable(canonicalPath, new Uri.Builder().scheme("content").authority(this.AUTHORITY).path(canonicalPath).build());
        }
        return bundle;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.AUTHORITY = "";
        Bundle bundle = new Bundle();
        this.data = bundle;
        bundle.putBundle(DIAGMON_SUPPORT_V1_VERSION_NAME, getDiagmonSupportV1VersionNameBundle());
        this.data.putBundle(DIAGMON_SUPPORT_V1_VERSION_CODE, getDiagmonSupportV1VersionCodeBundle());
        this.data.putBundle(REGISTERED, makeBundle(REGISTERED, false));
        this.data.putBundle(PUSH_REGISTERED, makeBundle(PUSH_REGISTERED, false));
        this.data.putBundle(TRY_REGISTERING, makeBundle(TRY_REGISTERING, true));
        this.data.putBundle("nonce", makeBundle("nonce", ""));
        this.data.putBundle(UPLOAD_WIFIONLY, makeBundle(UPLOAD_WIFIONLY, true));
        this.data.putBundle(SUPPORT_PUSH, makeBundle(SUPPORT_PUSH, true));
        this.data.putBundle(DEVICE_INFO, setDeviceInfo());
        this.data.putBundle(SERVICE_NAME, makeBundle(SERVICE_NAME, DEFAULT_SERVICE_NAME));
        this.data.putBundle(AUTHORITY_LIST, makeAuthorityListBundle(new ArrayList()));
        this.data.putBundle("deviceId", makeBundle("deviceId", setDeviceId()));
        this.data.putBundle(LOG_LIST, makeLogListBundle(new ArrayList()));
        this.data.putBundle(PLAIN_LOG_LIST, makeLogListBundle(new ArrayList()));
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        String path = uri.getPath();
        if (this.data.getBundle(LOG_LIST) == null || this.data.getBundle(PLAIN_LOG_LIST) == null) {
            throw new RuntimeException("Data is corrupted");
        }
        if (this.data.getBundle(LOG_LIST).containsKey(path) || this.data.getBundle(PLAIN_LOG_LIST).containsKey(path)) {
            return openParcelFileDescriptor(path);
        }
        throw new FileNotFoundException();
    }

    public ParcelFileDescriptor openParcelFileDescriptor(String str) {
        return ParcelFileDescriptor.open(new File(str), 268435456);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new RuntimeException(OPERATION_NOT_SUPPORTED);
    }

    public Bundle set(String str, Bundle bundle) {
        SharedPreferences.Editor editorEdit = getDiagMonSharedPreferences().edit();
        Object obj = bundle.get(str);
        if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        }
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        }
        editorEdit.apply();
        return Bundle.EMPTY;
    }

    public Bundle setLogPath(String str) {
        this.data.putBundle(LOG_LIST, makeLogListBundle(makeLogList(str)));
        return Bundle.EMPTY;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new RuntimeException(OPERATION_NOT_SUPPORTED);
    }

    private Bundle makeBundle(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, z);
        return bundle;
    }
}

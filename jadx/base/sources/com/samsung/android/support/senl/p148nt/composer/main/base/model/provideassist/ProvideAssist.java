package com.samsung.android.support.senl.p148nt.composer.main.base.model.provideassist;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.util.EnvironmentUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ProvideAssist {
    private static final String ERROR_RESULT = "";
    private static final String PROVIDE_ASSIST_DATA_KEY = "file_metadata";
    private static final String PROVIDE_ASSIST_GOOGLE_SEARCH = "com.google.android.googlequicksearchbox";
    private static final String PROVIDE_ASSIST_PDF_NAME_KEY = "file_name";
    private static final String PROVIDE_ASSIST_PDF_TYPE_KEY = "mime_type";
    private static final String PROVIDE_ASSIST_PDF_URI_KEY = "file_uri";
    private static final String PROVIDE_ASSIST_WORK_PROFILE_KEY = "is_work_profile";
    private static final String TAG = "ProvideAssist";
    private PdfManager mPdfManager;
    private Uri mUri;

    @NonNull
    private static String getResultString(Context context, Uri uri, String str) {
        context.grantUriPermission(PROVIDE_ASSIST_GOOGLE_SEARCH, uri, 1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("file_uri", uri);
            jSONObject.put("mime_type", Constants.MIME_PDF);
            jSONObject.put("file_name", str);
            jSONObject.put(PROVIDE_ASSIST_WORK_PROFILE_KEY, EnvironmentUtils.isRunningUnderAndroidForWork(context));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PROVIDE_ASSIST_DATA_KEY, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            Logger.m11004w(TAG, "make json string - " + e.getMessage());
            return "";
        }
    }

    @NonNull
    public String build(@NonNull Context context) {
        Uri uri = this.mUri;
        if (uri == null) {
            Logger.m11004w(TAG, "build - failed, couldn't uri");
            return "";
        }
        String fileNameFromUri = FileUtils.getFileNameFromUri(context, uri);
        if (TextUtils.isEmpty(fileNameFromUri)) {
            Logger.m11004w(TAG, "build - failed, couldn't access file from uri");
            return "";
        }
        String filePathFromUri = UriFileUtils.getFilePathFromUri(context, this.mUri);
        PdfManager pdfManager = this.mPdfManager;
        if (pdfManager == null || pdfManager.isSecured(filePathFromUri)) {
            AbstractC8014b.m7222x(new StringBuilder("build - denied, secured file : "), this.mPdfManager == null, TAG);
            return "";
        }
        Logger.m10999d(TAG, "build completed");
        return getResultString(context, this.mUri, fileNameFromUri);
    }

    public ProvideAssist setPdfManager(@Nullable PdfManager pdfManager) {
        this.mPdfManager = pdfManager;
        return this;
    }

    public ProvideAssist setUri(@Nullable Uri uri) {
        this.mUri = uri;
        return this;
    }
}

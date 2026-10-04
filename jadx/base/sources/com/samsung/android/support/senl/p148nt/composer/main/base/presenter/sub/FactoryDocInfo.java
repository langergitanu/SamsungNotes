package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.io.File;
import java.util.regex.Pattern;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FactoryDocInfo {
    private static final String TAG = Logger.createTag("FactoryDocInfo");

    private DocInfo createByIntentAction(Activity activity, String str, String str2, String str3) throws Throwable {
        String sDocPathOnShare;
        DocInfo.OpenType openType = DocInfo.OpenType.None;
        if ("android.intent.action.VIEW".equals(str)) {
            sDocPathOnShare = NotesDataRepositoryFactory.newInstance(activity).createMainListDocumentDataRepository().getPath(str2);
            if (TextUtils.isEmpty(sDocPathOnShare)) {
                sDocPathOnShare = getSDocPathOnView(activity);
                if (sDocPathOnShare != null) {
                    DocInfo.ErrorType errorType = DocInfo.ErrorType.UnsupportedFileType;
                    if (sDocPathOnShare.equals(errorType.name())) {
                        return new DocInfo(openType, sDocPathOnShare, errorType, str2);
                    }
                }
            } else {
                String str4 = TAG;
                StringBuilder sbM16m = AbstractC0000a.m16m("createByIntentAction, action: ", str, " uuid : ", str2, " path = ");
                sbM16m.append(Logger.getEncode(str3));
                Logger.m11002f(str4, sbM16m.toString());
            }
            openType = DocInfo.OpenType.OpenByView;
        } else if ("android.intent.action.SEND".equals(str) || "android.intent.action.SEND_MULTIPLE".equals(str)) {
            sDocPathOnShare = getSDocPathOnShare(activity);
            openType = DocInfo.OpenType.OpenByShare;
        } else {
            sDocPathOnShare = null;
        }
        if (TextUtils.isEmpty(sDocPathOnShare)) {
            return null;
        }
        return new DocInfo(openType, sDocPathOnShare, str2);
    }

    private DocInfo createByNew(Activity activity, String str) {
        return new DocInfo(DocInfo.OpenType.New, makeNewSdocPath(activity), str);
    }

    private DocInfo createByOpen(Activity activity, String str) {
        String path = NotesDataRepositoryFactory.newInstance(activity).createMainListDocumentDataRepository().getPath(str);
        if (TextUtils.isEmpty(path)) {
            String str2 = TAG;
            Logger.m10999d(str2, "createByOpen# docPath is empty in getNoteFilePath.");
            String stringExtra = activity.getIntent().getStringExtra("doc_path");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(NotesDataRepositoryFactory.newInstance(activity).createDocumentDataRepository().getUuid(stringExtra))) {
                path = stringExtra;
            } else {
                Logger.m11002f(str2, "createByOpen, docPath is empty in getNoteFilePath.");
                path = null;
            }
        } else if (!FileUtils.exists(path)) {
            Logger.m11002f(TAG, "createByOpen# ins null, action: " + activity.getIntent().getAction() + " uuid : " + str + " path = " + Logger.getEncode(path));
            return null;
        }
        if (!TextUtils.isEmpty(path)) {
            return new DocInfo(DocInfo.OpenType.Open, path, str);
        }
        Logger.m10999d(TAG, "createByOpen# docPath is empty.");
        return createByNew(activity, str);
    }

    private String getPathFromMyFileIntent(Intent intent, Uri uri) {
        String stringExtra = intent.getStringExtra("AbsolutePath");
        if (stringExtra != null && stringExtra.length() > 0) {
            return stringExtra;
        }
        String path = uri.getPath();
        return (TextUtils.isEmpty(path) || !path.startsWith("/device_storage")) ? path : Pattern.compile("/device_storage", 16).matcher(path).replaceFirst(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    private String getSDocPathOnShare(Activity activity) throws Throwable {
        Intent intent = activity.getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        Uri uri = ("android.intent.action.SEND".equals(action) && !TextUtils.isEmpty(type) && type.startsWith(Constants.MIME_SDOC)) ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM") : (("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) && intent.hasExtra(Constants.EXTRA_DOC)) ? (Uri) intent.getParcelableExtra(Constants.EXTRA_DOC) : null;
        if (uri == null) {
            return "";
        }
        String pathFromUri = UriFileUtils.getPathFromUri(activity, uri);
        if (TextUtils.isEmpty(pathFromUri)) {
            return "";
        }
        if (new File(pathFromUri).canRead()) {
            return pathFromUri;
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(FileUtils.getDownloadDirWithFileSeparator(activity));
        sbM1324q.append(new File(pathFromUri).getName());
        String string = sbM1324q.toString();
        return UriFileUtils.saveUriToFile(activity, uri, string) ? string : "";
    }

    private String getSDocPathOnView(Activity activity) {
        Intent intent = activity.getIntent();
        Uri data = intent.getData();
        if (data == null) {
            return intent.getStringExtra("doc_path");
        }
        String authority = data.getAuthority();
        String pdfFilepath = (authority == null || !authority.contains(UriFileUtils.MY_FILES_PROVIDER)) ? Constants.MIME_PDF.equals(intent.getType()) ? UriFileUtils.getPdfFilepath(activity, data) : UriFileUtils.getPathFromUri(activity, data) : getPathFromMyFileIntent(intent, data);
        return (pdfFilepath == null || pdfFilepath.contains(".sdocx")) ? pdfFilepath : makeSavePathWithNoNote(activity, pdfFilepath);
    }

    private String makeNewSdocPath(Activity activity) {
        return WDocUtils.getNoteFilePath(activity) + System.currentTimeMillis() + ".sdocx";
    }

    private String makeSavePathWithNoNote(Activity activity, String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0 && Constants.PDF_EXTENSION.equals(str.substring(iLastIndexOf + 1).toLowerCase())) {
            return makeNewSdocPath(activity);
        }
        Logger.m11002f(TAG, "makeSavePathWithNoNote: " + Logger.getEncode(str));
        return DocInfo.ErrorType.UnsupportedFileType.name();
    }

    public DocInfo createByIntent(Activity activity) throws Throwable {
        String stringExtra = activity.getIntent().getStringExtra("sdoc_uuid");
        String action = activity.getIntent().getAction();
        String stringExtra2 = activity.getIntent().getStringExtra("doc_path");
        String str = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("createByIntent, action: ", action, " uuid : ", stringExtra, " path = ");
        sbM16m.append(Logger.getEncode(stringExtra2));
        Logger.m10999d(str, sbM16m.toString());
        DocInfo docInfoCreateByIntentAction = createByIntentAction(activity, action, stringExtra, stringExtra2);
        return docInfoCreateByIntentAction != null ? docInfoCreateByIntentAction : createByOpen(activity, stringExtra);
    }
}

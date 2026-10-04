package com.samsung.android.app.notes.sync.network;

import com.google.android.gms.drive.DriveFolder;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6841f {
    /* JADX INFO: renamed from: a */
    public static void m5005a(Drive drive, String str, String str2, String str3) throws Throwable {
        FileOutputStream fileOutputStream;
        String str4 = str3 + str;
        Debugger.m8607d("NT$NoteGoogleDriveHelper", "downloadFile() start");
        if (str2 != null && str2.length() > 0) {
            HttpRequest httpRequestBuildGetRequest = drive.getRequestFactory().buildGetRequest(new GenericUrl(str2));
            if (httpRequestBuildGetRequest == null) {
                throw new IOException("Fail to download a file");
            }
            httpRequestBuildGetRequest.setReadTimeout(0);
            HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
            File file = new File(str3);
            if (!file.isDirectory() && !file.mkdirs()) {
                Debugger.m8609e("NT$NoteGoogleDriveHelper", "Could not create directories!");
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    Debugger.m8607d("NT$NoteGoogleDriveHelper", "downloadFile() : try to create file = " + Logger.getEncode(str4));
                    fileOutputStream = new FileOutputStream(str4);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = httpResponseExecute.getContent().read(bArr);
                    if (i > 0) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            Debugger.m8609e("NT$NoteGoogleDriveHelper", e2.toString());
                        }
                    }
                }
                fileOutputStream.close();
            } catch (IOException e3) {
                e = e3;
                Debugger.m8609e("NT$NoteGoogleDriveHelper", "downloadFile() - IOException" + e.getMessage());
                throw e;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        Debugger.m8609e("NT$NoteGoogleDriveHelper", e5.toString());
                    }
                }
                throw th;
            }
        }
        Debugger.m8607d("NT$NoteGoogleDriveHelper", "downloadFile() finish");
    }

    /* JADX INFO: renamed from: b */
    public static void m5006b(Drive drive, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        String title;
        int length;
        Debugger.m8607d("NT$NoteGoogleDriveHelper", "downloadList()");
        Drive.Files.List q = drive.files().list().setQ("trashed = false and hidden = false");
        do {
            Debugger.m8607d("NT$NoteGoogleDriveHelper", "request.execute() start");
            FileList fileListExecute = q.execute();
            Debugger.m8607d("NT$NoteGoogleDriveHelper", "request.execute() end");
            if (fileListExecute == null) {
                Debugger.m8615i("NT$NoteGoogleDriveHelper", "files is null!");
            } else {
                List<com.google.api.services.drive.model.File> items = fileListExecute.getItems();
                Collections.sort(items, new NoteGoogleDriveHelper$TimeAscCompare());
                Debugger.m8607d("NT$NoteGoogleDriveHelper", "File count = " + items.size());
                for (com.google.api.services.drive.model.File file : items) {
                    Debugger.m8616s("NT$NoteGoogleDriveHelper", "File name = " + file.getTitle());
                    if (file.getParents().size() > 0) {
                        if (file.getMimeType().equals(Constants.MIME_SPD)) {
                            arrayList.add(file);
                        } else if (file.getMimeType().equals(CoeditServiceConstants.MimeType.NOTE_TYPE_FILE)) {
                            arrayList2.add(file);
                        } else if (file.getMimeType().equals(DriveFolder.MIME_TYPE)) {
                            Debugger.m8616s("NT$NoteGoogleDriveHelper", "This file is folder");
                            arrayList3.add(file);
                        } else if (file.getTitle() != null && (length = (title = file.getTitle()).length()) > 3) {
                            String strSubstring = title.substring(length - 3, length);
                            if (strSubstring.equalsIgnoreCase("spd")) {
                                arrayList.add(file);
                            } else if (strSubstring.equalsIgnoreCase("snb")) {
                                arrayList2.add(file);
                            }
                        }
                    }
                }
                q.setPageToken(fileListExecute.getNextPageToken());
            }
            if (q.getPageToken() == null) {
                break;
            }
        } while (q.getPageToken().length() > 0);
        Debugger.m8607d("NT$NoteGoogleDriveHelper", "SPD files count : " + arrayList.size());
        Debugger.m8607d("NT$NoteGoogleDriveHelper", "SNB files count : " + arrayList2.size());
    }
}

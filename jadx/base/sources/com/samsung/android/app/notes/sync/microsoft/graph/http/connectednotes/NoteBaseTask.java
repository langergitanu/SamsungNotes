package com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.lang3.time.TimeZones;
import p025F0.C0094i;
import p025F0.C0096k;
import p029G0.C0104a;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p079T.AbstractC0299q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class NoteBaseTask extends AsyncTask<Void, Void, C0124c> {
    private static final String TAG = "NoteBaseTask";
    private static final AbstractC6786a contentCreator = new C6787b();
    protected InterfaceC0122a callback;
    protected String contentType;
    protected C0094i data;
    protected String method;
    protected String url;
    protected String value;

    public NoteBaseTask(String str, String str2, String str3, @NonNull C0094i c0094i, InterfaceC0122a interfaceC0122a) {
        this.url = str;
        this.method = str2;
        this.contentType = str3;
        this.data = c0094i;
        this.callback = interfaceC0122a;
    }

    public JsonObject createJson() {
        JsonObject jsonObjectCreateJsonValueMain = createJsonValueMain();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(createJsonValueExtension());
        jsonObjectCreateJsonValueMain.add("extensions", jsonArray);
        return jsonObjectCreateJsonValueMain;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonObject createJsonValueExtension() throws Throwable {
        String str;
        String str2;
        AbstractC6786a abstractC6786a = contentCreator;
        C0094i c0094i = this.data;
        ((C6787b) abstractC6786a).getClass();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("@odata.type", "microsoft.graph.openTypeExtension");
        jsonObject.addProperty("extensionName", "Com.Samsung.Note");
        jsonObject.addProperty("uuid", c0094i.f306c);
        jsonObject.addProperty(GroupContract.Group.CREATED_TIME, String.valueOf(c0094i.f310g));
        long j = c0094i.f311h;
        jsonObject.addProperty(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME, String.valueOf(j));
        jsonObject.addProperty("serverTimestamp", String.valueOf(c0094i.f313j));
        if (c0094i.f312i) {
            jsonObject.addProperty("previewImage", AbstractC0299q.m651v());
        } else {
            AbstractC6784f.f4180a.getClass();
            Context applicationContext = BaseUtils.getApplicationContext();
            String str3 = c0094i.f306c;
            ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
            C0104a c0104a = new C0104a(applicationContext, NotesDatabaseManager.getInstance().getDocumentDao().getPath(str3), PageCacheUtils.createPageThumbnailCacheDirectory(applicationContext, str3, 600), 600, 1, true);
            ArrayList arrayList = (ArrayList) c0104a.m250d();
            if (arrayList.isEmpty()) {
                str2 = null;
                if (str2 != null) {
                    String strEncodeBase64 = "";
                    if (!str2.isEmpty()) {
                        try {
                            strEncodeBase64 = Base64Utils.encodeBase64(AbstractC0299q.m596F(str2));
                        } catch (Exception e) {
                            AbstractC6670b.m4753n(e, new StringBuilder("Failed to make encoded base64 string. "), "GraphImageUtil");
                        }
                    }
                    jsonObject.addProperty("previewImage", strEncodeBase64);
                    FileUtils.deleteFile(str2);
                } else {
                    jsonObject.addProperty("previewImage", AbstractC0299q.m651v());
                }
            } else {
                int iMin = Math.min(1, arrayList.size());
                if (c0104a.f340h == 0 || c0104a.f345m == 0) {
                    str = null;
                    MSLogger.m8633e("GraphImageUtil", "Failed to capture document width : " + c0104a.f340h + ", height : " + c0104a.f345m);
                } else {
                    long length = 0;
                    int i = 0;
                    int i2 = 0;
                    while (i < iMin) {
                        length += new File((String) arrayList.get(i)).length();
                        if (length > 2000000) {
                            break;
                        }
                        i2 = i + 1;
                        i = i2;
                    }
                    if (i2 != 0) {
                        int iMin2 = Math.min(i2, arrayList.size());
                        int iIntValue = i2 < arrayList.size() ? ((Integer) c0104a.f346n.get(i2)).intValue() : 0;
                        if (iIntValue == 0) {
                            iIntValue = c0104a.f345m;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0104a.f340h, iIntValue, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        for (int i4 = 0; i4 < iMin2; i4++) {
                            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile((String) arrayList.get(i4));
                            if (bitmapDecodeFile != null) {
                                canvas.drawBitmap(bitmapDecodeFile, 0.0f, ((Integer) c0104a.f346n.get(i4)).intValue(), (Paint) null);
                            }
                        }
                        str = null;
                        String strM249c = c0104a.m249c(str3, 0, c0104a.f340h, c0104a.f345m);
                        boolean zMakeJpg = ImageUtils.makeJpg(bitmapCreateBitmap, strM249c, 50, true);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            FileUtils.deleteFile((String) it.next());
                        }
                        if (zMakeJpg) {
                            str2 = strM249c;
                        }
                    }
                    if (str2 != null) {
                    }
                }
                str2 = str;
                if (str2 != null) {
                }
            }
        }
        jsonObject.addProperty("dataVersion", "2.0.1");
        MSLogger.m8632d("GraphTimeUtil", "convertToGraphTimeFormat, timestamp : " + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        String str4 = simpleDateFormat.format(new Date(j));
        MSLogger.m8632d("GraphTimeUtil", "convertToGraphTimeFormat, format ret : " + str4);
        jsonObject.addProperty("clientLastModifiedDateTime", str4);
        return jsonObject;
    }

    public JsonObject createJsonValueMain() {
        AbstractC6786a abstractC6786a = contentCreator;
        C0094i c0094i = this.data;
        ((C6787b) abstractC6786a).getClass();
        JsonObject jsonObject = new JsonObject();
        String str = c0094i.f307d;
        boolean z = c0094i.f314k;
        C0096k c0096k = c0094i.f309f;
        List list = c0094i.f308e;
        jsonObject.addProperty("subject", str);
        JsonObject jsonObject2 = new JsonObject();
        if (c0094i.f312i) {
            jsonObject2.addProperty("contentType", "text");
            jsonObject2.addProperty("content", "Locked Note");
        } else {
            if (c0096k != null) {
                jsonObject2.addProperty("contentType", "HTML");
                StringBuilder sb = new StringBuilder("<div style=\"background-color: ");
                sb.append(String.format("#%06X", Integer.valueOf(16777215 & c0096k.f317b)));
                sb.append("; width: 100%; object-fit: contain; display: block;\" >");
                if (list != null) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        sb.append("<img style=\"");
                        if (i != size - 1 && !z) {
                            sb.append("border-bottom: solid; border-bottom-color: grey;");
                        }
                        sb.append("width: 100%; object-fit: contain; display: block;\" src=\"cid:");
                        sb.append(FileUtils.extractFileName((String) list.get(i)));
                        sb.append("\"/>");
                    }
                }
                SpenObjectShape spenObjectShape = c0096k.f316a;
                String strReplaceAll = "";
                if (!TextUtils.isEmpty(spenObjectShape.getText())) {
                    Spanned spanned = (Spanned) new HandleTextBox().handleText(new HandleTextBox.InputBuilder(spenObjectShape).setConverter(C0096k.f315c).setAddTaskSpan(false).setMaxLength(30000).setClearSpace(true).done());
                    if (spenObjectShape.getText() != null && !spenObjectShape.getText().trim().replace("\n", "").isEmpty()) {
                        strReplaceAll = CharUtils.toHtml(spanned);
                    }
                }
                try {
                    strReplaceAll = strReplaceAll.replaceAll("(<br>\\n?\\r?){4,}", "<br><br><br>");
                } catch (PatternSyntaxException e) {
                    MSLogger.m8634e("HtmlContentCreator", "replaceAll failed ", e);
                }
                sb.append(strReplaceAll);
                sb.append("</div>");
                jsonObject2.addProperty("content", sb.toString());
            } else {
                jsonObject2.addProperty("contentType", "HTML");
                StringBuilder sb2 = new StringBuilder();
                if (list != null) {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        sb2.append("<img style=\"");
                        if (i2 != size2 - 1 && !z) {
                            sb2.append("border-bottom: solid; border-bottom-color: grey;");
                        }
                        sb2.append("width: 100%; object-fit: contain; display: block; src=\"cid:");
                        sb2.append(FileUtils.extractFileName((String) list.get(i2)));
                        sb2.append("\"/>");
                    }
                }
                jsonObject2.addProperty("content", sb2.toString());
            }
        }
        jsonObject.add("body", jsonObject2);
        MSLogger.m8632d("HtmlContentCreator", "createJsonValueMain finished ");
        return jsonObject;
    }

    @Override // android.os.AsyncTask
    public C0124c doInBackground(Void... voidArr) {
        MSLogger.m8632d(TAG, "doInBackground");
        this.value = createJson().toString();
        return AbstractC0299q.m614X(this.url, this.method, (String) C0112b.m261h().f363b, this.contentType, this.value);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(C0124c c0124c) {
        super.onPostExecute(c0124c);
        this.callback.mo252g(c0124c);
    }
}

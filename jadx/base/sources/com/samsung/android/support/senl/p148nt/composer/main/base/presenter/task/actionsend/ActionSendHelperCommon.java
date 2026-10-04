package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ActionSendHelperCommon {
    static final int ERROR_NONE = 0;
    private static final String TAG = Logger.createTag("ActionSendHelperCommon");
    final String mCachePath;
    final List<Content.Base> mContentList = new ArrayList();
    final List<Content.Base> mDownloadObjList = new ArrayList();
    final ArrayList<Callable<Boolean>> mCallableList = new ArrayList<>();

    public ActionSendHelperCommon(@NonNull String str) {
        this.mCachePath = str;
    }

    public void clear() {
        this.mContentList.clear();
        this.mDownloadObjList.clear();
        this.mCallableList.clear();
    }

    public ArrayList<Callable<Boolean>> getCallableList() {
        return this.mCallableList;
    }

    public List<Content.Base> getContentList() {
        return this.mContentList;
    }

    public List<Content.Base> getDownloadObjList() {
        return this.mDownloadObjList;
    }

    public String getSubject(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        Logger.m10999d(TAG, "getSubject");
        return TextUtils.isEmpty(stringExtra) ? "" : stringExtra;
    }

    public String getText(Intent intent) {
        String extraText = IntentParser.getExtraText(intent);
        Logger.m10999d(TAG, "getText# text.length:" + extraText.length());
        return IntentParser.removeUnicodeObj(extraText);
    }

    public abstract int handleIntent(Context context, Intent intent);

    public void removeContentInList(Content.Base base) {
        this.mDownloadObjList.remove(base);
        this.mContentList.remove(base);
    }
}

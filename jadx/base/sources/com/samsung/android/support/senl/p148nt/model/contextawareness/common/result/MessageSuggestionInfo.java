package com.samsung.android.support.senl.p148nt.model.contextawareness.common.result;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.CALogger;
import com.samsung.android.support.senl.p148nt.model.contextawareness.util.ResultGetter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MessageSuggestionInfo extends SuggestionInfo {
    private static final String COLUMN_NAME_AVATAR_URI = "avatar_uri";
    private static final String COLUMN_NAME_RECIPIENT_LIST = "recipient_list";
    private static final String COLUMN_NAME_SESSION_ID = "session_id";
    private static final String COLUMN_NAME_THREAD_ID = "thread_id";
    private static final String COLUMN_NAME_TITLE = "title";
    private static final String INTENT_DATA_URI_SCHEME = "smsto";
    private static final String INTENT_EXTRA_KEY_FROM_QUICK_NOTE = "from_quick_note";
    private static final String INTENT_EXTRA_KEY_SESSION_ID = "sessionId";
    private static final String INTENT_EXTRA_KEY_THREAD_ID = "threadId";
    private static final String TAG = CALogger.createTag("MessageSuggestionInfo");
    private Bitmap mAvatarImage;
    private Uri mAvatarUri;
    private String mQueriedTitle;
    private String mRecipientList;
    private String mSessionId;
    private long mThreadId;
    private Uri mUri;

    public MessageSuggestionInfo(SuggestionData suggestionData) {
        super(suggestionData);
    }

    private void setAdditionalInfo() {
        this.mPackageName = this.mIntent.getStringExtra("source");
        try {
            this.mAppIcon = ResultGetter.getAppIcon(BaseUtils.getApplicationContext(), this.mPackageName);
        } catch (PackageManager.NameNotFoundException unused) {
            setRepresentativeAppIcon();
        }
    }

    private void setAvatarInfo(Context context, Cursor cursor) {
        try {
            Uri uri = Uri.parse(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_AVATAR_URI)));
            this.mAvatarUri = uri;
            this.mAvatarImage = UriFileUtils.getBitmap(context, uri);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("setAvatarInfo# "), TAG);
        }
    }

    private void setQueriedTitle(Cursor cursor) {
        try {
            this.mQueriedTitle = cursor.getString(cursor.getColumnIndex("title"));
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("setQueriedTitle# "), TAG);
        }
    }

    private void setRecipientList(Cursor cursor) {
        try {
            this.mRecipientList = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_RECIPIENT_LIST));
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("setRecipientList# "), TAG);
        }
    }

    private void setSessionId(Cursor cursor) {
        try {
            this.mSessionId = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_SESSION_ID));
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("setSessionId# "), TAG);
        }
    }

    private void setThreadId(Cursor cursor) {
        try {
            this.mThreadId = cursor.getLong(cursor.getColumnIndex("thread_id"));
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("setThreadId# "), TAG);
        }
    }

    public Bitmap getAvatarImage() {
        return this.mAvatarImage;
    }

    public Uri getAvatarUri() {
        return this.mAvatarUri;
    }

    public String getIntentAction() {
        return "android.intent.action.SENDTO";
    }

    public Uri getIntentData() {
        return Uri.fromParts(INTENT_DATA_URI_SCHEME, this.mRecipientList, null);
    }

    public List<Pair<String, Boolean>> getIntentExtraBooleanValues() {
        return Collections.singletonList(new Pair(INTENT_EXTRA_KEY_FROM_QUICK_NOTE, Boolean.TRUE));
    }

    public List<Pair<String, Long>> getIntentExtraLongValues() {
        return Collections.singletonList(new Pair(INTENT_EXTRA_KEY_THREAD_ID, getThreadId()));
    }

    public List<Pair<String, String>> getIntentExtraStringValues() {
        ArrayList arrayList = new ArrayList();
        String sessionId = getSessionId();
        if (!TextUtils.isEmpty(sessionId)) {
            arrayList.add(new Pair(INTENT_EXTRA_KEY_SESSION_ID, sessionId));
        }
        return arrayList;
    }

    public String getQueriedTitle() {
        return this.mQueriedTitle;
    }

    public String getRecipientList() {
        return this.mRecipientList;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public Long getThreadId() {
        return Long.valueOf(this.mThreadId);
    }

    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public boolean isValidExecution() {
        return !TextUtils.isEmpty(this.mRecipientList) && this.mThreadId > 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo
    public void setSuggestionInfo() {
        Context applicationContext = BaseUtils.getApplicationContext();
        ContentResolver contentResolver = applicationContext.getContentResolver();
        Uri uri = Uri.parse(this.mIntent.getStringExtra("url"));
        this.mUri = uri;
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        setAvatarInfo(applicationContext, cursorQuery);
                        setQueriedTitle(cursorQuery);
                        setRecipientList(cursorQuery);
                        setThreadId(cursorQuery);
                        setSessionId(cursorQuery);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("setSuggestionInfo# "), TAG);
        }
        setAdditionalInfo();
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("MessageSuggestionInfo{mUri=");
        Uri uri = this.mUri;
        sb.append(uri != null ? uri.toString() : "");
        sb.append(", mQueriedTitle='");
        sb.append(this.mQueriedTitle);
        sb.append("', mRecipientList='");
        sb.append(this.mRecipientList);
        sb.append("', mThreadId=");
        sb.append(this.mThreadId);
        sb.append(", mSessionId=");
        return AbstractC1038a.m1213n('}', this.mSessionId, sb);
    }

    public MessageSuggestionInfo(Intent intent) {
        super(intent);
    }
}

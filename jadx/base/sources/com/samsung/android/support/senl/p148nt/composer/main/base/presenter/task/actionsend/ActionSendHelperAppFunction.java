package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionSendHelperAppFunction extends ActionSendHelperMultiple {
    public static final String AI_ACTION_UPDATE_EDITING_NOTE = "AI_ACTION_UPDATE_EDITING_NOTE";
    private static final String TAG = Logger.createTag("ActionSendHelperAppFunction");
    private final NotesDocEntityManager mEntityManager;
    private final TextManager mTextManager;

    public ActionSendHelperAppFunction(@NonNull String str, @NonNull TextManager textManager, @NonNull NotesDocEntityManager notesDocEntityManager) {
        super(str);
        this.mTextManager = textManager;
        this.mEntityManager = notesDocEntityManager;
    }

    private void handleFolder(Intent intent) {
        String stringExtra = intent.getStringExtra("category_id");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.mEntityManager.setFolderUuid(stringExtra);
    }

    private void handleImageUri(Context context, Intent intent) {
        String mimeType;
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri == null || (mimeType = UriFileUtils.getMimeType(context, uri)) == null) {
            return;
        }
        if (mimeType.startsWith(Constants.MIME_IMAGE_START) || mimeType.equals(Constants.MIME_IMAGE_DIR)) {
            makeImageContent(context, uri, mimeType);
        }
    }

    private void handleText(Intent intent) {
        this.mContentList.add(new Content.Text(getText(intent)));
    }

    private void handleTitle(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        Logger.m10999d(TAG, "handleTitle: " + Logger.getEncode(stringExtra));
        if (stringExtra == null) {
            return;
        }
        this.mTextManager.setTitle(Utils.extendedTrim(stringExtra));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperMultiple, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperCommon
    public int handleIntent(Context context, Intent intent) {
        handleFolder(intent);
        handleTitle(intent);
        handleText(intent);
        handleImageUri(context, intent);
        return 0;
    }
}

package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionManager {
    private static final String TAG = Logger.createTag("BixbyActionManager");

    public static void executeBixbyAction(Activity activity, BixbyContract bixbyContract) {
        executeBixbyAction(activity, activity.getIntent(), bixbyContract);
    }

    private static BixbyAction getAction(Intent intent) {
        String stringExtra = intent.getStringExtra(Bixby2Constants.BIXBY_ACTION);
        BixbyAction bixbyActionAddContent = null;
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        stringExtra.getClass();
        switch (stringExtra) {
            case "AddContentToEditingNote":
                bixbyActionAddContent = new BixbyActionAddContent(intent);
                break;
            case "CorrectSpellingNotePage":
                bixbyActionAddContent = new BixbyActionAi(5, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), 0, intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "ChangeNotePageFormatMeeting":
                bixbyActionAddContent = new BixbyActionAi(4, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), 0, intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "DeleteInNote":
                bixbyActionAddContent = new BixbyActionDelete();
                break;
            case "CreateNoteCover":
                bixbyActionAddContent = new BixbyActionAi(6, 0, 0, intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "SummarizeNotePage":
                bixbyActionAddContent = new BixbyActionAi(2, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), 0, intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "addAction":
                bixbyActionAddContent = new BixbyActionAi(0, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), 0, intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "ChangeNotePageFormatMultiLevelList":
                bixbyActionAddContent = new BixbyActionAi(3, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), 0, intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "SearchInNote":
                bixbyActionAddContent = new BixbyActionSearch(intent.getStringExtra(Bixby2Constants.BIXBY_PARAM_KEYWORD));
                break;
            case "ChangeTitle":
                bixbyActionAddContent = new BixbyActionEdit(intent.getStringExtra("title"));
                break;
            case "ChangeSpeechToText":
                bixbyActionAddContent = new BixbyActionAi(7, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_INDEX, 0), intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            case "ShareNote":
                bixbyActionAddContent = new BixbyActionShare(intent.getStringExtra(Bixby2Constants.BIXBY_ACTION_SHARE), intent.getStringExtra("packageName"), intent.getStringExtra(Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME));
                break;
            case "EditNote":
                bixbyActionAddContent = new BixbyActionEdit();
                break;
            case "TranslateNotePage":
                bixbyActionAddContent = new BixbyActionAi(1, intent.getIntExtra(Bixby2Constants.BIXBY_ACTION_ADD_ACTION, 0), intent.getStringExtra(Bixby2Constants.BIXBY_PARAM_TARGET_LANGUAGE_CODE), intent.getIntExtra(Bixby2Constants.BIXBY_PARAM_RANGE, 0));
                break;
            default:
                Logger.m11000e(TAG, "getAction# : unexpected action: ".concat(stringExtra));
                break;
        }
        intent.putExtra(Bixby2Constants.BIXBY_ACTION, "");
        return bixbyActionAddContent;
    }

    public static void executeBixbyAction(Activity activity, Intent intent, final BixbyContract bixbyContract) {
        final BixbyAction action = getAction(intent);
        if (action != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.bixby.BixbyActionManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        action.execute(bixbyContract);
                    } catch (Exception e) {
                        AbstractC8014b.m7207i("execute# : ", e, BixbyActionManager.TAG);
                    }
                }
            });
        }
    }
}

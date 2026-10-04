package com.samsung.android.support.senl.p148nt.app.trigger;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentType;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
class TriggerIntentHandler {
    private Intent getComposerIntentFromBuilder(Context context, Intent intent, String str, IntentUtil.ComposerIntentBuilder composerIntentBuilder) {
        composerIntentBuilder.setDocUuid(str).setViewAction().setMdeInfo(intent).setIsNewDoc(false).setComposerComponent(context);
        return composerIntentBuilder.build();
    }

    private boolean isOpenMemoIntent(String str) {
        return ComposerConstants.ACTION_OPEN_MEMO.equals(str);
    }

    private boolean isShareIntent(ClipData clipData, String str) {
        return ("android.intent.action.SEND".equals(str) || "android.intent.action.SEND_MULTIPLE".equals(str)) && clipData != null;
    }

    private boolean isWidgetIntent(String str) {
        return WidgetConstant.ACTION_MEMO_CONVERT.equals(str);
    }

    public Intent getOpenPDFIntent(Context context, Uri uri, String str, Intent intent) {
        return new IntentUtil.ComposerIntentBuilder(intent).addPdfUri(uri).addPdfPath(str).setComposerComponent(context).setViewAction().setOpenPDFFlags().build();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent getOpenPDFReaderIntent(Context context, Uri uri, Intent intent) {
        String str;
        IntentUtil.ComposerIntentBuilder pdfReaderComponent = new IntentUtil.ComposerIntentBuilder(intent).addPdfUriForReader(context, intent, uri).addPdfPath(intent.getStringExtra(ComposerConstants.ARG_PDF_OPEN_PATH)).setPdfReaderComponent(context);
        if (FeatureInfo.isOneTouchPdfTranslationOverlayEnabled()) {
            String action = intent.getAction();
            str = ComposerConstants.ACTION_TRANSLATE;
            if (!ComposerConstants.ACTION_TRANSLATE.equals(action)) {
                String action2 = intent.getAction();
                str = ComposerConstants.ACTION_SIMPLE_MODE;
                if (!ComposerConstants.ACTION_SIMPLE_MODE.equals(action2)) {
                    String action3 = intent.getAction();
                    str = ComposerConstants.ACTION_EDIT_MODE;
                    if (!ComposerConstants.ACTION_EDIT_MODE.equals(action3)) {
                        str = "android.intent.action.VIEW";
                    }
                }
            }
        }
        return pdfReaderComponent.setAction(str).setOpenPDFFlags().build();
    }

    public Intent getOpenTextIntent(Context context, Uri uri) {
        return new IntentUtil.ComposerIntentBuilder(new Intent()).setTextUir(uri).setComposerComponent(context).setViewAction().setOpenTextFlags().setIsNewDoc(true).build();
    }

    public Intent getStartComposerIntent(Context context, Intent intent, String str, boolean z) {
        IntentUtil.ComposerIntentBuilder docUuid = new IntentUtil.ComposerIntentBuilder(intent, ComposerConstants.ACTIVITY_FLAG_CALLEE).setDocUuid(str);
        String action = intent.getAction();
        String str2 = ComposerConstants.ACTION_SIMPLE_MODE;
        if (!ComposerConstants.ACTION_SIMPLE_MODE.equals(action)) {
            str2 = "android.intent.action.VIEW";
        }
        return docUuid.setAction(str2).setConverted(z).setDefaultFlags().addFlags(1).setComposerComponent(context).build();
    }

    public Intent getStartComposerIntentAfterUnlock(Context context, Intent intent) {
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, C13541h.m14287e().m14294h());
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.setComponent(new ComponentName(context, ComposerAccessHandler.getComposerActivityClass()));
        return intent;
    }

    public Intent getStartComposerIntentBeforeUnlock(Context context, Intent intent, String str) {
        return getComposerIntentFromBuilder(context, intent, str, new IntentUtil.ComposerIntentBuilder(new Intent()));
    }

    public Intent getStartComposerIntentForExistingDoc(Context context, Intent intent, String str) {
        return getComposerIntentFromBuilder(context, intent, str, new IntentUtil.ComposerIntentBuilder(new Intent(), ComposerConstants.ACTIVITY_FLAG_CALLEE));
    }

    public Intent getStartMemoListAndRequestComposerIntent(Context context, String str) {
        Intent intent = new Intent(context, NoteListAccessHandler.getNoteListClass());
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent.putExtra(Constants.MAIN_EXECUTION_COMPOSER_DOC_UUID, str);
        intent.putExtra(Constants.MAIN_EXECUTION_EDITOR_DOC_TYPE, DocumentType.SPEN_SDOCX);
        return intent;
    }

    public Intent getStartMemoListIntent(Context context) {
        Intent intent = new Intent(context, NoteListAccessHandler.getNoteListClass());
        intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        return intent;
    }

    public Intent getStartOldComposerIntent(Context context, Intent intent, String str, String str2) {
        return new IntentUtil.ComposerIntentBuilder(intent).setDocOldUuid(str).setDocPath(str2).setOldComposerComponent(context).setViewAction().addFlags(1).build();
    }

    public String getUuid(Intent intent) {
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("id");
            if (!TextUtils.isEmpty(stringExtra)) {
                intent.putExtra("sdoc_uuid", stringExtra);
            }
        }
        return stringExtra;
    }

    public boolean isValid(Intent intent) {
        String action = intent.getAction();
        return !((!"android.intent.action.VIEW".equals(action) && !ComposerConstants.ACTION_TRANSLATE.equals(action) && !ComposerConstants.ACTION_SIMPLE_MODE.equals(action) && !ComposerConstants.ACTION_EDIT_MODE.equals(action)) || intent.getData() == null || ShareFileProvider.isMyShareFileProvider(intent.getData())) || isShareIntent(intent.getClipData(), action) || isOpenMemoIntent(action) || isWidgetIntent(action);
    }
}

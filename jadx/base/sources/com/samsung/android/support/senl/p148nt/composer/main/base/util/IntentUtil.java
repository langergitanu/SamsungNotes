package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.OldComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class IntentUtil {
    private static final String TAG = Logger.createTag("IntentUtil");

    public static boolean startActivity(Context context, @Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "startActivity# ActivityNotFoundException " + e.getMessage());
            ToastHandler.show(context, context.getString(C9086R.string.composer_unable_to_perform_this_action), 0);
            return true;
        } catch (Exception e2) {
            Logger.m11001e(TAG, "startActivity# " + e2.getMessage(), e2);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ComposerIntentBuilder {
        private final Intent mIntent;

        public ComposerIntentBuilder(Intent intent) {
            this.mIntent = intent;
        }

        public ComposerIntentBuilder addFlags(int i) {
            this.mIntent.addFlags(i);
            return this;
        }

        public ComposerIntentBuilder addPdfPath(String str) {
            this.mIntent.putExtra(ComposerConstants.ARG_PDF_OPEN_PATH, str);
            return this;
        }

        public ComposerIntentBuilder addPdfUri(Uri uri) {
            this.mIntent.putExtra(ComposerConstants.ARG_PDF_OPEN_URI, uri);
            return this;
        }

        public ComposerIntentBuilder addPdfUriForReader(Context context, Intent intent, Uri uri) throws Throwable {
            this.mIntent.putExtra(ComposerConstants.ARG_PDF_OPEN_URI, uri);
            this.mIntent.putExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO, new PwFileManager().getPdfFileInfo(context, uri, intent.getStringExtra(PwFileManager.KEY_FILE_NAME_BY_MYFILES)));
            return this;
        }

        public Intent build() {
            return this.mIntent;
        }

        public ComposerIntentBuilder putExtra(String str, boolean z) {
            this.mIntent.putExtra(str, z);
            return this;
        }

        public ComposerIntentBuilder removeFlags(int i) {
            Intent intent = this.mIntent;
            intent.setFlags((~i) & intent.getFlags());
            return this;
        }

        public ComposerIntentBuilder setAction(String str) {
            this.mIntent.setAction(str);
            return this;
        }

        public ComposerIntentBuilder setComposerComponent(Context context) {
            if (ComposerAccessHandler.getComposerActivityClass() == null) {
                PostLaunchManager.getInstance().executeBaseLogic(1);
            }
            this.mIntent.setClass(context, ComposerAccessHandler.getComposerActivityClass());
            return this;
        }

        public ComposerIntentBuilder setConverted(boolean z) {
            this.mIntent.putExtra(ComposerConstants.ARG_IS_CONVERTED, z);
            return this;
        }

        public ComposerIntentBuilder setDefaultFlags() {
            Intent intent = this.mIntent;
            intent.setFlags(intent.getFlags() & (-16777217));
            this.mIntent.addFlags(470286336);
            return this;
        }

        public ComposerIntentBuilder setDocOldUuid(String str) {
            this.mIntent.putExtra(ComposerConstants.ARG_SDOC_OLD_UUID, str);
            return this;
        }

        public ComposerIntentBuilder setDocPath(String str) {
            this.mIntent.putExtra("doc_path", str);
            return this;
        }

        public ComposerIntentBuilder setDocUuid(String str) {
            this.mIntent.putExtra("sdoc_uuid", str);
            return this;
        }

        public ComposerIntentBuilder setIsNewDoc(boolean z) {
            this.mIntent.putExtra("new_doc", z);
            return this;
        }

        public ComposerIntentBuilder setMdeInfo(Intent intent) {
            String stringExtra = intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mIntent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, stringExtra);
                this.mIntent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, intent.getStringExtra(ComposerConstants.ARG_MDE_GROUP_ID));
                this.mIntent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, intent.getStringExtra(ComposerConstants.ARG_MDE_OWNER_ID));
                this.mIntent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, intent.getIntExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, 0));
            }
            return this;
        }

        public ComposerIntentBuilder setOldComposerComponent(Context context) {
            if (ComposerAccessHandler.getComposerActivityClass() == null) {
                PostLaunchManager.getInstance().executeBaseLogic(1);
            }
            this.mIntent.setClass(context, OldComposerActivity.class);
            return this;
        }

        public ComposerIntentBuilder setOpenPDFFlags() {
            Intent intent = this.mIntent;
            intent.setFlags(intent.getFlags() & (-4097));
            this.mIntent.addFlags(470286336);
            return this;
        }

        public ComposerIntentBuilder setOpenTextFlags() {
            Intent intent = this.mIntent;
            intent.setFlags(intent.getFlags() & (-4097));
            this.mIntent.addFlags(470286336);
            return this;
        }

        public ComposerIntentBuilder setPdfReaderComponent(Context context) {
            if (ComposerAccessHandler.getComposerActivityClass() == null) {
                PostLaunchManager.getInstance().executeBaseLogic(1);
            }
            this.mIntent.setClass(context, ComposerAccessHandler.getComposerPdfReaderClass());
            return this;
        }

        public ComposerIntentBuilder setTextUir(Uri uri) {
            this.mIntent.putExtra(ComposerConstants.ARG_TEXT_OPEN_URI, uri);
            return this;
        }

        public ComposerIntentBuilder setViewAction() {
            return setAction("android.intent.action.VIEW");
        }

        public ComposerIntentBuilder(Intent intent, int i) {
            this(intent);
            this.mIntent.setFlags(i);
        }
    }
}

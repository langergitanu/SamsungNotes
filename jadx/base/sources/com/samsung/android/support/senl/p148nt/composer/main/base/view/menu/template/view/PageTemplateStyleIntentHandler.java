package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.TemplateEditorActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageTemplateStyleIntentHandler {
    private static final String TAG = CTLogger.createTag("PageTemplateStyleIntentHandler");
    private int mPageHeight;
    private int mPageWidth;
    private ChangeTemplatesPresenter mPresenter;

    public PageTemplateStyleIntentHandler(ChangeTemplatesPresenter changeTemplatesPresenter) {
        this.mPresenter = changeTemplatesPresenter;
    }

    public void handleActivityResult(@Nullable Context context, int i, int i2, @Nullable Intent intent, boolean z) {
        if (context == null || intent == null) {
            Logger.m11003i(TAG, "handleResult# invalid, context/data : " + context + '/' + intent);
            return;
        }
        if (i == 1111 && i2 == -1 && intent.getData() != null) {
            this.mPresenter.downloadTemplateImage(intent.getData(), context, this.mPageWidth, this.mPageHeight);
            return;
        }
        if (i != 1112) {
            if (i == 1113 && i2 == -1) {
                List<Uri> uriListFromResult = ContentPickerUtils.getUriListFromResult(intent);
                if (uriListFromResult != null && !uriListFromResult.isEmpty()) {
                    this.mPresenter.downloadTemplatePdf(context, uriListFromResult.get(0), z);
                    return;
                }
                Logger.m11003i(TAG, "handleResult# getUriListFromResult is invalid , context/data : " + context + '/' + intent);
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_PATH);
        String stringExtra2 = intent.getStringExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_NEW_PATH);
        String stringExtra3 = intent.getStringExtra(TemplateConstants.TEMPLATE_EDITOR_IMAGE_NEW_NAME);
        if (i2 == -1) {
            String stringExtra4 = intent.getStringExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_MIME_TYPE);
            String str = !TextUtils.isEmpty(stringExtra2) ? stringExtra2 : stringExtra;
            this.mPresenter.insertTemplateImage(context, stringExtra3, str, stringExtra4, 3);
            this.mPresenter.selectTemplateImage(str);
            return;
        }
        if (i2 == 0) {
            if (TextUtils.isEmpty(stringExtra3) && TextUtils.isEmpty(stringExtra2)) {
                FileUtils.deleteFile(stringExtra);
            } else {
                Logger.m10999d(TAG, "handleActivityResult#, newName exists");
            }
        }
    }

    public void startImageChooser(Fragment fragment, int i, int i2) {
        if (fragment.getLifecycle().getState() == Lifecycle.State.STARTED || fragment.getLifecycle().getState() == Lifecycle.State.RESUMED) {
            this.mPageWidth = i;
            this.mPageHeight = i2;
            ContentPickerUtils.startImagePickerActivityForResult(fragment, 114, TemplateConstants.REQUEST_ACTION_CHOOSE_IMAGE);
        }
    }

    public void startPdfChooser(Fragment fragment) {
        if (fragment.getLifecycle().getState() == Lifecycle.State.STARTED || fragment.getLifecycle().getState() == Lifecycle.State.RESUMED) {
            ContentPickerUtils.startPdfPickerActivityForResult(fragment, 122, TemplateConstants.REQUEST_ACTION_CHOOSE_PDF, false, true, new Runnable[0]);
        }
    }

    public void startTemplateEditor(Fragment fragment, String str, String str2, int i, int i2, String str3) {
        if (fragment.getContext() == null) {
            return;
        }
        Intent intent = new Intent(fragment.getContext(), (Class<?>) TemplateEditorActivity.class);
        intent.putExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_PATH, str);
        intent.putExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_NEW_PATH, str3);
        intent.putExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_MIME_TYPE, str2);
        intent.putExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_WIDTH, i);
        intent.putExtra(TemplateConstants.TEMPLATE_EDITOR_IMG_HEIGHT, i2);
        fragment.startActivityForResult(intent, TemplateConstants.REQUEST_ACTION_TEMPLATE_EDITOR);
    }
}

package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.sdk.mobileservice.social.share.BundleKey;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareUriHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuReminder {
    private static final int MAX_REMINDER_TEXT_LENGTH = 1500;
    private static final String TAG = Logger.createTag("OptionMenuReminder");
    private static final String mReminderPackageName = "com.samsung.android.app.reminder";

    @Nullable
    private Uri convertBitmapToUri(Context context, Bitmap bitmap) {
        try {
            Uri shareContentsFileProviderUri = new ShareUriHelper(new ShareCacheHelper()).getShareContentsFileProviderUri(context, bitmap, (String) null);
            if (shareContentsFileProviderUri == null) {
                return shareContentsFileProviderUri;
            }
            context.grantUriPermission(mReminderPackageName, shareContentsFileProviderUri, 1);
            return shareContentsFileProviderUri;
        } catch (ShareException e) {
            Logger.m11000e(TAG, "convertBitmapToUri# " + e.getMessage());
            return null;
        }
    }

    private void setContent(Context context, Intent intent, SpenWNote spenWNote) {
        String str;
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        int size = pageList.size();
        SpenWPage spenWPage = null;
        int i = 0;
        while (i < size) {
            spenWPage = pageList.get(i);
            if (spenWPage.getObjectCount(false) > 0 || spenWPage.hasPDF()) {
                break;
            } else {
                i++;
            }
        }
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        if (i != size) {
            NoteCaptureControl noteCaptureControl = new NoteCaptureControl(context);
            noteCaptureControl.setWNote(spenWNote);
            noteCaptureControl.setContents(spenWPage, bodyText, i);
            Bitmap bitmapCaptureRect = spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE ? noteCaptureControl.captureRect(new RectF(0.0f, 0.0f, spenWNote.getWidth(), DocumentPageRatio.PAGE_RATIO.getHeight(spenWNote.getWidth()))) : noteCaptureControl.capturePage(1.0f);
            noteCaptureControl.close();
            intent.putExtra(BundleKey.THUMBNAIL_URI, convertBitmapToUri(context, bitmapCaptureRect));
            str = "image";
        } else {
            str = "text";
        }
        if (bodyText == null || TextUtils.isEmpty(bodyText.getText())) {
            setText(intent, spenWNote, "");
        } else {
            int length = bodyText.getText().length();
            if (length > 1500) {
                length = 1500;
            }
            setText(intent, spenWNote, new HandleTextBox().handleText(new HandleTextBox.InputBuilder(ObjectTextFactory.copyText(bodyText, 0, length - 1)).setClearSpace(true).setConverter(new HandleTextBox.ObjectSpanClearConverterImpl()).done()).toString());
        }
        intent.putExtra("type_detail", str);
    }

    private void setText(Intent intent, SpenWNote spenWNote, String str) {
        intent.putExtra("primary_text", spenWNote.getTitle().getText());
        if (str != null && str.length() >= 1500) {
            str = str.substring(0, 1499);
        }
        intent.putExtra("secondary_text", str);
    }

    public boolean isReminderPackageExistAndUsable(Context context) {
        PackageManagerCompat.Companion companion = PackageManagerCompat.INSTANCE;
        return !companion.getInstance().isKMemoPackage(context) && DeviceInfo.isSemDevice() && companion.getInstance().isPackageInstalled(context, mReminderPackageName, 120000000) && !DeviceUtils.isPowerManageMode(context);
    }

    public void sendReminderIntent(Activity activity, SpenWNote spenWNote, String str, MdeInfo mdeInfo, boolean z) {
        Intent intent = new Intent("com.samsung.android.app.reminder.action.REGISTER");
        intent.putExtra("type", Privacy.KEY_NOTES);
        intent.putExtra("isHandwriting", false);
        intent.putExtra("doc_type", "sdocx");
        if (z) {
            intent.putExtra("primary_text", spenWNote.getTitle().getText());
            intent.putExtra("secondary_text", activity.getString(C9086R.string.locked_note));
            intent.putExtra("type_detail", "text");
        } else {
            setContent(activity, intent, spenWNote);
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.samsung.android.app.notes", "com.samsung.android.app.notes.nativecomposer.NativeComposerReminderTriggerActivity");
        intent2.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent2.putExtra("sdoc_uuid", str);
        intent2.setFlags(335544320);
        if (mdeInfo != null && !TextUtils.isEmpty(mdeInfo.getSpaceId())) {
            intent2.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, mdeInfo.getSpaceId());
            intent2.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, mdeInfo.getGroupId());
            intent2.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, mdeInfo.getOwnerId());
            intent2.putExtra(ComposerConstants.ARG_MDE_WRITER, mdeInfo.getCreatorName());
            intent2.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, mdeInfo.getAccountType());
        }
        intent.putExtra("action", intent2);
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() < 80500) {
            intent.setClassName(mReminderPackageName, Build.VERSION.SDK_INT >= 29 ? "com.samsung.android.app.reminder.data.eventreceiver.ShareViaReceiver" : "com.samsung.android.app.reminder.eventreceiver.ShareViaReceiver");
            activity.sendBroadcast(intent);
        } else {
            intent.addFlags(268435456);
            intent.setClassName(mReminderPackageName, "com.samsung.android.app.reminder.externalui.ShareViaActivityDummy");
            activity.startActivity(intent);
        }
    }
}

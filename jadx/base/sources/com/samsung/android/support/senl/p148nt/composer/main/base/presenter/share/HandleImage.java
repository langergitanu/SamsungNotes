package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseHandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.util.ArrayList;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandleImage {
    private static final String TAG = Logger.createTag("HandleImage");

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markGenerativeEditImageByC2pa$0(String str, String str2, String str3, Rect rect) {
        ImageUtil.addGenerativeEditData(str);
        C2paHandler.getInstance().copyAndAppendC2paManifestTargetImage(str, str2, str3, rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markGenerativeEditImage(@NonNull SpenObjectBase spenObjectBase, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Rect rect) {
        if (ImageUtil.isGenerativeEditImage(spenObjectBase)) {
            ImageUtil.addGenerativeEditData(str);
            C2paHandler.getInstance().copyAndAppendC2paManifestTargetImage(str, str2, str3, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markGenerativeEditImageByC2pa(@NonNull SpenObjectBase spenObjectBase, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Rect rect) {
        C2paHandler.getInstance().executeForGenerativeImage(spenObjectBase, new RunnableC0218a(str, (Object) str2, (Object) str3, (Object) rect, 17));
    }

    public CharSequence handleImageType(Context context, ArrayList<Uri> arrayList, Uri uri, CharSequence charSequence, int i) {
        if (uri == null) {
            return charSequence;
        }
        ShareUtils.grantUriPermissionForChooser(context, uri);
        arrayList.add(uri);
        SpannableString spannableString = new SpannableString(" \n\n");
        spannableString.setSpan(new ImageSpan(context, ShareUtils.attachUserIdToAuthority(uri, i)), 0, 1, 33);
        return TextUtils.concat(charSequence, spannableString);
    }

    public String saveAsImage(SpenObjectBase spenObjectBase, String str, String str2) {
        return saveAsImage(spenObjectBase, str, str2, false);
    }

    @WorkerThread
    public String saveAsImage(SpenObjectBase spenObjectBase, String str, String str2, final boolean z) {
        return new BaseHandleImage(TAG, new BaseHandleImage.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.share.HandleImage.1
            @Override // com.samsung.android.support.senl.nt.base.composer.share.BaseHandleImage.Contract
            public void markGenerativeEditImage(@NonNull SpenObjectBase spenObjectBase2, @NonNull String str3, @NonNull String str4, @Nullable String str5, @Nullable Rect rect) {
                if (z) {
                    HandleImage.this.markGenerativeEditImageByC2pa(spenObjectBase2, str3, str4, str5, rect);
                } else {
                    HandleImage.this.markGenerativeEditImage(spenObjectBase2, str3, str4, str5, rect);
                }
            }
        }).saveAsImage(spenObjectBase, str, str2);
    }
}

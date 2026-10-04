package com.samsung.android.support.senl.p148nt.model.base.utils.data;

import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.WebCardDataBase;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenImageObjectTemp;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenMathObjectTemp;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.model.assist.common.C2paHandler;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Content {
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_HTML = 6;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_LINK_CARD = 4;
    public static final int TYPE_MATH = 7;
    public static final int TYPE_TEXT = 0;
    public static final int TYPE_WEB = 3;
    public static final int TYPE_WEB_CLIP = 5;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Audio extends DownloadAble {
        String mTitle;

        public Audio(Uri uri, @NonNull String str) {
            super(uri, str);
            this.mType = 2;
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            SpenObjectVoice spenObjectVoice = new SpenObjectVoice();
            String path = getPath();
            spenObjectVoice.setTitle(convertContract.getNewVoiceName(getTitle()));
            spenObjectVoice.setState(4);
            spenObjectVoice.attachFile(path);
            if (VoiceManager.isAddingValidated(spenObjectVoice)) {
                return spenObjectVoice;
            }
            return null;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public void setTitle(String str) {
            this.mTitle = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Base {
        protected int mError = 0;
        protected int mType;

        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            return null;
        }

        public int getError() {
            return this.mError;
        }

        public int getType() {
            return this.mType;
        }

        public void setError(int i) {
            this.mError = i | this.mError;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConvertContract {
        void appendText(CharSequence charSequence);

        String getNewVoiceName(String str);

        boolean isCoedit();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class DownloadAble extends Base {
        protected String mMimeType;
        protected String mPath;
        protected Uri mUri;

        public DownloadAble() {
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        @NonNull
        public String getPath() {
            return this.mPath;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public void setMimeType(String str) {
            this.mMimeType = str;
        }

        public void setPath(@NonNull String str) {
            this.mPath = str;
        }

        public DownloadAble(Uri uri, @NonNull String str) {
            this.mUri = uri;
            this.mPath = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HtmlContent extends Base {
        public List<SpenObjectBase> mObjectList;
        public List<SpenImageObjectTemp> mSpenImageObjectTemps = new ArrayList();
        public List<SpenMathObjectTemp> mSpenMathObjectTemps = new ArrayList();

        public HtmlContent(List<SpenObjectBase> list) {
            this.mType = 6;
            this.mObjectList = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Image extends DownloadAble {
        protected boolean mIsAIGenerated;
        protected String mOriginalPath;

        public Image(Uri uri, String str) {
            super(uri, str);
            this.mIsAIGenerated = false;
            this.mType = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$download$0(String str) {
            this.mIsAIGenerated = true;
            setOriginalPath(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$download$1(File file) {
            C2paHandler.getInstance().executeForGenerativeImage(file.getPath(), new C11417a(this, 0));
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            try {
                Logger.m8702i("Content.Image", "convertToSpenObject#, " + this.mMimeType + " / " + FileUtils.getFileExt(getPath()));
                SpenObjectImage spenObjectImage = new SpenObjectImage();
                spenObjectImage.setImage(getPath());
                return spenObjectImage;
            } catch (Exception e) {
                Logger.m8698e("Content.Image", "convertToSpenObject#, e : " + e.getMessage());
                return null;
            }
        }

        public boolean download(Context context) {
            if (!"application/octet-stream".equals(getMimeType()) && !DownloadBitmap.isValidImage(context, getUri())) {
                return false;
            }
            if (TextUtils.isEmpty(getMimeType()) || "application/octet-stream".equals(getMimeType())) {
                setMimeType(UriFileUtils.getMimeType(context, getUri()));
            }
            return DownloadBitmap.saveBitmapFromUri(context, this, new C11253j(this, 6));
        }

        public boolean downloadGif(Context context) {
            if ("application/octet-stream".equals(getMimeType()) || DownloadBitmap.isValidGif(context, getUri())) {
                return UriFileUtils.saveUriToFile(context, getUri(), getPath());
            }
            return false;
        }

        public String getOriginalPath() {
            return this.mOriginalPath;
        }

        public boolean isAIGenerated() {
            return this.mIsAIGenerated;
        }

        public void setOriginalPath(String str) {
            this.mOriginalPath = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkCard extends WebCard {
        private String mAction;
        private int mIconType;
        private final String mPackage;

        public LinkCard(String str, String str2, String str3, String str4) {
            super(str, str2);
            this.mPackage = str3;
            this.mAction = str4;
            this.mType = 4;
            this.mIconType = 0;
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.WebCard, com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            SpenObjectLink spenObjectLink = new SpenObjectLink();
            spenObjectLink.setPackageName(this.mPackage);
            spenObjectLink.setTitle(getTitle());
            spenObjectLink.setBody(getDescription() == null ? "" : getDescription());
            spenObjectLink.setOption(getUrl());
            spenObjectLink.setThumbnailPath(getPath());
            spenObjectLink.setIconType(this.mIconType);
            spenObjectLink.setViewType(0);
            spenObjectLink.setVersion(2);
            spenObjectLink.setAction(this.mAction);
            return spenObjectLink;
        }

        public String getAction() {
            return this.mAction;
        }

        public void setAction(String str) {
            this.mAction = str;
        }

        public void setLinkIconType() {
            this.mIconType = 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MathContent extends DownloadAble {
        private final String mLatex;
        private int mWidth = 0;
        private int mHeight = 0;

        public MathContent(String str) {
            this.mType = 7;
            this.mLatex = str;
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            SpenObjectImage spenObjectImage = new SpenObjectImage();
            spenObjectImage.setRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), false);
            spenObjectImage.setImage(this.mPath);
            return spenObjectImage;
        }

        public String getLatex() {
            return this.mLatex;
        }

        public boolean isInvalid() {
            return this.mWidth == 0 || this.mHeight == 0;
        }

        public void setSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Text extends Base {
        CharSequence mText;

        public Text(CharSequence charSequence) {
            this.mType = 0;
            this.mText = charSequence;
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            convertContract.appendText(getText());
            return null;
        }

        public String getString() {
            return this.mText.toString();
        }

        public CharSequence getText() {
            return this.mText;
        }

        public void setText(CharSequence charSequence) {
            this.mText = charSequence;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WebCard extends DownloadAble {
        Integer mBgColor;
        String mDescription;
        int mImageTypeId;
        boolean mIsFailed;
        String mTitle;
        String mUrl;

        public WebCard(String str, String str2) {
            this.mTitle = str;
            this.mUrl = str2;
            this.mType = 3;
        }

        private void initWebObject(SpenObjectWeb spenObjectWeb, boolean z) {
            if (z) {
                spenObjectWeb.setVersion(2);
                return;
            }
            spenObjectWeb.setVersion(3);
            spenObjectWeb.setViewType(2);
            if (isFailed()) {
                spenObjectWeb.setState(5);
                return;
            }
            if (this.mBgColor != null) {
                Logger.m8697d(Logger.createTag("WebCard"), "bgColor: ".concat(String.format("%08x", this.mBgColor)));
                spenObjectWeb.setBackgroundGradientColors(WebCardDataBase.makeGradientColorList(this.mBgColor.intValue()));
            } else if (TextUtils.isEmpty(getPath())) {
                Pair<Integer, Integer> dummyColorSet = WebCardDataBase.getDummyColorSet(BaseUtils.getContext());
                spenObjectWeb.setDummyThumbnailColors(dummyColorSet);
                spenObjectWeb.setBackgroundGradientColors(WebCardDataBase.makeGradientColorList(dummyColorSet.getSecond().intValue()));
            }
        }

        @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.Base
        public SpenObjectBase convertToSpenObject(ConvertContract convertContract) {
            SpenObjectWeb spenObjectWeb = new SpenObjectWeb();
            spenObjectWeb.setUri(getUrl());
            spenObjectWeb.setTitle(getTitle());
            spenObjectWeb.setBody(getDescription());
            spenObjectWeb.setThumbnailPath(getPath());
            spenObjectWeb.setImageTypeId(getImageTypeId());
            initWebObject(spenObjectWeb, convertContract != null && convertContract.isCoedit());
            return spenObjectWeb;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public int getImageTypeId() {
            return this.mImageTypeId;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public boolean isFailed() {
            return this.mIsFailed;
        }

        public void setBgColor(Integer num) {
            this.mBgColor = num;
        }

        public void setDescription(String str) {
            this.mDescription = str;
        }

        public void setFailed(boolean z) {
            this.mIsFailed = z;
        }

        public void setImageTypeId(int i) {
            this.mImageTypeId = i;
        }

        public void setTitle(String str) {
            this.mTitle = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WebClip extends Base {
        public final String mUrl;

        public WebClip(String str) {
            this.mUrl = str;
            this.mType = 5;
        }

        public String getUrl() {
            return this.mUrl;
        }
    }
}

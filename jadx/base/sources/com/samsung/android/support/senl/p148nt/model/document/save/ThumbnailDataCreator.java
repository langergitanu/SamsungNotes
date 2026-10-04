package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.samsung.android.ocr.C7212a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import p074R1.C0233e;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ThumbnailDataCreator {
    private static final String CONTENT_DIR = "/media";
    private static final float MAX_IMAGE_THUMBNAIL_RATIO = 2.0f;
    private static final int MIN_IMAGE_THUMBNAIL_HEIGHT_DP = 130;
    private static final String TAG = ModelLogger.createTag("ThumbnailDataCreator");
    private static float sMinImageHeightForThumbnail = 0.0f;
    private final int mEditedPageIndex;
    private final SpenWNote mNote;
    private final SpenWPage mPage;
    private final String mUuid;

    public ThumbnailDataCreator(@NonNull String str, @NonNull SpenWNote spenWNote, int i) {
        this.mUuid = str;
        this.mNote = spenWNote;
        this.mPage = spenWNote.getPage(i);
        this.mEditedPageIndex = i;
    }

    private SpenObjectImage checkBodyImageObject() {
        SpenObjectTextBox bodyText = this.mNote.getBodyText();
        int textSectionStart = bodyText.getTextSectionStart(this.mEditedPageIndex);
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = bodyText.findObjectSpan(textSectionStart, bodyText.getTextSectionLength(this.mEditedPageIndex) + textSectionStart);
        if (arrayListFindObjectSpan == null) {
            DataLogger.m12302d(TAG, "checkBodyImageObject, objectSpan is null");
            return null;
        }
        AtomicReference atomicReference = new AtomicReference();
        arrayListFindObjectSpan.stream().filter(new C0233e(8)).min(Comparator.comparingInt(new C7212a(1))).ifPresent(new C4191n(atomicReference, 18));
        return (SpenObjectImage) atomicReference.get();
    }

    private Pair<SpenObjectImage, Boolean> checkImageObject() {
        ArrayList<SpenObjectBase> objectList = this.mPage.getObjectList();
        boolean z = false;
        SpenObjectImage spenObjectImage = null;
        if (!objectList.isEmpty()) {
            Iterator<SpenObjectBase> it = objectList.iterator();
            SpenObjectImage spenObjectImage2 = null;
            while (true) {
                if (!it.hasNext()) {
                    spenObjectImage = spenObjectImage2;
                    break;
                }
                SpenObjectBase next = it.next();
                if (next.getType() != 3) {
                    z = true;
                    break;
                }
                if (spenObjectImage2 == null || Float.compare(spenObjectImage2.getRect().top, next.getRect().top) > 0) {
                    spenObjectImage2 = (SpenObjectImage) next;
                }
            }
        }
        return new Pair<>(spenObjectImage, Boolean.valueOf(z));
    }

    private String createTimeString(int i) {
        int i2 = i / 3600;
        int i4 = (i % 3600) / 60;
        int i5 = i % 60;
        return i2 == 0 ? String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    @NonNull
    private String getAudioPlayTime() {
        long j = 0;
        String playTime = "";
        for (SpenObjectVoice spenObjectVoice : new SpenWNoteObjectHelper().getSortedObjectList(this.mNote, 512)) {
            long appendTime = spenObjectVoice.getAppendTime();
            if (appendTime > j) {
                playTime = spenObjectVoice.getPlayTime();
                j = appendTime;
            }
        }
        return j > 0 ? createTimeString(Integer.parseInt(VoiceTimeDataUtils.convertPlayTime(playTime)) / 1000) : "";
    }

    @DataConstants.PageBackgroundType
    private int getBackgroundType() {
        int templateType = this.mPage.getTemplateType();
        if (templateType == 16) {
            return 2;
        }
        if (templateType != 0) {
            return 1;
        }
        return this.mPage.hasPDF() ? 3 : 0;
    }

    private static synchronized float getMinImageHeightForThumbnail(@NonNull Context context) {
        try {
            if (sMinImageHeightForThumbnail == 0.0f) {
                sMinImageHeightForThumbnail = ResourceUtils.convertDpToPixel(context, 130.0f);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sMinImageHeightForThumbnail;
    }

    @NonNull
    private String getVoiceRecordingPlayTime() {
        long recordingTime;
        ArrayList<SpenVoiceData> voiceDataList = this.mNote.getVoiceDataList();
        if (voiceDataList != null) {
            Iterator<SpenVoiceData> it = voiceDataList.iterator();
            recordingTime = 0;
            while (it.hasNext()) {
                recordingTime += it.next().getRecordingTime();
            }
        } else {
            recordingTime = 0;
        }
        return recordingTime > 0 ? createTimeString((int) (recordingTime / 1000)) : "";
    }

    private boolean isSuitableImageForThumbnail(@Nullable Bitmap bitmap, @NonNull RectF rectF) {
        return bitmap != null && bitmap.getWidth() > 0 && rectF.height() > getMinImageHeightForThumbnail(DataUtils.getContext()) && rectF.height() != 0.0f && Float.compare(rectF.width() / rectF.height(), 2.0f) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$checkBodyImageObject$0(SpenObjectSpan spenObjectSpan) {
        SpenObjectBase obj = spenObjectSpan.getObj();
        return obj != null && obj.getType() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkBodyImageObject$1(AtomicReference atomicReference, SpenObjectSpan spenObjectSpan) {
        atomicReference.set((SpenObjectImage) spenObjectSpan.getObj());
    }

    public DocumentThumbnailEntity createEntity() {
        Pair<SpenObjectImage, Boolean> pairCheckImageObject = checkImageObject();
        String str = TAG;
        DataLogger.m12302d(str, "createEntity, imageObject: " + pairCheckImageObject.first);
        SpenObjectImage spenObjectImageCheckBodyImageObject = pairCheckImageObject.first;
        boolean zBooleanValue = pairCheckImageObject.second.booleanValue();
        if (spenObjectImageCheckBodyImageObject == null && !zBooleanValue) {
            spenObjectImageCheckBodyImageObject = checkBodyImageObject();
            DataLogger.m12302d(str, "createEntity, bodyObject: " + spenObjectImageCheckBodyImageObject);
        }
        int i = this.mPage.getHeight() >= this.mPage.getWidth() ? 1 : 2;
        int backgroundType = getBackgroundType();
        String strSubstring = "";
        if (spenObjectImageCheckBodyImageObject != null && isSuitableImageForThumbnail(spenObjectImageCheckBodyImageObject.getImage(), spenObjectImageCheckBodyImageObject.getDrawnRect())) {
            String imagePath = spenObjectImageCheckBodyImageObject.getImagePath();
            if (imagePath.endsWith(".spi")) {
                imagePath = spenObjectImageCheckBodyImageObject.getOriginalImagePath();
                if (TextUtils.isEmpty(imagePath)) {
                    imagePath = "";
                }
            }
            int iLastIndexOf = imagePath.lastIndexOf(CONTENT_DIR);
            if (iLastIndexOf >= 0) {
                strSubstring = imagePath.substring(iLastIndexOf);
            } else {
                DataLogger.m12302d(str, "createEntity, wrong image path: " + DataLogger.getEncode(imagePath));
            }
        }
        return new DocumentThumbnailEntity(this.mUuid, backgroundType, i, strSubstring, getPlayTime());
    }

    @NonNull
    public String getPlayTime() {
        String voiceRecordingPlayTime = getVoiceRecordingPlayTime();
        return !voiceRecordingPlayTime.isEmpty() ? voiceRecordingPlayTime : getAudioPlayTime();
    }
}

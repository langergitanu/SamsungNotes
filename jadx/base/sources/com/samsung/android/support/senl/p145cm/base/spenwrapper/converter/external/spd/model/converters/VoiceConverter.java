package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/VoiceConverter;", "", "<init>", "()V", "runConverterVoiceData", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "filePath", "", "createTime", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$VoiceConverter";
    public static final long UNKNOWN_CREATE_TIME = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/VoiceConverter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "UNKNOWN_CREATE_TIME", "", "getPlayTime", "", "filePath", "createTimeString", "timeInSecond", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String createTimeString(int timeInSecond) {
            int i = timeInSecond / 3600;
            int i2 = (timeInSecond % 3600) / 60;
            int i4 = timeInSecond % 60;
            if (i == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(i2), Integer.valueOf(i4)}, 2, Locale.getDefault(), "%02d:%02d", "format(...)");
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)}, 3, Locale.getDefault(), "%02d:%02d:%02d", "format(...)");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getPlayTime(String filePath) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    MediaMetadataRetriever mediaMetadataRetriever2 = mediaMetadataRetriever;
                    mediaMetadataRetriever2.setDataSource(filePath);
                    String strExtractMetadata = mediaMetadataRetriever2.extractMetadata(9);
                    int i = strExtractMetadata != null ? Integer.parseInt(strExtractMetadata) : 0;
                    AutoCloseableKt.closeFinally(mediaMetadataRetriever, null);
                    return i;
                } finally {
                }
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7133e(VoiceConverter.TAG, "getPlayTime, e : " + e.getMessage());
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(filePath);
                    mediaPlayer.prepare();
                    int duration = mediaPlayer.getDuration();
                    mediaPlayer.release();
                    return duration;
                } catch (IOException unused) {
                    mediaPlayer.release();
                    return -1;
                } catch (Throwable th) {
                    mediaPlayer.release();
                    throw th;
                }
            }
        }

        private Companion() {
        }
    }

    public final boolean runConverterVoiceData(@Nullable SpenWNote wNote, @Nullable String filePath, long createTime) {
        String strM14139M;
        if (TextUtils.isEmpty(filePath)) {
            LoggerBase.INSTANCE.m7138w(TAG, "runConverterVoiceData fail : filePath is empty");
            return false;
        }
        ArrayList<SpenVoiceData> voiceDataList = wNote != null ? wNote.getVoiceDataList() : null;
        if (voiceDataList == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "runConverterVoiceData fail : invalid voiceDataList");
            return false;
        }
        SpenVoiceData spenVoiceDataMakeVoiceData = SpenObjectConstructor.makeVoiceData();
        if (createTime == -1) {
            createTime = System.currentTimeMillis();
        }
        spenVoiceDataMakeVoiceData.setCreationTime(createTime);
        int iM14130D = StringsKt.m14130D(String.valueOf(filePath), '/');
        int iM14130D2 = StringsKt.m14130D(String.valueOf(filePath), '.');
        if (iM14130D < 0 || iM14130D2 < 0) {
            strM14139M = "";
        } else {
            String strSubstring = String.valueOf(filePath).substring(iM14130D + 1, iM14130D2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            strM14139M = StringsKt.m14139M(strSubstring, ":", "_");
        }
        spenVoiceDataMakeVoiceData.setName(strM14139M);
        Companion companion = INSTANCE;
        int playTime = companion.getPlayTime(String.valueOf(filePath));
        spenVoiceDataMakeVoiceData.setPlayTime(companion.createTimeString(playTime / 1000));
        spenVoiceDataMakeVoiceData.setRecordingTime(playTime);
        spenVoiceDataMakeVoiceData.attachFile(filePath);
        if (Thread.interrupted()) {
            return false;
        }
        wNote.insertVoiceData(voiceDataList.size(), spenVoiceDataMakeVoiceData);
        return true;
    }
}

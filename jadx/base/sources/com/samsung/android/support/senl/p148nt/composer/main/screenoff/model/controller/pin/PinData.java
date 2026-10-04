package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.UriUtils;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u001a\u0010(\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u001a\u0010)\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u001a\u0010*\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u0010\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0005J\u0010\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0005J\u0006\u0010.\u001a\u00020\"J\u001c\u0010/\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00100\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00101\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u00102\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0003J \u00103\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u001a\u00107\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u00105\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b6\u0010\u000b¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/PinData;", "", "<init>", "()V", "mPinImageDirectory", "", "mPinUuid", "mPinNotePath", "value", Constants.IntentExtraName.PIN_IMAGE_PATH, "getPinImagePath", "()Ljava/lang/String;", "Landroid/net/Uri;", Constants.IntentExtraName.PIN_URI, "getPinUri", "()Landroid/net/Uri;", "", Constants.IntentExtraName.EDITED, "getEdited", "()Z", "mContentResolver", "Landroid/content/ContentResolver;", "init", "", "contentResolver", "internalCacheDir", "externalFilesDir", "pinUuid", "pinNotePath", "makePinData", "bitmap", "Landroid/graphics/Bitmap;", "savePinnedNoteData", "scrollPanY", "", "savePinnedNotePathData", "savePinnedNoteUriData", "loadPinnedLegacyNotePathByPath", "internalFilesDir", "path", "loadExistingPinnedLegacyNotePathByPath", "deleteExistingPinnedLegacyNoteByPath", "deleteExistingPinnedLegacyNoteByExceptedPath", "loadPinnedNoteUuidByUri", "uri", "loadPinnedNotePathByUri", "loadPinnedNoteScrollPanY", "deleteExistingPinnedDataByUri", "deleteExistingPinnedDataByExceptedUri", "deleteExistingPinnedDataByExceptedPath", "deleteExistingPinnedDataByExceptedUriInner", "replacePinnedNoteData", "uuid", "currentPinnedNoteUri", "getCurrentPinnedNoteUri", "saveBitmapToFile", "saveBitmapToUri", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPinData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PinData.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/PinData\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,370:1\n37#2:371\n36#2,3:372\n37#2:375\n36#2,3:376\n*S KotlinDebug\n*F\n+ 1 PinData.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/PinData\n*L\n199#1:371\n199#1:372,3\n216#1:375\n216#1:376,3\n*E\n"})
public final class PinData {

    @NotNull
    private static final String PIN_IMAGE_FILE_EXTENSION = ".jpg";

    @NotNull
    private static final String PIN_IMAGE_HIDDEN_DIRECTORY = ".screenoff_pin";

    @NotNull
    private static final String PIN_LEGACY_SAVE_HIDDEN_DIRECTORY = ".screenoff_pin";
    private boolean edited;

    @Nullable
    private ContentResolver mContentResolver;

    @Nullable
    private String mPinImageDirectory;

    @Nullable
    private String mPinNotePath;

    @Nullable
    private String mPinUuid;

    @Nullable
    private String pinImagePath;

    @NotNull
    private Uri pinUri;

    @NotNull
    private static final String TAG = SOLogger.createTag("PinData");

    public PinData() {
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        this.pinUri = EMPTY;
    }

    private final void deleteExistingPinnedDataByExceptedPath(String uri) {
        String strFindFileExcept = FileUtils.INSTANCE.findFileExcept(this.mPinImageDirectory, String.valueOf(uri));
        String strLoadPinnedNoteUuidByUri = loadPinnedNoteUuidByUri(strFindFileExcept);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        String encode = Logger.getEncode(uri);
        String encode2 = Logger.getEncode(strFindFileExcept);
        String encode3 = Logger.getEncode(strLoadPinnedNoteUuidByUri);
        StringBuilder sbM16m = AbstractC0000a.m16m("deleteExistingPinnedDataByExceptedPath# uri/exceptedPath/pinUuid ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str, sbM16m.toString());
        FileUtils.deleteFile$default(strFindFileExcept, false, 2, null);
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(strFindFileExcept);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(strLoadPinnedNoteUuidByUri);
    }

    @RequiresApi(29)
    private final void deleteExistingPinnedDataByExceptedUriInner(String uri) {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        String strLoadPinnedNoteUuidByUri = "";
        String string = companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(Constants.Preference.PREF_KEY_PINNED_URI, "");
        if (!Intrinsics.areEqual(uri, string)) {
            strLoadPinnedNoteUuidByUri = loadPinnedNoteUuidByUri(string);
            UriUtils.INSTANCE.deleteUri(this.mContentResolver, string);
            companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(string);
            companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(strLoadPinnedNoteUuidByUri);
            companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(Constants.Preference.PREF_KEY_PINNED_URI);
            companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(Constants.Preference.PREF_KEY_PINNED_NOTE_SCROLL_PAN_Y);
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        String encode = Logger.getEncode(uri);
        String encode2 = Logger.getEncode(strLoadPinnedNoteUuidByUri);
        String encode3 = Logger.getEncode(string);
        StringBuilder sbM16m = AbstractC0000a.m16m("deleteExistingPinnedDataByExceptedUriInner# uri/pinUuid/pinnedUri ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerF(str, sbM16m.toString());
    }

    private final void saveBitmapToFile(Bitmap bitmap, String path) {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        AbstractC8014b.m7208j("saveBitmapToFile# ", Logger.getEncode(path), sOLogger, str);
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        File file = new File(path);
        try {
            try {
                fileOutputStream = file.createNewFile() ? new FileOutputStream(file) : null;
                if (fileOutputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                    sOLogger.SOLoggerD(str, "saveBitmapToFile# success");
                }
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        AbstractC0000a.m24u("saveBitmapToFile# IOException ", e.getMessage(), SOLogger.INSTANCE, TAG);
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "saveBitmapToFile# getMessage " + e2.getMessage());
            if (fileOutputStream == null) {
                return;
            }
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            AbstractC0000a.m24u("saveBitmapToFile# IOException ", e3.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    @RequiresApi(29)
    private final void saveBitmapToUri(Bitmap bitmap) {
        this.pinUri = UriUtils.INSTANCE.saveBitmapToUri(this.mContentResolver, this.mPinUuid, bitmap);
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("saveBitmapToUri# mPinUuid/mPinUri ", Logger.getEncode(this.mPinUuid), "/", Logger.getEncode(this.pinUri.toString())));
    }

    private final void savePinnedNotePathData() {
        String strM757C = AbstractC0541b.m757C(this.mPinUuid, "|", this.mPinNotePath);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        String encode = Logger.getEncode(this.pinImagePath);
        String encode2 = Logger.getEncode(this.mPinUuid);
        String encode3 = Logger.getEncode(this.mPinNotePath);
        StringBuilder sbM16m = AbstractC0000a.m16m("savePinnedNotePathData# pinImagePath/pinUuid/pinNotePath ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str, sbM16m.toString());
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(this.pinImagePath, strM757C);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(this.mPinUuid, this.mPinNotePath);
    }

    private final void savePinnedNoteUriData(float scrollPanY) {
        String strM757C = AbstractC0541b.m757C(this.mPinUuid, "|", this.mPinNotePath);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        String encode = Logger.getEncode(this.pinUri.toString());
        String encode2 = Logger.getEncode(this.mPinUuid);
        String encode3 = Logger.getEncode(this.mPinNotePath);
        StringBuilder sbM16m = AbstractC0000a.m16m("savePinnedNoteUriData# pinUri/pinUuid/pinNotePath/scrollPanY ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sbM16m.append("/");
        sbM16m.append(scrollPanY);
        sOLogger.SOLoggerD(str, sbM16m.toString());
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(this.pinUri.toString(), strM757C);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(this.mPinUuid, this.mPinNotePath);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_PINNED_URI, this.pinUri.toString());
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putFloat(Constants.Preference.PREF_KEY_PINNED_NOTE_SCROLL_PAN_Y, scrollPanY);
    }

    @RequiresApi(29)
    public final void deleteExistingPinnedDataByExceptedUri(@Nullable String uri) {
        AbstractC8014b.m7208j("deleteExistingPinnedDataByExceptedUri# uri ", Logger.getEncode(uri), SOLogger.INSTANCE, TAG);
        if (UriUtils.INSTANCE.isUriForm(uri)) {
            deleteExistingPinnedDataByExceptedUriInner(uri);
        } else {
            deleteExistingPinnedDataByExceptedPath(uri);
        }
    }

    @RequiresApi(29)
    public final void deleteExistingPinnedDataByUri(@Nullable ContentResolver contentResolver, @Nullable String uri) {
        String strLoadPinnedNoteUuidByUri = loadPinnedNoteUuidByUri(uri);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("deleteExistingPinnedDataByUri# uri/pinUuid ", Logger.getEncode(uri), "/", Logger.getEncode(strLoadPinnedNoteUuidByUri)));
        if (TextUtils.isEmpty(strLoadPinnedNoteUuidByUri)) {
            sOLogger.SOLoggerD(str, "deleteExistingPinnedDataByUri# invalid uri!");
            return;
        }
        UriUtils uriUtils = UriUtils.INSTANCE;
        if (uriUtils.isUriForm(uri)) {
            uriUtils.deleteUri(contentResolver, uri);
        } else {
            FileUtils.deleteFile$default(String.valueOf(uri), false, 2, null);
        }
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(uri);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(strLoadPinnedNoteUuidByUri);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(Constants.Preference.PREF_KEY_PINNED_URI);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(Constants.Preference.PREF_KEY_PINNED_NOTE_SCROLL_PAN_Y);
    }

    public final void deleteExistingPinnedLegacyNoteByExceptedPath(@Nullable String internalFilesDir, @Nullable String path) {
        String str = File.separator;
        String strM2221l = AbstractC2821a.m2221l(internalFilesDir, str, ".screenoff_pin", str);
        FileUtils fileUtils = FileUtils.INSTANCE;
        String strFindFileExcept = fileUtils.findFileExcept(this.mPinImageDirectory, FileUtils.extractFileName(String.valueOf(path)));
        String strFindFileExcept2 = fileUtils.findFileExcept(strM2221l, FileUtils.extractFileName(String.valueOf(path)));
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str2 = TAG;
        String encode = Logger.getEncode(path);
        String encode2 = Logger.getEncode(strM2221l);
        sOLogger.SOLoggerD(str2, AbstractC2322a.m1626p(AbstractC0000a.m16m("deleteExistingPinnedLegacyNoteByExceptedPath# path/pinLegacySavePath/legacyImagePath/legacyNotePath ", encode, "/", encode2, "/"), Logger.getEncode(strFindFileExcept), "/", Logger.getEncode(strFindFileExcept2)));
        FileUtils.deleteFile$default(strFindFileExcept, false, 2, null);
        FileUtils.deleteFile$default(strFindFileExcept2, false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:3:0x0038, B:9:0x0042, B:11:0x0052, B:13:0x005b, B:15:0x0068, B:14:0x0063), top: B:19:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void deleteExistingPinnedLegacyNoteByPath(@Nullable String internalFilesDir, @Nullable String path) {
        String str = File.separator;
        String strM2221l = AbstractC2821a.m2221l(internalFilesDir, str, ".screenoff_pin", str);
        String strFindFile = FileUtils.INSTANCE.findFile(strM2221l, FileUtils.extractFileName(String.valueOf(path)));
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str2 = TAG;
        String encode = Logger.getEncode(path);
        String encode2 = Logger.getEncode(strM2221l);
        String encode3 = Logger.getEncode(strFindFile);
        StringBuilder sbM16m = AbstractC0000a.m16m("deleteExistingPinnedLegacyNoteByPath# path/pinLegacySavePath/legacyNotePath ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str2, sbM16m.toString());
        try {
            String canonicalPath = new File(path == null ? "" : path).getCanonicalPath();
            if (!TextUtils.isEmpty(canonicalPath)) {
                Intrinsics.checkNotNull(canonicalPath);
                if (StringsKt.m14145S(canonicalPath, strM2221l)) {
                    FileUtils.deleteFile$default(String.valueOf(path), false, 2, null);
                } else {
                    sOLogger.SOLoggerD(str2, "deleteExistingPinnedLegacyNoteByPath# invalid path !");
                }
            }
            FileUtils.deleteFile$default(strFindFile, false, 2, null);
        } catch (Exception e) {
            AbstractC0000a.m24u("deleteExistingPinnedLegacyNoteByPath# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
    }

    @Nullable
    public final String getCurrentPinnedNoteUri() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(Constants.Preference.PREF_KEY_PINNED_URI, "");
    }

    public final boolean getEdited() {
        return this.edited;
    }

    @Nullable
    public final String getPinImagePath() {
        return this.pinImagePath;
    }

    @NotNull
    public final Uri getPinUri() {
        return this.pinUri;
    }

    public final void init(@Nullable ContentResolver contentResolver, @Nullable String internalCacheDir, @NotNull String externalFilesDir, @Nullable String pinUuid, @Nullable String pinNotePath) {
        Intrinsics.checkNotNullParameter(externalFilesDir, "externalFilesDir");
        this.mContentResolver = contentResolver;
        String str = File.separator;
        String str2 = externalFilesDir + str + ".screenoff_pin" + str;
        FileUtils.makeDirectory(str2);
        this.mPinUuid = pinUuid;
        this.mPinNotePath = pinNotePath;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str3 = TAG;
        String encode = Logger.getEncode(str2);
        String encode2 = Logger.getEncode(this.mPinUuid);
        String encode3 = Logger.getEncode(this.mPinNotePath);
        StringBuilder sbM16m = AbstractC0000a.m16m("init# path/pinUuid/pinNotePath ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str3, sbM16m.toString());
        if (!DeviceInfo.isUserMode() && internalCacheDir != null) {
            FileUtils.printDirectory(str2, "_screenoff", false);
            FileUtils.printDirectory(internalCacheDir + str + DocumentServiceConstants.Cache.CACHE_DIR, "_screenoff", false);
        }
        this.mPinImageDirectory = str2;
    }

    @NotNull
    public final String loadExistingPinnedLegacyNotePathByPath(@Nullable String internalFilesDir, @Nullable String path) {
        String str = File.separator;
        String strM2221l = AbstractC2821a.m2221l(internalFilesDir, str, ".screenoff_pin", str);
        String strFindFileExcept = FileUtils.INSTANCE.findFileExcept(strM2221l, FileUtils.extractFileName(String.valueOf(path)));
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str2 = TAG;
        String encode = Logger.getEncode(path);
        String encode2 = Logger.getEncode(strM2221l);
        String encode3 = Logger.getEncode(strFindFileExcept);
        StringBuilder sbM16m = AbstractC0000a.m16m("loadExistingPinnedLegacyNotePathByPath# path/pinLegacySavePath/legacyNotePath ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str2, sbM16m.toString());
        return strFindFileExcept;
    }

    @NotNull
    public final String loadPinnedLegacyNotePathByPath(@Nullable String internalFilesDir, @Nullable String path) {
        String str = File.separator;
        String strM2221l = AbstractC2821a.m2221l(internalFilesDir, str, ".screenoff_pin", str);
        String strFindFile = FileUtils.INSTANCE.findFile(strM2221l, FileUtils.extractFileName(String.valueOf(path)));
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str2 = TAG;
        String encode = Logger.getEncode(path);
        String encode2 = Logger.getEncode(strM2221l);
        String encode3 = Logger.getEncode(strFindFile);
        StringBuilder sbM16m = AbstractC0000a.m16m("loadPinnedLegacyNotePathByPath# path/pinLegacySavePath/legacyNotePath ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str2, sbM16m.toString());
        return strFindFile;
    }

    @NotNull
    public final String loadPinnedNotePathByUri(@Nullable String uri) {
        String str;
        List listM13999t;
        String str2 = "";
        String string = SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(uri, "");
        if (string != null && string.length() == 0) {
            return "";
        }
        String[] strArr = (string == null || (listM13999t = AbstractC12991c.m13999t(0, "\\|", string)) == null) ? null : (String[]) listM13999t.toArray(new String[0]);
        if (strArr != null && (str = strArr[1]) != null) {
            str2 = str;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m775q("loadPinnedNotePathByUri# uri/pinnedNoteData/pinnedNotePath ", Logger.getEncode(uri), "/", Logger.getEncode(string), Logger.getEncode(str2)));
        return str2;
    }

    public final float loadPinnedNoteScrollPanY() {
        float f = SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getFloat(Constants.Preference.PREF_KEY_PINNED_NOTE_SCROLL_PAN_Y, 0.0f);
        SOLogger.INSTANCE.SOLoggerD(TAG, "loadPinnedNoteScrollPanY# scrollPanY " + f);
        return f;
    }

    @NotNull
    public final String loadPinnedNoteUuidByUri(@Nullable String uri) {
        String str;
        List listM13999t;
        String str2 = "";
        String string = SharedPreferencesCompat.INSTANCE.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(uri, "");
        if (string != null && string.length() == 0) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "loadPinnedNoteUuidByUri# SharedPreferences is empty, delete PIN_IMAGE_DIRECTORY!");
            FileUtils.INSTANCE.deleteFile(this.mPinImageDirectory, String.valueOf(uri));
            return "";
        }
        if (!UriUtils.INSTANCE.isUriForm(uri)) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "loadPinnedNoteUuidByUri# pin image file is remained, delete PIN_IMAGE_DIRECTORY!");
            try {
                String str3 = this.mPinImageDirectory;
                if (str3 == null) {
                    str3 = "";
                }
                FileUtils.deleteFile(new File(str3));
            } catch (Exception e) {
                AbstractC0000a.m24u("loadPinnedNoteUuidBy# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
            }
        }
        String[] strArr = (string == null || (listM13999t = AbstractC12991c.m13999t(0, "\\|", string)) == null) ? null : (String[]) listM13999t.toArray(new String[0]);
        if (strArr != null && (str = strArr[0]) != null) {
            str2 = str;
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str4 = TAG;
        String encode = Logger.getEncode(uri);
        String encode2 = Logger.getEncode(string);
        String encode3 = Logger.getEncode(str2);
        StringBuilder sbM16m = AbstractC0000a.m16m("loadPinnedNoteUuidByUri# uri/pinnedNoteData/pinnedUuid ", encode, "/", encode2, "/");
        sbM16m.append(encode3);
        sOLogger.SOLoggerD(str4, sbM16m.toString());
        return str2;
    }

    @RequiresApi(29)
    public final void makePinData(@NotNull Bitmap bitmap, boolean edited) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        SOLogger.INSTANCE.SOLoggerD(TAG, "makePinData#");
        this.edited = edited;
        if (ConfigurationModel.INSTANCE.isUseScopedStorage()) {
            saveBitmapToUri(bitmap);
            return;
        }
        String strM757C = AbstractC0541b.m757C(this.mPinImageDirectory, this.mPinUuid, ".jpg");
        FileUtils.deleteFile$default(strM757C, false, 2, null);
        saveBitmapToFile(bitmap, strM757C);
        this.pinImagePath = strM757C;
    }

    public final void replacePinnedNoteData(@Nullable String uri, @NotNull String uuid, @NotNull String path) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        String strLoadPinnedNoteUuidByUri = loadPinnedNoteUuidByUri(uri);
        String strLoadPinnedNotePathByUri = loadPinnedNotePathByUri(uri);
        String strM757C = AbstractC0541b.m757C(uuid, "|", path);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        String encode = Logger.getEncode(uri);
        String encode2 = Logger.getEncode(uuid);
        String encode3 = Logger.getEncode(path);
        String encode4 = Logger.getEncode(strLoadPinnedNoteUuidByUri);
        String encode5 = Logger.getEncode(strLoadPinnedNotePathByUri);
        String encode6 = Logger.getEncode(strM757C);
        StringBuilder sbM16m = AbstractC0000a.m16m("replacePinnedNoteData# uri/uuid/path/pinnedUuid/pinnedNotePath/replacePinnedNoteData ", encode, "/", encode2, "/");
        AbstractC2821a.m2207B(sbM16m, encode3, "/", encode4, "/");
        sOLogger.SOLoggerD(str, AbstractC2322a.m1626p(sbM16m, encode5, "/", encode6));
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(uri);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(strLoadPinnedNoteUuidByUri);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).remove(Constants.Preference.PREF_KEY_PINNED_URI);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(uri, strM757C);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(uuid, path);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_PINNED_URI, uri);
    }

    public final void savePinnedNoteData(float scrollPanY) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "savePinnedNoteData#");
        if (ConfigurationModel.INSTANCE.isUseScopedStorage()) {
            savePinnedNoteUriData(scrollPanY);
        } else {
            savePinnedNotePathData();
        }
    }
}

package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J(\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0016J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\u0016H\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0016H\u0002J\u0006\u0010$\u001a\u00020\u001aJ\u0016\u0010%\u001a\u00020\u001a2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/EntryImprovementManager;", "", "<init>", "()V", "mNewBitmapInfoObjects", "", "Lcom/samsung/android/support/senl/nt/base/common/BitmapInfoObject;", "mOldBitmapInfoObjects", "mIsActive", "", "value", "isActive", "()Z", "setActive", "(Z)V", "isValid", "bitmapInfoObject", "getBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "filePath", "", "getBitmapInfoObjectFromListByFilePath", "bitmapInfoObjects", "loadInternalMemory", "", "add", "getInternalMemoryFilePath", "saveToInternalMemory", "clearOldFiles", "deleteOldFile", "fileName", "save", "bitmap", "createFilePath", "onDestroy", "releaseBitmapInfoObjects", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEntryImprovementManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntryImprovementManager.kt\ncom/samsung/android/support/senl/nt/base/common/EntryImprovementManager\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,246:1\n71#2,2:247\n739#3,9:249\n37#4:258\n36#4,3:259\n*S KotlinDebug\n*F\n+ 1 EntryImprovementManager.kt\ncom/samsung/android/support/senl/nt/base/common/EntryImprovementManager\n*L\n174#1:247,2\n201#1:249,9\n201#1:258\n201#1:259,3\n*E\n"})
public final class EntryImprovementManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DIRECTORY_NAME = "bitmapImages";
    private static final int MAX_CAPACITY = 10;

    @NotNull
    private static final String TAG = "EntryImprovementManager";

    @Nullable
    private static EntryImprovementManager mInstance;
    private boolean mIsActive;

    @NotNull
    private final List<BitmapInfoObject> mNewBitmapInfoObjects;

    @NotNull
    private final List<BitmapInfoObject> mOldBitmapInfoObjects;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/EntryImprovementManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DIRECTORY_NAME", "MAX_CAPACITY", "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/EntryImprovementManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/EntryImprovementManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final EntryImprovementManager getInstance() {
            if (EntryImprovementManager.mInstance == null) {
                synchronized (EntryImprovementManager.class) {
                    try {
                        if (EntryImprovementManager.mInstance == null) {
                            EntryImprovementManager.mInstance = new EntryImprovementManager(null);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            EntryImprovementManager entryImprovementManager = EntryImprovementManager.mInstance;
            Intrinsics.checkNotNull(entryImprovementManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.EntryImprovementManager");
            return entryImprovementManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EntryImprovementManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void clearOldFiles(Context context) {
        File[] fileArrListFiles;
        File file = new File(AbstractC0541b.m756B(context.getFilesDir().getPath(), "/bitmapImages"));
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            int i = 0;
            int i2 = 0;
            for (File file2 : fileArrListFiles) {
                if (file2 == null) {
                    return;
                }
                if (file2.delete()) {
                    i++;
                } else {
                    i2++;
                }
            }
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            String encode = companion.getEncode(file.getAbsolutePath());
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "clearOldFiles, deleted/failed count : ", "/", " @");
            sbM1173s.append(encode);
            companion.m7137i(TAG, sbM1173s.toString());
        }
    }

    private final String createFilePath(Context context, String fileName) {
        List listEmptyList;
        File file = new File(AbstractC0541b.m756B(context.getFilesDir().getPath(), "/bitmapImages"));
        if (!file.exists()) {
            if (file.mkdir()) {
                LoggerBase.INSTANCE.m7132d(TAG, "createFilePath# Directory is created");
            } else {
                LoggerBase.INSTANCE.m7132d(TAG, "createFilePath# Failed to create directory");
            }
        }
        List listM13999t = AbstractC12991c.m13999t(0, Constants.DOCUMENT_ATTACHMENT_DIR_NAME, fileName);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        return AbstractC0541b.m756B(file.getPath(), AbstractC0541b.m772n("/", StringsKt.m14139M(strArr[strArr.length - 1], "/", "")));
    }

    private final BitmapInfoObject getBitmapInfoObjectFromListByFilePath(Context context, String filePath, List<BitmapInfoObject> bitmapInfoObjects) {
        if (bitmapInfoObjects.isEmpty()) {
            return null;
        }
        String strCreateFilePath = createFilePath(context, getInternalMemoryFilePath(filePath));
        for (BitmapInfoObject bitmapInfoObject : bitmapInfoObjects) {
            if (Intrinsics.areEqual(bitmapInfoObject.getFilePath(), strCreateFilePath)) {
                return bitmapInfoObject;
            }
        }
        return null;
    }

    @NotNull
    public static final EntryImprovementManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final String getInternalMemoryFilePath(String filePath) {
        return AbstractC0541b.m756B(StringsKt.m14139M(StringsKt.m14139M(StringsKt__StringsJVMKt.replace$default(filePath, '.', '-', false, 4, (Object) null), "_g-jpg", "-jpg"), "_l-jpg", "-jpg"), ".png");
    }

    private final boolean isValid(BitmapInfoObject bitmapInfoObject) {
        if (this.mNewBitmapInfoObjects.size() >= 10) {
            return false;
        }
        Iterator<BitmapInfoObject> it = this.mNewBitmapInfoObjects.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getFilePath(), bitmapInfoObject.getFilePath())) {
                return false;
            }
        }
        return true;
    }

    private final void releaseBitmapInfoObjects(List<BitmapInfoObject> bitmapInfoObjects) {
        Iterator<BitmapInfoObject> it = bitmapInfoObjects.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        bitmapInfoObjects.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0044 -> B:31:0x0071). Please report as a decompilation issue!!! */
    private final void save(Context context, Bitmap bitmap, String fileName) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            return;
        }
        ?? r4 = 0;
        FileOutputStream fileOutputStream2 = null;
        r4 = 0;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(createFilePath(context, fileName)));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                r4 = 100;
                Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true).compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                LoggerBase.INSTANCE.m7132d(TAG, "save# fileName : " + fileName);
                fileOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                LoggerBase.INSTANCE.m7133e(TAG, "save# Error save bitmap : " + e.getMessage());
                r4 = fileOutputStream2;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    r4 = fileOutputStream2;
                }
            } catch (Throwable th2) {
                th = th2;
                r4 = fileOutputStream;
                if (r4 != 0) {
                    try {
                        r4.close();
                    } catch (IOException e3) {
                        AbstractC0000a.m23t("save# Error fileOutputStream close : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            AbstractC0000a.m23t("save# Error fileOutputStream close : ", e5.getMessage(), LoggerBase.INSTANCE, TAG);
            r4 = r4;
        }
    }

    public final void add(@NotNull BitmapInfoObject bitmapInfoObject) {
        Intrinsics.checkNotNullParameter(bitmapInfoObject, "bitmapInfoObject");
        if (getMIsActive() && isValid(bitmapInfoObject)) {
            synchronized (EntryImprovementManager.class) {
                if (isValid(bitmapInfoObject)) {
                    this.mNewBitmapInfoObjects.add(bitmapInfoObject);
                    LoggerBase.INSTANCE.m7132d(TAG, "add# path : " + bitmapInfoObject.getFilePath());
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final void deleteOldFile(@NotNull Context context, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String path = context.getFilesDir().getPath();
        String str = File.separator;
        StringBuilder sbM2228s = AbstractC2821a.m2228s(path, str, DIRECTORY_NAME, str, fileName);
        sbM2228s.append(".png");
        File file = new File(sbM2228s.toString());
        if (file.exists()) {
            boolean zDelete = file.delete();
            LoggerBase.INSTANCE.m7137i(TAG, "deleteOldFile# filePath/isDeleted : " + file.getAbsolutePath() + "/" + zDelete);
        }
    }

    @Nullable
    public final Bitmap getBitmap(@NotNull Context context, @Nullable String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!getMIsActive() || filePath == null) {
            return null;
        }
        synchronized (EntryImprovementManager.class) {
            BitmapInfoObject bitmapInfoObjectFromListByFilePath = getBitmapInfoObjectFromListByFilePath(context, filePath, this.mOldBitmapInfoObjects);
            if (bitmapInfoObjectFromListByFilePath == null) {
                return null;
            }
            Bitmap bitmap = bitmapInfoObjectFromListByFilePath.getBitmap();
            if (bitmap == null) {
                return null;
            }
            LoggerBase.INSTANCE.m7132d(TAG, "getBitmap# internalMemory success, Height : " + bitmap.getHeight() + ", Width : " + bitmap.getWidth());
            return bitmap;
        }
    }

    /* JADX INFO: renamed from: isActive, reason: from getter */
    public final boolean getMIsActive() {
        return this.mIsActive;
    }

    public final void loadInternalMemory(@Nullable Context context) {
        File[] fileArrListFiles;
        if (getMIsActive() && context != null) {
            File file = new File(AbstractC0541b.m756B(context.getFilesDir().getPath(), "/bitmapImages"));
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file2.getAbsolutePath());
                    if (bitmapDecodeFile != null) {
                        synchronized (EntryImprovementManager.class) {
                            List<BitmapInfoObject> list = this.mOldBitmapInfoObjects;
                            String absolutePath = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                            list.add(new BitmapInfoObject(bitmapDecodeFile, absolutePath));
                        }
                    }
                }
            }
        }
    }

    public final void onDestroy() {
        synchronized (EntryImprovementManager.class) {
            if (getMIsActive()) {
                setActive(false);
                releaseBitmapInfoObjects(this.mNewBitmapInfoObjects);
                releaseBitmapInfoObjects(this.mOldBitmapInfoObjects);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void saveToInternalMemory(@Nullable Context context) {
        if (context == null) {
            return;
        }
        synchronized (EntryImprovementManager.class) {
            try {
                try {
                    clearOldFiles(context);
                    if (!getMIsActive()) {
                        return;
                    }
                    LoggerBase.INSTANCE.m7132d(TAG, "saveToInternalMemory");
                    for (BitmapInfoObject bitmapInfoObject : this.mNewBitmapInfoObjects) {
                        save(context, bitmapInfoObject.getBitmap(), getInternalMemoryFilePath(bitmapInfoObject.getFilePath()));
                    }
                    onDestroy();
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7132d(TAG, "saveToInternalMemory# Exception " + e.getMessage());
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setActive(boolean z) {
        this.mIsActive = z;
    }

    private EntryImprovementManager() {
        this.mNewBitmapInfoObjects = new ArrayList(10);
        this.mOldBitmapInfoObjects = new ArrayList(10);
        this.mIsActive = true;
    }
}

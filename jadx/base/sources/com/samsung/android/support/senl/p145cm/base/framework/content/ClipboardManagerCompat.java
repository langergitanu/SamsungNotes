package com.samsung.android.support.senl.p145cm.base.framework.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.context.ClipboardManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001<B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u001c\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u000bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0012\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010#2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0001J;\u0010&\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020(2\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001c\u0010.\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u000100J*\u00101\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00102\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020\u0019J,\u00105\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001d\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\u0001J\u001a\u00108\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00106\u001a\u0004\u0018\u000107J\u0010\u00109\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010:\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010;\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/ClipboardManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;)V", "init", "", "context", "Landroid/content/Context;", "typeNone", "", "getTypeNone", "()I", "typeAll", "getTypeAll", "typeHtml", "getTypeHtml", "typeText", "getTypeText", "deleteClipboardFolders", "cacheDir", "Ljava/io/File;", "deleteFolder", "folderPath", "", "isClipboardManagerEnabled", "", "hasPrimaryClip", "type", "getPrimaryClip", "Landroid/content/ClipData;", "getPrimaryClipDescription", "Landroid/content/ClipDescription;", "getClips", "", "getClipData", "semClipData", "setClip", "item", "Landroid/content/ClipData$Item;", "mimeTypes", "", "label", "(Landroid/content/Context;Landroid/content/ClipData$Item;[Ljava/lang/String;Ljava/lang/String;)Z", "getDataListSize", "getPasteListener", "invocationHandler", "Ljava/lang/reflect/InvocationHandler;", "filterClip", "filter", "pasteListener", "msg", "showDialog", "view", "Landroid/view/View;", "canShowClipboard", "isShowing", "dismissDialog", "finishBind", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ClipboardManagerCompat {

    @NotNull
    public static final String CLIPBOARD_FOLDER_PREFIX = "Clip_XXXX";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String METHOD_ID_HONEYBOARD = "com.samsung.android.honeyboard/.service.HoneyBoardService";

    @NotNull
    private static final String TAG = "ClipboardManager";

    @Nullable
    private static ClipboardManagerCompat mInstance;

    @NotNull
    private final AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/ClipboardManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CLIPBOARD_FOLDER_PREFIX", "METHOD_ID_HONEYBOARD", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/content/ClipboardManagerCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/content/ClipboardManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ClipboardManagerCompat getInstance() {
            ClipboardManagerCompat clipboardManagerCompat;
            try {
                if (ClipboardManagerCompat.mInstance == null) {
                    ClipboardManagerCompat.mInstance = new ClipboardManagerCompat(new ClipboardManagerCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                clipboardManagerCompat = ClipboardManagerCompat.mInstance;
                Intrinsics.checkNotNull(clipboardManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.content.ClipboardManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return clipboardManagerCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ClipboardManagerCompat(AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl iClipboardManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iClipboardManagerCompatImpl);
    }

    private final void deleteClipboardFolders(File cacheDir) {
        if (cacheDir == null || !cacheDir.exists()) {
            LoggerBase.INSTANCE.m7132d(TAG, "initClipboardFolder - cache directory is not existed");
            return;
        }
        File[] fileArrListFiles = cacheDir.listFiles(new C7969a(0));
        if (fileArrListFiles == null) {
            LoggerBase.INSTANCE.m7132d(TAG, "initClipboardFolder - clipboard folder is null");
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
        while (it.hasNext()) {
            deleteFolder(((File) it.next()).getAbsolutePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteClipboardFolders$lambda$0(File file) {
        if (!file.isDirectory()) {
            return false;
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.m14162r(name, CLIPBOARD_FOLDER_PREFIX);
    }

    private final void deleteFolder(String folderPath) {
        File file;
        File[] fileArrListFiles;
        if (folderPath == null || (fileArrListFiles = (file = new File(folderPath)).listFiles()) == null) {
            return;
        }
        int i = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                deleteFolder(file2.getAbsolutePath());
            } else if (!file2.delete()) {
                i++;
            }
        }
        LoggerBase.INSTANCE.m7137i(TAG, "deleteFolder, failedCount : " + i + ", folder deleted : " + file.delete());
    }

    public final boolean canShowClipboard(@Nullable Context context, @Nullable View view) {
        if (context == null || view == null) {
            return false;
        }
        return this.mImpl.canShowClipboard(context, view);
    }

    public final void dismissDialog(@Nullable Context context) {
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "showClipboard");
        this.mImpl.dismissDialog(context);
    }

    public final boolean filterClip(@Nullable Context context, int filter, @Nullable Object pasteListener, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return false;
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        StringBuilder sbM780v = AbstractC0541b.m780v("filterClip#", filter, msg, ", filter:", " (");
        sbM780v.append(context);
        sbM780v.append(")");
        companion.m7132d(TAG, sbM780v.toString());
        this.mImpl.filterClip(context, filter, pasteListener);
        return true;
    }

    public final void finishBind(@Nullable Context context) {
        if (context == null) {
            return;
        }
        this.mImpl.finishBind(context);
    }

    @Nullable
    public final ClipData getClipData(@Nullable Object semClipData) {
        return this.mImpl.getClipData(semClipData);
    }

    @Nullable
    public final List<ClipData> getClips(@Nullable Context context) {
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return null;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "getClips");
        return this.mImpl.getClips(context);
    }

    public final int getDataListSize(@Nullable Context context) {
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return 0;
        }
        int dataListSize = this.mImpl.getDataListSize(context);
        LoggerBase.INSTANCE.m7132d(TAG, "getDataListSize#" + dataListSize);
        return dataListSize;
    }

    @Nullable
    public final Object getPasteListener(@Nullable Context context, @Nullable InvocationHandler invocationHandler) {
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return null;
        }
        return this.mImpl.getPasteListener(context, invocationHandler);
    }

    @Nullable
    public final ClipData getPrimaryClip(@Nullable Context context, int type) {
        if (context == null) {
            return null;
        }
        if (this.mImpl.isClipboardManagerEnabled(context)) {
            return this.mImpl.getPrimaryClip(context, type);
        }
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            try {
                return clipboardManager.getPrimaryClip();
            } catch (Throwable th) {
                LoggerBase.INSTANCE.m7134e(TAG, AbstractC2322a.m1616f(type, "getPrimaryClip# ClipboardManager.getPrimaryClip# type - ", SQLKeyword.COMMA, th.getMessage()), th);
                return null;
            }
        }
        LoggerBase.INSTANCE.m7133e(TAG, "getPrimaryClip# clipboard is null. type = " + type);
        return null;
    }

    @Nullable
    public final ClipDescription getPrimaryClipDescription(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "getPrimaryClipDescription# clipboard is null.");
            return null;
        }
        try {
            return clipboardManager.getPrimaryClipDescription();
        } catch (Throwable th) {
            LoggerBase.INSTANCE.m7134e(TAG, "getPrimaryClipDescription#" + th.getMessage(), th);
            return null;
        }
    }

    public final int getTypeAll() {
        return this.mImpl.getTypeAll();
    }

    public final int getTypeHtml() {
        return this.mImpl.getTypeHtml();
    }

    public final int getTypeNone() {
        return this.mImpl.getTypeNone();
    }

    public final int getTypeText() {
        return this.mImpl.getTypeText();
    }

    public final boolean hasPrimaryClip(@Nullable Context context, int type) {
        LoggerBase.INSTANCE.m7132d(TAG, "hasPrimaryClip");
        if (context == null) {
            return false;
        }
        if (this.mImpl.isClipboardManagerEnabled(context)) {
            return this.mImpl.hasPrimaryClip(context, type);
        }
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        return clipboardManager != null && clipboardManager.hasPrimaryClip();
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        deleteClipboardFolders(context.getCacheDir());
        this.mImpl.init(context);
    }

    public final boolean isClipboardManagerEnabled(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        return this.mImpl.isClipboardManagerEnabled(context);
    }

    public final boolean isShowing(@Nullable Context context) {
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return false;
        }
        return this.mImpl.isShowing(context);
    }

    @SuppressLint({"PrivateApi"})
    public final boolean setClip(@Nullable Context context, @NotNull ClipData.Item item, @Nullable String[] mimeTypes, @Nullable String label) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (context == null) {
            return false;
        }
        if (!this.mImpl.isClipboardAllowed(context)) {
            LoggerBase.INSTANCE.m7132d(TAG, "setClip : clipboard is not allowed.");
            return false;
        }
        if (this.mImpl.isClipboardManagerEnabled(context) && this.mImpl.hasSaveServicePermission(context)) {
            LoggerBase.INSTANCE.m7132d(TAG, "setClip : ACTION_ADD_CLIP");
            return this.mImpl.setClip(context, item, mimeTypes, label);
        }
        LoggerBase.INSTANCE.m7132d(TAG, "setClip : enterprise");
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            return true;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newHtmlText(label, item.getText(), item.getHtmlText()));
            return true;
        } catch (Throwable th) {
            LoggerBase.INSTANCE.m7134e(TAG, "setClip : setPrimaryClip#" + th.getMessage(), th);
            return false;
        }
    }

    public final boolean showDialog(@Nullable Context context, @Nullable View view, int type, @Nullable Object pasteListener) {
        if (context == null || !this.mImpl.isClipboardManagerEnabled(context)) {
            return false;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "showClipboard");
        this.mImpl.showDialog(context, view, type, pasteListener);
        return true;
    }

    private ClipboardManagerCompat(AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl iClipboardManagerCompatImpl) {
        this.mImpl = iClipboardManagerCompatImpl;
    }

    @Nullable
    public final ClipData getPrimaryClip(@Nullable Context context) {
        if (context == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "getPrimaryClip# Context is null.");
            return null;
        }
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "getPrimaryClip# clipboard is null.");
            return null;
        }
        try {
            return clipboardManager.getPrimaryClip();
        } catch (Throwable th) {
            LoggerBase.INSTANCE.m7134e(TAG, "getPrimaryClip#" + th.getMessage(), th);
            return null;
        }
    }
}

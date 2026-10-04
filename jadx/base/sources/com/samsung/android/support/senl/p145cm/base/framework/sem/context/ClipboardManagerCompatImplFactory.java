package com.samsung.android.support.senl.p145cm.base.framework.sem.context;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.samsung.android.content.clipboard.SemClipboardManager;
import com.samsung.android.content.clipboard.data.SemClipData;
import com.samsung.android.content.clipboard.data.SemHtmlClipData;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/ClipboardManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ClipboardManagerCompatSemSOsImpl", "ClipboardManagerCompatSem100000Impl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ClipboardManagerCompatImplFactory extends AbsClipboardManagerCompatImplFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ClipboardManagerImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J=\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/ClipboardManagerCompatImplFactory$ClipboardManagerCompatSemSOsImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/ClipboardManagerCompatImplFactory$ClipboardManagerCompatSem100000Impl;", "<init>", "()V", "hasSaveServicePermission", "", "context", "Landroid/content/Context;", "setClip", "item", "Landroid/content/ClipData$Item;", "mimeTypes", "", "", "label", "(Landroid/content/Context;Landroid/content/ClipData$Item;[Ljava/lang/String;Ljava/lang/String;)Z", "hasPrimaryClip", "type", "", "canShowClipboard", "view", "Landroid/view/View;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ClipboardManagerCompatSemSOsImpl extends ClipboardManagerCompatSem100000Impl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.ClipboardManagerCompatImplFactory.ClipboardManagerCompatSem100000Impl, com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboard(@Nullable Context context, @Nullable View view) {
            return canShowClipboardOnSIP(context, view);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.ClipboardManagerCompatImplFactory.ClipboardManagerCompatSem100000Impl, com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasPrimaryClip(@Nullable Context context, int type) {
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboardManager == null || !clipboardManager.hasPrimaryClip()) {
                return false;
            }
            ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
            if (primaryClipDescription == null) {
                LoggerBase.INSTANCE.m7133e(ClipboardManagerCompatImplFactory.TAG, "hasPrimaryClip# description is null");
                return false;
            }
            if (type == 1) {
                return primaryClipDescription.hasMimeType("text/plain") || primaryClipDescription.hasMimeType(Constants.MIME_HTML);
            }
            if (type != 4) {
                return true;
            }
            return primaryClipDescription.hasMimeType(Constants.MIME_HTML);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.ClipboardManagerCompatImplFactory.ClipboardManagerCompatSem100000Impl, com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasSaveServicePermission(@Nullable Context context) {
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.ClipboardManagerCompatImplFactory.ClipboardManagerCompatSem100000Impl, com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean setClip(@Nullable Context context, @Nullable ClipData.Item item, @Nullable String[] mimeTypes, @Nullable String label) {
            CharSequence text;
            boolean z;
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboardManager == null) {
                LoggerBase.INSTANCE.m7133e(ClipboardManagerCompatImplFactory.TAG, "setClip# : clipboardManager is null.");
                return false;
            }
            if (item != null) {
                try {
                    text = item.getText();
                } catch (Throwable th) {
                    LoggerBase.INSTANCE.m7134e(ClipboardManagerCompatImplFactory.TAG, "setClip# setPrimaryClip is fail. ", th);
                    z = false;
                }
            } else {
                text = null;
            }
            clipboardManager.setPrimaryClip(ClipData.newHtmlText(label, text, item != null ? item.getHtmlText() : null));
            z = true;
            if (ClipboardManagerCompatImplFactory.INSTANCE.isSos()) {
                Toast.makeText(context, z ? C7968R.string.copied_to_clipboard : C7968R.string.failed_to_copy_to_clipboard, 0).show();
            }
            return z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/ClipboardManagerCompatImplFactory$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isSos", "", "()Z", "isSosOrHigher", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSos() {
            int i = Build.VERSION.SDK_INT;
            return i == 31 || i == 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSosOrHigher() {
            return Build.VERSION.SDK_INT > 30 || DeviceInfo.getSemPlatformVersionInt(0) >= 130000;
        }

        private Companion() {
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory
    @NotNull
    public AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl create(int deviceType) {
        return deviceType == 2 ? INSTANCE.isSosOrHigher() ? new ClipboardManagerCompatSemSOsImpl() : new ClipboardManagerCompatSem100000Impl() : super.create(deviceType);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0012\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J\u001a\u0010\u0017\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u001c\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J=\u0010 \u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\"2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010)\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J$\u0010,\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u001fH\u0016J.\u0010/\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u0018\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u00102\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001c\u00103\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00104\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00106\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/ClipboardManagerCompatImplFactory$ClipboardManagerCompatSem100000Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", "<init>", "()V", "init", "", "context", "Landroid/content/Context;", "typeNone", "", "getTypeNone", "()I", "typeAll", "getTypeAll", "typeHtml", "getTypeHtml", "typeText", "getTypeText", "hasSaveServicePermission", "", "isClipboardManagerEnabled", "getClipboardManager", "Lcom/samsung/android/content/clipboard/SemClipboardManager;", "hasPrimaryClip", "type", "getPrimaryClip", "Landroid/content/ClipData;", "getClips", "", "getClipData", "semClipData", "", "setClip", "item", "Landroid/content/ClipData$Item;", "mimeTypes", "", "", "label", "(Landroid/content/Context;Landroid/content/ClipData$Item;[Ljava/lang/String;Ljava/lang/String;)Z", "getDataListSize", "getPasteListener", "invocationHandler", "Ljava/lang/reflect/InvocationHandler;", "filterClip", "filter", "pasteListener", "showDialog", "view", "Landroid/view/View;", "canShowClipboard", "canShowClipboardOnSIP", "isShowing", "dismissDialog", "isClipboardAllowed", "finishBind", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nClipboardManagerCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClipboardManagerCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/context/ClipboardManagerCompatImplFactory$ClipboardManagerCompatSem100000Impl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,377:1\n1#2:378\n*E\n"})
    public static class ClipboardManagerCompatSem100000Impl implements AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl {

        @NotNull
        private static final String EXTRA_VALUE_BOARD_CLIPBOARD = "clipboard";

        /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
        @SuppressLint({"WrongConstant"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final SemClipboardManager getClipboardManager(Context context) {
            Object systemService;
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    systemService = applicationContext != null ? applicationContext.getSystemService("semclipboard") : null;
                } catch (NoClassDefFoundError e) {
                    AbstractC0000a.m23t("SemClipboardManager: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                    return null;
                }
            }
            if (systemService instanceof SemClipboardManager) {
                return (SemClipboardManager) systemService;
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboard(@Nullable Context context, @Nullable View view) {
            if (ClipboardManagerCompat.INSTANCE.getInstance().getDataListSize(context) > 0) {
                return true;
            }
            LoggerBase.INSTANCE.m7133e(ClipboardManagerCompatImplFactory.TAG, "canShowClipboard# getDataListSize is 0");
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboardOnSIP(@Nullable Context context, @Nullable View view) {
            if (!InputMethodCompat.INSTANCE.getInstance().canShowHoneyBoardSIP(context, view)) {
                LoggerBase.INSTANCE.m7137i(ClipboardManagerCompatImplFactory.TAG, "canShowClipboardOnSIP# canShowHoneyBoardSIP is false");
                return false;
            }
            if (isClipboardManagerEnabled(context)) {
                return true;
            }
            LoggerBase.INSTANCE.m7137i(ClipboardManagerCompatImplFactory.TAG, "canShowClipboardOnSIP# getSemClipboardManager().isEnabled() is false");
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void dismissDialog(@Nullable Context context) {
            if (isClipboardManagerEnabled(context)) {
                LoggerBase.INSTANCE.m7132d(ClipboardManagerCompatImplFactory.TAG, "hideClipboard");
                try {
                    SemClipboardManager clipboardManager = getClipboardManager(context);
                    if (clipboardManager == null || !clipboardManager.isShowing()) {
                        return;
                    }
                    clipboardManager.dismissDialog();
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("dismissDialog: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void filterClip(@Nullable Context context, int filter, @Nullable Object pasteListener) {
            try {
                SemClipboardManager clipboardManager = getClipboardManager(context);
                if (pasteListener == null) {
                    if (clipboardManager != null) {
                        clipboardManager.filterClip(filter, (SemClipboardManager.OnPasteListener) pasteListener);
                    }
                } else {
                    SemClipboardManager.OnPasteListener onPasteListener = (SemClipboardManager.OnPasteListener) pasteListener;
                    if (clipboardManager != null) {
                        clipboardManager.filterClip(filter, onPasteListener);
                    }
                }
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("SemClipboardManager: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("filterClip: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public ClipData getClipData(@Nullable Object semClipData) {
            try {
                SemClipData semClipData2 = semClipData instanceof SemClipData ? (SemClipData) semClipData : null;
                if (semClipData2 != null) {
                    return semClipData2.getClipData();
                }
                return null;
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("SemClipData: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getClipData: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public List<ClipData> getClips(@Nullable Context context) {
            SemClipboardManager clipboardManager = getClipboardManager(context);
            if (clipboardManager == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                List clips = clipboardManager.getClips();
                if (clips != null && !clips.isEmpty()) {
                    Iterator it = clips.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((SemClipData) it.next()).getClipData());
                    }
                }
                return arrayList;
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(ClipboardManagerCompatImplFactory.TAG, "getClips", e);
                return null;
            } catch (NoClassDefFoundError e2) {
                AbstractC0000a.m23t("SemClipData: NoClassDefFoundError] ", e2.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e3) {
                AbstractC0000a.m23t("getClipData: NoSuchMethodError] ", e3.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getDataListSize(@Nullable Context context) {
            try {
                SemClipboardManager clipboardManager = getClipboardManager(context);
                if (clipboardManager != null) {
                    return clipboardManager.getCount();
                }
                return 0;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("getCount: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return 0;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public Object getPasteListener(@Nullable Context context, @Nullable InvocationHandler invocationHandler) {
            try {
                Class<?> cls = Class.forName("com.samsung.android.content.clipboard.SemClipboardManager$OnPasteListener");
                if (invocationHandler != null) {
                    return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
                }
                return null;
            } catch (ClassNotFoundException e) {
                LoggerBase.INSTANCE.m7134e(ClipboardManagerCompatImplFactory.TAG, "getPasteListener", e);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public ClipData getPrimaryClip(@Nullable Context context, int type) {
            try {
                SemClipboardManager clipboardManager = getClipboardManager(context);
                if (clipboardManager == null) {
                    LoggerBase.INSTANCE.m7133e(ClipboardManagerCompatImplFactory.TAG, "getPrimaryClip# clipboardManager is null");
                    return null;
                }
                SemClipData latestClip = clipboardManager.getLatestClip(type);
                if (latestClip != null) {
                    return latestClip.getClipData();
                }
                LoggerBase.INSTANCE.m7133e(ClipboardManagerCompatImplFactory.TAG, "getPrimaryClip# getLatestClip - semClipData is null");
                return null;
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("getPrimaryClip: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getPrimaryClip: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeAll() {
            return -1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeHtml() {
            return 4;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeNone() {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeText() {
            return 1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasPrimaryClip(@Nullable Context context, int type) {
            try {
                SemClipboardManager clipboardManager = getClipboardManager(context);
                return (clipboardManager != null ? clipboardManager.getLatestClip(type) : null) != null;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("hasPrimaryClip: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasSaveServicePermission(@Nullable Context context) {
            PackageManager packageManager;
            int iCheckPermission = (context == null || (packageManager = context.getPackageManager()) == null) ? -1 : packageManager.checkPermission(AbsClipboardManagerCompatImplFactory.CLIPBOARD_SAVE_SERVICE_PERMISSION, context.getPackageName());
            if (iCheckPermission == 0) {
                return true;
            }
            LoggerBase.INSTANCE.m7137i(ClipboardManagerCompatImplFactory.TAG, "hasSaveServicePermission# permission is wrong : " + iCheckPermission);
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isClipboardAllowed(@Nullable Context context) {
            try {
                Class<?> cls = Class.forName("android.sec.enterprise.EnterpriseDeviceManager");
                Object objInvoke = Class.forName("android.sec.enterprise.RestrictionPolicy").getMethod("isClipboardAllowed", Boolean.TYPE).invoke(cls.getMethod("getRestrictionPolicy", null).invoke(cls.getMethod("getInstance", null).invoke(null, null), null), Boolean.TRUE);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(ClipboardManagerCompatImplFactory.TAG, "setClip", e);
                return true;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isClipboardManagerEnabled(@Nullable Context context) {
            try {
                SemClipboardManager clipboardManager = getClipboardManager(context);
                if (clipboardManager != null) {
                    if (clipboardManager.isEnabled()) {
                        return true;
                    }
                }
                return false;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("isClipboardManagerEnabled: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isShowing(@Nullable Context context) {
            if (!isClipboardManagerEnabled(context)) {
                return false;
            }
            try {
                SemClipboardManager clipboardManager = getClipboardManager(context);
                if (clipboardManager != null) {
                    return clipboardManager.isShowing();
                }
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("isShowing: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean setClip(@Nullable Context context, @Nullable ClipData.Item item, @Nullable String[] mimeTypes, @Nullable String label) {
            SemClipboardManager clipboardManager = getClipboardManager(context);
            if (clipboardManager == null) {
                LoggerBase.INSTANCE.m7133e(ClipboardManagerCompatImplFactory.TAG, "setClip# : clipboardManager is null.");
                return false;
            }
            SemHtmlClipData semHtmlClipData = new SemHtmlClipData();
            if (item != null) {
                semHtmlClipData.setHtml(item.getHtmlText());
            }
            clipboardManager.addClip(context != null ? context.getApplicationContext() : null, semHtmlClipData, (SemClipboardManager.OnAddClipResultListener) null);
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void showDialog(@Nullable Context context, @Nullable View view, int type, @Nullable Object pasteListener) {
            if (isClipboardManagerEnabled(context)) {
                try {
                    SemClipboardManager clipboardManager = getClipboardManager(context);
                    if (clipboardManager != null) {
                        SemClipboardManager.OnPasteListener onPasteListener = (SemClipboardManager.OnPasteListener) pasteListener;
                        if (onPasteListener != null) {
                            clipboardManager.filterClip(type, onPasteListener);
                        }
                        if (!canShowClipboardOnSIP(context, view)) {
                            LoggerBase.INSTANCE.m7137i(ClipboardManagerCompatImplFactory.TAG, "showClipboard# not Honeyboard");
                            clipboardManager.showDialog();
                            return;
                        }
                        LoggerBase.INSTANCE.m7137i(ClipboardManagerCompatImplFactory.TAG, "showClipboard# Honeyboard");
                        Bundle bundle = new Bundle();
                        bundle.putString("board", EXTRA_VALUE_BOARD_CLIPBOARD);
                        if (context != null) {
                            InputMethodCompat.INSTANCE.getInstance().showSoftInput(context, view, bundle);
                        }
                    }
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("showDialog: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, ClipboardManagerCompatImplFactory.TAG);
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void finishBind(@Nullable Context context) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void init(@Nullable Context context) {
        }
    }
}

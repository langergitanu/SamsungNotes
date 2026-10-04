package com.samsung.android.support.senl.p145cm.base.framework.sem.context;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IClipboardManagerCompatImpl", "ClipboardManagerCompatSdlImpl", "ClipboardManagerCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsClipboardManagerCompatImplFactory {

    @NotNull
    public static final String CLIPBOARD_SAVE_SERVICE_PERMISSION = "com.samsung.clipboardsaveservice.CLIPBOARDSAVESERVICE_PERMISSION";

    @NotNull
    private static final String TAG = "ClipboardManagerImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0013\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0007H&J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0007H&J\u001c\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J=\u0010\u0019\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010#\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010$\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010&H&J$\u0010'\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001H&J.\u0010*\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010-\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010,H&J\u001c\u0010.\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010,H&J\u0012\u0010/\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u00100\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u00101\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u00102\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", "", "init", "", "context", "Landroid/content/Context;", "typeNone", "", "getTypeNone", "()I", "typeAll", "getTypeAll", "typeHtml", "getTypeHtml", "typeText", "getTypeText", "hasSaveServicePermission", "", "isClipboardManagerEnabled", "hasPrimaryClip", "type", "getPrimaryClip", "Landroid/content/ClipData;", "getClips", "", "setClip", "item", "Landroid/content/ClipData$Item;", "mimeTypes", "", "", "label", "(Landroid/content/Context;Landroid/content/ClipData$Item;[Ljava/lang/String;Ljava/lang/String;)Z", "getClipData", "semClipData", "getDataListSize", "getPasteListener", "invocationHandler", "Ljava/lang/reflect/InvocationHandler;", "filterClip", "filter", "pasteListener", "showDialog", "view", "Landroid/view/View;", "canShowClipboard", "canShowClipboardOnSIP", "isShowing", "dismissDialog", "isClipboardAllowed", "finishBind", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IClipboardManagerCompatImpl {
        boolean canShowClipboard(@Nullable Context context, @Nullable View view);

        boolean canShowClipboardOnSIP(@Nullable Context context, @Nullable View view);

        void dismissDialog(@Nullable Context context);

        void filterClip(@Nullable Context context, int filter, @Nullable Object pasteListener);

        void finishBind(@Nullable Context context);

        @Nullable
        ClipData getClipData(@Nullable Object semClipData);

        @Nullable
        List<ClipData> getClips(@Nullable Context context);

        int getDataListSize(@Nullable Context context);

        @Nullable
        Object getPasteListener(@Nullable Context context, @Nullable InvocationHandler invocationHandler);

        @Nullable
        ClipData getPrimaryClip(@Nullable Context context, int type);

        int getTypeAll();

        int getTypeHtml();

        int getTypeNone();

        int getTypeText();

        boolean hasPrimaryClip(@Nullable Context context, int type);

        boolean hasSaveServicePermission(@Nullable Context context);

        void init(@Nullable Context context);

        boolean isClipboardAllowed(@Nullable Context context);

        boolean isClipboardManagerEnabled(@Nullable Context context);

        boolean isShowing(@Nullable Context context);

        boolean setClip(@Nullable Context context, @Nullable ClipData.Item item, @Nullable String[] mimeTypes, @Nullable String label);

        void showDialog(@Nullable Context context, @Nullable View view, int type, @Nullable Object pasteListener);
    }

    @NotNull
    public IClipboardManagerCompatImpl create(int deviceType) {
        return deviceType == 3 ? new ClipboardManagerCompatSdlImpl() : new ClipboardManagerCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001a\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J=\u0010\u001e\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010'\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010*\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u001dH\u0016J.\u0010-\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u00100\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00101\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00102\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00103\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00104\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$ClipboardManagerCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", "<init>", "()V", "init", "", "context", "Landroid/content/Context;", "typeNone", "", "getTypeNone", "()I", "typeAll", "getTypeAll", "typeHtml", "getTypeHtml", "typeText", "getTypeText", "hasSaveServicePermission", "", "isClipboardManagerEnabled", "hasPrimaryClip", "type", "getPrimaryClip", "Landroid/content/ClipData;", "getClips", "", "getClipData", "semClipData", "", "setClip", "item", "Landroid/content/ClipData$Item;", "mimeTypes", "", "", "label", "(Landroid/content/Context;Landroid/content/ClipData$Item;[Ljava/lang/String;Ljava/lang/String;)Z", "getDataListSize", "getPasteListener", "invocationHandler", "Ljava/lang/reflect/InvocationHandler;", "filterClip", "filter", "pasteListener", "showDialog", "view", "Landroid/view/View;", "canShowClipboard", "canShowClipboardOnSIP", "isShowing", "dismissDialog", "isClipboardAllowed", "finishBind", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ClipboardManagerCompatPureImpl implements IClipboardManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboard(@Nullable Context context, @Nullable View view) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboardOnSIP(@Nullable Context context, @Nullable View view) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public ClipData getClipData(@Nullable Object semClipData) {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public List<ClipData> getClips(@Nullable Context context) {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getDataListSize(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public Object getPasteListener(@Nullable Context context, @Nullable InvocationHandler invocationHandler) {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public ClipData getPrimaryClip(@Nullable Context context, int type) {
            return null;
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
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasSaveServicePermission(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isClipboardAllowed(@Nullable Context context) {
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isClipboardManagerEnabled(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isShowing(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean setClip(@Nullable Context context, @Nullable ClipData.Item item, @Nullable String[] mimeTypes, @Nullable String label) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void dismissDialog(@Nullable Context context) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void finishBind(@Nullable Context context) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void init(@Nullable Context context) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void filterClip(@Nullable Context context, int filter, @Nullable Object pasteListener) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void showDialog(@Nullable Context context, @Nullable View view, int type, @Nullable Object pasteListener) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001a\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J=\u0010\u0019\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\"\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0016J.\u0010(\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010+\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010,\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010/\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00100\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u00101\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u000bR\u0014\u00103\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u000bR\u0014\u00105\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u000b¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$ClipboardManagerCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/context/AbsClipboardManagerCompatImplFactory$IClipboardManagerCompatImpl;", "<init>", "()V", "init", "", "context", "Landroid/content/Context;", "typeNone", "", "getTypeNone", "()I", "hasSaveServicePermission", "", "isClipboardManagerEnabled", "getClipboardManager", "", "hasPrimaryClip", "type", "getPrimaryClip", "Landroid/content/ClipData;", "getClips", "", "getClipData", "semClipData", "setClip", "item", "Landroid/content/ClipData$Item;", "mimeTypes", "", "", "label", "(Landroid/content/Context;Landroid/content/ClipData$Item;[Ljava/lang/String;Ljava/lang/String;)Z", "getDataListSize", "getPasteListener", "invocationHandler", "Ljava/lang/reflect/InvocationHandler;", "filterClip", "filter", "pasteListener", "showDialog", "view", "Landroid/view/View;", "canShowClipboard", "canShowClipboardOnSIP", "isShowing", "dismissDialog", "isClipboardAllowed", "finishBind", "typeAll", "getTypeAll", "typeHtml", "getTypeHtml", "typeText", "getTypeText", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ClipboardManagerCompatSdlImpl implements IClipboardManagerCompatImpl {

        @Nullable
        private static Class<?> CLIPBOARD_DATA_CLASS = null;

        @Nullable
        private static Class<?> CLIPBOARD_EVENT_LISTENER_CLASS = null;

        @Nullable
        private static Method CLIPBOARD_GET_DATA_LIST_SIZE_METHOD = null;

        @Nullable
        private static Method CLIPBOARD_HAS_DATA_METHOD = null;

        @Nullable
        private static Method CLIPBOARD_MANAGER_GET_DATA = null;

        @NotNull
        private static final String CLIPBOARD_SERVICE = "clipboardEx";

        @Nullable
        private static Method CLIPBOARD_SET_LISTENER_METHOD;

        @Nullable
        private static Method CLIPBOARD_SHOW_DIALOG_METHOD;

        @Nullable
        private static Method GET_DATA;
        private static int FORMAT_ALL_ID = 1;
        private static int FORMAT_TEXT_ID = 2;
        private static int FORMAT_HTML_ID = 4;

        @SuppressLint({"WrongConstant"})
        private final Object getClipboardManager(Context context) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        return applicationContext.getSystemService(CLIPBOARD_SERVICE);
                    }
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, "getClipboardManager", e);
                }
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboard(@Nullable Context context, @Nullable View view) {
            if (ClipboardManagerCompat.INSTANCE.getInstance().getDataListSize(context) > 0) {
                return true;
            }
            LoggerBase.INSTANCE.m7133e(AbsClipboardManagerCompatImplFactory.TAG, "canShowClipboard# getDataListSize is 0");
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean canShowClipboardOnSIP(@Nullable Context context, @Nullable View view) {
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void filterClip(@Nullable Context context, int filter, @Nullable Object pasteListener) {
            Method method;
            try {
                Object clipboardManager = getClipboardManager(context);
                if (clipboardManager == null || (method = CLIPBOARD_SET_LISTENER_METHOD) == null) {
                    return;
                }
                method.invoke(clipboardManager, Integer.valueOf(filter), pasteListener);
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, e.getMessage(), e);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public ClipData getClipData(@Nullable Object semClipData) {
            try {
                Method method = GET_DATA;
                Object objInvoke = method != null ? method.invoke(semClipData, null) : null;
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.content.ClipData");
                return (ClipData) objInvoke;
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, e.getMessage(), e);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public List<ClipData> getClips(@Nullable Context context) {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getDataListSize(@Nullable Context context) {
            Object clipboardManager = getClipboardManager(context);
            if (clipboardManager == null) {
                return 0;
            }
            try {
                Method method = CLIPBOARD_GET_DATA_LIST_SIZE_METHOD;
                Object objInvoke = method != null ? method.invoke(clipboardManager, null) : null;
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, e.getMessage(), e);
                return 0;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public Object getPasteListener(@Nullable Context context, @Nullable InvocationHandler invocationHandler) {
            try {
                Class<?> cls = CLIPBOARD_EVENT_LISTENER_CLASS;
                Intrinsics.checkNotNull(cls);
                return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{CLIPBOARD_EVENT_LISTENER_CLASS}, invocationHandler);
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, e.getMessage(), e);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @Nullable
        public ClipData getPrimaryClip(@Nullable Context context, int type) {
            try {
                Object clipboardManager = getClipboardManager(context);
                if (clipboardManager != null) {
                    Method method = CLIPBOARD_MANAGER_GET_DATA;
                    Object objInvoke = method != null ? method.invoke(clipboardManager, Integer.valueOf(type)) : null;
                    if (objInvoke != null) {
                        return getClipData(objInvoke);
                    }
                    LoggerBase.INSTANCE.m7132d(AbsClipboardManagerCompatImplFactory.TAG, "getPrimaryClip - semClipData is null");
                    return null;
                }
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, "getPrimaryClip", e);
            }
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeAll() {
            return FORMAT_ALL_ID;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeHtml() {
            return FORMAT_HTML_ID;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeNone() {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public int getTypeText() {
            return FORMAT_TEXT_ID;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasPrimaryClip(@Nullable Context context, int type) {
            LoggerBase.INSTANCE.m7132d(AbsClipboardManagerCompatImplFactory.TAG, "hasPrimaryClip");
            try {
                Object clipboardManager = getClipboardManager(context);
                Method method = CLIPBOARD_HAS_DATA_METHOD;
                Object objInvoke = method != null ? method.invoke(clipboardManager, Integer.valueOf(type)) : null;
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, "getPrimaryClip", e);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean hasSaveServicePermission(@Nullable Context context) {
            PackageManager packageManager;
            Integer numValueOf = (context == null || (packageManager = context.getPackageManager()) == null) ? null : Integer.valueOf(packageManager.checkPermission(AbsClipboardManagerCompatImplFactory.CLIPBOARD_SAVE_SERVICE_PERMISSION, context.getPackageName()));
            if (numValueOf != null && numValueOf.intValue() == 0) {
                return true;
            }
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            Object obj = numValueOf;
            if (numValueOf == null) {
                obj = "null";
            }
            companion.m7137i(AbsClipboardManagerCompatImplFactory.TAG, "hasSaveServicePermission# permission is wrong : " + obj);
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        @SuppressLint({"PrivateApi"})
        public void init(@Nullable Context context) {
            Object systemService;
            if (context != null) {
                try {
                    systemService = context.getSystemService(CLIPBOARD_SERVICE);
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, "init", e);
                    return;
                }
            } else {
                systemService = null;
            }
            if (systemService != null) {
                Class<?> cls = Class.forName("android.sec.clipboard.ClipboardExManager");
                CLIPBOARD_DATA_CLASS = Class.forName("android.sec.clipboard.data.ClipboardData");
                Class cls2 = Integer.TYPE;
                CLIPBOARD_MANAGER_GET_DATA = cls.getMethod("getData", cls2);
                Class<?> cls3 = Class.forName("android.sec.clipboard.ClipboardExManager$ClipboardEventListener");
                CLIPBOARD_EVENT_LISTENER_CLASS = cls3;
                CLIPBOARD_SET_LISTENER_METHOD = cls.getMethod("setFilter", cls2, cls3);
                CLIPBOARD_SHOW_DIALOG_METHOD = cls.getMethod("showDialog", cls2, CLIPBOARD_EVENT_LISTENER_CLASS);
                CLIPBOARD_HAS_DATA_METHOD = cls.getMethod("hasData", cls2);
                CLIPBOARD_GET_DATA_LIST_SIZE_METHOD = cls.getMethod("getDataListSize", null);
                Class<?> cls4 = CLIPBOARD_DATA_CLASS;
                GET_DATA = cls4 != null ? cls4.getMethod("getClipData", null) : null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isClipboardAllowed(@Nullable Context context) {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean isClipboardManagerEnabled(@Nullable Context context) {
            Object systemService;
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    systemService = applicationContext != null ? applicationContext.getSystemService(CLIPBOARD_SERVICE) : null;
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, "isClipboardManagerEnabled", e);
                    return false;
                }
            }
            if (systemService == null) {
                return false;
            }
            Object objInvoke = Class.forName("android.sec.clipboard.ClipboardExManager").getMethod("isEnabled", null).invoke(systemService, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean isShowing(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public boolean setClip(@Nullable Context context, @Nullable ClipData.Item item, @Nullable String[] mimeTypes, @Nullable String label) {
            Intent intent = new Intent("com.samsung.clipboardsaveservice.CLIPBOARD_COPY_HTML_RECEIVER");
            intent.addFlags(32);
            intent.putExtra("htmlPath", item != null ? item.getHtmlText() : null);
            intent.setPackage("com.samsung.clipboardsaveservice");
            if (context == null) {
                return true;
            }
            context.sendBroadcast(intent);
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void showDialog(@Nullable Context context, @Nullable View view, int type, @Nullable Object pasteListener) {
            Method method;
            try {
                Object clipboardManager = getClipboardManager(context);
                if (clipboardManager == null || (method = CLIPBOARD_SHOW_DIALOG_METHOD) == null) {
                    return;
                }
                method.invoke(clipboardManager, Integer.valueOf(type), pasteListener);
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(AbsClipboardManagerCompatImplFactory.TAG, e.getMessage(), e);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void dismissDialog(@Nullable Context context) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.context.AbsClipboardManagerCompatImplFactory.IClipboardManagerCompatImpl
        public void finishBind(@Nullable Context context) {
        }
    }
}

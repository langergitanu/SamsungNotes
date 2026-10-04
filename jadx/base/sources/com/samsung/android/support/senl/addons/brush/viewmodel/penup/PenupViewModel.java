package com.samsung.android.support.senl.addons.brush.viewmodel.penup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import androidx.core.content.FileProvider;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.util.BrushToastHandler;
import com.samsung.android.support.senl.addons.brush.util.CommonUtil;
import com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0006\u0010\u0012\u001a\u00020\nJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0006\u0010\u001d\u001a\u00020\nJ\n\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0014J\b\u0010 \u001a\u00020\u001aH\u0014J\b\u0010!\u001a\u00020\u001aH\u0014J\b\u0010\"\u001a\u00020\u001aH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penup/PenupViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penup/IPenupView$IPenupViewListener;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "mFacade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "mIsPenUpLoading", "", "mEnabled", "mImageFileSharePath", "", "getData", "", "id", "getPenupViewListener", "getEnabled", "onRequestCapturePage", "Landroid/graphics/Bitmap;", "getActiveNetwork", "Landroid/net/NetworkInfo;", "context", "Landroid/content/Context;", "onClosed", "", "runSharePenup", "onCheckValidity", "isPenUpLoading", "getFacade", "closeSubViewModels", "clearModels", "closeCallbacks", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PenupViewModel extends AbsBaseViewModel implements IPenupView.IPenupViewListener {

    @NotNull
    private static final String AUTHORITY = "com.samsung.android.app.notes.shareprovider";

    @NotNull
    private static final String BINDING_ID_ENABLE = "enable";

    @NotNull
    private static final String BINDING_ID_PENUP_LISTENER = "penupListener";

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenupViewModel");
    private boolean mEnabled = true;

    @Nullable
    private BrushFacade mFacade;

    @Nullable
    private String mImageFileSharePath;
    private boolean mIsPenUpLoading;

    public PenupViewModel(@Nullable IFacade iFacade) {
        if (iFacade != null) {
            this.mFacade = (BrushFacade) iFacade;
        }
    }

    private final IPenupView.IPenupViewListener getPenupViewListener() {
        return this;
    }

    private final boolean onCheckValidity() {
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade == null) {
            return false;
        }
        Intrinsics.checkNotNull(brushFacade);
        brushFacade.commitStroke();
        BrushFacade brushFacade2 = this.mFacade;
        Intrinsics.checkNotNull(brushFacade2);
        Integer objectCount = brushFacade2.getObjectCount();
        if (objectCount != null && objectCount.intValue() == 0) {
            String str = TAG;
            Logger.m7100d(str, "PenUp onCheckValidity() : object cnt = 0");
            BrushFacade brushFacade3 = this.mFacade;
            Intrinsics.checkNotNull(brushFacade3);
            if (brushFacade3.getForegroundImagePath() != null) {
                BrushFacade brushFacade4 = this.mFacade;
                Intrinsics.checkNotNull(brushFacade4);
                Rect drawnRect = brushFacade4.getDrawnRect();
                if (drawnRect != null && drawnRect.height() > 0) {
                    Logger.m7100d(str, "PenUp onCheckValidity() : has foreground image");
                    return true;
                }
            }
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        BrushFacade brushFacade5 = this.mFacade;
        Intrinsics.checkNotNull(brushFacade5);
        Rect validRect = brushFacade5.getValidRect(-1, 0, -1, 0);
        Logger.m7100d(TAG, "PenUp onCheckValidity() : getValidRect time = " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ,  getValidRect = " + (validRect == null ? "null" : validRect));
        return validRect != null && validRect.height() > 0;
    }

    private final Bitmap onRequestCapturePage() {
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade == null) {
            return null;
        }
        Intrinsics.checkNotNull(brushFacade);
        return brushFacade.captureAllPage();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mFacade = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void close() {
        this.mIsPenUpLoading = false;
        this.mEnabled = true;
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Nullable
    public final NetworkInfo getActiveNetwork(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Logger.m7101e(TAG, "activeNetwork is null!");
        }
        return activeNetworkInfo;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_ENABLE, id) ? Boolean.valueOf(getMEnabled()) : Intrinsics.areEqual(BINDING_ID_PENUP_LISTENER, id) ? getPenupViewListener() : super.getData(id);
    }

    /* JADX INFO: renamed from: getEnabled, reason: from getter */
    public final boolean getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView.IPenupViewListener
    @Nullable
    /* JADX INFO: renamed from: getFacade, reason: from getter */
    public BrushFacade getMFacade() {
        return this.mFacade;
    }

    /* JADX INFO: renamed from: isPenUpLoading, reason: from getter */
    public final boolean getMIsPenUpLoading() {
        return this.mIsPenUpLoading;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView.IPenupViewListener
    public void onClosed() {
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView.IPenupViewListener
    public boolean runSharePenup(@Nullable Context context) {
        if (!onCheckValidity()) {
            return false;
        }
        if (context == null) {
            Logger.m7100d(TAG, "Context is null");
            return false;
        }
        if (getActiveNetwork(context) != null) {
            NetworkInfo activeNetwork = getActiveNetwork(context);
            Intrinsics.checkNotNull(activeNetwork);
            if (activeNetwork.isConnected()) {
                this.mImageFileSharePath = CommonUtil.getImagePathByTimeInAppShare(context, "", Constants.THUMBNAIL_PNG_EXTENSION);
                Bitmap bitmapOnRequestCapturePage = onRequestCapturePage();
                if (bitmapOnRequestCapturePage == null) {
                    Logger.m7100d(TAG, "Failed to create bitmap");
                    return false;
                }
                Bitmap.Config config = bitmapOnRequestCapturePage.getConfig();
                Intrinsics.checkNotNull(config);
                Bitmap bitmapCopy = bitmapOnRequestCapturePage.copy(config, true);
                bitmapOnRequestCapturePage.recycle();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCopy.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                bitmapCopy.recycle();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    String str = this.mImageFileSharePath;
                    Intrinsics.checkNotNull(str);
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str), false);
                    try {
                        fileOutputStream.write(byteArray);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } finally {
                    }
                } catch (IOException unused) {
                    Logger.m7101e(TAG, "Exception is occurred at File I/O.");
                }
                String str2 = this.mImageFileSharePath;
                Intrinsics.checkNotNull(str2);
                File file = new File(str2);
                if (!file.exists()) {
                    Logger.m7101e(TAG, "Fail to write file : " + Logger.getEncode(this.mImageFileSharePath));
                    return false;
                }
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setPackage("com.sec.penup");
                intent.setType(CoeditServiceConstants.MimeType.IMAGE_PNG);
                intent.setFlags(1);
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, AUTHORITY, file));
                intent.putExtra("from_package", "com.samsung.android.app.notes");
                context.startActivity(intent);
                return true;
            }
        }
        BrushToastHandler.showShort(C7944R.string.brush_penup_msg_network_error);
        return false;
    }
}

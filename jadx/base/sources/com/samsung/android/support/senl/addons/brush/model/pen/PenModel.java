package com.samsung.android.support.senl.addons.brush.model.pen;

import android.util.Size;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\u0010J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\b\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModel;", "Lcom/samsung/android/support/senl/addons/base/model/pen/AbsPenModel;", "type", "", "color", "", "thickness", "position", "canvasSizeModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Ljava/lang/String;IIILcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "prevThickness", "", "(Ljava/lang/String;IIFILcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mHasAlpha", "", "mAlphaValue", "mPrevThickness", "mCanvasSizeModel", "mScreenModel", "mCanvasSize", "Landroid/util/Size;", "findPenClassName", "penType", "enableAlpha", "", "hasAlpha", "getAlpha", "getAlphaColor", "setAlpha", "alphaValue", "updateSize", "saveCurrentPenInfo", "savePenInfo", "getPenSize", "setSelected", "selected", "updateCanvasSize", "setColor", "src", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PenModel extends AbsPenModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenModel");
    private float mAlphaValue;

    @NotNull
    private Size mCanvasSize;

    @Nullable
    private IBrushCanvasModel mCanvasSizeModel;
    private boolean mHasAlpha;
    private float mPrevThickness;

    @Nullable
    private IScreenModel mScreenModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModel$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getAlpha", "", "alpha", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float getAlpha(int alpha) {
            return alpha / 255.0f;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PenModel(@NotNull String type, int i, int i2, int i4, @Nullable IBrushCanvasModel iBrushCanvasModel, @Nullable IScreenModel iScreenModel) {
        super(type, i, i2, i4);
        Intrinsics.checkNotNullParameter(type, "type");
        this.mAlphaValue = 1.0f;
        this.mPrevThickness = -1.0f;
        this.mCanvasSize = new Size(-1, -1);
        this.mAlphaValue = INSTANCE.getAlpha((i >> 24) & 255);
        this.mCanvasSizeModel = iBrushCanvasModel;
        this.mScreenModel = iScreenModel;
        updateCanvasSize();
    }

    private final void saveCurrentPenInfo() {
        PenInfoManager.INSTANCE.getInstance().saveCurrentPenName(getMPenType());
    }

    private final boolean updateCanvasSize() {
        IBrushCanvasModel iBrushCanvasModel = this.mCanvasSizeModel;
        if (iBrushCanvasModel == null) {
            return false;
        }
        Intrinsics.checkNotNull(iBrushCanvasModel);
        if (iBrushCanvasModel.getPageDocWidth() <= 0) {
            return false;
        }
        IBrushCanvasModel iBrushCanvasModel2 = this.mCanvasSizeModel;
        Intrinsics.checkNotNull(iBrushCanvasModel2);
        if (iBrushCanvasModel2.getPageDocHeight() <= 0) {
            return false;
        }
        if (this.mCanvasSize.getWidth() > 0 && this.mCanvasSize.getHeight() > 0) {
            return true;
        }
        IBrushCanvasModel iBrushCanvasModel3 = this.mCanvasSizeModel;
        Intrinsics.checkNotNull(iBrushCanvasModel3);
        int pageDocWidth = iBrushCanvasModel3.getPageDocWidth();
        IBrushCanvasModel iBrushCanvasModel4 = this.mCanvasSizeModel;
        Intrinsics.checkNotNull(iBrushCanvasModel4);
        this.mCanvasSize = new Size(pageDocWidth, iBrushCanvasModel4.getPageDocHeight());
        return true;
    }

    public final void enableAlpha() {
        this.mHasAlpha = true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel
    @Nullable
    public String findPenClassName(@NotNull String penType) {
        Intrinsics.checkNotNullParameter(penType, "penType");
        int length = PenDefaultInfo.INSTANCE.getINFO_PEN_NAMES().length;
        for (int i = 0; i < length; i++) {
            PenDefaultInfo penDefaultInfo = PenDefaultInfo.INSTANCE;
            if (StringsKt.m14162r(penDefaultInfo.getINFO_PEN_NAMES()[i], penType)) {
                return penDefaultInfo.getINFO_PEN_NAMES()[i];
            }
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel, com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public float getAlpha() {
        if (this.mHasAlpha) {
            return this.mAlphaValue;
        }
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel, com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public int getAlphaColor() {
        int mColor = getMColor();
        return this.mHasAlpha ? (mColor & 16777215) | ((((int) (this.mAlphaValue * 255)) << 24) & (-16777216)) : mColor;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel, com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public float getPenSize() {
        if (!updateCanvasSize()) {
            return -1.0f;
        }
        PenDefaultInfo penDefaultInfo = PenDefaultInfo.INSTANCE;
        String mPenType = getMPenType();
        int mPenThickness = getMPenThickness();
        IScreenModel iScreenModel = this.mScreenModel;
        Intrinsics.checkNotNull(iScreenModel);
        float penPixelSize = penDefaultInfo.getPenPixelSize(mPenType, mPenThickness, iScreenModel.getMWindowResolution());
        String str = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("getPenSize. ", getMPenThickness(), getMPenType(), SQLKeyword.COMMA, SQLKeyword.COMMA);
        sbM780v.append(penPixelSize);
        Logger.m7100d(str, sbM780v.toString());
        return penPixelSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel, com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    /* JADX INFO: renamed from: hasAlpha, reason: from getter */
    public boolean getMHasAlpha() {
        return this.mHasAlpha;
    }

    public final void savePenInfo() {
        PenInfoManager.INSTANCE.getInstance().savePenInfo(this);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel, com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void setAlpha(float alphaValue) {
        if (this.mAlphaValue == alphaValue) {
            return;
        }
        this.mAlphaValue = alphaValue;
        setColor(((((int) (alphaValue * 255)) << 24) & (-16777216)) | (getMColor() & 16777215));
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.ColorModel, com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    public void setColor(@NotNull IExtendedColor src) {
        Intrinsics.checkNotNullParameter(src, "src");
        if (!getMHasAlpha()) {
            super.setColor(src);
            return;
        }
        setColor(((((int) (this.mAlphaValue * 255)) << 24) & (-16777216)) | (src.getMColor() & 16777215), src.getMHSV());
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.AbsPenModel, com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            saveCurrentPenInfo();
        }
    }

    public void updateSize() {
        if (this.mPrevThickness <= 0.0f || !updateCanvasSize()) {
            return;
        }
        PenDefaultInfo penDefaultInfo = PenDefaultInfo.INSTANCE;
        String mPenClassName = getMPenClassName();
        Intrinsics.checkNotNull(mPenClassName);
        setPenSize(penDefaultInfo.getPenInfoSize(mPenClassName, this.mCanvasSize.getWidth(), this.mCanvasSize.getHeight(), this.mPrevThickness));
        this.mPrevThickness = -1.0f;
        notifyChanged(302);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PenModel(@NotNull String type, int i, int i2, float f, int i4, @Nullable IBrushCanvasModel iBrushCanvasModel, @Nullable IScreenModel iScreenModel) {
        super(type, i, i2, i4);
        Intrinsics.checkNotNullParameter(type, "type");
        this.mAlphaValue = 1.0f;
        this.mPrevThickness = -1.0f;
        this.mCanvasSize = new Size(-1, -1);
        this.mPrevThickness = f;
        this.mAlphaValue = INSTANCE.getAlpha((i >> 24) & 255);
        this.mCanvasSizeModel = iBrushCanvasModel;
        this.mScreenModel = iScreenModel;
        updateCanvasSize();
    }
}

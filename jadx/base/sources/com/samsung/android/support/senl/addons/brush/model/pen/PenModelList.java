package com.samsung.android.support.senl.addons.brush.model.pen;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel;
import com.samsung.android.support.senl.addons.brush.model.pen.IPenModelList;
import com.samsung.android.support.senl.addons.brush.model.pen.PenInfoManager;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModelList;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/brush/model/pen/IPenModelList;", "canvasSizeModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mPenModelList", "Ljava/util/Hashtable;", "", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModel;", "mEraserPenModel", "mPrevPenName", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "savePenInfo", "", "getPenModel", "index", "", "name", "getSelectedModel", "getEraserPenModel", "close", "updateSize", "setPrevSelectedPenName", "penName", "prevSelectedModel", "getPrevSelectedModel", "()Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModel;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PenModelList extends AbsBaseModel implements IPenModelList {

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenModelList");

    @Nullable
    private PenModel mEraserPenModel;

    @Nullable
    private String mPrevPenName;

    @Nullable
    private Hashtable<String, PenModel> mPenModelList = new Hashtable<>();

    @Nullable
    private IBaseModel.Observer mCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.model.pen.PenModelList$mCallback$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            Integer id = info != null ? info.getId() : null;
            Intrinsics.checkNotNull(id);
            int iIntValue = id.intValue();
            if (iIntValue == 301) {
                this.this$0.notifyChanged(301);
            } else {
                if (iIntValue != 302) {
                    return;
                }
                this.this$0.notifyChanged(302);
            }
        }
    };

    public PenModelList(@Nullable IBrushCanvasModel iBrushCanvasModel, @Nullable IScreenModel iScreenModel) {
        if (PenInfoManager.INSTANCE.getInstance().isExistPrevPreference()) {
            int pen_count = IPenModelList.INSTANCE.getPEN_COUNT();
            for (int i = 0; i < pen_count; i++) {
                PenModel penModelLoadPenModel = PenInfoManager.INSTANCE.getInstance().loadPenModel(i, IPenModelList.INSTANCE.getPEN_NAMES()[i], iBrushCanvasModel, iScreenModel);
                Hashtable<String, PenModel> hashtable = this.mPenModelList;
                Intrinsics.checkNotNull(hashtable);
                hashtable.put(penModelLoadPenModel.getMPenType(), penModelLoadPenModel);
                IBaseModel.Observer observer = this.mCallback;
                Intrinsics.checkNotNull(observer);
                penModelLoadPenModel.addObserver(observer);
                PenPluginManager.INSTANCE.updatePenInfo(penModelLoadPenModel);
            }
            Hashtable<String, PenModel> hashtable2 = this.mPenModelList;
            Intrinsics.checkNotNull(hashtable2);
            IPenModelList.Companion companion = IPenModelList.INSTANCE;
            PenModel penModel = hashtable2.get(companion.getPEN_NAMES()[BrushSettingViewInforManager.INSTANCE.getSelectedPenIndex()]);
            Intrinsics.checkNotNull(penModel);
            penModel.setSelected(true);
            this.mPrevPenName = companion.getPEN_NAMES()[0];
            PenInfoManager.Companion companion2 = PenInfoManager.INSTANCE;
            PenModel penModelLoadPenModel2 = companion2.getInstance().loadPenModel(companion.getPEN_COUNT(), companion.getERASER_NAME(), iBrushCanvasModel, iScreenModel);
            this.mEraserPenModel = penModelLoadPenModel2;
            Intrinsics.checkNotNull(penModelLoadPenModel2);
            IBaseModel.Observer observer2 = this.mCallback;
            Intrinsics.checkNotNull(observer2);
            penModelLoadPenModel2.addObserver(observer2);
            PenPluginManager penPluginManager = PenPluginManager.INSTANCE;
            PenModel penModel2 = this.mEraserPenModel;
            Intrinsics.checkNotNull(penModel2);
            penPluginManager.updatePenInfo(penModel2);
            companion2.getInstance().clearPrevPreference();
        } else {
            int pen_count2 = IPenModelList.INSTANCE.getPEN_COUNT();
            for (int i2 = 0; i2 < pen_count2; i2++) {
                PenModel penModelLoadPenModel3 = PenInfoManager.INSTANCE.getInstance().loadPenModel(IPenModelList.INSTANCE.getPEN_NAMES()[i2], i2, iBrushCanvasModel, iScreenModel);
                Hashtable<String, PenModel> hashtable3 = this.mPenModelList;
                Intrinsics.checkNotNull(hashtable3);
                hashtable3.put(penModelLoadPenModel3.getMPenType(), penModelLoadPenModel3);
                IBaseModel.Observer observer3 = this.mCallback;
                Intrinsics.checkNotNull(observer3);
                penModelLoadPenModel3.addObserver(observer3);
                PenPluginManager.INSTANCE.updatePenInfo(penModelLoadPenModel3);
            }
            Hashtable<String, PenModel> hashtable4 = this.mPenModelList;
            Intrinsics.checkNotNull(hashtable4);
            PenInfoManager.Companion companion3 = PenInfoManager.INSTANCE;
            PenModel penModel3 = hashtable4.get(companion3.getInstance().getSelectedPenName());
            if (penModel3 == null) {
                Hashtable<String, PenModel> hashtable5 = this.mPenModelList;
                Intrinsics.checkNotNull(hashtable5);
                penModel3 = hashtable5.get(IPenModelList.INSTANCE.getPEN_NAMES()[0]);
            }
            Intrinsics.checkNotNull(penModel3);
            penModel3.setSelected(true);
            this.mPrevPenName = companion3.getInstance().getPrevSelectedPenName();
            PenInfoManager companion4 = companion3.getInstance();
            IPenModelList.Companion companion5 = IPenModelList.INSTANCE;
            PenModel penModelLoadPenModel4 = companion4.loadPenModel(companion5.getERASER_NAME(), companion5.getPEN_COUNT(), iBrushCanvasModel, iScreenModel);
            this.mEraserPenModel = penModelLoadPenModel4;
            Intrinsics.checkNotNull(penModelLoadPenModel4);
            IBaseModel.Observer observer4 = this.mCallback;
            Intrinsics.checkNotNull(observer4);
            penModelLoadPenModel4.addObserver(observer4);
            PenPluginManager penPluginManager2 = PenPluginManager.INSTANCE;
            PenModel penModel4 = this.mEraserPenModel;
            Intrinsics.checkNotNull(penModel4);
            penPluginManager2.updatePenInfo(penModel4);
        }
        String str = TAG;
        Hashtable<String, PenModel> hashtable6 = this.mPenModelList;
        Intrinsics.checkNotNull(hashtable6);
        AbstractC6670b.m4761v(hashtable6.size(), "Pen list size. ", str);
    }

    public final void close() {
        savePenInfo();
        Hashtable<String, PenModel> hashtable = this.mPenModelList;
        if (hashtable != null) {
            Intrinsics.checkNotNull(hashtable);
            int size = hashtable.size();
            for (int i = 0; i < size; i++) {
                PenModel penModel = getPenModel(i);
                Intrinsics.checkNotNull(penModel);
                IBaseModel.Observer observer = this.mCallback;
                Intrinsics.checkNotNull(observer);
                penModel.removeObserver(observer);
            }
            Hashtable<String, PenModel> hashtable2 = this.mPenModelList;
            Intrinsics.checkNotNull(hashtable2);
            hashtable2.clear();
            this.mPenModelList = null;
        }
        PenModel penModel2 = this.mEraserPenModel;
        if (penModel2 != null) {
            Intrinsics.checkNotNull(penModel2);
            IBaseModel.Observer observer2 = this.mCallback;
            Intrinsics.checkNotNull(observer2);
            penModel2.removeObserver(observer2);
            this.mEraserPenModel = null;
        }
        this.mCallback = null;
    }

    @Nullable
    public final PenModel getPrevSelectedModel() {
        Hashtable<String, PenModel> hashtable = this.mPenModelList;
        Intrinsics.checkNotNull(hashtable);
        return hashtable.get(this.mPrevPenName);
    }

    public void savePenInfo() {
        if (this.mPrevPenName != null) {
            PenInfoManager.INSTANCE.getInstance().savePrevPenName(this.mPrevPenName);
        }
        Hashtable<String, PenModel> hashtable = this.mPenModelList;
        if (hashtable != null) {
            Intrinsics.checkNotNull(hashtable);
            int size = hashtable.size();
            for (int i = 0; i < size; i++) {
                PenModel penModel = getPenModel(i);
                if (penModel != null) {
                    penModel.savePenInfo();
                }
            }
        }
        PenModel penModel2 = this.mEraserPenModel;
        if (penModel2 != null) {
            Intrinsics.checkNotNull(penModel2);
            penModel2.savePenInfo();
        }
    }

    public final void setPrevSelectedPenName(@Nullable String penName) {
        this.mPrevPenName = penName;
    }

    public void updateSize() {
        if (this.mPenModelList != null) {
            Logger.m7100d(TAG, "update Pen Size");
            Hashtable<String, PenModel> hashtable = this.mPenModelList;
            Intrinsics.checkNotNull(hashtable);
            int size = hashtable.size();
            for (int i = 0; i < size; i++) {
                PenModel penModel = getPenModel(i);
                Intrinsics.checkNotNull(penModel);
                penModel.updateSize();
            }
        }
        if (this.mEraserPenModel != null) {
            Logger.m7100d(TAG, "update Eraser Size");
            PenModel penModel2 = this.mEraserPenModel;
            Intrinsics.checkNotNull(penModel2);
            penModel2.updateSize();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IBasePenModelList
    @Nullable
    /* JADX INFO: renamed from: getEraserPenModel, reason: from getter */
    public PenModel getMEraserPenModel() {
        return this.mEraserPenModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IBasePenModelList
    @Nullable
    public PenModel getSelectedModel() {
        Hashtable<String, PenModel> hashtable = this.mPenModelList;
        Intrinsics.checkNotNull(hashtable);
        int size = hashtable.size();
        for (int i = 0; i < size; i++) {
            PenModel penModel = getPenModel(i);
            Intrinsics.checkNotNull(penModel);
            if (penModel.getMIsSelected()) {
                return penModel;
            }
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IBasePenModelList
    @Nullable
    public PenModel getPenModel(int index) {
        return getPenModel(IPenModelList.INSTANCE.getPEN_NAMES()[index]);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IBasePenModelList
    @Nullable
    public PenModel getPenModel(@Nullable String name) {
        Hashtable<String, PenModel> hashtable = this.mPenModelList;
        Intrinsics.checkNotNull(hashtable);
        return hashtable.get(name);
    }
}

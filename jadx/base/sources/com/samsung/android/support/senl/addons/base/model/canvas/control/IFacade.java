package com.samsung.android.support.senl.addons.base.model.canvas.control;

import com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasFlags;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPreTouchListener;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,J\b\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H&J\u000e\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH&J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H&J\u000e\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H&J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u0004H&J\b\u0010\u001f\u001a\u00020\u0004H&J\b\u0010 \u001a\u00020\u0004H&J\b\u0010!\u001a\u00020\u0004H&J\b\u0010\"\u001a\u00020\u001bH&J\b\u0010#\u001a\u00020\u001bH&J\b\u0010$\u001a\u00020\u0004H&J\n\u0010%\u001a\u0004\u0018\u00010&H&J\u000f\u0010'\u001a\u0004\u0018\u00010(H&¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0004H&J\b\u0010+\u001a\u00020\u0004H&¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasFlags;", "clearViews", "", "getView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "setView", "view", "getSettingView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "setSettingView", "settingView", "getCurrentColor", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "getCanvasContainer", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer;", "setCanvasContainer", DBSchema.DocumentThumbnail.LAYOUT, "setDoc", "doc", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "getDocModel", "setPreTouchListener", "listner", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPreTouchListener;", "isUndoable", "", "isRedoable", "undo", "redo", "undoAll", "redoAll", "commitStroke", "isEmpty", "isDrawing", "clearAll", "getViewPositionInWindow", "", "getObjectCount", "", "()Ljava/lang/Integer;", "lockForSave", "unlockForSave", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IFacade extends IBaseModel, ICanvasFlags {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OBSV_PROPERTY_ALL_OBJECT_REMOVED = 11008;
    public static final int OBSV_PROPERTY_DOCUMENT_CREATED = 11400;
    public static final int OBSV_PROPERTY_ERASER_ENABLED = 11500;
    public static final int OBSV_PROPERTY_NONE = 11000;
    public static final int OBSV_PROPERTY_OBJECT_ADDED = 11006;
    public static final int OBSV_PROPERTY_OBJECT_CHANGED = 11001;
    public static final int OBSV_PROPERTY_OBJECT_CHANGED_REDO = 11003;
    public static final int OBSV_PROPERTY_OBJECT_CHANGED_UNDO = 11002;
    public static final int OBSV_PROPERTY_OBJECT_NOT_REDOABLE = 11005;
    public static final int OBSV_PROPERTY_OBJECT_NOT_UNDOABLE = 11004;
    public static final int OBSV_PROPERTY_OBJECT_REMOVED = 11007;
    public static final int OBSV_PROPERTY_OBJECT_SELECTED = 11010;
    public static final int OBSV_PROPERTY_PAINTING_DOC_CREATED = 11401;
    public static final int OBSV_PROPERTY_PEN_COLOR_CHANGED = 11303;
    public static final int OBSV_PROPERTY_START_OBJECT_ADDED = 11009;
    public static final int OBSV_PROPERTY_TOOL_CHANGED_ERASER = 11301;
    public static final int OBSV_PROPERTY_TOOL_CHANGED_PEN = 11300;
    public static final int OBSV_PROPERTY_TOOL_CHANGED_SELECTOR = 11302;
    public static final int OBSV_PROPERTY_VIEW_ACTION_UP = 11103;
    public static final int OBSV_PROPERTY_VIEW_INFLATED = 11200;
    public static final int OBSV_PROPERTY_VIEW_LAYOUT_CHANGED = 11201;
    public static final int OBSV_PROPERTY_VIEW_PRE_ACTION_DOWN = 11102;
    public static final int OBSV_PROPERTY_VIEW_SET_DOCUMENT = 11202;
    public static final int OBSV_PROPERTY_VIEW_SET_ZOOM_INIT = 11101;
    public static final int OBSV_PROPERTY_VIEW_ZOOM_CHANGED = 11100;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade$Companion;", "", "<init>", "()V", "OBSV_PROPERTY_NONE", "", "OBSV_PROPERTY_OBJECT_CHANGED", "OBSV_PROPERTY_OBJECT_CHANGED_UNDO", "OBSV_PROPERTY_OBJECT_CHANGED_REDO", "OBSV_PROPERTY_OBJECT_NOT_UNDOABLE", "OBSV_PROPERTY_OBJECT_NOT_REDOABLE", "OBSV_PROPERTY_OBJECT_ADDED", "OBSV_PROPERTY_OBJECT_REMOVED", "OBSV_PROPERTY_ALL_OBJECT_REMOVED", "OBSV_PROPERTY_START_OBJECT_ADDED", "OBSV_PROPERTY_OBJECT_SELECTED", "OBSV_PROPERTY_VIEW_ZOOM_CHANGED", "OBSV_PROPERTY_VIEW_SET_ZOOM_INIT", "OBSV_PROPERTY_VIEW_PRE_ACTION_DOWN", "OBSV_PROPERTY_VIEW_ACTION_UP", "OBSV_PROPERTY_VIEW_INFLATED", "OBSV_PROPERTY_VIEW_LAYOUT_CHANGED", "OBSV_PROPERTY_VIEW_SET_DOCUMENT", "OBSV_PROPERTY_TOOL_CHANGED_PEN", "OBSV_PROPERTY_TOOL_CHANGED_ERASER", "OBSV_PROPERTY_TOOL_CHANGED_SELECTOR", "OBSV_PROPERTY_PEN_COLOR_CHANGED", "OBSV_PROPERTY_DOCUMENT_CREATED", "OBSV_PROPERTY_PAINTING_DOC_CREATED", "OBSV_PROPERTY_ERASER_ENABLED", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OBSV_PROPERTY_ALL_OBJECT_REMOVED = 11008;
        public static final int OBSV_PROPERTY_DOCUMENT_CREATED = 11400;
        public static final int OBSV_PROPERTY_ERASER_ENABLED = 11500;
        public static final int OBSV_PROPERTY_NONE = 11000;
        public static final int OBSV_PROPERTY_OBJECT_ADDED = 11006;
        public static final int OBSV_PROPERTY_OBJECT_CHANGED = 11001;
        public static final int OBSV_PROPERTY_OBJECT_CHANGED_REDO = 11003;
        public static final int OBSV_PROPERTY_OBJECT_CHANGED_UNDO = 11002;
        public static final int OBSV_PROPERTY_OBJECT_NOT_REDOABLE = 11005;
        public static final int OBSV_PROPERTY_OBJECT_NOT_UNDOABLE = 11004;
        public static final int OBSV_PROPERTY_OBJECT_REMOVED = 11007;
        public static final int OBSV_PROPERTY_OBJECT_SELECTED = 11010;
        public static final int OBSV_PROPERTY_PAINTING_DOC_CREATED = 11401;
        public static final int OBSV_PROPERTY_PEN_COLOR_CHANGED = 11303;
        public static final int OBSV_PROPERTY_START_OBJECT_ADDED = 11009;
        public static final int OBSV_PROPERTY_TOOL_CHANGED_ERASER = 11301;
        public static final int OBSV_PROPERTY_TOOL_CHANGED_PEN = 11300;
        public static final int OBSV_PROPERTY_TOOL_CHANGED_SELECTOR = 11302;
        public static final int OBSV_PROPERTY_VIEW_ACTION_UP = 11103;
        public static final int OBSV_PROPERTY_VIEW_INFLATED = 11200;
        public static final int OBSV_PROPERTY_VIEW_LAYOUT_CHANGED = 11201;
        public static final int OBSV_PROPERTY_VIEW_PRE_ACTION_DOWN = 11102;
        public static final int OBSV_PROPERTY_VIEW_SET_DOCUMENT = 11202;
        public static final int OBSV_PROPERTY_VIEW_SET_ZOOM_INIT = 11101;
        public static final int OBSV_PROPERTY_VIEW_ZOOM_CHANGED = 11100;

        private Companion() {
        }
    }

    void clearAll();

    void clearViews();

    void commitStroke();

    @Nullable
    ICanvasContainer getCanvasContainer();

    @Nullable
    IExtendedColor getCurrentColor();

    @Nullable
    IDocModel<?> getDocModel();

    @Nullable
    Integer getObjectCount();

    @Nullable
    ISettingView<?> getSettingView();

    @Nullable
    IView<?> getView();

    @Nullable
    int[] getViewPositionInWindow();

    boolean isDrawing();

    boolean isEmpty();

    boolean isRedoable();

    boolean isUndoable();

    void lockForSave();

    void redo();

    void redoAll();

    void setCanvasContainer(@Nullable ICanvasContainer layout);

    void setDoc(@Nullable IDocModel<?> doc);

    void setPreTouchListener(@Nullable IPreTouchListener listner);

    void setSettingView(@Nullable ISettingView<?> settingView);

    void setView(@Nullable IView<?> view);

    void undo();

    void undoAll();

    void unlockForSave();
}

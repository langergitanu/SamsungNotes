package com.samsung.android.support.senl.p148nt.composer.main.compare.presenter;

import android.app.Activity;
import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract;", "", "IViewCompare", "IViewerFragment", "IPresenter", "IDialog", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface CompareViewerContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IDialog;", "", "setPresenter", "", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IPresenter;", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDialog {
        void setPresenter(@Nullable IPresenter presenter);

        void showDialog(@NotNull FragmentManager fragmentManager, @NotNull String tag);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0011H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H&J\u0017\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020*H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020'H&J\u0014\u0010.\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&J\b\u0010/\u001a\u00020\u0003H&R*\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IPresenter;", "", "init", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "iViewCompare", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewCompare;", "onClickKeepBoth", "noteInfoArguments", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/composer/main/simple/model/NoteInfoArgument;", "Lkotlin/collections/ArrayList;", "getNoteInfoArguments", "()Ljava/util/ArrayList;", "setDeviceNameForSyncConflict", "deviceName", "", "setTitle", "tag", "view", "Landroid/view/View;", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onClickOK", "setViewerFragment", "iViewerFragment", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewerFragment;", "onScrollChanged", "panY", "", "setAutoScroll", "onNextClick", "onPrevClick", "setMergeNoteToShow", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "onClickEditMerge", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIndexPageOfObject", "", "index", "destroy", "isMainDisplayOfFoldModel", "getDeviceName", "requestFitToScreenPreview", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter {
        void destroy();

        @Nullable
        String getDeviceName(@Nullable String tag);

        int getIndexPageOfObject(@NotNull SpenWNote note, int index);

        @Nullable
        ArrayList<NoteInfoArgument> getNoteInfoArguments();

        void init(@Nullable Activity activity, @Nullable IViewCompare iViewCompare);

        boolean isMainDisplayOfFoldModel();

        @Nullable
        Boolean onClickEditMerge(@NotNull String tag);

        void onClickKeepBoth();

        void onClickOK(@Nullable String tag);

        void onNextClick();

        void onPrevClick();

        void onScrollChanged(float panY, @NotNull String tag);

        void requestFitToScreenPreview();

        void setAutoScroll();

        void setDeviceNameForSyncConflict(@Nullable String deviceName);

        void setMergeNoteToShow(@NotNull SpenWNote note);

        void setTitle(@Nullable String tag, @Nullable View view);

        void setViewerFragment(@Nullable IViewerFragment iViewerFragment, @Nullable String tag);

        void showDialog(@Nullable FragmentManager fragmentManager, @Nullable String tag);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewCompare;", "", "showMenuBar", "", "information", "", "", "([Ljava/lang/Integer;)V", "updatePrevious", "enable", "", "updateNext", "showMergeButton", "setMergeFragment", "setFirstFragment", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IViewCompare {
        void setFirstFragment();

        void setMergeFragment();

        void showMenuBar(@NotNull Integer[] information);

        void showMergeButton();

        void updateNext(boolean enable);

        void updatePrevious(boolean enable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H&J,\u0010\u0015\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017`\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H&J,\u0010\u001b\u001a\u00020\n2\u001a\u0010\u001c\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017`\u00182\u0006\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\nH&J\b\u0010\u001f\u001a\u00020\nH&J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0014H&J\b\u0010\"\u001a\u00020\nH&J$\u0010#\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017`\u00182\u0006\u0010$\u001a\u00020\u0005H&J\n\u0010%\u001a\u0004\u0018\u00010&H&J\u000f\u0010'\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020\nH&¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewerFragment;", "", "getComposerViewContainer", "Landroid/view/View;", "getBottomContainerHeight", "", "getTopContainerHeight", "getHeightBottomContainer", "()Ljava/lang/Integer;", "setScrollView", "", "panY", "", "panX", "setZoomScale", WiggleAnimationConfig.KEY_SCALE, "hideProgress", "getPanY", "setAutoScroll", "enable", "", "getTextRectFromIndex", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "start", "end", "drawHighlight", "rectF", "type", "redraw", "mergeDone", "setViewEditMergeButton", "isDeleteMode", "requestPageLayout", "getRectObjectSpan", "index", "getNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getEditBtnHeight", "requestFitToScreenPreview", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IViewerFragment {
        void drawHighlight(@NotNull ArrayList<RectF> rectF, int type);

        int getBottomContainerHeight();

        @Nullable
        View getComposerViewContainer();

        @Nullable
        Integer getEditBtnHeight();

        @Nullable
        Integer getHeightBottomContainer();

        @Nullable
        SpenWNote getNote();

        float getPanY();

        @NotNull
        ArrayList<RectF> getRectObjectSpan(int index);

        @NotNull
        ArrayList<RectF> getTextRectFromIndex(int start, int end);

        int getTopContainerHeight();

        void hideProgress();

        void mergeDone();

        void redraw();

        void requestFitToScreenPreview();

        void requestPageLayout();

        void setAutoScroll(boolean enable);

        void setScrollView(float panY);

        void setScrollView(float panX, float panY);

        void setViewEditMergeButton(boolean isDeleteMode);

        void setZoomScale(float scale);
    }
}

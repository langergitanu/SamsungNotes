package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.CellStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface RtToolbarContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        int getBackgroundColor();

        SpanStates getLastRtState();

        @Nullable
        IView getView();

        boolean isComposerViewDarkTheme();

        boolean isDirectWriteRecognizing();

        boolean isDirectWriteUsing();

        void updateState(SpanStates spanStates);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView extends HistoryEventListenerImpl.UndoRedoListener {
        void enableMenus(boolean z, List<Integer> list);

        void enableToolbar(boolean z);

        void executeAiAssist();

        void executeTextStyle();

        View getView();

        void hide();

        void hideAll();

        boolean isDirectWriteRecognizing();

        boolean isDirectWriteUsing();

        boolean isShowing();

        void onDetach();

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
        void onObjectChanged();

        void onPaletteListChanged(List<Integer> list);

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
        void onRedoable(boolean z);

        void onSaveInstanceState(@NonNull Bundle bundle);

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.UndoRedoListener
        void onUndoable(boolean z);

        void onUpdateTask(int i);

        /* JADX INFO: renamed from: restore */
        void lambda$restore$4(Bundle bundle);

        void show();

        void showAlignPopup(View view, OnClickValueListener onClickValueListener);

        void showFontColorSetting(View view, OnClickValueListener onClickValueListener);

        void showFontSize(View view, OnClickValueListener onClickValueListener);

        void showTableCellSetting(CellStyle cellStyle);

        void showTableSetting(TableStyle tableStyle);

        void showTextColor(boolean z);

        /* JADX INFO: renamed from: update */
        void lambda$update$3(SpanStates spanStates);

        void updateAiMenu(boolean z);

        void updateBackgroundColor(int i, boolean z, boolean z2);

        void updateEnableUndoRedoMenu(boolean z);

        void updateFontBgColor(int i);

        void updateFontSize();

        void updateTextStyles();

        void updateUndoRedo(boolean z, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickValueListener {
        void apply(int i);
    }
}

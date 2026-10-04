package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormatStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatStreamingResultView extends AbsAiActionResultView {
    private AutoFormatStreaming mAutoFormat;
    private SimpleEditView mSimpleEditView;
    private View mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatStreamingResultView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96681 extends SpenTextManagerActionListener {
        public C96681() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBeforeTextChangedByKeyBoard$0() {
            Context context = AutoFormatStreamingResultView.this.mView.getContext();
            ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
        }

        @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
        public void onBeforeTextChangedByKeyBoard() {
            if (AutoFormatStreamingResultView.this.mSimpleEditView.getTextBoxLength() >= 350000) {
                new Handler(Looper.getMainLooper()).post(new RunnableC9711g(this, 7));
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatStreamingResultView$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96692 implements SpenWNote.ObjectEventListener {
        public C96692() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onObjectChanged$0() {
            Context context = AutoFormatStreamingResultView.this.mView.getContext();
            ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectAdded(@Nullable SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectChanged(@Nullable SpenWPage spenWPage, @NonNull SpenObjectChangedInfo spenObjectChangedInfo, int i) {
            int textBoxLength = AutoFormatStreamingResultView.this.mSimpleEditView.getTextBoxLength();
            if (textBoxLength >= 350000) {
                new Handler(Looper.getMainLooper()).post(new RunnableC9711g(this, 8));
            }
            AutoFormatStreamingResultView.this.mCommonViews.getBottomView().setBottomButtonsState(textBoxLength != 0);
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectRemoved(@Nullable SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }
    }

    public AutoFormatStreamingResultView(AutoFormat autoFormat, AiMenuResultCommonViews aiMenuResultCommonViews) {
        super(aiMenuResultCommonViews);
        if (autoFormat instanceof AutoFormatStreaming) {
            this.mAutoFormat = (AutoFormatStreaming) autoFormat;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView != null) {
            simpleEditView.release();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mAutoFormat;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_result_auto_format_view, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        this.mView = view2;
        if (this.mSimpleEditView == null) {
            this.mSimpleEditView = new SimpleEditView(view2.getContext(), this.mCommonViews.mContract.getPresenter());
        }
        this.mSimpleEditView.attachView((ViewGroup) view2.findViewById(C9086R.id.auto_format_result_edit_view));
        this.mSimpleEditView.setSpenTextManagerActionListener(new C96681());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isBottomMenuSupported() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mSimpleEditView != null;
    }

    public void scrollToPosition(SimpleEditView.SCROLL_POSITION scroll_position) {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView == null) {
            return;
        }
        simpleEditView.scrollToPosition(scroll_position);
    }

    public void setMode(int i) {
        this.mSimpleEditView.setMode(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_auto_format_name, C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    public void updateNote() {
        SpenWNote streamingNote;
        if (this.mSimpleEditView == null || (streamingNote = this.mAutoFormat.getStreamingNote()) == null) {
            return;
        }
        streamingNote.getBodyText().setMargin(0.0f, 16.0f, 0.0f, 0.0f);
        this.mSimpleEditView.initView(streamingNote, false, this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size), new boolean[0]);
        this.mSimpleEditView.setSpenObjectEventListener(new C96692());
    }
}

package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskStartDrag extends SingleThreadTask<InputValues, ResultValues> {
    public static final float BIG_SHADOW_VIEW_WIDTH_RATIO = 0.55f;
    public static final float SMALL_SHADOW_VIEW_WIDTH_RATIO = 0.75f;
    private static final String TAG = Logger.createTag("TaskStartDrag");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Activity mActivity;
        private final ObjectManager mObjectManager;
        private final SpenObjectTextBox mSpenObjectTextBox;
        private final View mView;

        public InputValues(Activity activity, ObjectManager objectManager, View view, SpenObjectTextBox spenObjectTextBox) {
            this.mActivity = activity;
            this.mObjectManager = objectManager;
            this.mView = view;
            this.mSpenObjectTextBox = spenObjectTextBox;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final ClipData mClipData;

        public ResultValues(ClipData clipData) {
            this.mClipData = clipData;
        }

        public ClipData getClipData() {
            return this.mClipData;
        }
    }

    private void setShadowViewLayout(InputValues inputValues, View view) {
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int width = inputValues.mActivity.getWindow().getDecorView().getWidth();
        int iRound = width < inputValues.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.composer_shadow_view_max_width) ? Math.round(width * 0.75f) : Math.round(width * 0.55f);
        int height = inputValues.mActivity.getWindow().getDecorView().getHeight();
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(measuredWidth, measuredHeight, "setShadowViewLayout, shadowView: ", "*", ", decorView : ");
        sbM1173s.append(iRound);
        sbM1173s.append("*");
        sbM1173s.append(height);
        Logger.m10999d(str, sbM1173s.toString());
        if (iRound < measuredWidth) {
            view.setLayoutParams(new ViewGroup.LayoutParams(iRound, -2));
            view.measure(View.MeasureSpec.makeMeasureSpec(iRound, 1073741824), iMakeMeasureSpec);
            measuredHeight = view.getMeasuredHeight();
            measuredWidth = iRound;
        }
        if (height < measuredHeight) {
            view.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth, height));
            view.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        } else {
            height = measuredHeight;
        }
        AbstractC8014b.m7216r(measuredWidth, height, "setShadowViewLayout, result: ", "*", str);
        view.layout(0, 0, measuredWidth, height);
        view.invalidate();
    }

    public void startDragAndDrop(InputValues inputValues, ClipData clipData, String str, DragAndDropInfo dragAndDropInfo) {
        View viewInflate = inputValues.mActivity.getLayoutInflater().inflate(C9086R.layout.drag_n_drop_shadow_view, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(C9086R.id.shadow_view_text);
        textView.setText(str);
        textView.setVisibility(0);
        setShadowViewLayout(inputValues, viewInflate);
        if (viewInflate.getWidth() != 0 && viewInflate.getHeight() != 0) {
            if (dragAndDropInfo != null) {
                dragAndDropInfo.setShadowViewWidth(viewInflate.getWidth());
                dragAndDropInfo.setShadowViewHeight(viewInflate.getHeight());
            }
            inputValues.mView.startDragAndDrop(clipData, new View.DragShadowBuilder(viewInflate), null, 257);
            ViewCompat.getInstance().performHapticFeedback(inputValues.mView, 108);
            return;
        }
        Logger.m11000e(TAG, "startDragAndDrop#shadowView size is wrong : " + viewInflate.getWidth() + "*" + viewInflate.getHeight() + ", ClipData : " + clipData.getItemCount() + ", dropContent : " + str.length());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskStartDrag.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCopy taskCopy = new TaskCopy();
                taskCopy.copyText(inputValues.mActivity, inputValues.mObjectManager, inputValues.mSpenObjectTextBox, 0, inputValues.mSpenObjectTextBox.getText().length());
                Pair<ClipData.Item, String[]> pairMakeClipData = taskCopy.makeClipData();
                TaskStartDrag.this.notifyCallback(true, new ResultValues(new ClipData(new ClipDescription("notes_drag", (String[]) pairMakeClipData.second), (ClipData.Item) pairMakeClipData.first)));
            }
        });
    }
}

package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.RecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewOriginalHw extends AbsAiActionResultView {
    private static final String TAG = Logger.createTag("AiMenuResultViewOriginalHw", AiConstants.PREFIX_TAG);
    List<Integer> mExpectedHeightList;
    View.OnLayoutChangeListener mImageViewOnLayoutChangeListener;
    RecognizedHw mRecognizedHw;
    RecyclerView mRecyclerView;
    List<Bitmap> mThumbnailList;
    View mView;
    Runnable mViewPagerRequestLayoutRunnable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        public /* synthetic */ ItemAdapter(AiMenuResultViewOriginalHw aiMenuResultViewOriginalHw, int i) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Bitmap> list = AiMenuResultViewOriginalHw.this.mThumbnailList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        private ItemAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
            AiMenuResultViewOriginalHw aiMenuResultViewOriginalHw = AiMenuResultViewOriginalHw.this;
            if (aiMenuResultViewOriginalHw.mThumbnailList == null) {
                return;
            }
            if (aiMenuResultViewOriginalHw.mExpectedHeightList.isEmpty()) {
                itemHolder.onBindViewHolder(AiMenuResultViewOriginalHw.this.mThumbnailList.get(i), null);
            } else {
                itemHolder.onBindViewHolder(AiMenuResultViewOriginalHw.this.mThumbnailList.get(i), AiMenuResultViewOriginalHw.this.mExpectedHeightList.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_result_recognized_hw_item, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(@NonNull View view) {
            super(view);
        }

        public void onBindViewHolder(Bitmap bitmap, Integer num) {
            if (num != null) {
                this.itemView.getLayoutParams().height = num.intValue();
            }
            ((ImageView) this.itemView).setImageBitmap(bitmap);
        }
    }

    public AiMenuResultViewOriginalHw(RecognizedHw recognizedHw, AiMenuResultCommonViews aiMenuResultCommonViews) {
        super(aiMenuResultCommonViews);
        this.mThumbnailList = new ArrayList();
        this.mExpectedHeightList = new ArrayList();
        this.mViewPagerRequestLayoutRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewOriginalHw.1
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultViewOriginalHw.this.mRecyclerView.requestLayout();
            }
        };
        this.mRecognizedHw = recognizedHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void resizeHwImage(int i) {
        List<Bitmap> list = this.mThumbnailList;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.mThumbnailList.size(); i2++) {
            Bitmap bitmap = this.mThumbnailList.get(i2);
            float width = i / bitmap.getWidth();
            int height = (int) (bitmap.getHeight() * width);
            String str = TAG;
            StringBuilder sb = new StringBuilder("resizeHwImage# ratio: ");
            sb.append(width);
            sb.append(" w/h: ");
            sb.append(i);
            sb.append("/");
            AbstractC8014b.m7221w(sb, str, height);
            if (height <= 0) {
                return;
            }
            if (this.mExpectedHeightList.size() <= i2) {
                this.mExpectedHeightList.add(Integer.valueOf(height));
            } else {
                this.mExpectedHeightList.set(i2, Integer.valueOf(height));
            }
        }
        if (this.mRecyclerView.getAdapter() != null) {
            this.mRecyclerView.getAdapter().notifyDataSetChanged();
            this.mRecyclerView.post(this.mViewPagerRequestLayoutRunnable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        if (this.mView == null) {
            return;
        }
        this.mRecyclerView.removeOnLayoutChangeListener(this.mImageViewOnLayoutChangeListener);
        this.mRecyclerView.removeCallbacks(this.mViewPagerRequestLayoutRunnable);
        this.mView.setVisibility(8);
        if (this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().removeAllViews();
        }
        List<Bitmap> list = this.mThumbnailList;
        if (list != null) {
            Iterator<Bitmap> it = list.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.mThumbnailList.clear();
            this.mThumbnailList = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_result_recognized_hw_original, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        if (this.mRecognizedHw == null) {
            return;
        }
        this.mView = view2;
        view2.setVisibility(0);
        this.mRecyclerView = (RecyclerView) view2.findViewById(C9086R.id.recycler_view);
        ItemAdapter itemAdapter = new ItemAdapter(this, 0 == true ? 1 : 0);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mView.getContext()));
        this.mRecyclerView.setAdapter(itemAdapter);
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewOriginalHw.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view3, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                int i10 = i5 - i2;
                int i11 = i4 - i;
                if (Math.abs((i8 - i6) - i11) > 100) {
                    AiMenuResultViewOriginalHw.this.resizeHwImage(i11);
                }
                AbstractC8014b.m7216r(i11, i10, "onLayoutChange# ", "/", AiConstants.LAYOUT_DEBUG_TAG);
            }
        };
        this.mImageViewOnLayoutChangeListener = onLayoutChangeListener;
        this.mRecyclerView.addOnLayoutChangeListener(onLayoutChangeListener);
        new Handler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewOriginalHw.3
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultViewOriginalHw aiMenuResultViewOriginalHw = AiMenuResultViewOriginalHw.this;
                aiMenuResultViewOriginalHw.mThumbnailList = aiMenuResultViewOriginalHw.mRecognizedHw.makeSelectedHwThumbnailList();
                AiMenuResultViewOriginalHw aiMenuResultViewOriginalHw2 = AiMenuResultViewOriginalHw.this;
                aiMenuResultViewOriginalHw2.resizeHwImage(aiMenuResultViewOriginalHw2.mRecyclerView.getWidth());
            }
        });
        boolean z = view.getResources().getConfiguration().orientation == 2;
        View viewFindViewById = view.findViewById(C9086R.id.result_layout_content);
        updateLayout(z, viewFindViewById.getMeasuredWidth(), viewFindViewById.getMeasuredHeight());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isBottomMenuSupported() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mView != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            int dimensionPixelSize = this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mView.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            marginLayoutParams.setMarginEnd(dimensionPixelSize);
        }
    }
}

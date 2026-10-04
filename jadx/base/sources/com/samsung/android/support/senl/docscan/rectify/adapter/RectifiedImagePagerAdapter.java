package com.samsung.android.support.senl.docscan.rectify.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/adapter/RectifiedImagePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mContract", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/AdapterContract$ViewPager;", "mScanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "<init>", "(Lcom/samsung/android/support/senl/docscan/rectify/adapter/AdapterContract$ViewPager;Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;)V", "mImageViewMap", "", "", "Landroid/widget/ImageView;", "getCount", "isViewFromObject", "", "view", "Landroid/view/View;", "o", "", "getItemPosition", CoeditServiceConstants.Element.NAME_OBJECT, "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "instantiateItem", "notifyItemUpdated", "scanDataCount", "getScanDataCount", "()I", "notifyItemRemoved", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RectifiedImagePagerAdapter extends PagerAdapter {

    @Nullable
    private final AdapterContract.ViewPager mContract;

    @NotNull
    private final Map<Integer, ImageView> mImageViewMap = new LinkedHashMap();

    @Nullable
    private final ScanDataModel mScanDataModel;

    public RectifiedImagePagerAdapter(@Nullable AdapterContract.ViewPager viewPager, @Nullable ScanDataModel scanDataModel) {
        this.mContract = viewPager;
        this.mScanDataModel = scanDataModel;
    }

    private final int getScanDataCount() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel != null) {
            return scanDataModel.getScanDataCount();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
        this.mImageViewMap.remove(Integer.valueOf(position));
        AdapterContract.ViewPager viewPager = this.mContract;
        if (viewPager != null) {
            viewPager.clearRectifiedImage(position);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return getScanDataCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        Object tag = ((View) object).getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) tag).intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewInflate = LayoutInflater.from(container.getContext()).inflate(C7976R.layout.rectified_image_pager_view, container, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewInflate;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setTag(Integer.valueOf(position));
        container.addView(imageView);
        this.mImageViewMap.put(Integer.valueOf(position), imageView);
        AdapterContract.ViewPager viewPager = this.mContract;
        if (viewPager != null) {
            Bitmap rectifiedImage = viewPager.getRectifiedImage(position);
            if (rectifiedImage != null) {
                imageView.setImageBitmap(rectifiedImage);
                return imageView;
            }
            this.mContract.updateRectifiedImage(position);
        }
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object o) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(o, "o");
        return Intrinsics.areEqual(view, o);
    }

    public final void notifyItemRemoved() {
        Iterator<ImageView> it = this.mImageViewMap.values().iterator();
        while (it.hasNext()) {
            it.next().setTag(-2);
        }
    }

    public final void notifyItemUpdated(int position) {
        ImageView imageView;
        int scanDataCount = getScanDataCount();
        if (position < 0 || scanDataCount <= position || (imageView = this.mImageViewMap.get(Integer.valueOf(position))) == null) {
            return;
        }
        AdapterContract.ViewPager viewPager = this.mContract;
        Intrinsics.checkNotNull(viewPager);
        Bitmap rectifiedImage = viewPager.getRectifiedImage(position);
        if (rectifiedImage != null) {
            imageView.setImageBitmap(rectifiedImage);
        } else {
            this.mContract.updateRectifiedImage(position);
        }
    }
}

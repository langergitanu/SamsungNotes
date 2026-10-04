package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.HoverCompat;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageThumbnailHoverListener implements View.OnHoverListener {
    protected AsyncTask mAsyncTask;
    protected HoverRecyclerViewHolderListener mHolderListener;
    protected View mHoverView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HoverAsyncTask extends AsyncTask<Void, Void, Drawable> {
        private static final String TAG = "PageThumbnailHoverListener$HoverAsyncTask";
        private WeakReference<PageThumbnailHoverListener> mListenerReference;

        public HoverAsyncTask(PageThumbnailHoverListener pageThumbnailHoverListener) {
            this.mListenerReference = new WeakReference<>(pageThumbnailHoverListener);
        }

        private int getAntiGreenisFilteredColor(int i) {
            return (ModelFeature.getFeature().needAntiGreenish() && ContextUtils.isNightMode(BaseUtils.getApplicationContext())) ? (i == C9086R.color.drawer_list_bg_color || i == C9086R.color.settings_list_background_color) ? C9086R.color.notes_anti_greenish_color : i == C9086R.color.noteslist_card_view_bg_color_black ? C9086R.color.notes_anti_greenish_color : i == C9086R.color.noteslist_thumbnail_opacity ? C9086R.color.notes_anti_greenish_thumbnail_opacity : i : i;
        }

        @Override // android.os.AsyncTask
        public Drawable doInBackground(Void... voidArr) {
            PageThumbnailHoverListener pageThumbnailHoverListener;
            WeakReference<PageThumbnailHoverListener> weakReference = this.mListenerReference;
            if (weakReference == null || (pageThumbnailHoverListener = weakReference.get()) == null) {
                return null;
            }
            return pageThumbnailHoverListener.mHolderListener.getImageDrawableImpl();
        }

        @Override // android.os.AsyncTask
        public void onCancelled(Drawable drawable) {
            super.onCancelled(drawable);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Drawable drawable) {
            Bitmap bitmapConvertDrawableToBitmap;
            super.onPostExecute(drawable);
            PageThumbnailHoverListener pageThumbnailHoverListener = this.mListenerReference.get();
            if (pageThumbnailHoverListener == null) {
                return;
            }
            if (drawable == null || drawable.getMinimumWidth() == 0 || !pageThumbnailHoverListener.mHolderListener.getItemView().isAttachedToWindow()) {
                HoverCompat.getInstance().dismiss(pageThumbnailHoverListener.mHoverView);
                return;
            }
            try {
                bitmapConvertDrawableToBitmap = ((BitmapDrawable) drawable).getBitmap();
            } catch (ClassCastException unused) {
                bitmapConvertDrawableToBitmap = ImageUtils.convertDrawableToBitmap(drawable);
            }
            if (bitmapConvertDrawableToBitmap == null) {
                return;
            }
            ImageUtils.resizeBitmapImage(bitmapConvertDrawableToBitmap, drawable.getIntrinsicWidth());
            View viewInflate = View.inflate(pageThumbnailHoverListener.mHoverView.getContext(), C9086R.layout.noteslist_hover_popup, null);
            ImageView imageView = (ImageView) viewInflate.findViewById(C9086R.id.noteslist_hover_image);
            imageView.setImageDrawable(drawable);
            float dimensionPixelSize = pageThumbnailHoverListener.mHoverView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.page_hover_image_thumbnail_max);
            float minimumWidth = drawable.getMinimumWidth();
            float minimumHeight = drawable.getMinimumHeight();
            if (minimumWidth > minimumHeight) {
                imageView.getLayoutParams().width = (int) dimensionPixelSize;
                imageView.getLayoutParams().height = (int) ((dimensionPixelSize * minimumHeight) / minimumWidth);
            } else {
                imageView.getLayoutParams().width = (int) ((minimumWidth * dimensionPixelSize) / minimumHeight);
                imageView.getLayoutParams().height = (int) dimensionPixelSize;
            }
            int iBackgroundColor = pageThumbnailHoverListener.mHolderListener.backgroundColor();
            boolean zIsNightMode = ContextUtils.isNightMode(viewInflate.getContext());
            int color = iBackgroundColor == viewInflate.getResources().getColor(C9086R.color.composer_main_background_dark, null) ? viewInflate.getResources().getColor(getAntiGreenisFilteredColor(C9086R.color.noteslist_card_view_bg_color_black), null) : !ContentUtils.hasBackgroundColorNotes(iBackgroundColor, false) ? viewInflate.getResources().getColor(C9086R.color.background_color_white, null) : iBackgroundColor;
            viewInflate.findViewById(C9086R.id.noteslist_hover_container).setBackgroundColor(color);
            imageView.setBackgroundColor(color);
            if (iBackgroundColor == viewInflate.getResources().getColor(C9086R.color.composer_main_background_dark, null) && zIsNightMode) {
                imageView.setColorFilter(viewInflate.getResources().getColor(getAntiGreenisFilteredColor(C9086R.color.noteslist_thumbnail_opacity), null));
            }
            imageView.requestLayout();
            HoverCompat.getInstance().setThumb(pageThumbnailHoverListener.mHoverView, viewInflate);
            HoverCompat.getInstance().show(pageThumbnailHoverListener.mHoverView, 3);
            this.mListenerReference.clear();
            this.mListenerReference = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HoverRecyclerViewHolderListener {
        int backgroundColor();

        Drawable getImageDrawableImpl();

        View getItemView();
    }

    public PageThumbnailHoverListener(HoverRecyclerViewHolderListener hoverRecyclerViewHolderListener) {
        this.mHolderListener = hoverRecyclerViewHolderListener;
    }

    public void dismissHoverPopup() {
        AsyncTask asyncTask = this.mAsyncTask;
        if (asyncTask != null && (asyncTask.getStatus() == AsyncTask.Status.RUNNING || this.mAsyncTask.getStatus() == AsyncTask.Status.PENDING)) {
            this.mAsyncTask.cancel(true);
            this.mAsyncTask = null;
        }
        if (this.mHoverView != null) {
            HoverCompat.getInstance().dismiss(this.mHoverView);
            this.mHoverView = null;
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (!this.mHolderListener.getItemView().isAttachedToWindow()) {
            return false;
        }
        this.mHoverView = view;
        if (motionEvent.getToolType(0) == 2 && motionEvent.getAction() == 9) {
            AsyncTask asyncTask = this.mAsyncTask;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.mAsyncTask = null;
            }
            this.mAsyncTask = new HoverAsyncTask(this).execute(new Void[0]);
        } else if (motionEvent.getToolType(0) == 2 && motionEvent.getAction() == 10) {
            dismissHoverPopup();
        }
        return false;
    }
}

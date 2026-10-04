package com.samsung.android.support.senl.p148nt.app.common.listener;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.view.HoverCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ThumbnailHoverListener implements View.OnHoverListener {
    private static final String TAG = "ThumbnailHoverListener";
    private static final Executor mExecutor = AbstractC4539a.m3201k(TAG);
    protected AsyncTask mAsyncTask;
    protected final HoverRecyclerViewHolderListener mHolderListener;
    protected View mHoverView;
    private final int mViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HoverAsyncTask extends AsyncTask<Void, Void, Drawable> {
        private static final String TAG = "ThumbnailHoverListener$HoverAsyncTask";
        private WeakReference<ThumbnailHoverListener> mListenerReference;

        public HoverAsyncTask(ThumbnailHoverListener thumbnailHoverListener) {
            this.mListenerReference = new WeakReference<>(thumbnailHoverListener);
        }

        @Override // android.os.AsyncTask
        public Drawable doInBackground(Void... voidArr) {
            ThumbnailHoverListener thumbnailHoverListener;
            WeakReference<ThumbnailHoverListener> weakReference = this.mListenerReference;
            if (weakReference == null || (thumbnailHoverListener = weakReference.get()) == null) {
                return null;
            }
            return thumbnailHoverListener.mHolderListener.getImageDrawableImpl();
        }

        @Override // android.os.AsyncTask
        public void onCancelled(Drawable drawable) {
            super.onCancelled(drawable);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Drawable drawable) {
            Bitmap bitmapConvertDrawableToBitmap;
            super.onPostExecute(drawable);
            ThumbnailHoverListener thumbnailHoverListener = this.mListenerReference.get();
            if (thumbnailHoverListener == null) {
                return;
            }
            if (drawable == null || drawable.getMinimumWidth() == 0 || !thumbnailHoverListener.mHolderListener.get$itemView().isAttachedToWindow()) {
                MainLogger.m7258i(TAG, "onPostExecute# dismiss hover");
                HoverCompat.getInstance().dismiss(thumbnailHoverListener.mHoverView);
                return;
            }
            try {
                bitmapConvertDrawableToBitmap = ((BitmapDrawable) drawable).getBitmap();
            } catch (ClassCastException e) {
                MainLogger.m7255e(TAG, "onPostExecute# ClassCastException : " + e.getMessage());
                bitmapConvertDrawableToBitmap = ImageUtils.convertDrawableToBitmap(drawable);
            }
            if (bitmapConvertDrawableToBitmap == null) {
                MainLogger.m7255e(TAG, "onPostExecute# drawableBitmap is null");
                return;
            }
            ImageUtils.resizeBitmapImage(bitmapConvertDrawableToBitmap, drawable.getIntrinsicWidth());
            View viewInflate = View.inflate(thumbnailHoverListener.mHoverView.getContext(), C8003R.layout.noteslist_hover_popup, null);
            ImageView imageView = (ImageView) viewInflate.findViewById(C8003R.id.noteslist_hover_image);
            imageView.setImageDrawable(drawable);
            int i = thumbnailHoverListener.mViewMode;
            AbstractC8014b.m7201c(i, "onPostExecute# viewMode : ", TAG);
            if (i == 3) {
                imageView.getLayoutParams().width = dimensionPixelSize;
                imageView.getLayoutParams().height = dimensionPixelSize;
            } else {
                float dimensionPixelSize = thumbnailHoverListener.mHoverView.getContext().getResources().getDimensionPixelSize(C8003R.dimen.noteslist_hover_image_thumbnail_max);
                float minimumWidth = drawable.getMinimumWidth();
                float minimumHeight = drawable.getMinimumHeight();
                if (minimumWidth > minimumHeight) {
                    imageView.getLayoutParams().width = (int) dimensionPixelSize;
                    imageView.getLayoutParams().height = (int) ((dimensionPixelSize * minimumHeight) / minimumWidth);
                } else {
                    imageView.getLayoutParams().width = (int) ((minimumWidth * dimensionPixelSize) / minimumHeight);
                    imageView.getLayoutParams().height = (int) dimensionPixelSize;
                }
            }
            int iBackgroundColor = thumbnailHoverListener.mHolderListener.backgroundColor();
            boolean zIsNightMode = ContextUtils.isNightMode(viewInflate.getContext());
            boolean zIsSdoc = thumbnailHoverListener.mHolderListener.isSdoc();
            boolean zHasBackgroundColor = ThumbnailHoverListener.hasBackgroundColor(iBackgroundColor, zIsSdoc);
            boolean zIsSupportInvertedBGColor = thumbnailHoverListener.mHolderListener.isSupportInvertedBGColor();
            int color = (zIsSupportInvertedBGColor || zIsSdoc) ? viewInflate.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.basic_list_item_bg_color), null) : iBackgroundColor == viewInflate.getResources().getColor(C8003R.color.composer_main_background_dark, null) ? viewInflate.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_card_view_bg_color_black), null) : !zHasBackgroundColor ? ResourcesUtils.getDefaultBackgroundColor(viewInflate.getResources()) : iBackgroundColor;
            viewInflate.findViewById(C8003R.id.noteslist_hover_container).setBackgroundColor(color);
            imageView.setBackgroundColor(color);
            if (zIsSdoc) {
                if (thumbnailHoverListener.mHolderListener.hasOnlyHandwritingSdoc() && iBackgroundColor == 0 && zIsNightMode) {
                    imageView.setColorFilter(-1);
                }
            } else if (iBackgroundColor == viewInflate.getResources().getColor(C8003R.color.composer_main_background_dark, null) || (zIsSupportInvertedBGColor && zIsNightMode)) {
                imageView.setColorFilter(viewInflate.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_thumbnail_opacity), null));
            }
            imageView.requestLayout();
            HoverCompat.getInstance().setThumb(thumbnailHoverListener.mHoverView, viewInflate);
            HoverCompat.getInstance().show(thumbnailHoverListener.mHoverView, 3);
            this.mListenerReference.clear();
            this.mListenerReference = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface HoverRecyclerViewHolderListener {
        int backgroundColor();

        Drawable getImageDrawableImpl();

        /* JADX INFO: renamed from: getItemView */
        View get$itemView();

        boolean hasOnlyHandwritingSdoc();

        boolean isSdoc();

        boolean isSupportInvertedBGColor();
    }

    public ThumbnailHoverListener(HoverRecyclerViewHolderListener hoverRecyclerViewHolderListener, int i) {
        this.mHolderListener = hoverRecyclerViewHolderListener;
        this.mViewMode = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasBackgroundColor(int i, boolean z) {
        return ContentUtils.hasBackgroundColorNotes(i, z);
    }

    public void dismissHoverPopup() {
        MainLogger.m7258i(TAG, "dismissHoverPopup");
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
        if (!this.mHolderListener.get$itemView().isAttachedToWindow()) {
            return false;
        }
        int toolType = motionEvent.getToolType(0);
        int action = motionEvent.getAction();
        if (Settings.System.getInt(view.getContext().getContentResolver(), "pen_hovering", 0) != 1 && toolType != 3) {
            return false;
        }
        this.mHoverView = view;
        if (toolType == 2 && action == 9) {
            AsyncTask asyncTask = this.mAsyncTask;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                this.mAsyncTask = null;
            }
            this.mAsyncTask = new HoverAsyncTask(this).executeOnExecutor(mExecutor, new Void[0]);
        } else if (action == 10) {
            dismissHoverPopup();
        }
        return false;
    }
}

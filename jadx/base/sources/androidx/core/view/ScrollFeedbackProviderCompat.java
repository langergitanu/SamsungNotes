package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class ScrollFeedbackProviderCompat {
    private final ScrollFeedbackProviderImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static class ScrollFeedbackProviderApi35Impl implements ScrollFeedbackProviderImpl {
        private final ScrollFeedbackProvider mProvider;

        public ScrollFeedbackProviderApi35Impl(View view) {
            this.mProvider = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i2, int i4, boolean z) {
            this.mProvider.onScrollLimit(i, i2, i4, z);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i2, int i4, int i5) {
            this.mProvider.onScrollProgress(i, i2, i4, i5);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onSnapToItem(int i, int i2, int i4) {
            this.mProvider.onSnapToItem(i, i2, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ScrollFeedbackProviderImpl {
        void onScrollLimit(int i, int i2, int i4, boolean z);

        void onScrollProgress(int i, int i2, int i4, int i5);

        void onSnapToItem(int i, int i2, int i4);
    }

    private ScrollFeedbackProviderCompat(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new ScrollFeedbackProviderApi35Impl(view);
        } else {
            this.mImpl = new ScrollFeedbackProviderBaseImpl();
        }
    }

    public static ScrollFeedbackProviderCompat createProvider(View view) {
        return new ScrollFeedbackProviderCompat(view);
    }

    public void onScrollLimit(int i, int i2, int i4, boolean z) {
        this.mImpl.onScrollLimit(i, i2, i4, z);
    }

    public void onScrollProgress(int i, int i2, int i4, int i5) {
        this.mImpl.onScrollProgress(i, i2, i4, i5);
    }

    public void onSnapToItem(int i, int i2, int i4) {
        this.mImpl.onSnapToItem(i, i2, i4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ScrollFeedbackProviderBaseImpl implements ScrollFeedbackProviderImpl {
        private ScrollFeedbackProviderBaseImpl() {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onSnapToItem(int i, int i2, int i4) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i2, int i4, boolean z) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i2, int i4, int i5) {
        }
    }
}

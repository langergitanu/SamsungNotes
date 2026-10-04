package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> realFactory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class BitmapGlideAnimation implements Transition<R> {
        private final Transition<Drawable> transition;

        public BitmapGlideAnimation(Transition<Drawable> transition) {
            this.transition = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
            return this.transition.transition(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(r)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.realFactory = transitionFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        return new BitmapGlideAnimation(this.realFactory.build(dataSource, z));
    }

    public abstract Bitmap getBitmap(R r);
}

package com.bumptech.glide.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GlideSuppliers {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> GlideSupplier<T> memorize(final GlideSupplier<T> glideSupplier) {
        return new GlideSupplier<T>() { // from class: com.bumptech.glide.util.GlideSuppliers.1
            private volatile T instance;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public T get() {
                if (this.instance == null) {
                    synchronized (this) {
                        try {
                            if (this.instance == null) {
                                this.instance = (T) Preconditions.checkNotNull(glideSupplier.get());
                            }
                        } finally {
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}

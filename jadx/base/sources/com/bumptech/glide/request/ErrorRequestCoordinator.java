package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request error;

    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState errorState;

    @Nullable
    private final RequestCoordinator parent;
    private volatile Request primary;

    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean isValidRequestForStatusChanged(Request request) {
        RequestCoordinator.RequestState requestState = this.primaryState;
        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.FAILED;
        if (requestState != requestState2) {
            return request.equals(this.primary);
        }
        if (!request.equals(this.error)) {
            return false;
        }
        RequestCoordinator.RequestState requestState3 = this.errorState;
        return requestState3 == RequestCoordinator.RequestState.SUCCESS || requestState3 == requestState2;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.primaryState = requestState2;
                    this.primary.begin();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = parentCanNotifyCleared() && request.equals(this.primary);
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = parentCanNotifyStatusChanged() && isValidRequestForStatusChanged(request);
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request request) {
        boolean zParentCanSetImage;
        synchronized (this.requestLock) {
            zParentCanSetImage = parentCanSetImage();
        }
        return zParentCanSetImage;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.primaryState = requestState;
                this.primary.clear();
                if (this.errorState != requestState) {
                    this.errorState = requestState;
                    this.error.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator requestCoordinator = this.parent;
                root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                z = this.primary.isAnyResourceSet() || this.error.isAnyResourceSet();
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z = requestState == requestState2 && this.errorState == requestState2;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                z = requestState == requestState2 || this.errorState == requestState2;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        if (request instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
            if (this.primary.isEquivalentTo(errorRequestCoordinator.primary) && this.error.isEquivalentTo(errorRequestCoordinator.error)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                z = requestState == requestState2 || this.errorState == requestState2;
            } finally {
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request request) {
        synchronized (this.requestLock) {
            try {
                if (request.equals(this.error)) {
                    this.errorState = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator requestCoordinator = this.parent;
                    if (requestCoordinator != null) {
                        requestCoordinator.onRequestFailed(this);
                    }
                    return;
                }
                this.primaryState = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.errorState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.errorState = requestState2;
                    this.error.begin();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request request) {
        synchronized (this.requestLock) {
            try {
                if (request.equals(this.primary)) {
                    this.primaryState = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.error)) {
                    this.errorState = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.parent;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestSuccess(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            try {
                RequestCoordinator.RequestState requestState = this.primaryState;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.primaryState = RequestCoordinator.RequestState.PAUSED;
                    this.primary.pause();
                }
                if (this.errorState == requestState2) {
                    this.errorState = RequestCoordinator.RequestState.PAUSED;
                    this.error.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.primary = request;
        this.error = request2;
    }
}

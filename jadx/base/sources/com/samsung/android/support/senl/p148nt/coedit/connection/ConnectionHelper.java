package com.samsung.android.support.senl.p148nt.coedit.connection;

import com.samsung.android.support.senl.p148nt.coedit.connection.contract.Connection;
import com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectionHelper implements ConnectionState, Connection {
    private State mState = State.UNDEFINED;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.connection.ConnectionHelper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C90131 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$coedit$connection$ConnectionHelper$State */
        static final /* synthetic */ int[] f6608xd6b33ad2;

        static {
            int[] iArr = new int[State.values().length];
            f6608xd6b33ad2 = iArr;
            try {
                iArr[State.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6608xd6b33ad2[State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6608xd6b33ad2[State.OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6608xd6b33ad2[State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6608xd6b33ad2[State.STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        UNDEFINED,
        STARTED,
        OPENED,
        CLOSED,
        STOPPED
    }

    private synchronized void setState(State state) {
        this.mState = state;
    }

    public synchronized State getState() {
        return this.mState;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public boolean isAlreadyClosed() {
        return getState() == State.CLOSED || getState() == State.STOPPED;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public boolean isAlreadyStopped() {
        return getState() == State.STOPPED;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public boolean isNotOpenedState() {
        return getState() != State.OPENED;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public boolean isStartedState() {
        return getState() == State.STARTED;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public boolean isUndefinedState() {
        return getState() == State.UNDEFINED;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public String printState() {
        int i = C90131.f6608xd6b33ad2[this.mState.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "not defined" : "STOPPED" : "CLOSED" : "OPENED" : "STARTED" : "UNDEFINED";
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public void setClosedState() {
        setState(State.CLOSED);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public void setOpenedState() {
        setState(State.OPENED);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public void setStartedState() {
        setState(State.STARTED);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.connection.contract.ConnectionState
    public void setStoppedState() {
        setState(State.STOPPED);
    }
}

package cz.msebera.android.httpclient.impl.bootstrap;

import cz.msebera.android.httpclient.ExceptionLogger;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.protocol.HttpService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class RequestListener implements Runnable {
    private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final ExecutorService executorService;
    private final HttpService httpService;
    private final ServerSocket serversocket;
    private final SocketConfig socketConfig;
    private final AtomicBoolean terminated = new AtomicBoolean(false);

    public RequestListener(SocketConfig socketConfig, ServerSocket serverSocket, HttpService httpService, HttpConnectionFactory<? extends HttpServerConnection> httpConnectionFactory, ExceptionLogger exceptionLogger, ExecutorService executorService) {
        this.socketConfig = socketConfig;
        this.serversocket = serverSocket;
        this.connectionFactory = httpConnectionFactory;
        this.httpService = httpService;
        this.exceptionLogger = exceptionLogger;
        this.executorService = executorService;
    }

    public boolean isTerminated() {
        return this.terminated.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!isTerminated() && !Thread.interrupted()) {
            try {
                Socket socketAccept = this.serversocket.accept();
                socketAccept.setSoTimeout(this.socketConfig.getSoTimeout());
                socketAccept.setKeepAlive(this.socketConfig.isSoKeepAlive());
                socketAccept.setTcpNoDelay(this.socketConfig.isTcpNoDelay());
                if (this.socketConfig.getRcvBufSize() > 0) {
                    socketAccept.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
                }
                if (this.socketConfig.getSndBufSize() > 0) {
                    socketAccept.setSendBufferSize(this.socketConfig.getSndBufSize());
                }
                if (this.socketConfig.getSoLinger() >= 0) {
                    socketAccept.setSoLinger(true, this.socketConfig.getSoLinger());
                }
                this.executorService.execute(new Worker(this.httpService, (HttpServerConnection) this.connectionFactory.createConnection(socketAccept), this.exceptionLogger));
            } catch (Exception e) {
                this.exceptionLogger.log(e);
                return;
            }
        }
    }

    public void terminate() throws IOException {
        if (this.terminated.compareAndSet(false, true)) {
            this.serversocket.close();
        }
    }
}

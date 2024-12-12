package dtm.servers.http.core;

import dtm.servers.http.security.ServerConfiguration;

public interface HttpServer {
    void setPort(int port);
    void setHost(String host);
    void enablePrintTrace();
    void setConfiguration(ServerConfiguration configuration);
    void setRouteExecutor(RouteExecutor routeExecutor);
    void start();
}

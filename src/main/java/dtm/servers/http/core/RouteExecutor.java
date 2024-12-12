package dtm.servers.http.core;

@FunctionalInterface
public interface RouteExecutor {
    void execute(HttpConnection connection);
}

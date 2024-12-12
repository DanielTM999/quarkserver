package dtm.servers.http.core;

public interface HttpConnection {
    HttpServerRequest getRequest();
    HttpServerResponse getResponse();
}

package dtm.servers.http.core;

import java.util.Map;

public interface HttpServerRequest {
    String getHttpMethod();
    String getRoute();
    String getProtocol();
    Map<String, String> getHeaders();
    String getHeader(String key);
    String getBody();
    HttpSession getSession();
}

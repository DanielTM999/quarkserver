package dtm.servers.http.io;

import dtm.servers.http.core.HttpConnection;
import dtm.servers.http.core.HttpServerRequest;
import dtm.servers.http.core.HttpServerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class HttpConnectionImple implements HttpConnection{
    private HttpServerRequest request;
    private HttpServerResponse response;
}

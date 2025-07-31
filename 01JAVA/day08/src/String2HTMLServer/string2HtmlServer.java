package String2HTMLServer;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class string2HtmlServer {

    public static void main(String[] args) throws IOException {
        // 8080 포트로 서버를 생성
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // "/" 경로로 들어오는 요청을 처리할 핸들러(MyHandler)를 등록
        server.createContext("/", new MyHandler());

        // 서버 실행 (기본 Executor 사용)
        server.setExecutor(null);
        server.start();

        System.out.println("Server is listening on port 8080");
    }

    // HTTP 요청을 실제로 처리하는 클래스
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // 1. 요청에서 쿼리 스트링(URL 뒤에 붙는 ?text=...) 가져오기
            URI uri = exchange.getRequestURI();
            String query = uri.getQuery();
            String inputText = "메시지를 입력해주세요"; // 기본 메시지

            if (query != null && query.startsWith("text=")) {
                // "text=" 부분을 제외하고 실제 값을 가져옴
                // 한글이나 특수문자가 깨지지 않도록 URL 디코딩 처리
                inputText = URLDecoder.decode(query.substring(5), StandardCharsets.UTF_8);
            }

            // 2. 입력받은 문자열을 HTML로 포맷팅
            String response = "<h1>" + inputText + "</h1>";

            // 3. 브라우저에 HTTP 응답 보내기
            // 응답 헤더 설정 (상태코드 200 OK, 응답 본문 길이)
            exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
            
            // 응답 본문(Body) 작성
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        }
    }
}
package com.example.vocabularybook.chapter_extended1.handler;

import com.example.vocabularybook.chapter_extended1.handler.api.BookApiHandler;
import com.example.vocabularybook.chapter_extended1.thrift.BookApi;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BookApiServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ContentTypeの設定<1>
        resp.setContentType("application/x-thrift");
        BookApiHandler handler = new BookApiHandler(this.getServletContext());
        // ここで実際に処理を受け取るクラスを作成します<2>
        BookApi.Processor<BookApiHandler> processor = new BookApi.Processor<>(handler);

        // リクエストとレスポンスから、それぞれIN/OUTを取得します<3>
        try (InputStream is = req.getInputStream();
             OutputStream os = resp.getOutputStream();
             TIOStreamTransport transport = new TIOStreamTransport(is, os)) {

            TBinaryProtocol protocol = new TBinaryProtocol(transport, true, true);

            // 通信を開始します<4>
            transport.open();
            processor.process(protocol, protocol);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

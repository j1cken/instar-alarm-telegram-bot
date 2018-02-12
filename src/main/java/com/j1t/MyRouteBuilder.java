package com.j1t;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.telegram.TelegramMediaType;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        String user = System.getenv("FTP_USER");
        String pwd = System.getenv("FTP_PWD");
        String port = System.getenv("FTP_PORT");
        String service = System.getenv("FTP_SERVICE_NAME");
        String passive = System.getenv("FTP_PASSIVE_MODE");
        String chatId = System.getenv("TELEGRAM_CHAT_ID");
        String authToken = System.getenv("TELEGRAM_AUTH_TOKEN");

        from("ftp://" + user + ":" + pwd + "@" + service + ":" + port + "/?binary=true&passiveMode=" + passive)
                .setHeader("CamelTelegramChatId", constant(chatId))
                .setHeader("CamelTelegramMediaType", constant(TelegramMediaType.PHOTO_JPG))
                .to("telegram:bots/" + authToken);

    }

}

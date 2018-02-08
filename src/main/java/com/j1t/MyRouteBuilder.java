package com.j1t;

import org.apache.camel.builder.RouteBuilder;

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
        String service = System.getenv("FTP_SERVIC_NAME");
        String passive = System.getenv("FTP_PASSIVE_MODE");
        String chatId = System.getenv("TELEGRAM_CHAT_ID");
        String authToken = System.getenv("TELEGRAM_AUTH_TOKEN");

        from("ftp://" + user + ":" + pwd + "@" + service + ":" + port + "/?passiveMode=" + passive)
                .setHeader("CamelTelegramChatId", constant(chatId)).to("telegram:bots/" + authToken);

    }

}

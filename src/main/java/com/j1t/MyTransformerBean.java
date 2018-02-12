package com.j1t;

import org.apache.camel.Exchange;
import org.apache.camel.component.telegram.model.OutgoingPhotoMessage;

public class MyTransformerBean {

    public void transform(Exchange exchange) {
        OutgoingPhotoMessage msg = new OutgoingPhotoMessage();
        msg.setPhoto(exchange.getIn().getBody(byte[].class));
        exchange.getIn().setBody(msg);
    }
}
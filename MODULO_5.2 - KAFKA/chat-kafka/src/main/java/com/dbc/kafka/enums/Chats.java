package com.dbc.kafka.enums;

public enum Chats {

    CHAT_GERAL("chat-geral"),
    CHAT_LUIZ("chat-luiz"),
    CHAT_PABLO("chat-pablo"),
    CHAT_ANA("chat-ana"),
    CHAT_GUSTAVO("chat-gustavo"),
    CHAT_NICOLAS("chat-nicolas"),
    CHAT_MAICON("chat-maicon"),
    CHAT_GUILHERME("chat-guilherme"),
    CHAT_FLAVIO("chat-flavio"),
    CHAT_GABRIEL("chat-gabriel"),
    CHAT_JOAO("chat-joao"),
    CHAT_LUCAS("chat-lucas"),
    CHAT_EZEQUIAS("chat-ezequias");

    private final String chatName;

    Chats(String chatName) {
        this.chatName = chatName;
    }

    public String getChat(){
        return chatName;
    }
}

package com.rettichlp.UnicacityAddon.base.text;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/text/Message.java">UCUtils by paulzhng</a>
 */
public class Message {

    private final List<MessagePart> messageParts;

    private Message(Builder builder) {
        this.messageParts = builder.messageParts;
    }

    public List<MessagePart> getMessageParts() {
        return messageParts;
    }
    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final List<MessagePart> messageParts = new ArrayList<>();

        public MessagePart.Builder of(String message) {
            return MessagePart.getBuilder().message(message).messageBuilder(this);
        }

        public Builder prefix() {
            return add(Message.getBuilder()
                    .of("[").color(ColorCode.DARK_GRAY).advance()
                    .of("Gemüsekiste").color(ColorCode.DARK_GREEN).advance()
                    .of("]").color(ColorCode.DARK_GRAY).advance()
                    .create());
        }

        public Builder info() {
            return add(Message.getBuilder()
                    .of("  Info:").color(ColorCode.AQUA).advance()
                    .create());
        }

        public Builder error() {
            return add(Message.getBuilder()
                    .of("[").color(ColorCode.DARK_GRAY).advance()
                    .of("Fehler").color(ColorCode.RED).advance()
                    .of("]").color(ColorCode.DARK_GRAY).advance()
                    .create());
        }

        public Builder add(String text) {
            return MessagePart.getBuilder().messageBuilder(this).message(text).advance();
        }

        public Builder space() {
            return add(" ");
        }

        public Builder newline() {
            return add("\n");
        }

        public Builder messageParts(MessagePart... messageParts) {
            Collections.addAll(this.messageParts, messageParts);
            return this;
        }

        public Message build() {
            return new Message(this);
        }

        public String create() {
            Message message = build();
            StringBuilder stringBuilder = new StringBuilder();

            message.getMessageParts().forEach(part -> {
                StringBuilder partStringBuilder = new StringBuilder();
                partStringBuilder.append(FormattingCode.RESET.getCode());
                if (part.getColorCode() != null) partStringBuilder.append(part.getColorCode().getCode());
                if (!part.getFormattingCodes().isEmpty()) part.getFormattingCodes().forEach(formattingCode -> partStringBuilder.append(formattingCode.getCode()));
                partStringBuilder.append(part.getMessage());
                stringBuilder.append(partStringBuilder);
            });

            return stringBuilder.toString();
        }

        public void sendTo(ClientPlayerEntity player) {
            player.sendMessage(new StringTextComponent(create()), player.getUniqueID());
        }
    }
}
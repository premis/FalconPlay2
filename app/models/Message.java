package models;

import java.io.Serializable;
import java.util.*;

/**
 * @author premis
 *
 * Message bean for holding a message. It acts more like a DTO.
 *
 */
public final class Message implements Serializable {

    private String key;

    private String value;

    public Message(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (key != null ? !key.equals(message.key) : message.key != null) return false;
        if (value != null ? !value.equals(message.value) : message.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


}

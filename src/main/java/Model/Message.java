package Model;

// Base message object
public class Message {

    // Message member variables
    public int message_id;
    public int posted_by;
    public String message_text;
    public long time_posted_epoch;

    // Default Constructor
    public Message() {}

    // Copy Constructor
    public Message(int posted_by, String message_text, long time_posted_epoch) {
        this.posted_by = posted_by;
        this.message_text = message_text;
        this.time_posted_epoch = time_posted_epoch;
    }

    // Copy Constructor with message_id
    public Message(int message_id, int posted_by, String message_text, long time_posted_epoch) {
        this.message_id = message_id;
        this.posted_by = posted_by;
        this.message_text = message_text;
        this.time_posted_epoch = time_posted_epoch;
    }

    // message_id getter
    public int getMessage_id() {
        return message_id;
    }

    // message_id setter
    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    // posted_by getter
    public int getPosted_by() {
        return posted_by;
    }

    // posted_by setter
    public void setPosted_by(int posted_by) {
        this.posted_by = posted_by;
    }

    // message_text getter
    public String getMessage_text() {
        return message_text;
    }

    // message_text setter
    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    // time_posted_epoch getter
    public long getTime_posted_epoch() {
        return time_posted_epoch;
    }

    // time_posted_epoch setter
    public void setTime_posted_epoch(long time_posted_epoch) {
        this.time_posted_epoch = time_posted_epoch;
    }

    // override method for equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return message_id == message.message_id && posted_by == message.posted_by
                && time_posted_epoch == message.time_posted_epoch && message_text.equals(message.message_text);
    }

    // override method for toString
    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", posted_by=" + posted_by +
                ", message_text='" + message_text + '\'' +
                ", time_posted_epoch=" + time_posted_epoch +
                '}';
    }
}

package lesson3.store;

import java.time.LocalDateTime;

public class Record implements IRecord {

    private LocalDateTime createdDateTime;
    private long id;

    /**
     * @param createdDateTime
     * @param id
     */
    public Record(LocalDateTime createdDateTime, long id) {
        this.createdDateTime = createdDateTime;
        this.id = id;
    }

    @Override
    public LocalDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setCreatedDateTime(LocalDateTime dateTime) {
        this.createdDateTime = dateTime;

    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

}

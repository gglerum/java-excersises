package lesson3.store;

import java.time.LocalDateTime;

public interface IRecord {

    /**
     * @param id
     */
    void setId(long id);

    /**
     * @return id
     */
    long getId();

    /**
     * @param dateTime
     */
    public void setCreatedDateTime(LocalDateTime dateTime);

    /**
     * @return dateTime
     */
    public LocalDateTime getCreatedDateTime();

}
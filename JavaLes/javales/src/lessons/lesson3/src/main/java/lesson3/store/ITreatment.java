package lesson3.store;

public interface ITreatment extends IRecord {

    /**
     * @param name of medication
     */
    public void setName(String name);

    /**
     * @return name of medication
     */
    public String getName();

    /**
     * @param description of medication
     */
    public void setDescription(String description);

    /**
     * @return description of medication
     */
    public String getDescription();

    /**
     * @param type of treatment
     */
    public void setType(TreatmentType type);

    /**
     * @return type of treatment
     */
    public TreatmentType getType();

}

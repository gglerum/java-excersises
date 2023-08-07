package lesson3.store;

public interface IPet extends IRegistration, IRecord {

    /**
     * @param owner of pet
     */
    public void setOwner(IOwner owner);

    /**
     * @return owner of pet
     */
    public IOwner getOwner();

    /**
     * get Name
     */
    public String getName();

    /**
     * set Name
     */
    public void setName(String name);

    /**
     * get species
     */
    public Species getSpecies();

    /**
     * setSpecies
     */
    public void setSpecies(Species species);

    /**
     * @param sex
     */
    public void setSex(Sex sex);

    /**
     * @return
     */
    public Sex getSex();

}

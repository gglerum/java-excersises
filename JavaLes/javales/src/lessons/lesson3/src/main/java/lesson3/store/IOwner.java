package lesson3.store;

import java.util.List;

public interface IOwner extends IRegistration, IRecord, IPerson {

    /**
     * Get pets
     */
    public List<IPet> getPets();

    /**
     * set pets
     */
    public void setPets(List<IPet> pets);

}

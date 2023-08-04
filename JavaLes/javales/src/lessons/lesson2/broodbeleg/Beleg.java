package javales.src.lessons.lesson2.broodbeleg;

public class Beleg {

    private String name;

    private String category;

    private String shelf;

    /**
     * @param name
     * @param category
     * @param shelf
     */
    public Beleg(String name, String category, String shelf) {
        this.setName(name);
        this.setCategory(category);
        this.setShelf(shelf);
    }

    /**
     * @param name
     * @param category
     */
    public Beleg(String name, String category) {
        this.setName(name);
        this.setCategory(category);
    }

    public Beleg() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the sku
     */
    public String getShelf() {
        return shelf;
    }

    /**
     * @param sku the sku to set
     */
    public void setShelf(String sku) {
        this.shelf = sku;
    }

    public String toInventoryString() {
        return String.format("%-10s\t%-10s\t%s", this.getName(), this.getCategory(), this.getShelf());
    }

}

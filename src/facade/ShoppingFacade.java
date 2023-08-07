package facade;

public class ShoppingFacade {
    private Store clothesStore;
    private Store snacksStore;
    private Store souvenirsStore;

    public ShoppingFacade() {
        clothesStore = new ClothesStore();
        snacksStore = new SnacksStore();
        souvenirsStore = new SouvenirsStore();
    }

    public void buyClothes() {
        clothesStore.buy();
    }

    public void buySnacks() {
        snacksStore.buy();
    }

    public void buySouvenirs() {
        souvenirsStore.buy();
    }
}

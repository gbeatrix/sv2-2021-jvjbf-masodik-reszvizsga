package city;

public class Home extends Building {
    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, levels, address);
        if (levels > 3) {
            throw new IllegalArgumentException("Error: " + levels + " > 3");
        }
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getArea() / SQUARE_METERS_NEED_PER_PERSON) * getLevels();
    }
}

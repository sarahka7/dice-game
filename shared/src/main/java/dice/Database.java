package dice;


public abstract class Database {
    public static Database create(String type) {
        if (type.equals("mock")) {
            return new MockDatabase();
        }
        else {
            return new ConcreteDatabase();
        }
    }

    public abstract RollRecord[] getAllRecords();
}

class MockDatabase extends Database {
    public RollRecord[] getAllRecords() {

        RollRecord recordA = new RollRecord("TAP", 0, 3, 13, 1, 13);
        RollRecord recordB = new RollRecord("TAP", 0, 1, 3, 2, 16);
        RollRecord recordC = new RollRecord("TAP", 0, 1, 6, 3, 22);
        RollRecord recordD = new RollRecord("CHS", 0, 3, 18, 1, 28);

        RollRecord[] array = {recordA, recordB, recordC, recordD};

        return array;
    }
}

class ConcreteDatabase extends Database {
    public RollRecord[] getAllRecords() {
        return new RollRecord[1];
    }
}

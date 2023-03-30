package JavaOrgExample.Six;

public enum Gender implements Flyable{
    MALE("MUŠKI ROD"){
        @Override
        public void fly() {
            System.out.println("JA sam muški rod i letim dok mi ne skrate krila..");
        }
    },
    FEMALE("ŽENSKI ROD"){
        @Override
        public void fly() {
            System.out.println("Ja sam ženskog i ljepšeg roda spol...");
        }
    },

    UNKNOWN("ROD"){
        @Override
        public void fly() {
            System.out.println("Ne znam šta sam...");
        }
    };

    private String name;

    private Gender(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

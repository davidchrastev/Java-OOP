package InterfacesAndAbstractionLab.sayHelloExtendet;

public abstract class BasePerson implements Person{
    
    String name;

    protected BasePerson(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    public abstract String sayHello();

    
    
}

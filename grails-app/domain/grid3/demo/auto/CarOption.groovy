package grid3.demo.auto

class CarOption {
    Brand brand
    CarModel model
    String optionId

    static constraints = {
        optionId unique: ['model'], blank: false
    }
}

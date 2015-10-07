package grid3.demo.auto

class CarOption {
    CarModel model
    String optionId

    static constraints = {
        optionId unique: ['model'], blank: false
    }
}

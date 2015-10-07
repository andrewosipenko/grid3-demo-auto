package grid3.demo.auto

class CarPackage {
    CarModel model
    String packageId

    static constraints = {
        packageId unique: ['model'], blank: false
    }

}

package grid3.demo.auto

class CarPackage {
    Brand brand
    CarModel model
    String packageId

    static constraints = {
        packageId unique: ['model'], blank: false
    }

}

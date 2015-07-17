package grid3.demo.auto

/**
 * Created by osa on 7/11/2015.
 */
class CarPackagePrice {
    Car car
    CarPackage carPackage

    BigDecimal price

    static constraints = {
        carPackage unique: ['car']
    }
}

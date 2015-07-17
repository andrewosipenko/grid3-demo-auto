package grid3.demo.auto

/**
 * Created by osa on 7/11/2015.
 */
class CarOptionPrice {
    Car car
    CarOption carOption

    BigDecimal price

    static constraints = {
        carOption unique: ['car']
    }
}

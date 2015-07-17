package grid3.demo.auto

/**
 * Created by osa on 7/11/2015.
 */
class CarModel {
    Brand brand
    String modelId

    static constraints = {
        modelId unique: ['brand'], blank: false
    }

    String toString(){
        modelId
    }
}

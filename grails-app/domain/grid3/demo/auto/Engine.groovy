package grid3.demo.auto

/**
 * Created by osa on 7/11/2015.
 */
class Engine {
    Brand brand
    String engineId

    static constraints = {
        engineId unique: ['brand'], blank: false
    }

    String toString(){
        engineId
    }
}

package grid3.demo.auto

/**
 * Created by osa on 7/11/2015.
 */
class Transmission {
    Brand brand
    String transmissionId

    static constraints = {
        transmissionId unique: ['brand'], blank: false
    }

    String toString(){
        transmissionId
    }
}

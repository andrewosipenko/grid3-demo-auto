package grid3.demo.auto

class Brand {
    String brandId

    String name

    static constraints = {
        brandId unique: true, blank: false
        name nullable: true, blank: false
    }

    String toString(){
        brandId
    }
}
